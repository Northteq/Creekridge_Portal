package com.tamarack.liferay.payment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
import com.tamarack.creekridge.service.ProductLocalServiceUtil;
import com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil;
import com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;
import com.tamarack.creekridge.service.TermLocalServiceUtil;

/**
 * Portlet implementation class PaymentCalculatorTable
 */
public class ViewOrCreateApplication extends MVCPortlet {
       
    /**
     * @see MVCPortlet#MVCPortlet()
     */
    public ViewOrCreateApplication() {
        super();
    }
    private static Log _log = LogFactory.getLog(PaymentCalculatorTable.class);

public  void submitPaymentCalculator(ActionRequest actionRequest,	ActionResponse actionResponse) throws Exception {
	
	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
		String actionType = ParamUtil.getString(uploadRequest, "actionType");
		System.out.println("Action Type "+actionType);
		if( "calculatePaymentAmount".equalsIgnoreCase(actionType)) {
			   System.out.println("Yes calculatePaymentAmount ");
			setPaymentCalculatorResults(actionRequest, actionResponse);
		 } else if( "createCreditAppOrProposal".equalsIgnoreCase(actionType)) {
				System.out.println("Yes createCreditAppOrProposal ");
				createCreditOrProposal(actionRequest, actionResponse,user);
		 }else {
		  CreditApp creditApp = null;
		  try {
			    creditApp = CreditAppLocalServiceUtil.createCreditApp(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditApp.class.getName()));
				long productId=ParamUtil.getLong(actionRequest,"productId");
				long purchaseOptionId=ParamUtil.getLong(actionRequest,"purchaseOptionId");
				long termId=ParamUtil.getLong(actionRequest,"termId");
				long ratefactorId=ParamUtil.getLong(actionRequest,"ratefactorId");
				double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
				javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
				RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByMatchingEquipmentPrice(0, true, productId, termId, purchaseOptionId, equipmentPrice);
				request.getSession().setAttribute("rateFactorRuleId",new Long(rateFactorRule.getRateFactorRuleId()).toString());	
				request.getSession().setAttribute("equipmentPrice",equipmentPrice);	
				
				Double rateFactorValue=rateFactorRule.getRateFactor();
				Double paymentAmount= rateFactorValue *1;
				// Auditing Values
		
				creditApp.setCompanyId(user.getCompanyId());
				creditApp.setUserId(user.getUserId());
				creditApp.setUserName(user.getScreenName());
				creditApp.setModifiedDate(new Date());
				creditApp.setCreateDate(new Date());
				
				CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus("Draft");
						if("Draft".equalsIgnoreCase(actionType)){
							creditApp.setCreditAppStatusId(1);
						} else if("Saved".equalsIgnoreCase(actionType)){
							creditApp.setCreditAppStatusId(2);
		                } else if("Submitted".equalsIgnoreCase(actionType)){
		                	creditApp.setCreditAppStatusId(3);
		                } else if("Cancelled".equalsIgnoreCase(actionType)){
		                	creditApp.setCreditAppStatusId(4);
						}
						//includeInProposal
						//useForApplication
						
					
				creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
				
				creditApp.setCustomerBusinessDesc(ParamUtil.getString(actionRequest,"customerBusinessDesc"));
				creditApp.setCustomerBusinessFederalTaxID(ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
				creditApp.setCustomerBusinessIncorporatedState(ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				sdf.setLenient(false);
				Date customerBusinessStartDate = null;
				
					customerBusinessStartDate = sdf.parse(ParamUtil.getString(actionRequest,"customerBusinessStartDate"));
				
				creditApp.setCustomerBusinessStartDate(customerBusinessStartDate);
				creditApp.setCustomerBusinessType(ParamUtil.getString(actionRequest,"customerBusinessType"));
				creditApp.setCustomerAddress1(ParamUtil.getString(actionRequest,"customerAddress1"));
				creditApp.setCustomerAddress2(ParamUtil.getString(actionRequest,"customerAddress1"));
				
				creditApp.setCustomerName(ParamUtil.getString(actionRequest,"customerName"));
				creditApp.setCustomerDBAName(ParamUtil.getString(actionRequest,"customerDBAName"));
				
				
				creditApp.setCustomerState(ParamUtil.getString(actionRequest,"customerState"));
				creditApp.setCustomerCity(ParamUtil.getString(actionRequest,"customerCity"));
				creditApp.setCustomerZip(ParamUtil.getString(actionRequest,"customerZip"));
				creditApp.setEquipmentAddress1(ParamUtil.getString(actionRequest,"equipmentAddress1"));
				creditApp.setEquipmentAddress2(ParamUtil.getString(actionRequest,"equipmentAddress2"));
				creditApp.setEquipmentState(ParamUtil.getString(actionRequest,"equipmentState"));
				creditApp.setEquipmentCity(ParamUtil.getString(actionRequest,"equipmentCity"));
				creditApp.setEquipmentZip(ParamUtil.getString(actionRequest,"equipmentZip"));
				creditApp.setEquipmentDesc(ParamUtil.getString(actionRequest,"equipmentDesc"));
				creditApp.setEquipmentLocAsCustomerFlag(ParamUtil.getBoolean(actionRequest,"equipmentLocAsCustomerFlag"));
				creditApp.setEquipmentPrice(ParamUtil.getDouble(actionRequest,"equipmentPrice"));
				//CreditAppStatusLocalServiceUtil.getCreditAppStatus(CreditAppStatusId);
				//Payment Amount comes from the formula of RateFactor Rule.Temporarily store equipment price for testing
				creditApp.setEquipmentPrice(paymentAmount);
				request.getSession().setAttribute("productId",new Long(productId).toString());
				request.getSession().setAttribute("purchaseOptionId",new Long(purchaseOptionId).toString());
				request.getSession().setAttribute("termId",new Long(termId).toString());
				request.getSession().setAttribute("ratefactorId",new Long(ratefactorId).toString());
				
				creditApp.setProductId(productId);
				creditApp.setPurchaseOptionId(purchaseOptionId);
				creditApp.setRateFactorRuleId(ratefactorId);
				creditApp.setTermId(termId);
				creditApp.setVendorId(rateFactorRule.getVendorId());
				System.out.println("Vendor Id: "+rateFactorRule.getVendorId() );
				CreditAppLocalServiceUtil.addCreditApp(creditApp);
				request.getSession().setAttribute("creditAppId",creditApp.getCreditAppId());
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					_log.info(e.getMessage());
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					_log.info(e.getMessage());
					e.printStackTrace();
				}
			}	
			
}

public  void createCreditOrProposal(ActionRequest actionRequest,	ActionResponse actionResponse, User user) throws Exception {
	CreditApp creditApp = null;
	  
		creditApp = CreditAppLocalServiceUtil.createCreditApp(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditApp.class.getName()));
		long productId=ParamUtil.getLong(actionRequest,"productId");
		long purchaseOptionId=ParamUtil.getLong(actionRequest,"purchaseOptionId");
		long termId=ParamUtil.getLong(actionRequest,"termId");
		long ratefactorId=ParamUtil.getLong(actionRequest,"ratefactorId");
		double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
		javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByMatchingEquipmentPrice(0, true, productId, termId, purchaseOptionId, equipmentPrice);
		request.getSession().setAttribute("rateFactorRuleId",new Long(rateFactorRule.getRateFactorRuleId()).toString());	
		request.getSession().setAttribute("equipmentPrice",equipmentPrice);	
		
		Double rateFactorValue=rateFactorRule.getRateFactor();
		Double paymentAmount= rateFactorValue *1;
		// Auditing Values
		
		creditApp.setCompanyId(user.getCompanyId());
		creditApp.setUserId(user.getUserId());
		creditApp.setUserName(user.getScreenName());
		creditApp.setModifiedDate(new Date());
		creditApp.setCreateDate(new Date());
		
		CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus("Draft");
	
				//includeInProposal
				//useForApplication
				
			
		creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
		CreditAppLocalServiceUtil.addCreditApp(creditApp);
		updateProposalOption(actionRequest, actionResponse, creditApp.getCreditAppId());
	  

}

public void setPaymentCalculatorResults (ActionRequest actionRequest,	ActionResponse actionResponse) throws Exception{
	Map<String,String> termnameListMap= new HashMap<String, String>();
	Map<String,String> purchaseOptionListMap= new HashMap<String, String>();
	Map<String,String> productNameListMap= new HashMap<String, String>();
	List<String> termnameListResult= new ArrayList<String>();
	List<String> purchaseOptionListResult= new ArrayList<String>();
	List<String> productNameListResult= new ArrayList<String>();
	HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
	UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
	
	Map<String,String[]> m=uploadRequest.getParameterMap();
    Set<Entry<String, String[]>> s = m.entrySet();
    Iterator<Entry<String, String[]>> it = s.iterator();
    
    while(it.hasNext()){
    	System.out.println(" Iterate all Values ");   
        Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

        String key             = entry.getKey();
        String[] value         = entry.getValue();

        //System.out.println("Key is "+key + " Value "+ value[0] != null ? value[0].toString(): "No Value");
        System.out.println("  Check Key is "+key + " Value " + value[0]);   
          if(key.contains("termOption") && key.contains("Checkbox")){
        	  termnameListResult.add(value[0].toString());
        	  termnameListMap.put(value[0].toString(), value[0].toString());
        	  
           }else if(key.contains("purchaseOption") && key.contains("Checkbox")){
        	   purchaseOptionListResult.add(value[0].toString());
        	   purchaseOptionListMap.put(value[0].toString(), value[0].toString());
           } else if(key.contains("productPricing")  && key.contains("Checkbox")){
        	   productNameListResult.add(value[0].toString());
        	   productNameListMap.put(value[0].toString(), value[0].toString());
           }
    }  
    double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
    request.getSession().setAttribute("equipmentPrice",equipmentPrice);
   	request.getSession().setAttribute("termNameListResult",termnameListResult);
	request.getSession().setAttribute("purchaseOptionListResult",purchaseOptionListResult);
	request.getSession().setAttribute("productNameListResult",productNameListResult);
	request.getSession().setAttribute("termNameListMap",termnameListMap);
	request.getSession().setAttribute("purchaseOptionListMap",purchaseOptionListMap);
	request.getSession().setAttribute("productNameListMap",productNameListMap);
	Long  productId=0l;
	Long termId=0l;
	Long purchaseOptionId=0l;
	
	double tempMinPrice=0.0;
	double paymentAmount=0.0;
	TempProposalOption tempProporsal= new TempProposalOption();
	List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
	List<Product> productList = ProductLocalServiceUtil.getProducts(-1, -1);
	List<Term> termList = TermLocalServiceUtil.getTerms(-1, -1);
	List<PurchaseOption> purchaseOptionList = PurchaseOptionLocalServiceUtil.getPurchaseOptions(-1, -1);
	for (int i=0;i<productList.size();i++){
		tempProporsal= new TempProposalOption();
		
		
		if(productNameListResult.contains(new Long(productList.get(i).getProductId()).toString())){
			//productId=new Long(ParamUtil.getString(actionRequest,"productPricing"+i)).longValue();
			System.out.println("Matched Product Id: "+productList.get(i).getProductId());
			tempProporsal.setProductId(productList.get(i).getProductId());
		}
		if( i<= termList.size() && termnameListResult.contains(new Long(termList.get(i).getTermId()).toString())){
			//termId=new Long(ParamUtil.getString(actionRequest,"termOption"+i)).longValue();
			System.out.println("Matched Term Id: "+termList.get(i).getTermId());
			tempProporsal.setTermId(termList.get(i).getTermId());
		}
		if(i<= purchaseOptionList.size() && purchaseOptionListResult.contains(new Long(purchaseOptionList.get(i).getPurchaseOptionId()).toString())){
			//purchaseOptionId=new Long(ParamUtil.getString(actionRequest,"purchaseOption"+i)).longValue();
			System.out.println("Matched Purchase Id: "+purchaseOptionList.get(i).getPurchaseOptionId());
			tempProporsal.setPurchaseOptionId(purchaseOptionList.get(i).getPurchaseOptionId());
		}
		
		try{
			RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(0, true, productId, termId, purchaseOptionId);
			tempMinPrice=rateFactorRule.getMinPrice();
		
		
		if(equipmentPrice >= tempMinPrice){
			paymentAmount=(equipmentPrice/TermLocalServiceUtil.getTerm(termId).getTermMonths()) * (1+rateFactorRule.getRateFactor());
			tempProporsal.setPaymentAmount(paymentAmount);
		}
       } catch (Exception e){
			
		}
		if(tempProporsal.getProductId() > 1){
			tempProporsal.setProposalId(i);
		    tempProposalList.add(tempProporsal);
		}
	}
	
	System.out.println("Temp Proporsal List size: "+tempProposalList.size());
	request.getSession().setAttribute("proposalOptionList",tempProposalList);
	
}
public  void updateCreditAppPrincipal(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		String actionType = ParamUtil.getString(actionRequest, "actionType");
 		CreditAppPrincipal creditAppPrincipal = null;
 		try {
 			creditAppPrincipal = CreditAppPrincipalLocalServiceUtil.createCreditAppPrincipal(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditAppPrincipal.class.getName()));
 		} catch (SystemException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 	
 		// Auditing Values

 		creditAppPrincipal.setCompanyId(user.getCompanyId());
 		creditAppPrincipal.setUserId(user.getUserId());
 		creditAppPrincipal.setUserName(user.getScreenName());
 		creditAppPrincipal.setModifiedDate(new Date());
 		creditAppPrincipal.setCreateDate(new Date());
 		
 		//CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.
 		javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		request.getSession().setAttribute("creditAppId",new Long((String)request.getSession().getAttribute("creditAppId")).longValue());
 		creditAppPrincipal.setPrincipalAddress1(ParamUtil.getString(actionRequest,"principalAddress1"));
 		creditAppPrincipal.setPrincipalAddress2(ParamUtil.getString(actionRequest,"principalAddress1"));
 		creditAppPrincipal.setPrincipalState(ParamUtil.getString(actionRequest,"principalState"));
 		creditAppPrincipal.setPrincipalCity(ParamUtil.getString(actionRequest,"principalCity"));
 		creditAppPrincipal.setPrincipalZip(ParamUtil.getString(actionRequest,"principalZip"));
 		creditAppPrincipal.setPrincipalFirstName(ParamUtil.getString(actionRequest,"principalFirstName"));
 		creditAppPrincipal.setPrincipalMiddleName(ParamUtil.getString(actionRequest,"principalMiddleName"));
 		creditAppPrincipal.setPrincipalLastName(ParamUtil.getString(actionRequest,"principalLastName"));
 		creditAppPrincipal.setPrincipalSSN(ParamUtil.getString(actionRequest,"principalSSN"));
 		creditAppPrincipal.setPrincipalEmail(ParamUtil.getString(actionRequest,"principalEmail"));
 		creditAppPrincipal.setCreditAppId(new Long((String)request.getSession().getAttribute("creditAppId")).longValue());
 		CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(creditAppPrincipal);
 
 	
 }

public  void updateProposalOption(ActionRequest actionRequest,	ActionResponse actionResponse, long creditAppId) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		ProposalOption proposalOption = null;
 		try {
 			proposalOption = ProposalOptionLocalServiceUtil.createProposalOption(com.liferay.counter.service.CounterLocalServiceUtil.increment(ProposalOption.class.getName()));
 		} catch (SystemException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 	
 		// Auditing Values

 		proposalOption.setCompanyId(user.getCompanyId());
 		proposalOption.setUserId(user.getUserId());
 		proposalOption.setUserName(user.getScreenName());
 		proposalOption.setModifiedDate(new Date());
 		proposalOption.setCreateDate(new Date());
 		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		TempProposalOption tempProposalOption= new TempProposalOption();
 		@SuppressWarnings("unchecked")
		List<TempProposalOption> tempProposalList=(ArrayList<TempProposalOption>)request.getSession().getAttribute("proposalOptionList");
 		for (int i=0; i<tempProposalList.size(); i++){
 			 if(tempProposalList.get(i).getProposalId() ==ParamUtil.getLong(actionRequest,"proposalId") ){
 				tempProposalOption=tempProposalList.get(i);
 				break;
 			 }
 		}
 		request.getSession().setAttribute("creditAppId",creditAppId);
 		proposalOption.setCreditAppId(creditAppId);
 		proposalOption.setProductId(tempProposalOption.getProductId());
 		proposalOption.setPurchaseOptionId(tempProposalOption.getPurchaseOptionId());
 		proposalOption.setTermId(tempProposalOption.getTermId());
 		proposalOption.setRateFactorRuleId(new Long((String)request.getSession().getAttribute("rateFactorRuleId")).longValue());
 		//proposalOption.setIncludeInProposal(tempProposalOption.getIncludeInProposal());
 		ProposalOptionLocalServiceUtil.addProposalOption(proposalOption);
 
 	
 }
@Override
public void doView(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
	// TODO Auto-generated method stub
	HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	Map<String,String> termnameListMap= new HashMap<String, String>();
	Map<String,String> purchaseOptionListMap= new HashMap<String, String>();
	Map<String,String> productNameListMap= new HashMap<String, String>();
	List<String> termnameListResult= new ArrayList<String>();
	List<String> purchaseOptionListResult= new ArrayList<String>();
	List<String> productNameListResult= new ArrayList<String>();
	try {
		List<String> termnameList= new ArrayList<String>();
		List<String> purchaseOptionList= new ArrayList<String>();
		List<String> productNameList= new ArrayList<String>();
	//List<RateFactorRule> rateFactorRule1=RateFactorRuleLocalServiceUtil.getRateFactorRules(-1, -1);
	List<Term> termnameList1= new ArrayList<Term>();
	List<PurchaseOption> purchaseOptionList1= new ArrayList<PurchaseOption>();
	List<Product> productNameList1= new ArrayList<Product>();
	termnameList1=TermLocalServiceUtil.getTerms(-1, -1);
	purchaseOptionList1=PurchaseOptionLocalServiceUtil.getPurchaseOptions(-1, -1);
	productNameList1=ProductLocalServiceUtil.getProducts(-1, -1);
	for ( int k=0; k<productNameList1.size(); k++ ){
		 Product product =productNameList1.get(k);
		 productNameList.add(new Long(product.getProductId()).toString());
		
		}
	renderRequest.setAttribute("productNameList",productNameList);
	request.getSession().setAttribute("productNameList",productNameList);
	if(request.getSession().getAttribute("equipmentPrice") == null){
	   request.getSession().setAttribute("equipmentPrice","");
	}
	
	for ( int i=0; i<termnameList1.size(); i++ ){
	     Term term =termnameList1.get(i);
	     termnameList.add(new Long(term.getTermId()).toString());
	 
	}
	
	renderRequest.setAttribute("termNameList",termnameList);
	request.getSession().setAttribute("termNameList",termnameList);
	
	for ( int j=0; j<purchaseOptionList1.size(); j++ ){
		PurchaseOption purchase =purchaseOptionList1.get(j);
		purchaseOptionList.add(new Long(purchase.getPurchaseOptionId()).toString());
			
		}
	
	renderRequest.setAttribute("purchaseOptionList",purchaseOptionList);
	request.getSession().setAttribute("purchaseOptionList",purchaseOptionList);
	//request.getSession().setAttribute("actionType","getCalculatorResults");
	
	if(request.getSession().getAttribute("productNameListMap") == null) {
		request.getSession().setAttribute("termNameListMap",termnameListMap);
		request.getSession().setAttribute("purchaseOptionListMap",purchaseOptionListMap);
		request.getSession().setAttribute("productNameListMap",productNameListMap);
	}
	
	if(request.getSession().getAttribute("productNameListResult") == null) {
		request.getSession().setAttribute("termNameListResult",termnameListResult);
		request.getSession().setAttribute("purchaseOptionListResult",purchaseOptionListResult);
		request.getSession().setAttribute("productNameListResult",productNameListResult);
	 }
	if(request.getSession().getAttribute("proposalOptionList") == null) {
	   List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
	   request.getSession().setAttribute("proposalOptionList",tempProposalList);
	  }
	}
	
	
	catch (Exception e){
		
	}
	super.doView(renderRequest, renderResponse);
 }

public  void updateCreditAppBankReference(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		String actionType = ParamUtil.getString(actionRequest, "actionType");
 		CreditAppBankReference creditAppPrincipal = null;
 		try {
 			creditAppPrincipal = CreditAppBankReferenceLocalServiceUtil.createCreditAppBankReference(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditAppBankReference.class.getName()));
 		} catch (SystemException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 	
 		// Auditing Values

 		creditAppPrincipal.setCompanyId(user.getCompanyId());
 		creditAppPrincipal.setUserId(user.getUserId());
 		creditAppPrincipal.setUserName(user.getScreenName());
 		creditAppPrincipal.setModifiedDate(new Date());
 		creditAppPrincipal.setCreateDate(new Date());
 		
 		//CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.
 		javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		creditAppPrincipal.setBankReferencAccountType(ParamUtil.getString(actionRequest,"bankReferencAccountType"));
 		creditAppPrincipal.setBankReferenceAccountNumber(ParamUtil.getString(actionRequest,"bankReferenceAccountNumber"));
 		creditAppPrincipal.setBankReferenceContact(ParamUtil.getString(actionRequest,"bankReferenceAccountContact"));
 		creditAppPrincipal.setBankReferenceName(ParamUtil.getString(actionRequest,"bankReferenceAccountName"));
 		creditAppPrincipal.setBankReferencePhone(ParamUtil.getString(actionRequest,"bankReferenceAccountPhone"));
 		creditAppPrincipal.setSequenceNumber(ParamUtil.getLong(actionRequest,"sequenceNumber"));
 		creditAppPrincipal.setCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
 		CreditAppBankReferenceLocalServiceUtil.addCreditAppBankReference(creditAppPrincipal);
 
 	
 }

}
