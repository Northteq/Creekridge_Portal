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

import com.liferay.portal.service.persistence.BasePersistence;

import com.tamarack.creekridge.model.CreditAppBankReference;

/**
 * The persistence interface for the credit app bank reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppBankReferencePersistenceImpl
 * @see CreditAppBankReferenceUtil
 * @generated
 */
public interface CreditAppBankReferencePersistence extends BasePersistence<CreditAppBankReference> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreditAppBankReferenceUtil} to access the credit app bank reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the credit app bank references where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findByCreditAppId(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findByCreditAppId(
		long creditAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findByCreditAppId(
		long creditAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first credit app bank reference in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app bank reference
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference findByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	/**
	* Returns the first credit app bank reference in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference fetchByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last credit app bank reference in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app bank reference
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference findByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	/**
	* Returns the last credit app bank reference in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference fetchByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.CreditAppBankReference[] findByCreditAppId_PrevAndNext(
		long bankReferenceId, long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	/**
	* Removes all the credit app bank references where creditAppId = &#63; from the database.
	*
	* @param creditAppId the credit app ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of credit app bank references where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the number of matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the credit app bank references where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @return the matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findBySequenceNumber(
		long sequenceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first credit app bank reference in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app bank reference
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference findBySequenceNumber_First(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	/**
	* Returns the first credit app bank reference in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference fetchBySequenceNumber_First(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last credit app bank reference in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app bank reference
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference findBySequenceNumber_Last(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	/**
	* Returns the last credit app bank reference in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app bank reference, or <code>null</code> if a matching credit app bank reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference fetchBySequenceNumber_Last(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.CreditAppBankReference[] findBySequenceNumber_PrevAndNext(
		long bankReferenceId, long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	/**
	* Removes all the credit app bank references where sequenceNumber = &#63; from the database.
	*
	* @param sequenceNumber the sequence number
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySequenceNumber(long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of credit app bank references where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @return the number of matching credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public int countBySequenceNumber(long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the credit app bank reference in the entity cache if it is enabled.
	*
	* @param creditAppBankReference the credit app bank reference
	*/
	public void cacheResult(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference);

	/**
	* Caches the credit app bank references in the entity cache if it is enabled.
	*
	* @param creditAppBankReferences the credit app bank references
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> creditAppBankReferences);

	/**
	* Creates a new credit app bank reference with the primary key. Does not add the credit app bank reference to the database.
	*
	* @param bankReferenceId the primary key for the new credit app bank reference
	* @return the new credit app bank reference
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference create(
		long bankReferenceId);

	/**
	* Removes the credit app bank reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference that was removed
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference remove(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	public com.tamarack.creekridge.model.CreditAppBankReference updateImpl(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the credit app bank reference with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppBankReferenceException} if it could not be found.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference
	* @throws com.tamarack.creekridge.NoSuchCreditAppBankReferenceException if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference findByPrimaryKey(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppBankReferenceException;

	/**
	* Returns the credit app bank reference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bankReferenceId the primary key of the credit app bank reference
	* @return the credit app bank reference, or <code>null</code> if a credit app bank reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppBankReference fetchByPrimaryKey(
		long bankReferenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the credit app bank references.
	*
	* @return the credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppBankReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the credit app bank references from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of credit app bank references.
	*
	* @return the number of credit app bank references
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}