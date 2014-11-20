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
 * This class is a wrapper for {@link CreditAppBankReference}.
 * </p>
 *
 * @author pmacha
 * @see CreditAppBankReference
 * @generated
 */
public class CreditAppBankReferenceWrapper implements CreditAppBankReference,
	ModelWrapper<CreditAppBankReference> {
	public CreditAppBankReferenceWrapper(
		CreditAppBankReference creditAppBankReference) {
		_creditAppBankReference = creditAppBankReference;
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppBankReference.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppBankReference.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bankReferenceId", getBankReferenceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("bankReferenceName", getBankReferenceName());
		attributes.put("bankReferenceContact", getBankReferenceContact());
		attributes.put("bankReferencePhone", getBankReferencePhone());
		attributes.put("bankReferencAccountType", getBankReferencAccountType());
		attributes.put("bankReferenceAccountNumber",
			getBankReferenceAccountNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bankReferenceId = (Long)attributes.get("bankReferenceId");

		if (bankReferenceId != null) {
			setBankReferenceId(bankReferenceId);
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

		String bankReferenceName = (String)attributes.get("bankReferenceName");

		if (bankReferenceName != null) {
			setBankReferenceName(bankReferenceName);
		}

		String bankReferenceContact = (String)attributes.get(
				"bankReferenceContact");

		if (bankReferenceContact != null) {
			setBankReferenceContact(bankReferenceContact);
		}

		String bankReferencePhone = (String)attributes.get("bankReferencePhone");

		if (bankReferencePhone != null) {
			setBankReferencePhone(bankReferencePhone);
		}

		String bankReferencAccountType = (String)attributes.get(
				"bankReferencAccountType");

		if (bankReferencAccountType != null) {
			setBankReferencAccountType(bankReferencAccountType);
		}

		String bankReferenceAccountNumber = (String)attributes.get(
				"bankReferenceAccountNumber");

		if (bankReferenceAccountNumber != null) {
			setBankReferenceAccountNumber(bankReferenceAccountNumber);
		}
	}

	/**
	* Returns the primary key of this credit app bank reference.
	*
	* @return the primary key of this credit app bank reference
	*/
	@Override
	public long getPrimaryKey() {
		return _creditAppBankReference.getPrimaryKey();
	}

	/**
	* Sets the primary key of this credit app bank reference.
	*
	* @param primaryKey the primary key of this credit app bank reference
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creditAppBankReference.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bank reference ID of this credit app bank reference.
	*
	* @return the bank reference ID of this credit app bank reference
	*/
	@Override
	public long getBankReferenceId() {
		return _creditAppBankReference.getBankReferenceId();
	}

	/**
	* Sets the bank reference ID of this credit app bank reference.
	*
	* @param bankReferenceId the bank reference ID of this credit app bank reference
	*/
	@Override
	public void setBankReferenceId(long bankReferenceId) {
		_creditAppBankReference.setBankReferenceId(bankReferenceId);
	}

	/**
	* Returns the company ID of this credit app bank reference.
	*
	* @return the company ID of this credit app bank reference
	*/
	@Override
	public long getCompanyId() {
		return _creditAppBankReference.getCompanyId();
	}

	/**
	* Sets the company ID of this credit app bank reference.
	*
	* @param companyId the company ID of this credit app bank reference
	*/
	@Override
	public void setCompanyId(long companyId) {
		_creditAppBankReference.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this credit app bank reference.
	*
	* @return the user ID of this credit app bank reference
	*/
	@Override
	public long getUserId() {
		return _creditAppBankReference.getUserId();
	}

	/**
	* Sets the user ID of this credit app bank reference.
	*
	* @param userId the user ID of this credit app bank reference
	*/
	@Override
	public void setUserId(long userId) {
		_creditAppBankReference.setUserId(userId);
	}

	/**
	* Returns the user uuid of this credit app bank reference.
	*
	* @return the user uuid of this credit app bank reference
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppBankReference.getUserUuid();
	}

	/**
	* Sets the user uuid of this credit app bank reference.
	*
	* @param userUuid the user uuid of this credit app bank reference
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_creditAppBankReference.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this credit app bank reference.
	*
	* @return the user name of this credit app bank reference
	*/
	@Override
	public java.lang.String getUserName() {
		return _creditAppBankReference.getUserName();
	}

	/**
	* Sets the user name of this credit app bank reference.
	*
	* @param userName the user name of this credit app bank reference
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_creditAppBankReference.setUserName(userName);
	}

	/**
	* Returns the create date of this credit app bank reference.
	*
	* @return the create date of this credit app bank reference
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _creditAppBankReference.getCreateDate();
	}

	/**
	* Sets the create date of this credit app bank reference.
	*
	* @param createDate the create date of this credit app bank reference
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_creditAppBankReference.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this credit app bank reference.
	*
	* @return the modified date of this credit app bank reference
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _creditAppBankReference.getModifiedDate();
	}

	/**
	* Sets the modified date of this credit app bank reference.
	*
	* @param modifiedDate the modified date of this credit app bank reference
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_creditAppBankReference.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the credit app ID of this credit app bank reference.
	*
	* @return the credit app ID of this credit app bank reference
	*/
	@Override
	public long getCreditAppId() {
		return _creditAppBankReference.getCreditAppId();
	}

	/**
	* Sets the credit app ID of this credit app bank reference.
	*
	* @param creditAppId the credit app ID of this credit app bank reference
	*/
	@Override
	public void setCreditAppId(long creditAppId) {
		_creditAppBankReference.setCreditAppId(creditAppId);
	}

	/**
	* Returns the sequence number of this credit app bank reference.
	*
	* @return the sequence number of this credit app bank reference
	*/
	@Override
	public long getSequenceNumber() {
		return _creditAppBankReference.getSequenceNumber();
	}

	/**
	* Sets the sequence number of this credit app bank reference.
	*
	* @param sequenceNumber the sequence number of this credit app bank reference
	*/
	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_creditAppBankReference.setSequenceNumber(sequenceNumber);
	}

	/**
	* Returns the bank reference name of this credit app bank reference.
	*
	* @return the bank reference name of this credit app bank reference
	*/
	@Override
	public java.lang.String getBankReferenceName() {
		return _creditAppBankReference.getBankReferenceName();
	}

	/**
	* Sets the bank reference name of this credit app bank reference.
	*
	* @param bankReferenceName the bank reference name of this credit app bank reference
	*/
	@Override
	public void setBankReferenceName(java.lang.String bankReferenceName) {
		_creditAppBankReference.setBankReferenceName(bankReferenceName);
	}

	/**
	* Returns the bank reference contact of this credit app bank reference.
	*
	* @return the bank reference contact of this credit app bank reference
	*/
	@Override
	public java.lang.String getBankReferenceContact() {
		return _creditAppBankReference.getBankReferenceContact();
	}

	/**
	* Sets the bank reference contact of this credit app bank reference.
	*
	* @param bankReferenceContact the bank reference contact of this credit app bank reference
	*/
	@Override
	public void setBankReferenceContact(java.lang.String bankReferenceContact) {
		_creditAppBankReference.setBankReferenceContact(bankReferenceContact);
	}

	/**
	* Returns the bank reference phone of this credit app bank reference.
	*
	* @return the bank reference phone of this credit app bank reference
	*/
	@Override
	public java.lang.String getBankReferencePhone() {
		return _creditAppBankReference.getBankReferencePhone();
	}

	/**
	* Sets the bank reference phone of this credit app bank reference.
	*
	* @param bankReferencePhone the bank reference phone of this credit app bank reference
	*/
	@Override
	public void setBankReferencePhone(java.lang.String bankReferencePhone) {
		_creditAppBankReference.setBankReferencePhone(bankReferencePhone);
	}

	/**
	* Returns the bank referenc account type of this credit app bank reference.
	*
	* @return the bank referenc account type of this credit app bank reference
	*/
	@Override
	public java.lang.String getBankReferencAccountType() {
		return _creditAppBankReference.getBankReferencAccountType();
	}

	/**
	* Sets the bank referenc account type of this credit app bank reference.
	*
	* @param bankReferencAccountType the bank referenc account type of this credit app bank reference
	*/
	@Override
	public void setBankReferencAccountType(
		java.lang.String bankReferencAccountType) {
		_creditAppBankReference.setBankReferencAccountType(bankReferencAccountType);
	}

	/**
	* Returns the bank reference account number of this credit app bank reference.
	*
	* @return the bank reference account number of this credit app bank reference
	*/
	@Override
	public java.lang.String getBankReferenceAccountNumber() {
		return _creditAppBankReference.getBankReferenceAccountNumber();
	}

	/**
	* Sets the bank reference account number of this credit app bank reference.
	*
	* @param bankReferenceAccountNumber the bank reference account number of this credit app bank reference
	*/
	@Override
	public void setBankReferenceAccountNumber(
		java.lang.String bankReferenceAccountNumber) {
		_creditAppBankReference.setBankReferenceAccountNumber(bankReferenceAccountNumber);
	}

	@Override
	public boolean isNew() {
		return _creditAppBankReference.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_creditAppBankReference.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _creditAppBankReference.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creditAppBankReference.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _creditAppBankReference.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _creditAppBankReference.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_creditAppBankReference.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _creditAppBankReference.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_creditAppBankReference.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_creditAppBankReference.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_creditAppBankReference.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CreditAppBankReferenceWrapper((CreditAppBankReference)_creditAppBankReference.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.CreditAppBankReference creditAppBankReference) {
		return _creditAppBankReference.compareTo(creditAppBankReference);
	}

	@Override
	public int hashCode() {
		return _creditAppBankReference.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.CreditAppBankReference> toCacheModel() {
		return _creditAppBankReference.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference toEscapedModel() {
		return new CreditAppBankReferenceWrapper(_creditAppBankReference.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppBankReference toUnescapedModel() {
		return new CreditAppBankReferenceWrapper(_creditAppBankReference.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _creditAppBankReference.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _creditAppBankReference.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_creditAppBankReference.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppBankReferenceWrapper)) {
			return false;
		}

		CreditAppBankReferenceWrapper creditAppBankReferenceWrapper = (CreditAppBankReferenceWrapper)obj;

		if (Validator.equals(_creditAppBankReference,
					creditAppBankReferenceWrapper._creditAppBankReference)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CreditAppBankReference getWrappedCreditAppBankReference() {
		return _creditAppBankReference;
	}

	@Override
	public CreditAppBankReference getWrappedModel() {
		return _creditAppBankReference;
	}

	@Override
	public void resetOriginalValues() {
		_creditAppBankReference.resetOriginalValues();
	}

	private CreditAppBankReference _creditAppBankReference;
}