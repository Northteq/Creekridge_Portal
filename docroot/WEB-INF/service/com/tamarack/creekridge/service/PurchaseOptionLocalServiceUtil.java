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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PurchaseOption. This utility wraps
 * {@link com.tamarack.creekridge.service.impl.PurchaseOptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pmacha
 * @see PurchaseOptionLocalService
 * @see com.tamarack.creekridge.service.base.PurchaseOptionLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.impl.PurchaseOptionLocalServiceImpl
 * @generated
 */
public class PurchaseOptionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.tamarack.creekridge.service.impl.PurchaseOptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the purchase option to the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOption the purchase option
	* @return the purchase option that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption addPurchaseOption(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPurchaseOption(purchaseOption);
	}

	/**
	* Creates a new purchase option with the primary key. Does not add the purchase option to the database.
	*
	* @param purchaseOptionId the primary key for the new purchase option
	* @return the new purchase option
	*/
	public static com.tamarack.creekridge.model.PurchaseOption createPurchaseOption(
		long purchaseOptionId) {
		return getService().createPurchaseOption(purchaseOptionId);
	}

	/**
	* Deletes the purchase option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option that was removed
	* @throws PortalException if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption deletePurchaseOption(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePurchaseOption(purchaseOptionId);
	}

	/**
	* Deletes the purchase option from the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOption the purchase option
	* @return the purchase option that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption deletePurchaseOption(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePurchaseOption(purchaseOption);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.tamarack.creekridge.model.PurchaseOption fetchPurchaseOption(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPurchaseOption(purchaseOptionId);
	}

	/**
	* Returns the purchase option with the primary key.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option
	* @throws PortalException if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption getPurchaseOption(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPurchaseOption(purchaseOptionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the purchase options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of purchase options
	* @param end the upper bound of the range of purchase options (not inclusive)
	* @return the range of purchase options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.PurchaseOption> getPurchaseOptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPurchaseOptions(start, end);
	}

	/**
	* Returns the number of purchase options.
	*
	* @return the number of purchase options
	* @throws SystemException if a system exception occurred
	*/
	public static int getPurchaseOptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPurchaseOptionsCount();
	}

	/**
	* Updates the purchase option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param purchaseOption the purchase option
	* @return the purchase option that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption updatePurchaseOption(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePurchaseOption(purchaseOption);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static PurchaseOptionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PurchaseOptionLocalService.class.getName());

			if (invokableLocalService instanceof PurchaseOptionLocalService) {
				_service = (PurchaseOptionLocalService)invokableLocalService;
			}
			else {
				_service = new PurchaseOptionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PurchaseOptionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PurchaseOptionLocalService service) {
	}

	private static PurchaseOptionLocalService _service;
}