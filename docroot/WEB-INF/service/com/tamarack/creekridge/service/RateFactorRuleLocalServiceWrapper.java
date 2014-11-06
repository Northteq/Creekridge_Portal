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
 * Provides a wrapper for {@link RateFactorRuleLocalService}.
 *
 * @author pmacha
 * @see RateFactorRuleLocalService
 * @generated
 */
public class RateFactorRuleLocalServiceWrapper
	implements RateFactorRuleLocalService,
		ServiceWrapper<RateFactorRuleLocalService> {
	public RateFactorRuleLocalServiceWrapper(
		RateFactorRuleLocalService rateFactorRuleLocalService) {
		_rateFactorRuleLocalService = rateFactorRuleLocalService;
	}

	/**
	* Adds the rate factor rule to the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRule the rate factor rule
	* @return the rate factor rule that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.RateFactorRule addRateFactorRule(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.addRateFactorRule(rateFactorRule);
	}

	/**
	* Creates a new rate factor rule with the primary key. Does not add the rate factor rule to the database.
	*
	* @param rateFactorRuleId the primary key for the new rate factor rule
	* @return the new rate factor rule
	*/
	@Override
	public com.tamarack.creekridge.model.RateFactorRule createRateFactorRule(
		long rateFactorRuleId) {
		return _rateFactorRuleLocalService.createRateFactorRule(rateFactorRuleId);
	}

	/**
	* Deletes the rate factor rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule that was removed
	* @throws PortalException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.RateFactorRule deleteRateFactorRule(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.deleteRateFactorRule(rateFactorRuleId);
	}

	/**
	* Deletes the rate factor rule from the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRule the rate factor rule
	* @return the rate factor rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.RateFactorRule deleteRateFactorRule(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.deleteRateFactorRule(rateFactorRule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rateFactorRuleLocalService.dynamicQuery();
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
		return _rateFactorRuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rateFactorRuleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rateFactorRuleLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _rateFactorRuleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rateFactorRuleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.tamarack.creekridge.model.RateFactorRule fetchRateFactorRule(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.fetchRateFactorRule(rateFactorRuleId);
	}

	/**
	* Returns the rate factor rule with the primary key.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule
	* @throws PortalException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.RateFactorRule getRateFactorRule(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.getRateFactorRule(rateFactorRuleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the rate factor rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> getRateFactorRules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.getRateFactorRules(start, end);
	}

	/**
	* Returns the number of rate factor rules.
	*
	* @return the number of rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRateFactorRulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.getRateFactorRulesCount();
	}

	/**
	* Updates the rate factor rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRule the rate factor rule
	* @return the rate factor rule that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.tamarack.creekridge.model.RateFactorRule updateRateFactorRule(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateFactorRuleLocalService.updateRateFactorRule(rateFactorRule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rateFactorRuleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rateFactorRuleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rateFactorRuleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> getRateFactorRuleByVendorIdActiveStatus(
		long vendorId, boolean active) throws java.lang.Exception {
		return _rateFactorRuleLocalService.getRateFactorRuleByVendorIdActiveStatus(vendorId,
			active);
	}

	@Override
	public com.tamarack.creekridge.model.RateFactorRule getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(
		long vendorId, boolean active, long productId, long termId,
		long purchaseOptionId) throws java.lang.Exception {
		return _rateFactorRuleLocalService.getRateFactorRuleByVendorIdActiveStatusProductIdTermIdPurchaseOptionId(vendorId,
			active, productId, termId, purchaseOptionId);
	}

	@Override
	public com.tamarack.creekridge.model.RateFactorRule getRateFactorRuleByMatchingEquipmentPrice(
		long vendorId, boolean active, long productId, long termId,
		long purchaseOptionId, double equipmentPrice)
		throws java.lang.Exception {
		return _rateFactorRuleLocalService.getRateFactorRuleByMatchingEquipmentPrice(vendorId,
			active, productId, termId, purchaseOptionId, equipmentPrice);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RateFactorRuleLocalService getWrappedRateFactorRuleLocalService() {
		return _rateFactorRuleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRateFactorRuleLocalService(
		RateFactorRuleLocalService rateFactorRuleLocalService) {
		_rateFactorRuleLocalService = rateFactorRuleLocalService;
	}

	@Override
	public RateFactorRuleLocalService getWrappedService() {
		return _rateFactorRuleLocalService;
	}

	@Override
	public void setWrappedService(
		RateFactorRuleLocalService rateFactorRuleLocalService) {
		_rateFactorRuleLocalService = rateFactorRuleLocalService;
	}

	private RateFactorRuleLocalService _rateFactorRuleLocalService;
}