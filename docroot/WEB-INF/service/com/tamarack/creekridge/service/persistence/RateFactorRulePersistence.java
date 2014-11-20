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

import com.liferay.portal.service.persistence.BasePersistence;

import com.tamarack.creekridge.model.RateFactorRule;

/**
 * The persistence interface for the rate factor rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see RateFactorRulePersistenceImpl
 * @see RateFactorRuleUtil
 * @generated
 */
public interface RateFactorRulePersistence extends BasePersistence<RateFactorRule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RateFactorRuleUtil} to access the rate factor rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rate factor rules where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByA_V(
		long vendorId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByA_V(
		long vendorId, boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByA_V(
		long vendorId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule findByA_V_First(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the first rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_First(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule findByA_V_Last(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the last rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_Last(
		long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule[] findByA_V_PrevAndNext(
		long rateFactorRuleId, long vendorId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Removes all the rate factor rules where vendorId = &#63; and active = &#63; from the database.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA_V(long vendorId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules where vendorId = &#63; and active = &#63;.
	*
	* @param vendorId the vendor ID
	* @param active the active
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_V(long vendorId, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule findByA_V_P(
		boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @return the matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P(
		boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P(
		boolean active, long vendorId, long productId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rate factor rule where active = &#63; and vendorId = &#63; and productId = &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @return the rate factor rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule removeByA_V_P(
		boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_V_P(boolean active, long vendorId, long productId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule findByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

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
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule removeByA_V_P_P(
		boolean active, long vendorId, long productId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

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
	public int countByA_V_P_P(boolean active, long vendorId, long productId,
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule findByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

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
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule fetchByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule removeByA_V_P_T_P(
		boolean active, long vendorId, long productId, long termId,
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

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
	public int countByA_V_P_T_P(boolean active, long vendorId, long productId,
		long termId, long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rate factor rules where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorId(
		long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorId(
		long vendorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorId(
		long vendorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorId_First(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the first rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorId_First(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorId_Last(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the last rate factor rule in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorId_Last(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.RateFactorRule[] findByVendorId_PrevAndNext(
		long rateFactorRuleId, long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Removes all the rate factor rules where vendorId = &#63; from the database.
	*
	* @param vendorId the vendor ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVendorId(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByVendorId(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rate factor rules where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByrateFactorRuleId(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByrateFactorRuleId(
		long rateFactorRuleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByrateFactorRuleId(
		long rateFactorRuleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByrateFactorRuleId_First(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the first rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByrateFactorRuleId_First(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByrateFactorRuleId_Last(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the last rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByrateFactorRuleId_Last(
		long rateFactorRuleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rate factor rules where rateFactorRuleId = &#63; from the database.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrateFactorRuleId(long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules where rateFactorRuleId = &#63;.
	*
	* @param rateFactorRuleId the rate factor rule ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByrateFactorRuleId(long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the rate factor rule in the entity cache if it is enabled.
	*
	* @param rateFactorRule the rate factor rule
	*/
	public void cacheResult(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule);

	/**
	* Caches the rate factor rules in the entity cache if it is enabled.
	*
	* @param rateFactorRules the rate factor rules
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.RateFactorRule> rateFactorRules);

	/**
	* Creates a new rate factor rule with the primary key. Does not add the rate factor rule to the database.
	*
	* @param rateFactorRuleId the primary key for the new rate factor rule
	* @return the new rate factor rule
	*/
	public com.tamarack.creekridge.model.RateFactorRule create(
		long rateFactorRuleId);

	/**
	* Removes the rate factor rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule that was removed
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule remove(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	public com.tamarack.creekridge.model.RateFactorRule updateImpl(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rate factor rule with the primary key or throws a {@link com.tamarack.creekridge.NoSuchRateFactorRuleException} if it could not be found.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByPrimaryKey(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the rate factor rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rateFactorRuleId the primary key of the rate factor rule
	* @return the rate factor rule, or <code>null</code> if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByPrimaryKey(
		long rateFactorRuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rate factor rules.
	*
	* @return the rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rate factor rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules.
	*
	* @return the number of rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}