package com.tamarack.creekridge.liferay.paymentcalculator;

import java.io.IOException;
<<<<<<< HEAD
<<<<<<< HEAD
import java.text.SimpleDateFormat;
=======

>>>>>>> master
=======
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
import javax.portlet.PortletRequest;
=======

>>>>>>> master
=======
>>>>>>> master
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.liferay.portal.kernel.mobile.device.rulegroup.ActionHandlerManagerUtil;
=======
>>>>>>> master
=======
import com.liferay.portal.kernel.portlet.LiferayWindowState;
>>>>>>> master
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
=======
>>>>>>> master
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
<<<<<<< HEAD
<<<<<<< HEAD
import com.tamarack.creekridge.model.CreditAppStatus;
=======
>>>>>>> master
=======
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.CreditAppStatus;
>>>>>>> master
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;
<<<<<<< HEAD
<<<<<<< HEAD
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
=======
>>>>>>> master
=======
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
>>>>>>> master
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
<<<<<<< HEAD
	private  Long vendorId;
	private  User currentUser;
	private List <ProposalOptionWrapper> proposalOptionList;
	private CreditApp creditApp;
=======
	private Long vendorId;
	private User currentUser;
	private ThemeDisplay themeDisplay;
	private List <ProposalOptionWrapper> proposalOptionList;
<<<<<<< HEAD

>>>>>>> master
=======
>>>>>>> master
	private boolean hasProposalIncluded = false;
	private PaymentCalculatorQueryUtil queryUtil;
	private boolean showPrincipals = true;//show per user story
	private boolean showBankRefs = true; //show per user story
	private String customPaymentAmountMessage = "";
	
	@Override 
	public void render (RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		showPrincipals = true;
		showBankRefs = true;
		customPaymentAmountMessage = "";
		
		_log.info("render started");

		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		//page variables available
		List<Product> productOptions = new ArrayList<Product>();
<<<<<<< HEAD
		creditApp = null;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
=======
		CreditApp creditApp;
		
		themeDisplay = (ThemeDisplay) renderRequest
>>>>>>> master
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		vendorId = themeDisplay.getLayout().getGroupId();
		currentUser = themeDisplay.getUser();
		
		Group siteGroup;
		
		try {
			siteGroup = GroupLocalServiceUtil.getGroup(vendorId);
			_log.info("sitegroup:  " + siteGroup);
			
			
			if (siteGroup.getExpandoBridge().getAttribute("Include Bank References") != null) {
				
				showBankRefs = (Boolean) siteGroup.getExpandoBridge().getAttribute("Include Bank References");
				_log.info("showBankRefs:  " + showBankRefs);
			}
			
			if (siteGroup.getExpandoBridge().getAttribute("Include Principals") != null) {
				showPrincipals = (Boolean) siteGroup.getExpandoBridge().getAttribute("Include Principals");
				_log.info("showPrincipals:  " + showPrincipals);
			}
			
			if (!String.valueOf(siteGroup.getExpandoBridge().getAttribute("Rep Name")).isEmpty()
					&& !String.valueOf(siteGroup.getExpandoBridge().getAttribute("Rep Phone")).isEmpty()) {
				
				
					customPaymentAmountMessage = "Please call ";
					customPaymentAmountMessage += siteGroup.getExpandoBridge().getAttribute("Rep Name").toString();
					customPaymentAmountMessage += " at ";
					customPaymentAmountMessage +=  siteGroup.getExpandoBridge().getAttribute("Rep Phone").toString();
					customPaymentAmountMessage += " for Payment Amount";
			
			} else {
				customPaymentAmountMessage = "Please submit a <a href=\"contact\" target=\"_blank\">contact form</a> for payment amount information on this pricing option.";
			}
			
			_log.info("customPaymentAmountMessage:  " + customPaymentAmountMessage);
			
		} catch (Exception ex) {
			_log.error ("error getting values from custom fields - " + ex);
		}
		
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
<<<<<<< HEAD
			
<<<<<<< HEAD
			Long creditAppId = ParamUtil.getLong(renderRequest, "creditAppId");
				
			_log.info("creditAppId: " + creditAppId);
			if (creditAppId != 0) {
				creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			}
			
			if (creditApp != null) {
			
				
				_log.info("credit app not null " + creditApp);
				renderRequest.setAttribute("creditApp", creditApp);
				renderRequest.setAttribute("creditAppId", creditApp.getCreditAppId());
=======
			
=======
>>>>>>> master
				
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
<<<<<<< HEAD
>>>>>>> master
				
				//populate proposal options if any
				List <ProposalOptionWrapper> powList = new ArrayList<ProposalOptionWrapper>();
				
=======
				proposalOptionList = new ArrayList<ProposalOptionWrapper>();
>>>>>>> master
				for (ProposalOption po: ProposalOptionLocalServiceUtil.getProposalOptionByCreditAppId(creditApp.getCreditAppId())) {
					proposalOptionList.add (new ProposalOptionWrapper(po));
				}
	
				//need to figure out if we want to switch back to the action vs ajax
				renderRequest.setAttribute("proposalList", JSONFactoryUtil.looseSerialize(proposalOptionList));
				renderRequest.setAttribute("proposalOptionList", proposalOptionList);
			}
			
<<<<<<< HEAD
<<<<<<< HEAD
			 
			_log.info("render creditApp : " + creditApp);
=======
>>>>>>> master
				
		} catch (Exception e) {
			_log.error(e);
		}
		
