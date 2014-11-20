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
 * Provides a wrapper for {@link CreditAppBankReferenceLocalService}.
 *
 * @author pmacha
 * @see CreditAppBankReferenceLocalService
 * @generated
 */
public class CreditAppBankReferenceLocalServiceWrapper
	implements CreditAppBankReferenceLocalService,
		ServiceWrapper<CreditAppBankReferenceLocalService> {
	public CreditAppBankReferenceLocalServiceWrapper(
		CreditAppBankReferenceLocalService creditAppBankReferenceLocalService) {
		_creditAppBankReferenceLocalService = creditAppBankReferenceLocalService;
	}

	/**
	* Adds the credit app bank reference to the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppBankReference the credit app bank reference
	* @return the credit app bank reference that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference addCreditAppBankReference(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.addCreditAppBankReference(creditAppBankReference);
	}

	/**
	* Creates a new credit app bank reference with the primary key. Does not add the credit app bank reference to the database.
	*
	* @param bankReferenceId the primary key for the new credit app bank reference
	* @return the new credit app bank reference
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference createCreditAppBankReference(
		long bankReferenceId) {
		return _creditAppBankReferenceLocalService.createCreditAppBankReference(bankReferenceId);
	}

	/**
	* Deletes the credit app bank reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference that was removed
	* @throws PortalException if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference deleteCreditAppBankReference(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.deleteCreditAppBankReference(bankReferenceId);
	}

	/**
	* Deletes the credit app bank reference from the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppBankReference the credit app bank reference
	* @return the credit app bank reference that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference deleteCreditAppBankReference(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.deleteCreditAppBankReference(creditAppBankReference);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _creditAppBankReferenceLocalService.dynamicQuery();
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
		return _creditAppBankReferenceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _creditAppBankReferenceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _creditAppBankReferenceLocalService.dynamicQuery(dynamicQuery,
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
		return _creditAppBankReferenceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _creditAppBankReferenceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference fetchCreditAppBankReference(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.fetchCreditAppBankReference(bankReferenceId);
	}

	/**
	* Returns the credit app bank reference with the primary key.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference
	* @throws PortalException if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference getCreditAppBankReference(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.getCreditAppBankReference(bankReferenceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the credit app bank references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit app bank references
	* @param end the upper bound of the range of credit app bank references (not inclusive)
	* @return the range of credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> getCreditAppBankReferences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.getCreditAppBankReferences(start,
			end);
	}

	/**
	* Returns the number of credit app bank references.
	*
	* @return the number of credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCreditAppBankReferencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.getCreditAppBankReferencesCount();
	}

	/**
	* Updates the credit app bank reference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creditAppBankReference the credit app bank reference
	* @return the credit app bank reference that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference updateCreditAppBankReference(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReferenceLocalService.updateCreditAppBankReference(creditAppBankReference);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _creditAppBankReferenceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_creditAppBankReferenceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _creditAppBankReferenceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> getCreditAppBankReferenceByCreditApp(
		long creditAppId) throws java.lang.Exception {
		return _creditAppBankReferenceLocalService.getCreditAppBankReferenceByCreditApp(creditAppId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CreditAppBankReferenceLocalService getWrappedCreditAppBankReferenceLocalService() {
		return _creditAppBankReferenceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCreditAppBankReferenceLocalService(
		CreditAppBankReferenceLocalService creditAppBankReferenceLocalService) {
		_creditAppBankReferenceLocalService = creditAppBankReferenceLocalService;
	}

	@Override
	public CreditAppBankReferenceLocalService getWrappedService() {
		return _creditAppBankReferenceLocalService;
	}

	@Override
	public void setWrappedService(
		CreditAppBankReferenceLocalService creditAppBankReferenceLocalService) {
		_creditAppBankReferenceLocalService = creditAppBankReferenceLocalService;
	}

	private CreditAppBankReferenceLocalService _creditAppBankReferenceLocalService;
}