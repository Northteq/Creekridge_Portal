package com.tamarack.liferay.payment;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
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
public class PaymentCalculatorTable extends MVCPortlet {
       
    /**
     * @see MVCPortlet#MVCPortlet()
     */
    public PaymentCalculatorTable() {
        super();
    }
    private static Log _log = LogFactory.getLog(PaymentCalculatorTable.class);

public  void submitPaymentCalculator(ActionRequest actionRequest,	ActionResponse actionResponse) throws Exception {
	
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
		String actionType = ParamUtil.getString(uploadRequest, "actionType");
		request.setAttribute("actionType",actionType);
		if( "calculatePaymentAmount".equalsIgnoreCase(actionType)) {
			   setPaymentCalculatorResults(actionRequest, actionResponse);
			   request.setAttribute("index", 1);
		 } else if( "createCreditAppOrProposal".equalsIgnoreCase(actionType) ||"updateCreditProposal".equalsIgnoreCase(actionType)) {
				createCreditOrProposal(actionRequest, actionResponse,user,true);
				request.setAttribute("index", 2);
		 } else {
		  CreditApp creditApp = null;
		  try {
			 
			  creditApp = CreditAppLocalServiceUtil.getCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
			  if(ParamUtil.getDouble(actionRequest,"equipmentPrice") != creditApp.getEquipmentPrice()) {
				  System.out.println("NEW EQUIPMENT PRICE: "+ParamUtil.getDouble(actionRequest,"equipmentPrice"));
				  recalculatePaymentCalculatorResults(actionRequest, actionResponse,creditApp.getCreditAppId(),ParamUtil.getDouble(actionRequest,"equipmentPrice"));
			  }
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
				creditApp.setCustomerBusinessIncorporatedState(uploadRequest.getParameter("customerBusinessIncorporatedState"));
				SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
				sdf.setLenient(true);
				Date customerBusinessStartDate = null;
				
				if(!"".equals(ParamUtil.getString(actionRequest,"customerBusinessStartDate"))){
				  try {
				       customerBusinessStartDate = sdf.parse(ParamUtil.getString(actionRequest,"customerBusinessStartDate"));
				  }
				  catch (Exception e){
					  sdf = new SimpleDateFormat("yyyy-dd-mm");
					  customerBusinessStartDate = sdf.parse(ParamUtil.getString(actionRequest,"customerBusinessStartDate"));
				  }
				  creditApp.setCustomerBusinessStartDate(customerBusinessStartDate);
				}
				creditApp.setCustomerBusinessType(uploadRequest.getParameter("customerBusinessType"));
				creditApp.setCustomerAddress1(ParamUtil.getString(actionRequest,"customerAddress1"));
				creditApp.setCustomerAddress2(ParamUtil.getString(actionRequest,"customerAddress1"));
				
				creditApp.setCustomerName(ParamUtil.getString(actionRequest,"customerName"));
				creditApp.setCustomerDBAName(ParamUtil.getString(actionRequest,"customerDBAName"));
				
				
				creditApp.setCustomerState(uploadRequest.getParameter("customerState"));
				creditApp.setCustomerCity(ParamUtil.getString(actionRequest,"customerCity"));
				creditApp.setCustomerZip(ParamUtil.getString(actionRequest,"customerZip"));
				creditApp.setEquipmentAddress1(ParamUtil.getString(actionRequest,"equipmentAddress1"));
				creditApp.setEquipmentAddress2(ParamUtil.getString(actionRequest,"equipmentAddress2"));
				creditApp.setEquipmentState(uploadRequest.getParameter("equipmentState"));
				creditApp.setEquipmentCity(ParamUtil.getString(actionRequest,"equipmentCity"));
				creditApp.setEquipmentZip(ParamUtil.getString(actionRequest,"equipmentZip"));
				creditApp.setEquipmentDesc(ParamUtil.getString(actionRequest,"equipmentDesc"));
				if("EquipmentLocationSameAsCustomer".equalsIgnoreCase(uploadRequest.getParameter("equipmentLocAsCustomerFlag"))){
				   creditApp.setEquipmentLocAsCustomerFlag(true);
				} else {
				   creditApp.setEquipmentLocAsCustomerFlag(false);
				}
					
				
				creditApp.setCustomerContact(ParamUtil.getString(actionRequest,"customerContact"));
				creditApp.setCustomerContactPhone(ParamUtil.getString(actionRequest,"customerContactPhone"));
				creditApp.setCustomerContactFax(ParamUtil.getString(actionRequest,"customerContactFax"));
				creditApp.setCustomerContactEmail(ParamUtil.getString(actionRequest,"customerContactEmail"));
				creditApp.setEquipmentPrice(ParamUtil.getDouble(actionRequest,"equipmentPrice"));
				request.setAttribute("customerBusinessDesc",ParamUtil.getString(actionRequest,"customerBusinessDesc"));
				request.setAttribute("customerBusinessFederalTaxID",ParamUtil.getString(actionRequest,"customerBusinessFederalTaxID"));
				request.setAttribute("customerBusinessIncorporatedState",uploadRequest.getParameter("customerBusinessIncorporatedState"));
				request.setAttribute("customerBusinessStartDate",ParamUtil.getString(actionRequest,"customerBusinessStartDate"));
				request.setAttribute("customerBusinessType",uploadRequest.getParameter("customerBusinessType"));
				request.setAttribute("customerAddress1",ParamUtil.getString(actionRequest,"customerAddress1"));
				request.setAttribute("customerAddress2",ParamUtil.getString(actionRequest,"customerAddress2"));
				
				request.setAttribute("customerName",ParamUtil.getString(actionRequest,"customerName"));
				request.setAttribute("customerDBAName",ParamUtil.getString(actionRequest,"customerDBAName"));
				request.setAttribute("customerContact",ParamUtil.getString(actionRequest,"customerContact"));
				request.setAttribute("customerContactPhone",ParamUtil.getString(actionRequest,"customerContactPhone"));
				request.setAttribute("customerContactFax",ParamUtil.getString(actionRequest,"customerContactFax"));
				request.setAttribute("customerContactEmail",ParamUtil.getString(actionRequest,"customerContactEmail"));
				
				
				request.setAttribute("customerState",uploadRequest.getParameter("customerState"));
				request.setAttribute("customerCity",ParamUtil.getString(actionRequest,"customerCity"));
				request.setAttribute("customerZip",ParamUtil.getString(actionRequest,"customerZip"));
				request.setAttribute("equipmentAddress1",ParamUtil.getString(actionRequest,"equipmentAddress1"));
				request.setAttribute("equipmentAddress2",ParamUtil.getString(actionRequest,"equipmentAddress2"));
				request.setAttribute("equipmentState",uploadRequest.getParameter("equipmentState"));
				request.setAttribute("equipmentCity",ParamUtil.getString(actionRequest,"equipmentCity"));
				request.setAttribute("equipmentZip",ParamUtil.getString(actionRequest,"equipmentZip"));
				request.setAttribute("equipmentDesc",ParamUtil.getString(actionRequest,"equipmentDesc"));
				request.setAttribute("equipmentLocAsCustomerFlag",creditApp.getEquipmentLocAsCustomerFlag()?"EquipmentLocationSameAsCustomer":"DifferentLocation");
				request.setAttribute("equipmentPrice",ParamUtil.getDouble(actionRequest,"equipmentPrice"));
				request.setAttribute("actionType",ParamUtil.getString(actionRequest,"actionType"));
				creditApp.setVendorId(themeDisplay.getScopeGroupId());
				CreditAppLocalServiceUtil.updateCreditApp(creditApp);
				request.getSession().setAttribute("creditAppId",creditApp.getCreditAppId());
				request.setAttribute("index", 2);
			    
				} catch (SystemException e) {
					
					_log.info(e.getMessage());
					e.printStackTrace();
				} catch (ParseException e) {
				
					_log.info(e.getMessage());
					e.printStackTrace();
				}
			}	
			
}

public  void createCreditOrProposal(ActionRequest actionRequest,	ActionResponse actionResponse, User user,boolean justUpdateProposal) throws Exception {
	   CreditApp creditApp = null;
	   String appStatus="";
	   ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	   boolean optionSelected=false;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);

