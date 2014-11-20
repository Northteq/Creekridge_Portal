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
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
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
public class ViewApplication extends MVCPortlet {
    
   /**
    * @see MVCPortlet#MVCPortlet()
    */
   public ViewApplication() {
       super();
   }
   private static Log _log = LogFactory.getLog(PaymentCalculatorTable.class);

public  void submitPaymentCalculator(ActionRequest actionRequest,	ActionResponse actionResponse) throws Exception {
	
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
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
			    creditApp = CreditAppLocalServiceUtil.getCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
				long productId=ParamUtil.getLong(actionRequest,"productId");
				long purchaseOptionId=ParamUtil.getLong(actionRequest,"purchaseOptionId");
				long termId=ParamUtil.getLong(actionRequest,"termId");
				long ratefactorId=ParamUtil.getLong(actionRequest,"ratefactorId");
				double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
				
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
				
				CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus(actionType);
				creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
				creditApp.setCustomerBusinessDesc(ParamUtil.getString(actionRequest,"customerBusinessDesc"));
				creditApp.setCustomerBusinessFederalTaxID(ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
				creditApp.setCustomerBusinessIncorporatedState(ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				sdf.setLenient(true);
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
				
				
				creditApp.setCustomerContact(ParamUtil.getString(actionRequest,"customerContact"));
				creditApp.setCustomerContactPhone(ParamUtil.getString(actionRequest,"customerContactPhone"));
				creditApp.setCustomerContactFax(ParamUtil.getString(actionRequest,"customerContactFax"));
				creditApp.setCustomerContactEmail(ParamUtil.getString(actionRequest,"customerContactEmail"));
				
				request.getSession().setAttribute("customerBusinessDesc",ParamUtil.getString(actionRequest,"customerBusinessDesc"));
				request.getSession().setAttribute("customerBusinessFederalTaxID",ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
				request.getSession().setAttribute("customerBusinessIncorporatedState",ParamUtil.getString(actionRequest,"customerBusinessIncorporatedState"));
				request.getSession().setAttribute("customerBusinessStartDate",ParamUtil.getString(actionRequest,"customerBusinessStartDate"));
				request.getSession().setAttribute("customerBusinessType",ParamUtil.getString(actionRequest,"customerBusinessType"));
				request.getSession().setAttribute("customerAddress1",ParamUtil.getString(actionRequest,"customerAddress1"));
				request.getSession().setAttribute("customerAddress1",ParamUtil.getString(actionRequest,"customerAddress1"));
				
				request.getSession().setAttribute("customerName",ParamUtil.getString(actionRequest,"customerName"));
				request.getSession().setAttribute("customerDBAName",ParamUtil.getString(actionRequest,"customerDBAName"));
				request.getSession().setAttribute("customerContact",ParamUtil.getString(actionRequest,"customerContact"));
				request.getSession().setAttribute("customerContactPhone",ParamUtil.getString(actionRequest,"customerContactPhone"));
				request.getSession().setAttribute("customerContactFax",ParamUtil.getString(actionRequest,"customerContactFax"));
				request.getSession().setAttribute("customerContactEmail",ParamUtil.getString(actionRequest,"customerContactEmail"));
				
				
				request.getSession().setAttribute("customerState",ParamUtil.getString(actionRequest,"customerState"));
				request.getSession().setAttribute("customerCity",ParamUtil.getString(actionRequest,"customerCity"));
				request.getSession().setAttribute("customerZip",ParamUtil.getString(actionRequest,"customerZip"));
				request.getSession().setAttribute("equipmentAddress1",ParamUtil.getString(actionRequest,"equipmentAddress1"));
				request.getSession().setAttribute("equipmentAddress2",ParamUtil.getString(actionRequest,"equipmentAddress2"));
				request.getSession().setAttribute("equipmentState",ParamUtil.getString(actionRequest,"equipmentState"));
				request.getSession().setAttribute("equipmentCity",ParamUtil.getString(actionRequest,"equipmentCity"));
				request.getSession().setAttribute("equipmentZip",ParamUtil.getString(actionRequest,"equipmentZip"));
				request.getSession().setAttribute("equipmentDesc",ParamUtil.getString(actionRequest,"equipmentDesc"));
				request.getSession().setAttribute("equipmentLocAsCustomerFlag",ParamUtil.getBoolean(actionRequest,"equipmentLocAsCustomerFlag"));
				request.getSession().setAttribute("equipmentPrice",ParamUtil.getDouble(actionRequest,"equipmentPrice"));
				request.getSession().setAttribute("actionType",ParamUtil.getString(actionRequest,"actionType"));
				creditApp.setVendorId(rateFactorRule.getVendorId());
				System.out.println("Vendor Id: "+rateFactorRule.getVendorId() );
				CreditAppLocalServiceUtil.updateCreditApp(creditApp);
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
	   ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		creditApp = CreditAppLocalServiceUtil.createCreditApp(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditApp.class.getName()));
		long productId=ParamUtil.getLong(actionRequest,"productId");
		long purchaseOptionId=ParamUtil.getLong(actionRequest,"purchaseOptionId");
		long termId=ParamUtil.getLong(actionRequest,"termId");
		boolean optionSelected=false;
		double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByMatchingEquipmentPrice(0, true, productId, termId, purchaseOptionId, equipmentPrice);
		request.getSession().setAttribute("rateFactorRuleId",new Long(rateFactorRule.getRateFactorRuleId()).toString());	
		request.getSession().setAttribute("equipmentPrice",equipmentPrice);	
		
		Double rateFactorValue=rateFactorRule.getRateFactor();
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
		
	    TempProposalOption tempProposalOption= new TempProposalOption();
		@SuppressWarnings("unchecked")
		List<TempProposalOption> tempProposalList=(ArrayList<TempProposalOption>)request.getSession().getAttribute("proposalOptionList");
		for (int i=0; i<tempProposalList.size(); i++){
			 if(tempProposalList.get(i).getProposalId() ==ParamUtil.getLong(actionRequest,"useForApplication") ){
				tempProposalOption=tempProposalList.get(i);
				optionSelected=true;
				break;
			 }
		}
		
		if(optionSelected){
	 		creditApp.setProductId(tempProposalOption.getProductId());
	 		creditApp.setPaymentAmount(tempProposalOption.getPaymentAmount());
	 		creditApp.setPurchaseOptionId(tempProposalOption.getPurchaseOptionId());
	 		creditApp.setTermId(tempProposalOption.getTermId());
	 		creditApp.setRateFactorRuleId(tempProposalOption.getRateFactorRuleId());
	 		creditApp.setVendorId(themeDisplay.getScopeGroupId());
		}
		CreditAppLocalServiceUtil.addCreditApp(creditApp);
	    request.getSession().setAttribute("creditAppId",creditApp.getCreditAppId());
	    updateProposalOption(actionRequest, actionResponse);
	  

}

public void setPaymentCalculatorResults (ActionRequest actionRequest,	ActionResponse actionResponse) throws Exception{
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
 
   long tempProposalOptionId=0;
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
          } else if(key.contains("useForApplication")){
       	 
       	  
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
	double tempMinPrice=0.0;
	double paymentAmount=0.0;
	
	TempProposalOption tempProporsal= new TempProposalOption();
	List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
	List<Product> productList = ProductLocalServiceUtil.getProducts(-1, -1);
	for (int i=0;i<productNameListResult.size();i++){
		
		for (int j=0;j<purchaseOptionListResult.size();j++){
			
			for (int k=0;k<termnameListResult.size();k++){
				tempProporsal= new TempProposalOption();
				    tempProporsal.setProposalId(tempProposalOptionId);
					System.out.println("Matched Product Id: "+productNameListResult.get(i));
					tempProporsal.setProductId(new Long(productNameListResult.get(i)).longValue());	
					System.out.println("Matched Purchase Id: "+purchaseOptionListResult.get(j));
					tempProporsal.setPurchaseOptionId(new Long(purchaseOptionListResult.get(j)).longValue());
					System.out.println("Matched Term Id: "+termnameListResult.get(k));
					tempProporsal.setTermId(new Long(termnameListResult.get(k)).longValue());
		     try{
			     RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(themeDisplay.getScopeGroupId(), true, tempProporsal.getProductId(), tempProporsal.getTermId(), tempProporsal.getPurchaseOptionId());
			      if( rateFactorRule.getRateFactor() == 0.0) {
				     request.getSession().setAttribute("zeroRateFactor",PropsUtil.get("zeroRateFactor"));
			       }
			     tempMinPrice=rateFactorRule.getMinPrice();
			     tempProporsal.setRateFactorRuleId(rateFactorRule.getRateFactorRuleId());
			     if(equipmentPrice >= tempMinPrice){
					paymentAmount=(equipmentPrice/TermLocalServiceUtil.getTerm(tempProporsal.getTermId()).getTermMonths()) * (1+rateFactorRule.getRateFactor());
					tempProporsal.setPaymentAmount(paymentAmount);
				}
			     if(tempProporsal.getProductId() > 0 && tempProporsal.getTermId() > 0 && tempProporsal.getPurchaseOptionId() > 0 && paymentAmount> 0.0){
						
					    tempProposalList.add(tempProporsal);
					   // request.getSession().setAttribute("zeroRateFactor",PropsUtil.get("zeroRateFactor"));
					}
			     
		       } catch (Exception e){
					
				}
		          tempProposalOptionId=tempProposalOptionId+1;
			   }
			  }
			}
	     if (tempProposalList.size() > 0){
		      System.out.println("Temp Proporsal List size: "+tempProposalList.size());
		      request.getSession().setAttribute("proposalOptionList",tempProposalList);
	     } else {
	    	  request.getSession().setAttribute("zeroRateFactor",PropsUtil.get("zeroRateFactor")); 
	     }
	   }

public  void updateCreditAppPrincipal(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
	   TempPrincipal tempPrincipal = new TempPrincipal();
	   List<TempPrincipal> tempPrincipalList=new ArrayList<TempPrincipal>();
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String actionType = ParamUtil.getString(actionRequest, "principalActionType");
		 System.out.println("Principal ActionType: "+actionType);
		Long principalId=ParamUtil.getLong(actionRequest,"creditAppPrincipalId");
		CreditAppPrincipal creditAppPrincipal = null;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		
		if(principalId > 0){
			creditAppPrincipal=CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipal(principalId);
		} else {
		  creditAppPrincipal = CreditAppPrincipalLocalServiceUtil.createCreditAppPrincipal(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditAppPrincipal.class.getName()));
		
		}

		if("delete".equalsIgnoreCase(actionType)){
			CreditAppPrincipalLocalServiceUtil.deleteCreditAppPrincipal(principalId);
			List<CreditAppPrincipal> creditAppPrincipalList= CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
			request.getSession().setAttribute("creditAppPrincipalList",creditAppPrincipalList);
			return;
		}
		// Auditing Values

		creditAppPrincipal.setCompanyId(user.getCompanyId());
		creditAppPrincipal.setUserId(user.getUserId());
		creditAppPrincipal.setUserName(user.getScreenName());
		creditAppPrincipal.setModifiedDate(new Date());
		creditAppPrincipal.setCreateDate(new Date());
		
		//CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.
		
		request.getSession().setAttribute("creditAppId",new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
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
		creditAppPrincipal.setCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
		
	    if("edit".equalsIgnoreCase(actionType)) {
		 	CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(creditAppPrincipal);
 		} else {
 			CreditAppPrincipalLocalServiceUtil.addCreditAppPrincipal(creditAppPrincipal);	
		}
	     List<CreditAppPrincipal> creditAppPrincipalList=  CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
	     
	     for ( int i=0; i< creditAppPrincipalList.size();i++){
	 	     tempPrincipal.setPrincipalFirstName(creditAppPrincipalList.get(i).getPrincipalFirstName());
	 	     tempPrincipal.setPrincipalSSN(creditAppPrincipalList.get(i).getPrincipalSSN());
	 	     tempPrincipal.setPrincipalLastName(creditAppPrincipalList.get(i).getPrincipalLastName());
	 	     tempPrincipal.setPrincipalId(creditAppPrincipalList.get(i).getPrincipalId());
	 	     tempPrincipalList.add(tempPrincipal);
	     }
	    request.getSession().removeAttribute("creditAppPrincipalList");
	    request.getSession().setAttribute("creditAppPrincipalList",tempPrincipalList);
	    request.getSession().setAttribute("actionType","principalEntered");
	   
	   
	   System.out.println("creditAppPrincipalList size: "+tempPrincipalList.size());

	
}

public  void updateProposalOption(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 
	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		List<ProposalOption> proposalOptionList = null;
		ProposalOption proposalOption = null;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		List<String> proposalListResult= new ArrayList<String>();
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
	          if(key.contains("includeInProposal") && key.contains("Checkbox")){
	        	 proposalListResult.add(value[0].toString());
	        	 
	        }  
	    }
		   long creditAppId= new Long(request.getSession().getAttribute("creditAppId").toString()).longValue();
		
			 @SuppressWarnings("unchecked")
			 List<TempProposalOption> tempProposalList=(ArrayList<TempProposalOption>)request.getSession().getAttribute("proposalOptionList");
			 for (int i=0; i<tempProposalList.size(); i++){
				 if(proposalListResult.contains(new Long(tempProposalList.get(i).getProposalId()).toString())){
					 proposalOption = ProposalOptionLocalServiceUtil.createProposalOption(com.liferay.counter.service.CounterLocalServiceUtil.increment(ProposalOption.class.getName()));
					 // Auditing Values
					 proposalOption.setCompanyId(user.getCompanyId());
					 proposalOption.setUserId(user.getUserId());
					 proposalOption.setUserName(user.getScreenName());
					 proposalOption.setModifiedDate(new Date());
					 proposalOption.setCreateDate(new Date());
					 //	Other fields
		 			 
					 proposalOption.setCreditAppId(creditAppId);
					 proposalOption.setProductId(tempProposalList.get(i).getProductId());
					 proposalOption.setPurchaseOptionId(tempProposalList.get(i).getPurchaseOptionId());
					 proposalOption.setTermId(tempProposalList.get(i).getTermId());
					 proposalOption.setRateFactorRuleId(tempProposalList.get(i).getRateFactorRuleId());
					 
					 ProposalOptionLocalServiceUtil.addProposalOption(proposalOption);
		
				 }
			 }
		  }
	

@Override
public void doView(RenderRequest renderRequest,	RenderResponse renderResponse) throws IOException, PortletException {

	HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
   System.out.println("Loading.... from "+request.getHeader("referer"));
   String clearCalculatorResults=PortalUtil.getOriginalServletRequest(request).getParameter("clear");
   
   String viewCreditApp=PortalUtil.getOriginalServletRequest(request).getParameter("view");
   request.getSession().setAttribute("viewCreditApp",viewCreditApp);
	
   String bankAccountReferenceId=PortalUtil.getOriginalServletRequest(request).getParameter("bankAccountReferenceId");
   System.out.println("Clear command.. "+clearCalculatorResults);
   System.out.println("bankAccountReferenceId.. "+bankAccountReferenceId);
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
	
	if(request.getSession().getAttribute("creditAppId") != null && request.getHeader("referer").contains("payment-calculator")){
		long creditAppId=new Long(request.getSession().getAttribute("creditAppId").toString()).longValue();
		CreditApp creditApp= CreditAppLocalServiceUtil.getCreditApp(creditAppId);
	//	List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
//		 if(request.getSession().getAttribute("creditAppPrincipalList") == null){
//			 List<CreditAppPrincipal> creditAppPrincipalList= CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
//			 if(creditAppPrincipalList != null && !creditAppPrincipalList.isEmpty()) {
//				  request.getSession().removeAttribute("creditAppPrincipalList");
//				  request.getSession().setAttribute("creditAppPrincipalList",creditAppPrincipalList);
//				}     
//		}
		   List<ProposalOption> creditAppProposalList= ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
//		if(bankReferenceAccountList != null && !bankReferenceAccountList.isEmpty()) {
//		  request.getSession().setAttribute("bankReferenceAccountList",bankReferenceAccountList);
//		}
		
		request.getSession().setAttribute("creditApp",creditApp);
		//request.getSession().setAttribute("proposalOptionList",creditAppProposalList);
		request.getSession().setAttribute("state",creditApp.getCustomerState());
		request.getSession().setAttribute("customerBusinessIncorporatedState",creditApp.getCustomerBusinessIncorporatedState());
		request.getSession().setAttribute("equipmentState",creditApp.getEquipmentState());
		request.getSession().setAttribute("principalState",creditApp.getCustomerBusinessIncorporatedState());
		request.getSession().setAttribute("customerBusinessType",creditApp.getCustomerBusinessType());
		
		
	} else {
		//request.getSession().setAttribute("bankReferenceAccountList",new ArrayList<CreditAppBankReference>());
		//request.getSession().setAttribute("creditAppPrincipalList",new ArrayList<CreditAppPrincipal>());
	}
	request.getSession().setAttribute("productNameList",productNameList);
	if("clear".equalsIgnoreCase(clearCalculatorResults) || request.getSession().getAttribute("equipmentPrice") == null || !request.getHeader("referer").contains("payment-calculator")){
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
	
	if( "clear".equalsIgnoreCase(clearCalculatorResults) || request.getSession().getAttribute("productNameListMap") == null || !request.getHeader("referer").contains("payment-calculator") ) {
		request.getSession().setAttribute("termNameListMap",termnameListMap);
		request.getSession().setAttribute("purchaseOptionListMap",purchaseOptionListMap);
		request.getSession().setAttribute("productNameListMap",productNameListMap);
		
	}
	
	if("clear".equalsIgnoreCase(clearCalculatorResults) || request.getSession().getAttribute("productNameListResult") == null || !request.getHeader("referer").contains("payment-calculator")) {
		request.getSession().setAttribute("termNameListResult",termnameListResult);
		request.getSession().setAttribute("purchaseOptionListResult",purchaseOptionListResult);
		request.getSession().setAttribute("productNameListResult",productNameListResult);
	 }
	if("clear".equalsIgnoreCase(clearCalculatorResults) || request.getSession().getAttribute("proposalOptionList") == null || !request.getHeader("referer").contains("payment-calculator")) {
	   List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
	   request.getSession().setAttribute("proposalOptionList",tempProposalList);
	   request.getSession().setAttribute("actionType","");
	   request.getSession().setAttribute("creditAppId","");
	  }
	}
	
	
	catch (Exception e){
		
	}
	super.doView(renderRequest, renderResponse);
}

public  void updateCreditAppBankAccountReference(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException, Exception {

	   TempBankAccount tempBankAccount = new TempBankAccount();
	   List<TempBankAccount> tempBankReferenceAccountList=new ArrayList<TempBankAccount>();
	   ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		CreditAppBankReference creditAppBankReference = null;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		String actionType = ParamUtil.getString(actionRequest, "bankReferenceActionType");
		Long creditAppBankReferenceId=ParamUtil.getLong(actionRequest,"creditAppBankReferenceId");
		
		if(creditAppBankReferenceId > 0){
			creditAppBankReference=CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReference(creditAppBankReferenceId);
		} else {
			creditAppBankReference = CreditAppBankReferenceLocalServiceUtil.createCreditAppBankReference(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditAppBankReference.class.getName()));
		
		}
		if("delete".equalsIgnoreCase(actionType)){
			CreditAppBankReferenceLocalServiceUtil.deleteCreditAppBankReference(creditAppBankReferenceId);
			List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
			request.getSession().setAttribute("bankReferenceAccountList",bankReferenceAccountList);
			return;
		}
		// Auditing Values
		creditAppBankReference.setCompanyId(user.getCompanyId());
		creditAppBankReference.setUserId(user.getUserId());
		creditAppBankReference.setUserName(user.getScreenName());
		creditAppBankReference.setModifiedDate(new Date());
		creditAppBankReference.setCreateDate(new Date());
	
		creditAppBankReference.setBankReferencAccountType(ParamUtil.getString(actionRequest,"bankReferencAccountType"));
		creditAppBankReference.setBankReferenceAccountNumber(ParamUtil.getString(actionRequest,"bankReferenceAccountNumber"));
		creditAppBankReference.setBankReferenceContact(ParamUtil.getString(actionRequest,"bankReferenceAccountContact"));
		creditAppBankReference.setBankReferenceName(ParamUtil.getString(actionRequest,"bankReferenceAccountName"));
		creditAppBankReference.setBankReferencePhone(ParamUtil.getString(actionRequest,"bankReferenceAccountPhone"));
		creditAppBankReference.setSequenceNumber(ParamUtil.getLong(actionRequest,"sequenceNumber"));
		creditAppBankReference.setCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
		if("edit".equalsIgnoreCase(actionType)){
			CreditAppBankReferenceLocalServiceUtil.updateCreditAppBankReference(creditAppBankReference);
		} else { 
		    CreditAppBankReferenceLocalServiceUtil.addCreditAppBankReference(creditAppBankReference);
		}
		
		List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
		 for (int i=0;i<bankReferenceAccountList.size();i++){
			 tempBankAccount.setBankReferencAccountType(bankReferenceAccountList.get(i).getBankReferencAccountType());
			 tempBankAccount.setBankReferenceName(bankReferenceAccountList.get(i).getBankReferenceName());
			 tempBankAccount.setBankReferenceAccountNumber(bankReferenceAccountList.get(i).getBankReferenceAccountNumber());
			 tempBankAccount.setBankReferenceContact(bankReferenceAccountList.get(i).getBankReferenceContact());
			 tempBankAccount.setBankReferencePhone(bankReferenceAccountList.get(i).getBankReferencePhone());
			 tempBankAccount.setBankReferenceId(bankReferenceAccountList.get(i).getBankReferenceId());
			 tempBankReferenceAccountList.add(tempBankAccount);
		 }
		
		request.getSession().setAttribute("bankReferenceAccountList",tempBankReferenceAccountList);
    
	 }

 
public void serveResource(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) throws IOException,
		PortletException {
	// TODO Auto-generated method stub
	  System.out.println("From serverResource");
	super.serveResource(resourceRequest, resourceResponse);
}

public  void updateCreditApp(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
	   List<TempPrincipal> tempPrincipalList=new ArrayList<TempPrincipal>();
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		 System.out.println(" ActionType: "+actionType);
		Long principalId=ParamUtil.getLong(actionRequest,"creditAppId");
		 System.out.println(" creditAppId: "+principalId);
		CreditApp creditAppPrincipal = null;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		
		if(principalId > 0){
			creditAppPrincipal=CreditAppLocalServiceUtil.getCreditApp(principalId);
		} else {
	       return;	
		}

		if("cancel".equalsIgnoreCase(actionType)){
			creditAppPrincipal.setCompanyId(user.getCompanyId());
			creditAppPrincipal.setUserId(user.getUserId());
			creditAppPrincipal.setUserName(user.getScreenName());
			creditAppPrincipal.setModifiedDate(new Date());
			creditAppPrincipal.setCreateDate(new Date());
			CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus("Cancelled");
			creditAppPrincipal.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
			
			CreditAppLocalServiceUtil.updateCreditApp(creditAppPrincipal);
			
			//request.getSession().setAttribute("creditAppPrincipalList",creditAppPrincipalList);
			return;
		}
		// Auditing Values
	   System.out.println("creditAppPrincipalList size: "+tempPrincipalList.size());

	
}

}
