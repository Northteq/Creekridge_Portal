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

import com.tamarack.creekridge.NoSuchTermException;
import com.tamarack.creekridge.model.Term;
import com.tamarack.creekridge.model.impl.TermImpl;
import com.tamarack.creekridge.model.impl.TermModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see TermPersistence
 * @see TermUtil
 * @generated
 */
public class TermPersistenceImpl extends BasePersistenceImpl<Term>
	implements TermPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TermUtil} to access the term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TermImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TERMID = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTermId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERMID =
		new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTermId",
			new String[] { Long.class.getName() },
			TermModelImpl.TERMID_COLUMN_BITMASK |
			TermModelImpl.SEQUENCENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TERMID = new FinderPath(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTermId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the terms where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByTermId(long termId) throws SystemException {
		return findByTermId(termId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByTermId(long termId, int start, int end)
		throws SystemException {
		return findByTermId(termId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where termId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param termId the term ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findByTermId(long termId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERMID;
			finderArgs = new Object[] { termId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TERMID;
			finderArgs = new Object[] { termId, start, end, orderByComparator };
		}

		List<Term> list = (List<Term>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Term term : list) {
				if ((termId != term.getTermId())) {
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

			query.append(_SQL_SELECT_TERM_WHERE);

			query.append(_FINDER_COLUMN_TERMID_TERMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(termId);

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Term>(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first term in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws com.tamarack.creekridge.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByTermId_First(long termId,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByTermId_First(termId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the first term in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByTermId_First(long termId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Term> list = findByTermId(termId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws com.tamarack.creekridge.NoSuchTermException if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByTermId_Last(long termId,
		OrderByComparator orderByComparator)
		throws NoSuchTermException, SystemException {
		Term term = fetchByTermId_Last(termId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("termId=");
		msg.append(termId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTermException(msg.toString());
	}

	/**
	 * Returns the last term in the ordered set where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByTermId_Last(long termId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTermId(termId);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByTermId(termId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the terms where termId = &#63; from the database.
	 *
	 * @param termId the term ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTermId(long termId) throws SystemException {
		for (Term term : findByTermId(termId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms where termId = &#63;.
	 *
	 * @param termId the term ID
	 * @return the number of matching terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTermId(long termId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TERMID;

		Object[] finderArgs = new Object[] { termId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TERM_WHERE);

			query.append(_FINDER_COLUMN_TERMID_TERMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(termId);

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

	private static final String _FINDER_COLUMN_TERMID_TERMID_2 = "term.termId = ?";

	public TermPersistenceImpl() {
		setModelClass(Term.class);
	}

	/**
	 * Caches the term in the entity cache if it is enabled.
	 *
	 * @param term the term
	 */
	@Override
	public void cacheResult(Term term) {
		EntityCacheUtil.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey(), term);

		term.resetOriginalValues();
	}

	/**
	 * Caches the terms in the entity cache if it is enabled.
	 *
	 * @param terms the terms
	 */
	@Override
	public void cacheResult(List<Term> terms) {
		for (Term term : terms) {
			if (EntityCacheUtil.getResult(TermModelImpl.ENTITY_CACHE_ENABLED,
						TermImpl.class, term.getPrimaryKey()) == null) {
				cacheResult(term);
			}
			else {
				term.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all terms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TermImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TermImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the term.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Term term) {
		EntityCacheUtil.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Term> terms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Term term : terms) {
			EntityCacheUtil.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
				TermImpl.class, term.getPrimaryKey());
		}
	}

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	@Override
	public Term create(long termId) {
		Term term = new TermImpl();

		term.setNew(true);
		term.setPrimaryKey(termId);

		return term;
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term remove(long termId) throws NoSuchTermException, SystemException {
		return remove((Serializable)termId);
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term that was removed
	 * @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term remove(Serializable primaryKey)
		throws NoSuchTermException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Term term = (Term)session.get(TermImpl.class, primaryKey);

			if (term == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTermException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(term);
		}
		catch (NoSuchTermException nsee) {
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
	protected Term removeImpl(Term term) throws SystemException {
		term = toUnwrappedModel(term);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(term)) {
				term = (Term)session.get(TermImpl.class, term.getPrimaryKeyObj());
			}

			if (term != null) {
				session.delete(term);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (term != null) {
			clearCache(term);
		}

		return term;
	}

	@Override
	public Term updateImpl(com.tamarack.creekridge.model.Term term)
		throws SystemException {
		term = toUnwrappedModel(term);

		boolean isNew = term.isNew();

		TermModelImpl termModelImpl = (TermModelImpl)term;

		Session session = null;

		try {
			session = openSession();

			if (term.isNew()) {
				session.save(term);

				term.setNew(false);
			}
			else {
				session.merge(term);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TermModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((termModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { termModelImpl.getOriginalTermId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TERMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERMID,
					args);

				args = new Object[] { termModelImpl.getTermId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TERMID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TERMID,
					args);
			}
		}

		EntityCacheUtil.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
			TermImpl.class, term.getPrimaryKey(), term);

		return term;
	}

	protected Term toUnwrappedModel(Term term) {
		if (term instanceof TermImpl) {
			return term;
		}

		TermImpl termImpl = new TermImpl();

		termImpl.setNew(term.isNew());
		termImpl.setPrimaryKey(term.getPrimaryKey());

		termImpl.setTermId(term.getTermId());
		termImpl.setCompanyId(term.getCompanyId());
		termImpl.setUserId(term.getUserId());
		termImpl.setUserName(term.getUserName());
		termImpl.setCreateDate(term.getCreateDate());
		termImpl.setModifiedDate(term.getModifiedDate());
		termImpl.setTermMonths(term.getTermMonths());
		termImpl.setTermName(term.getTermName());
		termImpl.setSequenceNumber(term.getSequenceNumber());

		return termImpl;
	}

	/**
	 * Returns the term with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term
	 * @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTermException, SystemException {
		Term term = fetchByPrimaryKey(primaryKey);

		if (term == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTermException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return term;
	}

	/**
	 * Returns the term with the primary key or throws a {@link com.tamarack.creekridge.NoSuchTermException} if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term findByPrimaryKey(long termId)
		throws NoSuchTermException, SystemException {
		return findByPrimaryKey((Serializable)termId);
	}

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Term term = (Term)EntityCacheUtil.getResult(TermModelImpl.ENTITY_CACHE_ENABLED,
				TermImpl.class, primaryKey);

		if (term == _nullTerm) {
			return null;
		}

		if (term == null) {
			Session session = null;

			try {
				session = openSession();

				term = (Term)session.get(TermImpl.class, primaryKey);

				if (term != null) {
					cacheResult(term);
				}
				else {
					EntityCacheUtil.putResult(TermModelImpl.ENTITY_CACHE_ENABLED,
						TermImpl.class, primaryKey, _nullTerm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TermModelImpl.ENTITY_CACHE_ENABLED,
					TermImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return term;
	}

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Term fetchByPrimaryKey(long termId) throws SystemException {
		return fetchByPrimaryKey((Serializable)termId);
	}

	/**
	 * Returns all the terms.
	 *
	 * @return the terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Term> findAll(int start, int end,
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

		List<Term> list = (List<Term>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TERM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TERM;

				if (pagination) {
					sql = sql.concat(TermModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Term>(list);
				}
				else {
					list = (List<Term>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the terms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Term term : findAll()) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
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

				Query q = session.createQuery(_SQL_COUNT_TERM);

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
	 * Initializes the term persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.Term")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Term>> listenersList = new ArrayList<ModelListener<Term>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Term>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TermImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TERM = "SELECT term FROM Term term";
	private static final String _SQL_SELECT_TERM_WHERE = "SELECT term FROM Term term WHERE ";
	private static final String _SQL_COUNT_TERM = "SELECT COUNT(term) FROM Term term";
	private static final String _SQL_COUNT_TERM_WHERE = "SELECT COUNT(term) FROM Term term WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "term.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Term exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Term exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TermPersistenceImpl.class);
	private static Term _nullTerm = new TermImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Term> toCacheModel() {
				return _nullTermCacheModel;
			}
		};

	private static CacheModel<Term> _nullTermCacheModel = new CacheModel<Term>() {
			@Override
			public Term toEntityModel() {
				return _nullTerm;
			}
		};
}