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
 * @author pmacha
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A_V = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByA_V",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_V = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_V",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.ACTIVE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_V = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_V",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the rate factor rules where vendorId = &#63; and active = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param active the active
	 * @return the matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByA_V(long vendorId, boolean active)
		throws SystemException {
		return findByA_V(vendorId, active, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<RateFactorRule> findByA_V(long vendorId, boolean active,
		int start, int end) throws SystemException {
		return findByA_V(vendorId, active, start, end, null);
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
	@Override
	public List<RateFactorRule> findByA_V(long vendorId, boolean active,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_V;
			finderArgs = new Object[] { vendorId, active };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A_V;
			finderArgs = new Object[] {
					vendorId, active,
					
					start, end, orderByComparator
				};
		}

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RateFactorRule rateFactorRule : list) {
				if ((vendorId != rateFactorRule.getVendorId()) ||
						(active != rateFactorRule.getActive())) {
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

			query.append(_FINDER_COLUMN_A_V_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_ACTIVE_2);

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

				qPos.add(vendorId);

				qPos.add(active);

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
	 * Returns the first rate factor rule in the ordered set where vendorId = &#63; and active = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByA_V_First(long vendorId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByA_V_First(vendorId, active,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vendorId=");
		msg.append(vendorId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
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
	@Override
	public RateFactorRule fetchByA_V_First(long vendorId, boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		List<RateFactorRule> list = findByA_V(vendorId, active, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RateFactorRule findByA_V_Last(long vendorId, boolean active,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByA_V_Last(vendorId, active,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vendorId=");
		msg.append(vendorId);

		msg.append(", active=");
		msg.append(active);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
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
	@Override
	public RateFactorRule fetchByA_V_Last(long vendorId, boolean active,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByA_V(vendorId, active);

		if (count == 0) {
			return null;
		}

		List<RateFactorRule> list = findByA_V(vendorId, active, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RateFactorRule[] findByA_V_PrevAndNext(long rateFactorRuleId,
		long vendorId, boolean active, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByPrimaryKey(rateFactorRuleId);

		Session session = null;

		try {
			session = openSession();

			RateFactorRule[] array = new RateFactorRuleImpl[3];

			array[0] = getByA_V_PrevAndNext(session, rateFactorRule, vendorId,
					active, orderByComparator, true);

			array[1] = rateFactorRule;

			array[2] = getByA_V_PrevAndNext(session, rateFactorRule, vendorId,
					active, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RateFactorRule getByA_V_PrevAndNext(Session session,
		RateFactorRule rateFactorRule, long vendorId, boolean active,
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

		query.append(_FINDER_COLUMN_A_V_VENDORID_2);

		query.append(_FINDER_COLUMN_A_V_ACTIVE_2);

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

		qPos.add(vendorId);

		qPos.add(active);

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
	 * Removes all the rate factor rules where vendorId = &#63; and active = &#63; from the database.
	 *
	 * @param vendorId the vendor ID
	 * @param active the active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByA_V(long vendorId, boolean active)
		throws SystemException {
		for (RateFactorRule rateFactorRule : findByA_V(vendorId, active,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rateFactorRule);
		}
	}

	/**
	 * Returns the number of rate factor rules where vendorId = &#63; and active = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param active the active
	 * @return the number of matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByA_V(long vendorId, boolean active)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_V;

		Object[] finderArgs = new Object[] { vendorId, active };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_A_V_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_ACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vendorId);

				qPos.add(active);

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

	private static final String _FINDER_COLUMN_A_V_VENDORID_2 = "rateFactorRule.vendorId = ? AND ";
	private static final String _FINDER_COLUMN_A_V_ACTIVE_2 = "rateFactorRule.active = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_A_V_P = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByA_V_P",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			RateFactorRuleModelImpl.ACTIVE_COLUMN_BITMASK |
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PRODUCTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_V_P = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_V_P",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

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
	@Override
	public RateFactorRule findByA_V_P(boolean active, long vendorId,
		long productId) throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByA_V_P(active, vendorId, productId);

		if (rateFactorRule == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(", vendorId=");
			msg.append(vendorId);

			msg.append(", productId=");
			msg.append(productId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRateFactorRuleException(msg.toString());
		}

		return rateFactorRule;
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
	@Override
	public RateFactorRule fetchByA_V_P(boolean active, long vendorId,
		long productId) throws SystemException {
		return fetchByA_V_P(active, vendorId, productId, true);
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
	@Override
	public RateFactorRule fetchByA_V_P(boolean active, long vendorId,
		long productId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { active, vendorId, productId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_A_V_P,
					finderArgs, this);
		}

		if (result instanceof RateFactorRule) {
			RateFactorRule rateFactorRule = (RateFactorRule)result;

			if ((active != rateFactorRule.getActive()) ||
					(vendorId != rateFactorRule.getVendorId()) ||
					(productId != rateFactorRule.getProductId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_A_V_P_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_V_P_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_P_PRODUCTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				List<RateFactorRule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P,
						finderArgs, list);
				}
				else {
					RateFactorRule rateFactorRule = list.get(0);

					result = rateFactorRule;

					cacheResult(rateFactorRule);

					if ((rateFactorRule.getActive() != active) ||
							(rateFactorRule.getVendorId() != vendorId) ||
							(rateFactorRule.getProductId() != productId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P,
							finderArgs, rateFactorRule);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RateFactorRule)result;
		}
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
	@Override
	public RateFactorRule removeByA_V_P(boolean active, long vendorId,
		long productId) throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByA_V_P(active, vendorId, productId);

		return remove(rateFactorRule);
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
	public int countByA_V_P(boolean active, long vendorId, long productId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_V_P;

		Object[] finderArgs = new Object[] { active, vendorId, productId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_A_V_P_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_V_P_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_P_PRODUCTID_2);

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

	private static final String _FINDER_COLUMN_A_V_P_ACTIVE_2 = "rateFactorRule.active = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_VENDORID_2 = "rateFactorRule.vendorId = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_PRODUCTID_2 = "rateFactorRule.productId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_A_V_P_P = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByA_V_P_P",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			RateFactorRuleModelImpl.ACTIVE_COLUMN_BITMASK |
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PRODUCTID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PURCHASEOPTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_V_P_P = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_V_P_P",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName()
			});

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
	@Override
	public RateFactorRule findByA_V_P_P(boolean active, long vendorId,
		long productId, long purchaseOptionId)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByA_V_P_P(active, vendorId,
				productId, purchaseOptionId);

		if (rateFactorRule == null) {
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

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRateFactorRuleException(msg.toString());
		}

		return rateFactorRule;
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
	@Override
	public RateFactorRule fetchByA_V_P_P(boolean active, long vendorId,
		long productId, long purchaseOptionId) throws SystemException {
		return fetchByA_V_P_P(active, vendorId, productId, purchaseOptionId,
			true);
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
	@Override
	public RateFactorRule fetchByA_V_P_P(boolean active, long vendorId,
		long productId, long purchaseOptionId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				active, vendorId, productId, purchaseOptionId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_A_V_P_P,
					finderArgs, this);
		}

		if (result instanceof RateFactorRule) {
			RateFactorRule rateFactorRule = (RateFactorRule)result;

			if ((active != rateFactorRule.getActive()) ||
					(vendorId != rateFactorRule.getVendorId()) ||
					(productId != rateFactorRule.getProductId()) ||
					(purchaseOptionId != rateFactorRule.getPurchaseOptionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_A_V_P_P_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_V_P_P_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_P_P_PRODUCTID_2);

			query.append(_FINDER_COLUMN_A_V_P_P_PURCHASEOPTIONID_2);

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

				List<RateFactorRule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_P,
						finderArgs, list);
				}
				else {
					RateFactorRule rateFactorRule = list.get(0);

					result = rateFactorRule;

					cacheResult(rateFactorRule);

					if ((rateFactorRule.getActive() != active) ||
							(rateFactorRule.getVendorId() != vendorId) ||
							(rateFactorRule.getProductId() != productId) ||
							(rateFactorRule.getPurchaseOptionId() != purchaseOptionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_P,
							finderArgs, rateFactorRule);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P_P,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RateFactorRule)result;
		}
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
	@Override
	public RateFactorRule removeByA_V_P_P(boolean active, long vendorId,
		long productId, long purchaseOptionId)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByA_V_P_P(active, vendorId,
				productId, purchaseOptionId);

		return remove(rateFactorRule);
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
	public int countByA_V_P_P(boolean active, long vendorId, long productId,
		long purchaseOptionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_V_P_P;

		Object[] finderArgs = new Object[] {
				active, vendorId, productId, purchaseOptionId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_A_V_P_P_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_V_P_P_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_P_P_PRODUCTID_2);

			query.append(_FINDER_COLUMN_A_V_P_P_PURCHASEOPTIONID_2);

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

	private static final String _FINDER_COLUMN_A_V_P_P_ACTIVE_2 = "rateFactorRule.active = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_P_VENDORID_2 = "rateFactorRule.vendorId = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_P_PRODUCTID_2 = "rateFactorRule.productId = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_P_PURCHASEOPTIONID_2 = "rateFactorRule.purchaseOptionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_A_V_P_T_P = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByA_V_P_T_P",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			RateFactorRuleModelImpl.ACTIVE_COLUMN_BITMASK |
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PRODUCTID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.TERMID_COLUMN_BITMASK |
			RateFactorRuleModelImpl.PURCHASEOPTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_V_P_T_P = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_V_P_T_P",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

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
	@Override
	public RateFactorRule findByA_V_P_T_P(boolean active, long vendorId,
		long productId, long termId, long purchaseOptionId)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByA_V_P_T_P(active, vendorId,
				productId, termId, purchaseOptionId);

		if (rateFactorRule == null) {
			StringBundler msg = new StringBundler(12);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("active=");
			msg.append(active);

			msg.append(", vendorId=");
			msg.append(vendorId);

			msg.append(", productId=");
			msg.append(productId);

			msg.append(", termId=");
			msg.append(termId);

			msg.append(", purchaseOptionId=");
			msg.append(purchaseOptionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRateFactorRuleException(msg.toString());
		}

		return rateFactorRule;
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
	@Override
	public RateFactorRule fetchByA_V_P_T_P(boolean active, long vendorId,
		long productId, long termId, long purchaseOptionId)
		throws SystemException {
		return fetchByA_V_P_T_P(active, vendorId, productId, termId,
			purchaseOptionId, true);
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
	@Override
	public RateFactorRule fetchByA_V_P_T_P(boolean active, long vendorId,
		long productId, long termId, long purchaseOptionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				active, vendorId, productId, termId, purchaseOptionId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_A_V_P_T_P,
					finderArgs, this);
		}

		if (result instanceof RateFactorRule) {
			RateFactorRule rateFactorRule = (RateFactorRule)result;

			if ((active != rateFactorRule.getActive()) ||
					(vendorId != rateFactorRule.getVendorId()) ||
					(productId != rateFactorRule.getProductId()) ||
					(termId != rateFactorRule.getTermId()) ||
					(purchaseOptionId != rateFactorRule.getPurchaseOptionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(7);

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_A_V_P_T_P_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_PRODUCTID_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_TERMID_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_PURCHASEOPTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				qPos.add(termId);

				qPos.add(purchaseOptionId);

				List<RateFactorRule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_T_P,
						finderArgs, list);
				}
				else {
					RateFactorRule rateFactorRule = list.get(0);

					result = rateFactorRule;

					cacheResult(rateFactorRule);

					if ((rateFactorRule.getActive() != active) ||
							(rateFactorRule.getVendorId() != vendorId) ||
							(rateFactorRule.getProductId() != productId) ||
							(rateFactorRule.getTermId() != termId) ||
							(rateFactorRule.getPurchaseOptionId() != purchaseOptionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_T_P,
							finderArgs, rateFactorRule);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P_T_P,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (RateFactorRule)result;
		}
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
	@Override
	public RateFactorRule removeByA_V_P_T_P(boolean active, long vendorId,
		long productId, long termId, long purchaseOptionId)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByA_V_P_T_P(active, vendorId,
				productId, termId, purchaseOptionId);

		return remove(rateFactorRule);
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
	@Override
	public int countByA_V_P_T_P(boolean active, long vendorId, long productId,
		long termId, long purchaseOptionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_V_P_T_P;

		Object[] finderArgs = new Object[] {
				active, vendorId, productId, termId, purchaseOptionId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_A_V_P_T_P_ACTIVE_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_VENDORID_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_PRODUCTID_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_TERMID_2);

			query.append(_FINDER_COLUMN_A_V_P_T_P_PURCHASEOPTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(active);

				qPos.add(vendorId);

				qPos.add(productId);

				qPos.add(termId);

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

	private static final String _FINDER_COLUMN_A_V_P_T_P_ACTIVE_2 = "rateFactorRule.active = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_T_P_VENDORID_2 = "rateFactorRule.vendorId = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_T_P_PRODUCTID_2 = "rateFactorRule.productId = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_T_P_TERMID_2 = "rateFactorRule.termId = ? AND ";
	private static final String _FINDER_COLUMN_A_V_P_T_P_PURCHASEOPTIONID_2 = "rateFactorRule.purchaseOptionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENDORID = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVendorId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVendorId",
			new String[] { Long.class.getName() },
			RateFactorRuleModelImpl.VENDORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENDORID = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVendorId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rate factor rules where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @return the matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByVendorId(long vendorId)
		throws SystemException {
		return findByVendorId(vendorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<RateFactorRule> findByVendorId(long vendorId, int start, int end)
		throws SystemException {
		return findByVendorId(vendorId, start, end, null);
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
	@Override
	public List<RateFactorRule> findByVendorId(long vendorId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RateFactorRule rateFactorRule : list) {
				if ((vendorId != rateFactorRule.getVendorId())) {
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

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_VENDORID_VENDORID_2);

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
	 * Returns the first rate factor rule in the ordered set where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByVendorId_First(long vendorId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorId_First(vendorId,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vendorId=");
		msg.append(vendorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the first rate factor rule in the ordered set where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendorId_First(long vendorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RateFactorRule> list = findByVendorId(vendorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RateFactorRule findByVendorId_Last(long vendorId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByVendorId_Last(vendorId,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vendorId=");
		msg.append(vendorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the last rate factor rule in the ordered set where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByVendorId_Last(long vendorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVendorId(vendorId);

		if (count == 0) {
			return null;
		}

		List<RateFactorRule> list = findByVendorId(vendorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RateFactorRule[] findByVendorId_PrevAndNext(long rateFactorRuleId,
		long vendorId, OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = findByPrimaryKey(rateFactorRuleId);

		Session session = null;

		try {
			session = openSession();

			RateFactorRule[] array = new RateFactorRuleImpl[3];

			array[0] = getByVendorId_PrevAndNext(session, rateFactorRule,
					vendorId, orderByComparator, true);

			array[1] = rateFactorRule;

			array[2] = getByVendorId_PrevAndNext(session, rateFactorRule,
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

	protected RateFactorRule getByVendorId_PrevAndNext(Session session,
		RateFactorRule rateFactorRule, long vendorId,
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

		query.append(_FINDER_COLUMN_VENDORID_VENDORID_2);

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
	 * Removes all the rate factor rules where vendorId = &#63; from the database.
	 *
	 * @param vendorId the vendor ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVendorId(long vendorId) throws SystemException {
		for (RateFactorRule rateFactorRule : findByVendorId(vendorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rateFactorRule);
		}
	}

	/**
	 * Returns the number of rate factor rules where vendorId = &#63;.
	 *
	 * @param vendorId the vendor ID
	 * @return the number of matching rate factor rules
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

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

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

	private static final String _FINDER_COLUMN_VENDORID_VENDORID_2 = "rateFactorRule.vendorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATEFACTORRULEID =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByrateFactorRuleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATEFACTORRULEID =
		new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED,
			RateFactorRuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByrateFactorRuleId", new String[] { Long.class.getName() },
			RateFactorRuleModelImpl.RATEFACTORRULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATEFACTORRULEID = new FinderPath(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByrateFactorRuleId", new String[] { Long.class.getName() });

	/**
	 * Returns all the rate factor rules where rateFactorRuleId = &#63;.
	 *
	 * @param rateFactorRuleId the rate factor rule ID
	 * @return the matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateFactorRule> findByrateFactorRuleId(long rateFactorRuleId)
		throws SystemException {
		return findByrateFactorRuleId(rateFactorRuleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<RateFactorRule> findByrateFactorRuleId(long rateFactorRuleId,
		int start, int end) throws SystemException {
		return findByrateFactorRuleId(rateFactorRuleId, start, end, null);
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
	@Override
	public List<RateFactorRule> findByrateFactorRuleId(long rateFactorRuleId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATEFACTORRULEID;
			finderArgs = new Object[] { rateFactorRuleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATEFACTORRULEID;
			finderArgs = new Object[] {
					rateFactorRuleId,
					
					start, end, orderByComparator
				};
		}

		List<RateFactorRule> list = (List<RateFactorRule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RateFactorRule rateFactorRule : list) {
				if ((rateFactorRuleId != rateFactorRule.getRateFactorRuleId())) {
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

			query.append(_SQL_SELECT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_RATEFACTORRULEID_RATEFACTORRULEID_2);

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

				qPos.add(rateFactorRuleId);

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
	 * Returns the first rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	 *
	 * @param rateFactorRuleId the rate factor rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule
	 * @throws com.tamarack.creekridge.NoSuchRateFactorRuleException if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule findByrateFactorRuleId_First(long rateFactorRuleId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByrateFactorRuleId_First(rateFactorRuleId,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rateFactorRuleId=");
		msg.append(rateFactorRuleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the first rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	 *
	 * @param rateFactorRuleId the rate factor rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByrateFactorRuleId_First(long rateFactorRuleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RateFactorRule> list = findByrateFactorRuleId(rateFactorRuleId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public RateFactorRule findByrateFactorRuleId_Last(long rateFactorRuleId,
		OrderByComparator orderByComparator)
		throws NoSuchRateFactorRuleException, SystemException {
		RateFactorRule rateFactorRule = fetchByrateFactorRuleId_Last(rateFactorRuleId,
				orderByComparator);

		if (rateFactorRule != null) {
			return rateFactorRule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("rateFactorRuleId=");
		msg.append(rateFactorRuleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRateFactorRuleException(msg.toString());
	}

	/**
	 * Returns the last rate factor rule in the ordered set where rateFactorRuleId = &#63;.
	 *
	 * @param rateFactorRuleId the rate factor rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rate factor rule, or <code>null</code> if a matching rate factor rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateFactorRule fetchByrateFactorRuleId_Last(long rateFactorRuleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByrateFactorRuleId(rateFactorRuleId);

		if (count == 0) {
			return null;
		}

		List<RateFactorRule> list = findByrateFactorRuleId(rateFactorRuleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the rate factor rules where rateFactorRuleId = &#63; from the database.
	 *
	 * @param rateFactorRuleId the rate factor rule ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByrateFactorRuleId(long rateFactorRuleId)
		throws SystemException {
		for (RateFactorRule rateFactorRule : findByrateFactorRuleId(
				rateFactorRuleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(rateFactorRule);
		}
	}

	/**
	 * Returns the number of rate factor rules where rateFactorRuleId = &#63;.
	 *
	 * @param rateFactorRuleId the rate factor rule ID
	 * @return the number of matching rate factor rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByrateFactorRuleId(long rateFactorRuleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RATEFACTORRULEID;

		Object[] finderArgs = new Object[] { rateFactorRuleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATEFACTORRULE_WHERE);

			query.append(_FINDER_COLUMN_RATEFACTORRULEID_RATEFACTORRULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rateFactorRuleId);

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

	private static final String _FINDER_COLUMN_RATEFACTORRULEID_RATEFACTORRULEID_2 =
		"rateFactorRule.rateFactorRuleId = ?";

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

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P,
			new Object[] {
				rateFactorRule.getActive(), rateFactorRule.getVendorId(),
				rateFactorRule.getProductId()
			}, rateFactorRule);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_P,
			new Object[] {
				rateFactorRule.getActive(), rateFactorRule.getVendorId(),
				rateFactorRule.getProductId(),
				rateFactorRule.getPurchaseOptionId()
			}, rateFactorRule);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_T_P,
			new Object[] {
				rateFactorRule.getActive(), rateFactorRule.getVendorId(),
				rateFactorRule.getProductId(), rateFactorRule.getTermId(),
				rateFactorRule.getPurchaseOptionId()
			}, rateFactorRule);

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

		clearUniqueFindersCache(rateFactorRule);
	}

	@Override
	public void clearCache(List<RateFactorRule> rateFactorRules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RateFactorRule rateFactorRule : rateFactorRules) {
			EntityCacheUtil.removeResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
				RateFactorRuleImpl.class, rateFactorRule.getPrimaryKey());

			clearUniqueFindersCache(rateFactorRule);
		}
	}

	protected void cacheUniqueFindersCache(RateFactorRule rateFactorRule) {
		if (rateFactorRule.isNew()) {
			Object[] args = new Object[] {
					rateFactorRule.getActive(), rateFactorRule.getVendorId(),
					rateFactorRule.getProductId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_V_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P, args,
				rateFactorRule);

			args = new Object[] {
					rateFactorRule.getActive(), rateFactorRule.getVendorId(),
					rateFactorRule.getProductId(),
					rateFactorRule.getPurchaseOptionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_V_P_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_P, args,
				rateFactorRule);

			args = new Object[] {
					rateFactorRule.getActive(), rateFactorRule.getVendorId(),
					rateFactorRule.getProductId(), rateFactorRule.getTermId(),
					rateFactorRule.getPurchaseOptionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_V_P_T_P, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_T_P, args,
				rateFactorRule);
		}
		else {
			RateFactorRuleModelImpl rateFactorRuleModelImpl = (RateFactorRuleModelImpl)rateFactorRule;

			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_V_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRule.getActive(), rateFactorRule.getVendorId(),
						rateFactorRule.getProductId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_V_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P, args,
					rateFactorRule);
			}

			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_V_P_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRule.getActive(), rateFactorRule.getVendorId(),
						rateFactorRule.getProductId(),
						rateFactorRule.getPurchaseOptionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_V_P_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_P, args,
					rateFactorRule);
			}

			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_V_P_T_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRule.getActive(), rateFactorRule.getVendorId(),
						rateFactorRule.getProductId(),
						rateFactorRule.getTermId(),
						rateFactorRule.getPurchaseOptionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_V_P_T_P, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_V_P_T_P, args,
					rateFactorRule);
			}
		}
	}

	protected void clearUniqueFindersCache(RateFactorRule rateFactorRule) {
		RateFactorRuleModelImpl rateFactorRuleModelImpl = (RateFactorRuleModelImpl)rateFactorRule;

		Object[] args = new Object[] {
				rateFactorRule.getActive(), rateFactorRule.getVendorId(),
				rateFactorRule.getProductId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P, args);

		if ((rateFactorRuleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_V_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					rateFactorRuleModelImpl.getOriginalActive(),
					rateFactorRuleModelImpl.getOriginalVendorId(),
					rateFactorRuleModelImpl.getOriginalProductId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P, args);
		}

		args = new Object[] {
				rateFactorRule.getActive(), rateFactorRule.getVendorId(),
				rateFactorRule.getProductId(),
				rateFactorRule.getPurchaseOptionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V_P_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P_P, args);

		if ((rateFactorRuleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_V_P_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					rateFactorRuleModelImpl.getOriginalActive(),
					rateFactorRuleModelImpl.getOriginalVendorId(),
					rateFactorRuleModelImpl.getOriginalProductId(),
					rateFactorRuleModelImpl.getOriginalPurchaseOptionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V_P_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P_P, args);
		}

		args = new Object[] {
				rateFactorRule.getActive(), rateFactorRule.getVendorId(),
				rateFactorRule.getProductId(), rateFactorRule.getTermId(),
				rateFactorRule.getPurchaseOptionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V_P_T_P, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P_T_P, args);

		if ((rateFactorRuleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_V_P_T_P.getColumnBitmask()) != 0) {
			args = new Object[] {
					rateFactorRuleModelImpl.getOriginalActive(),
					rateFactorRuleModelImpl.getOriginalVendorId(),
					rateFactorRuleModelImpl.getOriginalProductId(),
					rateFactorRuleModelImpl.getOriginalTermId(),
					rateFactorRuleModelImpl.getOriginalPurchaseOptionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V_P_T_P, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_V_P_T_P, args);
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
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRuleModelImpl.getOriginalVendorId(),
						rateFactorRuleModelImpl.getOriginalActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_V,
					args);

				args = new Object[] {
						rateFactorRuleModelImpl.getVendorId(),
						rateFactorRuleModelImpl.getActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_V,
					args);
			}

			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRuleModelImpl.getOriginalVendorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID,
					args);

				args = new Object[] { rateFactorRuleModelImpl.getVendorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENDORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENDORID,
					args);
			}

			if ((rateFactorRuleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATEFACTORRULEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rateFactorRuleModelImpl.getOriginalRateFactorRuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATEFACTORRULEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATEFACTORRULEID,
					args);

				args = new Object[] {
						rateFactorRuleModelImpl.getRateFactorRuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATEFACTORRULEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATEFACTORRULEID,
					args);
			}
		}

		EntityCacheUtil.putResult(RateFactorRuleModelImpl.ENTITY_CACHE_ENABLED,
			RateFactorRuleImpl.class, rateFactorRule.getPrimaryKey(),
			rateFactorRule);

		clearUniqueFindersCache(rateFactorRule);
		cacheUniqueFindersCache(rateFactorRule);

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