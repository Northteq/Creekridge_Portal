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

package com.tamarack.creekridge.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CreditAppDocument}.
 * </p>
 *
 * @author pmacha
 * @see CreditAppDocument
 * @generated
 */
public class CreditAppDocumentWrapper implements CreditAppDocument,
	ModelWrapper<CreditAppDocument> {
	public CreditAppDocumentWrapper(CreditAppDocument creditAppDocument) {
		_creditAppDocument = creditAppDocument;
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppDocument.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CreditAppDocumentId", getCreditAppDocumentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("documentTitle", getDocumentTitle());
		attributes.put("documentFileName", getDocumentFileName());
		attributes.put("documentFileLocation", getDocumentFileLocation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long CreditAppDocumentId = (Long)attributes.get("CreditAppDocumentId");

		if (CreditAppDocumentId != null) {
			setCreditAppDocumentId(CreditAppDocumentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long creditAppId = (Long)attributes.get("creditAppId");

		if (creditAppId != null) {
			setCreditAppId(creditAppId);
		}

		Long sequenceNumber = (Long)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}

		String documentTitle = (String)attributes.get("documentTitle");

		if (documentTitle != null) {
			setDocumentTitle(documentTitle);
		}

		String documentFileName = (String)attributes.get("documentFileName");

		if (documentFileName != null) {
			setDocumentFileName(documentFileName);
		}

		String documentFileLocation = (String)attributes.get(
				"documentFileLocation");

		if (documentFileLocation != null) {
			setDocumentFileLocation(documentFileLocation);
		}
	}

	/**
	* Returns the primary key of this credit app document.
	*
	* @return the primary key of this credit app document
	*/
	@Override
	public long getPrimaryKey() {
		return _creditAppDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this credit app document.
	*
	* @param primaryKey the primary key of this credit app document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creditAppDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the credit app document ID of this credit app document.
	*
	* @return the credit app document ID of this credit app document
	*/
	@Override
	public long getCreditAppDocumentId() {
		return _creditAppDocument.getCreditAppDocumentId();
	}

	/**
	* Sets the credit app document ID of this credit app document.
	*
	* @param CreditAppDocumentId the credit app document ID of this credit app document
	*/
	@Override
	public void setCreditAppDocumentId(long CreditAppDocumentId) {
		_creditAppDocument.setCreditAppDocumentId(CreditAppDocumentId);
	}

	/**
	* Returns the company ID of this credit app document.
	*
	* @return the company ID of this credit app document
	*/
	@Override
	public long getCompanyId() {
		return _creditAppDocument.getCompanyId();
	}

	/**
	* Sets the company ID of this credit app document.
	*
	* @param companyId the company ID of this credit app document
	*/
	@Override
	public void setCompanyId(long companyId) {
		_creditAppDocument.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this credit app document.
	*
	* @return the user ID of this credit app document
	*/
	@Override
	public long getUserId() {
		return _creditAppDocument.getUserId();
	}

	/**
	* Sets the user ID of this credit app document.
	*
	* @param userId the user ID of this credit app document
	*/
	@Override
	public void setUserId(long userId) {
		_creditAppDocument.setUserId(userId);
	}

	/**
	* Returns the user uuid of this credit app document.
	*
	* @return the user uuid of this credit app document
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppDocument.getUserUuid();
	}

	/**
	* Sets the user uuid of this credit app document.
	*
	* @param userUuid the user uuid of this credit app document
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_creditAppDocument.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this credit app document.
	*
	* @return the user name of this credit app document
	*/
	@Override
	public java.lang.String getUserName() {
		return _creditAppDocument.getUserName();
	}

	/**
	* Sets the user name of this credit app document.
	*
	* @param userName the user name of this credit app document
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_creditAppDocument.setUserName(userName);
	}

	/**
	* Returns the create date of this credit app document.
	*
	* @return the create date of this credit app document
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _creditAppDocument.getCreateDate();
	}

	/**
	* Sets the create date of this credit app document.
	*
	* @param createDate the create date of this credit app document
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_creditAppDocument.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this credit app document.
	*
	* @return the modified date of this credit app document
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _creditAppDocument.getModifiedDate();
	}

	/**
	* Sets the modified date of this credit app document.
	*
	* @param modifiedDate the modified date of this credit app document
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_creditAppDocument.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the credit app ID of this credit app document.
	*
	* @return the credit app ID of this credit app document
	*/
	@Override
	public long getCreditAppId() {
		return _creditAppDocument.getCreditAppId();
	}

	/**
	* Sets the credit app ID of this credit app document.
	*
	* @param creditAppId the credit app ID of this credit app document
	*/
	@Override
	public void setCreditAppId(long creditAppId) {
		_creditAppDocument.setCreditAppId(creditAppId);
	}

	/**
	* Returns the sequence number of this credit app document.
	*
	* @return the sequence number of this credit app document
	*/
	@Override
	public long getSequenceNumber() {
		return _creditAppDocument.getSequenceNumber();
	}

	/**
	* Sets the sequence number of this credit app document.
	*
	* @param sequenceNumber the sequence number of this credit app document
	*/
	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_creditAppDocument.setSequenceNumber(sequenceNumber);
	}

	/**
	* Returns the document title of this credit app document.
	*
	* @return the document title of this credit app document
	*/
	@Override
	public java.lang.String getDocumentTitle() {
		return _creditAppDocument.getDocumentTitle();
	}

	/**
	* Sets the document title of this credit app document.
	*
	* @param documentTitle the document title of this credit app document
	*/
	@Override
	public void setDocumentTitle(java.lang.String documentTitle) {
		_creditAppDocument.setDocumentTitle(documentTitle);
	}

	/**
	* Returns the document file name of this credit app document.
	*
	* @return the document file name of this credit app document
	*/
	@Override
	public java.lang.String getDocumentFileName() {
		return _creditAppDocument.getDocumentFileName();
	}

	/**
	* Sets the document file name of this credit app document.
	*
	* @param documentFileName the document file name of this credit app document
	*/
	@Override
	public void setDocumentFileName(java.lang.String documentFileName) {
		_creditAppDocument.setDocumentFileName(documentFileName);
	}

	/**
	* Returns the document file location of this credit app document.
	*
	* @return the document file location of this credit app document
	*/
	@Override
	public java.lang.String getDocumentFileLocation() {
		return _creditAppDocument.getDocumentFileLocation();
	}

	/**
	* Sets the document file location of this credit app document.
	*
	* @param documentFileLocation the document file location of this credit app document
	*/
	@Override
	public void setDocumentFileLocation(java.lang.String documentFileLocation) {
		_creditAppDocument.setDocumentFileLocation(documentFileLocation);
	}

	@Override
	public boolean isNew() {
		return _creditAppDocument.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_creditAppDocument.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _creditAppDocument.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creditAppDocument.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _creditAppDocument.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _creditAppDocument.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_creditAppDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _creditAppDocument.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_creditAppDocument.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_creditAppDocument.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_creditAppDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CreditAppDocumentWrapper((CreditAppDocument)_creditAppDocument.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.CreditAppDocument creditAppDocument) {
		return _creditAppDocument.compareTo(creditAppDocument);
	}

	@Override
	public int hashCode() {
		return _creditAppDocument.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.CreditAppDocument> toCacheModel() {
		return _creditAppDocument.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppDocument toEscapedModel() {
		return new CreditAppDocumentWrapper(_creditAppDocument.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppDocument toUnescapedModel() {
		return new CreditAppDocumentWrapper(_creditAppDocument.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _creditAppDocument.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _creditAppDocument.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_creditAppDocument.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppDocumentWrapper)) {
			return false;
		}

		CreditAppDocumentWrapper creditAppDocumentWrapper = (CreditAppDocumentWrapper)obj;

		if (Validator.equals(_creditAppDocument,
					creditAppDocumentWrapper._creditAppDocument)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CreditAppDocument getWrappedCreditAppDocument() {
		return _creditAppDocument;
	}

	@Override
	public CreditAppDocument getWrappedModel() {
		return _creditAppDocument;
	}

	@Override
	public void resetOriginalValues() {
		_creditAppDocument.resetOriginalValues();
	}

	private CreditAppDocument _creditAppDocument;
}