		if(request.getSession().getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getSession().getAttribute("creditAppId").toString())) {
		   creditApp = CreditAppLocalServiceUtil.getCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
		   appStatus="Saved";
		} else  {
		  creditApp = CreditAppLocalServiceUtil.createCreditApp(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditApp.class.getName()));
		  appStatus="Draft";
		}
		
		// Auditing Values
		creditApp.setCompanyId(user.getCompanyId());
		creditApp.setUserId(user.getUserId());
		creditApp.setUserName(user.getScreenName());
		creditApp.setModifiedDate(new Date());
		creditApp.setCreateDate(new Date());
		CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus(appStatus);
		creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
		if(uploadRequest.getParameter("useForApplication") != null){
		  Long userForApplication=new Long(uploadRequest.getParameter("useForApplication"));
		  System.out.println("User Selected Option "+userForApplication);
		
		TempProposalOption tempProposalOption= new TempProposalOption();
 		@SuppressWarnings("unchecked")
		List<TempProposalOption> tempProposalList=(ArrayList<TempProposalOption>)request.getSession().getAttribute("proposalOptionList");
 		for (int i=0; i<tempProposalList.size(); i++){
 			 if(tempProposalList.get(i).getProposalId() ==userForApplication.longValue() ){
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
 		request.getSession().setAttribute("useForApplication",userForApplication.longValue());
		}
 		double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
 	    request.setAttribute("equipmentPrice",equipmentPrice);
 	    creditApp.setEquipmentPrice(equipmentPrice);
 	   if(request.getSession().getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getSession().getAttribute("creditAppId").toString())) {
 			CreditAppLocalServiceUtil.updateCreditApp(creditApp);
 			if(justUpdateProposal){
 				 updateProposalOption(actionRequest, actionResponse);
 			}
 	   } else {
 		  CreditAppLocalServiceUtil.addCreditApp(creditApp);	
 		  request.getSession().setAttribute("creditAppId",creditApp.getCreditAppId());
	      updateProposalOption(actionRequest, actionResponse);
 	   }
	  

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
    String regex = "[0-9]+";
    long tempProposalOptionId=0;
    while(it.hasNext()){
    	
        Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

        String key             = entry.getKey();
        String[] value         = entry.getValue();
          
          if(key.contains("termOption") && !key.contains("Checkbox")){
        	  if(value[0].toString().matches(regex)){
        	    termnameListResult.add(value[0].toString());
        	    termnameListMap.put(value[0].toString(), value[0].toString());
        	    System.out.println("  Term Option "+key + " Value " + value[0]); 
        	  }
        	
           }else if(key.contains("purchaseOption") && !key.contains("Checkbox")){
        	   if(value[0].toString().matches(regex)){
        	     purchaseOptionListResult.add(value[0].toString());
        	     purchaseOptionListMap.put(value[0].toString(), value[0].toString());
        	     System.out.println("  Purchase Option "+key + " Value " + value[0]); 
        	   }
        	  
           } else if(key.contains("productPricing")){
        	   if(value[0].toString().matches(regex)){
        		   productNameListResult.add(value[0].toString());
        	   	   productNameListMap.put(value[0].toString(), value[0].toString());
        	   	 System.out.println("  Product Option "+key + " Value " + value[0]); 
        	   } 
        	  
        	   
           } else if(key.contains("useForApplication")){
        	 
        	  
           }
    }  
    double equipmentPrice=ParamUtil.getDouble(actionRequest,"equipmentPrice");
    request.setAttribute("equipmentPrice",equipmentPrice);
    
   	request.getSession().setAttribute("termNameListResult",termnameListResult);
	request.getSession().setAttribute("purchaseOptionListResult",purchaseOptionListResult);
	request.getSession().setAttribute("productNameListResult",productNameListResult);
	request.getSession().setAttribute("termNameListMap",termnameListMap);
	request.getSession().setAttribute("purchaseOptionListMap",purchaseOptionListMap);
	request.getSession().setAttribute("productNameListMap",productNameListMap);
	double tempMinPrice=0.0;
	double paymentAmount=0.0;
	
	TempProposalOption tempproposal= new TempProposalOption();
	List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
	int globalIndex=0;
	for (int i=0;i<productNameListResult.size();i++){
		
		for (int j=0;j<purchaseOptionListResult.size();j++){
			
			for (int k=0;k<termnameListResult.size();k++){
				tempproposal= new TempProposalOption();
				    tempproposal.setProposalId(tempProposalOptionId);
					System.out.println("Matched Product Id: "+productNameListResult.get(i));
					tempproposal.setProductId(new Long(productNameListResult.get(i)).longValue());	
					System.out.println("Matched Purchase Id: "+purchaseOptionListResult.get(j));
					tempproposal.setPurchaseOptionId(new Long(purchaseOptionListResult.get(j)).longValue());
					System.out.println("Matched Term Id: "+termnameListResult.get(k));
					tempproposal.setTermId(new Long(termnameListResult.get(k)).longValue());
		     try{
			     RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(themeDisplay.getScopeGroupId(), true, tempproposal.getProductId(), tempproposal.getTermId(), tempproposal.getPurchaseOptionId());
			      if( rateFactorRule.getRateFactor() == 0.0 || rateFactorRule.getRateFactor() == 0) {
				     request.getSession().setAttribute("zeroRateFactor",PropsUtil.get("zeroRateFactor"));
				     return;
			       }
			        tempMinPrice=rateFactorRule.getMinPrice();
			        tempproposal.setRateFactorRuleId(rateFactorRule.getRateFactorRuleId());
			        tempproposal.setEquipmentPrice(equipmentPrice);
			        tempproposal.setProposalId(globalIndex++);
			        
			     if(equipmentPrice >= tempMinPrice){
					paymentAmount=(equipmentPrice/TermLocalServiceUtil.getTerm(tempproposal.getTermId()).getTermMonths()) * (1+rateFactorRule.getRateFactor());
					tempproposal.setPaymentAmount(paymentAmount);
				}
			     if(tempproposal.getProductId() > 0 && tempproposal.getTermId() > 0 && tempproposal.getPurchaseOptionId() > 0 ){
						
					    tempProposalList.add(tempproposal);
					   
					}
			     
		       } catch (Exception e){
					
				}
		          tempProposalOptionId=tempProposalOptionId+1;
			   }
			  }
			}
	     if (tempProposalList.size() > 0){
	    	 if(request.getSession().getAttribute("creditAppId") != null && !"".equalsIgnoreCase(request.getSession().getAttribute("creditAppId").toString())) {
	    	    deleteInsertNewCreditApplicationProposal(themeDisplay.getUser(), new Long(request.getSession().getAttribute("creditAppId").toString()).longValue(), actionRequest,tempProposalList);
	    	    createCreditOrProposal(actionRequest, actionResponse, themeDisplay.getUser(),false);
	    	 }
		      request.getSession().setAttribute("proposalOptionList",tempProposalList);
	     } else {
	    	  request.setAttribute("zeroRateFactor",PropsUtil.get("zeroRateFactor")); 
	     }
	   }


