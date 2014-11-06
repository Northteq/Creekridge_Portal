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

import com.tamarack.creekridge.model.Vendor;

/**
 * The persistence interface for the vendor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see VendorPersistenceImpl
 * @see VendorUtil
 * @generated
 */
public interface VendorPersistence extends BasePersistence<Vendor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VendorUtil} to access the vendor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the vendors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vendors where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vendors where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vendor in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vendor in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vendors before and after the current vendor in the ordered set where groupId = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws com.tamarack.creekridge.NoSuchVendorException if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor[] findByGroupId_PrevAndNext(
		long vendorId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorException;

	/**
	* Removes all the vendors where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vendors where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vendors where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @return the matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findByVendorId(
		long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vendors where vendorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vendorId the vendor ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findByVendorId(
		long vendorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vendors where vendorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vendorId the vendor ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findByVendorId(
		long vendorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vendor in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor findByVendorId_First(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor fetchByVendorId_First(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vendor in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor findByVendorId_Last(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor fetchByVendorId_Last(
		long vendorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vendors where vendorId = &#63; from the database.
	*
	* @param vendorId the vendor ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVendorId(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vendors where vendorId = &#63;.
	*
	* @param vendorId the vendor ID
	* @return the number of matching vendors
	* @throws SystemException if a system exception occurred
	*/
	public int countByVendorId(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the vendor in the entity cache if it is enabled.
	*
	* @param vendor the vendor
	*/
	public void cacheResult(com.tamarack.creekridge.model.Vendor vendor);

	/**
	* Caches the vendors in the entity cache if it is enabled.
	*
	* @param vendors the vendors
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.Vendor> vendors);

	/**
	* Creates a new vendor with the primary key. Does not add the vendor to the database.
	*
	* @param vendorId the primary key for the new vendor
	* @return the new vendor
	*/
	public com.tamarack.creekridge.model.Vendor create(long vendorId);

	/**
	* Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor that was removed
	* @throws com.tamarack.creekridge.NoSuchVendorException if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor remove(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorException;

	public com.tamarack.creekridge.model.Vendor updateImpl(
		com.tamarack.creekridge.model.Vendor vendor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vendor with the primary key or throws a {@link com.tamarack.creekridge.NoSuchVendorException} if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor
	* @throws com.tamarack.creekridge.NoSuchVendorException if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor findByPrimaryKey(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchVendorException;

	/**
	* Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Vendor fetchByPrimaryKey(long vendorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vendors.
	*
	* @return the vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vendors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Vendor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vendors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vendors.
	*
	* @return the number of vendors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}