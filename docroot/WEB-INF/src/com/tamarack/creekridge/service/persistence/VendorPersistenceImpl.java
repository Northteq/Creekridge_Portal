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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.tamarack.creekridge.NoSuchVendorException;
import com.tamarack.creekridge.model.Vendor;
import com.tamarack.creekridge.model.impl.VendorImpl;
import com.tamarack.creekridge.model.impl.VendorModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vendor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see VendorPersistence
 * @see VendorUtil
 * @generated
 */
public class VendorPersistenceImpl extends BasePersistenceImpl<Vendor>
	implements VendorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VendorUtil} to access the vendor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VendorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			VendorModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vendors where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vendor> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Vendor> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<Vendor> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Vendor> list = (List<Vendor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vendor vendor : list) {
				if ((groupId != vendor.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Vendor>(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByGroupId_First(groupId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vendor> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByGroupId_Last(groupId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Vendor[] findByGroupId_PrevAndNext(long vendorId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, vendor, groupId,
					orderByComparator, true);

			array[1] = vendor;

			array[2] = getByGroupId_PrevAndNext(session, vendor, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByGroupId_PrevAndNext(Session session, Vendor vendor,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Vendor vendor : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "vendor.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVendorId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVendorId",
			new String[] { Long.class.getName() },
			VendorModelImpl.VENDORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENDORID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVendorId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vendors where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @return the matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vendor> findByVendorId(long vendorId) throws SystemException {
		return findByVendorId(vendorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<Vendor> findByVendorId(long vendorId, int start, int end)
		throws SystemException {
		return findByVendorId(vendorId, start, end, null);
	}

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
	@Override
	public List<Vendor> findByVendorId(long vendorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID;
			finderArgs = new Object[] { vendorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORID;
			finderArgs = new Object[] { vendorId, start, end, orderByComparator };
		}

		List<Vendor> list = (List<Vendor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Vendor vendor : list) {
				if ((vendorId != vendor.getVendorId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_VENDORID_VENDORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vendorId);

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Vendor>(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByVendorId_First(long vendorId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByVendorId_First(vendorId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vendorId=");
		msg.append(vendorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByVendorId_First(long vendorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Vendor> list = findByVendorId(vendorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByVendorId_Last(long vendorId,
		OrderByComparator orderByComparator)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByVendorId_Last(vendorId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vendorId=");
		msg.append(vendorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByVendorId_Last(long vendorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVendorId(vendorId);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByVendorId(vendorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the vendors where vendorId = &#63; from the database.
	 *
	 * @param vendorId the vendor ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVendorId(long vendorId) throws SystemException {
		for (Vendor vendor : findByVendorId(vendorId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @return the number of matching vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVendorId(long vendorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENDORID;

		Object[] finderArgs = new Object[] { vendorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			query.append(_FINDER_COLUMN_VENDORID_VENDORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vendorId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VENDORID_VENDORID_2 = "vendor.vendorId = ?";

	public VendorPersistenceImpl() {
		setModelClass(Vendor.class);
	}

	/**
	 * Caches the vendor in the entity cache if it is enabled.
	 *
	 * @param vendor the vendor
	 */
	@Override
	public void cacheResult(Vendor vendor) {
		EntityCacheUtil.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey(), vendor);

		vendor.resetOriginalValues();
	}

	/**
	 * Caches the vendors in the entity cache if it is enabled.
	 *
	 * @param vendors the vendors
	 */
	@Override
	public void cacheResult(List<Vendor> vendors) {
		for (Vendor vendor : vendors) {
			if (EntityCacheUtil.getResult(
						VendorModelImpl.ENTITY_CACHE_ENABLED, VendorImpl.class,
						vendor.getPrimaryKey()) == null) {
				cacheResult(vendor);
			}
			else {
				vendor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vendors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VendorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VendorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vendor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vendor vendor) {
		EntityCacheUtil.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Vendor> vendors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Vendor vendor : vendors) {
			EntityCacheUtil.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
				VendorImpl.class, vendor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vendor with the primary key. Does not add the vendor to the database.
	 *
	 * @param vendorId the primary key for the new vendor
	 * @return the new vendor
	 */
	@Override
	public Vendor create(long vendorId) {
		Vendor vendor = new VendorImpl();

		vendor.setNew(true);
		vendor.setPrimaryKey(vendorId);

		return vendor;
	}

	/**
	 * Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor that was removed
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor remove(long vendorId)
		throws NoSuchVendorException, SystemException {
		return remove((Serializable)vendorId);
	}

	/**
	 * Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor that was removed
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor remove(Serializable primaryKey)
		throws NoSuchVendorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Vendor vendor = (Vendor)session.get(VendorImpl.class, primaryKey);

			if (vendor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVendorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vendor);
		}
		catch (NoSuchVendorException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Vendor removeImpl(Vendor vendor) throws SystemException {
		vendor = toUnwrappedModel(vendor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vendor)) {
				vendor = (Vendor)session.get(VendorImpl.class,
						vendor.getPrimaryKeyObj());
			}

			if (vendor != null) {
				session.delete(vendor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vendor != null) {
			clearCache(vendor);
		}

		return vendor;
	}

	@Override
	public Vendor updateImpl(com.tamarack.creekridge.model.Vendor vendor)
		throws SystemException {
		vendor = toUnwrappedModel(vendor);

		boolean isNew = vendor.isNew();

		VendorModelImpl vendorModelImpl = (VendorModelImpl)vendor;

		Session session = null;

		try {
			session = openSession();

			if (vendor.isNew()) {
				session.save(vendor);

				vendor.setNew(false);
			}
			else {
				session.merge(vendor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VendorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { vendorModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalVendorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID,
					args);

				args = new Object[] { vendorModelImpl.getVendorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID,
					args);
			}
		}

		EntityCacheUtil.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey(), vendor);

		return vendor;
	}

	protected Vendor toUnwrappedModel(Vendor vendor) {
		if (vendor instanceof VendorImpl) {
			return vendor;
		}

		VendorImpl vendorImpl = new VendorImpl();

		vendorImpl.setNew(vendor.isNew());
		vendorImpl.setPrimaryKey(vendor.getPrimaryKey());

		vendorImpl.setVendorId(vendor.getVendorId());
		vendorImpl.setCompanyId(vendor.getCompanyId());
		vendorImpl.setUserId(vendor.getUserId());
		vendorImpl.setUserName(vendor.getUserName());
		vendorImpl.setCreateDate(vendor.getCreateDate());
		vendorImpl.setModifiedDate(vendor.getModifiedDate());
		vendorImpl.setGroupId(vendor.getGroupId());
		vendorImpl.setMultiSelectProduct(vendor.isMultiSelectProduct());
		vendorImpl.setMultiSelectPurchaseOption(vendor.isMultiSelectPurchaseOption());
		vendorImpl.setMultiSelectTerm(vendor.isMultiSelectTerm());

		return vendorImpl;
	}

	/**
	 * Returns the vendor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVendorException, SystemException {
		Vendor vendor = fetchByPrimaryKey(primaryKey);

		if (vendor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVendorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vendor;
	}

	/**
	 * Returns the vendor with the primary key or throws a {@link com.tamarack.creekridge.NoSuchVendorException} if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor
	 * @throws com.tamarack.creekridge.NoSuchVendorException if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor findByPrimaryKey(long vendorId)
		throws NoSuchVendorException, SystemException {
		return findByPrimaryKey((Serializable)vendorId);
	}

	/**
	 * Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Vendor vendor = (Vendor)EntityCacheUtil.getResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
				VendorImpl.class, primaryKey);

		if (vendor == _nullVendor) {
			return null;
		}

		if (vendor == null) {
			Session session = null;

			try {
				session = openSession();

				vendor = (Vendor)session.get(VendorImpl.class, primaryKey);

				if (vendor != null) {
					cacheResult(vendor);
				}
				else {
					EntityCacheUtil.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
						VendorImpl.class, primaryKey, _nullVendor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
					VendorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vendor;
	}

	/**
	 * Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Vendor fetchByPrimaryKey(long vendorId) throws SystemException {
		return fetchByPrimaryKey((Serializable)vendorId);
	}

	/**
	 * Returns all the vendors.
	 *
	 * @return the vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Vendor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Vendor> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Vendor> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Vendor> list = (List<Vendor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENDOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENDOR;

				if (pagination) {
					sql = sql.concat(VendorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Vendor>(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vendors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Vendor vendor : findAll()) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors.
	 *
	 * @return the number of vendors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VENDOR);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the vendor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.Vendor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Vendor>> listenersList = new ArrayList<ModelListener<Vendor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Vendor>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VendorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENDOR = "SELECT vendor FROM Vendor vendor";
	private static final String _SQL_SELECT_VENDOR_WHERE = "SELECT vendor FROM Vendor vendor WHERE ";
	private static final String _SQL_COUNT_VENDOR = "SELECT COUNT(vendor) FROM Vendor vendor";
	private static final String _SQL_COUNT_VENDOR_WHERE = "SELECT COUNT(vendor) FROM Vendor vendor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vendor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Vendor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Vendor exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VendorPersistenceImpl.class);
	private static Vendor _nullVendor = new VendorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Vendor> toCacheModel() {
				return _nullVendorCacheModel;
			}
		};

	private static CacheModel<Vendor> _nullVendorCacheModel = new CacheModel<Vendor>() {
			@Override
			public Vendor toEntityModel() {
				return _nullVendor;
			}
		};
}