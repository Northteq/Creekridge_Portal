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

import com.tamarack.creekridge.model.CreditAppPrincipal;

import java.util.List;

/**
 * The persistence utility for the credit app principal service. This utility wraps {@link CreditAppPrincipalPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see CreditAppPrincipalPersistence
 * @see CreditAppPrincipalPersistenceImpl
 * @generated
 */
public class CreditAppPrincipalUtil {
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
	public static void clearCache(CreditAppPrincipal creditAppPrincipal) {
		getPersistence().clearCache(creditAppPrincipal);
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
	public static List<CreditAppPrincipal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CreditAppPrincipal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CreditAppPrincipal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CreditAppPrincipal update(
		CreditAppPrincipal creditAppPrincipal) throws SystemException {
		return getPersistence().update(creditAppPrincipal);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CreditAppPrincipal update(
		CreditAppPrincipal creditAppPrincipal, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(creditAppPrincipal, serviceContext);
	}

	/**
	* Returns all the credit app principals where principalId = &#63;.
	*
	* @param principalId the principal ID
	* @return the matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findByPrincipalId(
		long principalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrincipalId(principalId);
	}

	/**
	* Returns a range of all the credit app principals where principalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param principalId the principal ID
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @return the range of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findByPrincipalId(
		long principalId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrincipalId(principalId, start, end);
	}

	/**
	* Returns an ordered range of all the credit app principals where principalId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param principalId the principal ID
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findByPrincipalId(
		long principalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPrincipalId(principalId, start, end, orderByComparator);
	}

	/**
	* Returns the first credit app principal in the ordered set where principalId = &#63;.
	*
	* @param principalId the principal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal findByPrincipalId_First(
		long principalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findByPrincipalId_First(principalId, orderByComparator);
	}

	/**
	* Returns the first credit app principal in the ordered set where principalId = &#63;.
	*
	* @param principalId the principal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal fetchByPrincipalId_First(
		long principalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrincipalId_First(principalId, orderByComparator);
	}

	/**
	* Returns the last credit app principal in the ordered set where principalId = &#63;.
	*
	* @param principalId the principal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal findByPrincipalId_Last(
		long principalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findByPrincipalId_Last(principalId, orderByComparator);
	}

	/**
	* Returns the last credit app principal in the ordered set where principalId = &#63;.
	*
	* @param principalId the principal ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal fetchByPrincipalId_Last(
		long principalId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPrincipalId_Last(principalId, orderByComparator);
	}

	/**
	* Removes all the credit app principals where principalId = &#63; from the database.
	*
	* @param principalId the principal ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPrincipalId(long principalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPrincipalId(principalId);
	}

	/**
	* Returns the number of credit app principals where principalId = &#63;.
	*
	* @param principalId the principal ID
	* @return the number of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPrincipalId(long principalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPrincipalId(principalId);
	}

	/**
	* Returns all the credit app principals where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findByCreditAppId(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId);
	}

	/**
	* Returns a range of all the credit app principals where creditAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppId the credit app ID
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @return the range of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findByCreditAppId(
		long creditAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId, start, end);
	}

	/**
	* Returns an ordered range of all the credit app principals where creditAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppId the credit app ID
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findByCreditAppId(
		long creditAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreditAppId(creditAppId, start, end, orderByComparator);
	}

	/**
	* Returns the first credit app principal in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal findByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findByCreditAppId_First(creditAppId, orderByComparator);
	}

	/**
	* Returns the first credit app principal in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal fetchByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_First(creditAppId, orderByComparator);
	}

	/**
	* Returns the last credit app principal in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal findByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findByCreditAppId_Last(creditAppId, orderByComparator);
	}

	/**
	* Returns the last credit app principal in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal fetchByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_Last(creditAppId, orderByComparator);
	}

	/**
	* Returns the credit app principals before and after the current credit app principal in the ordered set where creditAppId = &#63;.
	*
	* @param principalId the primary key of the current credit app principal
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal[] findByCreditAppId_PrevAndNext(
		long principalId, long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findByCreditAppId_PrevAndNext(principalId, creditAppId,
			orderByComparator);
	}

	/**
	* Removes all the credit app principals where creditAppId = &#63; from the database.
	*
	* @param creditAppId the credit app ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreditAppId(creditAppId);
	}

	/**
	* Returns the number of credit app principals where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the number of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreditAppId(creditAppId);
	}

	/**
	* Returns all the credit app principals where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @return the matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findBySequenceNumber(
		long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySequenceNumber(sequenceNumber);
	}

	/**
	* Returns a range of all the credit app principals where sequenceNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sequenceNumber the sequence number
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @return the range of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findBySequenceNumber(
		long sequenceNumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySequenceNumber(sequenceNumber, start, end);
	}

	/**
	* Returns an ordered range of all the credit app principals where sequenceNumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sequenceNumber the sequence number
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findBySequenceNumber(
		long sequenceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySequenceNumber(sequenceNumber, start, end,
			orderByComparator);
	}

	/**
	* Returns the first credit app principal in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal findBySequenceNumber_First(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findBySequenceNumber_First(sequenceNumber, orderByComparator);
	}

	/**
	* Returns the first credit app principal in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal fetchBySequenceNumber_First(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySequenceNumber_First(sequenceNumber,
			orderByComparator);
	}

	/**
	* Returns the last credit app principal in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal findBySequenceNumber_Last(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findBySequenceNumber_Last(sequenceNumber, orderByComparator);
	}

	/**
	* Returns the last credit app principal in the ordered set where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching credit app principal, or <code>null</code> if a matching credit app principal could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal fetchBySequenceNumber_Last(
		long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySequenceNumber_Last(sequenceNumber, orderByComparator);
	}

	/**
	* Returns the credit app principals before and after the current credit app principal in the ordered set where sequenceNumber = &#63;.
	*
	* @param principalId the primary key of the current credit app principal
	* @param sequenceNumber the sequence number
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal[] findBySequenceNumber_PrevAndNext(
		long principalId, long sequenceNumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence()
				   .findBySequenceNumber_PrevAndNext(principalId,
			sequenceNumber, orderByComparator);
	}

	/**
	* Removes all the credit app principals where sequenceNumber = &#63; from the database.
	*
	* @param sequenceNumber the sequence number
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySequenceNumber(long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySequenceNumber(sequenceNumber);
	}

	/**
	* Returns the number of credit app principals where sequenceNumber = &#63;.
	*
	* @param sequenceNumber the sequence number
	* @return the number of matching credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySequenceNumber(long sequenceNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySequenceNumber(sequenceNumber);
	}

	/**
	* Caches the credit app principal in the entity cache if it is enabled.
	*
	* @param creditAppPrincipal the credit app principal
	*/
	public static void cacheResult(
		com.tamarack.creekridge.model.CreditAppPrincipal creditAppPrincipal) {
		getPersistence().cacheResult(creditAppPrincipal);
	}

	/**
	* Caches the credit app principals in the entity cache if it is enabled.
	*
	* @param creditAppPrincipals the credit app principals
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> creditAppPrincipals) {
		getPersistence().cacheResult(creditAppPrincipals);
	}

	/**
	* Creates a new credit app principal with the primary key. Does not add the credit app principal to the database.
	*
	* @param principalId the primary key for the new credit app principal
	* @return the new credit app principal
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal create(
		long principalId) {
		return getPersistence().create(principalId);
	}

	/**
	* Removes the credit app principal with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param principalId the primary key of the credit app principal
	* @return the credit app principal that was removed
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal remove(
		long principalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence().remove(principalId);
	}

	public static com.tamarack.creekridge.model.CreditAppPrincipal updateImpl(
		com.tamarack.creekridge.model.CreditAppPrincipal creditAppPrincipal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(creditAppPrincipal);
	}

	/**
	* Returns the credit app principal with the primary key or throws a {@link com.tamarack.creekridge.NoSuchCreditAppPrincipalException} if it could not be found.
	*
	* @param principalId the primary key of the credit app principal
	* @return the credit app principal
	* @throws com.tamarack.creekridge.NoSuchCreditAppPrincipalException if a credit app principal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal findByPrimaryKey(
		long principalId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchCreditAppPrincipalException {
		return getPersistence().findByPrimaryKey(principalId);
	}

	/**
	* Returns the credit app principal with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param principalId the primary key of the credit app principal
	* @return the credit app principal, or <code>null</code> if a credit app principal with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppPrincipal fetchByPrimaryKey(
		long principalId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(principalId);
	}

	/**
	* Returns all the credit app principals.
	*
	* @return the credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the credit app principals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @return the range of credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the credit app principals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit app principals
	* @param end the upper bound of the range of credit app principals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppPrincipal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the credit app principals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of credit app principals.
	*
	* @return the number of credit app principals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CreditAppPrincipalPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CreditAppPrincipalPersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					CreditAppPrincipalPersistence.class.getName());

			ReferenceRegistry.registerReference(CreditAppPrincipalUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CreditAppPrincipalPersistence persistence) {
	}

	private static CreditAppPrincipalPersistence _persistence;
}