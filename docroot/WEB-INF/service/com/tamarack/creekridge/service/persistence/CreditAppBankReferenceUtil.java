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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.tamarack.creekridge.model.CreditAppBankReference;

import java.util.List;

/**
 * The persistence utility for the credit app bank reference service. This utility wraps {@link CreditAppBankReferencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppBankReferencePersistence
 * @see CreditAppBankReferencePersistenceImpl
 * @generated
 */
public class CreditAppBankReferenceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CreditAppBankReference creditAppBankReference) {
		getPersistence().clearCache(creditAppBankReference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CreditAppBankReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CreditAppBankReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CreditAppBankReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CreditAppBankReference update(
		CreditAppBankReference creditAppBankReference)
		throws SystemException {
		return getPersistence().update(creditAppBankReference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CreditAppBankReference update(
		CreditAppBankReference creditAppBankReference,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(creditAppBankReference, serviceContext);
	}

	/**
	* Returns all the credit app bank references where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findByCreditAppId(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId);
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
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findByCreditAppId(
		long creditAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId, start, end);
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
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findByCreditAppId(
		long creditAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreditAppId(creditAppId, start, end, orderByComparator);
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
	public static com.tamarack.creekridge.model.CreditAppBankReference findByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence()
				   .findByCreditAppId_First(creditAppId, orderByComparator);
	}

	/**
	* Returns the first credit app bank reference in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference fetchByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_First(creditAppId, orderByComparator);
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
	public static com.tamarack.creekridge.model.CreditAppBankReference findByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence()
				   .findByCreditAppId_Last(creditAppId, orderByComparator);
	}

	/**
	* Returns the last credit app bank reference in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference fetchByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_Last(creditAppId, orderByComparator);
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
	public static com.tamarack.creekridge.model.CreditAppBankReference[] findByCreditAppId_PrevAndNext(
		long bankReferenceId, long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence()
				   .findByCreditAppId_PrevAndNext(bankReferenceId, creditAppId,
			orderByComparator);
	}

	/**
	* Removes all the credit app bank references where creditAppId = &#63; from the database.
	*
	* @param creditAppId the credit app ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreditAppId(creditAppId);
	}

	/**
	* Returns the number of credit app bank references where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the number of matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreditAppId(creditAppId);
	}

	/**
	* Returns all the credit app bank references where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @return the matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySequenceNumber(sequenceNumber);
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
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySequenceNumber(sequenceNumber, start, end);
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
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySequenceNumber(sequenceNumber, start, end,
			orderByComparator);
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
	public static com.tamarack.creekridge.model.CreditAppBankReference findBySequenceNumber_First(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence()
				   .findBySequenceNumber_First(sequenceNumber, orderByComparator);
	}

	/**
	* Returns the first credit app bank reference in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference fetchBySequenceNumber_First(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySequenceNumber_First(sequenceNumber,
			orderByComparator);
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
	public static com.tamarack.creekridge.model.CreditAppBankReference findBySequenceNumber_Last(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence()
				   .findBySequenceNumber_Last(sequenceNumber, orderByComparator);
	}

	/**
	* Returns the last credit app bank reference in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference fetchBySequenceNumber_Last(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySequenceNumber_Last(sequenceNumber, orderByComparator);
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
	public static com.tamarack.creekridge.model.CreditAppBankReference[] findBySequenceNumber_PrevAndNext(
		long bankReferenceId, long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence()
				   .findBySequenceNumber_PrevAndNext(bankReferenceId,
			sequenceNumber, orderByComparator);
	}

	/**
	* Removes all the credit app bank references where sequenceNumber = &#63; from the database.
	*
	* @param sequenceNumber the sequence number
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySequenceNumber(long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySequenceNumber(sequenceNumber);
	}

	/**
	* Returns the number of credit app bank references where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @return the number of matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySequenceNumber(long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySequenceNumber(sequenceNumber);
	}

	/**
	* Caches the credit app bank reference in the entity cache if it is enabled.
	*
	* @param creditAppBankReference the credit app bank reference
	*/
	public static void cacheResult(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference) {
		getPersistence().cacheResult(creditAppBankReference);
	}

	/**
	* Caches the credit app bank references in the entity cache if it is enabled.
	*
	* @param creditAppBankReferences the credit app bank references
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> creditAppBankReferences) {
		getPersistence().cacheResult(creditAppBankReferences);
	}

	/**
	* Creates a new credit app bank reference with the primary key. Does not add the credit app bank reference to the database.
	*
	* @param bankReferenceId the primary key for the new credit app bank reference
	* @return the new credit app bank reference
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference create(
		long bankReferenceId) {
		return getPersistence().create(bankReferenceId);
	}

	/**
	* Removes the credit app bank reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference that was removed
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference remove(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence().remove(bankReferenceId);
	}

	public static com.tamarack.creekridge.model.CreditAppBankReference updateImpl(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(creditAppBankReference);
	}

	/**
	* Returns the credit app bank reference with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppBankReferenceException} if it could not be found.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference findByPrimaryKey(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException {
		return getPersistence().findByPrimaryKey(bankReferenceId);
	}

	/**
	* Returns the credit app bank reference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference, or <code>null</code> if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppBankReference fetchByPrimaryKey(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bankReferenceId);
	}

	/**
	* Returns all the credit app bank references.
	*
	* @return the credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the credit app bank references from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of credit app bank references.
	*
	* @return the number of credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CreditAppBankReferencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CreditAppBankReferencePersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					CreditAppBankReferencePersistence.class.getName());

			ReferenceRegistry.registerReference(CreditAppBankReferenceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CreditAppBankReferencePersistence persistence) {
	}

	private static CreditAppBankReferencePersistence _persistence;
}