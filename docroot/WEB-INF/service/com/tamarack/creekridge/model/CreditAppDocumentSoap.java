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
public class CreditAppDocumentSoap implements Serializable {
	public static CreditAppDocumentSoap toSoapModel(CreditAppDocument model) {
		CreditAppDocumentSoap soapModel = new CreditAppDocumentSoap();

		soapModel.setCreditAppDocumentId(model.getCreditAppDocumentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreditAppId(model.getCreditAppId());
		soapModel.setSequenceNumber(model.getSequenceNumber());
		soapModel.setDocumentTitle(model.getDocumentTitle());
		soapModel.setDocumentFileName(model.getDocumentFileName());
		soapModel.setDocumentFileLocation(model.getDocumentFileLocation());

		return soapModel;
	}

	public static CreditAppDocumentSoap[] toSoapModels(
		CreditAppDocument[] models) {
		CreditAppDocumentSoap[] soapModels = new CreditAppDocumentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CreditAppDocumentSoap[][] toSoapModels(
		CreditAppDocument[][] models) {
		CreditAppDocumentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CreditAppDocumentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CreditAppDocumentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CreditAppDocumentSoap[] toSoapModels(
		List<CreditAppDocument> models) {
		List<CreditAppDocumentSoap> soapModels = new ArrayList<CreditAppDocumentSoap>(models.size());

		for (CreditAppDocument model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CreditAppDocumentSoap[soapModels.size()]);
	}

	public CreditAppDocumentSoap() {
	}

	public long getPrimaryKey() {
		return _CreditAppDocumentId;
	}

	public void setPrimaryKey(long pk) {
		setCreditAppDocumentId(pk);
	}

	public long getCreditAppDocumentId() {
		return _CreditAppDocumentId;
	}

	public void setCreditAppDocumentId(long CreditAppDocumentId) {
		_CreditAppDocumentId = CreditAppDocumentId;
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

	public String getDocumentTitle() {
		return _documentTitle;
	}

	public void setDocumentTitle(String documentTitle) {
		_documentTitle = documentTitle;
	}

	public String getDocumentFileName() {
		return _documentFileName;
	}

	public void setDocumentFileName(String documentFileName) {
		_documentFileName = documentFileName;
	}

	public String getDocumentFileLocation() {
		return _documentFileLocation;
	}

	public void setDocumentFileLocation(String documentFileLocation) {
		_documentFileLocation = documentFileLocation;
	}

	private long _CreditAppDocumentId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditAppId;
	private long _sequenceNumber;
	private String _documentTitle;
	private String _documentFileName;
	private String _documentFileLocation;
}