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

import com.tamarack.creekridge.model.VendorMessage;

import java.util.List;

/**
 * The persistence utility for the vendor message service. This utility wraps {@link VendorMessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see VendorMessagePersistence
 * @see VendorMessagePersistenceImpl
 * @generated
 */
public class VendorMessageUtil {
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
	public static void clearCache(VendorMessage vendorMessage) {
		getPersistence().clearCache(vendorMessage);
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
	public static List<VendorMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VendorMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VendorMessage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VendorMessage update(VendorMessage vendorMessage)
		throws SystemException {
		return getPersistence().update(vendorMessage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VendorMessage update(VendorMessage vendorMessage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vendorMessage, serviceContext);
	}

	/**
	* Returns all the vendor messages where key = &#63;.
	*
	* @param key the key
	* @return the matching vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.VendorMessage> findByName(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(key);
	}

	/**
	* Returns a range of all the vendor messages where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param key the key
	* @param start the lower bound of the range of vendor messages
	* @param end the upper bound of the range of vendor messages (not inclusive)
	* @return the range of matching vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.VendorMessage> findByName(
		java.lang.String key, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(key, start, end);
	}

	/**
	* Returns an ordered range of all the vendor messages where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param key the key
	* @param start the lower bound of the range of vendor messages
	* @param end the upper bound of the range of vendor messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.VendorMessage> findByName(
		java.lang.String key, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(key, start, end, orderByComparator);
	}

	/**
	* Returns the first vendor message in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor message
	* @throws com.tamarack.creekridge.NoSuchVendorMessageException if a matching vendor message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage findByName_First(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorMessageException {
		return getPersistence().findByName_First(key, orderByComparator);
	}

	/**
	* Returns the first vendor message in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor message, or <code>null</code> if a matching vendor message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage fetchByName_First(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(key, orderByComparator);
	}

	/**
	* Returns the last vendor message in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor message
	* @throws com.tamarack.creekridge.NoSuchVendorMessageException if a matching vendor message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage findByName_Last(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorMessageException {
		return getPersistence().findByName_Last(key, orderByComparator);
	}

	/**
	* Returns the last vendor message in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor message, or <code>null</code> if a matching vendor message could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage fetchByName_Last(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(key, orderByComparator);
	}

	/**
	* Returns the vendor messages before and after the current vendor message in the ordered set where key = &#63;.
	*
	* @param vendorId the primary key of the current vendor message
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor message
	* @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage[] findByName_PrevAndNext(
		long vendorId, java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorMessageException {
		return getPersistence()
				   .findByName_PrevAndNext(vendorId, key, orderByComparator);
	}

	/**
	* Removes all the vendor messages where key = &#63; from the database.
	*
	* @param key the key
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(key);
	}

	/**
	* Returns the number of vendor messages where key = &#63;.
	*
	* @param key the key
	* @return the number of matching vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(key);
	}

	/**
	* Caches the vendor message in the entity cache if it is enabled.
	*
	* @param vendorMessage the vendor message
	*/
	public static void cacheResult(
		com.tamarack.creekridge.model.VendorMessage vendorMessage) {
		getPersistence().cacheResult(vendorMessage);
	}

	/**
	* Caches the vendor messages in the entity cache if it is enabled.
	*
	* @param vendorMessages the vendor messages
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.VendorMessage> vendorMessages) {
		getPersistence().cacheResult(vendorMessages);
	}

	/**
	* Creates a new vendor message with the primary key. Does not add the vendor message to the database.
	*
	* @param vendorId the primary key for the new vendor message
	* @return the new vendor message
	*/
	public static com.tamarack.creekridge.model.VendorMessage create(
		long vendorId) {
		return getPersistence().create(vendorId);
	}

	/**
	* Removes the vendor message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vendorId the primary key of the vendor message
	* @return the vendor message that was removed
	* @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage remove(
		long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorMessageException {
		return getPersistence().remove(vendorId);
	}

	public static com.tamarack.creekridge.model.VendorMessage updateImpl(
		com.tamarack.creekridge.model.VendorMessage vendorMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vendorMessage);
	}

	/**
	* Returns the vendor message with the primary key or throws a {@link com.tamarack.creekridge.NoSuchVendorMessageException} if it could not be found.
	*
	* @param vendorId the primary key of the vendor message
	* @return the vendor message
	* @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage findByPrimaryKey(
		long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorMessageException {
		return getPersistence().findByPrimaryKey(vendorId);
	}

	/**
	* Returns the vendor message with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vendorId the primary key of the vendor message
	* @return the vendor message, or <code>null</code> if a vendor message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.VendorMessage fetchByPrimaryKey(
		long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vendorId);
	}

	/**
	* Returns all the vendor messages.
	*
	* @return the vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.VendorMessage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vendor messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendor messages
	* @param end the upper bound of the range of vendor messages (not inclusive)
	* @return the range of vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.VendorMessage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vendor messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendor messages
	* @param end the upper bound of the range of vendor messages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.VendorMessage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vendor messages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vendor messages.
	*
	* @return the number of vendor messages
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VendorMessagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VendorMessagePersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					VendorMessagePersistence.class.getName());

			ReferenceRegistry.registerReference(VendorMessageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VendorMessagePersistence persistence) {
	}

	private static VendorMessagePersistence _persistence;
}