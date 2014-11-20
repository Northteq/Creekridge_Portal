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

import com.tamarack.creekridge.NoSuchCreditAppPrincipalException;
import com.tamarack.creekridge.model.CreditAppPrincipal;
import com.tamarack.creekridge.model.impl.CreditAppPrincipalImpl;
import com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the credit app principal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppPrincipalPersistence
 * @see CreditAppPrincipalUtil
 * @generated
 */
public class CreditAppPrincipalPersistenceImpl extends BasePersistenceImpl<CreditAppPrincipal>
	implements CreditAppPrincipalPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreditAppPrincipalUtil} to access the credit app principal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreditAppPrincipalImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRINCIPALID =
		new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrincipalId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINCIPALID =
		new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrincipalId",
			new String[] { Long.class.getName() },
			CreditAppPrincipalModelImpl.PRINCIPALID_COLUMN_BITMASK |
			CreditAppPrincipalModelImpl.PRINCIPALFIRSTNAME_COLUMN_BITMASK |
			CreditAppPrincipalModelImpl.SEQUENCENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRINCIPALID = new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrincipalId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit app principals where principalId = &#63;.
	 *
	 * @param principalId the principal ID
	 * @return the matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findByPrincipalId(long principalId)
		throws SystemException {
		return findByPrincipalId(principalId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app principals where principalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param principalId the principal ID
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @return the range of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findByPrincipalId(long principalId,
		int start, int end) throws SystemException {
		return findByPrincipalId(principalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app principals where principalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param principalId the principal ID
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findByPrincipalId(long principalId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINCIPALID;
			finderArgs = new Object[] { principalId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRINCIPALID;
			finderArgs = new Object[] { principalId, start, end, orderByComparator };
		}

		List<CreditAppPrincipal> list = (List<CreditAppPrincipal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditAppPrincipal creditAppPrincipal : list) {
				if ((principalId != creditAppPrincipal.getPrincipalId())) {
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

			query.append(_SQL_SELECT_CREDITAPPPRINCIPAL_WHERE);

			query.append(_FINDER_COLUMN_PRINCIPALID_PRINCIPALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppPrincipalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(principalId);

				if (!pagination) {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppPrincipal>(list);
				}
				else {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
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
	 * Returns the first credit app principal in the ordered set where principalId = &#63;.
	 *
	 * @param principalId the principal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findByPrincipalId_First(long principalId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = fetchByPrincipalId_First(principalId,
				orderByComparator);

		if (creditAppPrincipal != null) {
			return creditAppPrincipal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("principalId=");
		msg.append(principalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppPrincipalException(msg.toString());
	}

	/**
	 * Returns the first credit app principal in the ordered set where principalId = &#63;.
	 *
	 * @param principalId the principal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchByPrincipalId_First(long principalId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditAppPrincipal> list = findByPrincipalId(principalId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app principal in the ordered set where principalId = &#63;.
	 *
	 * @param principalId the principal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findByPrincipalId_Last(long principalId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = fetchByPrincipalId_Last(principalId,
				orderByComparator);

		if (creditAppPrincipal != null) {
			return creditAppPrincipal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("principalId=");
		msg.append(principalId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppPrincipalException(msg.toString());
	}

	/**
	 * Returns the last credit app principal in the ordered set where principalId = &#63;.
	 *
	 * @param principalId the principal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchByPrincipalId_Last(long principalId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPrincipalId(principalId);

		if (count == 0) {
			return null;
		}

		List<CreditAppPrincipal> list = findByPrincipalId(principalId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the credit app principals where principalId = &#63; from the database.
	 *
	 * @param principalId the principal ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPrincipalId(long principalId) throws SystemException {
		for (CreditAppPrincipal creditAppPrincipal : findByPrincipalId(
				principalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditAppPrincipal);
		}
	}

	/**
	 * Returns the number of credit app principals where principalId = &#63;.
	 *
	 * @param principalId the principal ID
	 * @return the number of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPrincipalId(long principalId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRINCIPALID;

		Object[] finderArgs = new Object[] { principalId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREDITAPPPRINCIPAL_WHERE);

			query.append(_FINDER_COLUMN_PRINCIPALID_PRINCIPALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(principalId);

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

	private static final String _FINDER_COLUMN_PRINCIPALID_PRINCIPALID_2 = "creditAppPrincipal.principalId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreditAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreditAppId",
			new String[] { Long.class.getName() },
			CreditAppPrincipalModelImpl.CREDITAPPID_COLUMN_BITMASK |
			CreditAppPrincipalModelImpl.PRINCIPALFIRSTNAME_COLUMN_BITMASK |
			CreditAppPrincipalModelImpl.SEQUENCENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDITAPPID = new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreditAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit app principals where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findByCreditAppId(long creditAppId)
		throws SystemException {
		return findByCreditAppId(creditAppId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app principals where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @return the range of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findByCreditAppId(long creditAppId,
		int start, int end) throws SystemException {
		return findByCreditAppId(creditAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app principals where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findByCreditAppId(long creditAppId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<CreditAppPrincipal> list = (List<CreditAppPrincipal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditAppPrincipal creditAppPrincipal : list) {
				if ((creditAppId != creditAppPrincipal.getCreditAppId())) {
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

			query.append(_SQL_SELECT_CREDITAPPPRINCIPAL_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppPrincipalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppId);

				if (!pagination) {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppPrincipal>(list);
				}
				else {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
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
	 * Returns the first credit app principal in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = fetchByCreditAppId_First(creditAppId,
				orderByComparator);

		if (creditAppPrincipal != null) {
			return creditAppPrincipal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppPrincipalException(msg.toString());
	}

	/**
	 * Returns the first credit app principal in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditAppPrincipal> list = findByCreditAppId(creditAppId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app principal in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = fetchByCreditAppId_Last(creditAppId,
				orderByComparator);

		if (creditAppPrincipal != null) {
			return creditAppPrincipal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppPrincipalException(msg.toString());
	}

	/**
	 * Returns the last credit app principal in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreditAppId(creditAppId);

		if (count == 0) {
			return null;
		}

		List<CreditAppPrincipal> list = findByCreditAppId(creditAppId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit app principals before and after the current credit app principal in the ordered set where creditAppId = &#63;.
	 *
	 * @param principalId the primary key of the current credit app principal
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal[] findByCreditAppId_PrevAndNext(
		long principalId, long creditAppId, OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = findByPrimaryKey(principalId);

		Session session = null;

		try {
			session = openSession();

			CreditAppPrincipal[] array = new CreditAppPrincipalImpl[3];

			array[0] = getByCreditAppId_PrevAndNext(session,
					creditAppPrincipal, creditAppId, orderByComparator, true);

			array[1] = creditAppPrincipal;

			array[2] = getByCreditAppId_PrevAndNext(session,
					creditAppPrincipal, creditAppId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditAppPrincipal getByCreditAppId_PrevAndNext(Session session,
		CreditAppPrincipal creditAppPrincipal, long creditAppId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPPPRINCIPAL_WHERE);

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
			query.append(CreditAppPrincipalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creditAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditAppPrincipal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditAppPrincipal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit app principals where creditAppId = &#63; from the database.
	 *
	 * @param creditAppId the credit app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreditAppId(long creditAppId) throws SystemException {
		for (CreditAppPrincipal creditAppPrincipal : findByCreditAppId(
				creditAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditAppPrincipal);
		}
	}

	/**
	 * Returns the number of credit app principals where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the number of matching credit app principals
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

			query.append(_SQL_COUNT_CREDITAPPPRINCIPAL_WHERE);

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

	private static final String _FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2 = "creditAppPrincipal.creditAppId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCENUMBER =
		new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySequenceNumber",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER =
		new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED,
			CreditAppPrincipalImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequenceNumber",
			new String[] { Long.class.getName() },
			CreditAppPrincipalModelImpl.SEQUENCENUMBER_COLUMN_BITMASK |
			CreditAppPrincipalModelImpl.PRINCIPALFIRSTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCENUMBER = new FinderPath(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequenceNumber",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit app principals where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findBySequenceNumber(long sequenceNumber)
		throws SystemException {
		return findBySequenceNumber(sequenceNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app principals where sequenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sequenceNumber the sequence number
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @return the range of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findBySequenceNumber(long sequenceNumber,
		int start, int end) throws SystemException {
		return findBySequenceNumber(sequenceNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app principals where sequenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sequenceNumber the sequence number
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findBySequenceNumber(long sequenceNumber,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER;
			finderArgs = new Object[] { sequenceNumber };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCENUMBER;
			finderArgs = new Object[] {
					sequenceNumber,
					
					start, end, orderByComparator
				};
		}

		List<CreditAppPrincipal> list = (List<CreditAppPrincipal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditAppPrincipal creditAppPrincipal : list) {
				if ((sequenceNumber != creditAppPrincipal.getSequenceNumber())) {
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

			query.append(_SQL_SELECT_CREDITAPPPRINCIPAL_WHERE);

			query.append(_FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppPrincipalModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sequenceNumber);

				if (!pagination) {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppPrincipal>(list);
				}
				else {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
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
	 * Returns the first credit app principal in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findBySequenceNumber_First(long sequenceNumber,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = fetchBySequenceNumber_First(sequenceNumber,
				orderByComparator);

		if (creditAppPrincipal != null) {
			return creditAppPrincipal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sequenceNumber=");
		msg.append(sequenceNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppPrincipalException(msg.toString());
	}

	/**
	 * Returns the first credit app principal in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchBySequenceNumber_First(long sequenceNumber,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditAppPrincipal> list = findBySequenceNumber(sequenceNumber, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app principal in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findBySequenceNumber_Last(long sequenceNumber,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = fetchBySequenceNumber_Last(sequenceNumber,
				orderByComparator);

		if (creditAppPrincipal != null) {
			return creditAppPrincipal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sequenceNumber=");
		msg.append(sequenceNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppPrincipalException(msg.toString());
	}

	/**
	 * Returns the last credit app principal in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchBySequenceNumber_Last(long sequenceNumber,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySequenceNumber(sequenceNumber);

		if (count == 0) {
			return null;
		}

		List<CreditAppPrincipal> list = findBySequenceNumber(sequenceNumber,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit app principals before and after the current credit app principal in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param principalId the primary key of the current credit app principal
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal[] findBySequenceNumber_PrevAndNext(
		long principalId, long sequenceNumber,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = findByPrimaryKey(principalId);

		Session session = null;

		try {
			session = openSession();

			CreditAppPrincipal[] array = new CreditAppPrincipalImpl[3];

			array[0] = getBySequenceNumber_PrevAndNext(session,
					creditAppPrincipal, sequenceNumber, orderByComparator, true);

			array[1] = creditAppPrincipal;

			array[2] = getBySequenceNumber_PrevAndNext(session,
					creditAppPrincipal, sequenceNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditAppPrincipal getBySequenceNumber_PrevAndNext(
		Session session, CreditAppPrincipal creditAppPrincipal,
		long sequenceNumber, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPPPRINCIPAL_WHERE);

		query.append(_FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2);

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
			query.append(CreditAppPrincipalModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sequenceNumber);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditAppPrincipal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditAppPrincipal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit app principals where sequenceNumber = &#63; from the database.
	 *
	 * @param sequenceNumber the sequence number
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySequenceNumber(long sequenceNumber)
		throws SystemException {
		for (CreditAppPrincipal creditAppPrincipal : findBySequenceNumber(
				sequenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditAppPrincipal);
		}
	}

	/**
	 * Returns the number of credit app principals where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the number of matching credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBySequenceNumber(long sequenceNumber)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCENUMBER;

		Object[] finderArgs = new Object[] { sequenceNumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREDITAPPPRINCIPAL_WHERE);

			query.append(_FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sequenceNumber);

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

	private static final String _FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2 = "creditAppPrincipal.sequenceNumber = ?";

	public CreditAppPrincipalPersistenceImpl() {
		setModelClass(CreditAppPrincipal.class);
	}

	/**
	 * Caches the credit app principal in the entity cache if it is enabled.
	 *
	 * @param creditAppPrincipal the credit app principal
	 */
	@Override
	public void cacheResult(CreditAppPrincipal creditAppPrincipal) {
		EntityCacheUtil.putResult(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalImpl.class, creditAppPrincipal.getPrimaryKey(),
			creditAppPrincipal);

		creditAppPrincipal.resetOriginalValues();
	}

	/**
	 * Caches the credit app principals in the entity cache if it is enabled.
	 *
	 * @param creditAppPrincipals the credit app principals
	 */
	@Override
	public void cacheResult(List<CreditAppPrincipal> creditAppPrincipals) {
		for (CreditAppPrincipal creditAppPrincipal : creditAppPrincipals) {
			if (EntityCacheUtil.getResult(
						CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppPrincipalImpl.class,
						creditAppPrincipal.getPrimaryKey()) == null) {
				cacheResult(creditAppPrincipal);
			}
			else {
				creditAppPrincipal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all credit app principals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CreditAppPrincipalImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CreditAppPrincipalImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit app principal.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditAppPrincipal creditAppPrincipal) {
		EntityCacheUtil.removeResult(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalImpl.class, creditAppPrincipal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CreditAppPrincipal> creditAppPrincipals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CreditAppPrincipal creditAppPrincipal : creditAppPrincipals) {
			EntityCacheUtil.removeResult(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppPrincipalImpl.class, creditAppPrincipal.getPrimaryKey());
		}
	}

	/**
	 * Creates a new credit app principal with the primary key. Does not add the credit app principal to the database.
	 *
	 * @param principalId the primary key for the new credit app principal
	 * @return the new credit app principal
	 */
	@Override
	public CreditAppPrincipal create(long principalId) {
		CreditAppPrincipal creditAppPrincipal = new CreditAppPrincipalImpl();

		creditAppPrincipal.setNew(true);
		creditAppPrincipal.setPrimaryKey(principalId);

		return creditAppPrincipal;
	}

	/**
	 * Removes the credit app principal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param principalId the primary key of the credit app principal
	 * @return the credit app principal that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal remove(long principalId)
		throws NoSuchCreditAppPrincipalException, SystemException {
		return remove((Serializable)principalId);
	}

	/**
	 * Removes the credit app principal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit app principal
	 * @return the credit app principal that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal remove(Serializable primaryKey)
		throws NoSuchCreditAppPrincipalException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CreditAppPrincipal creditAppPrincipal = (CreditAppPrincipal)session.get(CreditAppPrincipalImpl.class,
					primaryKey);

			if (creditAppPrincipal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditAppPrincipalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creditAppPrincipal);
		}
		catch (NoSuchCreditAppPrincipalException nsee) {
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
	protected CreditAppPrincipal removeImpl(
		CreditAppPrincipal creditAppPrincipal) throws SystemException {
		creditAppPrincipal = toUnwrappedModel(creditAppPrincipal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditAppPrincipal)) {
				creditAppPrincipal = (CreditAppPrincipal)session.get(CreditAppPrincipalImpl.class,
						creditAppPrincipal.getPrimaryKeyObj());
			}

			if (creditAppPrincipal != null) {
				session.delete(creditAppPrincipal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creditAppPrincipal != null) {
			clearCache(creditAppPrincipal);
		}

		return creditAppPrincipal;
	}

	@Override
	public CreditAppPrincipal updateImpl(
		com.tamarack.creekridge.model.CreditAppPrincipal creditAppPrincipal)
		throws SystemException {
		creditAppPrincipal = toUnwrappedModel(creditAppPrincipal);

		boolean isNew = creditAppPrincipal.isNew();

		CreditAppPrincipalModelImpl creditAppPrincipalModelImpl = (CreditAppPrincipalModelImpl)creditAppPrincipal;

		Session session = null;

		try {
			session = openSession();

			if (creditAppPrincipal.isNew()) {
				session.save(creditAppPrincipal);

				creditAppPrincipal.setNew(false);
			}
			else {
				session.merge(creditAppPrincipal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CreditAppPrincipalModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((creditAppPrincipalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINCIPALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppPrincipalModelImpl.getOriginalPrincipalId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRINCIPALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINCIPALID,
					args);

				args = new Object[] { creditAppPrincipalModelImpl.getPrincipalId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PRINCIPALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRINCIPALID,
					args);
			}

			if ((creditAppPrincipalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppPrincipalModelImpl.getOriginalCreditAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);

				args = new Object[] { creditAppPrincipalModelImpl.getCreditAppId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);
			}

			if ((creditAppPrincipalModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppPrincipalModelImpl.getOriginalSequenceNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER,
					args);

				args = new Object[] {
						creditAppPrincipalModelImpl.getSequenceNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER,
					args);
			}
		}

		EntityCacheUtil.putResult(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppPrincipalImpl.class, creditAppPrincipal.getPrimaryKey(),
			creditAppPrincipal);

		return creditAppPrincipal;
	}

	protected CreditAppPrincipal toUnwrappedModel(
		CreditAppPrincipal creditAppPrincipal) {
		if (creditAppPrincipal instanceof CreditAppPrincipalImpl) {
			return creditAppPrincipal;
		}

		CreditAppPrincipalImpl creditAppPrincipalImpl = new CreditAppPrincipalImpl();

		creditAppPrincipalImpl.setNew(creditAppPrincipal.isNew());
		creditAppPrincipalImpl.setPrimaryKey(creditAppPrincipal.getPrimaryKey());

		creditAppPrincipalImpl.setPrincipalId(creditAppPrincipal.getPrincipalId());
		creditAppPrincipalImpl.setCompanyId(creditAppPrincipal.getCompanyId());
		creditAppPrincipalImpl.setUserId(creditAppPrincipal.getUserId());
		creditAppPrincipalImpl.setUserName(creditAppPrincipal.getUserName());
		creditAppPrincipalImpl.setCreateDate(creditAppPrincipal.getCreateDate());
		creditAppPrincipalImpl.setModifiedDate(creditAppPrincipal.getModifiedDate());
		creditAppPrincipalImpl.setCreditAppId(creditAppPrincipal.getCreditAppId());
		creditAppPrincipalImpl.setSequenceNumber(creditAppPrincipal.getSequenceNumber());
		creditAppPrincipalImpl.setPrincipalFirstName(creditAppPrincipal.getPrincipalFirstName());
		creditAppPrincipalImpl.setPrincipalMiddleName(creditAppPrincipal.getPrincipalMiddleName());
		creditAppPrincipalImpl.setPrincipalLastName(creditAppPrincipal.getPrincipalLastName());
		creditAppPrincipalImpl.setPrincipalSSN(creditAppPrincipal.getPrincipalSSN());
		creditAppPrincipalImpl.setPrincipalHomePhoneNumber(creditAppPrincipal.getPrincipalHomePhoneNumber());
		creditAppPrincipalImpl.setPrincipalAddress1(creditAppPrincipal.getPrincipalAddress1());
		creditAppPrincipalImpl.setPrincipalAddress2(creditAppPrincipal.getPrincipalAddress2());
		creditAppPrincipalImpl.setPrincipalCity(creditAppPrincipal.getPrincipalCity());
		creditAppPrincipalImpl.setPrincipalState(creditAppPrincipal.getPrincipalState());
		creditAppPrincipalImpl.setPrincipalZip(creditAppPrincipal.getPrincipalZip());
		creditAppPrincipalImpl.setPrincipalEmail(creditAppPrincipal.getPrincipalEmail());

		return creditAppPrincipalImpl;
	}

	/**
	 * Returns the credit app principal with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app principal
	 * @return the credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditAppPrincipalException, SystemException {
		CreditAppPrincipal creditAppPrincipal = fetchByPrimaryKey(primaryKey);

		if (creditAppPrincipal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditAppPrincipalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creditAppPrincipal;
	}

	/**
	 * Returns the credit app principal with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppPrincipalException} if it could not be found.
	 *
	 * @param principalId the primary key of the credit app principal
	 * @return the credit app principal
	 * @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal findByPrimaryKey(long principalId)
		throws NoSuchCreditAppPrincipalException, SystemException {
		return findByPrimaryKey((Serializable)principalId);
	}

	/**
	 * Returns the credit app principal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app principal
	 * @return the credit app principal, or <code>null</code> if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CreditAppPrincipal creditAppPrincipal = (CreditAppPrincipal)EntityCacheUtil.getResult(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppPrincipalImpl.class, primaryKey);

		if (creditAppPrincipal == _nullCreditAppPrincipal) {
			return null;
		}

		if (creditAppPrincipal == null) {
			Session session = null;

			try {
				session = openSession();

				creditAppPrincipal = (CreditAppPrincipal)session.get(CreditAppPrincipalImpl.class,
						primaryKey);

				if (creditAppPrincipal != null) {
					cacheResult(creditAppPrincipal);
				}
				else {
					EntityCacheUtil.putResult(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppPrincipalImpl.class, primaryKey,
						_nullCreditAppPrincipal);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CreditAppPrincipalModelImpl.ENTITY_CACHE_ENABLED,
					CreditAppPrincipalImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creditAppPrincipal;
	}

	/**
	 * Returns the credit app principal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param principalId the primary key of the credit app principal
	 * @return the credit app principal, or <code>null</code> if a credit app principal with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppPrincipal fetchByPrimaryKey(long principalId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)principalId);
	}

	/**
	 * Returns all the credit app principals.
	 *
	 * @return the credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app principals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @return the range of credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app principals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app principals
	 * @param end the upper bound of the range of credit app principals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit app principals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppPrincipal> findAll(int start, int end,
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

		List<CreditAppPrincipal> list = (List<CreditAppPrincipal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CREDITAPPPRINCIPAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITAPPPRINCIPAL;

				if (pagination) {
					sql = sql.concat(CreditAppPrincipalModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppPrincipal>(list);
				}
				else {
					list = (List<CreditAppPrincipal>)QueryUtil.list(q,
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
	 * Removes all the credit app principals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CreditAppPrincipal creditAppPrincipal : findAll()) {
			remove(creditAppPrincipal);
		}
	}

	/**
	 * Returns the number of credit app principals.
	 *
	 * @return the number of credit app principals
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

				Query q = session.createQuery(_SQL_COUNT_CREDITAPPPRINCIPAL);

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
	 * Initializes the credit app principal persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.CreditAppPrincipal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CreditAppPrincipal>> listenersList = new ArrayList<ModelListener<CreditAppPrincipal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CreditAppPrincipal>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CreditAppPrincipalImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CREDITAPPPRINCIPAL = "SELECT creditAppPrincipal FROM CreditAppPrincipal creditAppPrincipal";
	private static final String _SQL_SELECT_CREDITAPPPRINCIPAL_WHERE = "SELECT creditAppPrincipal FROM CreditAppPrincipal creditAppPrincipal WHERE ";
	private static final String _SQL_COUNT_CREDITAPPPRINCIPAL = "SELECT COUNT(creditAppPrincipal) FROM CreditAppPrincipal creditAppPrincipal";
	private static final String _SQL_COUNT_CREDITAPPPRINCIPAL_WHERE = "SELECT COUNT(creditAppPrincipal) FROM CreditAppPrincipal creditAppPrincipal WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creditAppPrincipal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CreditAppPrincipal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CreditAppPrincipal exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CreditAppPrincipalPersistenceImpl.class);
	private static CreditAppPrincipal _nullCreditAppPrincipal = new CreditAppPrincipalImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CreditAppPrincipal> toCacheModel() {
				return _nullCreditAppPrincipalCacheModel;
			}
		};

	private static CacheModel<CreditAppPrincipal> _nullCreditAppPrincipalCacheModel =
		new CacheModel<CreditAppPrincipal>() {
			@Override
			public CreditAppPrincipal toEntityModel() {
				return _nullCreditAppPrincipal;
			}
		};
}