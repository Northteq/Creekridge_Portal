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

import com.tamarack.creekridge.model.CreditApp;

/**
 * The persistence interface for the credit app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppPersistenceImpl
 * @see CreditAppUtil
 * @generated
 */
public interface CreditAppPersistence extends BasePersistence<CreditApp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CreditAppUtil} to access the credit app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the credit apps where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppId(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the credit apps where creditAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppId the credit app ID
	* @param start the lower bound of the range of credit apps
	* @param end the upper bound of the range of credit apps (not inclusive)
	* @return the range of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppId(
		long creditAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the credit apps where creditAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppId the credit app ID
	* @param start the lower bound of the range of credit apps
	* @param end the upper bound of the range of credit apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppId(
		long creditAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp findByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException;

	/**
	* Returns the first credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp fetchByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp findByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException;

	/**
	* Returns the last credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp fetchByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the credit apps where creditAppId = &#63; from the database.
	*
	* @param creditAppId the credit app ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of credit apps where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the number of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the credit apps where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @return the matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppStatusId(
		long creditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the credit apps where creditAppStatusId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppStatusId the credit app status ID
	* @param start the lower bound of the range of credit apps
	* @param end the upper bound of the range of credit apps (not inclusive)
	* @return the range of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppStatusId(
		long creditAppStatusId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the credit apps where creditAppStatusId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppStatusId the credit app status ID
	* @param start the lower bound of the range of credit apps
	* @param end the upper bound of the range of credit apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppStatusId(
		long creditAppStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp findByCreditAppStatusId_First(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException;

	/**
	* Returns the first credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp fetchByCreditAppStatusId_First(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp findByCreditAppStatusId_Last(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException;

	/**
	* Returns the last credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp fetchByCreditAppStatusId_Last(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the credit apps before and after the current credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppId the primary key of the current credit app
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp[] findByCreditAppStatusId_PrevAndNext(
		long creditAppId, long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException;

	/**
	* Removes all the credit apps where creditAppStatusId = &#63; from the database.
	*
	* @param creditAppStatusId the credit app status ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreditAppStatusId(long creditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of credit apps where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @return the number of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreditAppStatusId(long creditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the credit app in the entity cache if it is enabled.
	*
	* @param creditApp the credit app
	*/
	public void cacheResult(com.tamarack.creekridge.model.CreditApp creditApp);

	/**
	* Caches the credit apps in the entity cache if it is enabled.
	*
	* @param creditApps the credit apps
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.CreditApp> creditApps);

	/**
	* Creates a new credit app with the primary key. Does not add the credit app to the database.
	*
	* @param creditAppId the primary key for the new credit app
	* @return the new credit app
	*/
	public com.tamarack.creekridge.model.CreditApp create(long creditAppId);

	/**
	* Removes the credit app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app that was removed
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp remove(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException;

	public com.tamarack.creekridge.model.CreditApp updateImpl(
		com.tamarack.creekridge.model.CreditApp creditApp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the credit app with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppException} if it could not be found.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp findByPrimaryKey(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException;

	/**
	* Returns the credit app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app, or <code>null</code> if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.CreditApp fetchByPrimaryKey(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the credit apps.
	*
	* @return the credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the credit apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit apps
	* @param end the upper bound of the range of credit apps (not inclusive)
	* @return the range of credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the credit apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit apps
	* @param end the upper bound of the range of credit apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of credit apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.CreditApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the credit apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of credit apps.
	*
	* @return the number of credit apps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}