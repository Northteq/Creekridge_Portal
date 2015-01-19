/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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
 * @author Tamarack Consulting
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
	* Returns all the rate factor rules where active = &#63; and vendorId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendor(
		boolean active, long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rate factor rules where active = &#63; and vendorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendor(
		boolean active, long vendorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rate factor rules where active = &#63; and vendorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendor(
		boolean active, long vendorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendor_First(
		boolean active, long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendor_First(
		boolean active, long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendor_Last(
		boolean active, long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendor_Last(
		boolean active, long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rate factor rules before and after the current rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	*
	* @param rateFactorRuleId the primary key of the current rate factor rule
	* @param active the active
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule[] findByVendor_PrevAndNext(
		long rateFactorRuleId, boolean active, long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Removes all the rate factor rules where active = &#63; and vendorId = &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVendor(boolean active, long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByVendor(boolean active, long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductPrice(
		boolean active, long vendorId, long productId, double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductPrice(
		boolean active, long vendorId, long productId, double minPrice,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductPrice(
		boolean active, long vendorId, long productId, double minPrice,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorProductPrice_First(
		boolean active, long vendorId, long productId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorProductPrice_First(
		boolean active, long vendorId, long productId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorProductPrice_Last(
		boolean active, long vendorId, long productId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorProductPrice_Last(
		boolean active, long vendorId, long productId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rate factor rules before and after the current rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* @param rateFactorRuleId the primary key of the current rate factor rule
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule[] findByVendorProductPrice_PrevAndNext(
		long rateFactorRuleId, boolean active, long vendorId, long productId,
		double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Removes all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVendorProductPrice(boolean active, long vendorId,
		long productId, double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param minPrice the min price
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByVendorProductPrice(boolean active, long vendorId,
		long productId, double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductPurchaseOptionPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductPurchaseOptionPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		double minPrice, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductPurchaseOptionPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		double minPrice, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorProductPurchaseOptionPrice_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorProductPurchaseOptionPrice_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorProductPurchaseOptionPrice_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorProductPurchaseOptionPrice_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rate factor rules before and after the current rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* @param rateFactorRuleId the primary key of the current rate factor rule
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule[] findByVendorProductPurchaseOptionPrice_PrevAndNext(
		long rateFactorRuleId, boolean active, long vendorId, long productId,
		long purchaseOptionId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Removes all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVendorProductPurchaseOptionPrice(boolean active,
		long vendorId, long productId, long purchaseOptionId, double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param minPrice the min price
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByVendorProductPurchaseOptionPrice(boolean active,
		long vendorId, long productId, long purchaseOptionId, double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @return the matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductOptionTermPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @return the range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductOptionTermPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @param start the lower bound of the range of rate factor rules
	* @param end the upper bound of the range of rate factor rules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.RateFactorRule> findByVendorProductOptionTermPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorProductOptionTermPrice_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorProductOptionTermPrice_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule findByVendorProductOptionTermPrice_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule fetchByVendorProductOptionTermPrice_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rate factor rules before and after the current rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* @param rateFactorRuleId the primary key of the current rate factor rule
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rate factor rule
	* @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.RateFactorRule[] findByVendorProductOptionTermPrice_PrevAndNext(
		long rateFactorRuleId, boolean active, long vendorId, long productId,
		long purchaseOptionId, long termId, double minPrice,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchRateFactorRuleException;

	/**
	* Removes all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63; from the database.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVendorProductOptionTermPrice(boolean active,
		long vendorId, long productId, long purchaseOptionId, long termId,
		double minPrice)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &lt; &#63;.
	*
	* @param active the active
	* @param vendorId the vendor ID
	* @param productId the product ID
	* @param purchaseOptionId the purchase option ID
	* @param termId the term ID
	* @param minPrice the min price
	* @return the number of matching rate factor rules
	* @throws SystemException if a system exception occurred
	*/
	public int countByVendorProductOptionTermPrice(boolean active,
		long vendorId, long productId, long purchaseOptionId, long termId,
		double minPrice)
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