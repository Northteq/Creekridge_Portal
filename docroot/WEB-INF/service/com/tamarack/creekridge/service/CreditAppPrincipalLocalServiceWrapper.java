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
 * Provides a wrapper for {@link CreditAppPrincipalLocalService}.
 *
 * @author pmacha
 * @see CreditAppPrincipalLocalService
 * @generated
 */
public class CreditAppPrincipalLocalServiceWrapper
	implements CreditAppPrincipalLocalService,
		ServiceWrapper<CreditAppPrincipalLocalService> {
	public CreditAppPrincipalLocalServiceWrapper(
		CreditAppPrincipalLocalService creditAppPrincipalLocalService) {
		_creditAppPrincipalLocalService = creditAppPrincipalLocalService;
	}

	/**
	* Adds the credit app principal to the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppPrincipal the credit app principal
	* @return the credit app principal that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal addCreditAppPrincipal(
		com.tamarack.creekridge.model.CreditAppPrincipal creditAppPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.addCreditAppPrincipal(creditAppPrincipal);
	}

	/**
	* Creates a new credit app principal with the primary key. Does not add the credit app principal to the database.
	*
	* @param principalId the primary key for the new credit app principal
	* @return the new credit app principal
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal createCreditAppPrincipal(
		long principalId) {
		return _creditAppPrincipalLocalService.createCreditAppPrincipal(principalId);
	}

	/**
	* Deletes the credit app principal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param principalId the primary key of the credit app principal
	* @return the credit app principal that was removed
	* @throws PortalException if a credit app principal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal deleteCreditAppPrincipal(
		long principalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.deleteCreditAppPrincipal(principalId);
	}

	/**
	* Deletes the credit app principal from the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppPrincipal the credit app principal
	* @return the credit app principal that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal deleteCreditAppPrincipal(
		com.tamarack.creekridge.model.CreditAppPrincipal creditAppPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.deleteCreditAppPrincipal(creditAppPrincipal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creditAppPrincipalLocalService.dynamicQuery();
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
		return _creditAppPrincipalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _creditAppPrincipalLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _creditAppPrincipalLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _creditAppPrincipalLocalService.dynamicQueryCount(dynamicQuery);
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
		return _creditAppPrincipalLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal fetchCreditAppPrincipal(
		long principalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.fetchCreditAppPrincipal(principalId);
	}

	/**
	* Returns the credit app principal with the primary key.
	*
	* @param principalId the primary key of the credit app principal
	* @return the credit app principal
	* @throws PortalException if a credit app principal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal getCreditAppPrincipal(
		long principalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.getCreditAppPrincipal(principalId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the credit app principals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @return the range of credit app principals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> getCreditAppPrincipals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.getCreditAppPrincipals(start, end);
	}

	/**
	* Returns the number of credit app principals.
	*
	* @return the number of credit app principals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCreditAppPrincipalsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.getCreditAppPrincipalsCount();
	}

	/**
	* Updates the credit app principal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creditAppPrincipal the credit app principal
	* @return the credit app principal that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal updateCreditAppPrincipal(
		com.tamarack.creekridge.model.CreditAppPrincipal creditAppPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipalLocalService.updateCreditAppPrincipal(creditAppPrincipal);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _creditAppPrincipalLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_creditAppPrincipalLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _creditAppPrincipalLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> getCreditAppPrincipalByCreditAppId(
		long creditAppId) throws java.lang.Exception {
		return _creditAppPrincipalLocalService.getCreditAppPrincipalByCreditAppId(creditAppId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CreditAppPrincipalLocalService getWrappedCreditAppPrincipalLocalService() {
		return _creditAppPrincipalLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCreditAppPrincipalLocalService(
		CreditAppPrincipalLocalService creditAppPrincipalLocalService) {
		_creditAppPrincipalLocalService = creditAppPrincipalLocalService;
	}

	@Override
	public CreditAppPrincipalLocalService getWrappedService() {
		return _creditAppPrincipalLocalService;
	}

	@Override
	public void setWrappedService(
		CreditAppPrincipalLocalService creditAppPrincipalLocalService) {
		_creditAppPrincipalLocalService = creditAppPrincipalLocalService;
	}

	private CreditAppPrincipalLocalService _creditAppPrincipalLocalService;
}