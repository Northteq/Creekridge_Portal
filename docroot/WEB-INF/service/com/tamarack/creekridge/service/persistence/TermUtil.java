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

import com.tamarack.creekridge.model.Term;

import java.util.List;

/**
 * The persistence utility for the term service. This utility wraps {@link TermPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pmacha
 * @see TermPersistence
 * @see TermPersistenceImpl
 * @generated
 */
public class TermUtil {
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
	public static void clearCache(Term term) {
		getPersistence().clearCache(term);
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
	public static List<Term> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Term> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Term> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Term update(Term term) throws SystemException {
		return getPersistence().update(term);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Term update(Term term, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(term, serviceContext);
	}

	/**
	* Returns all the terms where termId = &#63;.
	*
	* @param termId the term ID
	* @return the matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.Term> findByTermId(
		long termId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTermId(termId);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.Term> findByTermId(
		long termId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTermId(termId, start, end);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.Term> findByTermId(
		long termId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTermId(termId, start, end, orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term
	* @throws com.tamarack.creekridge.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.Term findByTermId_First(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException {
		return getPersistence().findByTermId_First(termId, orderByComparator);
	}

	/**
	* Returns the first term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.Term fetchByTermId_First(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTermId_First(termId, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term
	* @throws com.tamarack.creekridge.NoSuchTermException if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.Term findByTermId_Last(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException {
		return getPersistence().findByTermId_Last(termId, orderByComparator);
	}

	/**
	* Returns the last term in the ordered set where termId = &#63;.
	*
	* @param termId the term ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching term, or <code>null</code> if a matching term could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.Term fetchByTermId_Last(
		long termId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTermId_Last(termId, orderByComparator);
	}

	/**
	* Removes all the terms where termId = &#63; from the database.
	*
	* @param termId the term ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTermId(long termId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTermId(termId);
	}

	/**
	* Returns the number of terms where termId = &#63;.
	*
	* @param termId the term ID
	* @return the number of matching terms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTermId(long termId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTermId(termId);
	}

	/**
	* Caches the term in the entity cache if it is enabled.
	*
	* @param term the term
	*/
	public static void cacheResult(com.tamarack.creekridge.model.Term term) {
		getPersistence().cacheResult(term);
	}

	/**
	* Caches the terms in the entity cache if it is enabled.
	*
	* @param terms the terms
	*/
	public static void cacheResult(
		java.util.List<com.tamarack.creekridge.model.Term> terms) {
		getPersistence().cacheResult(terms);
	}

	/**
	* Creates a new term with the primary key. Does not add the term to the database.
	*
	* @param termId the primary key for the new term
	* @return the new term
	*/
	public static com.tamarack.creekridge.model.Term create(long termId) {
		return getPersistence().create(termId);
	}

	/**
	* Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param termId the primary key of the term
	* @return the term that was removed
	* @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.Term remove(long termId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException {
		return getPersistence().remove(termId);
	}

	public static com.tamarack.creekridge.model.Term updateImpl(
		com.tamarack.creekridge.model.Term term)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(term);
	}

	/**
	* Returns the term with the primary key or throws a {@link com.tamarack.creekridge.NoSuchTermException} if it could not be found.
	*
	* @param termId the primary key of the term
	* @return the term
	* @throws com.tamarack.creekridge.NoSuchTermException if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.Term findByPrimaryKey(
		long termId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.tamarack.creekridge.NoSuchTermException {
		return getPersistence().findByPrimaryKey(termId);
	}

	/**
	* Returns the term with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param termId the primary key of the term
	* @return the term, or <code>null</code> if a term with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.Term fetchByPrimaryKey(
		long termId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(termId);
	}

	/**
	* Returns all the terms.
	*
	* @return the terms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.Term> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.tamarack.creekridge.model.Term> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.tamarack.creekridge.model.Term> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the terms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of terms.
	*
	* @return the number of terms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TermPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TermPersistence)PortletBeanLocatorUtil.locate(com.tamarack.creekridge.service.ClpSerializer.getServletContextName(),
					TermPersistence.class.getName());

			ReferenceRegistry.registerReference(TermUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TermPersistence persistence) {
	}

	private static TermPersistence _persistence;
}