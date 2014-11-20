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

import com.tamarack.creekridge.model.Term;

/**
 * The persistence interface for the term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see TermPersistenceImpl
 * @see TermUtil
 * @generated
 */
public interface TermPersistence extends BasePersistence<Term> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TermUtil} to access the term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the terms where termId = &#63;.
	*
	* @param termId the term ID
	* @return the matching terms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Term> findByTermId(
		long termId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the terms where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @return the range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Term> findByTermId(
		long termId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the terms where termId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param termId the term ID
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Term> findByTermId(
		long termId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term
	* @throws com.tamarack.creekridge.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Term findByTermId_First(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException;

	/**
	* Returns the first term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Term fetchByTermId_First(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term
	* @throws com.tamarack.creekridge.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Term findByTermId_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException;

	/**
	* Returns the last term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Term fetchByTermId_Last(long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the terms where termId = &#63; from the database.
	*
	* @param termId the term ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTermId(long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of terms where termId = &#63;.
	*
	* @param termId the term ID
	* @return the number of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public int countByTermId(long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the term in the entity cache if it is enabled.
	*
	* @param term the term
	*/
	public void cacheResult(com.tamarack.creekridge.model.Term term);

	/**
	* Caches the terms in the entity cache if it is enabled.
	*
	* @param terms the terms
	*/
	public void cacheResult(
		java.util.List<com.tamarack.creekridge.model.Term> terms);

	/**
	* Creates a new term with the primary key. Does not add the term to the database.
	*
	* @param termId the primary key for the new term
	* @return the new term
	*/
	public com.tamarack.creekridge.model.Term create(long termId);

	/**
	* Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param termId the primary key of the term
	* @return the term that was removed
	* @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Term remove(long termId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException;

	public com.tamarack.creekridge.model.Term updateImpl(
		com.tamarack.creekridge.model.Term term)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the term with the primary key or throws a {@link com.tamarack.creekridge.NoSuchTermException} if it could not be found.
	*
	* @param termId the primary key of the term
	* @return the term
	* @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Term findByPrimaryKey(long termId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException;

	/**
	* Returns the term with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param termId the primary key of the term
	* @return the term, or <code>null</code> if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.tamarack.creekridge.model.Term fetchByPrimaryKey(long termId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the terms.
	*
	* @return the terms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Term> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the terms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @return the range of terms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Term> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the terms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.TermModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of terms
	* @param end the upper bound of the range of terms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of terms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.tamarack.creekridge.model.Term> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the terms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of terms.
	*
	* @return the number of terms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}