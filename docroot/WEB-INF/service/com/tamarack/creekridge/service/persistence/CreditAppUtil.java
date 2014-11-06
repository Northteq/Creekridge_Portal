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

import com.tamarack.creekridge.model.CreditApp;

import java.util.List;

/**
 * The persistence utility for the credit app service. This utility wraps {@link CreditAppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppPersistence
 * @see CreditAppPersistenceImpl
 * @generated
 */
public class CreditAppUtil {
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
	public static void clearCache(CreditApp creditApp) {
		getPersistence().clearCache(creditApp);
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
	public static List<CreditApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CreditApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CreditApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CreditApp update(CreditApp creditApp)
		throws SystemException {
		return getPersistence().update(creditApp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CreditApp update(CreditApp creditApp,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(creditApp, serviceContext);
	}

	/**
	* Returns all the credit apps where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppId(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppId(
		long creditAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId, start, end);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppId(
		long creditAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreditAppId(creditAppId, start, end, orderByComparator);
	}

	/**
	* Returns the first credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp findByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException {
		return getPersistence()
				   .findByCreditAppId_First(creditAppId, orderByComparator);
	}

	/**
	* Returns the first credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp fetchByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_First(creditAppId, orderByComparator);
	}

	/**
	* Returns the last credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp findByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException {
		return getPersistence()
				   .findByCreditAppId_Last(creditAppId, orderByComparator);
	}

	/**
	* Returns the last credit app in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp fetchByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_Last(creditAppId, orderByComparator);
	}

	/**
	* Removes all the credit apps where creditAppId = &#63; from the database.
	*
	* @param creditAppId the credit app ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreditAppId(creditAppId);
	}

	/**
	* Returns the number of credit apps where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the number of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreditAppId(creditAppId);
	}

	/**
	* Returns all the credit apps where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @return the matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppStatusId(
		long creditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppStatusId(creditAppStatusId);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppStatusId(
		long creditAppStatusId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreditAppStatusId(creditAppStatusId, start, end);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findByCreditAppStatusId(
		long creditAppStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreditAppStatusId(creditAppStatusId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp findByCreditAppStatusId_First(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException {
		return getPersistence()
				   .findByCreditAppStatusId_First(creditAppStatusId,
			orderByComparator);
	}

	/**
	* Returns the first credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp fetchByCreditAppStatusId_First(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppStatusId_First(creditAppStatusId,
			orderByComparator);
	}

	/**
	* Returns the last credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp findByCreditAppStatusId_Last(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException {
		return getPersistence()
				   .findByCreditAppStatusId_Last(creditAppStatusId,
			orderByComparator);
	}

	/**
	* Returns the last credit app in the ordered set where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app, or <code>null</code> if a matching credit app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp fetchByCreditAppStatusId_Last(
		long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppStatusId_Last(creditAppStatusId,
			orderByComparator);
	}

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
	public static com.tamarack.creekridge.model.CreditApp[] findByCreditAppStatusId_PrevAndNext(
		long creditAppId, long creditAppStatusId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException {
		return getPersistence()
				   .findByCreditAppStatusId_PrevAndNext(creditAppId,
			creditAppStatusId, orderByComparator);
	}

	/**
	* Removes all the credit apps where creditAppStatusId = &#63; from the database.
	*
	* @param creditAppStatusId the credit app status ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreditAppStatusId(long creditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreditAppStatusId(creditAppStatusId);
	}

	/**
	* Returns the number of credit apps where creditAppStatusId = &#63;.
	*
	* @param creditAppStatusId the credit app status ID
	* @return the number of matching credit apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreditAppStatusId(long creditAppStatusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreditAppStatusId(creditAppStatusId);
	}

	/**
	* Caches the credit app in the entity cache if it is enabled.
	*
	* @param creditApp the credit app
	*/
	public static void cacheResult(
		com.tamarack.creekridge.model.CreditApp creditApp) {
		getPersistence().cacheResult(creditApp);
	}

	/**
	* Caches the credit apps in the entity cache if it is enabled.
	*
	* @param creditApps the credit apps
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.CreditApp> creditApps) {
		getPersistence().cacheResult(creditApps);
	}

	/**
	* Creates a new credit app with the primary key. Does not add the credit app to the database.
	*
	* @param creditAppId the primary key for the new credit app
	* @return the new credit app
	*/
	public static com.tamarack.creekridge.model.CreditApp create(
		long creditAppId) {
		return getPersistence().create(creditAppId);
	}

	/**
	* Removes the credit app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app that was removed
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp remove(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException {
		return getPersistence().remove(creditAppId);
	}

	public static com.tamarack.creekridge.model.CreditApp updateImpl(
		com.tamarack.creekridge.model.CreditApp creditApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(creditApp);
	}

	/**
	* Returns the credit app with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppException} if it could not be found.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app
	* @throws com.tamarack.creekridge.NoSuchCreditAppException if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp findByPrimaryKey(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppException {
		return getPersistence().findByPrimaryKey(creditAppId);
	}

	/**
	* Returns the credit app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param creditAppId the primary key of the credit app
	* @return the credit app, or <code>null</code> if a credit app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditApp fetchByPrimaryKey(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(creditAppId);
	}

	/**
	* Returns all the credit apps.
	*
	* @return the credit apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.CreditApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the credit apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of credit apps.
	*
	* @return the number of credit apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CreditAppPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CreditAppPersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					CreditAppPersistence.class.getName());

			ReferenceRegistry.registerReference(CreditAppUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CreditAppPersistence persistence) {
	}

	private static CreditAppPersistence _persistence;
}