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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CreditAppPrincipal service. Represents a row in the &quot;eCreekRidge_CreditAppPrincipal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tamarack.creekridge.model.impl.CreditAppPrincipalImpl}.
 * </p>
 *
 * @author tamarack
 * @see CreditAppPrincipal
 * @see com.tamarack.creekridge.model.impl.CreditAppPrincipalImpl
 * @see com.tamarack.creekridge.model.impl.CreditAppPrincipalModelImpl
 * @generated
 */
public interface CreditAppPrincipalModel extends AuditedModel,
	BaseModel<CreditAppPrincipal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a credit app principal model instance should use the {@link CreditAppPrincipal} interface instead.
	 */

	/**
	 * Returns the primary key of this credit app principal.
	 *
	 * @return the primary key of this credit app principal
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this credit app principal.
	 *
	 * @param primaryKey the primary key of this credit app principal
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the principal ID of this credit app principal.
	 *
	 * @return the principal ID of this credit app principal
	 */
	public long getPrincipalId();

	/**
	 * Sets the principal ID of this credit app principal.
	 *
	 * @param principalId the principal ID of this credit app principal
	 */
	public void setPrincipalId(long principalId);

	/**
	 * Returns the company ID of this credit app principal.
	 *
	 * @return the company ID of this credit app principal
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this credit app principal.
	 *
	 * @param companyId the company ID of this credit app principal
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this credit app principal.
	 *
	 * @return the user ID of this credit app principal
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this credit app principal.
	 *
	 * @param userId the user ID of this credit app principal
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this credit app principal.
	 *
	 * @return the user uuid of this credit app principal
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this credit app principal.
	 *
	 * @param userUuid the user uuid of this credit app principal
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this credit app principal.
	 *
	 * @return the user name of this credit app principal
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this credit app principal.
	 *
	 * @param userName the user name of this credit app principal
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this credit app principal.
	 *
	 * @return the create date of this credit app principal
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this credit app principal.
	 *
	 * @param createDate the create date of this credit app principal
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this credit app principal.
	 *
	 * @return the modified date of this credit app principal
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this credit app principal.
	 *
	 * @param modifiedDate the modified date of this credit app principal
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the credit app ID of this credit app principal.
	 *
	 * @return the credit app ID of this credit app principal
	 */
	public long getCreditAppId();

	/**
	 * Sets the credit app ID of this credit app principal.
	 *
	 * @param creditAppId the credit app ID of this credit app principal
	 */
	public void setCreditAppId(long creditAppId);

	/**
	 * Returns the sequence number of this credit app principal.
	 *
	 * @return the sequence number of this credit app principal
	 */
	public long getSequenceNumber();

	/**
	 * Sets the sequence number of this credit app principal.
	 *
	 * @param sequenceNumber the sequence number of this credit app principal
	 */
	public void setSequenceNumber(long sequenceNumber);

	/**
	 * Returns the principal first name of this credit app principal.
	 *
	 * @return the principal first name of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalFirstName();

	/**
	 * Sets the principal first name of this credit app principal.
	 *
	 * @param principalFirstName the principal first name of this credit app principal
	 */
	public void setPrincipalFirstName(String principalFirstName);

	/**
	 * Returns the principal middle name of this credit app principal.
	 *
	 * @return the principal middle name of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalMiddleName();

	/**
	 * Sets the principal middle name of this credit app principal.
	 *
	 * @param principalMiddleName the principal middle name of this credit app principal
	 */
	public void setPrincipalMiddleName(String principalMiddleName);

	/**
	 * Returns the principal last name of this credit app principal.
	 *
	 * @return the principal last name of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalLastName();

	/**
	 * Sets the principal last name of this credit app principal.
	 *
	 * @param principalLastName the principal last name of this credit app principal
	 */
	public void setPrincipalLastName(String principalLastName);

	/**
	 * Returns the principal s s n of this credit app principal.
	 *
	 * @return the principal s s n of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalSSN();

	/**
	 * Sets the principal s s n of this credit app principal.
	 *
	 * @param principalSSN the principal s s n of this credit app principal
	 */
	public void setPrincipalSSN(String principalSSN);

	/**
	 * Returns the principal home phone number of this credit app principal.
	 *
	 * @return the principal home phone number of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalHomePhoneNumber();

	/**
	 * Sets the principal home phone number of this credit app principal.
	 *
	 * @param principalHomePhoneNumber the principal home phone number of this credit app principal
	 */
	public void setPrincipalHomePhoneNumber(String principalHomePhoneNumber);

	/**
	 * Returns the principal address1 of this credit app principal.
	 *
	 * @return the principal address1 of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalAddress1();

	/**
	 * Sets the principal address1 of this credit app principal.
	 *
	 * @param principalAddress1 the principal address1 of this credit app principal
	 */
	public void setPrincipalAddress1(String principalAddress1);

	/**
	 * Returns the principal address2 of this credit app principal.
	 *
	 * @return the principal address2 of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalAddress2();

	/**
	 * Sets the principal address2 of this credit app principal.
	 *
	 * @param principalAddress2 the principal address2 of this credit app principal
	 */
	public void setPrincipalAddress2(String principalAddress2);

	/**
	 * Returns the principal city of this credit app principal.
	 *
	 * @return the principal city of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalCity();

	/**
	 * Sets the principal city of this credit app principal.
	 *
	 * @param principalCity the principal city of this credit app principal
	 */
	public void setPrincipalCity(String principalCity);

	/**
	 * Returns the principal state of this credit app principal.
	 *
	 * @return the principal state of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalState();

	/**
	 * Sets the principal state of this credit app principal.
	 *
	 * @param principalState the principal state of this credit app principal
	 */
	public void setPrincipalState(String principalState);

	/**
	 * Returns the principal zip of this credit app principal.
	 *
	 * @return the principal zip of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalZip();

	/**
	 * Sets the principal zip of this credit app principal.
	 *
	 * @param principalZip the principal zip of this credit app principal
	 */
	public void setPrincipalZip(String principalZip);

	/**
	 * Returns the principal email of this credit app principal.
	 *
	 * @return the principal email of this credit app principal
	 */
	@AutoEscape
	public String getPrincipalEmail();

	/**
	 * Sets the principal email of this credit app principal.
	 *
	 * @param principalEmail the principal email of this credit app principal
	 */
	public void setPrincipalEmail(String principalEmail);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CreditAppPrincipal creditAppPrincipal);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CreditAppPrincipal> toCacheModel();

	@Override
	public CreditAppPrincipal toEscapedModel();

	@Override
	public CreditAppPrincipal toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}