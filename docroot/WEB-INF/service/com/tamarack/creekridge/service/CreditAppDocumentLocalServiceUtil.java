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

package com.tamarack.creekridge.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CreditAppDocument. This utility wraps
 * {@link com.tamarack.creekridge.service.impl.CreditAppDocumentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pmacha
 * @see CreditAppDocumentLocalService
 * @see com.tamarack.creekridge.service.base.CreditAppDocumentLocalServiceBaseImpl
 * @see com.tamarack.creekridge.service.impl.CreditAppDocumentLocalServiceImpl
 * @generated
 */
public class CreditAppDocumentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.tamarack.creekridge.service.impl.CreditAppDocumentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the credit app document to the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppDocument the credit app document
	* @return the credit app document that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppDocument addCreditAppDocument(
		com.tamarack.creekridge.model.CreditAppDocument creditAppDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCreditAppDocument(creditAppDocument);
	}

	/**
	* Creates a new credit app document with the primary key. Does not add the credit app document to the database.
	*
	* @param CreditAppDocumentId the primary key for the new credit app document
	* @return the new credit app document
	*/
	public static com.tamarack.creekridge.model.CreditAppDocument createCreditAppDocument(
		long CreditAppDocumentId) {
		return getService().createCreditAppDocument(CreditAppDocumentId);
	}

	/**
	* Deletes the credit app document with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CreditAppDocumentId the primary key of the credit app document
	* @return the credit app document that was removed
	* @throws PortalException if a credit app document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppDocument deleteCreditAppDocument(
		long CreditAppDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCreditAppDocument(CreditAppDocumentId);
	}

	/**
	* Deletes the credit app document from the database. Also notifies the appropriate model listeners.
	*
	* @param creditAppDocument the credit app document
	* @return the credit app document that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppDocument deleteCreditAppDocument(
		com.tamarack.creekridge.model.CreditAppDocument creditAppDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCreditAppDocument(creditAppDocument);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.tamarack.creekridge.model.CreditAppDocument fetchCreditAppDocument(
		long CreditAppDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCreditAppDocument(CreditAppDocumentId);
	}

	/**
	* Returns the credit app document with the primary key.
	*
	* @param CreditAppDocumentId the primary key of the credit app document
	* @return the credit app document
	* @throws PortalException if a credit app document with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppDocument getCreditAppDocument(
		long CreditAppDocumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCreditAppDocument(CreditAppDocumentId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the credit app documents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.tamarack.creekridge.model.impl.CreditAppDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of credit app documents
	* @param end the upper bound of the range of credit app documents (not inclusive)
	* @return the range of credit app documents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.tamarack.creekridge.model.CreditAppDocument> getCreditAppDocuments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCreditAppDocuments(start, end);
	}

	/**
	* Returns the number of credit app documents.
	*
	* @return the number of credit app documents
	* @throws SystemException if a system exception occurred
	*/
	public static int getCreditAppDocumentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCreditAppDocumentsCount();
	}

	/**
	* Updates the credit app document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param creditAppDocument the credit app document
	* @return the credit app document that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.tamarack.creekridge.model.CreditAppDocument updateCreditAppDocument(
		com.tamarack.creekridge.model.CreditAppDocument creditAppDocument)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCreditAppDocument(creditAppDocument);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.tamarack.creekridge.model.CreditAppDocument> getCreditAppDocumentByCreditAppId(
		long creditAppId) throws java.lang.Exception {
		return getService().getCreditAppDocumentByCreditAppId(creditAppId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CreditAppDocumentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CreditAppDocumentLocalService.class.getName());

			if (invokableLocalService instanceof CreditAppDocumentLocalService) {
				_service = (CreditAppDocumentLocalService)invokableLocalService;
			}
			else {
				_service = new CreditAppDocumentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CreditAppDocumentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CreditAppDocumentLocalService service) {
	}

	private static CreditAppDocumentLocalService _service;
}