public void recalculatePaymentCalculatorResults (ActionRequest actionRequest,	ActionResponse actionResponse,long creditAppId, double equipmentPrice) throws Exception{
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
	 long tempProposalOptionId=0;
   
	double tempMinPrice=0.0;
	double paymentAmount=0.0;
	
	TempProposalOption tempproposal= new TempProposalOption();
	List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
	int globalIndex=0;
	
	 List<ProposalOption> proposalOptionList = ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditAppId);
	 for (int i=0; i<proposalOptionList.size(); i++){ 
		
		     try{
		    	 tempproposal= new TempProposalOption();
		    	 tempproposal.setIncludeInProposal(proposalOptionList.get(i).isIncludeInProposal());
                 tempproposal.setRateFactorRuleId(proposalOptionList.get(i).getRateFactorRuleId());
                 tempproposal.setProposalId(tempProposalOptionId);
		    	 tempproposal.setProductId(proposalOptionList.get(i).getProductId());
		    	 
		    	 tempproposal.setTermId(proposalOptionList.get(i).getTermId());
		    	 tempproposal.setPurchaseOptionId(proposalOptionList.get(i).getPurchaseOptionId());
			     RateFactorRule rateFactorRule= (RateFactorRule) RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(themeDisplay.getScopeGroupId(), true, tempproposal.getProductId(), tempproposal.getTermId(), tempproposal.getPurchaseOptionId());
			      if( rateFactorRule.getRateFactor() == 0.0 || rateFactorRule.getRateFactor() == 0) {
				     request.getSession().setAttribute("zeroRateFactor",PropsUtil.get("zeroRateFactor"));
				     return;
			       }
			        tempMinPrice=rateFactorRule.getMinPrice();
			        tempproposal.setRateFactorRuleId(rateFactorRule.getRateFactorRuleId());
			        tempproposal.setEquipmentPrice(equipmentPrice);
			        tempproposal.setProposalId(globalIndex++);
			        
			     if(equipmentPrice >= tempMinPrice){
					paymentAmount=(equipmentPrice/TermLocalServiceUtil.getTerm(tempproposal.getTermId()).getTermMonths()) * (1+rateFactorRule.getRateFactor());
					tempproposal.setPaymentAmount(paymentAmount);
				}
			     if(tempproposal.getProductId() > 0 && tempproposal.getTermId() > 0 && tempproposal.getPurchaseOptionId() > 0 ){
						
					    tempProposalList.add(tempproposal);
					   
					}
			     
		       } catch (Exception e){
					
				}
		          tempProposalOptionId=tempProposalOptionId+1;
			  
	       } 
	     if (tempProposalList.size() > 0){
	    	  deleteInsertNewCreditApplicationProposal(themeDisplay.getUser(), creditAppId, actionRequest, tempProposalList);
		      request.getSession().setAttribute("proposalOptionList",tempProposalList);
	     } else {
	    	  request.setAttribute("zeroRateFactor",PropsUtil.get("zeroRateFactor")); 
	     }
	   }
public  void updateCreditAppPrincipal(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
	   
	   TempPrincipal tempPrincipal = new TempPrincipal();
	   List<TempPrincipal> tempPrincipalList=new ArrayList<TempPrincipal>();
	   UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
 	   ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 	   User user = themeDisplay.getUser();
 	   String actionType = ParamUtil.getString(actionRequest, "principalActionType");
 	   Long principalId=ParamUtil.getLong(actionRequest,"creditAppPrincipalId");
 	   CreditAppPrincipal creditAppPrincipal = null;
 	   HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 	   request.setAttribute("actionType",actionType);
 	   request.setAttribute("index", 3);
 	   if(principalId > 0){
 			creditAppPrincipal=CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipal(principalId);
 		} else {
 		  creditAppPrincipal = CreditAppPrincipalLocalServiceUtil.createCreditAppPrincipal(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditAppPrincipal.class.getName()));
 		
 		}

 		if("delete".equalsIgnoreCase(actionType)){
 			CreditAppPrincipalLocalServiceUtil.deleteCreditAppPrincipal(principalId);
 			List<CreditAppPrincipal> creditAppPrincipalList= CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
 			for ( int i=0; i< creditAppPrincipalList.size();i++){
 				 tempPrincipal = new TempPrincipal();
 		 	     tempPrincipal.setPrincipalFirstName(creditAppPrincipalList.get(i).getPrincipalFirstName());
 		 	     tempPrincipal.setPrincipalSSN(creditAppPrincipalList.get(i).getPrincipalSSN());
 		 	     tempPrincipal.setPrincipalLastName(creditAppPrincipalList.get(i).getPrincipalLastName());
 		 	     tempPrincipal.setPrincipalId(creditAppPrincipalList.get(i).getPrincipalId());
 		 	     tempPrincipalList.add(tempPrincipal);
 	 	     }
 			request.setAttribute("creditAppPrincipalList",tempPrincipalList);
 			 request.setAttribute("index", 3);
 			return;
 		} 		
 		 if("view".equalsIgnoreCase(actionType)) {
  		 	request.setAttribute("principalAddress1",creditAppPrincipal.getPrincipalAddress1());
  		 	request.setAttribute("principalAddress2",creditAppPrincipal.getPrincipalAddress2());
  		 	request.setAttribute("principalState",creditAppPrincipal.getPrincipalState());
  		 	request.setAttribute("principalCity",creditAppPrincipal.getPrincipalCity());
  		 	request.setAttribute("principalZip",creditAppPrincipal.getPrincipalZip());
  		 	request.setAttribute("principalFirstName",creditAppPrincipal.getPrincipalFirstName());
  		 	request.setAttribute("principalLastName",creditAppPrincipal.getPrincipalLastName());
  		 	request.setAttribute("principalMiddleName",creditAppPrincipal.getPrincipalMiddleName());
  		 	request.setAttribute("principalSSN",creditAppPrincipal.getPrincipalSSN());
  		 	request.setAttribute("principalEmailAddress",creditAppPrincipal.getPrincipalEmail());
  		 	request.setAttribute("principalHomePhoneNumber",creditAppPrincipal.getPrincipalHomePhoneNumber());
  		 	request.setAttribute("principalId",creditAppPrincipal.getPrincipalId());
  		    request.setAttribute("index", 3);
  		 	return;
   		}
 		// Auditing Values

 		creditAppPrincipal.setCompanyId(user.getCompanyId());
 		creditAppPrincipal.setUserId(user.getUserId());
 		creditAppPrincipal.setUserName(user.getScreenName());
 		creditAppPrincipal.setModifiedDate(new Date());
 		creditAppPrincipal.setCreateDate(new Date());
 		
 		request.getSession().setAttribute("creditAppId",new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
 		creditAppPrincipal.setPrincipalAddress1(ParamUtil.getString(actionRequest,"principalAddress1"));
 		creditAppPrincipal.setPrincipalAddress2(ParamUtil.getString(actionRequest,"principalAddress2"));
 		creditAppPrincipal.setPrincipalState(uploadRequest.getParameter("principalState"));
 		creditAppPrincipal.setPrincipalCity(ParamUtil.getString(actionRequest,"principalCity"));
 		creditAppPrincipal.setPrincipalZip(ParamUtil.getString(actionRequest,"principalZip"));
 		creditAppPrincipal.setPrincipalFirstName(ParamUtil.getString(actionRequest,"principalFirstName"));
 		creditAppPrincipal.setPrincipalMiddleName(ParamUtil.getString(actionRequest,"principalMiddleName"));
 		creditAppPrincipal.setPrincipalLastName(ParamUtil.getString(actionRequest,"principalLastName"));
 		creditAppPrincipal.setPrincipalSSN(ParamUtil.getString(actionRequest,"principalSSN"));
 		creditAppPrincipal.setPrincipalEmail(ParamUtil.getString(actionRequest,"principalEmailAddress"));
 		creditAppPrincipal.setPrincipalHomePhoneNumber(ParamUtil.getString(actionRequest,"principalHomePhoneNumber"));
 		creditAppPrincipal.setCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
 		
 	    if("edit".equalsIgnoreCase(actionType) || principalId> 0) {
 		 	CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(creditAppPrincipal);
		}else {
  			CreditAppPrincipalLocalServiceUtil.addCreditAppPrincipal(creditAppPrincipal);	
 		}
 	     List<CreditAppPrincipal> creditAppPrincipalList=  CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
 	     
 	     for ( int i=0; i< creditAppPrincipalList.size();i++){
 	    	 tempPrincipal = new TempPrincipal();
 	    	 tempPrincipal.setPrincipalFirstName(creditAppPrincipalList.get(i).getPrincipalFirstName());
	 	     tempPrincipal.setPrincipalSSN(creditAppPrincipalList.get(i).getPrincipalSSN());
	 	     tempPrincipal.setPrincipalLastName(creditAppPrincipalList.get(i).getPrincipalLastName());
	 	     tempPrincipal.setPrincipalId(creditAppPrincipalList.get(i).getPrincipalId());
	 	     tempPrincipalList.add(tempPrincipal);
 	     }
 	    request.removeAttribute("creditAppPrincipalList");
 	    request.setAttribute("creditAppPrincipalList",tempPrincipalList);
 	    request.setAttribute("actionType","principalEntered");
 	    request.setAttribute("index", 3);
 	  
 	
 }

