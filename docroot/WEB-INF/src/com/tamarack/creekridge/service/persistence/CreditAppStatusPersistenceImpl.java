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

import com.tamarack.creekridge.NoSuchCreditAppStatusException;
import com.tamarack.creekridge.model.CreditAppStatus;
import com.tamarack.creekridge.model.impl.CreditAppStatusImpl;
import com.tamarack.creekridge.model.impl.CreditAppStatusModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the credit app status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppStatusPersistence
 * @see CreditAppStatusUtil
 * @generated
 */
public class CreditAppStatusPersistenceImpl extends BasePersistenceImpl<CreditAppStatus>
	implements CreditAppStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreditAppStatusUtil} to access the credit app status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreditAppStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusModelImpl.FINDER_CACHE_ENABLED,
			CreditAppStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusModelImpl.FINDER_CACHE_ENABLED,
			CreditAppStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME = new FinderPath(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusModelImpl.FINDER_CACHE_ENABLED,
			CreditAppStatusImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCreditAppStatusName",
			new String[] { String.class.getName() },
			CreditAppStatusModelImpl.CREDITAPPSTATUSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDITAPPSTATUSNAME = new FinderPath(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCreditAppStatusName",
			new String[] { String.class.getName() });

	/**
	 * Returns the credit app status where creditAppStatusName = &#63; or throws a {@link com.tamarack.creekridge.NoSuchCreditAppStatusException} if it could not be found.
	 *
	 * @param creditAppStatusName the credit app status name
	 * @return the matching credit app status
	 * @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a matching credit app status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus findByCreditAppStatusName(String creditAppStatusName)
		throws NoSuchCreditAppStatusException, SystemException {
		CreditAppStatus creditAppStatus = fetchByCreditAppStatusName(creditAppStatusName);

		if (creditAppStatus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("creditAppStatusName=");
			msg.append(creditAppStatusName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCreditAppStatusException(msg.toString());
		}

		return creditAppStatus;
	}

	/**
	 * Returns the credit app status where creditAppStatusName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param creditAppStatusName the credit app status name
	 * @return the matching credit app status, or <code>null</code> if a matching credit app status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus fetchByCreditAppStatusName(
		String creditAppStatusName) throws SystemException {
		return fetchByCreditAppStatusName(creditAppStatusName, true);
	}

	/**
	 * Returns the credit app status where creditAppStatusName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param creditAppStatusName the credit app status name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching credit app status, or <code>null</code> if a matching credit app status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus fetchByCreditAppStatusName(
		String creditAppStatusName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { creditAppStatusName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
					finderArgs, this);
		}

		if (result instanceof CreditAppStatus) {
			CreditAppStatus creditAppStatus = (CreditAppStatus)result;

			if (!Validator.equals(creditAppStatusName,
						creditAppStatus.getCreditAppStatusName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CREDITAPPSTATUS_WHERE);

			boolean bindCreditAppStatusName = false;

			if (creditAppStatusName == null) {
				query.append(_FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_1);
			}
			else if (creditAppStatusName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_3);
			}
			else {
				bindCreditAppStatusName = true;

				query.append(_FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreditAppStatusName) {
					qPos.add(creditAppStatusName);
				}

				List<CreditAppStatus> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
						finderArgs, list);
				}
				else {
					CreditAppStatus creditAppStatus = list.get(0);

					result = creditAppStatus;

					cacheResult(creditAppStatus);

					if ((creditAppStatus.getCreditAppStatusName() == null) ||
							!creditAppStatus.getCreditAppStatusName()
												.equals(creditAppStatusName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
							finderArgs, creditAppStatus);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
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
			return (CreditAppStatus)result;
		}
	}

	/**
	 * Removes the credit app status where creditAppStatusName = &#63; from the database.
	 *
	 * @param creditAppStatusName the credit app status name
	 * @return the credit app status that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus removeByCreditAppStatusName(
		String creditAppStatusName)
		throws NoSuchCreditAppStatusException, SystemException {
		CreditAppStatus creditAppStatus = findByCreditAppStatusName(creditAppStatusName);

		return remove(creditAppStatus);
	}

	/**
	 * Returns the number of credit app statuses where creditAppStatusName = &#63;.
	 *
	 * @param creditAppStatusName the credit app status name
	 * @return the number of matching credit app statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCreditAppStatusName(String creditAppStatusName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREDITAPPSTATUSNAME;

		Object[] finderArgs = new Object[] { creditAppStatusName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CREDITAPPSTATUS_WHERE);

			boolean bindCreditAppStatusName = false;

			if (creditAppStatusName == null) {
				query.append(_FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_1);
			}
			else if (creditAppStatusName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_3);
			}
			else {
				bindCreditAppStatusName = true;

				query.append(_FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreditAppStatusName) {
					qPos.add(creditAppStatusName);
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

	private static final String _FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_1 =
		"creditAppStatus.creditAppStatusName IS NULL";
	private static final String _FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_2 =
		"creditAppStatus.creditAppStatusName = ?";
	private static final String _FINDER_COLUMN_CREDITAPPSTATUSNAME_CREDITAPPSTATUSNAME_3 =
		"(creditAppStatus.creditAppStatusName IS NULL OR creditAppStatus.creditAppStatusName = '')";

	public CreditAppStatusPersistenceImpl() {
		setModelClass(CreditAppStatus.class);
	}

	/**
	 * Caches the credit app status in the entity cache if it is enabled.
	 *
	 * @param creditAppStatus the credit app status
	 */
	@Override
	public void cacheResult(CreditAppStatus creditAppStatus) {
		EntityCacheUtil.putResult(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusImpl.class, creditAppStatus.getPrimaryKey(),
			creditAppStatus);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
			new Object[] { creditAppStatus.getCreditAppStatusName() },
			creditAppStatus);

		creditAppStatus.resetOriginalValues();
	}

	/**
	 * Caches the credit app statuses in the entity cache if it is enabled.
	 *
	 * @param creditAppStatuses the credit app statuses
	 */
	@Override
	public void cacheResult(List<CreditAppStatus> creditAppStatuses) {
		for (CreditAppStatus creditAppStatus : creditAppStatuses) {
			if (EntityCacheUtil.getResult(
						CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppStatusImpl.class,
						creditAppStatus.getPrimaryKey()) == null) {
				cacheResult(creditAppStatus);
			}
			else {
				creditAppStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all credit app statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CreditAppStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CreditAppStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit app status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditAppStatus creditAppStatus) {
		EntityCacheUtil.removeResult(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusImpl.class, creditAppStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(creditAppStatus);
	}

	@Override
	public void clearCache(List<CreditAppStatus> creditAppStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CreditAppStatus creditAppStatus : creditAppStatuses) {
			EntityCacheUtil.removeResult(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppStatusImpl.class, creditAppStatus.getPrimaryKey());

			clearUniqueFindersCache(creditAppStatus);
		}
	}

	protected void cacheUniqueFindersCache(CreditAppStatus creditAppStatus) {
		if (creditAppStatus.isNew()) {
			Object[] args = new Object[] {
					creditAppStatus.getCreditAppStatusName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREDITAPPSTATUSNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
				args, creditAppStatus);
		}
		else {
			CreditAppStatusModelImpl creditAppStatusModelImpl = (CreditAppStatusModelImpl)creditAppStatus;

			if ((creditAppStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppStatus.getCreditAppStatusName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREDITAPPSTATUSNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
					args, creditAppStatus);
			}
		}
	}

	protected void clearUniqueFindersCache(CreditAppStatus creditAppStatus) {
		CreditAppStatusModelImpl creditAppStatusModelImpl = (CreditAppStatusModelImpl)creditAppStatus;

		Object[] args = new Object[] { creditAppStatus.getCreditAppStatusName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPSTATUSNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
			args);

		if ((creditAppStatusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					creditAppStatusModelImpl.getOriginalCreditAppStatusName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPSTATUSNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CREDITAPPSTATUSNAME,
				args);
		}
	}

	/**
	 * Creates a new credit app status with the primary key. Does not add the credit app status to the database.
	 *
	 * @param CreditAppStatusId the primary key for the new credit app status
	 * @return the new credit app status
	 */
	@Override
	public CreditAppStatus create(long CreditAppStatusId) {
		CreditAppStatus creditAppStatus = new CreditAppStatusImpl();

		creditAppStatus.setNew(true);
		creditAppStatus.setPrimaryKey(CreditAppStatusId);

		return creditAppStatus;
	}

	/**
	 * Removes the credit app status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CreditAppStatusId the primary key of the credit app status
	 * @return the credit app status that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus remove(long CreditAppStatusId)
		throws NoSuchCreditAppStatusException, SystemException {
		return remove((Serializable)CreditAppStatusId);
	}

	/**
	 * Removes the credit app status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit app status
	 * @return the credit app status that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus remove(Serializable primaryKey)
		throws NoSuchCreditAppStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CreditAppStatus creditAppStatus = (CreditAppStatus)session.get(CreditAppStatusImpl.class,
					primaryKey);

			if (creditAppStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditAppStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creditAppStatus);
		}
		catch (NoSuchCreditAppStatusException nsee) {
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
	protected CreditAppStatus removeImpl(CreditAppStatus creditAppStatus)
		throws SystemException {
		creditAppStatus = toUnwrappedModel(creditAppStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditAppStatus)) {
				creditAppStatus = (CreditAppStatus)session.get(CreditAppStatusImpl.class,
						creditAppStatus.getPrimaryKeyObj());
			}

			if (creditAppStatus != null) {
				session.delete(creditAppStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creditAppStatus != null) {
			clearCache(creditAppStatus);
		}

		return creditAppStatus;
	}

	@Override
	public CreditAppStatus updateImpl(
		com.tamarack.creekridge.model.CreditAppStatus creditAppStatus)
		throws SystemException {
		creditAppStatus = toUnwrappedModel(creditAppStatus);

		boolean isNew = creditAppStatus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (creditAppStatus.isNew()) {
				session.save(creditAppStatus);

				creditAppStatus.setNew(false);
			}
			else {
				session.merge(creditAppStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CreditAppStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppStatusImpl.class, creditAppStatus.getPrimaryKey(),
			creditAppStatus);

		clearUniqueFindersCache(creditAppStatus);
		cacheUniqueFindersCache(creditAppStatus);

		return creditAppStatus;
	}

	protected CreditAppStatus toUnwrappedModel(CreditAppStatus creditAppStatus) {
		if (creditAppStatus instanceof CreditAppStatusImpl) {
			return creditAppStatus;
		}

		CreditAppStatusImpl creditAppStatusImpl = new CreditAppStatusImpl();

		creditAppStatusImpl.setNew(creditAppStatus.isNew());
		creditAppStatusImpl.setPrimaryKey(creditAppStatus.getPrimaryKey());

		creditAppStatusImpl.setCreditAppStatusId(creditAppStatus.getCreditAppStatusId());
		creditAppStatusImpl.setCompanyId(creditAppStatus.getCompanyId());
		creditAppStatusImpl.setUserId(creditAppStatus.getUserId());
		creditAppStatusImpl.setUserName(creditAppStatus.getUserName());
		creditAppStatusImpl.setCreateDate(creditAppStatus.getCreateDate());
		creditAppStatusImpl.setModifiedDate(creditAppStatus.getModifiedDate());
		creditAppStatusImpl.setCreditAppStatusName(creditAppStatus.getCreditAppStatusName());

		return creditAppStatusImpl;
	}

	/**
	 * Returns the credit app status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app status
	 * @return the credit app status
	 * @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditAppStatusException, SystemException {
		CreditAppStatus creditAppStatus = fetchByPrimaryKey(primaryKey);

		if (creditAppStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditAppStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creditAppStatus;
	}

	/**
	 * Returns the credit app status with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppStatusException} if it could not be found.
	 *
	 * @param CreditAppStatusId the primary key of the credit app status
	 * @return the credit app status
	 * @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus findByPrimaryKey(long CreditAppStatusId)
		throws NoSuchCreditAppStatusException, SystemException {
		return findByPrimaryKey((Serializable)CreditAppStatusId);
	}

	/**
	 * Returns the credit app status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app status
	 * @return the credit app status, or <code>null</code> if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CreditAppStatus creditAppStatus = (CreditAppStatus)EntityCacheUtil.getResult(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppStatusImpl.class, primaryKey);

		if (creditAppStatus == _nullCreditAppStatus) {
			return null;
		}

		if (creditAppStatus == null) {
			Session session = null;

			try {
				session = openSession();

				creditAppStatus = (CreditAppStatus)session.get(CreditAppStatusImpl.class,
						primaryKey);

				if (creditAppStatus != null) {
					cacheResult(creditAppStatus);
				}
				else {
					EntityCacheUtil.putResult(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppStatusImpl.class, primaryKey,
						_nullCreditAppStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CreditAppStatusModelImpl.ENTITY_CACHE_ENABLED,
					CreditAppStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creditAppStatus;
	}

	/**
	 * Returns the credit app status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CreditAppStatusId the primary key of the credit app status
	 * @return the credit app status, or <code>null</code> if a credit app status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppStatus fetchByPrimaryKey(long CreditAppStatusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)CreditAppStatusId);
	}

	/**
	 * Returns all the credit app statuses.
	 *
	 * @return the credit app statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app statuses
	 * @param end the upper bound of the range of credit app statuses (not inclusive)
	 * @return the range of credit app statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app statuses
	 * @param end the upper bound of the range of credit app statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit app statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppStatus> findAll(int start, int end,
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

		List<CreditAppStatus> list = (List<CreditAppStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CREDITAPPSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITAPPSTATUS;

				if (pagination) {
					sql = sql.concat(CreditAppStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CreditAppStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppStatus>(list);
				}
				else {
					list = (List<CreditAppStatus>)QueryUtil.list(q,
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
	 * Removes all the credit app statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CreditAppStatus creditAppStatus : findAll()) {
			remove(creditAppStatus);
		}
	}

	/**
	 * Returns the number of credit app statuses.
	 *
	 * @return the number of credit app statuses
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

				Query q = session.createQuery(_SQL_COUNT_CREDITAPPSTATUS);

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
	 * Initializes the credit app status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.CreditAppStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CreditAppStatus>> listenersList = new ArrayList<ModelListener<CreditAppStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CreditAppStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CreditAppStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CREDITAPPSTATUS = "SELECT creditAppStatus FROM CreditAppStatus creditAppStatus";
	private static final String _SQL_SELECT_CREDITAPPSTATUS_WHERE = "SELECT creditAppStatus FROM CreditAppStatus creditAppStatus WHERE ";
	private static final String _SQL_COUNT_CREDITAPPSTATUS = "SELECT COUNT(creditAppStatus) FROM CreditAppStatus creditAppStatus";
	private static final String _SQL_COUNT_CREDITAPPSTATUS_WHERE = "SELECT COUNT(creditAppStatus) FROM CreditAppStatus creditAppStatus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creditAppStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CreditAppStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CreditAppStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CreditAppStatusPersistenceImpl.class);
	private static CreditAppStatus _nullCreditAppStatus = new CreditAppStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CreditAppStatus> toCacheModel() {
				return _nullCreditAppStatusCacheModel;
			}
		};

	private static CacheModel<CreditAppStatus> _nullCreditAppStatusCacheModel = new CacheModel<CreditAppStatus>() {
			@Override
			public CreditAppStatus toEntityModel() {
				return _nullCreditAppStatus;
			}
		};
}