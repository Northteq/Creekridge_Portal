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

import com.tamarack.creekridge.model.CreditAppStatus;

/**
 * The persistence interface for the credit app status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppStatusPersistenceImpl
 * @see CreditAppStatusUtil
 * @generated
 */
public interface CreditAppStatusPersistence extends BasePersistence<CreditAppStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreditAppStatusUtil} to access the credit app status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the credit app status where creditAppStatusName = &#63; or throws a {@link com.tamarack.creekridge.NoSuchCreditAppStatusException} if it could not be found.
	*
	* @param creditAppStatusName the credit app status name
	* @return the matching credit app status
	* @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a matching credit app status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppStatus findByCreditAppStatusName(
		java.lang.String creditAppStatusName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppStatusException;

	/**
	* Returns the credit app status where creditAppStatusName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param creditAppStatusName the credit app status name
	* @return the matching credit app status, or <code>null</code> if a matching credit app status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppStatus fetchByCreditAppStatusName(
		java.lang.String creditAppStatusName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the credit app status where creditAppStatusName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param creditAppStatusName the credit app status name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching credit app status, or <code>null</code> if a matching credit app status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppStatus fetchByCreditAppStatusName(
		java.lang.String creditAppStatusName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the credit app status where creditAppStatusName = &#63; from the database.
	*
	* @param creditAppStatusName the credit app status name
	* @return the credit app status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppStatus removeByCreditAppStatusName(
		java.lang.String creditAppStatusName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppStatusException;

	/**
	* Returns the number of credit app statuses where creditAppStatusName = &#63;.
	*
	* @param creditAppStatusName the credit app status name
	* @return the number of matching credit app statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreditAppStatusName(java.lang.String creditAppStatusName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the credit app status in the entity cache if it is enabled.
	*
	* @param creditAppStatus the credit app status
	*/
	public void cacheResult(
		com.tamarack.creekridge.model.CreditAppStatus creditAppStatus);

	/**
	* Caches the credit app statuses in the entity cache if it is enabled.
	*
	* @param creditAppStatuses the credit app statuses
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.CreditAppStatus> creditAppStatuses);

	/**
	* Creates a new credit app status with the primary key. Does not add the credit app status to the database.
	*
	* @param CreditAppStatusId the primary key for the new credit app status
	* @return the new credit app status
	*/
	public com.tamarack.creekridge.model.CreditAppStatus create(
		long CreditAppStatusId);

	/**
	* Removes the credit app status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CreditAppStatusId the primary key of the credit app status
	* @return the credit app status that was removed
	* @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a credit app status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppStatus remove(
		long CreditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppStatusException;

	public com.tamarack.creekridge.model.CreditAppStatus updateImpl(
		com.tamarack.creekridge.model.CreditAppStatus creditAppStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the credit app status with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppStatusException} if it could not be found.
	*
	* @param CreditAppStatusId the primary key of the credit app status
	* @return the credit app status
	* @throws com.tamarack.creekridge.NoSuchCreditAppStatusException if a credit app status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppStatus findByPrimaryKey(
		long CreditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppStatusException;

	/**
	* Returns the credit app status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CreditAppStatusId the primary key of the credit app status
	* @return the credit app status, or <code>null</code> if a credit app status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditAppStatus fetchByPrimaryKey(
		long CreditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the credit app statuses.
	*
	* @return the credit app statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditAppStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.CreditAppStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the credit app statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of credit app statuses.
	*
	* @return the number of credit app statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}