public  void updateProposalOption(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
  
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		ProposalOption proposalOption = null;
 		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		List<String> proposalListResult= new ArrayList<String>();
 		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
 		
 		Map<String,String[]> m=uploadRequest.getParameterMap();
 	    Set<Entry<String, String[]>> s = m.entrySet();
 	    Iterator<Entry<String, String[]>> it = s.iterator();
 	    
 	    while(it.hasNext()){
 	    	  
 	        Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
 	        String key             = entry.getKey();
 	        String[] value         = entry.getValue();
 	           if(key.contains("includeInProposal") && key.contains("Checkbox")){
 	        	 proposalListResult.add(value[0].toString());
 	        	System.out.println(" includeInProposal Key is "+key + " Value " + value[0]);   
 	        	 
 	        }  
 	    }
 		   long creditAppId= new Long(request.getSession().getAttribute("creditAppId").toString()).longValue();
 		   if("updateCreditProposal".equalsIgnoreCase((String)request.getAttribute("actionType"))) {
			 	 List<ProposalOption> proposalOptionList = ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditAppId);
				 for (int i=0; i<proposalOptionList.size(); i++){
				    // Auditing Values
					 proposalOption=proposalOptionList.get(i);
					 proposalOption.setCompanyId(user.getCompanyId());
					 proposalOption.setUserId(user.getUserId());
					 proposalOption.setUserName(user.getScreenName());
					 proposalOption.setModifiedDate(new Date());
					 proposalOption.setCreateDate(new Date());
					 //	Other fields
					 if(proposalListResult.contains(new Long(proposalOption.getProposalOptionId()).toString())){
					   proposalOption.setIncludeInProposal(true);
					 } else {
						 proposalOption.setIncludeInProposal(false); 
					 }
				
					 ProposalOptionLocalServiceUtil.updateProposalOption(proposalOption);
		
				 }
			 } else {
 			 @SuppressWarnings("unchecked")
 			 List<TempProposalOption> tempProposalList=(ArrayList<TempProposalOption>)request.getSession().getAttribute("proposalOptionList");
 			 for (int i=0; i<tempProposalList.size(); i++){
 					proposalOption = ProposalOptionLocalServiceUtil.createProposalOption(CounterLocalServiceUtil.increment(ProposalOption.class.getName()));
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
 					 proposalOption.setPaymentAmount(tempProposalList.get(i).getPaymentAmount());
 					 proposalOption.setEquipmentPrice(tempProposalList.get(i).getEquipmentPrice());
 					 if(proposalListResult.contains(new Long(tempProposalList.get(i).getProposalId()).toString())){
 					   proposalOption.setIncludeInProposal(true);
 					 } else {
 						 proposalOption.setIncludeInProposal(false); 
 					 }
 				
 					 ProposalOptionLocalServiceUtil.addProposalOption(proposalOption);
 		
 				 }
			 }
 			 request.setAttribute("index", 2);
 			 }
 		
 	

