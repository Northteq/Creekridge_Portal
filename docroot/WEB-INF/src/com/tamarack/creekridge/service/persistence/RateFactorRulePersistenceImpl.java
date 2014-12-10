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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.tamarack.creekridge.NoSuchRateFactorRuleException;
import com.tamarack.creekridge.model.RateFactorRule;
import com.tamarack.creekridge.model.impl.RateFactorRuleImpl;
import com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the rate factor rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tamarack Consulting
 * @see RateFactorRulePersistence
 * @see RateFactorRuleUtil
 * @generated
 */
public class RateFactorRulePersistenceImpl extends BasePersistenceImpl<RateFactorRule>
	implements RateFactorRulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RateFactorRuleUtil} to access the rate factor rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RateFactorRuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDOR = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVendor",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDOR =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVendor",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			RateFactorRuleModelImpl.ACTIVE_COLUMN_BITMASK |
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENDOR = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVendor",
			new String[] { Boolean.class.getName(), Long.class.getName() });

	/**
	 * Returns all the rate factor rules where active = &#63; and vendorId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @return the matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendor(boolean active, long vendorId)
		throws SystemException {
		return findByVendor(active, vendorId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<RateFactorRule> findByVendor(boolean active, long vendorId,
		int start, int end) throws SystemException {
		return findByVendor(active, vendorId, start, end, null);
	}

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
	@Override
	public List<RateFactorRule> findByVendor(boolean active, long vendorId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDOR;
			finderArgs = new Object[] { active, vendorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDOR;
			finderArgs = new Object[] {
					active, vendorId,
					
					start, end, orderByComparator
				};
		}

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RateFactorRule rateFactorRule : list) {
				if ((active != rateFactorRule.getActive()) ||
						(vendorId != rateFactorRule.getVendorId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDOR_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDOR_VENDORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				if (!pagination) {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RateFactorRule>(list);
				}
				else {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByVendor_First(boolean active, long vendorId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendor_First(active, vendorId,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendor_First(boolean active, long vendorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RateFactorRule> list = findByVendor(active, vendorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public RateFactorRule findByVendor_Last(boolean active, long vendorId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendor_Last(active, vendorId,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendor_Last(boolean active, long vendorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVendor(active, vendorId);

		if (count == 0) {
			return null;
		}

		List<RateFactorRule> list = findByVendor(active, vendorId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public RateFactorRule[] findByVendor_PrevAndNext(long rateFactorRuleId,
		boolean active, long vendorId, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByPrimaryKey(rateFactorRuleId);

		Session session = null;

		try {
			session = openSession();

			RateFactorRule[] array = new RateFactorRuleImpl[3];

			array[0] = getByVendor_PrevAndNext(session, rateFactorRule, active,
					vendorId, orderByComparator, true);

			array[1] = rateFactorRule;

			array[2] = getByVendor_PrevAndNext(session, rateFactorRule, active,
					vendorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RateFactorRule getByVendor_PrevAndNext(Session session,
		RateFactorRule rateFactorRule, boolean active, long vendorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

		query.append(_FINDER_COLUMN_VENDOR_ACTIVE_2);

		query.append(_FINDER_COLUMN_VENDOR_VENDORID_2);

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
			query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(vendorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rateFactorRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RateFactorRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rate factor rules where active = &#63; and vendorId = &#63; from the database.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVendor(boolean active, long vendorId)
		throws SystemException {
		for (RateFactorRule rateFactorRule : findByVendor(active, vendorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rateFactorRule);
		}
	}

	/**
	 * Returns the number of rate factor rules where active = &#63; and vendorId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @return the number of matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVendor(boolean active, long vendorId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENDOR;

		Object[] finderArgs = new Object[] { active, vendorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDOR_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDOR_VENDORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_VENDOR_ACTIVE_2 = "rateFactorRule.active = ? AND ";
	private static final String _FINDER_COLUMN_VENDOR_VENDORID_2 = "rateFactorRule.vendorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORPRODUCT =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVendorProduct",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCT =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVendorProduct",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			RateFactorRuleModelImpl.ACTIVE_COLUMN_BITMASK |
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENDORPRODUCT = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVendorProduct",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @return the matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendorProduct(boolean active,
		long vendorId, long productId) throws SystemException {
		return findByVendorProduct(active, vendorId, productId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param start the lower bound of the range of rate factor rules
	 * @param end the upper bound of the range of rate factor rules (not inclusive)
	 * @return the range of matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendorProduct(boolean active,
		long vendorId, long productId, int start, int end)
		throws SystemException {
		return findByVendorProduct(active, vendorId, productId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param start the lower bound of the range of rate factor rules
	 * @param end the upper bound of the range of rate factor rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendorProduct(boolean active,
		long vendorId, long productId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCT;
			finderArgs = new Object[] { active, vendorId, productId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORPRODUCT;
			finderArgs = new Object[] {
					active, vendorId, productId,
					
					start, end, orderByComparator
				};
		}

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RateFactorRule rateFactorRule : list) {
				if ((active != rateFactorRule.getActive()) ||
						(vendorId != rateFactorRule.getVendorId()) ||
						(productId != rateFactorRule.getProductId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDORPRODUCT_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCT_VENDORID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCT_PRODUCTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				if (!pagination) {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RateFactorRule>(list);
				}
				else {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByVendorProduct_First(boolean active,
		long vendorId, long productId, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorProduct_First(active,
				vendorId, productId, orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendorProduct_First(boolean active,
		long vendorId, long productId, OrderByComparator orderByComparator)
		throws SystemException {
		List<RateFactorRule> list = findByVendorProduct(active, vendorId,
				productId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByVendorProduct_Last(boolean active,
		long vendorId, long productId, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorProduct_Last(active,
				vendorId, productId, orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendorProduct_Last(boolean active,
		long vendorId, long productId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVendorProduct(active, vendorId, productId);

		if (count == 0) {
			return null;
		}

		List<RateFactorRule> list = findByVendorProduct(active, vendorId,
				productId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rate factor rules before and after the current rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63;.
	 *
	 * @param rateFactorRuleId the primary key of the current rate factor rule
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule[] findByVendorProduct_PrevAndNext(
		long rateFactorRuleId, boolean active, long vendorId, long productId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByPrimaryKey(rateFactorRuleId);

		Session session = null;

		try {
			session = openSession();

			RateFactorRule[] array = new RateFactorRuleImpl[3];

			array[0] = getByVendorProduct_PrevAndNext(session, rateFactorRule,
					active, vendorId, productId, orderByComparator, true);

			array[1] = rateFactorRule;

			array[2] = getByVendorProduct_PrevAndNext(session, rateFactorRule,
					active, vendorId, productId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RateFactorRule getByVendorProduct_PrevAndNext(Session session,
		RateFactorRule rateFactorRule, boolean active, long vendorId,
		long productId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

		query.append(_FINDER_COLUMN_VENDORPRODUCT_ACTIVE_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCT_VENDORID_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCT_PRODUCTID_2);

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
			query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(vendorId);

		qPos.add(productId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rateFactorRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RateFactorRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; from the database.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVendorProduct(boolean active, long vendorId,
		long productId) throws SystemException {
		for (RateFactorRule rateFactorRule : findByVendorProduct(active,
				vendorId, productId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rateFactorRule);
		}
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
	@Override
	public int countByVendorProduct(boolean active, long vendorId,
		long productId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENDORPRODUCT;

		Object[] finderArgs = new Object[] { active, vendorId, productId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDORPRODUCT_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCT_VENDORID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCT_PRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

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

	private static final String _FINDER_COLUMN_VENDORPRODUCT_ACTIVE_2 = "rateFactorRule.active = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCT_VENDORID_2 = "rateFactorRule.vendorId = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCT_PRODUCTID_2 = "rateFactorRule.productId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORPRODUCTPURCHASEOPTION =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVendorProductPurchaseOption",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCTPURCHASEOPTION =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVendorProductPurchaseOption",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			RateFactorRuleModelImpl.ACTIVE_COLUMN_BITMASK |
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PRODUCTID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PURCHASEOPTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENDORPRODUCTPURCHASEOPTION =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVendorProductPurchaseOption",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @return the matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendorProductPurchaseOption(
		boolean active, long vendorId, long productId, long purchaseOptionId)
		throws SystemException {
		return findByVendorProductPurchaseOption(active, vendorId, productId,
			purchaseOptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param start the lower bound of the range of rate factor rules
	 * @param end the upper bound of the range of rate factor rules (not inclusive)
	 * @return the range of matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendorProductPurchaseOption(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		int start, int end) throws SystemException {
		return findByVendorProductPurchaseOption(active, vendorId, productId,
			purchaseOptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.RateFactorRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param start the lower bound of the range of rate factor rules
	 * @param end the upper bound of the range of rate factor rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendorProductPurchaseOption(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCTPURCHASEOPTION;
			finderArgs = new Object[] {
					active, vendorId, productId, purchaseOptionId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORPRODUCTPURCHASEOPTION;
			finderArgs = new Object[] {
					active, vendorId, productId, purchaseOptionId,
					
					start, end, orderByComparator
				};
		}

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RateFactorRule rateFactorRule : list) {
				if ((active != rateFactorRule.getActive()) ||
						(vendorId != rateFactorRule.getVendorId()) ||
						(productId != rateFactorRule.getProductId()) ||
						(purchaseOptionId != rateFactorRule.getPurchaseOptionId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_VENDORID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PRODUCTID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PURCHASEOPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				qPos.add(purchaseOptionId);

				if (!pagination) {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RateFactorRule>(list);
				}
				else {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByVendorProductPurchaseOption_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorProductPurchaseOption_First(active,
				vendorId, productId, purchaseOptionId, orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(", purchaseOptionId=");
		msg.append(purchaseOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendorProductPurchaseOption_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RateFactorRule> list = findByVendorProductPurchaseOption(active,
				vendorId, productId, purchaseOptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByVendorProductPurchaseOption_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorProductPurchaseOption_Last(active,
				vendorId, productId, purchaseOptionId, orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(", purchaseOptionId=");
		msg.append(purchaseOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendorProductPurchaseOption_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVendorProductPurchaseOption(active, vendorId,
				productId, purchaseOptionId);

		if (count == 0) {
			return null;
		}

		List<RateFactorRule> list = findByVendorProductPurchaseOption(active,
				vendorId, productId, purchaseOptionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rate factor rules before and after the current rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63;.
	 *
	 * @param rateFactorRuleId the primary key of the current rate factor rule
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule[] findByVendorProductPurchaseOption_PrevAndNext(
		long rateFactorRuleId, boolean active, long vendorId, long productId,
		long purchaseOptionId, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByPrimaryKey(rateFactorRuleId);

		Session session = null;

		try {
			session = openSession();

			RateFactorRule[] array = new RateFactorRuleImpl[3];

			array[0] = getByVendorProductPurchaseOption_PrevAndNext(session,
					rateFactorRule, active, vendorId, productId,
					purchaseOptionId, orderByComparator, true);

			array[1] = rateFactorRule;

			array[2] = getByVendorProductPurchaseOption_PrevAndNext(session,
					rateFactorRule, active, vendorId, productId,
					purchaseOptionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RateFactorRule getByVendorProductPurchaseOption_PrevAndNext(
		Session session, RateFactorRule rateFactorRule, boolean active,
		long vendorId, long productId, long purchaseOptionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

		query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_ACTIVE_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_VENDORID_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PRODUCTID_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PURCHASEOPTIONID_2);

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
			query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(vendorId);

		qPos.add(productId);

		qPos.add(purchaseOptionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rateFactorRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RateFactorRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; from the database.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVendorProductPurchaseOption(boolean active,
		long vendorId, long productId, long purchaseOptionId)
		throws SystemException {
		for (RateFactorRule rateFactorRule : findByVendorProductPurchaseOption(
				active, vendorId, productId, purchaseOptionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rateFactorRule);
		}
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
	@Override
	public int countByVendorProductPurchaseOption(boolean active,
		long vendorId, long productId, long purchaseOptionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENDORPRODUCTPURCHASEOPTION;

		Object[] finderArgs = new Object[] {
				active, vendorId, productId, purchaseOptionId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_VENDORID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PRODUCTID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PURCHASEOPTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				qPos.add(purchaseOptionId);

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

	private static final String _FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_ACTIVE_2 =
		"rateFactorRule.active = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_VENDORID_2 =
		"rateFactorRule.vendorId = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PRODUCTID_2 =
		"rateFactorRule.productId = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTPURCHASEOPTION_PURCHASEOPTIONID_2 =
		"rateFactorRule.purchaseOptionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORPRODUCTOPTIONTERMPRICE =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVendorProductOptionTermPrice",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_VENDORPRODUCTOPTIONTERMPRICE =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByVendorProductOptionTermPrice",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Double.class.getName()
			});

	/**
	 * Returns all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public List<RateFactorRule> findByVendorProductOptionTermPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice) throws SystemException {
		return findByVendorProductOptionTermPrice(active, vendorId, productId,
			purchaseOptionId, termId, minPrice, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public List<RateFactorRule> findByVendorProductOptionTermPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, int start, int end)
		throws SystemException {
		return findByVendorProductOptionTermPrice(active, vendorId, productId,
			purchaseOptionId, termId, minPrice, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public List<RateFactorRule> findByVendorProductOptionTermPrice(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORPRODUCTOPTIONTERMPRICE;
		finderArgs = new Object[] {
				active, vendorId, productId, purchaseOptionId, termId, minPrice,
				
				start, end, orderByComparator
			};

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RateFactorRule rateFactorRule : list) {
				if ((active != rateFactorRule.getActive()) ||
						(vendorId != rateFactorRule.getVendorId()) ||
						(productId != rateFactorRule.getProductId()) ||
						(purchaseOptionId != rateFactorRule.getPurchaseOptionId()) ||
						(termId != rateFactorRule.getTermId()) ||
						(minPrice < rateFactorRule.getMinPrice())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(8 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(8);
			}

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_VENDORID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PRODUCTID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PURCHASEOPTIONID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_TERMID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_MINPRICE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				qPos.add(purchaseOptionId);

				qPos.add(termId);

				qPos.add(minPrice);

				if (!pagination) {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RateFactorRule>(list);
				}
				else {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public RateFactorRule findByVendorProductOptionTermPrice_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorProductOptionTermPrice_First(active,
				vendorId, productId, purchaseOptionId, termId, minPrice,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(", purchaseOptionId=");
		msg.append(purchaseOptionId);

		msg.append(", termId=");
		msg.append(termId);

		msg.append(", minPrice=");
		msg.append(minPrice);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the first rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public RateFactorRule fetchByVendorProductOptionTermPrice_First(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, OrderByComparator orderByComparator)
		throws SystemException {
		List<RateFactorRule> list = findByVendorProductOptionTermPrice(active,
				vendorId, productId, purchaseOptionId, termId, minPrice, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public RateFactorRule findByVendorProductOptionTermPrice_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorProductOptionTermPrice_Last(active,
				vendorId, productId, purchaseOptionId, termId, minPrice,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(14);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("active=");
		msg.append(active);

		msg.append(", vendorId=");
		msg.append(vendorId);

		msg.append(", productId=");
		msg.append(productId);

		msg.append(", purchaseOptionId=");
		msg.append(purchaseOptionId);

		msg.append(", termId=");
		msg.append(termId);

		msg.append(", minPrice=");
		msg.append(minPrice);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the last rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public RateFactorRule fetchByVendorProductOptionTermPrice_Last(
		boolean active, long vendorId, long productId, long purchaseOptionId,
		long termId, double minPrice, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVendorProductOptionTermPrice(active, vendorId,
				productId, purchaseOptionId, termId, minPrice);

		if (count == 0) {
			return null;
		}

		List<RateFactorRule> list = findByVendorProductOptionTermPrice(active,
				vendorId, productId, purchaseOptionId, termId, minPrice,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rate factor rules before and after the current rate factor rule in the ordered set where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public RateFactorRule[] findByVendorProductOptionTermPrice_PrevAndNext(
		long rateFactorRuleId, boolean active, long vendorId, long productId,
		long purchaseOptionId, long termId, double minPrice,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByPrimaryKey(rateFactorRuleId);

		Session session = null;

		try {
			session = openSession();

			RateFactorRule[] array = new RateFactorRuleImpl[3];

			array[0] = getByVendorProductOptionTermPrice_PrevAndNext(session,
					rateFactorRule, active, vendorId, productId,
					purchaseOptionId, termId, minPrice, orderByComparator, true);

			array[1] = rateFactorRule;

			array[2] = getByVendorProductOptionTermPrice_PrevAndNext(session,
					rateFactorRule, active, vendorId, productId,
					purchaseOptionId, termId, minPrice, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RateFactorRule getByVendorProductOptionTermPrice_PrevAndNext(
		Session session, RateFactorRule rateFactorRule, boolean active,
		long vendorId, long productId, long purchaseOptionId, long termId,
		double minPrice, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

		query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_ACTIVE_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_VENDORID_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PRODUCTID_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PURCHASEOPTIONID_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_TERMID_2);

		query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_MINPRICE_2);

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
			query.append(RateFactorRuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(active);

		qPos.add(vendorId);

		qPos.add(productId);

		qPos.add(purchaseOptionId);

		qPos.add(termId);

		qPos.add(minPrice);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rateFactorRule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RateFactorRule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63; from the database.
	 *
	 * @param active the active
	 * @param vendorId the vendor ID
	 * @param productId the product ID
	 * @param purchaseOptionId the purchase option ID
	 * @param termId the term ID
	 * @param minPrice the min price
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVendorProductOptionTermPrice(boolean active,
		long vendorId, long productId, long purchaseOptionId, long termId,
		double minPrice) throws SystemException {
		for (RateFactorRule rateFactorRule : findByVendorProductOptionTermPrice(
				active, vendorId, productId, purchaseOptionId, termId,
				minPrice, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rateFactorRule);
		}
	}

	/**
	 * Returns the number of rate factor rules where active = &#63; and vendorId = &#63; and productId = &#63; and purchaseOptionId = &#63; and termId = &#63; and minPrice &le; &#63;.
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
	@Override
	public int countByVendorProductOptionTermPrice(boolean active,
		long vendorId, long productId, long purchaseOptionId, long termId,
		double minPrice) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_VENDORPRODUCTOPTIONTERMPRICE;

		Object[] finderArgs = new Object[] {
				active, vendorId, productId, purchaseOptionId, termId, minPrice
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_ACTIVE_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_VENDORID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PRODUCTID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PURCHASEOPTIONID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_TERMID_2);

			query.append(_FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_MINPRICE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				qPos.add(purchaseOptionId);

				qPos.add(termId);

				qPos.add(minPrice);

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

	private static final String _FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_ACTIVE_2 =
		"rateFactorRule.active = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_VENDORID_2 =
		"rateFactorRule.vendorId = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PRODUCTID_2 =
		"rateFactorRule.productId = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_PURCHASEOPTIONID_2 =
		"rateFactorRule.purchaseOptionId = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_TERMID_2 =
		"rateFactorRule.termId = ? AND ";
	private static final String _FINDER_COLUMN_VENDORPRODUCTOPTIONTERMPRICE_MINPRICE_2 =
		"rateFactorRule.minPrice <= ?";

	public RateFactorRulePersistenceImpl() {
		setModelClass(RateFactorRule.class);
	}

	/**
	 * Caches the rate factor rule in the entity cache if it is enabled.
	 *
	 * @param rateFactorRule the rate factor rule
	 */
	@Override
	public void cacheResult(RateFactorRule rateFactorRule) {
		EntityCacheUtil.putResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleImpl.class, rateFactorRule.getPrimaryKey(),
			rateFactorRule);

		rateFactorRule.resetOriginalValues();
	}

	/**
	 * Caches the rate factor rules in the entity cache if it is enabled.
	 *
	 * @param rateFactorRules the rate factor rules
	 */
	@Override
	public void cacheResult(List<RateFactorRule> rateFactorRules) {
		for (RateFactorRule rateFactorRule : rateFactorRules) {
			if (EntityCacheUtil.getResult(
						RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
						RateFactorRuleImpl.class, rateFactorRule.getPrimaryKey()) == null) {
				cacheResult(rateFactorRule);
			}
			else {
				rateFactorRule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rate factor rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RateFactorRuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RateFactorRuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rate factor rule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RateFactorRule rateFactorRule) {
		EntityCacheUtil.removeResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleImpl.class, rateFactorRule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RateFactorRule> rateFactorRules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RateFactorRule rateFactorRule : rateFactorRules) {
			EntityCacheUtil.removeResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
				RateFactorRuleImpl.class, rateFactorRule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rate factor rule with the primary key. Does not add the rate factor rule to the database.
	 *
	 * @param rateFactorRuleId the primary key for the new rate factor rule
	 * @return the new rate factor rule
	 */
	@Override
	public RateFactorRule create(long rateFactorRuleId) {
		RateFactorRule rateFactorRule = new RateFactorRuleImpl();

		rateFactorRule.setNew(true);
		rateFactorRule.setPrimaryKey(rateFactorRuleId);

		return rateFactorRule;
	}

	/**
	 * Removes the rate factor rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rateFactorRuleId the primary key of the rate factor rule
	 * @return the rate factor rule that was removed
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule remove(long rateFactorRuleId)
		throws NoSuchRateFactorRuleException, SystemException {
		return remove((Serializable)rateFactorRuleId);
	}

	/**
	 * Removes the rate factor rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rate factor rule
	 * @return the rate factor rule that was removed
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule remove(Serializable primaryKey)
		throws NoSuchRateFactorRuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RateFactorRule rateFactorRule = (RateFactorRule)session.get(RateFactorRuleImpl.class,
					primaryKey);

			if (rateFactorRule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRateFactorRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rateFactorRule);
		}
		catch (NoSuchRateFactorRuleException nsee) {
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
	protected RateFactorRule removeImpl(RateFactorRule rateFactorRule)
		throws SystemException {
		rateFactorRule = toUnwrappedModel(rateFactorRule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rateFactorRule)) {
				rateFactorRule = (RateFactorRule)session.get(RateFactorRuleImpl.class,
						rateFactorRule.getPrimaryKeyObj());
			}

			if (rateFactorRule != null) {
				session.delete(rateFactorRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rateFactorRule != null) {
			clearCache(rateFactorRule);
		}

		return rateFactorRule;
	}

	@Override
	public RateFactorRule updateImpl(
		com.tamarack.creekridge.model.RateFactorRule rateFactorRule)
		throws SystemException {
		rateFactorRule = toUnwrappedModel(rateFactorRule);

		boolean isNew = rateFactorRule.isNew();

		RateFactorRuleModelImpl rateFactorRuleModelImpl = (RateFactorRuleModelImpl)rateFactorRule;

		Session session = null;

		try {
			session = openSession();

			if (rateFactorRule.isNew()) {
				session.save(rateFactorRule);

				rateFactorRule.setNew(false);
			}
			else {
				session.merge(rateFactorRule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RateFactorRuleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRuleModelImpl.getOriginalActive(),
						rateFactorRuleModelImpl.getOriginalVendorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDOR,
					args);

				args = new Object[] {
						rateFactorRuleModelImpl.getActive(),
						rateFactorRuleModelImpl.getVendorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDOR,
					args);
			}

			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRuleModelImpl.getOriginalActive(),
						rateFactorRuleModelImpl.getOriginalVendorId(),
						rateFactorRuleModelImpl.getOriginalProductId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORPRODUCT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCT,
					args);

				args = new Object[] {
						rateFactorRuleModelImpl.getActive(),
						rateFactorRuleModelImpl.getVendorId(),
						rateFactorRuleModelImpl.getProductId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORPRODUCT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCT,
					args);
			}

			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCTPURCHASEOPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRuleModelImpl.getOriginalActive(),
						rateFactorRuleModelImpl.getOriginalVendorId(),
						rateFactorRuleModelImpl.getOriginalProductId(),
						rateFactorRuleModelImpl.getOriginalPurchaseOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORPRODUCTPURCHASEOPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCTPURCHASEOPTION,
					args);

				args = new Object[] {
						rateFactorRuleModelImpl.getActive(),
						rateFactorRuleModelImpl.getVendorId(),
						rateFactorRuleModelImpl.getProductId(),
						rateFactorRuleModelImpl.getPurchaseOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORPRODUCTPURCHASEOPTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORPRODUCTPURCHASEOPTION,
					args);
			}
		}

		EntityCacheUtil.putResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleImpl.class, rateFactorRule.getPrimaryKey(),
			rateFactorRule);

		return rateFactorRule;
	}

	protected RateFactorRule toUnwrappedModel(RateFactorRule rateFactorRule) {
		if (rateFactorRule instanceof RateFactorRuleImpl) {
			return rateFactorRule;
		}

		RateFactorRuleImpl rateFactorRuleImpl = new RateFactorRuleImpl();

		rateFactorRuleImpl.setNew(rateFactorRule.isNew());
		rateFactorRuleImpl.setPrimaryKey(rateFactorRule.getPrimaryKey());

		rateFactorRuleImpl.setRateFactorRuleId(rateFactorRule.getRateFactorRuleId());
		rateFactorRuleImpl.setCompanyId(rateFactorRule.getCompanyId());
		rateFactorRuleImpl.setUserId(rateFactorRule.getUserId());
		rateFactorRuleImpl.setUserName(rateFactorRule.getUserName());
		rateFactorRuleImpl.setCreateDate(rateFactorRule.getCreateDate());
		rateFactorRuleImpl.setModifiedDate(rateFactorRule.getModifiedDate());
		rateFactorRuleImpl.setProductId(rateFactorRule.getProductId());
		rateFactorRuleImpl.setTermId(rateFactorRule.getTermId());
		rateFactorRuleImpl.setPurchaseOptionId(rateFactorRule.getPurchaseOptionId());
		rateFactorRuleImpl.setVendorId(rateFactorRule.getVendorId());
		rateFactorRuleImpl.setMinPrice(rateFactorRule.getMinPrice());
		rateFactorRuleImpl.setRateFactor(rateFactorRule.getRateFactor());
		rateFactorRuleImpl.setEffectiveDate(rateFactorRule.getEffectiveDate());
		rateFactorRuleImpl.setActive(rateFactorRule.isActive());
		rateFactorRuleImpl.setExpirationDate(rateFactorRule.getExpirationDate());

		return rateFactorRuleImpl;
	}

	/**
	 * Returns the rate factor rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rate factor rule
	 * @return the rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByPrimaryKey(primaryKey);

		if (rateFactorRule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRateFactorRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rateFactorRule;
	}

	/**
	 * Returns the rate factor rule with the primary key or throws a {@link com.tamarack.creekridge.NoSuchRateFactorRuleException} if it could not be found.
	 *
	 * @param rateFactorRuleId the primary key of the rate factor rule
	 * @return the rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByPrimaryKey(long rateFactorRuleId)
		throws NoSuchRateFactorRuleException, SystemException {
		return findByPrimaryKey((Serializable)rateFactorRuleId);
	}

	/**
	 * Returns the rate factor rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rate factor rule
	 * @return the rate factor rule, or <code>null</code> if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RateFactorRule rateFactorRule = (RateFactorRule)EntityCacheUtil.getResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
				RateFactorRuleImpl.class, primaryKey);

		if (rateFactorRule == _nullRateFactorRule) {
			return null;
		}

		if (rateFactorRule == null) {
			Session session = null;

			try {
				session = openSession();

				rateFactorRule = (RateFactorRule)session.get(RateFactorRuleImpl.class,
						primaryKey);

				if (rateFactorRule != null) {
					cacheResult(rateFactorRule);
				}
				else {
					EntityCacheUtil.putResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
						RateFactorRuleImpl.class, primaryKey,
						_nullRateFactorRule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
					RateFactorRuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rateFactorRule;
	}

	/**
	 * Returns the rate factor rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rateFactorRuleId the primary key of the rate factor rule
	 * @return the rate factor rule, or <code>null</code> if a rate factor rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByPrimaryKey(long rateFactorRuleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)rateFactorRuleId);
	}

	/**
	 * Returns all the rate factor rules.
	 *
	 * @return the rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<RateFactorRule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<RateFactorRule> findAll(int start, int end,
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

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RATEFACTORRULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RATEFACTORRULE;

				if (pagination) {
					sql = sql.concat(RateFactorRuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RateFactorRule>(list);
				}
				else {
					list = (List<RateFactorRule>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the rate factor rules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RateFactorRule rateFactorRule : findAll()) {
			remove(rateFactorRule);
		}
	}

	/**
	 * Returns the number of rate factor rules.
	 *
	 * @return the number of rate factor rules
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

				Query q = session.createQuery(_SQL_COUNT_RATEFACTORRULE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the rate factor rule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.RateFactorRule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RateFactorRule>> listenersList = new ArrayList<ModelListener<RateFactorRule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RateFactorRule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RateFactorRuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RATEFACTORRULE = "SELECT rateFactorRule FROM RateFactorRule rateFactorRule";
	private static final String _SQL_SELECT_RATEFACTORRULE_WHERE = "SELECT rateFactorRule FROM RateFactorRule rateFactorRule WHERE ";
	private static final String _SQL_COUNT_RATEFACTORRULE = "SELECT COUNT(rateFactorRule) FROM RateFactorRule rateFactorRule";
	private static final String _SQL_COUNT_RATEFACTORRULE_WHERE = "SELECT COUNT(rateFactorRule) FROM RateFactorRule rateFactorRule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rateFactorRule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RateFactorRule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RateFactorRule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RateFactorRulePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static RateFactorRule _nullRateFactorRule = new RateFactorRuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RateFactorRule> toCacheModel() {
				return _nullRateFactorRuleCacheModel;
			}
		};

	private static CacheModel<RateFactorRule> _nullRateFactorRuleCacheModel = new CacheModel<RateFactorRule>() {
			@Override
			public RateFactorRule toEntityModel() {
				return _nullRateFactorRule;
			}
		};
}