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

package com.tamarack.creekridge.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.tamarack.creekridge.model.RateFactorRule;

import java.util.List;

/**
 * The persistence utility for the rate factor rule service. This utility wraps {@link RateFactorRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see RateFactorRulePersistence
 * @see RateFactorRulePersistenceImpl
 * @generated
 */
public class RateFactorRuleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(RateFactorRule rateFactorRule) {
		getPersistence().clearCache(rateFactorRule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RateFactorRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RateFactorRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RateFactorRule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RateFactorRule update(RateFactorRule rateFactorRule)
		throws SystemException {
		return getPersistence().update(rateFactorRule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RateFactorRule update(RateFactorRule rateFactorRule,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rateFactorRule, serviceContext);
	}

	/**
	* Returns all the rate factor rules where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByA_V(
		long vendorId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_V(vendorId, active);
	}

	/**
	* Returns a range of all the rate factor rules where vendorId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByA_V(
		long vendorId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA_V(vendorId, active, start, end);
	}

	/**
	* Returns an ordered range of all the rate factor rules where vendorId = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByA_V(
		long vendorId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByA_V(vendorId, active, start, end, orderByComparator);
	}

	/**
	* Returns the first rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByA_V_First(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByA_V_First(vendorId, active, orderByComparator);
	}

	/**
	* Returns the first rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_First(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_V_First(vendorId, active, orderByComparator);
	}

	/**
	* Returns the last rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByA_V_Last(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByA_V_Last(vendorId, active, orderByComparator);
	}

	/**
	* Returns the last rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_Last(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_V_Last(vendorId, active, orderByComparator);
	}

	/**
	* Returns the rate factor rules before and after the current rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	*
	* @param rateFactorRuleId the primary key of the current rate factor rule
	* @param vendorId the vendor ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule[] findByA_V_PrevAndNext(
		long rateFactorRuleId, long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByA_V_PrevAndNext(rateFactorRuleId, vendorId, active,
			orderByComparator);
	}

	/**
	* Removes all the rate factor rules where vendorId = &#63; and active = &#63; from the database.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA_V(long vendorId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA_V(vendorId, active);
	}

	/**
	* Returns the number of rate factor rules where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_V(long vendorId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA_V(vendorId, active);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; or throws a {@link com.tamarack.creekridge.NoSuchRateFactorRuleException} if it could not be found.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @return the matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByA_V_P(
		boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence().findByA_V_P(active, vendorId, productId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @return the matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P(
		boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByA_V_P(active, vendorId, productId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P(
		boolean active, long vendorId, long productId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_V_P(active, vendorId, productId, retrieveFromCache);
	}

	/**
	* Removes the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @return the rate factor rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule removeByA_V_P(
		boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence().removeByA_V_P(active, vendorId, productId);
	}

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_V_P(boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA_V_P(active, vendorId, productId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; or throws a {@link com.tamarack.creekridge.NoSuchRateFactorRuleException} if it could not be found.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @return the matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByA_V_P_P(active, vendorId, productId, purchaseOptionId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @return the matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_V_P_P(active, vendorId, productId, purchaseOptionId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_V_P_P(active, vendorId, productId,
			purchaseOptionId, retrieveFromCache);
	}

	/**
	* Removes the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @return the rate factor rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule removeByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .removeByA_V_P_P(active, vendorId, productId,
			purchaseOptionId);
	}

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_V_P_P(boolean active, long vendorId,
		long productId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByA_V_P_P(active, vendorId, productId, purchaseOptionId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and termId = &#63; and purchaseOptionId = &#63; or throws a {@link com.tamarack.creekridge.NoSuchRateFactorRuleException} if it could not be found.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param termId the term ID
	* @param purchaseOptionId the purchase option ID
	* @return the matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByA_V_P_T_P(active, vendorId, productId, termId,
			purchaseOptionId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and termId = &#63; and purchaseOptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param termId the term ID
	* @param purchaseOptionId the purchase option ID
	* @return the matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_V_P_T_P(active, vendorId, productId, termId,
			purchaseOptionId);
	}

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and termId = &#63; and purchaseOptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param termId the term ID
	* @param purchaseOptionId the purchase option ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByA_V_P_T_P(active, vendorId, productId, termId,
			purchaseOptionId, retrieveFromCache);
	}

	/**
	* Removes the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; and termId = &#63; and purchaseOptionId = &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param termId the term ID
	* @param purchaseOptionId the purchase option ID
	* @return the rate factor rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule removeByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .removeByA_V_P_T_P(active, vendorId, productId, termId,
			purchaseOptionId);
	}

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and termId = &#63; and purchaseOptionId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param termId the term ID
	* @param purchaseOptionId the purchase option ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA_V_P_T_P(boolean active, long vendorId,
		long productId, long termId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByA_V_P_T_P(active, vendorId, productId, termId,
			purchaseOptionId);
	}

	/**
	* Returns all the rate factor rules where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorId(
		long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVendorId(vendorId);
	}

	/**
	* Returns a range of all the rate factor rules where vendorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vendorId the vendor ID
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorId(
		long vendorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVendorId(vendorId, start, end);
	}

	/**
	* Returns an ordered range of all the rate factor rules where vendorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vendorId the vendor ID
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorId(
		long vendorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVendorId(vendorId, start, end, orderByComparator);
	}

	/**
	* Returns the first rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByVendorId_First(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence().findByVendorId_First(vendorId, orderByComparator);
	}

	/**
	* Returns the first rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByVendorId_First(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVendorId_First(vendorId, orderByComparator);
	}

	/**
	* Returns the last rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByVendorId_Last(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence().findByVendorId_Last(vendorId, orderByComparator);
	}

	/**
	* Returns the last rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByVendorId_Last(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVendorId_Last(vendorId, orderByComparator);
	}

	/**
	* Returns the rate factor rules before and after the current rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param rateFactorRuleId the primary key of the current rate factor rule
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule[] findByVendorId_PrevAndNext(
		long rateFactorRuleId, long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByVendorId_PrevAndNext(rateFactorRuleId, vendorId,
			orderByComparator);
	}

	/**
	* Removes all the rate factor rules where vendorId = &#63; from the database.
	*
	* @param vendorId the vendor ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVendorId(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVendorId(vendorId);
	}

	/**
	* Returns the number of rate factor rules where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVendorId(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVendorId(vendorId);
	}

	/**
	* Returns all the rate factor rules where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByrateFactorRuleId(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrateFactorRuleId(rateFactorRuleId);
	}

	/**
	* Returns a range of all the rate factor rules where rateFactorRuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByrateFactorRuleId(
		long rateFactorRuleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrateFactorRuleId(rateFactorRuleId, start, end);
	}

	/**
	* Returns an ordered range of all the rate factor rules where rateFactorRuleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByrateFactorRuleId(
		long rateFactorRuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrateFactorRuleId(rateFactorRuleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByrateFactorRuleId_First(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByrateFactorRuleId_First(rateFactorRuleId,
			orderByComparator);
	}

	/**
	* Returns the first rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByrateFactorRuleId_First(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrateFactorRuleId_First(rateFactorRuleId,
			orderByComparator);
	}

	/**
	* Returns the last rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByrateFactorRuleId_Last(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence()
				   .findByrateFactorRuleId_Last(rateFactorRuleId,
			orderByComparator);
	}

	/**
	* Returns the last rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByrateFactorRuleId_Last(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrateFactorRuleId_Last(rateFactorRuleId,
			orderByComparator);
	}

	/**
	* Removes all the rate factor rules where rateFactorRuleId = &#63; from the database.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByrateFactorRuleId(long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByrateFactorRuleId(rateFactorRuleId);
	}

	/**
	* Returns the number of rate factor rules where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByrateFactorRuleId(long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByrateFactorRuleId(rateFactorRuleId);
	}

	/**
	* Caches the rate factor rule in the entity cache if it is enabled.
	*
	* @param rateFactorRule the rate factor rule
	*/
	public static void cacheResult(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule) {
		getPersistence().cacheResult(rateFactorRule);
	}

	/**
	* Caches the rate factor rules in the entity cache if it is enabled.
	*
	* @param rateFactorRules the rate factor rules
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.RateFactorRule> rateFactorRules) {
		getPersistence().cacheResult(rateFactorRules);
	}

	/**
	* Creates a new rate factor rule with the primary key. Does not add the rate factor rule to the database.
	*
	* @param rateFactorRuleId the primary key for the new rate factor rule
	* @return the new rate factor rule
	*/
	public static com.tamarack.creekridge.model.RateFactorRule create(
		long rateFactorRuleId) {
		return getPersistence().create(rateFactorRuleId);
	}

	/**
	* Removes the rate factor rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule that was removed
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule remove(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence().remove(rateFactorRuleId);
	}

	public static com.tamarack.creekridge.model.RateFactorRule updateImpl(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rateFactorRule);
	}

	/**
	* Returns the rate factor rule with the primary key or throws a {@link com.tamarack.creekridge.NoSuchRateFactorRuleException} if it could not be found.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule findByPrimaryKey(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException {
		return getPersistence().findByPrimaryKey(rateFactorRuleId);
	}

	/**
	* Returns the rate factor rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule, or <code>null</code> if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.RateFactorRule fetchByPrimaryKey(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rateFactorRuleId);
	}

	/**
	* Returns all the rate factor rules.
	*
	* @return the rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rate factor rules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.RateFactorRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rate factor rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rate factor rules.
	*
	* @return the number of rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RateFactorRulePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RateFactorRulePersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					RateFactorRulePersistence.class.getName());

			ReferenceRegistry.registerReference(RateFactorRuleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RateFactorRulePersistence persistence) {
	}

	private static RateFactorRulePersistence _persistence;
}