@Override
public void doView(RenderRequest renderRequest,	RenderResponse renderResponse) throws IOException, PortletException {

	HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	List<String> termnameList= new ArrayList<String>();
	List<String> purchaseOptionList= new ArrayList<String>();
	List<String> productNameList= new ArrayList<String>();
	try {
			
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
	request.setAttribute("productNameList",productNameList);
	
	for ( int i=0; i<termnameList1.size(); i++ ){
	     Term term =termnameList1.get(i);
	     termnameList.add(new Long(term.getTermId()).toString());
	 
	}
	
	renderRequest.setAttribute("termNameList",termnameList);
	request.setAttribute("termNameList",termnameList);
	
	for ( int j=0; j<purchaseOptionList1.size(); j++ ){
		PurchaseOption purchase =purchaseOptionList1.get(j);
		purchaseOptionList.add(new Long(purchase.getPurchaseOptionId()).toString());
			
		}
	
	renderRequest.setAttribute("purchaseOptionList",purchaseOptionList);
	request.setAttribute("purchaseOptionList",purchaseOptionList);
	System.out.println("ProductName List " +request.getAttribute("productNameListMap"));
	
	String passedCreditAppId=PortalUtil.getOriginalServletRequest(request).getParameter("creditAppId");
	System.out.println("passedCreditAppId " +passedCreditAppId);
	if(passedCreditAppId != null && !"".equalsIgnoreCase(passedCreditAppId)){
		
		Long viewCreditAppId = new Long(passedCreditAppId).longValue();
		request.getSession().setAttribute("creditAppId",viewCreditAppId); 
		try {
			viewEditSubmitCreditApplication(renderRequest, renderResponse, viewCreditAppId);
		} catch (NumberFormatException e1) {
			
			e1.printStackTrace();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	} else {
	String clearCalculatorResults=PortalUtil.getOriginalServletRequest(request).getParameter("clear");
	System.out.println("clearCalculatorResults " +clearCalculatorResults);
	
	  
	Map<String,String> termnameListMap= new HashMap<String, String>();
	Map<String,String> purchaseOptionListMap= new HashMap<String, String>();
	Map<String,String> productNameListMap= new HashMap<String, String>();
	List<String> termnameListResult= new ArrayList<String>();
	List<String> purchaseOptionListResult= new ArrayList<String>();
	List<String> productNameListResult= new ArrayList<String>();
	if("clear".equalsIgnoreCase(clearCalculatorResults)  || (request.getAttribute("actionType") == null && request.getHeader("referer").contains("payment-calculator"))) {
		    List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
		    System.out.println("proposalOption List " +request.getSession().getAttribute("proposalOptionList"));
			request.getSession().setAttribute("proposalOptionList",tempProposalList);
		    System.out.println("proposalOption List " +request.getSession().getAttribute("proposalOptionList"));
			request.setAttribute("actionType","");
		    request.getSession().setAttribute("creditAppId","");
		    request.getSession().setAttribute("termNameListMap",termnameListMap);
			request.getSession().setAttribute("purchaseOptionListMap",purchaseOptionListMap);
			request.getSession().setAttribute("productNameListMap",productNameListMap);
			request.getSession().setAttribute("termNameListResult",termnameListResult);
			request.getSession().setAttribute("purchaseOptionListResult",purchaseOptionListResult);
			request.getSession().setAttribute("productNameListResult",productNameListResult);
			request.setAttribute("index", 0);
		  }
 String bankAccountReferenceId=PortalUtil.getOriginalServletRequest(request).getParameter("bankAccountReferenceId");

	
	if(request.getSession().getAttribute("creditAppId") != null && request.getHeader("referer").contains("payment-calculator")){
		long creditAppId=new Long(request.getSession().getAttribute("creditAppId").toString()).longValue();
		CreditApp creditApp= CreditAppLocalServiceUtil.getCreditApp(creditAppId);
		viewEditSubmitCreditApplication(renderRequest, renderResponse, creditAppId);
		List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
		 if(request.getAttribute("creditAppPrincipalList") == null){
		    List<CreditAppPrincipal> creditAppPrincipalList= CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
			 if(creditAppPrincipalList != null && !creditAppPrincipalList.isEmpty()) {
				  request.removeAttribute("creditAppPrincipalList");
				  request.setAttribute("creditAppPrincipalList",creditAppPrincipalList);
				}     
		}
	    List<ProposalOption> creditAppProposalList= ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
		if(bankReferenceAccountList != null && !bankReferenceAccountList.isEmpty()) {
			TempBankAccount tempBankAccount = new TempBankAccount();
	 	    List<TempBankAccount> tempBankReferenceAccountList=new ArrayList<TempBankAccount>();
		   
		  for (int i=0;i<bankReferenceAccountList.size();i++){
			  tempBankAccount = new TempBankAccount();
			 tempBankAccount.setBankReferencAccountType(bankReferenceAccountList.get(i).getBankReferenceAccountType());
			 tempBankAccount.setBankReferenceName(bankReferenceAccountList.get(i).getBankReferenceName());
			 tempBankAccount.setBankReferenceAccountNumber(bankReferenceAccountList.get(i).getBankReferenceAccountNumber());
			 tempBankAccount.setBankReferenceContact(bankReferenceAccountList.get(i).getBankReferenceContact());
			 tempBankAccount.setBankReferencePhone(bankReferenceAccountList.get(i).getBankReferencePhone());
			 tempBankAccount.setBankReferenceId(bankReferenceAccountList.get(i).getBankReferenceId());
			 tempBankReferenceAccountList.add(tempBankAccount);
		 }
			
			request.setAttribute("bankReferenceAccountList",tempBankReferenceAccountList);
		    
		}
		
		request.getSession().setAttribute("creditApp",creditApp);
		request.setAttribute("proposalOptionList",creditAppProposalList);
		request.setAttribute("equipmentPrice",creditApp.getEquipmentPrice());
		
	} 
	
	if( "clear".equalsIgnoreCase(clearCalculatorResults)  || (request.getAttribute("actionType") == null && request.getHeader("referer").contains("payment-calculator")) ) {
		
		//For Payment Calc
		request.getSession().setAttribute("productList",new ArrayList<String>());
		request.getSession().setAttribute("purchaseOptionList",new ArrayList<String>());
		request.setAttribute("index", 0);
		
	}
	
	if("clear".equalsIgnoreCase(clearCalculatorResults)  || (request.getAttribute("actionType") == null && request.getHeader("referer").contains("payment-calculator"))) {
		request.getSession().setAttribute("termNameListResult",termnameListResult);
		request.getSession().setAttribute("purchaseOptionListResult",purchaseOptionListResult);
		request.getSession().setAttribute("productNameListResult",productNameListResult);
		request.setAttribute("index", 0);
	 }
	
	}
	}

	
	catch (Exception e){
		System.out.println(e.getMessage());
	 }
	String viewOnly=PortalUtil.getOriginalServletRequest(request).getParameter("viewOnly");
   if (viewOnly != null) {
	   include("/html/paymentcalculatortable/view_only.jsp", renderRequest, renderResponse);
   } else {
	super.doView(renderRequest, renderResponse);
   }
}
public List<RateFactorRule> fetchRatefactorOptionByProduct(ResourceRequest actionRequest, ResourceResponse actionResponse, List<String> productIdList,List<String> purchaseOptionIdList) throws Exception {
	
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	DynamicQuery rateFactorCriteriaQuery = DynamicQueryFactoryUtil.forClass(RateFactorRule.class, PortletClassLoaderUtil.getClassLoader());

	Criterion productCriteria = null;
	Criterion purchaseOptionCriteria = null;
	Criterion purchaseAndproductCriteria = null; 
	Criterion vendorIdCriteria = RestrictionsFactoryUtil.eq("vendorId",new Long(themeDisplay.getScopeGroupId()).longValue());
	Criterion activeFlagCriteria = RestrictionsFactoryUtil.eq("active",true);
	for (int i=0;i<productIdList.size();i++){
		if(i== 0 ){
		   productCriteria = RestrictionsFactoryUtil.eq("productId",new Long(productIdList.get(i)).longValue());
		} else {
		  productCriteria=RestrictionsFactoryUtil.or(productCriteria,RestrictionsFactoryUtil.eq("productId",new Long(productIdList.get(i)).longValue()));
		}
		
     }
	
	for (int i=0;i<purchaseOptionIdList.size();i++){
		if(i == 0 ){
			purchaseOptionCriteria = RestrictionsFactoryUtil.eq("purchaseOptionId",new Long(purchaseOptionIdList.get(i)).longValue());
		} else {
			purchaseOptionCriteria=RestrictionsFactoryUtil.or(purchaseOptionCriteria,RestrictionsFactoryUtil.eq("purchaseOptionId",new Long(purchaseOptionIdList.get(i)).longValue()));
		}
		
     }
	
	if(purchaseOptionCriteria != null) {
	   System.out.println("PurchaseOption Criteria ");
	   purchaseAndproductCriteria=RestrictionsFactoryUtil.and(productCriteria, purchaseOptionCriteria);
	   rateFactorCriteriaQuery.add(purchaseAndproductCriteria);
	} else {
		System.out.println("ProductOption Criteria ");
	   rateFactorCriteriaQuery.add(productCriteria);
	}
	
	rateFactorCriteriaQuery.add(vendorIdCriteria);
	rateFactorCriteriaQuery.add(activeFlagCriteria);
	@SuppressWarnings("unchecked")
	List<RateFactorRule> rateFactorRuleList=RateFactorRuleLocalServiceUtil.dynamicQuery(rateFactorCriteriaQuery);
	System.out.println("After query Criteria ");
	return rateFactorRuleList;
}

public  void updateCreditAppBankAccountReference(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	    TempBankAccount tempBankAccount = new TempBankAccount();
 	    List<TempBankAccount> tempBankReferenceAccountList=new ArrayList<TempBankAccount>();
	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 	    User user = themeDisplay.getUser();
 		CreditAppBankReference creditAppBankReference = null;
 		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		 request.setAttribute("index",4);
 		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
 		String actionType = ParamUtil.getString(actionRequest, "bankReferenceActionType");
 		request.setAttribute("actionType",actionType);
 		Long creditAppBankReferenceId=ParamUtil.getLong(actionRequest,"bankReferenceId");
 		if(creditAppBankReferenceId > 0){
 			creditAppBankReference=CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReference(creditAppBankReferenceId);
 		} else {
 			creditAppBankReference = CreditAppBankReferenceLocalServiceUtil.createCreditAppBankReference(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditAppBankReference.class.getName()));
 		
 		}
 		
 		if("delete".equalsIgnoreCase(actionType)){
 			CreditAppBankReferenceLocalServiceUtil.deleteCreditAppBankReference(creditAppBankReferenceId);
 			List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
 			 for (int i=0;i<bankReferenceAccountList.size();i++){
 				 tempBankAccount = new TempBankAccount();
 				 tempBankAccount.setBankReferencAccountType(bankReferenceAccountList.get(i).getBankReferenceAccountType());
 				 tempBankAccount.setBankReferenceName(bankReferenceAccountList.get(i).getBankReferenceName());
 				 tempBankAccount.setBankReferenceAccountNumber(bankReferenceAccountList.get(i).getBankReferenceAccountNumber());
 				 tempBankAccount.setBankReferenceContact(bankReferenceAccountList.get(i).getBankReferenceContact());
 				 tempBankAccount.setBankReferencePhone(bankReferenceAccountList.get(i).getBankReferencePhone());
 				 tempBankAccount.setBankReferenceId(bankReferenceAccountList.get(i).getBankReferenceId());
 				 tempBankReferenceAccountList.add(tempBankAccount);
 			 }
 	 		
 	 		 request.setAttribute("bankReferenceAccountList",tempBankReferenceAccountList);
 	 		 request.setAttribute("index", 4);
 			return;
 		}
 		
 		if("view".equalsIgnoreCase(actionType)){
 			request.setAttribute("bankReferenceAccountType",creditAppBankReference.getBankReferenceAccountType());
 			request.setAttribute("bankReferenceAccountNumber",creditAppBankReference.getBankReferenceAccountNumber());
 			request.setAttribute("bankReferenceAccountContact",creditAppBankReference.getBankReferenceContact());
 			request.setAttribute("bankReferenceAccountName",creditAppBankReference.getBankReferenceName());
 			request.setAttribute("bankReferenceAccountPhone",creditAppBankReference.getBankReferencePhone());
 			request.setAttribute("bankReferenceId",creditAppBankReference.getBankReferenceId());
 			 request.setAttribute("index", 4);
 			return;
 		}
 		// Auditing Values
 		creditAppBankReference.setCompanyId(user.getCompanyId());
 		creditAppBankReference.setUserId(user.getUserId());
 		creditAppBankReference.setUserName(user.getScreenName());
 		creditAppBankReference.setModifiedDate(new Date());
 		creditAppBankReference.setCreateDate(new Date());
 		
 		creditAppBankReference.setBankReferenceAccountType(uploadRequest.getParameter("bankReferenceAccountType"));
 		creditAppBankReference.setBankReferenceAccountNumber(ParamUtil.getString(actionRequest,"bankReferenceAccountNumber"));
 		creditAppBankReference.setBankReferenceContact(ParamUtil.getString(actionRequest,"bankReferenceAccountContact"));
 		creditAppBankReference.setBankReferenceName(ParamUtil.getString(actionRequest,"bankReferenceAccountName"));
 		creditAppBankReference.setBankReferencePhone(ParamUtil.getString(actionRequest,"bankReferenceAccountPhone"));
 		creditAppBankReference.setSequenceNumber(ParamUtil.getLong(actionRequest,"sequenceNumber"));
 		creditAppBankReference.setCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
 		if("edit".equalsIgnoreCase(actionType) || creditAppBankReferenceId > 0){
 			CreditAppBankReferenceLocalServiceUtil.updateCreditAppBankReference(creditAppBankReference);
 		} else { 
 		    CreditAppBankReferenceLocalServiceUtil.addCreditAppBankReference(creditAppBankReference);
 		}
 		
 		List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
		 for (int i=0;i<bankReferenceAccountList.size();i++){
			 tempBankAccount = new TempBankAccount();
			 tempBankAccount.setBankReferencAccountType(bankReferenceAccountList.get(i).getBankReferenceAccountType());
			 tempBankAccount.setBankReferenceName(bankReferenceAccountList.get(i).getBankReferenceName());
			 tempBankAccount.setBankReferenceAccountNumber(bankReferenceAccountList.get(i).getBankReferenceAccountNumber());
			 tempBankAccount.setBankReferenceContact(bankReferenceAccountList.get(i).getBankReferenceContact());
			 tempBankAccount.setBankReferencePhone(bankReferenceAccountList.get(i).getBankReferencePhone());
			 tempBankAccount.setBankReferenceId(bankReferenceAccountList.get(i).getBankReferenceId());
			 tempBankReferenceAccountList.add(tempBankAccount);
		 }
 		
 		request.setAttribute("bankReferenceAccountList",tempBankReferenceAccountList);
 		 request.setAttribute("index", 4);
     
 	 }

  
 public void viewEditSubmitCreditApplication(RenderRequest renderRequest,	RenderResponse renderResponse, long creditAppId) throws NumberFormatException, Exception{
	 HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	 TempBankAccount tempBankAccount = new TempBankAccount();
	 TempPrincipal tempPrincipal = new TempPrincipal();
	 TempProposalOption tempProposal= new TempProposalOption();
	 List<TempProposalOption> tempProposalList= new ArrayList<TempProposalOption>();
	 List<TempPrincipal> tempPrincipalList=new ArrayList<TempPrincipal>();
	 List<TempBankAccount> tempBankReferenceAccountList=new ArrayList<TempBankAccount>();
	    
     CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
     request.setAttribute("customerBusinessDesc",creditApp.getCustomerBusinessDesc());
	 request.setAttribute("customerBusinessFederalTaxID",creditApp.getCustomerBusinessFederalTaxID());
	 request.setAttribute("customerBusinessIncorporatedState",creditApp.getCustomerBusinessIncorporatedState());
	 if(creditApp.getCustomerBusinessStartDate() != null) {
		 SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		 sdf.setLenient(false);
	
		 try {
			 request.setAttribute("customerBusinessStartDate",sdf.format(creditApp.getCustomerBusinessStartDate()));
		  }
		  catch (Exception e){
			  sdf = new SimpleDateFormat("yyyy-dd-mm");
			  request.setAttribute("customerBusinessStartDate",sdf.format(creditApp.getCustomerBusinessStartDate()));
		  }
		 
	 }
	 request.setAttribute("customerBusinessType",creditApp.getCustomerBusinessType());
	 request.setAttribute("customerAddress1",creditApp.getCustomerAddress1());
	 request.setAttribute("customerAddress2",creditApp.getCustomerAddress2());
	
	request.setAttribute("customerName",creditApp.getCustomerName());
	request.setAttribute("customerDBAName",creditApp.getCustomerDBAName());
	request.setAttribute("customerContact",creditApp.getCustomerContact());
	request.setAttribute("customerContactPhone",creditApp.getCustomerContactPhone());
	request.setAttribute("customerContactFax",creditApp.getCustomerContactFax());
	request.setAttribute("customerContactEmail",creditApp.getCustomerContactEmail());
	
	
	request.setAttribute("customerState",creditApp.getCustomerState());
	request.setAttribute("customerCity",creditApp.getCustomerCity());
	request.setAttribute("customerZip",creditApp.getCustomerZip());
	request.setAttribute("equipmentAddress1",creditApp.getEquipmentAddress1());
	request.setAttribute("equipmentAddress2",creditApp.getEquipmentAddress2());
	request.setAttribute("equipmentState",creditApp.getEquipmentState());
	request.setAttribute("equipmentCity",creditApp.getEquipmentCity());
	request.setAttribute("equipmentZip",creditApp.getEquipmentZip());
	request.setAttribute("equipmentDesc",creditApp.getEquipmentDesc());
	request.setAttribute("equipmentLocAsCustomerFlag",creditApp.getEquipmentLocAsCustomerFlag()?"EquipmentLocationSameAsCustomer":"DifferentLocation");
	request.setAttribute("equipmentPrice",creditApp.getEquipmentPrice());
	
     List<ProposalOption> proposalList= ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditAppId);
      for (int i=0; i<proposalList.size();i++){
    	  tempProposal= new TempProposalOption();
    	  tempProposal.setPaymentAmount(proposalList.get(i).getPaymentAmount());
    	  tempProposal.setProductId(proposalList.get(i).getProductId());
    	  tempProposal.setPurchaseOptionId(proposalList.get(i).getPurchaseOptionId());
    	  tempProposal.setTermId(proposalList.get(i).getTermId());
    	  tempProposal.setRateFactorRuleId(proposalList.get(i).getRateFactorRuleId());
    	  tempProposal.setIncludeInProposal(proposalList.get(i).getIncludeInProposal());
    	  System.out.println("IncludeInProposal from the database: "+ proposalList.get(i).getIncludeInProposal());
    	  System.out.println("IncludeInProposal from the database with ProposalOptionId: "+ proposalList.get(i).getProposalOptionId());
    	  tempProposal.setProposalId(proposalList.get(i).getProposalOptionId());
    	  if(proposalList.get(i).getProductId() == creditApp.getProductId() && proposalList.get(i).getPurchaseOptionId() == creditApp.getPurchaseOptionId() && 
    			  proposalList.get(i).getTermId() == creditApp.getTermId() && proposalList.get(i).getRateFactorRuleId() == creditApp.getRateFactorRuleId()){
    		  tempProposal.setUseForApplication(true);
    		  //Remove if there is any in memory
    		  request.getSession().removeAttribute("useForApplication");
    	  }
    	  tempProposalList.add(tempProposal);
      }
      request.getSession().setAttribute("proposalOptionList",tempProposalList);
      
     List<CreditAppPrincipal> creditAppPrincipalList=  CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(creditApp.getCreditAppId());
     	for ( int i=0; i< creditAppPrincipalList.size();i++){
     		tempPrincipal = new TempPrincipal();	 
     		tempPrincipal.setPrincipalFirstName(creditAppPrincipalList.get(i).getPrincipalFirstName());
     		tempPrincipal.setPrincipalSSN(creditAppPrincipalList.get(i).getPrincipalSSN());
     		tempPrincipal.setPrincipalLastName(creditAppPrincipalList.get(i).getPrincipalLastName());
     		tempPrincipal.setPrincipalId(creditAppPrincipalList.get(i).getPrincipalId());
     		tempPrincipalList.add(tempPrincipal);
	     }
	    
	    request.setAttribute("creditAppPrincipalList",tempPrincipalList);
	    
	 List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(creditApp.getCreditAppId());
	    for (int i=0;i<bankReferenceAccountList.size();i++){
	    	tempBankAccount = new TempBankAccount();
	    	tempBankAccount.setBankReferencAccountType(bankReferenceAccountList.get(i).getBankReferenceAccountType());
	    	tempBankAccount.setBankReferenceName(bankReferenceAccountList.get(i).getBankReferenceName());
	    	tempBankAccount.setBankReferenceAccountNumber(bankReferenceAccountList.get(i).getBankReferenceAccountNumber());
	    	tempBankAccount.setBankReferenceContact(bankReferenceAccountList.get(i).getBankReferenceContact());
	    	tempBankAccount.setBankReferencePhone(bankReferenceAccountList.get(i).getBankReferencePhone());
	    	tempBankAccount.setBankReferenceId(bankReferenceAccountList.get(i).getBankReferenceId());
	    	tempBankReferenceAccountList.add(tempBankAccount);
	 }
		
		request.setAttribute("bankReferenceAccountList",tempBankReferenceAccountList);
 
 }
 
