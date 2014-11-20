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

import com.tamarack.creekridge.model.ProposalOption;

import java.util.List;

/**
 * The persistence utility for the proposal option service. This utility wraps {@link ProposalOptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see ProposalOptionPersistence
 * @see ProposalOptionPersistenceImpl
 * @generated
 */
public class ProposalOptionUtil {
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
	public static void clearCache(ProposalOption proposalOption) {
		getPersistence().clearCache(proposalOption);
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
	public static List<ProposalOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProposalOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProposalOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ProposalOption update(ProposalOption proposalOption)
		throws SystemException {
		return getPersistence().update(proposalOption);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ProposalOption update(ProposalOption proposalOption,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(proposalOption, serviceContext);
	}

	/**
	* Returns all the proposal options where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findByCreditAppId(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId);
	}

	/**
	* Returns a range of all the proposal options where creditAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppId the credit app ID
	* @param start the lower bound of the range of proposal options
	* @param end the upper bound of the range of proposal options (not inclusive)
	* @return the range of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findByCreditAppId(
		long creditAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreditAppId(creditAppId, start, end);
	}

	/**
	* Returns an ordered range of all the proposal options where creditAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creditAppId the credit app ID
	* @param start the lower bound of the range of proposal options
	* @param end the upper bound of the range of proposal options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findByCreditAppId(
		long creditAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreditAppId(creditAppId, start, end, orderByComparator);
	}

	/**
	* Returns the first proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption findByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException {
		return getPersistence()
				   .findByCreditAppId_First(creditAppId, orderByComparator);
	}

	/**
	* Returns the first proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption fetchByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_First(creditAppId, orderByComparator);
	}

	/**
	* Returns the last proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption findByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException {
		return getPersistence()
				   .findByCreditAppId_Last(creditAppId, orderByComparator);
	}

	/**
	* Returns the last proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption fetchByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreditAppId_Last(creditAppId, orderByComparator);
	}

	/**
	* Returns the proposal options before and after the current proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param proposalOptionId the primary key of the current proposal option
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption[] findByCreditAppId_PrevAndNext(
		long proposalOptionId, long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException {
		return getPersistence()
				   .findByCreditAppId_PrevAndNext(proposalOptionId,
			creditAppId, orderByComparator);
	}

	/**
	* Removes all the proposal options where creditAppId = &#63; from the database.
	*
	* @param creditAppId the credit app ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreditAppId(creditAppId);
	}

	/**
	* Returns the number of proposal options where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the number of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreditAppId(creditAppId);
	}

	/**
	* Returns all the proposal options where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @return the matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findByProposalOptionId(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByProposalOptionId(proposalOptionId);
	}

	/**
	* Returns a range of all the proposal options where proposalOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param proposalOptionId the proposal option ID
	* @param start the lower bound of the range of proposal options
	* @param end the upper bound of the range of proposal options (not inclusive)
	* @return the range of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findByProposalOptionId(
		long proposalOptionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProposalOptionId(proposalOptionId, start, end);
	}

	/**
	* Returns an ordered range of all the proposal options where proposalOptionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param proposalOptionId the proposal option ID
	* @param start the lower bound of the range of proposal options
	* @param end the upper bound of the range of proposal options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findByProposalOptionId(
		long proposalOptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByProposalOptionId(proposalOptionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption findByProposalOptionId_First(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException {
		return getPersistence()
				   .findByProposalOptionId_First(proposalOptionId,
			orderByComparator);
	}

	/**
	* Returns the first proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption fetchByProposalOptionId_First(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProposalOptionId_First(proposalOptionId,
			orderByComparator);
	}

	/**
	* Returns the last proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption findByProposalOptionId_Last(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException {
		return getPersistence()
				   .findByProposalOptionId_Last(proposalOptionId,
			orderByComparator);
	}

	/**
	* Returns the last proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption fetchByProposalOptionId_Last(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByProposalOptionId_Last(proposalOptionId,
			orderByComparator);
	}

	/**
	* Removes all the proposal options where proposalOptionId = &#63; from the database.
	*
	* @param proposalOptionId the proposal option ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByProposalOptionId(long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByProposalOptionId(proposalOptionId);
	}

	/**
	* Returns the number of proposal options where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @return the number of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static int countByProposalOptionId(long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByProposalOptionId(proposalOptionId);
	}

	/**
	* Caches the proposal option in the entity cache if it is enabled.
	*
	* @param proposalOption the proposal option
	*/
	public static void cacheResult(
		com.tamarack.creekridge.model.ProposalOption proposalOption) {
		getPersistence().cacheResult(proposalOption);
	}

	/**
	* Caches the proposal options in the entity cache if it is enabled.
	*
	* @param proposalOptions the proposal options
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.ProposalOption> proposalOptions) {
		getPersistence().cacheResult(proposalOptions);
	}

	/**
	* Creates a new proposal option with the primary key. Does not add the proposal option to the database.
	*
	* @param proposalOptionId the primary key for the new proposal option
	* @return the new proposal option
	*/
	public static com.tamarack.creekridge.model.ProposalOption create(
		long proposalOptionId) {
		return getPersistence().create(proposalOptionId);
	}

	/**
	* Removes the proposal option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proposalOptionId the primary key of the proposal option
	* @return the proposal option that was removed
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption remove(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException {
		return getPersistence().remove(proposalOptionId);
	}

	public static com.tamarack.creekridge.model.ProposalOption updateImpl(
		com.tamarack.creekridge.model.ProposalOption proposalOption)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(proposalOption);
	}

	/**
	* Returns the proposal option with the primary key or throws a {@link com.tamarack.creekridge.NoSuchProposalOptionException} if it could not be found.
	*
	* @param proposalOptionId the primary key of the proposal option
	* @return the proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption findByPrimaryKey(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException {
		return getPersistence().findByPrimaryKey(proposalOptionId);
	}

	/**
	* Returns the proposal option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param proposalOptionId the primary key of the proposal option
	* @return the proposal option, or <code>null</code> if a proposal option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.ProposalOption fetchByPrimaryKey(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(proposalOptionId);
	}

	/**
	* Returns all the proposal options.
	*
	* @return the proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the proposal options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposal options
	* @param end the upper bound of the range of proposal options (not inclusive)
	* @return the range of proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the proposal options.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.ProposalOptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of proposal options
	* @param end the upper bound of the range of proposal options (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.ProposalOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the proposal options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of proposal options.
	*
	* @return the number of proposal options
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProposalOptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProposalOptionPersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					ProposalOptionPersistence.class.getName());

			ReferenceRegistry.registerReference(ProposalOptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProposalOptionPersistence persistence) {
	}

	private static ProposalOptionPersistence _persistence;
}