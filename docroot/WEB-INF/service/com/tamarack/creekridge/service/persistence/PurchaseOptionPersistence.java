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

import com.tamarack.creekridge.model.PurchaseOption;

/**
 * The persistence interface for the purchase option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see PurchaseOptionPersistenceImpl
 * @see PurchaseOptionUtil
 * @generated
 */
public interface PurchaseOptionPersistence extends BasePersistence<PurchaseOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PurchaseOptionUtil} to access the purchase option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the purchase option where purchaseOptionName = &#63; or throws a {@link com.tamarack.creekridge.NoSuchPurchaseOptionException} if it could not be found.
	*
	* @param purchaseOptionName the purchase option name
	* @return the matching purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption findByPurchaseOptionName(
		java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException;

	/**
	* Returns the purchase option where purchaseOptionName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param purchaseOptionName the purchase option name
	* @return the matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionName(
		java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the purchase option where purchaseOptionName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param purchaseOptionName the purchase option name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionName(
		java.lang.String purchaseOptionName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the purchase option where purchaseOptionName = &#63; from the database.
	*
	* @param purchaseOptionName the purchase option name
	* @return the purchase option that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption removeByPurchaseOptionName(
		java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException;

	/**
	* Returns the number of purchase options where purchaseOptionName = &#63;.
	*
	* @param purchaseOptionName the purchase option name
	* @return the number of matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public int countByPurchaseOptionName(java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the purchase options where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @return the matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.PurchaseOption> findByPurchaseOptionId(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the purchase options where purchaseOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param purchaseOptionId the purchase option ID
	* @param start the lower bound of the range of purchase options
	* @param end the upper bound of the range of purchase options (not inclusive)
	* @return the range of matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.PurchaseOption> findByPurchaseOptionId(
		long purchaseOptionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the purchase options where purchaseOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param purchaseOptionId the purchase option ID
	* @param start the lower bound of the range of purchase options
	* @param end the upper bound of the range of purchase options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.PurchaseOption> findByPurchaseOptionId(
		long purchaseOptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption findByPurchaseOptionId_First(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException;

	/**
	* Returns the first purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionId_First(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption findByPurchaseOptionId_Last(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException;

	/**
	* Returns the last purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionId_Last(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the purchase options where purchaseOptionId = &#63; from the database.
	*
	* @param purchaseOptionId the purchase option ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPurchaseOptionId(long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of purchase options where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @return the number of matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public int countByPurchaseOptionId(long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the purchase option in the entity cache if it is enabled.
	*
	* @param purchaseOption the purchase option
	*/
	public void cacheResult(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption);

	/**
	* Caches the purchase options in the entity cache if it is enabled.
	*
	* @param purchaseOptions the purchase options
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.PurchaseOption> purchaseOptions);

	/**
	* Creates a new purchase option with the primary key. Does not add the purchase option to the database.
	*
	* @param purchaseOptionId the primary key for the new purchase option
	* @return the new purchase option
	*/
	public com.tamarack.creekridge.model.PurchaseOption create(
		long purchaseOptionId);

	/**
	* Removes the purchase option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option that was removed
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption remove(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException;

	public com.tamarack.creekridge.model.PurchaseOption updateImpl(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the purchase option with the primary key or throws a {@link com.tamarack.creekridge.NoSuchPurchaseOptionException} if it could not be found.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption findByPrimaryKey(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException;

	/**
	* Returns the purchase option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option, or <code>null</code> if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.PurchaseOption fetchByPrimaryKey(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the purchase options.
	*
	* @return the purchase options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.PurchaseOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.PurchaseOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the purchase options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of purchase options
	* @param end the upper bound of the range of purchase options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of purchase options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.PurchaseOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the purchase options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of purchase options.
	*
	* @return the number of purchase options
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}