public List<TempBankAccount> deleteBankAccountReference (String bankAccountId,ResourceRequest resourceRequest) throws Exception{
	TempBankAccount tempBankAccount = new TempBankAccount();
	List<TempBankAccount> tempBankReferenceAccountList=new ArrayList<TempBankAccount>();
	CreditAppBankReferenceLocalServiceUtil.deleteCreditAppBankReference(new Long(bankAccountId).longValue());
	HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
	List<CreditAppBankReference> bankReferenceAccountList= CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
    for (int i=0;i<bankReferenceAccountList.size();i++){
    	 tempBankAccount = new TempBankAccount();
    	tempBankAccount.setBankReferencAccountType(bankReferenceAccountList.get(i).getBankReferenceAccountType());
    	tempBankAccount.setBankReferenceName(bankReferenceAccountList.get(i).getBankReferenceName());
    	tempBankAccount.setBankReferenceAccountNumber(bankReferenceAccountList.get(i).getBankReferenceAccountNumber());
    	tempBankAccount.setBankReferenceContact(bankReferenceAccountList.get(i).getBankReferenceContact());
    	tempBankAccount.setBankReferencePhone(bankReferenceAccountList.get(i).getBankReferencePhone());
    	tempBankAccount.setBankReferenceId(bankReferenceAccountList.get(i).getBankReferenceId());
    	tempBankReferenceAccountList.add(tempBankAccount);
 }
    request.setAttribute("bankReferenceAccountList",tempBankReferenceAccountList);
	return tempBankReferenceAccountList;	
}

