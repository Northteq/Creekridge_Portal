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

import com.tamarack.creekridge.NoSuchCreditAppDocumentException;
import com.tamarack.creekridge.model.CreditAppDocument;
import com.tamarack.creekridge.model.impl.CreditAppDocumentImpl;
import com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the credit app document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppDocumentPersistence
 * @see CreditAppDocumentUtil
 * @generated
 */
public class CreditAppDocumentPersistenceImpl extends BasePersistenceImpl<CreditAppDocument>
	implements CreditAppDocumentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CreditAppDocumentUtil} to access the credit app document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CreditAppDocumentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED,
			CreditAppDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED,
			CreditAppDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED,
			CreditAppDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreditAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID =
		new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED,
			CreditAppDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreditAppId",
			new String[] { Long.class.getName() },
			CreditAppDocumentModelImpl.CREDITAPPID_COLUMN_BITMASK |
			CreditAppDocumentModelImpl.SEQUENCENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREDITAPPID = new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreditAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit app documents where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the matching credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findByCreditAppId(long creditAppId)
		throws SystemException {
		return findByCreditAppId(creditAppId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app documents where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit app documents
	 * @param end the upper bound of the range of credit app documents (not inclusive)
	 * @return the range of matching credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findByCreditAppId(long creditAppId,
		int start, int end) throws SystemException {
		return findByCreditAppId(creditAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app documents where creditAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creditAppId the credit app ID
	 * @param start the lower bound of the range of credit app documents
	 * @param end the upper bound of the range of credit app documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findByCreditAppId(long creditAppId,
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

		List<CreditAppDocument> list = (List<CreditAppDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditAppDocument creditAppDocument : list) {
				if ((creditAppId != creditAppDocument.getCreditAppId())) {
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

			query.append(_SQL_SELECT_CREDITAPPDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creditAppId);

				if (!pagination) {
					list = (List<CreditAppDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppDocument>(list);
				}
				else {
					list = (List<CreditAppDocument>)QueryUtil.list(q,
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
	 * Returns the first credit app document in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument findByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppDocumentException, SystemException {
		CreditAppDocument creditAppDocument = fetchByCreditAppId_First(creditAppId,
				orderByComparator);

		if (creditAppDocument != null) {
			return creditAppDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppDocumentException(msg.toString());
	}

	/**
	 * Returns the first credit app document in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app document, or <code>null</code> if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument fetchByCreditAppId_First(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditAppDocument> list = findByCreditAppId(creditAppId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app document in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument findByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppDocumentException, SystemException {
		CreditAppDocument creditAppDocument = fetchByCreditAppId_Last(creditAppId,
				orderByComparator);

		if (creditAppDocument != null) {
			return creditAppDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creditAppId=");
		msg.append(creditAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppDocumentException(msg.toString());
	}

	/**
	 * Returns the last credit app document in the ordered set where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app document, or <code>null</code> if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument fetchByCreditAppId_Last(long creditAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreditAppId(creditAppId);

		if (count == 0) {
			return null;
		}

		List<CreditAppDocument> list = findByCreditAppId(creditAppId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit app documents before and after the current credit app document in the ordered set where creditAppId = &#63;.
	 *
	 * @param CreditAppDocumentId the primary key of the current credit app document
	 * @param creditAppId the credit app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument[] findByCreditAppId_PrevAndNext(
		long CreditAppDocumentId, long creditAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppDocumentException, SystemException {
		CreditAppDocument creditAppDocument = findByPrimaryKey(CreditAppDocumentId);

		Session session = null;

		try {
			session = openSession();

			CreditAppDocument[] array = new CreditAppDocumentImpl[3];

			array[0] = getByCreditAppId_PrevAndNext(session, creditAppDocument,
					creditAppId, orderByComparator, true);

			array[1] = creditAppDocument;

			array[2] = getByCreditAppId_PrevAndNext(session, creditAppDocument,
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

	protected CreditAppDocument getByCreditAppId_PrevAndNext(Session session,
		CreditAppDocument creditAppDocument, long creditAppId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CREDITAPPDOCUMENT_WHERE);

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
			query.append(CreditAppDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creditAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditAppDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditAppDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit app documents where creditAppId = &#63; from the database.
	 *
	 * @param creditAppId the credit app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCreditAppId(long creditAppId) throws SystemException {
		for (CreditAppDocument creditAppDocument : findByCreditAppId(
				creditAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditAppDocument);
		}
	}

	/**
	 * Returns the number of credit app documents where creditAppId = &#63;.
	 *
	 * @param creditAppId the credit app ID
	 * @return the number of matching credit app documents
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

			query.append(_SQL_COUNT_CREDITAPPDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_CREDITAPPID_CREDITAPPID_2 = "creditAppDocument.creditAppId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCENUMBER =
		new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED,
			CreditAppDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySequenceNumber",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER =
		new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED,
			CreditAppDocumentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequenceNumber",
			new String[] { Long.class.getName() },
			CreditAppDocumentModelImpl.SEQUENCENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCENUMBER = new FinderPath(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequenceNumber",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the credit app documents where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findBySequenceNumber(long sequenceNumber)
		throws SystemException {
		return findBySequenceNumber(sequenceNumber, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app documents where sequenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sequenceNumber the sequence number
	 * @param start the lower bound of the range of credit app documents
	 * @param end the upper bound of the range of credit app documents (not inclusive)
	 * @return the range of matching credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findBySequenceNumber(long sequenceNumber,
		int start, int end) throws SystemException {
		return findBySequenceNumber(sequenceNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app documents where sequenceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sequenceNumber the sequence number
	 * @param start the lower bound of the range of credit app documents
	 * @param end the upper bound of the range of credit app documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findBySequenceNumber(long sequenceNumber,
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

		List<CreditAppDocument> list = (List<CreditAppDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CreditAppDocument creditAppDocument : list) {
				if ((sequenceNumber != creditAppDocument.getSequenceNumber())) {
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

			query.append(_SQL_SELECT_CREDITAPPDOCUMENT_WHERE);

			query.append(_FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CreditAppDocumentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sequenceNumber);

				if (!pagination) {
					list = (List<CreditAppDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppDocument>(list);
				}
				else {
					list = (List<CreditAppDocument>)QueryUtil.list(q,
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
	 * Returns the first credit app document in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument findBySequenceNumber_First(long sequenceNumber,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppDocumentException, SystemException {
		CreditAppDocument creditAppDocument = fetchBySequenceNumber_First(sequenceNumber,
				orderByComparator);

		if (creditAppDocument != null) {
			return creditAppDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sequenceNumber=");
		msg.append(sequenceNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppDocumentException(msg.toString());
	}

	/**
	 * Returns the first credit app document in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching credit app document, or <code>null</code> if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument fetchBySequenceNumber_First(long sequenceNumber,
		OrderByComparator orderByComparator) throws SystemException {
		List<CreditAppDocument> list = findBySequenceNumber(sequenceNumber, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last credit app document in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument findBySequenceNumber_Last(long sequenceNumber,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppDocumentException, SystemException {
		CreditAppDocument creditAppDocument = fetchBySequenceNumber_Last(sequenceNumber,
				orderByComparator);

		if (creditAppDocument != null) {
			return creditAppDocument;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sequenceNumber=");
		msg.append(sequenceNumber);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCreditAppDocumentException(msg.toString());
	}

	/**
	 * Returns the last credit app document in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching credit app document, or <code>null</code> if a matching credit app document could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument fetchBySequenceNumber_Last(long sequenceNumber,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySequenceNumber(sequenceNumber);

		if (count == 0) {
			return null;
		}

		List<CreditAppDocument> list = findBySequenceNumber(sequenceNumber,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the credit app documents before and after the current credit app document in the ordered set where sequenceNumber = &#63;.
	 *
	 * @param CreditAppDocumentId the primary key of the current credit app document
	 * @param sequenceNumber the sequence number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument[] findBySequenceNumber_PrevAndNext(
		long CreditAppDocumentId, long sequenceNumber,
		OrderByComparator orderByComparator)
		throws NoSuchCreditAppDocumentException, SystemException {
		CreditAppDocument creditAppDocument = findByPrimaryKey(CreditAppDocumentId);

		Session session = null;

		try {
			session = openSession();

			CreditAppDocument[] array = new CreditAppDocumentImpl[3];

			array[0] = getBySequenceNumber_PrevAndNext(session,
					creditAppDocument, sequenceNumber, orderByComparator, true);

			array[1] = creditAppDocument;

			array[2] = getBySequenceNumber_PrevAndNext(session,
					creditAppDocument, sequenceNumber, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CreditAppDocument getBySequenceNumber_PrevAndNext(
		Session session, CreditAppDocument creditAppDocument,
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

		query.append(_SQL_SELECT_CREDITAPPDOCUMENT_WHERE);

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
			query.append(CreditAppDocumentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sequenceNumber);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(creditAppDocument);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CreditAppDocument> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the credit app documents where sequenceNumber = &#63; from the database.
	 *
	 * @param sequenceNumber the sequence number
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBySequenceNumber(long sequenceNumber)
		throws SystemException {
		for (CreditAppDocument creditAppDocument : findBySequenceNumber(
				sequenceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(creditAppDocument);
		}
	}

	/**
	 * Returns the number of credit app documents where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the number of matching credit app documents
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

			query.append(_SQL_COUNT_CREDITAPPDOCUMENT_WHERE);

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

	private static final String _FINDER_COLUMN_SEQUENCENUMBER_SEQUENCENUMBER_2 = "creditAppDocument.sequenceNumber = ?";

	public CreditAppDocumentPersistenceImpl() {
		setModelClass(CreditAppDocument.class);
	}

	/**
	 * Caches the credit app document in the entity cache if it is enabled.
	 *
	 * @param creditAppDocument the credit app document
	 */
	@Override
	public void cacheResult(CreditAppDocument creditAppDocument) {
		EntityCacheUtil.putResult(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentImpl.class, creditAppDocument.getPrimaryKey(),
			creditAppDocument);

		creditAppDocument.resetOriginalValues();
	}

	/**
	 * Caches the credit app documents in the entity cache if it is enabled.
	 *
	 * @param creditAppDocuments the credit app documents
	 */
	@Override
	public void cacheResult(List<CreditAppDocument> creditAppDocuments) {
		for (CreditAppDocument creditAppDocument : creditAppDocuments) {
			if (EntityCacheUtil.getResult(
						CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppDocumentImpl.class,
						creditAppDocument.getPrimaryKey()) == null) {
				cacheResult(creditAppDocument);
			}
			else {
				creditAppDocument.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all credit app documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CreditAppDocumentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CreditAppDocumentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the credit app document.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CreditAppDocument creditAppDocument) {
		EntityCacheUtil.removeResult(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentImpl.class, creditAppDocument.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CreditAppDocument> creditAppDocuments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CreditAppDocument creditAppDocument : creditAppDocuments) {
			EntityCacheUtil.removeResult(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppDocumentImpl.class, creditAppDocument.getPrimaryKey());
		}
	}

	/**
	 * Creates a new credit app document with the primary key. Does not add the credit app document to the database.
	 *
	 * @param CreditAppDocumentId the primary key for the new credit app document
	 * @return the new credit app document
	 */
	@Override
	public CreditAppDocument create(long CreditAppDocumentId) {
		CreditAppDocument creditAppDocument = new CreditAppDocumentImpl();

		creditAppDocument.setNew(true);
		creditAppDocument.setPrimaryKey(CreditAppDocumentId);

		return creditAppDocument;
	}

	/**
	 * Removes the credit app document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CreditAppDocumentId the primary key of the credit app document
	 * @return the credit app document that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument remove(long CreditAppDocumentId)
		throws NoSuchCreditAppDocumentException, SystemException {
		return remove((Serializable)CreditAppDocumentId);
	}

	/**
	 * Removes the credit app document with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the credit app document
	 * @return the credit app document that was removed
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument remove(Serializable primaryKey)
		throws NoSuchCreditAppDocumentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CreditAppDocument creditAppDocument = (CreditAppDocument)session.get(CreditAppDocumentImpl.class,
					primaryKey);

			if (creditAppDocument == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreditAppDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(creditAppDocument);
		}
		catch (NoSuchCreditAppDocumentException nsee) {
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
	protected CreditAppDocument removeImpl(CreditAppDocument creditAppDocument)
		throws SystemException {
		creditAppDocument = toUnwrappedModel(creditAppDocument);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creditAppDocument)) {
				creditAppDocument = (CreditAppDocument)session.get(CreditAppDocumentImpl.class,
						creditAppDocument.getPrimaryKeyObj());
			}

			if (creditAppDocument != null) {
				session.delete(creditAppDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (creditAppDocument != null) {
			clearCache(creditAppDocument);
		}

		return creditAppDocument;
	}

	@Override
	public CreditAppDocument updateImpl(
		com.tamarack.creekridge.model.CreditAppDocument creditAppDocument)
		throws SystemException {
		creditAppDocument = toUnwrappedModel(creditAppDocument);

		boolean isNew = creditAppDocument.isNew();

		CreditAppDocumentModelImpl creditAppDocumentModelImpl = (CreditAppDocumentModelImpl)creditAppDocument;

		Session session = null;

		try {
			session = openSession();

			if (creditAppDocument.isNew()) {
				session.save(creditAppDocument);

				creditAppDocument.setNew(false);
			}
			else {
				session.merge(creditAppDocument);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CreditAppDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((creditAppDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppDocumentModelImpl.getOriginalCreditAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);

				args = new Object[] { creditAppDocumentModelImpl.getCreditAppId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREDITAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREDITAPPID,
					args);
			}

			if ((creditAppDocumentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						creditAppDocumentModelImpl.getOriginalSequenceNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER,
					args);

				args = new Object[] {
						creditAppDocumentModelImpl.getSequenceNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCENUMBER,
					args);
			}
		}

		EntityCacheUtil.putResult(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
			CreditAppDocumentImpl.class, creditAppDocument.getPrimaryKey(),
			creditAppDocument);

		return creditAppDocument;
	}

	protected CreditAppDocument toUnwrappedModel(
		CreditAppDocument creditAppDocument) {
		if (creditAppDocument instanceof CreditAppDocumentImpl) {
			return creditAppDocument;
		}

		CreditAppDocumentImpl creditAppDocumentImpl = new CreditAppDocumentImpl();

		creditAppDocumentImpl.setNew(creditAppDocument.isNew());
		creditAppDocumentImpl.setPrimaryKey(creditAppDocument.getPrimaryKey());

		creditAppDocumentImpl.setCreditAppDocumentId(creditAppDocument.getCreditAppDocumentId());
		creditAppDocumentImpl.setCompanyId(creditAppDocument.getCompanyId());
		creditAppDocumentImpl.setUserId(creditAppDocument.getUserId());
		creditAppDocumentImpl.setUserName(creditAppDocument.getUserName());
		creditAppDocumentImpl.setCreateDate(creditAppDocument.getCreateDate());
		creditAppDocumentImpl.setModifiedDate(creditAppDocument.getModifiedDate());
		creditAppDocumentImpl.setCreditAppId(creditAppDocument.getCreditAppId());
		creditAppDocumentImpl.setSequenceNumber(creditAppDocument.getSequenceNumber());
		creditAppDocumentImpl.setDocumentTitle(creditAppDocument.getDocumentTitle());
		creditAppDocumentImpl.setDocumentFileName(creditAppDocument.getDocumentFileName());
		creditAppDocumentImpl.setDocumentFileLocation(creditAppDocument.getDocumentFileLocation());

		return creditAppDocumentImpl;
	}

	/**
	 * Returns the credit app document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app document
	 * @return the credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreditAppDocumentException, SystemException {
		CreditAppDocument creditAppDocument = fetchByPrimaryKey(primaryKey);

		if (creditAppDocument == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreditAppDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return creditAppDocument;
	}

	/**
	 * Returns the credit app document with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppDocumentException} if it could not be found.
	 *
	 * @param CreditAppDocumentId the primary key of the credit app document
	 * @return the credit app document
	 * @throws com.tamarack.creekridge.NoSuchCreditAppDocumentException if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument findByPrimaryKey(long CreditAppDocumentId)
		throws NoSuchCreditAppDocumentException, SystemException {
		return findByPrimaryKey((Serializable)CreditAppDocumentId);
	}

	/**
	 * Returns the credit app document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the credit app document
	 * @return the credit app document, or <code>null</code> if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CreditAppDocument creditAppDocument = (CreditAppDocument)EntityCacheUtil.getResult(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
				CreditAppDocumentImpl.class, primaryKey);

		if (creditAppDocument == _nullCreditAppDocument) {
			return null;
		}

		if (creditAppDocument == null) {
			Session session = null;

			try {
				session = openSession();

				creditAppDocument = (CreditAppDocument)session.get(CreditAppDocumentImpl.class,
						primaryKey);

				if (creditAppDocument != null) {
					cacheResult(creditAppDocument);
				}
				else {
					EntityCacheUtil.putResult(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
						CreditAppDocumentImpl.class, primaryKey,
						_nullCreditAppDocument);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CreditAppDocumentModelImpl.ENTITY_CACHE_ENABLED,
					CreditAppDocumentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return creditAppDocument;
	}

	/**
	 * Returns the credit app document with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CreditAppDocumentId the primary key of the credit app document
	 * @return the credit app document, or <code>null</code> if a credit app document with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CreditAppDocument fetchByPrimaryKey(long CreditAppDocumentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)CreditAppDocumentId);
	}

	/**
	 * Returns all the credit app documents.
	 *
	 * @return the credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the credit app documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app documents
	 * @param end the upper bound of the range of credit app documents (not inclusive)
	 * @return the range of credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the credit app documents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of credit app documents
	 * @param end the upper bound of the range of credit app documents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of credit app documents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CreditAppDocument> findAll(int start, int end,
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

		List<CreditAppDocument> list = (List<CreditAppDocument>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CREDITAPPDOCUMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CREDITAPPDOCUMENT;

				if (pagination) {
					sql = sql.concat(CreditAppDocumentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CreditAppDocument>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CreditAppDocument>(list);
				}
				else {
					list = (List<CreditAppDocument>)QueryUtil.list(q,
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
	 * Removes all the credit app documents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CreditAppDocument creditAppDocument : findAll()) {
			remove(creditAppDocument);
		}
	}

	/**
	 * Returns the number of credit app documents.
	 *
	 * @return the number of credit app documents
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

				Query q = session.createQuery(_SQL_COUNT_CREDITAPPDOCUMENT);

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
	 * Initializes the credit app document persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.CreditAppDocument")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CreditAppDocument>> listenersList = new ArrayList<ModelListener<CreditAppDocument>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CreditAppDocument>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CreditAppDocumentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CREDITAPPDOCUMENT = "SELECT creditAppDocument FROM CreditAppDocument creditAppDocument";
	private static final String _SQL_SELECT_CREDITAPPDOCUMENT_WHERE = "SELECT creditAppDocument FROM CreditAppDocument creditAppDocument WHERE ";
	private static final String _SQL_COUNT_CREDITAPPDOCUMENT = "SELECT COUNT(creditAppDocument) FROM CreditAppDocument creditAppDocument";
	private static final String _SQL_COUNT_CREDITAPPDOCUMENT_WHERE = "SELECT COUNT(creditAppDocument) FROM CreditAppDocument creditAppDocument WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "creditAppDocument.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CreditAppDocument exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CreditAppDocument exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CreditAppDocumentPersistenceImpl.class);
	private static CreditAppDocument _nullCreditAppDocument = new CreditAppDocumentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CreditAppDocument> toCacheModel() {
				return _nullCreditAppDocumentCacheModel;
			}
		};

	private static CacheModel<CreditAppDocument> _nullCreditAppDocumentCacheModel =
		new CacheModel<CreditAppDocument>() {
			@Override
			public CreditAppDocument toEntityModel() {
				return _nullCreditAppDocument;
			}
		};
}