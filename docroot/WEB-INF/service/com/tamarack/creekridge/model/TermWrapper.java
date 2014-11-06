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
 * This class is a wrapper for {@link Term}.
 * </p>
 *
 * @author pmacha
 * @see Term
 * @generated
 */
public class TermWrapper implements Term, ModelWrapper<Term> {
	public TermWrapper(Term term) {
		_term = term;
	}

	@Override
	public Class<?> getModelClass() {
		return Term.class;
	}

	@Override
	public String getModelClassName() {
		return Term.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("termId", getTermId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("termMonths", getTermMonths());
		attributes.put("termName", getTermName());
		attributes.put("sequenceNumber", getSequenceNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
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

		Long termMonths = (Long)attributes.get("termMonths");

		if (termMonths != null) {
			setTermMonths(termMonths);
		}

		String termName = (String)attributes.get("termName");

		if (termName != null) {
			setTermName(termName);
		}

		Long sequenceNumber = (Long)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}
	}

	/**
	* Returns the primary key of this term.
	*
	* @return the primary key of this term
	*/
	@Override
	public long getPrimaryKey() {
		return _term.getPrimaryKey();
	}

	/**
	* Sets the primary key of this term.
	*
	* @param primaryKey the primary key of this term
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_term.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the term ID of this term.
	*
	* @return the term ID of this term
	*/
	@Override
	public long getTermId() {
		return _term.getTermId();
	}

	/**
	* Sets the term ID of this term.
	*
	* @param termId the term ID of this term
	*/
	@Override
	public void setTermId(long termId) {
		_term.setTermId(termId);
	}

	/**
	* Returns the company ID of this term.
	*
	* @return the company ID of this term
	*/
	@Override
	public long getCompanyId() {
		return _term.getCompanyId();
	}

	/**
	* Sets the company ID of this term.
	*
	* @param companyId the company ID of this term
	*/
	@Override
	public void setCompanyId(long companyId) {
		_term.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this term.
	*
	* @return the user ID of this term
	*/
	@Override
	public long getUserId() {
		return _term.getUserId();
	}

	/**
	* Sets the user ID of this term.
	*
	* @param userId the user ID of this term
	*/
	@Override
	public void setUserId(long userId) {
		_term.setUserId(userId);
	}

	/**
	* Returns the user uuid of this term.
	*
	* @return the user uuid of this term
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _term.getUserUuid();
	}

	/**
	* Sets the user uuid of this term.
	*
	* @param userUuid the user uuid of this term
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_term.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this term.
	*
	* @return the user name of this term
	*/
	@Override
	public java.lang.String getUserName() {
		return _term.getUserName();
	}

	/**
	* Sets the user name of this term.
	*
	* @param userName the user name of this term
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_term.setUserName(userName);
	}

	/**
	* Returns the create date of this term.
	*
	* @return the create date of this term
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _term.getCreateDate();
	}

	/**
	* Sets the create date of this term.
	*
	* @param createDate the create date of this term
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_term.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this term.
	*
	* @return the modified date of this term
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _term.getModifiedDate();
	}

	/**
	* Sets the modified date of this term.
	*
	* @param modifiedDate the modified date of this term
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_term.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the term months of this term.
	*
	* @return the term months of this term
	*/
	@Override
	public long getTermMonths() {
		return _term.getTermMonths();
	}

	/**
	* Sets the term months of this term.
	*
	* @param termMonths the term months of this term
	*/
	@Override
	public void setTermMonths(long termMonths) {
		_term.setTermMonths(termMonths);
	}

	/**
	* Returns the term name of this term.
	*
	* @return the term name of this term
	*/
	@Override
	public java.lang.String getTermName() {
		return _term.getTermName();
	}

	/**
	* Sets the term name of this term.
	*
	* @param termName the term name of this term
	*/
	@Override
	public void setTermName(java.lang.String termName) {
		_term.setTermName(termName);
	}

	/**
	* Returns the sequence number of this term.
	*
	* @return the sequence number of this term
	*/
	@Override
	public long getSequenceNumber() {
		return _term.getSequenceNumber();
	}

	/**
	* Sets the sequence number of this term.
	*
	* @param sequenceNumber the sequence number of this term
	*/
	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_term.setSequenceNumber(sequenceNumber);
	}

	@Override
	public boolean isNew() {
		return _term.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_term.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _term.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_term.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _term.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _term.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_term.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _term.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_term.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_term.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_term.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TermWrapper((Term)_term.clone());
	}

	@Override
	public int compareTo(com.tamarack.creekridge.model.Term term) {
		return _term.compareTo(term);
	}

	@Override
	public int hashCode() {
		return _term.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.Term> toCacheModel() {
		return _term.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.Term toEscapedModel() {
		return new TermWrapper(_term.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.Term toUnescapedModel() {
		return new TermWrapper(_term.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _term.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _term.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_term.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TermWrapper)) {
			return false;
		}

		TermWrapper termWrapper = (TermWrapper)obj;

		if (Validator.equals(_term, termWrapper._term)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Term getWrappedTerm() {
		return _term;
	}

	@Override
	public Term getWrappedModel() {
		return _term;
	}

	@Override
	public void resetOriginalValues() {
		_term.resetOriginalValues();
	}

	private Term _term;
}