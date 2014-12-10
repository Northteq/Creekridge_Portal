/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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
 * The base model interface for the Term service. Represents a row in the &quot;eCreekRidge_Term&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.tamarack.creekridge.model.impl.TermModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.tamarack.creekridge.model.impl.TermImpl}.
 * </p>
 *
 * @author Tamarack Consulting
 * @see Term
 * @see com.tamarack.creekridge.model.impl.TermImpl
 * @see com.tamarack.creekridge.model.impl.TermModelImpl
 * @generated
 */
public interface TermModel extends AuditedModel, BaseModel<Term> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a term model instance should use the {@link Term} interface instead.
	 */

	/**
	 * Returns the primary key of this term.
	 *
	 * @return the primary key of this term
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this term.
	 *
	 * @param primaryKey the primary key of this term
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the term ID of this term.
	 *
	 * @return the term ID of this term
	 */
	public long getTermId();

	/**
	 * Sets the term ID of this term.
	 *
	 * @param termId the term ID of this term
	 */
	public void setTermId(long termId);

	/**
	 * Returns the company ID of this term.
	 *
	 * @return the company ID of this term
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this term.
	 *
	 * @param companyId the company ID of this term
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this term.
	 *
	 * @return the user ID of this term
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this term.
	 *
	 * @param userId the user ID of this term
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this term.
	 *
	 * @return the user uuid of this term
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this term.
	 *
	 * @param userUuid the user uuid of this term
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this term.
	 *
	 * @return the user name of this term
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this term.
	 *
	 * @param userName the user name of this term
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this term.
	 *
	 * @return the create date of this term
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this term.
	 *
	 * @param createDate the create date of this term
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this term.
	 *
	 * @return the modified date of this term
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this term.
	 *
	 * @param modifiedDate the modified date of this term
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the term months of this term.
	 *
	 * @return the term months of this term
	 */
	public long getTermMonths();

	/**
	 * Sets the term months of this term.
	 *
	 * @param termMonths the term months of this term
	 */
	public void setTermMonths(long termMonths);

	/**
	 * Returns the term name of this term.
	 *
	 * @return the term name of this term
	 */
	@AutoEscape
	public String getTermName();

	/**
	 * Sets the term name of this term.
	 *
	 * @param termName the term name of this term
	 */
	public void setTermName(String termName);

	/**
	 * Returns the sequence number of this term.
	 *
	 * @return the sequence number of this term
	 */
	public long getSequenceNumber();

	/**
	 * Sets the sequence number of this term.
	 *
	 * @param sequenceNumber the sequence number of this term
	 */
	public void setSequenceNumber(long sequenceNumber);

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
	public int compareTo(Term term);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Term> toCacheModel();

	@Override
	public Term toEscapedModel();

	@Override
	public Term toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}