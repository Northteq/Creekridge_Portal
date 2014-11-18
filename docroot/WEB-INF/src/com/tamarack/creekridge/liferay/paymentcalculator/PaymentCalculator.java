package com.tamarack.creekridge.liferay.paymentcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.Term;
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
		pcUtil = new PaymentCalculatorUtil();
	}

	private static Log _log = LogFactory.getLog(PaymentCalculator.class);
	private  Long vendorId;
	private  User currentUser;
	private List <ProposalOptionWrapper> proposalOptionList;
	private PaymentCalculatorUtil pcUtil;
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		List<Product> productOptions = new ArrayList<Product>();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		vendorId = themeDisplay.getLayout().getGroupId();
		currentUser = themeDisplay.getUser();
		_log.info ("Current vendorID: " + vendorId);
		
		try {

			productOptions = ProductLocalServiceUtil.getProducts(-1, -1);

			_log.info("doView haz these product options : " + productOptions);

			renderRequest.setAttribute("productOptions", productOptions);

		} catch (Exception e) {
			_log.error(e);
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}
	
	public void createApplication (ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("createApplication");
	}
	
	public List<ProposalOptionWrapper> calculatePayments(String selectedOptions) throws Exception {
		
		List <RateFactorRule> rateFactorRuleList = new ArrayList <RateFactorRule> ();
		
		
		JSONObject selectedOptionsObject = JSONFactoryUtil.createJSONObject(selectedOptions);
		_log.info("calculatePayments JSON : " + selectedOptionsObject);
		
		JSONArray productIdList = selectedOptionsObject.getJSONArray("products");
		_log.info("calculatePayments JSON productIdList : " + productIdList);
		
		
		JSONArray purchaseOptionIdList = selectedOptionsObject.getJSONArray("purchaseOptions");
		_log.info("calculatePayments JSON purchaseOptionIdList : " + purchaseOptionIdList);
		
		JSONArray termIdList = selectedOptionsObject.getJSONArray("termOptions");
		_log.info("calculatePayments JSON termIdList : " + purchaseOptionIdList);
		
		Double equipmentPrice = selectedOptionsObject.getDouble("equipmentPrice");
		_log.info("calculatePayments JSON equipmentPrice : " + equipmentPrice);
		
		//build query for terms
		if (termIdList.length()>0) {
			for (int i = 0; i < termIdList.length(); i++) {
				for (int j = 0; j < purchaseOptionIdList.length(); j++) {
					for (int k = 0; k < productIdList.length(); k++) {
						List <RateFactorRule> tempRfRList = new ArrayList <RateFactorRule> ();
						tempRfRList = fetchRatefactorOptionForCalculations(productIdList.getLong(k), purchaseOptionIdList.getLong(j), termIdList.getLong(i), equipmentPrice);
						if (!tempRfRList.isEmpty()) {
							rateFactorRuleList.add(tempRfRList.get(0));
						}
					}
				}
			}	
		}
		
		
		proposalOptionList = new ArrayList <ProposalOptionWrapper> ();
		
		
		for (RateFactorRule rate: rateFactorRuleList) {
			ProposalOption proposalOption = ProposalOptionLocalServiceUtil.createProposalOption(CounterLocalServiceUtil.increment(ProposalOption.class.getName()));
			proposalOption.setRateFactorRuleId(rate.getRateFactorRuleId());
			// Auditing Values
			 proposalOption.setCompanyId(currentUser.getCompanyId());
			 proposalOption.setUserId(currentUser.getUserId());
			 proposalOption.setUserName(currentUser.getScreenName());
			 proposalOption.setModifiedDate(new Date());
			 proposalOption.setCreateDate(new Date());
			 //	Other fields

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
		
		return proposalOptionList;
		
	}
	
	private List<RateFactorRule> fetchRatefactorOptionForCalculations(
			Long prodId, Long optionId, Long termId, Double eqPrice) throws Exception {
		//main object passed from the page
		
		
		DynamicQuery rateFactorCriteriaQuery = DynamicQueryFactoryUtil
				.forClass(RateFactorRule.class,
						PortletClassLoaderUtil.getClassLoader());
		
		//only rules that are active and belong to a site/vendorId
		Criterion vendorIdCriteria = RestrictionsFactoryUtil.eq("vendorId",
				vendorId);
		Criterion activeFlagCriteria = RestrictionsFactoryUtil.eq("active",
				true);
		
		Criterion crit = RestrictionsFactoryUtil.eq("productId", prodId);
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("purchaseOptionId", optionId));
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.eq("termId", termId));
		
		
		crit = RestrictionsFactoryUtil.and(crit, RestrictionsFactoryUtil.le("minPrice", eqPrice));
		
		rateFactorCriteriaQuery.add(crit);
		

		rateFactorCriteriaQuery.add(vendorIdCriteria);
		rateFactorCriteriaQuery.add(activeFlagCriteria);
		
		//orderby price
		rateFactorCriteriaQuery.addOrder(OrderFactoryUtil.desc("minPrice"));
		
		
		@SuppressWarnings("unchecked")
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil
				.dynamicQuery(rateFactorCriteriaQuery);
		
		_log.info("fetched ratefactorrules: " + rateFactorRuleList);
		
		return rateFactorRuleList;
	}

	public List<RateFactorRule> fetchRatefactorOption(String currentSelectedOptions)
			throws Exception {
		
		//main object passed from the page
		JSONObject options = JSONFactoryUtil.createJSONObject(currentSelectedOptions);
		_log.info("fetchRatefactorOptionByProduct JSON : " + options);
		
		JSONArray productIdList = options.getJSONArray("products");
		_log.info("fetchRatefactorOptionByProduct JSON productIdList : " + productIdList);
		
		JSONArray purchaseOptionIdList = options.getJSONArray("purchaseOptions");
		_log.info("fetchRatefactorOptionByProduct JSON purchaseOptionIdList : " + purchaseOptionIdList);

		
		DynamicQuery rateFactorCriteriaQuery = DynamicQueryFactoryUtil
				.forClass(RateFactorRule.class,
						PortletClassLoaderUtil.getClassLoader());

		Criterion productCriteria = null;
		Criterion purchaseOptionCriteria = null;
		
		
		//only rules that are active and belong to a site/vendorId
		Criterion vendorIdCriteria = RestrictionsFactoryUtil.eq("vendorId",
				vendorId);
		Criterion activeFlagCriteria = RestrictionsFactoryUtil.eq("active",
				true);
		

		// build query for product ids
		if (productIdList.length()>0) {
			for (int i = 0; i < productIdList.length(); i++) {
				if (i == 0) {
					productCriteria = RestrictionsFactoryUtil.eq("productId",
							new Long(productIdList.getString(i)).longValue());
				} else {
					productCriteria = RestrictionsFactoryUtil
							.or(productCriteria, RestrictionsFactoryUtil.eq(
									"productId",
									new Long(productIdList.getString(i)).longValue()));
				}
			}
		}

		// build query for purchaseOption ids
		if (purchaseOptionIdList.length()>0) {
			for (int i = 0; i < purchaseOptionIdList.length(); i++) {
				if (i == 0) {
					purchaseOptionCriteria = RestrictionsFactoryUtil.eq(
							"purchaseOptionId", purchaseOptionIdList.getLong(i));
				} else {
					purchaseOptionCriteria = RestrictionsFactoryUtil.or(
							purchaseOptionCriteria, RestrictionsFactoryUtil.eq(
									"purchaseOptionId",purchaseOptionIdList.getLong(i)));
				}
			}
		}
		
		
		if (productCriteria != null){
			rateFactorCriteriaQuery.add(productCriteria);
			
			if (purchaseOptionCriteria != null)
				rateFactorCriteriaQuery.add(purchaseOptionCriteria);
		}
		
		rateFactorCriteriaQuery.add(vendorIdCriteria);
		rateFactorCriteriaQuery.add(activeFlagCriteria);

		@SuppressWarnings("unchecked")
		List<RateFactorRule> rateFactorRuleList = RateFactorRuleLocalServiceUtil
				.dynamicQuery(rateFactorCriteriaQuery);
		
		return rateFactorRuleList;
	}
	
	//needed for the js table
	public class ProposalOptionWrapper {
		public ProposalOption propOption;
		public String termName;
		public String productName;
		public String prodOptionName;
		public Double eqPrice;
		public Double paymentAmount;
		public Boolean useForCreditApp;
		public Boolean includeInProposal;
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
				this.useForCreditApp = propOption.getUseForCreditApp();
				this.includeInProposal = propOption.getIncludeInProposal();
				
			} catch (SystemException e) {
				_log.error(e);
				e.printStackTrace();
			} catch (PortalException e) {
				_log.error(e);
				e.printStackTrace();
			}
		}
		
		
	}

	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		
		
		HttpServletRequest request = PortalUtil
				.getHttpServletRequest(resourceRequest);

		
		List <RateFactorRule> rateFactorList = new ArrayList <RateFactorRule>();
		List <PurchaseOption> purchaseOptionList = new ArrayList <PurchaseOption> ();
		List <Term> termList = new ArrayList <Term> ();
		
		_log.info(resourceRequest.getResourceID());
		
		String selectedOptionsParam = PortalUtil.getOriginalServletRequest(request).getParameter("selectedOptions");
		
		if (selectedOptionsParam != null) {
			try {
				rateFactorList = fetchRatefactorOption(selectedOptionsParam);
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
						pow.propOption.setIncludeInProposal(true);
					}
				}
				
				resourceResponse.getWriter().write("{\"proposalOptionId\": \"" + selectedProposalOptionId + "\"}");
			} else {
				resourceResponse.getWriter().write("{ \"error\": \"selectedProposalOptionId not found " + selectedProposalOptionId + "\"}");
			}
			
			
			
		} else if (resourceRequest.getResourceID().equalsIgnoreCase(
				"updateIncludeInProposal")) {
			
			String selectedProposalOptionId = PortalUtil.getOriginalServletRequest(request).getParameter("purchaseOptionId");
			String selectedValue = PortalUtil.getOriginalServletRequest(request).getParameter("isChecked");
			
			for (ProposalOptionWrapper pow: proposalOptionList) {
				if (pow.propOption.getProposalOptionId() == Long.valueOf(selectedProposalOptionId)) {
					pow.propOption.setUseForCreditApp(Boolean.valueOf(selectedValue));
				}
			}
			
			resourceResponse.getWriter().write(JSONFactoryUtil.looseSerialize(proposalOptionList));
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}

}
