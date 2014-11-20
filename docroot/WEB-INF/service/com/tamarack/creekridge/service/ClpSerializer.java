/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.tamarack.creekridge.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.tamarack.creekridge.model.CreditAppBankReferenceClp;
import com.tamarack.creekridge.model.CreditAppClp;
import com.tamarack.creekridge.model.CreditAppDocumentClp;
import com.tamarack.creekridge.model.CreditAppPrincipalClp;
import com.tamarack.creekridge.model.CreditAppStatusClp;
import com.tamarack.creekridge.model.ProductClp;
import com.tamarack.creekridge.model.ProposalOptionClp;
import com.tamarack.creekridge.model.PurchaseOptionClp;
import com.tamarack.creekridge.model.RateFactorRuleClp;
import com.tamarack.creekridge.model.TermClp;
import com.tamarack.creekridge.model.VendorClp;
import com.tamarack.creekridge.model.VendorMessageClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pmacha
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"CreekRidgeCapital-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"CreekRidgeCapital-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "CreekRidgeCapital-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CreditAppClp.class.getName())) {
			return translateInputCreditApp(oldModel);
		}

		if (oldModelClassName.equals(CreditAppBankReferenceClp.class.getName())) {
			return translateInputCreditAppBankReference(oldModel);
		}

		if (oldModelClassName.equals(CreditAppDocumentClp.class.getName())) {
			return translateInputCreditAppDocument(oldModel);
		}

		if (oldModelClassName.equals(CreditAppPrincipalClp.class.getName())) {
			return translateInputCreditAppPrincipal(oldModel);
		}

		if (oldModelClassName.equals(CreditAppStatusClp.class.getName())) {
			return translateInputCreditAppStatus(oldModel);
		}

		if (oldModelClassName.equals(ProductClp.class.getName())) {
			return translateInputProduct(oldModel);
		}

		if (oldModelClassName.equals(ProposalOptionClp.class.getName())) {
			return translateInputProposalOption(oldModel);
		}

		if (oldModelClassName.equals(PurchaseOptionClp.class.getName())) {
			return translateInputPurchaseOption(oldModel);
		}

		if (oldModelClassName.equals(RateFactorRuleClp.class.getName())) {
			return translateInputRateFactorRule(oldModel);
		}

		if (oldModelClassName.equals(TermClp.class.getName())) {
			return translateInputTerm(oldModel);
		}

		if (oldModelClassName.equals(VendorClp.class.getName())) {
			return translateInputVendor(oldModel);
		}

		if (oldModelClassName.equals(VendorMessageClp.class.getName())) {
			return translateInputVendorMessage(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCreditApp(BaseModel<?> oldModel) {
		CreditAppClp oldClpModel = (CreditAppClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCreditAppRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCreditAppBankReference(
		BaseModel<?> oldModel) {
		CreditAppBankReferenceClp oldClpModel = (CreditAppBankReferenceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCreditAppBankReferenceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCreditAppDocument(BaseModel<?> oldModel) {
		CreditAppDocumentClp oldClpModel = (CreditAppDocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCreditAppDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCreditAppPrincipal(BaseModel<?> oldModel) {
		CreditAppPrincipalClp oldClpModel = (CreditAppPrincipalClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCreditAppPrincipalRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCreditAppStatus(BaseModel<?> oldModel) {
		CreditAppStatusClp oldClpModel = (CreditAppStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCreditAppStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProduct(BaseModel<?> oldModel) {
		ProductClp oldClpModel = (ProductClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProposalOption(BaseModel<?> oldModel) {
		ProposalOptionClp oldClpModel = (ProposalOptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProposalOptionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPurchaseOption(BaseModel<?> oldModel) {
		PurchaseOptionClp oldClpModel = (PurchaseOptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPurchaseOptionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRateFactorRule(BaseModel<?> oldModel) {
		RateFactorRuleClp oldClpModel = (RateFactorRuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRateFactorRuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTerm(BaseModel<?> oldModel) {
		TermClp oldClpModel = (TermClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTermRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVendor(BaseModel<?> oldModel) {
		VendorClp oldClpModel = (VendorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVendorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVendorMessage(BaseModel<?> oldModel) {
		VendorMessageClp oldClpModel = (VendorMessageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVendorMessageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.CreditAppImpl")) {
			return translateOutputCreditApp(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.CreditAppBankReferenceImpl")) {
			return translateOutputCreditAppBankReference(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.CreditAppDocumentImpl")) {
			return translateOutputCreditAppDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.CreditAppPrincipalImpl")) {
			return translateOutputCreditAppPrincipal(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.CreditAppStatusImpl")) {
			return translateOutputCreditAppStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.ProductImpl")) {
			return translateOutputProduct(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.ProposalOptionImpl")) {
			return translateOutputProposalOption(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.PurchaseOptionImpl")) {
			return translateOutputPurchaseOption(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.RateFactorRuleImpl")) {
			return translateOutputRateFactorRule(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.TermImpl")) {
			return translateOutputTerm(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.VendorImpl")) {
			return translateOutputVendor(oldModel);
		}

		if (oldModelClassName.equals(
					"com.tamarack.creekridge.model.impl.VendorMessageImpl")) {
			return translateOutputVendorMessage(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.tamarack.creekridge.NoSuchCreditAppException")) {
			return new com.tamarack.creekridge.NoSuchCreditAppException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchCreditAppBankReferenceException")) {
			return new com.tamarack.creekridge.NoSuchCreditAppBankReferenceException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchCreditAppDocumentException")) {
			return new com.tamarack.creekridge.NoSuchCreditAppDocumentException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchCreditAppPrincipalException")) {
			return new com.tamarack.creekridge.NoSuchCreditAppPrincipalException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchCreditAppStatusException")) {
			return new com.tamarack.creekridge.NoSuchCreditAppStatusException();
		}

		if (className.equals("com.tamarack.creekridge.NoSuchProductException")) {
			return new com.tamarack.creekridge.NoSuchProductException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchProposalOptionException")) {
			return new com.tamarack.creekridge.NoSuchProposalOptionException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchPurchaseOptionException")) {
			return new com.tamarack.creekridge.NoSuchPurchaseOptionException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchRateFactorRuleException")) {
			return new com.tamarack.creekridge.NoSuchRateFactorRuleException();
		}

		if (className.equals("com.tamarack.creekridge.NoSuchTermException")) {
			return new com.tamarack.creekridge.NoSuchTermException();
		}

		if (className.equals("com.tamarack.creekridge.NoSuchVendorException")) {
			return new com.tamarack.creekridge.NoSuchVendorException();
		}

		if (className.equals(
					"com.tamarack.creekridge.NoSuchVendorMessageException")) {
			return new com.tamarack.creekridge.NoSuchVendorMessageException();
		}

		return throwable;
	}

	public static Object translateOutputCreditApp(BaseModel<?> oldModel) {
		CreditAppClp newModel = new CreditAppClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCreditAppRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCreditAppBankReference(
		BaseModel<?> oldModel) {
		CreditAppBankReferenceClp newModel = new CreditAppBankReferenceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCreditAppBankReferenceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCreditAppDocument(BaseModel<?> oldModel) {
		CreditAppDocumentClp newModel = new CreditAppDocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCreditAppDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCreditAppPrincipal(
		BaseModel<?> oldModel) {
		CreditAppPrincipalClp newModel = new CreditAppPrincipalClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCreditAppPrincipalRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCreditAppStatus(BaseModel<?> oldModel) {
		CreditAppStatusClp newModel = new CreditAppStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCreditAppStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProduct(BaseModel<?> oldModel) {
		ProductClp newModel = new ProductClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProposalOption(BaseModel<?> oldModel) {
		ProposalOptionClp newModel = new ProposalOptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProposalOptionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPurchaseOption(BaseModel<?> oldModel) {
		PurchaseOptionClp newModel = new PurchaseOptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPurchaseOptionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRateFactorRule(BaseModel<?> oldModel) {
		RateFactorRuleClp newModel = new RateFactorRuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRateFactorRuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTerm(BaseModel<?> oldModel) {
		TermClp newModel = new TermClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTermRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVendor(BaseModel<?> oldModel) {
		VendorClp newModel = new VendorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVendorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVendorMessage(BaseModel<?> oldModel) {
		VendorMessageClp newModel = new VendorMessageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVendorMessageRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}