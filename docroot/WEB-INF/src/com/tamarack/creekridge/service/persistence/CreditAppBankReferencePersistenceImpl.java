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

import com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;
import com.tamarack.creekridge.model.CreditAppBankReference;
import com.tamarack.creekridge.model.impl.CreditAppBankReferenceImpl;
import com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the credit app bank reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppBankReferencePersistence
 * @see CreditAppBankReferenceUtil
 * @generated
 */
public class CreditAppBankReferencePersistenceImpl extends BasePersistenceImpl<CreditAppBankReference>
	implements CreditAppBankReferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreditAppBankReferenceUtil} to access the credit app bank reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreditAppBankReferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreditAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreditAppId",
			new String[] { Long.class.getName() },
			CreditAppBankReferenceModelImpl.CREDITAPPID_COLUMN_BITMASK |
			CreditAppBankReferenceModelImpl.SEQUENCENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDITAPPID = new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreditAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit app bank references where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the matching credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findByCreditAppId(long creditAppId)
		throws SystemException {
		return findByCreditAppId(creditAppId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app bank references where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit app bank references
	 * @param end the upper bound of the range of credit app bank references (not inclusive)
	 * @return the range of matching credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findByCreditAppId(long creditAppId,
		int start, int end) throws SystemException {
		return findByCreditAppId(creditAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app bank references where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit app bank references
	 * @param end the upper bound of the range of credit app bank references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findByCreditAppId(long creditAppId,
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

		List<CreditAppBankReference> list = (List<CreditAppBankReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditAppBankReference creditAppBankReference : list) {
				if ((creditAppId != creditAppBankReference.getCreditAppId())) {
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

			query.append(_SQL_SELECT_CREDITAPPBANKREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppBankReferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppId);

				if (!pagination) {
					list = (List<CreditAppBankReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppBankReference>(list);
				}
				else {
					list = (List<CreditAppBankReference>)QueryUtil.list(q,
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
	 * Returns the first credit app bank reference in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference findByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		CreditAppBankReference creditAppBankReference = fetchByCreditAppId_First(creditAppId,
				orderByComparator);

		if (creditAppBankReference != null) {
			return creditAppBankReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppBankReferenceException(msg.toString());
	}

	/**
	 * Returns the first credit app bank reference in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference fetchByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditAppBankReference> list = findByCreditAppId(creditAppId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app bank reference in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference findByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		CreditAppBankReference creditAppBankReference = fetchByCreditAppId_Last(creditAppId,
				orderByComparator);

		if (creditAppBankReference != null) {
			return creditAppBankReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppBankReferenceException(msg.toString());
	}

	/**
	 * Returns the last credit app bank reference in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference fetchByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreditAppId(creditAppId);

		if (count == 0) {
			return null;
		}

		List<CreditAppBankReference> list = findByCreditAppId(creditAppId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit app bank references before and after the current credit app bank reference in the ordered set where creditAppId = &#63;.
	 *
	 * @param bankReferenceId the primary key of the current credit app bank reference
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference[] findByCreditAppId_PrevAndNext(
		long bankReferenceId, long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		CreditAppBankReference creditAppBankReference = findByPrimaryKey(bankReferenceId);

		Session session = null;

		try {
			session = openSession();

			CreditAppBankReference[] array = new CreditAppBankReferenceImpl[3];

			array[0] = getByCreditAppId_PrevAndNext(session,
					creditAppBankReference, creditAppId, orderByComparator, true);

			array[1] = creditAppBankReference;

			array[2] = getByCreditAppId_PrevAndNext(session,
					creditAppBankReference, creditAppId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditAppBankReference getByCreditAppId_PrevAndNext(
		Session session, CreditAppBankReference creditAppBankReference,
		long creditAppId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPPBANKREFERENCE_WHERE);

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
			query.append(CreditAppBankReferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creditAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditAppBankReference);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditAppBankReference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit app bank references where creditAppId = &#63; from the database.
	 *
	 * @param creditAppId the credit app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreditAppId(long creditAppId) throws SystemException {
		for (CreditAppBankReference creditAppBankReference : findByCreditAppId(
				creditAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditAppBankReference);
		}
	}

	/**
	 * Returns the number of credit app bank references where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the number of matching credit app bank references
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

			query.append(_SQL_COUNT_CREDITAPPBANKREFERENCE_WHERE);

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

	private static final String _FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2 = "creditAppBankReference.creditAppId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCENUMBER =
		new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySequenceNumber",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER =
		new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequenceNumber",
			new String[] { Long.class.getName() },
			CreditAppBankReferenceModelImpl.SEQUENCENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCENUMBER = new FinderPath(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequenceNumber",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit app bank references where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber) throws SystemException {
		return findBySequenceNumber(sequenceNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app bank references where sequenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sequenceNumber the sequence number
	 * @param start the lower bound of the range of credit app bank references
	 * @param end the upper bound of the range of credit app bank references (not inclusive)
	 * @return the range of matching credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber, int start, int end) throws SystemException {
		return findBySequenceNumber(sequenceNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app bank references where sequenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sequenceNumber the sequence number
	 * @param start the lower bound of the range of credit app bank references
	 * @param end the upper bound of the range of credit app bank references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<CreditAppBankReference> list = (List<CreditAppBankReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditAppBankReference creditAppBankReference : list) {
				if ((sequenceNumber != creditAppBankReference.getSequenceNumber())) {
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

			query.append(_SQL_SELECT_CREDITAPPBANKREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppBankReferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sequenceNumber);

				if (!pagination) {
					list = (List<CreditAppBankReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppBankReference>(list);
				}
				else {
					list = (List<CreditAppBankReference>)QueryUtil.list(q,
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
	 * Returns the first credit app bank reference in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference findBySequenceNumber_First(
		long sequenceNumber, OrderByComparator orderByComparator)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		CreditAppBankReference creditAppBankReference = fetchBySequenceNumber_First(sequenceNumber,
				orderByComparator);

		if (creditAppBankReference != null) {
			return creditAppBankReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sequenceNumber=");
		msg.append(sequenceNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppBankReferenceException(msg.toString());
	}

	/**
	 * Returns the first credit app bank reference in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference fetchBySequenceNumber_First(
		long sequenceNumber, OrderByComparator orderByComparator)
		throws SystemException {
		List<CreditAppBankReference> list = findBySequenceNumber(sequenceNumber,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app bank reference in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference findBySequenceNumber_Last(
		long sequenceNumber, OrderByComparator orderByComparator)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		CreditAppBankReference creditAppBankReference = fetchBySequenceNumber_Last(sequenceNumber,
				orderByComparator);

		if (creditAppBankReference != null) {
			return creditAppBankReference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sequenceNumber=");
		msg.append(sequenceNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppBankReferenceException(msg.toString());
	}

	/**
	 * Returns the last credit app bank reference in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference fetchBySequenceNumber_Last(
		long sequenceNumber, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBySequenceNumber(sequenceNumber);

		if (count == 0) {
			return null;
		}

		List<CreditAppBankReference> list = findBySequenceNumber(sequenceNumber,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit app bank references before and after the current credit app bank reference in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param bankReferenceId the primary key of the current credit app bank reference
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference[] findBySequenceNumber_PrevAndNext(
		long bankReferenceId, long sequenceNumber,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		CreditAppBankReference creditAppBankReference = findByPrimaryKey(bankReferenceId);

		Session session = null;

		try {
			session = openSession();

			CreditAppBankReference[] array = new CreditAppBankReferenceImpl[3];

			array[0] = getBySequenceNumber_PrevAndNext(session,
					creditAppBankReference, sequenceNumber, orderByComparator,
					true);

			array[1] = creditAppBankReference;

			array[2] = getBySequenceNumber_PrevAndNext(session,
					creditAppBankReference, sequenceNumber, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditAppBankReference getBySequenceNumber_PrevAndNext(
		Session session, CreditAppBankReference creditAppBankReference,
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

		query.append(_SQL_SELECT_CREDITAPPBANKREFERENCE_WHERE);

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
			query.append(CreditAppBankReferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sequenceNumber);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditAppBankReference);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditAppBankReference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit app bank references where sequenceNumber = &#63; from the database.
	 *
	 * @param sequenceNumber the sequence number
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySequenceNumber(long sequenceNumber)
		throws SystemException {
		for (CreditAppBankReference creditAppBankReference : findBySequenceNumber(
				sequenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditAppBankReference);
		}
	}

	/**
	 * Returns the number of credit app bank references where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the number of matching credit app bank references
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

			query.append(_SQL_COUNT_CREDITAPPBANKREFERENCE_WHERE);

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

	private static final String _FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2 = "creditAppBankReference.sequenceNumber = ?";

	public CreditAppBankReferencePersistenceImpl() {
		setModelClass(CreditAppBankReference.class);
	}

	/**
	 * Caches the credit app bank reference in the entity cache if it is enabled.
	 *
	 * @param creditAppBankReference the credit app bank reference
	 */
	@Override
	public void cacheResult(CreditAppBankReference creditAppBankReference) {
		EntityCacheUtil.putResult(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			creditAppBankReference.getPrimaryKey(), creditAppBankReference);

		creditAppBankReference.resetOriginalValues();
	}

	/**
	 * Caches the credit app bank references in the entity cache if it is enabled.
	 *
	 * @param creditAppBankReferences the credit app bank references
	 */
	@Override
	public void cacheResult(
		List<CreditAppBankReference> creditAppBankReferences) {
		for (CreditAppBankReference creditAppBankReference : creditAppBankReferences) {
			if (EntityCacheUtil.getResult(
						CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppBankReferenceImpl.class,
						creditAppBankReference.getPrimaryKey()) == null) {
				cacheResult(creditAppBankReference);
			}
			else {
				creditAppBankReference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all credit app bank references.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CreditAppBankReferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CreditAppBankReferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit app bank reference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditAppBankReference creditAppBankReference) {
		EntityCacheUtil.removeResult(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			creditAppBankReference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CreditAppBankReference> creditAppBankReferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CreditAppBankReference creditAppBankReference : creditAppBankReferences) {
			EntityCacheUtil.removeResult(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppBankReferenceImpl.class,
				creditAppBankReference.getPrimaryKey());
		}
	}

	/**
	 * Creates a new credit app bank reference with the primary key. Does not add the credit app bank reference to the database.
	 *
	 * @param bankReferenceId the primary key for the new credit app bank reference
	 * @return the new credit app bank reference
	 */
	@Override
	public CreditAppBankReference create(long bankReferenceId) {
		CreditAppBankReference creditAppBankReference = new CreditAppBankReferenceImpl();

		creditAppBankReference.setNew(true);
		creditAppBankReference.setPrimaryKey(bankReferenceId);

		return creditAppBankReference;
	}

	/**
	 * Removes the credit app bank reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankReferenceId the primary key of the credit app bank reference
	 * @return the credit app bank reference that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference remove(long bankReferenceId)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		return remove((Serializable)bankReferenceId);
	}

	/**
	 * Removes the credit app bank reference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit app bank reference
	 * @return the credit app bank reference that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference remove(Serializable primaryKey)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CreditAppBankReference creditAppBankReference = (CreditAppBankReference)session.get(CreditAppBankReferenceImpl.class,
					primaryKey);

			if (creditAppBankReference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditAppBankReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creditAppBankReference);
		}
		catch (NoSuchCreditAppBankReferenceException nsee) {
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
	protected CreditAppBankReference removeImpl(
		CreditAppBankReference creditAppBankReference)
		throws SystemException {
		creditAppBankReference = toUnwrappedModel(creditAppBankReference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditAppBankReference)) {
				creditAppBankReference = (CreditAppBankReference)session.get(CreditAppBankReferenceImpl.class,
						creditAppBankReference.getPrimaryKeyObj());
			}

			if (creditAppBankReference != null) {
				session.delete(creditAppBankReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creditAppBankReference != null) {
			clearCache(creditAppBankReference);
		}

		return creditAppBankReference;
	}

	@Override
	public CreditAppBankReference updateImpl(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference)
		throws SystemException {
		creditAppBankReference = toUnwrappedModel(creditAppBankReference);

		boolean isNew = creditAppBankReference.isNew();

		CreditAppBankReferenceModelImpl creditAppBankReferenceModelImpl = (CreditAppBankReferenceModelImpl)creditAppBankReference;

		Session session = null;

		try {
			session = openSession();

			if (creditAppBankReference.isNew()) {
				session.save(creditAppBankReference);

				creditAppBankReference.setNew(false);
			}
			else {
				session.merge(creditAppBankReference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CreditAppBankReferenceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((creditAppBankReferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppBankReferenceModelImpl.getOriginalCreditAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);

				args = new Object[] {
						creditAppBankReferenceModelImpl.getCreditAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);
			}

			if ((creditAppBankReferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppBankReferenceModelImpl.getOriginalSequenceNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER,
					args);

				args = new Object[] {
						creditAppBankReferenceModelImpl.getSequenceNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER,
					args);
			}
		}

		EntityCacheUtil.putResult(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppBankReferenceImpl.class,
			creditAppBankReference.getPrimaryKey(), creditAppBankReference);

		return creditAppBankReference;
	}

	protected CreditAppBankReference toUnwrappedModel(
		CreditAppBankReference creditAppBankReference) {
		if (creditAppBankReference instanceof CreditAppBankReferenceImpl) {
			return creditAppBankReference;
		}

		CreditAppBankReferenceImpl creditAppBankReferenceImpl = new CreditAppBankReferenceImpl();

		creditAppBankReferenceImpl.setNew(creditAppBankReference.isNew());
		creditAppBankReferenceImpl.setPrimaryKey(creditAppBankReference.getPrimaryKey());

		creditAppBankReferenceImpl.setBankReferenceId(creditAppBankReference.getBankReferenceId());
		creditAppBankReferenceImpl.setCompanyId(creditAppBankReference.getCompanyId());
		creditAppBankReferenceImpl.setUserId(creditAppBankReference.getUserId());
		creditAppBankReferenceImpl.setUserName(creditAppBankReference.getUserName());
		creditAppBankReferenceImpl.setCreateDate(creditAppBankReference.getCreateDate());
		creditAppBankReferenceImpl.setModifiedDate(creditAppBankReference.getModifiedDate());
		creditAppBankReferenceImpl.setCreditAppId(creditAppBankReference.getCreditAppId());
		creditAppBankReferenceImpl.setSequenceNumber(creditAppBankReference.getSequenceNumber());
		creditAppBankReferenceImpl.setBankReferenceName(creditAppBankReference.getBankReferenceName());
		creditAppBankReferenceImpl.setBankReferenceContact(creditAppBankReference.getBankReferenceContact());
		creditAppBankReferenceImpl.setBankReferencePhone(creditAppBankReference.getBankReferencePhone());
		creditAppBankReferenceImpl.setBankReferencAccountType(creditAppBankReference.getBankReferencAccountType());
		creditAppBankReferenceImpl.setBankReferenceAccountNumber(creditAppBankReference.getBankReferenceAccountNumber());

		return creditAppBankReferenceImpl;
	}

	/**
	 * Returns the credit app bank reference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app bank reference
	 * @return the credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		CreditAppBankReference creditAppBankReference = fetchByPrimaryKey(primaryKey);

		if (creditAppBankReference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditAppBankReferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creditAppBankReference;
	}

	/**
	 * Returns the credit app bank reference with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppBankReferenceException} if it could not be found.
	 *
	 * @param bankReferenceId the primary key of the credit app bank reference
	 * @return the credit app bank reference
	 * @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference findByPrimaryKey(long bankReferenceId)
		throws NoSuchCreditAppBankReferenceException, SystemException {
		return findByPrimaryKey((Serializable)bankReferenceId);
	}

	/**
	 * Returns the credit app bank reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app bank reference
	 * @return the credit app bank reference, or <code>null</code> if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CreditAppBankReference creditAppBankReference = (CreditAppBankReference)EntityCacheUtil.getResult(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppBankReferenceImpl.class, primaryKey);

		if (creditAppBankReference == _nullCreditAppBankReference) {
			return null;
		}

		if (creditAppBankReference == null) {
			Session session = null;

			try {
				session = openSession();

				creditAppBankReference = (CreditAppBankReference)session.get(CreditAppBankReferenceImpl.class,
						primaryKey);

				if (creditAppBankReference != null) {
					cacheResult(creditAppBankReference);
				}
				else {
					EntityCacheUtil.putResult(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppBankReferenceImpl.class, primaryKey,
						_nullCreditAppBankReference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CreditAppBankReferenceModelImpl.ENTITY_CACHE_ENABLED,
					CreditAppBankReferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creditAppBankReference;
	}

	/**
	 * Returns the credit app bank reference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankReferenceId the primary key of the credit app bank reference
	 * @return the credit app bank reference, or <code>null</code> if a credit app bank reference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppBankReference fetchByPrimaryKey(long bankReferenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)bankReferenceId);
	}

	/**
	 * Returns all the credit app bank references.
	 *
	 * @return the credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app bank references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app bank references
	 * @param end the upper bound of the range of credit app bank references (not inclusive)
	 * @return the range of credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app bank references.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppBankReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app bank references
	 * @param end the upper bound of the range of credit app bank references (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit app bank references
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppBankReference> findAll(int start, int end,
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

		List<CreditAppBankReference> list = (List<CreditAppBankReference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CREDITAPPBANKREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITAPPBANKREFERENCE;

				if (pagination) {
					sql = sql.concat(CreditAppBankReferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CreditAppBankReference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppBankReference>(list);
				}
				else {
					list = (List<CreditAppBankReference>)QueryUtil.list(q,
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
	 * Removes all the credit app bank references from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CreditAppBankReference creditAppBankReference : findAll()) {
			remove(creditAppBankReference);
		}
	}

	/**
	 * Returns the number of credit app bank references.
	 *
	 * @return the number of credit app bank references
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

				Query q = session.createQuery(_SQL_COUNT_CREDITAPPBANKREFERENCE);

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
	 * Initializes the credit app bank reference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.CreditAppBankReference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CreditAppBankReference>> listenersList = new ArrayList<ModelListener<CreditAppBankReference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CreditAppBankReference>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CreditAppBankReferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CREDITAPPBANKREFERENCE = "SELECT creditAppBankReference FROM CreditAppBankReference creditAppBankReference";
	private static final String _SQL_SELECT_CREDITAPPBANKREFERENCE_WHERE = "SELECT creditAppBankReference FROM CreditAppBankReference creditAppBankReference WHERE ";
	private static final String _SQL_COUNT_CREDITAPPBANKREFERENCE = "SELECT COUNT(creditAppBankReference) FROM CreditAppBankReference creditAppBankReference";
	private static final String _SQL_COUNT_CREDITAPPBANKREFERENCE_WHERE = "SELECT COUNT(creditAppBankReference) FROM CreditAppBankReference creditAppBankReference WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creditAppBankReference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CreditAppBankReference exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CreditAppBankReference exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CreditAppBankReferencePersistenceImpl.class);
	private static CreditAppBankReference _nullCreditAppBankReference = new CreditAppBankReferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CreditAppBankReference> toCacheModel() {
				return _nullCreditAppBankReferenceCacheModel;
			}
		};

	private static CacheModel<CreditAppBankReference> _nullCreditAppBankReferenceCacheModel =
		new CacheModel<CreditAppBankReference>() {
			@Override
			public CreditAppBankReference toEntityModel() {
				return _nullCreditAppBankReference;
			}
		};
}