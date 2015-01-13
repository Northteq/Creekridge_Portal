package com.tamarack.creekridge.liferay.paymentcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.mail.MailEngine;
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
public class PaymentCalculator extends MVCPortlet {

	/**
	 * @see MVCPortlet#MVCPortlet()
	 */
	public PaymentCalculator() {
		super();
		queryUtil = new PaymentCalculatorQueryUtil ();
		
	}

	private static Log _log = LogFactory.getLog(PaymentCalculator.class);
	private Long vendorId;
	private User currentUser;
	private ThemeDisplay themeDisplay;
	private List <ProposalOptionWrapper> proposalOptionList;
	private boolean hasProposalIncluded = false;
	private PaymentCalculatorQueryUtil queryUtil;
	
	
	@Override 
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		_log.info("render started");

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		//page variables available
		List<Product> productOptions = new ArrayList<Product>();
		CreditApp creditApp;
		
		themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		vendorId = themeDisplay.getLayout().getGroupId();
		currentUser = themeDisplay.getUser();
	
		try {
			List <RateFactorRule> rfrList = RateFactorRuleLocalServiceUtil.getRateFactorRuleByVendor(vendorId, true);
			
			if (rfrList != null) {
				
				Map <Long, Product> rfrSet = new HashMap <Long, Product> ();
				
				for (RateFactorRule rfr: rfrList) {
					if (!rfrSet.containsKey(rfr.getProductId()))
						rfrSet.put(rfr.getProductId(), ProductLocalServiceUtil.getProduct(rfr.getProductId()));
				}
				
				productOptions.addAll(rfrSet.values());
			}
			
			renderRequest.setAttribute("productOptions", productOptions);
				
			creditApp = (CreditApp) renderRequest.getAttribute("creditApp");
			if (creditApp == null) { //try page parameter
				
				String appId = httpReq.getParameter("creditAppId");
				
				if (appId == null) {//try namespace prefixed version
					appId = httpReq.getParameter(renderResponse.getNamespace()+"creditAppId");
				} 
				
				if (appId == null) {
					appId = httpReq.getParameter("creditAppId");
				}
				
				if (appId == null)
					appId = ParamUtil.getString(renderRequest, "creditAppId");
				
				if (appId != null && appId != "") {
					creditApp = CreditAppLocalServiceUtil.getCreditApp(new Long (appId));
				}
				
			} //else app was found
			
			_log.info("creditApp: " + creditApp);
			
			if (creditApp != null) {
				renderRequest.setAttribute("creditApp", creditApp);
				proposalOptionList = new ArrayList<ProposalOptionWrapper>();
				for (ProposalOption po: ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditApp.getCreditAppId())) {
					proposalOptionList.add (new ProposalOptionWrapper(po));
				}
	
				//need to figure out if we want to switch back to the action vs ajax
				renderRequest.setAttribute("proposalList", JSONFactoryUtil.looseSerialize(proposalOptionList));
				renderRequest.setAttribute("proposalOptionList", proposalOptionList);
			}
			
		} catch (Exception e) {
			_log.error("error in render");
			_log.error(e);
			e.printStackTrace();
		}
		super.render(renderRequest, renderResponse);
		_log.info("render ended");
	}

	public void submitApplication (ActionRequest actionRequest, ActionResponse actionResponse) {
		
		saveApplicationInfo (actionRequest, actionResponse);
		
		CreditApp creditApp = null;
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		try {
			
			creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			CreditAppStatus creditAppStatus = CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus("Submitted");
			creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
			CreditAppLocalServiceUtil.updateCreditApp(creditApp);
			
			PaymentCalculatorUtil.generateCreditAppXML(creditApp, getPortletContext().getRealPath("/"));
			
			//http://portaldevelopment.wordpress.com/2008/06/16/sending-email-in-liferay-portal/
			_log.info("Credit App has been submitted" + creditApp);
			SessionMessages.add(actionRequest, "appSubmitted");
			actionRequest.setAttribute("creditApp", creditApp);
			
			String from = currentUser.getEmailAddress();
			Group siteGroup = GroupLocalServiceUtil.getGroup(vendorId);
			String vendorName = siteGroup.getName();
			String to = (String) siteGroup.getExpandoBridge().getAttribute("Rep Email");
			 
			String subject= vendorName + " submitted an application for Customer: " + creditApp.getCustomerName();
			String body="An application (Application #:" + creditApp.getCreditAppId() + ") was submitted by " + vendorName +  " \n \n Please login to the vendor portal to view details at the link below: "; 
			body += themeDisplay.getPortalURL()+themeDisplay.getPathFriendlyURLPrivateGroup()+ "/" + themeDisplay.getLayout().getGroup().getName().toLowerCase();
			 
			MailEngine.send(from, to, subject, body);
			
			
		} catch (Exception e) {
			_log.error(e);
		}
		
	}
	
	public void saveAndExitApplication (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("saveAndExitApplication actionrequest started: ");
		try {
			saveApplicationInfo (actionRequest, actionResponse);
			
			
			//actionResponse.sendRedirect(PortalUtil.getCurrentURL(actionRequest));
			actionResponse.setRenderParameter("mvcPath", "/html/viewapplicationstable/view.jsp");
			
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "genericError");
			_log.error(e);
		}	
		
		_log.info("saveAndExitApplication actionrequest ended: ");
	}
	
	public void manageDocs (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("managedocs actionrequest started: ");
		try {
			saveApplicationInfo (actionRequest, actionResponse);
			_log.info("managedocs creditapp: " + ParamUtil.getLong(actionRequest, "creditAppId"));
			actionResponse.setRenderParameter("jspPage", "/html/manageDocument/view.jsp?creditAppId=" + ParamUtil.getLong(actionRequest, "creditAppId"));
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "genericError");
			_log.error(e);
		}	
		
		_log.info("manageDocs actionrequest ended: ");
	}
	
	
	
	public void saveApplicationInfo (ActionRequest actionRequest, ActionResponse actionResponse) {

		CreditApp creditApp = null;
		hasProposalIncluded = false;
		_log.info("saveApplicationInfo actionrequest started: ");
		
		try {
			long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
			_log.info("saveApplicationInfo creditAppId: " + creditAppId);
			
			if (creditAppId != 0)
				creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			
			if (actionRequest.getMethod() == "GET") {
				actionRequest.setAttribute("creditApp", creditApp);
				return;
			}
			
			if (creditApp == null) {
				creditApp = CreditAppLocalServiceUtil.addCreditApp (currentUser, themeDisplay);
				_log.info("Application has been created. " + creditApp);
				creditApp.setCreditAppStatusId(1);
			} else {
				_log.info("Application has been updated. " + creditApp);
			}
			
			creditApp = PaymentCalculatorUtil.populateAppFromRequest(actionRequest, creditApp);
			
			//process proposalOptions
			 if (proposalOptionList != null && !proposalOptionList.isEmpty()) {
				_log.info("proposalOptionList is populated: " + proposalOptionList.size());
				
				for (ProposalOptionWrapper pow: proposalOptionList) {
					_log.info("pow.propOption: " + pow.propOption);
					
					pow.propOption.setCreditAppId(creditApp.getCreditAppId());
					pow.propOption = ProposalOptionLocalServiceUtil.updateProposalOption(pow.propOption);
					
					if (pow.propOption.getIncludeInProposal()) {
						hasProposalIncluded = true;
					}
					
					if (pow.propOption.getUseForCreditApp()) {
						creditApp.setPaymentAmount(pow.propOption.getPaymentAmount());
						creditApp.setTermId(pow.propOption.getTermId());
						creditApp.setProductId(pow.propOption.getProductId());
						creditApp.setPurchaseOptionId(pow.propOption.getPurchaseOptionId());
						creditApp.setRateFactorRuleId(pow.propOption.getRateFactorRuleId());
						creditApp.setEquipmentPrice(pow.eqPrice);
					}
				}
			}
			
			//validations 
			if (!hasProposalIncluded) {
				SessionErrors.add(actionRequest, "errorProposalRequired");	
				creditApp.setCreditAppStatusId(1);
				actionResponse.setRenderParameter("openSection", "pricingOverview");
				
			} else if (proposalOptionList == null || proposalOptionList.isEmpty()) {
				_log.info("proposalOptionList is empty");
				SessionErrors.add(actionRequest, "runCalculatorRequired");
				creditApp.setCreditAppStatusId(1);
				actionResponse.setRenderParameter("openSection", "pricingOverview");
			} else {
				SessionMessages.add(actionRequest, "appSaved");
				creditApp.setCreditAppStatusId(2);
				actionResponse.setRenderParameter("openSection", "customerAndEquipmentInfo");
			}
			
			//update app info
			creditApp.setModifiedDate(new Date());
			creditApp = CreditAppLocalServiceUtil.updateCreditApp(creditApp);
			
		} catch (Exception e) {
			_log.error(e);
		}
	
		
		actionRequest.setAttribute("creditApp", creditApp);
		//actionResponse.setRenderParameter("creditAppId", String.valueOf(creditApp.getCreditAppId()));
	}
	
	public List<ProposalOptionWrapper> calculatePayments(String selectedOptions) throws Exception {
		
		List <RateFactorRule> rateFactorRuleList = new ArrayList <RateFactorRule> ();

		JSONObject selectedOptionsObject = JSONFactoryUtil.createJSONObject(selectedOptions);
		JSONArray productIdList = selectedOptionsObject.getJSONArray("products");		
		JSONArray purchaseOptionIdList = selectedOptionsObject.getJSONArray("purchaseOptions");
		JSONArray termIdList = selectedOptionsObject.getJSONArray("termOptions");
		long creditAppId = selectedOptionsObject.getLong("creditAppId");
		_log.info("recalculating po for creditAppId: " + creditAppId);
		
		if (creditAppId != 0) {
			List <ProposalOption> existingPOList = ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditAppId);
			_log.info(" po for creditAppId existingPOList size =" + existingPOList.size());
			if (existingPOList != null) {
				for (ProposalOption po : existingPOList) {
					_log.info("Deleting po : " + ProposalOptionLocalServiceUtil.deleteProposalOption(po));
				}
			}
			
			CreditApp creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			creditApp.setRateFactorRuleId(0);
			creditApp.setTermId(0);
			creditApp.setProductId(0);
			creditApp.setPurchaseOptionId(0);
			creditApp = CreditAppLocalServiceUtil.updateCreditApp(creditApp);
		}
		
		_log.info("Price from calculator :  " + selectedOptionsObject.getString("equipmentPrice"));
		Long equipmentPrice = PaymentCalculatorUtil.getLongFromCurrency(selectedOptionsObject.getString("equipmentPrice"));

		//build query for terms
		if (termIdList.length()>0) {
			for (int i = 0; i < termIdList.length(); i++) {
				for (int j = 0; j < purchaseOptionIdList.length(); j++) {
					for (int k = 0; k < productIdList.length(); k++) {
						List <RateFactorRule> tempRfRList = new ArrayList <RateFactorRule> ();
						tempRfRList = queryUtil.fetchRatefactorOptionForCalculations(productIdList.getLong(k), purchaseOptionIdList.getLong(j), termIdList.getLong(i), equipmentPrice, vendorId);
						if (!tempRfRList.isEmpty()) {
							rateFactorRuleList.add(tempRfRList.get(0));
						}
					}
				}
			}	
		}
		
		
		proposalOptionList = new ArrayList <ProposalOptionWrapper> ();
		
		for (RateFactorRule rate: rateFactorRuleList) {
			ProposalOption proposalOption = ProposalOptionLocalServiceUtil.addProposalOption(currentUser, themeDisplay);
			
			proposalOption.setRateFactorRuleId(rate.getRateFactorRuleId());
			proposalOption.setProductId(rate.getProductId());
			proposalOption.setPurchaseOptionId(rate.getPurchaseOptionId());
			proposalOption.setTermId(rate.getTermId());
			proposalOption.setRateFactorRuleId(rate.getRateFactorRuleId());
			 
			Term tempTerm = TermLocalServiceUtil.getTerm(rate.getTermId());
			 
			Double paymentAmount = (equipmentPrice/tempTerm.getTermMonths()) * (1+rate.getRateFactor()) ;
			 
			proposalOption.setPaymentAmount(paymentAmount);
			proposalOption.setEquipmentPrice(equipmentPrice);
			proposalOptionList.add(new ProposalOptionWrapper(proposalOption)); 
		}
		
		if (proposalOptionList.size()==1){
			proposalOptionList.get(0).propOption.setIncludeInProposal(true);
			proposalOptionList.get(0).propOption.setUseForCreditApp(true);
		}
		
		return proposalOptionList;
		
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		List <RateFactorRule> rateFactorList = new ArrayList <RateFactorRule>();
		List <PurchaseOption> purchaseOptionList = new ArrayList <PurchaseOption> ();
		List <Term> termList = new ArrayList <Term> ();
		
		_log.info(resourceRequest.getResourceID());
		
		String selectedOptionsParam = PortalUtil.getOriginalServletRequest(request).getParameter("selectedOptions");
		
		if (selectedOptionsParam != null) {
			try {
				//rateFactorList = fetchRatefactorOption(selectedOptionsParam);
				rateFactorList = queryUtil.fetchRatefactorOption(selectedOptionsParam, vendorId);
			} catch (Exception e) {
				_log.error (e);
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
		}
		
		if (resourceRequest.getResourceID().equalsIgnoreCase(
				"processProductsSelection")) {
			try {
				_log.info ("processProductsSelection rateFactorList size " + rateFactorList.size());
				Set <Long> poSet = new HashSet <Long> ();
				for (RateFactorRule rateFactorValue : rateFactorList) {
					_log.info(rateFactorValue);
					if (!poSet.contains(rateFactorValue.getPurchaseOptionId())) {
						poSet.add(rateFactorValue.getPurchaseOptionId());
						PurchaseOption po = PurchaseOptionLocalServiceUtil.getPurchaseOption(rateFactorValue.getPurchaseOptionId());
						purchaseOptionList.add(po);
					} 
				}
			} catch (Exception e) {
				_log.error(e.getMessage());
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
			resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(purchaseOptionList));
		}
		
		if (resourceRequest.getResourceID().equalsIgnoreCase(
				"processPurchaseOptionsSelection")) {
			try {
				
				_log.info ("rateFactorList size " + rateFactorList.size());
				Set <Long> termSet = new HashSet <Long> ();
				for (RateFactorRule rateFactorValue : rateFactorList) {
					_log.info(rateFactorValue);
					if (!termSet.contains(rateFactorValue.getTermId())) {
						termSet.add(rateFactorValue.getTermId());
						Term term = TermLocalServiceUtil.getTerm(new Long(rateFactorValue.getTermId()).longValue());
						termList.add(term);
					} 
				}
				
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(termList));
			} catch (Exception e) {
				_log. error(e);
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
		} else if (resourceRequest.getResourceID().equalsIgnoreCase(
				"calculatePayments")) {
			try {
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(calculatePayments(selectedOptionsParam)));
			} catch (Exception e) {
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
				_log. error(e);
			}
		} else if (resourceRequest.getResourceID().equalsIgnoreCase(
				"updateUseForApplication")) {
			
			String selectedProposalOptionId = PortalUtil.getOriginalServletRequest(request).getParameter("proposalOptionId");
			
			if (selectedProposalOptionId != null) {
				for (ProposalOptionWrapper pow: proposalOptionList) {
					if (pow.propOption.getProposalOptionId() == Long.valueOf(selectedProposalOptionId)) {
						pow.propOption.setUseForCreditApp(true);
						pow.propOption.setIncludeInProposal(true);
					} else {
						pow.propOption.setUseForCreditApp(false);
					}
				}	
				resourceResponse.getWriter().write("{\"proposalOptionId\": \"" + selectedProposalOptionId + "\"}");
			} else {
				resourceResponse.getWriter().write("{ \"error\": \"selectedProposalOptionId not found " + selectedProposalOptionId + "\"}");
			}
		} else if (resourceRequest.getResourceID().equalsIgnoreCase("updateIncludeInProposal")) {
			String selectedProposalOptionId = PortalUtil.getOriginalServletRequest(request).getParameter("purchaseOptionId");
			String selectedValue = PortalUtil.getOriginalServletRequest(request).getParameter("selectedValue");
		
			for (ProposalOptionWrapper pow: proposalOptionList) {
				if (pow.propOption.getProposalOptionId() == Long.valueOf(selectedProposalOptionId)) {
					pow.propOption.setIncludeInProposal(Boolean.valueOf(selectedValue));
				}
				
				if (Boolean.valueOf(selectedValue) == false) {
					pow.propOption.setUseForCreditApp(false);
				}
			}	
			resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(proposalOptionList));
		} else if (resourceRequest.getResourceID().equalsIgnoreCase("createPrincipalRecord"))	 {
			
			
			String principalJson = PortalUtil.getOriginalServletRequest(request).getParameter("principal");
			
			_log.info("createPrincipalRecord request: " + principalJson);
			
			CreditAppPrincipal principal;
			try {
				
				JSONObject principalJObj = JSONFactoryUtil.createJSONObject(principalJson);
				_log.info(principalJObj.getLong("principalId"));
				if (principalJObj.getLong("principalId") == 0) {
					_log.info("new record");
					principal = CreditAppPrincipalLocalServiceUtil.addCreditAppPrincipal(currentUser, themeDisplay);
					
				} else {
					_log.info("update record");
					principal = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipal(Long.valueOf(principalJObj.getString("principalId")));
				}
				
				principal = PaymentCalculatorUtil.populatePrincipalFromJsonString(principalJson, principal);
				principal = CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(principal);
				
				List <CreditAppPrincipal> principals = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(principalJObj.getLong("creditAppId"));
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(principals));
				
			} catch (Exception e) {
				_log.error(e);
				resourceResponse.getWriter().write((JSONFactoryUtil.looseSerialize(e)));
			}
			
		} else if (resourceRequest.getResourceID().equalsIgnoreCase("deletePrincipalRecord"))	 {
			String principalJson = PortalUtil.getOriginalServletRequest(request).getParameter("principal");
			try {
				JSONObject principalJObj = JSONFactoryUtil.createJSONObject(principalJson);
				if (principalJObj.getLong("principalId") != 0) {
					CreditAppPrincipalLocalServiceUtil.deleteCreditAppPrincipal(principalJObj.getLong("principalId"));
					
				}
				List <CreditAppPrincipal> principals = CreditAppPrincipalLocalServiceUtil.getCreditAppPrincipalByCreditAppId(principalJObj.getLong("creditAppId"));
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(principals));
			} catch (Exception e) {
				_log.error(e);
				resourceResponse.getWriter().write((JSONFactoryUtil.looseSerialize(e)));
			}
		}  else if (resourceRequest.getResourceID().equalsIgnoreCase("createReferenceRecord"))	 {
			
			String referenceJson = PortalUtil.getOriginalServletRequest(request).getParameter("reference");
			
			_log.info("createReferenceRecord request: " + referenceJson);
			
			
			CreditAppBankReference reference;
			try {
				
				JSONObject referenceJObj = JSONFactoryUtil.createJSONObject(referenceJson);
				long bankReferenceId = referenceJObj.getLong("bankReferenceId");
				
				if (bankReferenceId == 0) {
					_log.info("new record");
					reference = CreditAppBankReferenceLocalServiceUtil.addCreditAppBankReference(currentUser, themeDisplay);
					
				} else {
					_log.info("update record");
					reference = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReference(bankReferenceId);
				}
				
				reference = PaymentCalculatorUtil.populateBankReferenceFromJsonString(referenceJson, reference);
				reference = CreditAppBankReferenceLocalServiceUtil.updateCreditAppBankReference(reference);
				
				List <CreditAppBankReference> references = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(referenceJObj.getLong("creditAppId"));
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(references));
				
			} catch (Exception e) {
				_log.error(e);
				resourceResponse.getWriter().write((JSONFactoryUtil.looseSerialize(e)));
			}
			
		}else if (resourceRequest.getResourceID().equalsIgnoreCase("deleteReferenceRecord"))	 {
			String referenceJson = PortalUtil.getOriginalServletRequest(request).getParameter("reference");
			
			try {
				JSONObject referenceJObj = JSONFactoryUtil.createJSONObject(referenceJson);
				long bankReferenceId = referenceJObj.getLong("bankReferenceId");
				if (bankReferenceId != 0) {
					CreditAppBankReferenceLocalServiceUtil.deleteCreditAppBankReference(bankReferenceId);
					
				}
				
				List <CreditAppBankReference> references = CreditAppBankReferenceLocalServiceUtil.getCreditAppBankReferenceByCreditApp(referenceJObj.getLong("creditAppId"));
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(references));
			} catch (Exception e) {
				_log.error(e);
				resourceResponse.getWriter().write((JSONFactoryUtil.looseSerialize(e)));
			}
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	//needed for the js table to be able to display product names instead of IDs
	public class ProposalOptionWrapper {
		public ProposalOption propOption;
		public String termName;
		public String productName;
		public String prodOptionName;
		public Double eqPrice;
		public Double paymentAmount;
	
		public Long proposalOptionId;
		
		public ProposalOptionWrapper (ProposalOption propOption) {
			this.propOption = propOption;
			try {
				this.proposalOptionId = propOption.getProposalOptionId();
				this.termName = TermLocalServiceUtil.getTerm(propOption.getTermId()).getTermName();
				this.productName = ProductLocalServiceUtil.getProduct(propOption.getProductId()).getProductName();
				this.prodOptionName = PurchaseOptionLocalServiceUtil.getPurchaseOption(propOption.getPurchaseOptionId()).getPurchaseOptionName();
				this.eqPrice = propOption.getEquipmentPrice();
				this.paymentAmount = propOption.getPaymentAmount();
				
				
			} catch (SystemException e) {
				_log.error(e);
				e.printStackTrace();
			} catch (PortalException e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
	}
}