public List<TempPrincipal> deleteCreditApplicationPrincipal (String principalId,ResourceRequest resourceRequest) throws Exception{
	TempPrincipal tempPrincipal = new TempPrincipal();
	List<TempPrincipal> tempPrincipalList=new ArrayList<TempPrincipal>();
	HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
	CreditAppPrincipal creditAppPrincipal=CreditAppPrincipalLocalServiceUtil.deleteCreditAppPrincipal(new Long(principalId).longValue());
	System.out.println(" Compare Principa Id and Principal Primary Key " +new Long(principalId).longValue() + " "+creditAppPrincipal.getPrincipalId()+" "+ creditAppPrincipal.getPrimaryKey());
	
	List<CreditAppPrincipal> creditAppPrincipalList= CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(new Long(request.getSession().getAttribute("creditAppId").toString()).longValue());
	System.out.println(" New Updated creditAppPrincipalList size " + creditAppPrincipalList.size());
	for ( int i=0; i< creditAppPrincipalList.size();i++){
			 tempPrincipal = new TempPrincipal();
			 tempPrincipal.setPrincipalFirstName(creditAppPrincipalList.get(i).getPrincipalFirstName());
	 	     tempPrincipal.setPrincipalSSN(creditAppPrincipalList.get(i).getPrincipalSSN());
	 	     tempPrincipal.setPrincipalLastName(creditAppPrincipalList.get(i).getPrincipalLastName());
	 	     tempPrincipal.setPrincipalId(creditAppPrincipalList.get(i).getPrincipalId());
	 	     tempPrincipalList.add(tempPrincipal);
	 	    System.out.println(" tempPrincipal " + tempPrincipal);
	     }
		System.out.println(" New Updated tempPrincipalList size " + tempPrincipalList.size());
		request.setAttribute("creditAppPrincipalList",tempPrincipalList);
	return tempPrincipalList;	
}

public void deleteInsertNewCreditApplicationProposal (User user,Long creditAppId, ActionRequest resourceRequest,List<TempProposalOption> tempProposalList) throws Exception{
		List<ProposalOption> creditAppPrincipalList= ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditAppId);
	    
		for ( ProposalOption proposalOption : creditAppPrincipalList ){
		     ProposalOptionLocalServiceUtil.deleteProposalOption(proposalOption);
	     }
	    for (int i=0; i<tempProposalList.size(); i++){
				ProposalOption proposalOption = ProposalOptionLocalServiceUtil.createProposalOption(CounterLocalServiceUtil.increment(ProposalOption.class.getName()));
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
				 proposalOption.setPaymentAmount(tempProposalList.get(i).getPaymentAmount());
				 proposalOption.setEquipmentPrice(tempProposalList.get(i).getEquipmentPrice());
			     ProposalOptionLocalServiceUtil.addProposalOption(proposalOption);
	
			 }
		 }
	
