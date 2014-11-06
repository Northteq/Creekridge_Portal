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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CreditAppLocalService}.
 *
 * @author pmacha
 * @see CreditAppLocalService
 * @generated
 */
public class CreditAppLocalServiceWrapper implements CreditAppLocalService,
	ServiceWrapper<CreditAppLocalService> {
	public CreditAppLocalServiceWrapper(
		CreditAppLocalService creditAppLocalService) {
		_creditAppLocalService = creditAppLocalService;
	}

	/**
	* Adds the credit app to the database. Also notifies the appropriate model listeners.
	*
	* @param creditApp the credit app
	* @return the credit app that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditApp addCreditApp(
		com.tamarack.creekridge.model.CreditApp creditApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.addCreditApp(creditApp);
	}

	/**
	* Creates a new credit app with the primary key. Does not add the credit app to the database.
	*
	* @param creditAppId the primary key for the new credit app
	* @return the new credit app
	*/
	@Override
	public com.tamarack.creekridge.model.CreditApp createCreditApp(
		long creditAppId) {
		return _creditAppLocalService.createCreditApp(creditAppId);
	}

	/**
	* Deletes the credit app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app that was removed
	* @throws PortalException if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditApp deleteCreditApp(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.deleteCreditApp(creditAppId);
	}

	/**
	* Deletes the credit app from the database. Also notifies the appropriate model listeners.
	*
	* @param creditApp the credit app
	* @return the credit app that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditApp deleteCreditApp(
		com.tamarack.creekridge.model.CreditApp creditApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.deleteCreditApp(creditApp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creditAppLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.tamarack.creekridge.model.CreditApp fetchCreditApp(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.fetchCreditApp(creditAppId);
	}

	/**
	* Returns the credit app with the primary key.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app
	* @throws PortalException if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditApp getCreditApp(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.getCreditApp(creditAppId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the credit apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit apps
	* @param end the upper bound of the range of credit apps (not inclusive)
	* @return the range of credit apps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.tamarack.creekridge.model.CreditApp> getCreditApps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.getCreditApps(start, end);
	}

	/**
	* Returns the number of credit apps.
	*
	* @return the number of credit apps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCreditAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.getCreditAppsCount();
	}

	/**
	* Updates the credit app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creditApp the credit app
	* @return the credit app that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditApp updateCreditApp(
		com.tamarack.creekridge.model.CreditApp creditApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppLocalService.updateCreditApp(creditApp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _creditAppLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_creditAppLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _creditAppLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CreditAppLocalService getWrappedCreditAppLocalService() {
		return _creditAppLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCreditAppLocalService(
		CreditAppLocalService creditAppLocalService) {
		_creditAppLocalService = creditAppLocalService;
	}

	@Override
	public CreditAppLocalService getWrappedService() {
		return _creditAppLocalService;
	}

	@Override
	public void setWrappedService(CreditAppLocalService creditAppLocalService) {
		_creditAppLocalService = creditAppLocalService;
	}

	private CreditAppLocalService _creditAppLocalService;
}