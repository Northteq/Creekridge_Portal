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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.tamarack.creekridge.NoSuchVendorMessageException;
import com.tamarack.creekridge.model.VendorMessage;
import com.tamarack.creekridge.model.impl.VendorMessageImpl;
import com.tamarack.creekridge.model.impl.VendorMessageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the vendor message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see VendorMessagePersistence
 * @see VendorMessageUtil
 * @generated
 */
public class VendorMessagePersistenceImpl extends BasePersistenceImpl<VendorMessage>
	implements VendorMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VendorMessageUtil} to access the vendor message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VendorMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageModelImpl.FINDER_CACHE_ENABLED,
			VendorMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageModelImpl.FINDER_CACHE_ENABLED,
			VendorMessageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageModelImpl.FINDER_CACHE_ENABLED,
			VendorMessageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageModelImpl.FINDER_CACHE_ENABLED,
			VendorMessageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByName", new String[] { String.class.getName() },
			VendorMessageModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vendor messages where key = &#63;.
	 *
	 * @param key the key
	 * @return the matching vendor messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VendorMessage> findByName(String key) throws SystemException {
		return findByName(key, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vendor messages where key = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param key the key
	 * @param start the lower bound of the range of vendor messages
	 * @param end the upper bound of the range of vendor messages (not inclusive)
	 * @return the range of matching vendor messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VendorMessage> findByName(String key, int start, int end)
		throws SystemException {
		return findByName(key, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vendor messages where key = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param key the key
	 * @param start the lower bound of the range of vendor messages
	 * @param end the upper bound of the range of vendor messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vendor messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VendorMessage> findByName(String key, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { key };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { key, start, end, orderByComparator };
		}

		List<VendorMessage> list = (List<VendorMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VendorMessage vendorMessage : list) {
				if (!Validator.equals(key, vendorMessage.getKey())) {
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

			query.append(_SQL_SELECT_VENDORMESSAGE_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_NAME_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_NAME_KEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				if (!pagination) {
					list = (List<VendorMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VendorMessage>(list);
				}
				else {
					list = (List<VendorMessage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vendor message in the ordered set where key = &#63;.
	 *
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor message
	 * @throws com.tamarack.creekridge.NoSuchVendorMessageException if a matching vendor message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage findByName_First(String key,
		OrderByComparator orderByComparator)
		throws NoSuchVendorMessageException, SystemException {
		VendorMessage vendorMessage = fetchByName_First(key, orderByComparator);

		if (vendorMessage != null) {
			return vendorMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("key=");
		msg.append(key);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorMessageException(msg.toString());
	}

	/**
	 * Returns the first vendor message in the ordered set where key = &#63;.
	 *
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor message, or <code>null</code> if a matching vendor message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage fetchByName_First(String key,
		OrderByComparator orderByComparator) throws SystemException {
		List<VendorMessage> list = findByName(key, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor message in the ordered set where key = &#63;.
	 *
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor message
	 * @throws com.tamarack.creekridge.NoSuchVendorMessageException if a matching vendor message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage findByName_Last(String key,
		OrderByComparator orderByComparator)
		throws NoSuchVendorMessageException, SystemException {
		VendorMessage vendorMessage = fetchByName_Last(key, orderByComparator);

		if (vendorMessage != null) {
			return vendorMessage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("key=");
		msg.append(key);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVendorMessageException(msg.toString());
	}

	/**
	 * Returns the last vendor message in the ordered set where key = &#63;.
	 *
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor message, or <code>null</code> if a matching vendor message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage fetchByName_Last(String key,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(key);

		if (count == 0) {
			return null;
		}

		List<VendorMessage> list = findByName(key, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vendor messages before and after the current vendor message in the ordered set where key = &#63;.
	 *
	 * @param vendorId the primary key of the current vendor message
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vendor message
	 * @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage[] findByName_PrevAndNext(long vendorId, String key,
		OrderByComparator orderByComparator)
		throws NoSuchVendorMessageException, SystemException {
		VendorMessage vendorMessage = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			VendorMessage[] array = new VendorMessageImpl[3];

			array[0] = getByName_PrevAndNext(session, vendorMessage, key,
					orderByComparator, true);

			array[1] = vendorMessage;

			array[2] = getByName_PrevAndNext(session, vendorMessage, key,
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

	protected VendorMessage getByName_PrevAndNext(Session session,
		VendorMessage vendorMessage, String key,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDORMESSAGE_WHERE);

		boolean bindKey = false;

		if (key == null) {
			query.append(_FINDER_COLUMN_NAME_KEY_1);
		}
		else if (key.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_KEY_3);
		}
		else {
			bindKey = true;

			query.append(_FINDER_COLUMN_NAME_KEY_2);
		}

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
			query.append(VendorMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindKey) {
			qPos.add(key);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendorMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VendorMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendor messages where key = &#63; from the database.
	 *
	 * @param key the key
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String key) throws SystemException {
		for (VendorMessage vendorMessage : findByName(key, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendorMessage);
		}
	}

	/**
	 * Returns the number of vendor messages where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching vendor messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDORMESSAGE_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_NAME_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_NAME_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_NAME_KEY_1 = "vendorMessage.key IS NULL";
	private static final String _FINDER_COLUMN_NAME_KEY_2 = "vendorMessage.key = ?";
	private static final String _FINDER_COLUMN_NAME_KEY_3 = "(vendorMessage.key IS NULL OR vendorMessage.key = '')";

	public VendorMessagePersistenceImpl() {
		setModelClass(VendorMessage.class);
	}

	/**
	 * Caches the vendor message in the entity cache if it is enabled.
	 *
	 * @param vendorMessage the vendor message
	 */
	@Override
	public void cacheResult(VendorMessage vendorMessage) {
		EntityCacheUtil.putResult(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageImpl.class, vendorMessage.getPrimaryKey(),
			vendorMessage);

		vendorMessage.resetOriginalValues();
	}

	/**
	 * Caches the vendor messages in the entity cache if it is enabled.
	 *
	 * @param vendorMessages the vendor messages
	 */
	@Override
	public void cacheResult(List<VendorMessage> vendorMessages) {
		for (VendorMessage vendorMessage : vendorMessages) {
			if (EntityCacheUtil.getResult(
						VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
						VendorMessageImpl.class, vendorMessage.getPrimaryKey()) == null) {
				cacheResult(vendorMessage);
			}
			else {
				vendorMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vendor messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VendorMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VendorMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vendor message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VendorMessage vendorMessage) {
		EntityCacheUtil.removeResult(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageImpl.class, vendorMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VendorMessage> vendorMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VendorMessage vendorMessage : vendorMessages) {
			EntityCacheUtil.removeResult(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
				VendorMessageImpl.class, vendorMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vendor message with the primary key. Does not add the vendor message to the database.
	 *
	 * @param vendorId the primary key for the new vendor message
	 * @return the new vendor message
	 */
	@Override
	public VendorMessage create(long vendorId) {
		VendorMessage vendorMessage = new VendorMessageImpl();

		vendorMessage.setNew(true);
		vendorMessage.setPrimaryKey(vendorId);

		return vendorMessage;
	}

	/**
	 * Removes the vendor message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vendorId the primary key of the vendor message
	 * @return the vendor message that was removed
	 * @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage remove(long vendorId)
		throws NoSuchVendorMessageException, SystemException {
		return remove((Serializable)vendorId);
	}

	/**
	 * Removes the vendor message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vendor message
	 * @return the vendor message that was removed
	 * @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage remove(Serializable primaryKey)
		throws NoSuchVendorMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VendorMessage vendorMessage = (VendorMessage)session.get(VendorMessageImpl.class,
					primaryKey);

			if (vendorMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVendorMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vendorMessage);
		}
		catch (NoSuchVendorMessageException nsee) {
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
	protected VendorMessage removeImpl(VendorMessage vendorMessage)
		throws SystemException {
		vendorMessage = toUnwrappedModel(vendorMessage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vendorMessage)) {
				vendorMessage = (VendorMessage)session.get(VendorMessageImpl.class,
						vendorMessage.getPrimaryKeyObj());
			}

			if (vendorMessage != null) {
				session.delete(vendorMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vendorMessage != null) {
			clearCache(vendorMessage);
		}

		return vendorMessage;
	}

	@Override
	public VendorMessage updateImpl(
		com.tamarack.creekridge.model.VendorMessage vendorMessage)
		throws SystemException {
		vendorMessage = toUnwrappedModel(vendorMessage);

		boolean isNew = vendorMessage.isNew();

		VendorMessageModelImpl vendorMessageModelImpl = (VendorMessageModelImpl)vendorMessage;

		Session session = null;

		try {
			session = openSession();

			if (vendorMessage.isNew()) {
				session.save(vendorMessage);

				vendorMessage.setNew(false);
			}
			else {
				session.merge(vendorMessage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VendorMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vendorMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorMessageModelImpl.getOriginalKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { vendorMessageModelImpl.getKey() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
			VendorMessageImpl.class, vendorMessage.getPrimaryKey(),
			vendorMessage);

		return vendorMessage;
	}

	protected VendorMessage toUnwrappedModel(VendorMessage vendorMessage) {
		if (vendorMessage instanceof VendorMessageImpl) {
			return vendorMessage;
		}

		VendorMessageImpl vendorMessageImpl = new VendorMessageImpl();

		vendorMessageImpl.setNew(vendorMessage.isNew());
		vendorMessageImpl.setPrimaryKey(vendorMessage.getPrimaryKey());

		vendorMessageImpl.setVendorId(vendorMessage.getVendorId());
		vendorMessageImpl.setCompanyId(vendorMessage.getCompanyId());
		vendorMessageImpl.setUserId(vendorMessage.getUserId());
		vendorMessageImpl.setUserName(vendorMessage.getUserName());
		vendorMessageImpl.setCreateDate(vendorMessage.getCreateDate());
		vendorMessageImpl.setModifiedDate(vendorMessage.getModifiedDate());
		vendorMessageImpl.setKey(vendorMessage.getKey());
		vendorMessageImpl.setValue(vendorMessage.getValue());

		return vendorMessageImpl;
	}

	/**
	 * Returns the vendor message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor message
	 * @return the vendor message
	 * @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVendorMessageException, SystemException {
		VendorMessage vendorMessage = fetchByPrimaryKey(primaryKey);

		if (vendorMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVendorMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vendorMessage;
	}

	/**
	 * Returns the vendor message with the primary key or throws a {@link com.tamarack.creekridge.NoSuchVendorMessageException} if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor message
	 * @return the vendor message
	 * @throws com.tamarack.creekridge.NoSuchVendorMessageException if a vendor message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage findByPrimaryKey(long vendorId)
		throws NoSuchVendorMessageException, SystemException {
		return findByPrimaryKey((Serializable)vendorId);
	}

	/**
	 * Returns the vendor message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor message
	 * @return the vendor message, or <code>null</code> if a vendor message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VendorMessage vendorMessage = (VendorMessage)EntityCacheUtil.getResult(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
				VendorMessageImpl.class, primaryKey);

		if (vendorMessage == _nullVendorMessage) {
			return null;
		}

		if (vendorMessage == null) {
			Session session = null;

			try {
				session = openSession();

				vendorMessage = (VendorMessage)session.get(VendorMessageImpl.class,
						primaryKey);

				if (vendorMessage != null) {
					cacheResult(vendorMessage);
				}
				else {
					EntityCacheUtil.putResult(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
						VendorMessageImpl.class, primaryKey, _nullVendorMessage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VendorMessageModelImpl.ENTITY_CACHE_ENABLED,
					VendorMessageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vendorMessage;
	}

	/**
	 * Returns the vendor message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor message
	 * @return the vendor message, or <code>null</code> if a vendor message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VendorMessage fetchByPrimaryKey(long vendorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vendorId);
	}

	/**
	 * Returns all the vendor messages.
	 *
	 * @return the vendor messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VendorMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vendor messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vendor messages
	 * @param end the upper bound of the range of vendor messages (not inclusive)
	 * @return the range of vendor messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VendorMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vendor messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.VendorMessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vendor messages
	 * @param end the upper bound of the range of vendor messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vendor messages
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VendorMessage> findAll(int start, int end,
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

		List<VendorMessage> list = (List<VendorMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENDORMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENDORMESSAGE;

				if (pagination) {
					sql = sql.concat(VendorMessageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VendorMessage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VendorMessage>(list);
				}
				else {
					list = (List<VendorMessage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vendor messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VendorMessage vendorMessage : findAll()) {
			remove(vendorMessage);
		}
	}

	/**
	 * Returns the number of vendor messages.
	 *
	 * @return the number of vendor messages
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

				Query q = session.createQuery(_SQL_COUNT_VENDORMESSAGE);

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
	 * Initializes the vendor message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.tamarack.creekridge.model.VendorMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VendorMessage>> listenersList = new ArrayList<ModelListener<VendorMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VendorMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VendorMessageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENDORMESSAGE = "SELECT vendorMessage FROM VendorMessage vendorMessage";
	private static final String _SQL_SELECT_VENDORMESSAGE_WHERE = "SELECT vendorMessage FROM VendorMessage vendorMessage WHERE ";
	private static final String _SQL_COUNT_VENDORMESSAGE = "SELECT COUNT(vendorMessage) FROM VendorMessage vendorMessage";
	private static final String _SQL_COUNT_VENDORMESSAGE_WHERE = "SELECT COUNT(vendorMessage) FROM VendorMessage vendorMessage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vendorMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VendorMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VendorMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VendorMessagePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key"
			});
	private static VendorMessage _nullVendorMessage = new VendorMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VendorMessage> toCacheModel() {
				return _nullVendorMessageCacheModel;
			}
		};

	private static CacheModel<VendorMessage> _nullVendorMessageCacheModel = new CacheModel<VendorMessage>() {
			@Override
			public VendorMessage toEntityModel() {
				return _nullVendorMessage;
			}
		};
}