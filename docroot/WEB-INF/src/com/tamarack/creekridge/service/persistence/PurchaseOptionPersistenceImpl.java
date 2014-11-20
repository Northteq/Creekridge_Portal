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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.tamarack.creekridge.NoSuchPurchaseOptionException;
import com.tamarack.creekridge.model.PurchaseOption;
import com.tamarack.creekridge.model.impl.PurchaseOptionImpl;
import com.tamarack.creekridge.model.impl.PurchaseOptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the purchase option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see PurchaseOptionPersistence
 * @see PurchaseOptionUtil
 * @generated
 */
public class PurchaseOptionPersistenceImpl extends BasePersistenceImpl<PurchaseOption>
	implements PurchaseOptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PurchaseOptionUtil} to access the purchase option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PurchaseOptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME = new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOptionImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPurchaseOptionName",
			new String[] { String.class.getName() },
			PurchaseOptionModelImpl.PURCHASEOPTIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PURCHASEOPTIONNAME = new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPurchaseOptionName", new String[] { String.class.getName() });

	/**
	 * Returns the purchase option where purchaseOptionName = &#63; or throws a {@link com.tamarack.creekridge.NoSuchPurchaseOptionException} if it could not be found.
	 *
	 * @param purchaseOptionName the purchase option name
	 * @return the matching purchase option
	 * @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption findByPurchaseOptionName(String purchaseOptionName)
		throws NoSuchPurchaseOptionException, SystemException {
		PurchaseOption purchaseOption = fetchByPurchaseOptionName(purchaseOptionName);

		if (purchaseOption == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("purchaseOptionName=");
			msg.append(purchaseOptionName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPurchaseOptionException(msg.toString());
		}

		return purchaseOption;
	}

	/**
	 * Returns the purchase option where purchaseOptionName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param purchaseOptionName the purchase option name
	 * @return the matching purchase option, or <code>null</code> if a matching purchase option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption fetchByPurchaseOptionName(String purchaseOptionName)
		throws SystemException {
		return fetchByPurchaseOptionName(purchaseOptionName, true);
	}

	/**
	 * Returns the purchase option where purchaseOptionName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param purchaseOptionName the purchase option name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching purchase option, or <code>null</code> if a matching purchase option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption fetchByPurchaseOptionName(String purchaseOptionName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { purchaseOptionName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
					finderArgs, this);
		}

		if (result instanceof PurchaseOption) {
			PurchaseOption purchaseOption = (PurchaseOption)result;

			if (!Validator.equals(purchaseOptionName,
						purchaseOption.getPurchaseOptionName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PURCHASEOPTION_WHERE);

			boolean bindPurchaseOptionName = false;

			if (purchaseOptionName == null) {
				query.append(_FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_1);
			}
			else if (purchaseOptionName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_3);
			}
			else {
				bindPurchaseOptionName = true;

				query.append(_FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPurchaseOptionName) {
					qPos.add(purchaseOptionName);
				}

				List<PurchaseOption> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
						finderArgs, list);
				}
				else {
					PurchaseOption purchaseOption = list.get(0);

					result = purchaseOption;

					cacheResult(purchaseOption);

					if ((purchaseOption.getPurchaseOptionName() == null) ||
							!purchaseOption.getPurchaseOptionName()
											   .equals(purchaseOptionName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
							finderArgs, purchaseOption);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
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
			return (PurchaseOption)result;
		}
	}

	/**
	 * Removes the purchase option where purchaseOptionName = &#63; from the database.
	 *
	 * @param purchaseOptionName the purchase option name
	 * @return the purchase option that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption removeByPurchaseOptionName(String purchaseOptionName)
		throws NoSuchPurchaseOptionException, SystemException {
		PurchaseOption purchaseOption = findByPurchaseOptionName(purchaseOptionName);

		return remove(purchaseOption);
	}

	/**
	 * Returns the number of purchase options where purchaseOptionName = &#63;.
	 *
	 * @param purchaseOptionName the purchase option name
	 * @return the number of matching purchase options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPurchaseOptionName(String purchaseOptionName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PURCHASEOPTIONNAME;

		Object[] finderArgs = new Object[] { purchaseOptionName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PURCHASEOPTION_WHERE);

			boolean bindPurchaseOptionName = false;

			if (purchaseOptionName == null) {
				query.append(_FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_1);
			}
			else if (purchaseOptionName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_3);
			}
			else {
				bindPurchaseOptionName = true;

				query.append(_FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPurchaseOptionName) {
					qPos.add(purchaseOptionName);
				}

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

	private static final String _FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_1 =
		"purchaseOption.purchaseOptionName IS NULL";
	private static final String _FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_2 =
		"purchaseOption.purchaseOptionName = ?";
	private static final String _FINDER_COLUMN_PURCHASEOPTIONNAME_PURCHASEOPTIONNAME_3 =
		"(purchaseOption.purchaseOptionName IS NULL OR purchaseOption.purchaseOptionName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PURCHASEOPTIONID =
		new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOptionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPurchaseOptionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PURCHASEOPTIONID =
		new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED,
			PurchaseOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPurchaseOptionId", new String[] { Long.class.getName() },
			PurchaseOptionModelImpl.PURCHASEOPTIONID_COLUMN_BITMASK |
			PurchaseOptionModelImpl.SEQUENCENUMBER_COLUMN_BITMASK |
			PurchaseOptionModelImpl.PURCHASEOPTIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PURCHASEOPTIONID = new FinderPath(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPurchaseOptionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the purchase options where purchaseOptionId = &#63;.
	 *
	 * @param purchaseOptionId the purchase option ID
	 * @return the matching purchase options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PurchaseOption> findByPurchaseOptionId(long purchaseOptionId)
		throws SystemException {
		return findByPurchaseOptionId(purchaseOptionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<PurchaseOption> findByPurchaseOptionId(long purchaseOptionId,
		int start, int end) throws SystemException {
		return findByPurchaseOptionId(purchaseOptionId, start, end, null);
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
	@Override
	public List<PurchaseOption> findByPurchaseOptionId(long purchaseOptionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PURCHASEOPTIONID;
			finderArgs = new Object[] { purchaseOptionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PURCHASEOPTIONID;
			finderArgs = new Object[] {
					purchaseOptionId,
					
					start, end, orderByComparator
				};
		}

		List<PurchaseOption> list = (List<PurchaseOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PurchaseOption purchaseOption : list) {
				if ((purchaseOptionId != purchaseOption.getPurchaseOptionId())) {
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

			query.append(_SQL_SELECT_PURCHASEOPTION_WHERE);

			query.append(_FINDER_COLUMN_PURCHASEOPTIONID_PURCHASEOPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PurchaseOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(purchaseOptionId);

				if (!pagination) {
					list = (List<PurchaseOption>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PurchaseOption>(list);
				}
				else {
					list = (List<PurchaseOption>)QueryUtil.list(q,
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
	 * Returns the first purchase option in the ordered set where purchaseOptionId = &#63;.
	 *
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase option
	 * @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a matching purchase option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption findByPurchaseOptionId_First(long purchaseOptionId,
		OrderByComparator orderByComparator)
		throws NoSuchPurchaseOptionException, SystemException {
		PurchaseOption purchaseOption = fetchByPurchaseOptionId_First(purchaseOptionId,
				orderByComparator);

		if (purchaseOption != null) {
			return purchaseOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("purchaseOptionId=");
		msg.append(purchaseOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPurchaseOptionException(msg.toString());
	}

	/**
	 * Returns the first purchase option in the ordered set where purchaseOptionId = &#63;.
	 *
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase option, or <code>null</code> if a matching purchase option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption fetchByPurchaseOptionId_First(long purchaseOptionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PurchaseOption> list = findByPurchaseOptionId(purchaseOptionId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PurchaseOption findByPurchaseOptionId_Last(long purchaseOptionId,
		OrderByComparator orderByComparator)
		throws NoSuchPurchaseOptionException, SystemException {
		PurchaseOption purchaseOption = fetchByPurchaseOptionId_Last(purchaseOptionId,
				orderByComparator);

		if (purchaseOption != null) {
			return purchaseOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("purchaseOptionId=");
		msg.append(purchaseOptionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPurchaseOptionException(msg.toString());
	}

	/**
	 * Returns the last purchase option in the ordered set where purchaseOptionId = &#63;.
	 *
	 * @param purchaseOptionId the purchase option ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase option, or <code>null</code> if a matching purchase option could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption fetchByPurchaseOptionId_Last(long purchaseOptionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPurchaseOptionId(purchaseOptionId);

		if (count == 0) {
			return null;
		}

		List<PurchaseOption> list = findByPurchaseOptionId(purchaseOptionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the purchase options where purchaseOptionId = &#63; from the database.
	 *
	 * @param purchaseOptionId the purchase option ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPurchaseOptionId(long purchaseOptionId)
		throws SystemException {
		for (PurchaseOption purchaseOption : findByPurchaseOptionId(
				purchaseOptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(purchaseOption);
		}
	}

	/**
	 * Returns the number of purchase options where purchaseOptionId = &#63;.
	 *
	 * @param purchaseOptionId the purchase option ID
	 * @return the number of matching purchase options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPurchaseOptionId(long purchaseOptionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PURCHASEOPTIONID;

		Object[] finderArgs = new Object[] { purchaseOptionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PURCHASEOPTION_WHERE);

			query.append(_FINDER_COLUMN_PURCHASEOPTIONID_PURCHASEOPTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_PURCHASEOPTIONID_PURCHASEOPTIONID_2 =
		"purchaseOption.purchaseOptionId = ?";

	public PurchaseOptionPersistenceImpl() {
		setModelClass(PurchaseOption.class);
	}

	/**
	 * Caches the purchase option in the entity cache if it is enabled.
	 *
	 * @param purchaseOption the purchase option
	 */
	@Override
	public void cacheResult(PurchaseOption purchaseOption) {
		EntityCacheUtil.putResult(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionImpl.class, purchaseOption.getPrimaryKey(),
			purchaseOption);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
			new Object[] { purchaseOption.getPurchaseOptionName() },
			purchaseOption);

		purchaseOption.resetOriginalValues();
	}

	/**
	 * Caches the purchase options in the entity cache if it is enabled.
	 *
	 * @param purchaseOptions the purchase options
	 */
	@Override
	public void cacheResult(List<PurchaseOption> purchaseOptions) {
		for (PurchaseOption purchaseOption : purchaseOptions) {
			if (EntityCacheUtil.getResult(
						PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseOptionImpl.class, purchaseOption.getPrimaryKey()) == null) {
				cacheResult(purchaseOption);
			}
			else {
				purchaseOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all purchase options.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PurchaseOptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PurchaseOptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the purchase option.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PurchaseOption purchaseOption) {
		EntityCacheUtil.removeResult(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionImpl.class, purchaseOption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(purchaseOption);
	}

	@Override
	public void clearCache(List<PurchaseOption> purchaseOptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PurchaseOption purchaseOption : purchaseOptions) {
			EntityCacheUtil.removeResult(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseOptionImpl.class, purchaseOption.getPrimaryKey());

			clearUniqueFindersCache(purchaseOption);
		}
	}

	protected void cacheUniqueFindersCache(PurchaseOption purchaseOption) {
		if (purchaseOption.isNew()) {
			Object[] args = new Object[] { purchaseOption.getPurchaseOptionName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PURCHASEOPTIONNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
				args, purchaseOption);
		}
		else {
			PurchaseOptionModelImpl purchaseOptionModelImpl = (PurchaseOptionModelImpl)purchaseOption;

			if ((purchaseOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						purchaseOption.getPurchaseOptionName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PURCHASEOPTIONNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
					args, purchaseOption);
			}
		}
	}

	protected void clearUniqueFindersCache(PurchaseOption purchaseOption) {
		PurchaseOptionModelImpl purchaseOptionModelImpl = (PurchaseOptionModelImpl)purchaseOption;

		Object[] args = new Object[] { purchaseOption.getPurchaseOptionName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PURCHASEOPTIONNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
			args);

		if ((purchaseOptionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					purchaseOptionModelImpl.getOriginalPurchaseOptionName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PURCHASEOPTIONNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PURCHASEOPTIONNAME,
				args);
		}
	}

	/**
	 * Creates a new purchase option with the primary key. Does not add the purchase option to the database.
	 *
	 * @param purchaseOptionId the primary key for the new purchase option
	 * @return the new purchase option
	 */
	@Override
	public PurchaseOption create(long purchaseOptionId) {
		PurchaseOption purchaseOption = new PurchaseOptionImpl();

		purchaseOption.setNew(true);
		purchaseOption.setPrimaryKey(purchaseOptionId);

		return purchaseOption;
	}

	/**
	 * Removes the purchase option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseOptionId the primary key of the purchase option
	 * @return the purchase option that was removed
	 * @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption remove(long purchaseOptionId)
		throws NoSuchPurchaseOptionException, SystemException {
		return remove((Serializable)purchaseOptionId);
	}

	/**
	 * Removes the purchase option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase option
	 * @return the purchase option that was removed
	 * @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption remove(Serializable primaryKey)
		throws NoSuchPurchaseOptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PurchaseOption purchaseOption = (PurchaseOption)session.get(PurchaseOptionImpl.class,
					primaryKey);

			if (purchaseOption == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(purchaseOption);
		}
		catch (NoSuchPurchaseOptionException nsee) {
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
	protected PurchaseOption removeImpl(PurchaseOption purchaseOption)
		throws SystemException {
		purchaseOption = toUnwrappedModel(purchaseOption);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(purchaseOption)) {
				purchaseOption = (PurchaseOption)session.get(PurchaseOptionImpl.class,
						purchaseOption.getPrimaryKeyObj());
			}

			if (purchaseOption != null) {
				session.delete(purchaseOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (purchaseOption != null) {
			clearCache(purchaseOption);
		}

		return purchaseOption;
	}

	@Override
	public PurchaseOption updateImpl(
		com.tamarack.creekridge.model.PurchaseOption purchaseOption)
		throws SystemException {
		purchaseOption = toUnwrappedModel(purchaseOption);

		boolean isNew = purchaseOption.isNew();

		PurchaseOptionModelImpl purchaseOptionModelImpl = (PurchaseOptionModelImpl)purchaseOption;

		Session session = null;

		try {
			session = openSession();

			if (purchaseOption.isNew()) {
				session.save(purchaseOption);

				purchaseOption.setNew(false);
			}
			else {
				session.merge(purchaseOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PurchaseOptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((purchaseOptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PURCHASEOPTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						purchaseOptionModelImpl.getOriginalPurchaseOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PURCHASEOPTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PURCHASEOPTIONID,
					args);

				args = new Object[] {
						purchaseOptionModelImpl.getPurchaseOptionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PURCHASEOPTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PURCHASEOPTIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
			PurchaseOptionImpl.class, purchaseOption.getPrimaryKey(),
			purchaseOption);

		clearUniqueFindersCache(purchaseOption);
		cacheUniqueFindersCache(purchaseOption);

		return purchaseOption;
	}

	protected PurchaseOption toUnwrappedModel(PurchaseOption purchaseOption) {
		if (purchaseOption instanceof PurchaseOptionImpl) {
			return purchaseOption;
		}

		PurchaseOptionImpl purchaseOptionImpl = new PurchaseOptionImpl();

		purchaseOptionImpl.setNew(purchaseOption.isNew());
		purchaseOptionImpl.setPrimaryKey(purchaseOption.getPrimaryKey());

		purchaseOptionImpl.setPurchaseOptionId(purchaseOption.getPurchaseOptionId());
		purchaseOptionImpl.setCompanyId(purchaseOption.getCompanyId());
		purchaseOptionImpl.setUserId(purchaseOption.getUserId());
		purchaseOptionImpl.setUserName(purchaseOption.getUserName());
		purchaseOptionImpl.setCreateDate(purchaseOption.getCreateDate());
		purchaseOptionImpl.setModifiedDate(purchaseOption.getModifiedDate());
		purchaseOptionImpl.setPurchaseOptionName(purchaseOption.getPurchaseOptionName());
		purchaseOptionImpl.setSequenceNumber(purchaseOption.getSequenceNumber());

		return purchaseOptionImpl;
	}

	/**
	 * Returns the purchase option with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase option
	 * @return the purchase option
	 * @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPurchaseOptionException, SystemException {
		PurchaseOption purchaseOption = fetchByPrimaryKey(primaryKey);

		if (purchaseOption == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPurchaseOptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return purchaseOption;
	}

	/**
	 * Returns the purchase option with the primary key or throws a {@link com.tamarack.creekridge.NoSuchPurchaseOptionException} if it could not be found.
	 *
	 * @param purchaseOptionId the primary key of the purchase option
	 * @return the purchase option
	 * @throws com.tamarack.creekridge.NoSuchPurchaseOptionException if a purchase option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption findByPrimaryKey(long purchaseOptionId)
		throws NoSuchPurchaseOptionException, SystemException {
		return findByPrimaryKey((Serializable)purchaseOptionId);
	}

	/**
	 * Returns the purchase option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase option
	 * @return the purchase option, or <code>null</code> if a purchase option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PurchaseOption purchaseOption = (PurchaseOption)EntityCacheUtil.getResult(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
				PurchaseOptionImpl.class, primaryKey);

		if (purchaseOption == _nullPurchaseOption) {
			return null;
		}

		if (purchaseOption == null) {
			Session session = null;

			try {
				session = openSession();

				purchaseOption = (PurchaseOption)session.get(PurchaseOptionImpl.class,
						primaryKey);

				if (purchaseOption != null) {
					cacheResult(purchaseOption);
				}
				else {
					EntityCacheUtil.putResult(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
						PurchaseOptionImpl.class, primaryKey,
						_nullPurchaseOption);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PurchaseOptionModelImpl.ENTITY_CACHE_ENABLED,
					PurchaseOptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return purchaseOption;
	}

	/**
	 * Returns the purchase option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseOptionId the primary key of the purchase option
	 * @return the purchase option, or <code>null</code> if a purchase option with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PurchaseOption fetchByPrimaryKey(long purchaseOptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)purchaseOptionId);
	}

	/**
	 * Returns all the purchase options.
	 *
	 * @return the purchase options
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PurchaseOption> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PurchaseOption> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<PurchaseOption> findAll(int start, int end,
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

		List<PurchaseOption> list = (List<PurchaseOption>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PURCHASEOPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASEOPTION;

				if (pagination) {
					sql = sql.concat(PurchaseOptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PurchaseOption>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PurchaseOption>(list);
				}
				else {
					list = (List<PurchaseOption>)QueryUtil.list(q,
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
	 * Removes all the purchase options from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PurchaseOption purchaseOption : findAll()) {
			remove(purchaseOption);
		}
	}

	/**
	 * Returns the number of purchase options.
	 *
	 * @return the number of purchase options
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

				Query q = session.createQuery(_SQL_COUNT_PURCHASEOPTION);

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
	 * Initializes the purchase option persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.PurchaseOption")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PurchaseOption>> listenersList = new ArrayList<ModelListener<PurchaseOption>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PurchaseOption>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PurchaseOptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PURCHASEOPTION = "SELECT purchaseOption FROM PurchaseOption purchaseOption";
	private static final String _SQL_SELECT_PURCHASEOPTION_WHERE = "SELECT purchaseOption FROM PurchaseOption purchaseOption WHERE ";
	private static final String _SQL_COUNT_PURCHASEOPTION = "SELECT COUNT(purchaseOption) FROM PurchaseOption purchaseOption";
	private static final String _SQL_COUNT_PURCHASEOPTION_WHERE = "SELECT COUNT(purchaseOption) FROM PurchaseOption purchaseOption WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "purchaseOption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PurchaseOption exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PurchaseOption exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PurchaseOptionPersistenceImpl.class);
	private static PurchaseOption _nullPurchaseOption = new PurchaseOptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PurchaseOption> toCacheModel() {
				return _nullPurchaseOptionCacheModel;
			}
		};

	private static CacheModel<PurchaseOption> _nullPurchaseOptionCacheModel = new CacheModel<PurchaseOption>() {
			@Override
			public PurchaseOption toEntityModel() {
				return _nullPurchaseOption;
			}
		};
}