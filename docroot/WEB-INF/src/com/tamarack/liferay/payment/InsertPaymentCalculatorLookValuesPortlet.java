package com.tamarack.liferay.payment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.model.Product;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.service.CreditAppLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;
import com.tamarack.creekridge.service.ProductLocalServiceUtil;
import com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil;
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;
import com.tamarack.creekridge.service.TermLocalServiceUtil;

/**
 * Portlet implementation class InsertPaymentCalculatorLookValuesPortlet
 */
public class InsertPaymentCalculatorLookValuesPortlet extends MVCPortlet {
       
    /**
     * @see MVCPortlet#MVCPortlet()
     */
    public InsertPaymentCalculatorLookValuesPortlet() {
        super();
    }
    private static Log _log = LogFactory.getLog(InsertPaymentCalculatorLookValuesPortlet.class);


@Override
public void doView(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
	// TODO Auto-generated method stub
	
	
	super.doView(renderRequest, renderResponse);
	
}

public  void updateProductLookUpValues(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		String actionType = ParamUtil.getString(actionRequest, "actionType");
 		Product productOption = null;
 		try {
 			productOption = ProductLocalServiceUtil.createProduct(com.liferay.counter.service.CounterLocalServiceUtil.increment(Product.class.getName()));
 		} catch (SystemException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		List<Product> products=ProductLocalServiceUtil.getProducts(-1, -1);
 		
 		for (int i=0;i<products.size();i++){
 			System.out.println("Product Primary KeyId " + products.get(i).getPrimaryKey());
 			System.out.println("Product Id " + products.get(i).getProductId());
 			System.out.println("Product Name " + products.get(i).getProductName());
 			System.out.println("");
 			if(products.get(i).getPrimaryKey() < 501)
 				ProductLocalServiceUtil.deleteProduct(products.get(i).getPrimaryKey());
 		}

 		// Auditing Values

 		productOption.setCompanyId(user.getCompanyId());
 		productOption.setUserId(user.getUserId());
 		productOption.setUserName(user.getScreenName());
 		productOption.setModifiedDate(new Date());
 		productOption.setCreateDate(new Date());
 		
 	
 		javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
 		productOption.setProductName(ParamUtil.getString(uploadRequest,"productName"));
 		
 		productOption.setSequenceNumber(ParamUtil.getLong(uploadRequest,"sequenceNumber"));
 		
 		ProductLocalServiceUtil.addProduct(productOption);
 		System.out.println("Product "+ productOption.getProductName());
 	
 }

public  void updateCreditStatusLookUpValues(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		String actionType = ParamUtil.getString(actionRequest, "actionType");
 		CreditAppStatus creditAppStatus = null;
 		try {
 			creditAppStatus = CreditAppStatusLocalServiceUtil.createCreditAppStatus(com.liferay.counter.service.CounterLocalServiceUtil.increment(CreditAppStatus.class.getName()));
 		} catch (SystemException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 	
 		// Auditing Values

 		creditAppStatus.setCompanyId(user.getCompanyId());
 		creditAppStatus.setUserId(user.getUserId());
 		creditAppStatus.setUserName(user.getScreenName());
 		creditAppStatus.setModifiedDate(new Date());
 		creditAppStatus.setCreateDate(new Date());
 		
 	
 		javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		UploadRequest uploadRequest=PortalUtil.getUploadPortletRequest(actionRequest);
 		creditAppStatus.setCreditAppStatusName(ParamUtil.getString(uploadRequest,"creditAppStatusName"));
 		
 		
 		CreditAppStatusLocalServiceUtil.addCreditAppStatus(creditAppStatus);
 		System.out.println("Credit Status "+ creditAppStatus.getCreditAppStatusName());
 		//updateRateFactorRuleLookUpValues(actionRequest, actionResponse);
 	
 }
public  void updateTermLookUpValues(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		String actionType = ParamUtil.getString(actionRequest, "actionType");
 		Term termOption = null;
 		try {
 			termOption = TermLocalServiceUtil.createTerm(com.liferay.counter.service.CounterLocalServiceUtil.increment(Term.class.getName()));
 		} catch (SystemException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		List<Term> terms=TermLocalServiceUtil.getTerms(-1, -1);
 		for (int i=0;i<terms.size();i++){
 			System.out.println("Product Primary KeyId " + terms.get(i).getPrimaryKey());
 			
 			System.out.println("");
 			if(terms.get(i).getPrimaryKey() < 101)
 				TermLocalServiceUtil.deleteTerm(terms.get(i).getPrimaryKey());
 		}
 		// Auditing Values

 		termOption.setCompanyId(user.getCompanyId());
 		termOption.setUserId(user.getUserId());
 		termOption.setUserName(user.getScreenName());
 		termOption.setModifiedDate(new Date());
 		termOption.setCreateDate(new Date());
 		
 		//CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.
 		javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		
 		termOption.setTermMonths(ParamUtil.getLong(actionRequest,"termMonths"));
 		termOption.setSequenceNumber(ParamUtil.getLong(actionRequest,"sequenceNumber"));
 		termOption.setTermName(ParamUtil.getString(actionRequest,"termName"));
 		TermLocalServiceUtil.addTerm(termOption);
 
 		System.out.println("Term "+ termOption.getTermName());
 }

public  void updatePurchaseOptionLookUpValues(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		String actionType = ParamUtil.getString(actionRequest, "actionType");
 		PurchaseOption purchaseOption = null;
 		try {
 			purchaseOption = PurchaseOptionLocalServiceUtil.createPurchaseOption(com.liferay.counter.service.CounterLocalServiceUtil.increment(PurchaseOption.class.getName()));
 		} catch (SystemException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 		List<PurchaseOption> terms=PurchaseOptionLocalServiceUtil.getPurchaseOptions(-1, -1);
 		for (int i=0;i<terms.size();i++){
 			System.out.println("Product Primary KeyId " + terms.get(i).getPrimaryKey());
 			
 			System.out.println("");
 			if(terms.get(i).getPrimaryKey() < 201)
 				PurchaseOptionLocalServiceUtil.deletePurchaseOption(terms.get(i).getPrimaryKey());
 		}
 		// Auditing Values

 		purchaseOption.setCompanyId(user.getCompanyId());
 		purchaseOption.setUserId(user.getUserId());
 		purchaseOption.setUserName(user.getScreenName());
 		purchaseOption.setModifiedDate(new Date());
 		purchaseOption.setCreateDate(new Date());
 		
 		//CreditAppStatus creditAppStatus=CreditAppStatusLocalServiceUtil.
 		javax.servlet.http.HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
 		System.out.println("Purchase Option from sequenceNumber "+ ParamUtil.getLong(actionRequest,"sequenceNumber"));
 		purchaseOption.setSequenceNumber(ParamUtil.getLong(actionRequest,"sequenceNumber"));
 		purchaseOption.setPurchaseOptionName(ParamUtil.getString(actionRequest,"purchaseOptionName"));
 		PurchaseOptionLocalServiceUtil.addPurchaseOption(purchaseOption);
 		System.out.println("Purchase "+ purchaseOption.getPurchaseOptionName());
 		//updateRateFactorRuleLookUpValues(actionRequest, actionResponse);
 }

public  void updateRateFactorRuleLookUpValues(ActionRequest actionRequest,	ActionResponse actionResponse) throws IOException, PortletException, Exception {
 	// TODO Auto-generated method stub
 	 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
 		User user = themeDisplay.getUser();
 		String actionType = ParamUtil.getString(actionRequest, "actionType");
 		RateFactorRule rateFactorRule = null;
 		try {
 			rateFactorRule = RateFactorRuleLocalServiceUtil.createRateFactorRule(com.liferay.counter.service.CounterLocalServiceUtil.increment(RateFactorRule.class.getName()));
 		} catch (SystemException e) {
 			
 			e.printStackTrace();
 		}
 		
 	
 		// Auditing Values

 		rateFactorRule.setCompanyId(user.getCompanyId());
 		rateFactorRule.setUserId(user.getUserId());
 		rateFactorRule.setUserName(user.getScreenName());
 		rateFactorRule.setModifiedDate(new Date());
 		rateFactorRule.setCreateDate(new Date());
 		
 		/*
 		<column name="minPrice" type="double" />
		<column name="rateFactor" type="double" />
		<column name="effectiveDate" type="Date" />
		<column name="active" type="boolean" />
		<column name="expirationDate" type="Date" />
		
 		 */
 		
 		rateFactorRule.setMinPrice(15000);
 		rateFactorRule.setRateFactor(50.5);
 		rateFactorRule.setEffectiveDate(new Date());
 		rateFactorRule.setActive(true);
 		rateFactorRule.setExpirationDate(new Date());
 		rateFactorRule.setProductId(501);
 		rateFactorRule.setPurchaseOptionId(202);
 		rateFactorRule.setVendorId(themeDisplay.getScopeGroupId());
 		rateFactorRule.setTermId(201);
 		RateFactorRuleLocalServiceUtil.addRateFactorRule(rateFactorRule);
		rateFactorRule = RateFactorRuleLocalServiceUtil.createRateFactorRule(com.liferay.counter.service.CounterLocalServiceUtil.increment(RateFactorRule.class.getName()));
		// Auditing Values

		 		rateFactorRule.setCompanyId(user.getCompanyId());
		 		rateFactorRule.setUserId(user.getUserId());
		 		rateFactorRule.setUserName(user.getScreenName());
		 		rateFactorRule.setModifiedDate(new Date());
		 		rateFactorRule.setCreateDate(new Date());
		 		
 		rateFactorRule.setMinPrice(20000);
 		rateFactorRule.setRateFactor(60.5);
 		rateFactorRule.setEffectiveDate(new Date());
 		rateFactorRule.setActive(true);
 		rateFactorRule.setExpirationDate(new Date());
 		rateFactorRule.setProductId(501);
 		rateFactorRule.setPurchaseOptionId(202);
 		rateFactorRule.setVendorId(themeDisplay.getScopeGroupId());
 		rateFactorRule.setTermId(202);
 		RateFactorRuleLocalServiceUtil.addRateFactorRule(rateFactorRule);
 		
 		rateFactorRule = RateFactorRuleLocalServiceUtil.createRateFactorRule(com.liferay.counter.service.CounterLocalServiceUtil.increment(RateFactorRule.class.getName()));
		// Auditing Values

		 		rateFactorRule.setCompanyId(user.getCompanyId());
		 		rateFactorRule.setUserId(user.getUserId());
		 		rateFactorRule.setUserName(user.getScreenName());
		 		rateFactorRule.setModifiedDate(new Date());
		 		rateFactorRule.setCreateDate(new Date());
	
 		rateFactorRule.setMinPrice(15000);
 		rateFactorRule.setRateFactor(40.5);
 		rateFactorRule.setEffectiveDate(new Date());
 		rateFactorRule.setActive(true);
 		rateFactorRule.setExpirationDate(new Date());
 		rateFactorRule.setProductId(501);
 		rateFactorRule.setPurchaseOptionId(202);
 		rateFactorRule.setVendorId(themeDisplay.getScopeGroupId());
 		rateFactorRule.setTermId(101);
 		RateFactorRuleLocalServiceUtil.addRateFactorRule(rateFactorRule);
 		
 		rateFactorRule = RateFactorRuleLocalServiceUtil.createRateFactorRule(com.liferay.counter.service.CounterLocalServiceUtil.increment(RateFactorRule.class.getName()));
		// Auditing Values

		 		rateFactorRule.setCompanyId(user.getCompanyId());
		 		rateFactorRule.setUserId(user.getUserId());
		 		rateFactorRule.setUserName(user.getScreenName());
		 		rateFactorRule.setModifiedDate(new Date());
		 		rateFactorRule.setCreateDate(new Date());
	
 		rateFactorRule.setMinPrice(15000);
 		rateFactorRule.setRateFactor(40.5);
 		rateFactorRule.setEffectiveDate(new Date());
 		rateFactorRule.setActive(true);
 		rateFactorRule.setExpirationDate(new Date());
 		rateFactorRule.setProductId(501);
 		rateFactorRule.setPurchaseOptionId(201);
 		rateFactorRule.setVendorId(themeDisplay.getScopeGroupId());
 		rateFactorRule.setTermId(201);
 		RateFactorRuleLocalServiceUtil.addRateFactorRule(rateFactorRule);
 		System.out.println("RateFactorRule Lookup Table "+ rateFactorRule.getMinPrice());
 	
 }
}
