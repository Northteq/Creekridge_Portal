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

import com.tamarack.creekridge.model.ProposalOption;

/**
 * The persistence interface for the proposal option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see ProposalOptionPersistenceImpl
 * @see ProposalOptionUtil
 * @generated
 */
public interface ProposalOptionPersistence extends BasePersistence<ProposalOption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProposalOptionUtil} to access the proposal option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the proposal options where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findByCreditAppId(
		long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findByCreditAppId(
		long creditAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findByCreditAppId(
		long creditAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption findByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException;

	/**
	* Returns the first proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption fetchByCreditAppId_First(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption findByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException;

	/**
	* Returns the last proposal option in the ordered set where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption fetchByCreditAppId_Last(
		long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.tamarack.creekridge.model.ProposalOption[] findByCreditAppId_PrevAndNext(
		long proposalOptionId, long creditAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException;

	/**
	* Removes all the proposal options where creditAppId = &#63; from the database.
	*
	* @param creditAppId the credit app ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposal options where creditAppId = &#63;.
	*
	* @param creditAppId the credit app ID
	* @return the number of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreditAppId(long creditAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the proposal options where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @return the matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findByProposalOptionId(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findByProposalOptionId(
		long proposalOptionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findByProposalOptionId(
		long proposalOptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption findByProposalOptionId_First(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException;

	/**
	* Returns the first proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption fetchByProposalOptionId_First(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption findByProposalOptionId_Last(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException;

	/**
	* Returns the last proposal option in the ordered set where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching proposal option, or <code>null</code> if a matching proposal option could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption fetchByProposalOptionId_Last(
		long proposalOptionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposal options where proposalOptionId = &#63; from the database.
	*
	* @param proposalOptionId the proposal option ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProposalOptionId(long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposal options where proposalOptionId = &#63;.
	*
	* @param proposalOptionId the proposal option ID
	* @return the number of matching proposal options
	* @throws SystemException if a system exception occurred
	*/
	public int countByProposalOptionId(long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the proposal option in the entity cache if it is enabled.
	*
	* @param proposalOption the proposal option
	*/
	public void cacheResult(
		com.tamarack.creekridge.model.ProposalOption proposalOption);

	/**
	* Caches the proposal options in the entity cache if it is enabled.
	*
	* @param proposalOptions the proposal options
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.ProposalOption> proposalOptions);

	/**
	* Creates a new proposal option with the primary key. Does not add the proposal option to the database.
	*
	* @param proposalOptionId the primary key for the new proposal option
	* @return the new proposal option
	*/
	public com.tamarack.creekridge.model.ProposalOption create(
		long proposalOptionId);

	/**
	* Removes the proposal option with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param proposalOptionId the primary key of the proposal option
	* @return the proposal option that was removed
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption remove(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException;

	public com.tamarack.creekridge.model.ProposalOption updateImpl(
		com.tamarack.creekridge.model.ProposalOption proposalOption)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the proposal option with the primary key or throws a {@link com.tamarack.creekridge.NoSuchProposalOptionException} if it could not be found.
	*
	* @param proposalOptionId the primary key of the proposal option
	* @return the proposal option
	* @throws com.tamarack.creekridge.NoSuchProposalOptionException if a proposal option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption findByPrimaryKey(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchProposalOptionException;

	/**
	* Returns the proposal option with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param proposalOptionId the primary key of the proposal option
	* @return the proposal option, or <code>null</code> if a proposal option with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.ProposalOption fetchByPrimaryKey(
		long proposalOptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the proposal options.
	*
	* @return the proposal options
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.tamarack.creekridge.model.ProposalOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the proposal options from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of proposal options.
	*
	* @return the number of proposal options
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}