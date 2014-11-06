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

import com.tamarack.creekridge.model.PurchaseOption;

import java.util.List;

/**
 * The persistence utility for the purchase option service. This utility wraps {@link PurchaseOptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see PurchaseOptionPersistence
 * @see PurchaseOptionPersistenceImpl
 * @generated
 */
public class PurchaseOptionUtil {
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
	public static void clearCache(PurchaseOption purchaseOption) {
		getPersistence().clearCache(purchaseOption);
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
	public static List<PurchaseOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PurchaseOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PurchaseOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PurchaseOption update(PurchaseOption purchaseOption)
		throws SystemException {
		return getPersistence().update(purchaseOption);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PurchaseOption update(PurchaseOption purchaseOption,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(purchaseOption, serviceContext);
	}

	/**
	* Returns the purchase option where purchaseOptionName = &#63; or throws a {@link com.tamarack.creekridge.NoSuchPurchaseOptionException} if it could not be found.
	*
	* @param purchaseOptionName the purchase option name
	* @return the matching purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption findByPurchaseOptionName(
		java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException {
		return getPersistence().findByPurchaseOptionName(purchaseOptionName);
	}

	/**
	* Returns the purchase option where purchaseOptionName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param purchaseOptionName the purchase option name
	* @return the matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionName(
		java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPurchaseOptionName(purchaseOptionName);
	}

	/**
	* Returns the purchase option where purchaseOptionName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param purchaseOptionName the purchase option name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionName(
		java.lang.String purchaseOptionName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPurchaseOptionName(purchaseOptionName,
			retrieveFromCache);
	}

	/**
	* Removes the purchase option where purchaseOptionName = &#63; from the database.
	*
	* @param purchaseOptionName the purchase option name
	* @return the purchase option that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption removeByPurchaseOptionName(
		java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException {
		return getPersistence().removeByPurchaseOptionName(purchaseOptionName);
	}

	/**
	* Returns the number of purchase options where purchaseOptionName = &#63;.
	*
	* @param purchaseOptionName the purchase option name
	* @return the number of matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPurchaseOptionName(
		java.lang.String purchaseOptionName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPurchaseOptionName(purchaseOptionName);
	}

	/**
	* Returns all the purchase options where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @return the matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.PurchaseOption> findByPurchaseOptionId(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPurchaseOptionId(purchaseOptionId);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.PurchaseOption> findByPurchaseOptionId(
		long purchaseOptionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPurchaseOptionId(purchaseOptionId, start, end);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.PurchaseOption> findByPurchaseOptionId(
		long purchaseOptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPurchaseOptionId(purchaseOptionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption findByPurchaseOptionId_First(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException {
		return getPersistence()
				   .findByPurchaseOptionId_First(purchaseOptionId,
			orderByComparator);
	}

	/**
	* Returns the first purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionId_First(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPurchaseOptionId_First(purchaseOptionId,
			orderByComparator);
	}

	/**
	* Returns the last purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption findByPurchaseOptionId_Last(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException {
		return getPersistence()
				   .findByPurchaseOptionId_Last(purchaseOptionId,
			orderByComparator);
	}

	/**
	* Returns the last purchase option in the ordered set where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching purchase option, or <code>null</code> if a matching purchase option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption fetchByPurchaseOptionId_Last(
		long purchaseOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPurchaseOptionId_Last(purchaseOptionId,
			orderByComparator);
	}

	/**
	* Removes all the purchase options where purchaseOptionId = &#63; from the database.
	*
	* @param purchaseOptionId the purchase option ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPurchaseOptionId(long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPurchaseOptionId(purchaseOptionId);
	}

	/**
	* Returns the number of purchase options where purchaseOptionId = &#63;.
	*
	* @param purchaseOptionId the purchase option ID
	* @return the number of matching purchase options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPurchaseOptionId(long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPurchaseOptionId(purchaseOptionId);
	}

	/**
	* Caches the purchase option in the entity cache if it is enabled.
	*
	* @param purchaseOption the purchase option
	*/
	public static void cacheResult(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption) {
		getPersistence().cacheResult(purchaseOption);
	}

	/**
	* Caches the purchase options in the entity cache if it is enabled.
	*
	* @param purchaseOptions the purchase options
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.PurchaseOption> purchaseOptions) {
		getPersistence().cacheResult(purchaseOptions);
	}

	/**
	* Creates a new purchase option with the primary key. Does not add the purchase option to the database.
	*
	* @param purchaseOptionId the primary key for the new purchase option
	* @return the new purchase option
	*/
	public static com.tamarack.creekridge.model.PurchaseOption create(
		long purchaseOptionId) {
		return getPersistence().create(purchaseOptionId);
	}

	/**
	* Removes the purchase option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option that was removed
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption remove(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException {
		return getPersistence().remove(purchaseOptionId);
	}

	public static com.tamarack.creekridge.model.PurchaseOption updateImpl(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(purchaseOption);
	}

	/**
	* Returns the purchase option with the primary key or throws a {@link com.tamarack.creekridge.NoSuchPurchaseOptionException} if it could not be found.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option
	* @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption findByPrimaryKey(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchPurchaseOptionException {
		return getPersistence().findByPrimaryKey(purchaseOptionId);
	}

	/**
	* Returns the purchase option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param purchaseOptionId the primary key of the purchase option
	* @return the purchase option, or <code>null</code> if a purchase option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.PurchaseOption fetchByPrimaryKey(
		long purchaseOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(purchaseOptionId);
	}

	/**
	* Returns all the purchase options.
	*
	* @return the purchase options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.PurchaseOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.tamarack.creekridge.model.PurchaseOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.PurchaseOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the purchase options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of purchase options.
	*
	* @return the number of purchase options
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PurchaseOptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PurchaseOptionPersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					PurchaseOptionPersistence.class.getName());

			ReferenceRegistry.registerReference(PurchaseOptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PurchaseOptionPersistence persistence) {
	}

	private static PurchaseOptionPersistence _persistence;
}