<<<<<<< HEAD
		
=======
>>>>>>> master
=======
		} catch (Exception e) {
			_log.error("error in render");
			_log.error(e);
			e.printStackTrace();
		}
<<<<<<< HEAD
>>>>>>> master
		super.render(renderRequest, renderResponse);
		_log.info("render ended");
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		
		_log.info("doView started");
		
		super.doView(renderRequest, renderResponse);
		
		_log.info("doView started ended");
	}
=======

>>>>>>> master

=======
>>>>>>> master
	
	//	ADD CREDIT REFERENCE 
	public void addCreditAppBankReference (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("addCreditAppBankReference started");
=======
		
		renderRequest.setAttribute("showBankRefs", showBankRefs);
		renderRequest.setAttribute("showPrincipals", showPrincipals);
		renderRequest.setAttribute("customPaymentAmountMessage", customPaymentAmountMessage);
		
		super.render(renderRequest, renderResponse);
		_log.info("render ended");
	}

	public void submitApplication (ActionRequest actionRequest, ActionResponse actionResponse) {
>>>>>>> master
		
		saveApplicationInfo (actionRequest, actionResponse);
		
		CreditApp creditApp = null;
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		try {
			
			creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			CreditAppStatus creditAppStatus = CreditAppStatusLocalServiceUtil.getCreditAppStatusByStatus("Submitted");
			creditApp.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
			CreditAppLocalServiceUtil.updateCreditApp(creditApp);
			
			//http://portaldevelopment.wordpress.com/2008/06/16/sending-email-in-liferay-portal/
			_log.info("Credit App has been submitted \n " + creditApp);
			SessionMessages.add(actionRequest, "appSubmitted");
			actionRequest.setAttribute("creditApp", creditApp);
			
			
			_log.info("sending email... \n ");
			
			themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			
			vendorId = themeDisplay.getLayout().getGroupId();
			currentUser = themeDisplay.getUser();
			
<<<<<<< HEAD
		} catch (Exception e) {
			_log.error(e); 
		}
		
		actionResponse.setRenderParameter ("openSection", "bankReferenceSection");
		_log.info("deleteCreditAppBankReference ended");
	}
	
	//ADD PRINCIPAL
	public void addCreditAppPrincipal (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("addCreditAppPrincipal started");
		
<<<<<<< HEAD
<<<<<<< HEAD

		_log.info("saveApplicationInfo actionrequest started: ");
		Long creditAppId = ParamUtil.getLong(actionRequest,"creditAppId");
=======
		CreditApp creditApp = null;
		_log.info("saveApplicationInfo actionrequest started: ");
=======
>>>>>>> master
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		
		try {
			CreditAppPrincipal principal = CreditAppPrincipalLocalServiceUtil.addCreditAppPrincipal(currentUser, themeDisplay);
			principal = PaymentCalculatorUtil.populatePrincipalFromRequest(actionRequest, principal);
			principal.setCreditAppId(creditAppId);
			CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(principal);
=======
>>>>>>> master
			
			String from = currentUser.getEmailAddress();
			_log.info("from address:  " + from);
			
			Group siteGroup = GroupLocalServiceUtil.getGroup(vendorId);
			_log.info("sitegroup:  " + siteGroup);
			String vendorName = siteGroup.getName();
			
			String to = (String) siteGroup.getExpandoBridge().getAttribute("Rep Email");
			
			_log.info("to address:  " + to);
			 
			String subject= vendorName + " submitted an application for Customer: " + creditApp.getCustomerName();
			
			String body="An application (Application #:" + creditApp.getCreditAppId() + ") was submitted by " + vendorName +  " \n \n Please login to the vendor portal to view details at the link below: "; 
			body += themeDisplay.getPortalURL()+themeDisplay.getPathFriendlyURLPrivateGroup()+ "/" + themeDisplay.getLayout().getGroup().getName().toLowerCase();
			 
			String[] toArray= new String[]{""};
			if (to != null){
				if (to.contains(",")){
					toArray=to.split(",");
				} else if (to.contains(";")){
					toArray= to.split(";");
				}
				
			}
			if (toArray.length > 1) {
			   for (int i=0;i<toArray.length;i++){
				   MailEngine.send(from, toArray[i], subject, body); 
			   }
			} else {
			     MailEngine.send(from, to, subject, body);
			}	

			_log.info("email sent");
			
		} catch (Exception e) {
			_log.error("submitApplication error" + e.getStackTrace().toString());
		}
		
<<<<<<< HEAD
		actionResponse.setRenderParameter ("openSection", "principalSection");
		SessionMessages.add(actionRequest, "principalSaved");
		_log.info("addCreditAppPrincipal ended");
	}
	
	//EDIT PRINCIPAL
	public void editCreditAppPrincipal (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("editCreditAppPrincipal started");
		
<<<<<<< HEAD
		if (actionRequest.getMethod() == "GET")
			return;
>>>>>>> master
=======
		long creditAppId = ParamUtil.getLong(actionRequest, "creditAppId");
		long principalId = ParamUtil.getLong(actionRequest, "resourcePrimKey");
=======
>>>>>>> master
		try {
			PaymentCalculatorUtil.generateCreditAppXML(creditApp, getPortletContext().getRealPath("/"));
		} catch (Exception e) {
			_log.error("error generateCreditAppXML:  " + e.getMessage().toString());
		}
>>>>>>> master
		
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
			
<<<<<<< HEAD
			
			if (creditAppId == 0) {
				creditApp = CreditAppLocalServiceUtil.addCreditApp (currentUser, vendorId);
=======
			if (creditAppId != 0)
				creditApp = CreditAppLocalServiceUtil.getCreditApp(creditAppId);
			
			if (actionRequest.getMethod() == "GET") {
				actionRequest.setAttribute("creditApp", creditApp);
				return;
			}
			
			if (creditApp == null) {
				creditApp = CreditAppLocalServiceUtil.addCreditApp (currentUser, themeDisplay);
>>>>>>> master
				_log.info("Application has been created. " + creditApp);
				creditApp.setCreditAppStatusId(1);
			} else {
				_log.info("Application has been updated. " + creditApp);
			}
			
<<<<<<< HEAD

			//map form fields to the application
			creditApp.setEquipmentPrice(ParamUtil.getDouble(actionRequest, "equipmentPrice"));
			creditApp.setCustomerName(ParamUtil.getString(actionRequest,"customerName"));
			creditApp.setCustomerDBAName(ParamUtil.getString(actionRequest,"customerDBAName"));
			
=======
			creditApp = PaymentCalculatorUtil.populateAppFromRequest(actionRequest, creditApp);
>>>>>>> master
			
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
	
		
<<<<<<< HEAD
<<<<<<< HEAD
		
		
/*
 * 
 * 
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
*/		
		
		_log.info("actionResponse.setRenderParameter");
		actionResponse.setRenderParameter("creditAppId", String.valueOf(creditApp.getCreditAppId()));
		_log.info("creditAppId: " + String.valueOf(creditApp.getCreditAppId()));
		
		
=======

<<<<<<< HEAD
>>>>>>> master
		if (actionResponse.getRenderParameterMap().get("calculatorSectionState") == null) {
			actionResponse.setRenderParameter("calculatorSectionState", "collapsed");
		}
		
		if (actionResponse.getRenderParameterMap().get("pricingOvervewSectionState") == null) {
			actionResponse.setRenderParameter("pricingOvervewSectionState", "collapsed");
		}
		
		if (actionResponse.getRenderParameterMap().get("appicationInfoSectionState") == null) {
			actionResponse.setRenderParameter("appicationInfoSectionState", "open");
		}
=======
		actionResponse.setRenderParameter("openSection", "customerAndEquipmentInfo");
>>>>>>> master
		
<<<<<<< HEAD
=======
		_log.info("Setting attribute : creditApp=" + creditApp );
		actionRequest.setAttribute("creditApp", creditApp);
		
>>>>>>> master
=======
		actionRequest.setAttribute("creditApp", creditApp);
		//actionResponse.setRenderParameter("creditAppId", String.valueOf(creditApp.getCreditAppId()));
>>>>>>> master
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
			 
			Double paymentAmount = -1.0;
			if (rate.getRateFactor() > 0)
				paymentAmount = equipmentPrice * rate.getRateFactor() ;
				//paymentAmount = (equipmentPrice/tempTerm.getTermMonths()) * (1+rate.getRateFactor()) ;
				//https://github.com/TamarackConsulting/Creekridge_Portal/issues/160
				
				
			 
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
		_log.info("selectedOptionsParam:" + selectedOptionsParam);
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
				"getProductsForEqPrice")) {
			try {
				List <Product> productList = new ArrayList <Product> ();
				List <RateFactorRule> rfrListForProducts = new ArrayList <RateFactorRule> ();
				String eqPriceString = PortalUtil.getOriginalServletRequest(request).getParameter("eqPrice");
				_log.info ("eqPriceString when getting products " + eqPriceString);
				if (eqPriceString != null) {
					double eqPrice = PaymentCalculatorUtil.getDoubleFromCurrency(eqPriceString);
					rfrListForProducts = queryUtil.fetchActiveProductsForEquipmentPrice(vendorId, eqPrice);
					
					_log.info ("rfrListForProducts size " + rfrListForProducts.size());
					Set <Long> prodSet = new HashSet <Long> ();
					for (RateFactorRule rateFactorValue : rfrListForProducts) {
						_log.info(rateFactorValue);
						if (!prodSet.contains(rateFactorValue.getProductId())) {
							prodSet.add(rateFactorValue.getProductId());
							Product product = ProductLocalServiceUtil.getProduct(rateFactorValue.getProductId());
							productList.add(product);
						} 
					}
				}
				
				
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(productList));
			} catch (Exception e) {
				_log. error(e);
				resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(e));
			}
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