public void serveResource(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) throws IOException,	PortletException {
	   System.out.println("From serverResource");
	   JSONArray rateFactorTableJsonArray=JSONFactoryUtil.createJSONArray();
	   List<RateFactorRule> rateFactorList= new ArrayList<RateFactorRule>();
	   HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
	   request.setAttribute("actionType","ajax");
	   String productOptionId=PortalUtil.getOriginalServletRequest(request).getParameter("productOptionId");
	   String purchaseOptionId=PortalUtil.getOriginalServletRequest(request).getParameter("purchaseOptionId");
	   String bankAccountReferenceId = PortalUtil.getOriginalServletRequest(request).getParameter("bankAccountId");
	   String principalId = PortalUtil.getOriginalServletRequest(request).getParameter("principalId");
	   try {  
		   	if(bankAccountReferenceId != null){
		   		List<TempBankAccount> tempBankReferenceAccountList=deleteBankAccountReference(bankAccountReferenceId,resourceRequest);
		   		StringBuffer tempBankAccountString= null;
		   		for (TempBankAccount tempBankAccount:tempBankReferenceAccountList){
		   			tempBankAccountString= new StringBuffer();
		   		}
		   		
		   		return;
		   	}
		   	
	   
		   	if(principalId != null){
		   		List<TempPrincipal> tempPrincipalList=deleteCreditApplicationPrincipal(principalId,resourceRequest);
		   		StringBuffer tempPrincipalString= null;
		   		for (TempPrincipal tempPrincipal:tempPrincipalList){
		   			tempPrincipalString= new StringBuffer();
		   			tempPrincipalString.append("<tr valign=\"top\" >");
		   			tempPrincipalString.append("<td>"+tempPrincipal.getPrincipalLastName()+"</td>");
		   			tempPrincipalString.append("<td>"+tempPrincipal.getPrincipalFirstName()+"</td>");
		   			tempPrincipalString.append("<td>"+tempPrincipal.getPrincipalSSN()+"</td>");
		   			tempPrincipalString.append("<td><button  type=\"submit\"  name=\"Edit\" value=\"Edit\" onclick=\"javascript:assignPrincipalActionType('view','"+tempPrincipal.getPrincipalId() +"')\" ><img src='/CreekRidgeCapital-portlet/images/edit.png'/></button></td>");
		   			tempPrincipalString.append("<td><button  type=\"submit\"  name=\"Delete\" value=\"Delete\" onclick=\"javascript:deletePrincipal('"+tempPrincipal.getPrincipalId() +"')\" ><img src='/CreekRidgeCapital-portlet/images/remove.png' /></button></td>");
		   			tempPrincipalString.append("</tr><br>");
		   			rateFactorTableJsonArray.put(tempPrincipalString.toString());
		   			System.out.println("tempPrincipalString "+ tempPrincipalString.toString());
		   		}
		   		PrintWriter out=resourceResponse.getWriter();
		   		System.out.println("Temp Principal Returned Matched RateFactor Records "+ rateFactorTableJsonArray.toString());
		    	out.print(rateFactorTableJsonArray.toString());
		    	out.flush();
		    	out.close();
		   		return;
		   	}
	   } catch (Exception e){
		   //Need to handle exception
		   System.out.println(e.getMessage());
		   return;
	   }
	   String optionString="";
	  
	   List<String> productList= new ArrayList<String>();
	   List<String> purchaseOptionList= new ArrayList<String>();
	   if(productOptionId != null){
	   if ( request.getSession().getAttribute("productList") == null){
	       productList.add(productOptionId);
	       //request.getSession().setAttribute("productList", productList);
	       System.out.println("First time");
	       System.out.println("productOptionId " +productOptionId);
	   } else {
		   productList=(ArrayList<String>)request.getSession().getAttribute("productList");
		   if(productList.contains(productOptionId)){
			   System.out.println("Yes it existing");
			   productList.remove(productOptionId);
			     
		   } else {
			   productList.add(productOptionId);
			   System.out.println("First time");
		   }
		   
	    }
	     System.out.println("PurchaseOption List "+ productList.size());
   	     request.getSession().setAttribute("productList", productList);
	   } else if (purchaseOptionId != null) {
		   System.out.println("purchaseOptionId "+purchaseOptionId);
	       if ( request.getSession().getAttribute("purchaseOptionList") == null){
	    	   purchaseOptionList.add(purchaseOptionId);
	    	   //request.getSession().setAttribute("productList", productList);
	    	   System.out.println("First time");
	   	  } else {
	   		  purchaseOptionList=(ArrayList<String>)request.getSession().getAttribute("purchaseOptionList");
	   		   if(purchaseOptionList.contains(purchaseOptionId)){
			   System.out.println("Yes it existing");
			   purchaseOptionList.remove(purchaseOptionId);
			     
		     } else {
			   purchaseOptionList.add(purchaseOptionId);
			   System.out.println("First time");
		   }
		   
	      }
	      // System.out.println("Purchase Option List "+ purchaseOptionList.size());
   	       request.getSession().setAttribute("purchaseOptionList", purchaseOptionList);
   	       productList=(ArrayList<String>)request.getSession().getAttribute("productList");
   	      // System.out.println("Product Option List "+ productList.size());
	    }
	   try {
		   rateFactorList=fetchRatefactorOptionByProduct(resourceRequest,resourceResponse,productList, purchaseOptionList);
		   System.out.println("rateFactorList size "+ rateFactorList.size()); 
		    rateFactorTableJsonArray=JSONFactoryUtil.createJSONArray();
		    int i=0;
    		for (RateFactorRule rateFactorValue:rateFactorList){
    		
    			if(productOptionId != null){
    			   optionString="<input type='checkbox' onclick='javascript:getTermOption("+rateFactorValue.getPurchaseOptionId()+")' "+ " value='"+rateFactorValue.getPurchaseOptionId()+"' label=''"+" name='purchaseOption"+i +"' /> "+PurchaseOptionLocalServiceUtil.getPurchaseOption(new Long(rateFactorValue.getPurchaseOptionId()).longValue()).getPurchaseOptionName()+" <br>";
    				if (!"".equals(optionString) && !rateFactorTableJsonArray.toString().contains(new Long(rateFactorValue.getPurchaseOptionId()).toString())) {
        				rateFactorTableJsonArray.put(optionString);
        			}
    			} else if (purchaseOptionId != null && purchaseOptionList.size() > 0) {
    		       optionString="<input type='checkbox' value='"+rateFactorValue.getTermId()+"' label=''"+" name='termOption"+i +"' /> "+TermLocalServiceUtil.getTerm(new Long(rateFactorValue.getTermId()).longValue()).getTermName()+" <br>";
    		     	if (!"".equals(optionString) && !rateFactorTableJsonArray.toString().contains(new Long(rateFactorValue.getTermId()).toString())) {
    				rateFactorTableJsonArray.put(optionString);
    			    }		
    		     }
    			
    			i++;
    	}
	   
    	PrintWriter out=resourceResponse.getWriter();
    	System.out.println("Returned Matched RateFactor Records "+ rateFactorTableJsonArray.toString());
    	out.print(rateFactorTableJsonArray.toString());
    	out.flush();
    	out.close();
	   }
	   catch (Exception e){
		   
	   }
	super.serveResource(resourceRequest, resourceResponse);
  }
}
