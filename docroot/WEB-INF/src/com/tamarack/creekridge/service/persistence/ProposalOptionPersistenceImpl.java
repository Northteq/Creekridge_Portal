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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.tamarack.creekridge.NoSuchProposalOptionException;
import com.tamarack.creekridge.model.ProposalOption;
import com.tamarack.creekridge.model.impl.ProposalOptionImpl;
import com.tamarack.creekridge.model.impl.ProposalOptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the proposal option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tamarack
 * @see ProposalOptionPersistence
 * @see ProposalOptionUtil
 * @generated
 */
public class ProposalOptionPersistenceImpl extends BasePersistenceImpl<ProposalOption>
	implements ProposalOptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProposalOptionUtil} to access the proposal option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProposalOptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED,
			ProposalOptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED,
			ProposalOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED,
			ProposalOptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreditAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED,
			ProposalOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreditAppId",
			new String[] { Long.class.getName() },
			ProposalOptionModelImpl.CREDITAPPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDITAPPID = new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreditAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the proposal options where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findByCreditAppId(long creditAppId)
		throws SystemException {
		return findByCreditAppId(creditAppId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposal options where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of proposal options
	 * @param end the upper bound of the range of proposal options (not inclusive)
	 * @return the range of matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findByCreditAppId(long creditAppId, int start,
		int end) throws SystemException {
		return findByCreditAppId(creditAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposal options where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of proposal options
	 * @param end the upper bound of the range of proposal options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findByCreditAppId(long creditAppId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID;
			finderArgs = new Object[] { creditAppId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPID;
			finderArgs = new Object[] { creditAppId, start, end, orderByComparator };
		}

		List<ProposalOption> list = (List<ProposalOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProposalOption proposalOption : list) {
				if ((creditAppId != proposalOption.getCreditAppId())) {
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

			query.append(_SQL_SELECT_PROPOSALOPTION_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProposalOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppId);

				if (!pagination) {
					list = (List<ProposalOption>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProposalOption>(list);
				}
				else {
					list = (List<ProposalOption>)QueryUtil.list(q,
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
	 * Returns the first proposal option in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal option
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption findByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchProposalOptionException, SystemException {
		ProposalOption proposalOption = fetchByCreditAppId_First(creditAppId,
				orderByComparator);

		if (proposalOption != null) {
			return proposalOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProposalOptionException(msg.toString());
	}

	/**
	 * Returns the first proposal option in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal option, or <code>null</code> if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption fetchByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProposalOption> list = findByCreditAppId(creditAppId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposal option in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal option
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption findByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchProposalOptionException, SystemException {
		ProposalOption proposalOption = fetchByCreditAppId_Last(creditAppId,
				orderByComparator);

		if (proposalOption != null) {
			return proposalOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProposalOptionException(msg.toString());
	}

	/**
	 * Returns the last proposal option in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal option, or <code>null</code> if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption fetchByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreditAppId(creditAppId);

		if (count == 0) {
			return null;
		}

		List<ProposalOption> list = findByCreditAppId(creditAppId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the proposal options before and after the current proposal option in the ordered set where creditAppId = &#63;.
	 *
	 * @param proposalOptionId the primary key of the current proposal option
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next proposal option
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption[] findByCreditAppId_PrevAndNext(
		long proposalOptionId, long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchProposalOptionException, SystemException {
		ProposalOption proposalOption = findByPrimaryKey(proposalOptionId);

		Session session = null;

		try {
			session = openSession();

			ProposalOption[] array = new ProposalOptionImpl[3];

			array[0] = getByCreditAppId_PrevAndNext(session, proposalOption,
					creditAppId, orderByComparator, true);

			array[1] = proposalOption;

			array[2] = getByCreditAppId_PrevAndNext(session, proposalOption,
					creditAppId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProposalOption getByCreditAppId_PrevAndNext(Session session,
		ProposalOption proposalOption, long creditAppId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROPOSALOPTION_WHERE);

		query.append(_FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2);

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
			query.append(ProposalOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creditAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(proposalOption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProposalOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the proposal options where creditAppId = &#63; from the database.
	 *
	 * @param creditAppId the credit app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreditAppId(long creditAppId) throws SystemException {
		for (ProposalOption proposalOption : findByCreditAppId(creditAppId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(proposalOption);
		}
	}

	/**
	 * Returns the number of proposal options where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the number of matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreditAppId(long creditAppId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREDITAPPID;

		Object[] finderArgs = new Object[] { creditAppId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSALOPTION_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppId);

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

	private static final String _FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2 = "proposalOption.creditAppId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALOPTIONID =
		new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED,
			ProposalOptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProposalOptionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALOPTIONID =
		new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED,
			ProposalOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProposalOptionId", new String[] { Long.class.getName() },
			ProposalOptionModelImpl.PROPOSALOPTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROPOSALOPTIONID = new FinderPath(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProposalOptionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the proposal options where proposalOptionId = &#63;.
	 *
	 * @param proposalOptionId the proposal option ID
	 * @return the matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findByProposalOptionId(long proposalOptionId)
		throws SystemException {
		return findByProposalOptionId(proposalOptionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposal options where proposalOptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param proposalOptionId the proposal option ID
	 * @param start the lower bound of the range of proposal options
	 * @param end the upper bound of the range of proposal options (not inclusive)
	 * @return the range of matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findByProposalOptionId(long proposalOptionId,
		int start, int end) throws SystemException {
		return findByProposalOptionId(proposalOptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposal options where proposalOptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param proposalOptionId the proposal option ID
	 * @param start the lower bound of the range of proposal options
	 * @param end the upper bound of the range of proposal options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findByProposalOptionId(long proposalOptionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALOPTIONID;
			finderArgs = new Object[] { proposalOptionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROPOSALOPTIONID;
			finderArgs = new Object[] {
					proposalOptionId,
					
					start, end, orderByComparator
				};
		}

		List<ProposalOption> list = (List<ProposalOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ProposalOption proposalOption : list) {
				if ((proposalOptionId != proposalOption.getProposalOptionId())) {
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

			query.append(_SQL_SELECT_PROPOSALOPTION_WHERE);

			query.append(_FINDER_COLUMN_PROPOSALOPTIONID_PROPOSALOPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProposalOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(proposalOptionId);

				if (!pagination) {
					list = (List<ProposalOption>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProposalOption>(list);
				}
				else {
					list = (List<ProposalOption>)QueryUtil.list(q,
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
	 * Returns the first proposal option in the ordered set where proposalOptionId = &#63;.
	 *
	 * @param proposalOptionId the proposal option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal option
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption findByProposalOptionId_First(long proposalOptionId,
		OrderByComparator orderByComparator)
		throws NoSuchProposalOptionException, SystemException {
		ProposalOption proposalOption = fetchByProposalOptionId_First(proposalOptionId,
				orderByComparator);

		if (proposalOption != null) {
			return proposalOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("proposalOptionId=");
		msg.append(proposalOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProposalOptionException(msg.toString());
	}

	/**
	 * Returns the first proposal option in the ordered set where proposalOptionId = &#63;.
	 *
	 * @param proposalOptionId the proposal option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching proposal option, or <code>null</code> if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption fetchByProposalOptionId_First(long proposalOptionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ProposalOption> list = findByProposalOptionId(proposalOptionId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last proposal option in the ordered set where proposalOptionId = &#63;.
	 *
	 * @param proposalOptionId the proposal option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal option
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption findByProposalOptionId_Last(long proposalOptionId,
		OrderByComparator orderByComparator)
		throws NoSuchProposalOptionException, SystemException {
		ProposalOption proposalOption = fetchByProposalOptionId_Last(proposalOptionId,
				orderByComparator);

		if (proposalOption != null) {
			return proposalOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("proposalOptionId=");
		msg.append(proposalOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchProposalOptionException(msg.toString());
	}

	/**
	 * Returns the last proposal option in the ordered set where proposalOptionId = &#63;.
	 *
	 * @param proposalOptionId the proposal option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching proposal option, or <code>null</code> if a matching proposal option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption fetchByProposalOptionId_Last(long proposalOptionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProposalOptionId(proposalOptionId);

		if (count == 0) {
			return null;
		}

		List<ProposalOption> list = findByProposalOptionId(proposalOptionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the proposal options where proposalOptionId = &#63; from the database.
	 *
	 * @param proposalOptionId the proposal option ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProposalOptionId(long proposalOptionId)
		throws SystemException {
		for (ProposalOption proposalOption : findByProposalOptionId(
				proposalOptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(proposalOption);
		}
	}

	/**
	 * Returns the number of proposal options where proposalOptionId = &#63;.
	 *
	 * @param proposalOptionId the proposal option ID
	 * @return the number of matching proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProposalOptionId(long proposalOptionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROPOSALOPTIONID;

		Object[] finderArgs = new Object[] { proposalOptionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROPOSALOPTION_WHERE);

			query.append(_FINDER_COLUMN_PROPOSALOPTIONID_PROPOSALOPTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(proposalOptionId);

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

	private static final String _FINDER_COLUMN_PROPOSALOPTIONID_PROPOSALOPTIONID_2 =
		"proposalOption.proposalOptionId = ?";

	public ProposalOptionPersistenceImpl() {
		setModelClass(ProposalOption.class);
	}

	/**
	 * Caches the proposal option in the entity cache if it is enabled.
	 *
	 * @param proposalOption the proposal option
	 */
	@Override
	public void cacheResult(ProposalOption proposalOption) {
		EntityCacheUtil.putResult(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionImpl.class, proposalOption.getPrimaryKey(),
			proposalOption);

		proposalOption.resetOriginalValues();
	}

	/**
	 * Caches the proposal options in the entity cache if it is enabled.
	 *
	 * @param proposalOptions the proposal options
	 */
	@Override
	public void cacheResult(List<ProposalOption> proposalOptions) {
		for (ProposalOption proposalOption : proposalOptions) {
			if (EntityCacheUtil.getResult(
						ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
						ProposalOptionImpl.class, proposalOption.getPrimaryKey()) == null) {
				cacheResult(proposalOption);
			}
			else {
				proposalOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all proposal options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProposalOptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProposalOptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the proposal option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProposalOption proposalOption) {
		EntityCacheUtil.removeResult(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionImpl.class, proposalOption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProposalOption> proposalOptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProposalOption proposalOption : proposalOptions) {
			EntityCacheUtil.removeResult(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
				ProposalOptionImpl.class, proposalOption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new proposal option with the primary key. Does not add the proposal option to the database.
	 *
	 * @param proposalOptionId the primary key for the new proposal option
	 * @return the new proposal option
	 */
	@Override
	public ProposalOption create(long proposalOptionId) {
		ProposalOption proposalOption = new ProposalOptionImpl();

		proposalOption.setNew(true);
		proposalOption.setPrimaryKey(proposalOptionId);

		return proposalOption;
	}

	/**
	 * Removes the proposal option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param proposalOptionId the primary key of the proposal option
	 * @return the proposal option that was removed
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption remove(long proposalOptionId)
		throws NoSuchProposalOptionException, SystemException {
		return remove((Serializable)proposalOptionId);
	}

	/**
	 * Removes the proposal option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the proposal option
	 * @return the proposal option that was removed
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption remove(Serializable primaryKey)
		throws NoSuchProposalOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProposalOption proposalOption = (ProposalOption)session.get(ProposalOptionImpl.class,
					primaryKey);

			if (proposalOption == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProposalOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(proposalOption);
		}
		catch (NoSuchProposalOptionException nsee) {
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
	protected ProposalOption removeImpl(ProposalOption proposalOption)
		throws SystemException {
		proposalOption = toUnwrappedModel(proposalOption);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(proposalOption)) {
				proposalOption = (ProposalOption)session.get(ProposalOptionImpl.class,
						proposalOption.getPrimaryKeyObj());
			}

			if (proposalOption != null) {
				session.delete(proposalOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (proposalOption != null) {
			clearCache(proposalOption);
		}

		return proposalOption;
	}

	@Override
	public ProposalOption updateImpl(
		com.tamarack.creekridge.model.ProposalOption proposalOption)
		throws SystemException {
		proposalOption = toUnwrappedModel(proposalOption);

		boolean isNew = proposalOption.isNew();

		ProposalOptionModelImpl proposalOptionModelImpl = (ProposalOptionModelImpl)proposalOption;

		Session session = null;

		try {
			session = openSession();

			if (proposalOption.isNew()) {
				session.save(proposalOption);

				proposalOption.setNew(false);
			}
			else {
				session.merge(proposalOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ProposalOptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((proposalOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						proposalOptionModelImpl.getOriginalCreditAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);

				args = new Object[] { proposalOptionModelImpl.getCreditAppId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);
			}

			if ((proposalOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALOPTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						proposalOptionModelImpl.getOriginalProposalOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSALOPTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALOPTIONID,
					args);

				args = new Object[] {
						proposalOptionModelImpl.getProposalOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROPOSALOPTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROPOSALOPTIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
			ProposalOptionImpl.class, proposalOption.getPrimaryKey(),
			proposalOption);

		return proposalOption;
	}

	protected ProposalOption toUnwrappedModel(ProposalOption proposalOption) {
		if (proposalOption instanceof ProposalOptionImpl) {
			return proposalOption;
		}

		ProposalOptionImpl proposalOptionImpl = new ProposalOptionImpl();

		proposalOptionImpl.setNew(proposalOption.isNew());
		proposalOptionImpl.setPrimaryKey(proposalOption.getPrimaryKey());

		proposalOptionImpl.setProposalOptionId(proposalOption.getProposalOptionId());
		proposalOptionImpl.setCompanyId(proposalOption.getCompanyId());
		proposalOptionImpl.setUserId(proposalOption.getUserId());
		proposalOptionImpl.setUserName(proposalOption.getUserName());
		proposalOptionImpl.setCreateDate(proposalOption.getCreateDate());
		proposalOptionImpl.setModifiedDate(proposalOption.getModifiedDate());
		proposalOptionImpl.setCreditAppId(proposalOption.getCreditAppId());
		proposalOptionImpl.setProductId(proposalOption.getProductId());
		proposalOptionImpl.setTermId(proposalOption.getTermId());
		proposalOptionImpl.setPurchaseOptionId(proposalOption.getPurchaseOptionId());
		proposalOptionImpl.setRateFactorRuleId(proposalOption.getRateFactorRuleId());
		proposalOptionImpl.setPaymentAmount(proposalOption.getPaymentAmount());
		proposalOptionImpl.setEquipmentPrice(proposalOption.getEquipmentPrice());
		proposalOptionImpl.setIncludeInProposal(proposalOption.isIncludeInProposal());
		proposalOptionImpl.setUseForCreditApp(proposalOption.isUseForCreditApp());

		return proposalOptionImpl;
	}

	/**
	 * Returns the proposal option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal option
	 * @return the proposal option
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProposalOptionException, SystemException {
		ProposalOption proposalOption = fetchByPrimaryKey(primaryKey);

		if (proposalOption == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProposalOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return proposalOption;
	}

	/**
	 * Returns the proposal option with the primary key or throws a {@link com.tamarack.creekridge.NoSuchProposalOptionException} if it could not be found.
	 *
	 * @param proposalOptionId the primary key of the proposal option
	 * @return the proposal option
	 * @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption findByPrimaryKey(long proposalOptionId)
		throws NoSuchProposalOptionException, SystemException {
		return findByPrimaryKey((Serializable)proposalOptionId);
	}

	/**
	 * Returns the proposal option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the proposal option
	 * @return the proposal option, or <code>null</code> if a proposal option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProposalOption proposalOption = (ProposalOption)EntityCacheUtil.getResult(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
				ProposalOptionImpl.class, primaryKey);

		if (proposalOption == _nullProposalOption) {
			return null;
		}

		if (proposalOption == null) {
			Session session = null;

			try {
				session = openSession();

				proposalOption = (ProposalOption)session.get(ProposalOptionImpl.class,
						primaryKey);

				if (proposalOption != null) {
					cacheResult(proposalOption);
				}
				else {
					EntityCacheUtil.putResult(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
						ProposalOptionImpl.class, primaryKey,
						_nullProposalOption);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProposalOptionModelImpl.ENTITY_CACHE_ENABLED,
					ProposalOptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return proposalOption;
	}

	/**
	 * Returns the proposal option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param proposalOptionId the primary key of the proposal option
	 * @return the proposal option, or <code>null</code> if a proposal option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProposalOption fetchByPrimaryKey(long proposalOptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)proposalOptionId);
	}

	/**
	 * Returns all the proposal options.
	 *
	 * @return the proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the proposal options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal options
	 * @param end the upper bound of the range of proposal options (not inclusive)
	 * @return the range of proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the proposal options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of proposal options
	 * @param end the upper bound of the range of proposal options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of proposal options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProposalOption> findAll(int start, int end,
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

		List<ProposalOption> list = (List<ProposalOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROPOSALOPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROPOSALOPTION;

				if (pagination) {
					sql = sql.concat(ProposalOptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProposalOption>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProposalOption>(list);
				}
				else {
					list = (List<ProposalOption>)QueryUtil.list(q,
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
	 * Removes all the proposal options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProposalOption proposalOption : findAll()) {
			remove(proposalOption);
		}
	}

	/**
	 * Returns the number of proposal options.
	 *
	 * @return the number of proposal options
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

				Query q = session.createQuery(_SQL_COUNT_PROPOSALOPTION);

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
	 * Initializes the proposal option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.ProposalOption")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProposalOption>> listenersList = new ArrayList<ModelListener<ProposalOption>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProposalOption>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProposalOptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROPOSALOPTION = "SELECT proposalOption FROM ProposalOption proposalOption";
	private static final String _SQL_SELECT_PROPOSALOPTION_WHERE = "SELECT proposalOption FROM ProposalOption proposalOption WHERE ";
	private static final String _SQL_COUNT_PROPOSALOPTION = "SELECT COUNT(proposalOption) FROM ProposalOption proposalOption";
	private static final String _SQL_COUNT_PROPOSALOPTION_WHERE = "SELECT COUNT(proposalOption) FROM ProposalOption proposalOption WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "proposalOption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProposalOption exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProposalOption exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProposalOptionPersistenceImpl.class);
	private static ProposalOption _nullProposalOption = new ProposalOptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProposalOption> toCacheModel() {
				return _nullProposalOptionCacheModel;
			}
		};

	private static CacheModel<ProposalOption> _nullProposalOptionCacheModel = new CacheModel<ProposalOption>() {
			@Override
			public ProposalOption toEntityModel() {
				return _nullProposalOption;
			}
		};
}