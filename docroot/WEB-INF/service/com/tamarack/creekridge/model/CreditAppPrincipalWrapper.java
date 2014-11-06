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
 * This class is a wrapper for {@link CreditAppPrincipal}.
 * </p>
 *
 * @author pmacha
 * @see CreditAppPrincipal
 * @generated
 */
public class CreditAppPrincipalWrapper implements CreditAppPrincipal,
	ModelWrapper<CreditAppPrincipal> {
	public CreditAppPrincipalWrapper(CreditAppPrincipal creditAppPrincipal) {
		_creditAppPrincipal = creditAppPrincipal;
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppPrincipal.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppPrincipal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("principalId", getPrincipalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("sequenceNumber", getSequenceNumber());
		attributes.put("principalFirstName", getPrincipalFirstName());
		attributes.put("principalMiddleName", getPrincipalMiddleName());
		attributes.put("principalLastName", getPrincipalLastName());
		attributes.put("principalSSN", getPrincipalSSN());
		attributes.put("principalHomePhoneNumber", getPrincipalHomePhoneNumber());
		attributes.put("principalAddress1", getPrincipalAddress1());
		attributes.put("principalAddress2", getPrincipalAddress2());
		attributes.put("principalCity", getPrincipalCity());
		attributes.put("principalState", getPrincipalState());
		attributes.put("principalZip", getPrincipalZip());
		attributes.put("principalEmail", getPrincipalEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long principalId = (Long)attributes.get("principalId");

		if (principalId != null) {
			setPrincipalId(principalId);
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

		String principalFirstName = (String)attributes.get("principalFirstName");

		if (principalFirstName != null) {
			setPrincipalFirstName(principalFirstName);
		}

		String principalMiddleName = (String)attributes.get(
				"principalMiddleName");

		if (principalMiddleName != null) {
			setPrincipalMiddleName(principalMiddleName);
		}

		String principalLastName = (String)attributes.get("principalLastName");

		if (principalLastName != null) {
			setPrincipalLastName(principalLastName);
		}

		String principalSSN = (String)attributes.get("principalSSN");

		if (principalSSN != null) {
			setPrincipalSSN(principalSSN);
		}

		String principalHomePhoneNumber = (String)attributes.get(
				"principalHomePhoneNumber");

		if (principalHomePhoneNumber != null) {
			setPrincipalHomePhoneNumber(principalHomePhoneNumber);
		}

		String principalAddress1 = (String)attributes.get("principalAddress1");

		if (principalAddress1 != null) {
			setPrincipalAddress1(principalAddress1);
		}

		String principalAddress2 = (String)attributes.get("principalAddress2");

		if (principalAddress2 != null) {
			setPrincipalAddress2(principalAddress2);
		}

		String principalCity = (String)attributes.get("principalCity");

		if (principalCity != null) {
			setPrincipalCity(principalCity);
		}

		String principalState = (String)attributes.get("principalState");

		if (principalState != null) {
			setPrincipalState(principalState);
		}

		String principalZip = (String)attributes.get("principalZip");

		if (principalZip != null) {
			setPrincipalZip(principalZip);
		}

		String principalEmail = (String)attributes.get("principalEmail");

		if (principalEmail != null) {
			setPrincipalEmail(principalEmail);
		}
	}

	/**
	* Returns the primary key of this credit app principal.
	*
	* @return the primary key of this credit app principal
	*/
	@Override
	public long getPrimaryKey() {
		return _creditAppPrincipal.getPrimaryKey();
	}

	/**
	* Sets the primary key of this credit app principal.
	*
	* @param primaryKey the primary key of this credit app principal
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_creditAppPrincipal.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the principal ID of this credit app principal.
	*
	* @return the principal ID of this credit app principal
	*/
	@Override
	public long getPrincipalId() {
		return _creditAppPrincipal.getPrincipalId();
	}

	/**
	* Sets the principal ID of this credit app principal.
	*
	* @param principalId the principal ID of this credit app principal
	*/
	@Override
	public void setPrincipalId(long principalId) {
		_creditAppPrincipal.setPrincipalId(principalId);
	}

	/**
	* Returns the company ID of this credit app principal.
	*
	* @return the company ID of this credit app principal
	*/
	@Override
	public long getCompanyId() {
		return _creditAppPrincipal.getCompanyId();
	}

	/**
	* Sets the company ID of this credit app principal.
	*
	* @param companyId the company ID of this credit app principal
	*/
	@Override
	public void setCompanyId(long companyId) {
		_creditAppPrincipal.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this credit app principal.
	*
	* @return the user ID of this credit app principal
	*/
	@Override
	public long getUserId() {
		return _creditAppPrincipal.getUserId();
	}

	/**
	* Sets the user ID of this credit app principal.
	*
	* @param userId the user ID of this credit app principal
	*/
	@Override
	public void setUserId(long userId) {
		_creditAppPrincipal.setUserId(userId);
	}

	/**
	* Returns the user uuid of this credit app principal.
	*
	* @return the user uuid of this credit app principal
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _creditAppPrincipal.getUserUuid();
	}

	/**
	* Sets the user uuid of this credit app principal.
	*
	* @param userUuid the user uuid of this credit app principal
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_creditAppPrincipal.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this credit app principal.
	*
	* @return the user name of this credit app principal
	*/
	@Override
	public java.lang.String getUserName() {
		return _creditAppPrincipal.getUserName();
	}

	/**
	* Sets the user name of this credit app principal.
	*
	* @param userName the user name of this credit app principal
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_creditAppPrincipal.setUserName(userName);
	}

	/**
	* Returns the create date of this credit app principal.
	*
	* @return the create date of this credit app principal
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _creditAppPrincipal.getCreateDate();
	}

	/**
	* Sets the create date of this credit app principal.
	*
	* @param createDate the create date of this credit app principal
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_creditAppPrincipal.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this credit app principal.
	*
	* @return the modified date of this credit app principal
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _creditAppPrincipal.getModifiedDate();
	}

	/**
	* Sets the modified date of this credit app principal.
	*
	* @param modifiedDate the modified date of this credit app principal
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_creditAppPrincipal.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the credit app ID of this credit app principal.
	*
	* @return the credit app ID of this credit app principal
	*/
	@Override
	public long getCreditAppId() {
		return _creditAppPrincipal.getCreditAppId();
	}

	/**
	* Sets the credit app ID of this credit app principal.
	*
	* @param creditAppId the credit app ID of this credit app principal
	*/
	@Override
	public void setCreditAppId(long creditAppId) {
		_creditAppPrincipal.setCreditAppId(creditAppId);
	}

	/**
	* Returns the sequence number of this credit app principal.
	*
	* @return the sequence number of this credit app principal
	*/
	@Override
	public long getSequenceNumber() {
		return _creditAppPrincipal.getSequenceNumber();
	}

	/**
	* Sets the sequence number of this credit app principal.
	*
	* @param sequenceNumber the sequence number of this credit app principal
	*/
	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_creditAppPrincipal.setSequenceNumber(sequenceNumber);
	}

	/**
	* Returns the principal first name of this credit app principal.
	*
	* @return the principal first name of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalFirstName() {
		return _creditAppPrincipal.getPrincipalFirstName();
	}

	/**
	* Sets the principal first name of this credit app principal.
	*
	* @param principalFirstName the principal first name of this credit app principal
	*/
	@Override
	public void setPrincipalFirstName(java.lang.String principalFirstName) {
		_creditAppPrincipal.setPrincipalFirstName(principalFirstName);
	}

	/**
	* Returns the principal middle name of this credit app principal.
	*
	* @return the principal middle name of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalMiddleName() {
		return _creditAppPrincipal.getPrincipalMiddleName();
	}

	/**
	* Sets the principal middle name of this credit app principal.
	*
	* @param principalMiddleName the principal middle name of this credit app principal
	*/
	@Override
	public void setPrincipalMiddleName(java.lang.String principalMiddleName) {
		_creditAppPrincipal.setPrincipalMiddleName(principalMiddleName);
	}

	/**
	* Returns the principal last name of this credit app principal.
	*
	* @return the principal last name of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalLastName() {
		return _creditAppPrincipal.getPrincipalLastName();
	}

	/**
	* Sets the principal last name of this credit app principal.
	*
	* @param principalLastName the principal last name of this credit app principal
	*/
	@Override
	public void setPrincipalLastName(java.lang.String principalLastName) {
		_creditAppPrincipal.setPrincipalLastName(principalLastName);
	}

	/**
	* Returns the principal s s n of this credit app principal.
	*
	* @return the principal s s n of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalSSN() {
		return _creditAppPrincipal.getPrincipalSSN();
	}

	/**
	* Sets the principal s s n of this credit app principal.
	*
	* @param principalSSN the principal s s n of this credit app principal
	*/
	@Override
	public void setPrincipalSSN(java.lang.String principalSSN) {
		_creditAppPrincipal.setPrincipalSSN(principalSSN);
	}

	/**
	* Returns the principal home phone number of this credit app principal.
	*
	* @return the principal home phone number of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalHomePhoneNumber() {
		return _creditAppPrincipal.getPrincipalHomePhoneNumber();
	}

	/**
	* Sets the principal home phone number of this credit app principal.
	*
	* @param principalHomePhoneNumber the principal home phone number of this credit app principal
	*/
	@Override
	public void setPrincipalHomePhoneNumber(
		java.lang.String principalHomePhoneNumber) {
		_creditAppPrincipal.setPrincipalHomePhoneNumber(principalHomePhoneNumber);
	}

	/**
	* Returns the principal address1 of this credit app principal.
	*
	* @return the principal address1 of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalAddress1() {
		return _creditAppPrincipal.getPrincipalAddress1();
	}

	/**
	* Sets the principal address1 of this credit app principal.
	*
	* @param principalAddress1 the principal address1 of this credit app principal
	*/
	@Override
	public void setPrincipalAddress1(java.lang.String principalAddress1) {
		_creditAppPrincipal.setPrincipalAddress1(principalAddress1);
	}

	/**
	* Returns the principal address2 of this credit app principal.
	*
	* @return the principal address2 of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalAddress2() {
		return _creditAppPrincipal.getPrincipalAddress2();
	}

	/**
	* Sets the principal address2 of this credit app principal.
	*
	* @param principalAddress2 the principal address2 of this credit app principal
	*/
	@Override
	public void setPrincipalAddress2(java.lang.String principalAddress2) {
		_creditAppPrincipal.setPrincipalAddress2(principalAddress2);
	}

	/**
	* Returns the principal city of this credit app principal.
	*
	* @return the principal city of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalCity() {
		return _creditAppPrincipal.getPrincipalCity();
	}

	/**
	* Sets the principal city of this credit app principal.
	*
	* @param principalCity the principal city of this credit app principal
	*/
	@Override
	public void setPrincipalCity(java.lang.String principalCity) {
		_creditAppPrincipal.setPrincipalCity(principalCity);
	}

	/**
	* Returns the principal state of this credit app principal.
	*
	* @return the principal state of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalState() {
		return _creditAppPrincipal.getPrincipalState();
	}

	/**
	* Sets the principal state of this credit app principal.
	*
	* @param principalState the principal state of this credit app principal
	*/
	@Override
	public void setPrincipalState(java.lang.String principalState) {
		_creditAppPrincipal.setPrincipalState(principalState);
	}

	/**
	* Returns the principal zip of this credit app principal.
	*
	* @return the principal zip of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalZip() {
		return _creditAppPrincipal.getPrincipalZip();
	}

	/**
	* Sets the principal zip of this credit app principal.
	*
	* @param principalZip the principal zip of this credit app principal
	*/
	@Override
	public void setPrincipalZip(java.lang.String principalZip) {
		_creditAppPrincipal.setPrincipalZip(principalZip);
	}

	/**
	* Returns the principal email of this credit app principal.
	*
	* @return the principal email of this credit app principal
	*/
	@Override
	public java.lang.String getPrincipalEmail() {
		return _creditAppPrincipal.getPrincipalEmail();
	}

	/**
	* Sets the principal email of this credit app principal.
	*
	* @param principalEmail the principal email of this credit app principal
	*/
	@Override
	public void setPrincipalEmail(java.lang.String principalEmail) {
		_creditAppPrincipal.setPrincipalEmail(principalEmail);
	}

	@Override
	public boolean isNew() {
		return _creditAppPrincipal.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_creditAppPrincipal.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _creditAppPrincipal.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_creditAppPrincipal.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _creditAppPrincipal.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _creditAppPrincipal.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_creditAppPrincipal.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _creditAppPrincipal.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_creditAppPrincipal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_creditAppPrincipal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_creditAppPrincipal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CreditAppPrincipalWrapper((CreditAppPrincipal)_creditAppPrincipal.clone());
	}

	@Override
	public int compareTo(
		com.tamarack.creekridge.model.CreditAppPrincipal creditAppPrincipal) {
		return _creditAppPrincipal.compareTo(creditAppPrincipal);
	}

	@Override
	public int hashCode() {
		return _creditAppPrincipal.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.CreditAppPrincipal> toCacheModel() {
		return _creditAppPrincipal.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal toEscapedModel() {
		return new CreditAppPrincipalWrapper(_creditAppPrincipal.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.CreditAppPrincipal toUnescapedModel() {
		return new CreditAppPrincipalWrapper(_creditAppPrincipal.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _creditAppPrincipal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _creditAppPrincipal.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_creditAppPrincipal.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppPrincipalWrapper)) {
			return false;
		}

		CreditAppPrincipalWrapper creditAppPrincipalWrapper = (CreditAppPrincipalWrapper)obj;

		if (Validator.equals(_creditAppPrincipal,
					creditAppPrincipalWrapper._creditAppPrincipal)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CreditAppPrincipal getWrappedCreditAppPrincipal() {
		return _creditAppPrincipal;
	}

	@Override
	public CreditAppPrincipal getWrappedModel() {
		return _creditAppPrincipal;
	}

	@Override
	public void resetOriginalValues() {
		_creditAppPrincipal.resetOriginalValues();
	}

	private CreditAppPrincipal _creditAppPrincipal;
}