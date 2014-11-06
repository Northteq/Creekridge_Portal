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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pmacha
 * @generated
 */
public class TermSoap implements Serializable {
	public static TermSoap toSoapModel(Term model) {
		TermSoap soapModel = new TermSoap();

		soapModel.setTermId(model.getTermId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTermMonths(model.getTermMonths());
		soapModel.setTermName(model.getTermName());
		soapModel.setSequenceNumber(model.getSequenceNumber());

		return soapModel;
	}

	public static TermSoap[] toSoapModels(Term[] models) {
		TermSoap[] soapModels = new TermSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TermSoap[][] toSoapModels(Term[][] models) {
		TermSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TermSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TermSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TermSoap[] toSoapModels(List<Term> models) {
		List<TermSoap> soapModels = new ArrayList<TermSoap>(models.size());

		for (Term model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TermSoap[soapModels.size()]);
	}

	public TermSoap() {
	}

	public long getPrimaryKey() {
		return _termId;
	}

	public void setPrimaryKey(long pk) {
		setTermId(pk);
	}

	public long getTermId() {
		return _termId;
	}

	public void setTermId(long termId) {
		_termId = termId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getTermMonths() {
		return _termMonths;
	}

	public void setTermMonths(long termMonths) {
		_termMonths = termMonths;
	}

	public String getTermName() {
		return _termName;
	}

	public void setTermName(String termName) {
		_termName = termName;
	}

	public long getSequenceNumber() {
		return _sequenceNumber;
	}

	public void setSequenceNumber(long sequenceNumber) {
		_sequenceNumber = sequenceNumber;
	}

	private long _termId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _termMonths;
	private String _termName;
	private long _sequenceNumber;
}