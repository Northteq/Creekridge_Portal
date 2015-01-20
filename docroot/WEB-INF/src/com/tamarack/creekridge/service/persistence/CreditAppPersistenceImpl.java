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

import com.tamarack.creekridge.NoSuchCreditAppException;
import com.tamarack.creekridge.model.CreditApp;
import com.tamarack.creekridge.model.impl.CreditAppImpl;
import com.tamarack.creekridge.model.impl.CreditAppModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the credit app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Tamarack Consulting
 * @see CreditAppPersistence
 * @see CreditAppUtil
 * @generated
 */
public class CreditAppPersistenceImpl extends BasePersistenceImpl<CreditApp>
	implements CreditAppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreditAppUtil} to access the credit app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreditAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreditAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreditAppId",
			new String[] { Long.class.getName() },
			CreditAppModelImpl.CREDITAPPID_COLUMN_BITMASK |
			CreditAppModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDITAPPID = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreditAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit apps where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByCreditAppId(long creditAppId)
		throws SystemException {
		return findByCreditAppId(creditAppId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit apps where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @return the range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByCreditAppId(long creditAppId, int start,
		int end) throws SystemException {
		return findByCreditAppId(creditAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit apps where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByCreditAppId(long creditAppId, int start,
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

		List<CreditApp> list = (List<CreditApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditApp creditApp : list) {
				if ((creditAppId != creditApp.getCreditAppId())) {
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

			query.append(_SQL_SELECT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppId);

				if (!pagination) {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditApp>(list);
				}
				else {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first credit app in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByCreditAppId_First(creditAppId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the first credit app in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditApp> list = findByCreditAppId(creditAppId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByCreditAppId_Last(creditAppId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the last credit app in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreditAppId(creditAppId);

		if (count == 0) {
			return null;
		}

		List<CreditApp> list = findByCreditAppId(creditAppId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the credit apps where creditAppId = &#63; from the database.
	 *
	 * @param creditAppId the credit app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreditAppId(long creditAppId) throws SystemException {
		for (CreditApp creditApp : findByCreditAppId(creditAppId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditApp);
		}
	}

	/**
	 * Returns the number of credit apps where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the number of matching credit apps
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

			query.append(_SQL_COUNT_CREDITAPP_WHERE);

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

	private static final String _FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2 = "creditApp.creditAppId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPSTATUSID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreditAppStatusId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPSTATUSID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreditAppStatusId", new String[] { Long.class.getName() },
			CreditAppModelImpl.CREDITAPPSTATUSID_COLUMN_BITMASK |
			CreditAppModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDITAPPSTATUSID = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCreditAppStatusId", new String[] { Long.class.getName() });

	/**
	 * Returns all the credit apps where creditAppStatusId = &#63;.
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @return the matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByCreditAppStatusId(long creditAppStatusId)
		throws SystemException {
		return findByCreditAppStatusId(creditAppStatusId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit apps where creditAppStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @return the range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByCreditAppStatusId(long creditAppStatusId,
		int start, int end) throws SystemException {
		return findByCreditAppStatusId(creditAppStatusId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit apps where creditAppStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByCreditAppStatusId(long creditAppStatusId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPSTATUSID;
			finderArgs = new Object[] { creditAppStatusId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPSTATUSID;
			finderArgs = new Object[] {
					creditAppStatusId,
					
					start, end, orderByComparator
				};
		}

		List<CreditApp> list = (List<CreditApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditApp creditApp : list) {
				if ((creditAppStatusId != creditApp.getCreditAppStatusId())) {
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

			query.append(_SQL_SELECT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPSTATUSID_CREDITAPPSTATUSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppStatusId);

				if (!pagination) {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditApp>(list);
				}
				else {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first credit app in the ordered set where creditAppStatusId = &#63;.
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByCreditAppStatusId_First(long creditAppStatusId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByCreditAppStatusId_First(creditAppStatusId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppStatusId=");
		msg.append(creditAppStatusId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the first credit app in the ordered set where creditAppStatusId = &#63;.
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByCreditAppStatusId_First(long creditAppStatusId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditApp> list = findByCreditAppStatusId(creditAppStatusId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app in the ordered set where creditAppStatusId = &#63;.
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByCreditAppStatusId_Last(long creditAppStatusId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByCreditAppStatusId_Last(creditAppStatusId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppStatusId=");
		msg.append(creditAppStatusId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the last credit app in the ordered set where creditAppStatusId = &#63;.
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByCreditAppStatusId_Last(long creditAppStatusId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreditAppStatusId(creditAppStatusId);

		if (count == 0) {
			return null;
		}

		List<CreditApp> list = findByCreditAppStatusId(creditAppStatusId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit apps before and after the current credit app in the ordered set where creditAppStatusId = &#63;.
	 *
	 * @param creditAppId the primary key of the current credit app
	 * @param creditAppStatusId the credit app status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp[] findByCreditAppStatusId_PrevAndNext(long creditAppId,
		long creditAppStatusId, OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = findByPrimaryKey(creditAppId);

		Session session = null;

		try {
			session = openSession();

			CreditApp[] array = new CreditAppImpl[3];

			array[0] = getByCreditAppStatusId_PrevAndNext(session, creditApp,
					creditAppStatusId, orderByComparator, true);

			array[1] = creditApp;

			array[2] = getByCreditAppStatusId_PrevAndNext(session, creditApp,
					creditAppStatusId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditApp getByCreditAppStatusId_PrevAndNext(Session session,
		CreditApp creditApp, long creditAppStatusId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPP_WHERE);

		query.append(_FINDER_COLUMN_CREDITAPPSTATUSID_CREDITAPPSTATUSID_2);

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
			query.append(CreditAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creditAppStatusId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit apps where creditAppStatusId = &#63; from the database.
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreditAppStatusId(long creditAppStatusId)
		throws SystemException {
		for (CreditApp creditApp : findByCreditAppStatusId(creditAppStatusId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditApp);
		}
	}

	/**
	 * Returns the number of credit apps where creditAppStatusId = &#63;.
	 *
	 * @param creditAppStatusId the credit app status ID
	 * @return the number of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreditAppStatusId(long creditAppStatusId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREDITAPPSTATUSID;

		Object[] finderArgs = new Object[] { creditAppStatusId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPSTATUSID_CREDITAPPSTATUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppStatusId);

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

	private static final String _FINDER_COLUMN_CREDITAPPSTATUSID_CREDITAPPSTATUSID_2 =
		"creditApp.creditAppStatusId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			CreditAppModelImpl.GROUPID_COLUMN_BITMASK |
			CreditAppModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit apps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit apps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @return the range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit apps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByGroupId(long groupId, int start, int end,
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

		List<CreditApp> list = (List<CreditApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditApp creditApp : list) {
				if ((groupId != creditApp.getGroupId())) {
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

			query.append(_SQL_SELECT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditApp>(list);
				}
				else {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByGroupId_First(groupId, orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the first credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditApp> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByGroupId_Last(groupId, orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CreditApp> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit apps before and after the current credit app in the ordered set where groupId = &#63;.
	 *
	 * @param creditAppId the primary key of the current credit app
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp[] findByGroupId_PrevAndNext(long creditAppId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = findByPrimaryKey(creditAppId);

		Session session = null;

		try {
			session = openSession();

			CreditApp[] array = new CreditAppImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, creditApp, groupId,
					orderByComparator, true);

			array[1] = creditApp;

			array[2] = getByGroupId_PrevAndNext(session, creditApp, groupId,
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

	protected CreditApp getByGroupId_PrevAndNext(Session session,
		CreditApp creditApp, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPP_WHERE);

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
			query.append(CreditAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit apps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (CreditApp creditApp : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(creditApp);
		}
	}

	/**
	 * Returns the number of credit apps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching credit apps
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

			query.append(_SQL_COUNT_CREDITAPP_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "creditApp.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDUSERID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDUSERID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupIdUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CreditAppModelImpl.GROUPID_COLUMN_BITMASK |
			CreditAppModelImpl.USERID_COLUMN_BITMASK |
			CreditAppModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDUSERID = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupIdUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByGroupIdUserId(long groupId, long userId)
		throws SystemException {
		return findByGroupIdUserId(groupId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @return the range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByGroupIdUserId(long groupId, long userId,
		int start, int end) throws SystemException {
		return findByGroupIdUserId(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByGroupIdUserId(long groupId, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDUSERID;
			finderArgs = new Object[] { groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDUSERID;
			finderArgs = new Object[] {
					groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<CreditApp> list = (List<CreditApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditApp creditApp : list) {
				if ((groupId != creditApp.getGroupId()) ||
						(userId != creditApp.getUserId())) {
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

			query.append(_SQL_SELECT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDUSERID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditApp>(list);
				}
				else {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByGroupIdUserId_First(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByGroupIdUserId_First(groupId, userId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the first credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByGroupIdUserId_First(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditApp> list = findByGroupIdUserId(groupId, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByGroupIdUserId_Last(long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByGroupIdUserId_Last(groupId, userId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByGroupIdUserId_Last(long groupId, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupIdUserId(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<CreditApp> list = findByGroupIdUserId(groupId, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit apps before and after the current credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param creditAppId the primary key of the current credit app
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp[] findByGroupIdUserId_PrevAndNext(long creditAppId,
		long groupId, long userId, OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = findByPrimaryKey(creditAppId);

		Session session = null;

		try {
			session = openSession();

			CreditApp[] array = new CreditAppImpl[3];

			array[0] = getByGroupIdUserId_PrevAndNext(session, creditApp,
					groupId, userId, orderByComparator, true);

			array[1] = creditApp;

			array[2] = getByGroupIdUserId_PrevAndNext(session, creditApp,
					groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditApp getByGroupIdUserId_PrevAndNext(Session session,
		CreditApp creditApp, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPP_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDUSERID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDUSERID_USERID_2);

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
			query.append(CreditAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit apps where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdUserId(long groupId, long userId)
		throws SystemException {
		for (CreditApp creditApp : findByGroupIdUserId(groupId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditApp);
		}
	}

	/**
	 * Returns the number of credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdUserId(long groupId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDUSERID;

		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDUSERID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_GROUPIDUSERID_GROUPID_2 = "creditApp.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDUSERID_USERID_2 = "creditApp.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTDRAFTGROUPID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotDraftGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNotDraftGroupId",
			new String[] { Long.class.getName() },
			CreditAppModelImpl.GROUPID_COLUMN_BITMASK |
			CreditAppModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTDRAFTGROUPID = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNotDraftGroupId", new String[] { Long.class.getName() });

	/**
	 * Returns all the credit apps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByNotDraftGroupId(long groupId)
		throws SystemException {
		return findByNotDraftGroupId(groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit apps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @return the range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByNotDraftGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByNotDraftGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit apps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByNotDraftGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTDRAFTGROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<CreditApp> list = (List<CreditApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditApp creditApp : list) {
				if ((groupId != creditApp.getGroupId())) {
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

			query.append(_SQL_SELECT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_NOTDRAFTGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditApp>(list);
				}
				else {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByNotDraftGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByNotDraftGroupId_First(groupId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the first credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByNotDraftGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditApp> list = findByNotDraftGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByNotDraftGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByNotDraftGroupId_Last(groupId,
				orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByNotDraftGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNotDraftGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<CreditApp> list = findByNotDraftGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit apps before and after the current credit app in the ordered set where groupId = &#63;.
	 *
	 * @param creditAppId the primary key of the current credit app
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp[] findByNotDraftGroupId_PrevAndNext(long creditAppId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = findByPrimaryKey(creditAppId);

		Session session = null;

		try {
			session = openSession();

			CreditApp[] array = new CreditAppImpl[3];

			array[0] = getByNotDraftGroupId_PrevAndNext(session, creditApp,
					groupId, orderByComparator, true);

			array[1] = creditApp;

			array[2] = getByNotDraftGroupId_PrevAndNext(session, creditApp,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditApp getByNotDraftGroupId_PrevAndNext(Session session,
		CreditApp creditApp, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPP_WHERE);

		query.append(_FINDER_COLUMN_NOTDRAFTGROUPID_GROUPID_2);

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
			query.append(CreditAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit apps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotDraftGroupId(long groupId) throws SystemException {
		for (CreditApp creditApp : findByNotDraftGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditApp);
		}
	}

	/**
	 * Returns the number of credit apps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotDraftGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTDRAFTGROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_NOTDRAFTGROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_NOTDRAFTGROUPID_GROUPID_2 = "creditApp.groupId = ? AND creditApp.creditAppStatusId != 1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTDRAFTGROUPIDUSERID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNotDraftGroupIdUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPIDUSERID =
		new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, CreditAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByNotDraftGroupIdUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			CreditAppModelImpl.GROUPID_COLUMN_BITMASK |
			CreditAppModelImpl.USERID_COLUMN_BITMASK |
			CreditAppModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTDRAFTGROUPIDUSERID = new FinderPath(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNotDraftGroupIdUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByNotDraftGroupIdUserId(long groupId, long userId)
		throws SystemException {
		return findByNotDraftGroupIdUserId(groupId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @return the range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByNotDraftGroupIdUserId(long groupId,
		long userId, int start, int end) throws SystemException {
		return findByNotDraftGroupIdUserId(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findByNotDraftGroupIdUserId(long groupId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPIDUSERID;
			finderArgs = new Object[] { groupId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTDRAFTGROUPIDUSERID;
			finderArgs = new Object[] {
					groupId, userId,
					
					start, end, orderByComparator
				};
		}

		List<CreditApp> list = (List<CreditApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditApp creditApp : list) {
				if ((groupId != creditApp.getGroupId()) ||
						(userId != creditApp.getUserId())) {
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

			query.append(_SQL_SELECT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_GROUPID_2);

			query.append(_FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditApp>(list);
				}
				else {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByNotDraftGroupIdUserId_First(long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByNotDraftGroupIdUserId_First(groupId,
				userId, orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the first credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByNotDraftGroupIdUserId_First(long groupId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<CreditApp> list = findByNotDraftGroupIdUserId(groupId, userId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByNotDraftGroupIdUserId_Last(long groupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByNotDraftGroupIdUserId_Last(groupId,
				userId, orderByComparator);

		if (creditApp != null) {
			return creditApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppException(msg.toString());
	}

	/**
	 * Returns the last credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByNotDraftGroupIdUserId_Last(long groupId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNotDraftGroupIdUserId(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<CreditApp> list = findByNotDraftGroupIdUserId(groupId, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit apps before and after the current credit app in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param creditAppId the primary key of the current credit app
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp[] findByNotDraftGroupIdUserId_PrevAndNext(
		long creditAppId, long groupId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = findByPrimaryKey(creditAppId);

		Session session = null;

		try {
			session = openSession();

			CreditApp[] array = new CreditAppImpl[3];

			array[0] = getByNotDraftGroupIdUserId_PrevAndNext(session,
					creditApp, groupId, userId, orderByComparator, true);

			array[1] = creditApp;

			array[2] = getByNotDraftGroupIdUserId_PrevAndNext(session,
					creditApp, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditApp getByNotDraftGroupIdUserId_PrevAndNext(
		Session session, CreditApp creditApp, long groupId, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPP_WHERE);

		query.append(_FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_GROUPID_2);

		query.append(_FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_USERID_2);

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
			query.append(CreditAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit apps where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotDraftGroupIdUserId(long groupId, long userId)
		throws SystemException {
		for (CreditApp creditApp : findByNotDraftGroupIdUserId(groupId, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditApp);
		}
	}

	/**
	 * Returns the number of credit apps where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotDraftGroupIdUserId(long groupId, long userId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTDRAFTGROUPIDUSERID;

		Object[] finderArgs = new Object[] { groupId, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CREDITAPP_WHERE);

			query.append(_FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_GROUPID_2);

			query.append(_FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_GROUPID_2 = "creditApp.groupId = ? AND ";
	private static final String _FINDER_COLUMN_NOTDRAFTGROUPIDUSERID_USERID_2 = "creditApp.userId = ? AND creditApp.creditAppStatusId != 1";

	public CreditAppPersistenceImpl() {
		setModelClass(CreditApp.class);
	}

	/**
	 * Caches the credit app in the entity cache if it is enabled.
	 *
	 * @param creditApp the credit app
	 */
	@Override
	public void cacheResult(CreditApp creditApp) {
		EntityCacheUtil.putResult(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppImpl.class, creditApp.getPrimaryKey(), creditApp);

		creditApp.resetOriginalValues();
	}

	/**
	 * Caches the credit apps in the entity cache if it is enabled.
	 *
	 * @param creditApps the credit apps
	 */
	@Override
	public void cacheResult(List<CreditApp> creditApps) {
		for (CreditApp creditApp : creditApps) {
			if (EntityCacheUtil.getResult(
						CreditAppModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppImpl.class, creditApp.getPrimaryKey()) == null) {
				cacheResult(creditApp);
			}
			else {
				creditApp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all credit apps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CreditAppImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CreditAppImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit app.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditApp creditApp) {
		EntityCacheUtil.removeResult(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppImpl.class, creditApp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CreditApp> creditApps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CreditApp creditApp : creditApps) {
			EntityCacheUtil.removeResult(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppImpl.class, creditApp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new credit app with the primary key. Does not add the credit app to the database.
	 *
	 * @param creditAppId the primary key for the new credit app
	 * @return the new credit app
	 */
	@Override
	public CreditApp create(long creditAppId) {
		CreditApp creditApp = new CreditAppImpl();

		creditApp.setNew(true);
		creditApp.setPrimaryKey(creditAppId);

		return creditApp;
	}

	/**
	 * Removes the credit app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creditAppId the primary key of the credit app
	 * @return the credit app that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp remove(long creditAppId)
		throws NoSuchCreditAppException, SystemException {
		return remove((Serializable)creditAppId);
	}

	/**
	 * Removes the credit app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit app
	 * @return the credit app that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp remove(Serializable primaryKey)
		throws NoSuchCreditAppException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CreditApp creditApp = (CreditApp)session.get(CreditAppImpl.class,
					primaryKey);

			if (creditApp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creditApp);
		}
		catch (NoSuchCreditAppException nsee) {
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
	protected CreditApp removeImpl(CreditApp creditApp)
		throws SystemException {
		creditApp = toUnwrappedModel(creditApp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditApp)) {
				creditApp = (CreditApp)session.get(CreditAppImpl.class,
						creditApp.getPrimaryKeyObj());
			}

			if (creditApp != null) {
				session.delete(creditApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creditApp != null) {
			clearCache(creditApp);
		}

		return creditApp;
	}

	@Override
	public CreditApp updateImpl(
		com.tamarack.creekridge.model.CreditApp creditApp)
		throws SystemException {
		creditApp = toUnwrappedModel(creditApp);

		boolean isNew = creditApp.isNew();

		CreditAppModelImpl creditAppModelImpl = (CreditAppModelImpl)creditApp;

		Session session = null;

		try {
			session = openSession();

			if (creditApp.isNew()) {
				session.save(creditApp);

				creditApp.setNew(false);
			}
			else {
				session.merge(creditApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CreditAppModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((creditAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppModelImpl.getOriginalCreditAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);

				args = new Object[] { creditAppModelImpl.getCreditAppId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);
			}

			if ((creditAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPSTATUSID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppModelImpl.getOriginalCreditAppStatusId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPSTATUSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPSTATUSID,
					args);

				args = new Object[] { creditAppModelImpl.getCreditAppStatusId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPSTATUSID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPSTATUSID,
					args);
			}

			if ((creditAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { creditAppModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((creditAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppModelImpl.getOriginalGroupId(),
						creditAppModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDUSERID,
					args);

				args = new Object[] {
						creditAppModelImpl.getGroupId(),
						creditAppModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDUSERID,
					args);
			}

			if ((creditAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTDRAFTGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPID,
					args);

				args = new Object[] { creditAppModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTDRAFTGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPID,
					args);
			}

			if ((creditAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPIDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppModelImpl.getOriginalGroupId(),
						creditAppModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTDRAFTGROUPIDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPIDUSERID,
					args);

				args = new Object[] {
						creditAppModelImpl.getGroupId(),
						creditAppModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTDRAFTGROUPIDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTDRAFTGROUPIDUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppImpl.class, creditApp.getPrimaryKey(), creditApp);

		return creditApp;
	}

	protected CreditApp toUnwrappedModel(CreditApp creditApp) {
		if (creditApp instanceof CreditAppImpl) {
			return creditApp;
		}

		CreditAppImpl creditAppImpl = new CreditAppImpl();

		creditAppImpl.setNew(creditApp.isNew());
		creditAppImpl.setPrimaryKey(creditApp.getPrimaryKey());

		creditAppImpl.setCreditAppId(creditApp.getCreditAppId());
		creditAppImpl.setCompanyId(creditApp.getCompanyId());
		creditAppImpl.setUserId(creditApp.getUserId());
		creditAppImpl.setUserName(creditApp.getUserName());
		creditAppImpl.setCreateDate(creditApp.getCreateDate());
		creditAppImpl.setModifiedDate(creditApp.getModifiedDate());
<<<<<<< HEAD
=======
		creditAppImpl.setGroupId(creditApp.getGroupId());
>>>>>>> master
		creditAppImpl.setVendorId(creditApp.getVendorId());
		creditAppImpl.setCreditAppStatusId(creditApp.getCreditAppStatusId());
		creditAppImpl.setProductId(creditApp.getProductId());
		creditAppImpl.setTermId(creditApp.getTermId());
		creditAppImpl.setPurchaseOptionId(creditApp.getPurchaseOptionId());
		creditAppImpl.setRateFactorRuleId(creditApp.getRateFactorRuleId());
		creditAppImpl.setPaymentAmount(creditApp.getPaymentAmount());
		creditAppImpl.setEquipmentPrice(creditApp.getEquipmentPrice());
		creditAppImpl.setEquipmentDesc(creditApp.getEquipmentDesc());
		creditAppImpl.setEquipmentLocAsCustomerFlag(creditApp.isEquipmentLocAsCustomerFlag());
		creditAppImpl.setEquipmentAddress1(creditApp.getEquipmentAddress1());
		creditAppImpl.setEquipmentAddress2(creditApp.getEquipmentAddress2());
		creditAppImpl.setEquipmentCity(creditApp.getEquipmentCity());
		creditAppImpl.setEquipmentState(creditApp.getEquipmentState());
		creditAppImpl.setEquipmentZip(creditApp.getEquipmentZip());
		creditAppImpl.setCustomerName(creditApp.getCustomerName());
		creditAppImpl.setCustomerDBAName(creditApp.getCustomerDBAName());
		creditAppImpl.setCustomerAddress1(creditApp.getCustomerAddress1());
		creditAppImpl.setCustomerAddress2(creditApp.getCustomerAddress2());
		creditAppImpl.setCustomerCity(creditApp.getCustomerCity());
		creditAppImpl.setCustomerState(creditApp.getCustomerState());
		creditAppImpl.setCustomerZip(creditApp.getCustomerZip());
		creditAppImpl.setCustomerContact(creditApp.getCustomerContact());
		creditAppImpl.setCustomerContactPhone(creditApp.getCustomerContactPhone());
		creditAppImpl.setCustomerContactFax(creditApp.getCustomerContactFax());
		creditAppImpl.setCustomerContactEmail(creditApp.getCustomerContactEmail());
		creditAppImpl.setCustomerBusinessDesc(creditApp.getCustomerBusinessDesc());
		creditAppImpl.setCustomerBusinessType(creditApp.getCustomerBusinessType());
		creditAppImpl.setCustomerBusinessStartDate(creditApp.getCustomerBusinessStartDate());
		creditAppImpl.setCustomerBusinessIncorporatedState(creditApp.getCustomerBusinessIncorporatedState());
		creditAppImpl.setCustomerBusinessFederalTaxID(creditApp.getCustomerBusinessFederalTaxID());

		return creditAppImpl;
	}

	/**
	 * Returns the credit app with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app
	 * @return the credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditAppException, SystemException {
		CreditApp creditApp = fetchByPrimaryKey(primaryKey);

		if (creditApp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creditApp;
	}

	/**
	 * Returns the credit app with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppException} if it could not be found.
	 *
	 * @param creditAppId the primary key of the credit app
	 * @return the credit app
	 * @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp findByPrimaryKey(long creditAppId)
		throws NoSuchCreditAppException, SystemException {
		return findByPrimaryKey((Serializable)creditAppId);
	}

	/**
	 * Returns the credit app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app
	 * @return the credit app, or <code>null</code> if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CreditApp creditApp = (CreditApp)EntityCacheUtil.getResult(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppImpl.class, primaryKey);

		if (creditApp == _nullCreditApp) {
			return null;
		}

		if (creditApp == null) {
			Session session = null;

			try {
				session = openSession();

				creditApp = (CreditApp)session.get(CreditAppImpl.class,
						primaryKey);

				if (creditApp != null) {
					cacheResult(creditApp);
				}
				else {
					EntityCacheUtil.putResult(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppImpl.class, primaryKey, _nullCreditApp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CreditAppModelImpl.ENTITY_CACHE_ENABLED,
					CreditAppImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creditApp;
	}

	/**
	 * Returns the credit app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creditAppId the primary key of the credit app
	 * @return the credit app, or <code>null</code> if a credit app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditApp fetchByPrimaryKey(long creditAppId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)creditAppId);
	}

	/**
	 * Returns all the credit apps.
	 *
	 * @return the credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @return the range of credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit apps
	 * @param end the upper bound of the range of credit apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditApp> findAll(int start, int end,
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

		List<CreditApp> list = (List<CreditApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CREDITAPP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITAPP;

				if (pagination) {
					sql = sql.concat(CreditAppModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditApp>(list);
				}
				else {
					list = (List<CreditApp>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the credit apps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CreditApp creditApp : findAll()) {
			remove(creditApp);
		}
	}

	/**
	 * Returns the number of credit apps.
	 *
	 * @return the number of credit apps
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

				Query q = session.createQuery(_SQL_COUNT_CREDITAPP);

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
	 * Initializes the credit app persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.CreditApp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CreditApp>> listenersList = new ArrayList<ModelListener<CreditApp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CreditApp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CreditAppImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CREDITAPP = "SELECT creditApp FROM CreditApp creditApp";
	private static final String _SQL_SELECT_CREDITAPP_WHERE = "SELECT creditApp FROM CreditApp creditApp WHERE ";
	private static final String _SQL_COUNT_CREDITAPP = "SELECT COUNT(creditApp) FROM CreditApp creditApp";
	private static final String _SQL_COUNT_CREDITAPP_WHERE = "SELECT COUNT(creditApp) FROM CreditApp creditApp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creditApp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CreditApp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CreditApp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CreditAppPersistenceImpl.class);
	private static CreditApp _nullCreditApp = new CreditAppImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CreditApp> toCacheModel() {
				return _nullCreditAppCacheModel;
			}
		};

	private static CacheModel<CreditApp> _nullCreditAppCacheModel = new CacheModel<CreditApp>() {
			@Override
			public CreditApp toEntityModel() {
				return _nullCreditApp;
			}
		};
}