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
public class CreditAppPrincipalSoap implements Serializable {
	public static CreditAppPrincipalSoap toSoapModel(CreditAppPrincipal model) {
		CreditAppPrincipalSoap soapModel = new CreditAppPrincipalSoap();

		soapModel.setPrincipalId(model.getPrincipalId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreditAppId(model.getCreditAppId());
		soapModel.setSequenceNumber(model.getSequenceNumber());
		soapModel.setPrincipalFirstName(model.getPrincipalFirstName());
		soapModel.setPrincipalMiddleName(model.getPrincipalMiddleName());
		soapModel.setPrincipalLastName(model.getPrincipalLastName());
		soapModel.setPrincipalSSN(model.getPrincipalSSN());
		soapModel.setPrincipalHomePhoneNumber(model.getPrincipalHomePhoneNumber());
		soapModel.setPrincipalAddress1(model.getPrincipalAddress1());
		soapModel.setPrincipalAddress2(model.getPrincipalAddress2());
		soapModel.setPrincipalCity(model.getPrincipalCity());
		soapModel.setPrincipalState(model.getPrincipalState());
		soapModel.setPrincipalZip(model.getPrincipalZip());
		soapModel.setPrincipalEmail(model.getPrincipalEmail());

		return soapModel;
	}

	public static CreditAppPrincipalSoap[] toSoapModels(
		CreditAppPrincipal[] models) {
		CreditAppPrincipalSoap[] soapModels = new CreditAppPrincipalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditAppPrincipalSoap[][] toSoapModels(
		CreditAppPrincipal[][] models) {
		CreditAppPrincipalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditAppPrincipalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditAppPrincipalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditAppPrincipalSoap[] toSoapModels(
		List<CreditAppPrincipal> models) {
		List<CreditAppPrincipalSoap> soapModels = new ArrayList<CreditAppPrincipalSoap>(models.size());

		for (CreditAppPrincipal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditAppPrincipalSoap[soapModels.size()]);
	}

	public CreditAppPrincipalSoap() {
	}

	public long getPrimaryKey() {
		return _principalId;
	}

	public void setPrimaryKey(long pk) {
		setPrincipalId(pk);
	}

	public long getPrincipalId() {
		return _principalId;
	}

	public void setPrincipalId(long principalId) {
		_principalId = principalId;
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

	public long getCreditAppId() {
		return _creditAppId;
	}

	public void setCreditAppId(long creditAppId) {
		_creditAppId = creditAppId;
	}

	public long getSequenceNumber() {
		return _sequenceNumber;
	}

	public void setSequenceNumber(long sequenceNumber) {
		_sequenceNumber = sequenceNumber;
	}

	public String getPrincipalFirstName() {
		return _principalFirstName;
	}

	public void setPrincipalFirstName(String principalFirstName) {
		_principalFirstName = principalFirstName;
	}

	public String getPrincipalMiddleName() {
		return _principalMiddleName;
	}

	public void setPrincipalMiddleName(String principalMiddleName) {
		_principalMiddleName = principalMiddleName;
	}

	public String getPrincipalLastName() {
		return _principalLastName;
	}

	public void setPrincipalLastName(String principalLastName) {
		_principalLastName = principalLastName;
	}

	public String getPrincipalSSN() {
		return _principalSSN;
	}

	public void setPrincipalSSN(String principalSSN) {
		_principalSSN = principalSSN;
	}

	public String getPrincipalHomePhoneNumber() {
		return _principalHomePhoneNumber;
	}

	public void setPrincipalHomePhoneNumber(String principalHomePhoneNumber) {
		_principalHomePhoneNumber = principalHomePhoneNumber;
	}

	public String getPrincipalAddress1() {
		return _principalAddress1;
	}

	public void setPrincipalAddress1(String principalAddress1) {
		_principalAddress1 = principalAddress1;
	}

	public String getPrincipalAddress2() {
		return _principalAddress2;
	}

	public void setPrincipalAddress2(String principalAddress2) {
		_principalAddress2 = principalAddress2;
	}

	public String getPrincipalCity() {
		return _principalCity;
	}

	public void setPrincipalCity(String principalCity) {
		_principalCity = principalCity;
	}

	public String getPrincipalState() {
		return _principalState;
	}

	public void setPrincipalState(String principalState) {
		_principalState = principalState;
	}

	public String getPrincipalZip() {
		return _principalZip;
	}

	public void setPrincipalZip(String principalZip) {
		_principalZip = principalZip;
	}

	public String getPrincipalEmail() {
		return _principalEmail;
	}

	public void setPrincipalEmail(String principalEmail) {
		_principalEmail = principalEmail;
	}

	private long _principalId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditAppId;
	private long _sequenceNumber;
	private String _principalFirstName;
	private String _principalMiddleName;
	private String _principalLastName;
	private String _principalSSN;
	private String _principalHomePhoneNumber;
	private String _principalAddress1;
	private String _principalAddress2;
	private String _principalCity;
	private String _principalState;
	private String _principalZip;
	private String _principalEmail;
}