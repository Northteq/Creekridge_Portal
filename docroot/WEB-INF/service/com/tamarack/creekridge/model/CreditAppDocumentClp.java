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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.tamarack.creekridge.service.ClpSerializer;
import com.tamarack.creekridge.service.CreditAppDocumentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tamarack Consulting
 */
public class CreditAppDocumentClp extends BaseModelImpl<CreditAppDocument>
	implements CreditAppDocument {
	public CreditAppDocumentClp() {
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
	public long getPrimaryKey() {
		return _CreditAppDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCreditAppDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CreditAppDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("documentFileContent", getDocumentFileContent());

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

		Blob documentFileContent = (Blob)attributes.get("documentFileContent");

		if (documentFileContent != null) {
			setDocumentFileContent(documentFileContent);
		}
	}

	@Override
	public long getCreditAppDocumentId() {
		return _CreditAppDocumentId;
	}

	@Override
	public void setCreditAppDocumentId(long CreditAppDocumentId) {
		_CreditAppDocumentId = CreditAppDocumentId;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppDocumentId",
						long.class);

				method.invoke(_creditAppDocumentRemoteModel, CreditAppDocumentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_creditAppDocumentRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_creditAppDocumentRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_creditAppDocumentRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_creditAppDocumentRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_creditAppDocumentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreditAppId() {
		return _creditAppId;
	}

	@Override
	public void setCreditAppId(long creditAppId) {
		_creditAppId = creditAppId;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppId", long.class);

				method.invoke(_creditAppDocumentRemoteModel, creditAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSequenceNumber() {
		return _sequenceNumber;
	}

	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_sequenceNumber = sequenceNumber;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setSequenceNumber", long.class);

				method.invoke(_creditAppDocumentRemoteModel, sequenceNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocumentTitle() {
		return _documentTitle;
	}

	@Override
	public void setDocumentTitle(String documentTitle) {
		_documentTitle = documentTitle;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocumentTitle", String.class);

				method.invoke(_creditAppDocumentRemoteModel, documentTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocumentFileName() {
		return _documentFileName;
	}

	@Override
	public void setDocumentFileName(String documentFileName) {
		_documentFileName = documentFileName;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocumentFileName",
						String.class);

				method.invoke(_creditAppDocumentRemoteModel, documentFileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Blob getDocumentFileContent() {
		return _documentFileContent;
	}

	@Override
	public void setDocumentFileContent(Blob documentFileContent) {
		_documentFileContent = documentFileContent;

		if (_creditAppDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setDocumentFileContent",
						Blob.class);

				method.invoke(_creditAppDocumentRemoteModel, documentFileContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCreditAppDocumentRemoteModel() {
		return _creditAppDocumentRemoteModel;
	}

	public void setCreditAppDocumentRemoteModel(
		BaseModel<?> creditAppDocumentRemoteModel) {
		_creditAppDocumentRemoteModel = creditAppDocumentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _creditAppDocumentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_creditAppDocumentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CreditAppDocumentLocalServiceUtil.addCreditAppDocument(this);
		}
		else {
			CreditAppDocumentLocalServiceUtil.updateCreditAppDocument(this);
		}
	}

	@Override
	public CreditAppDocument toEscapedModel() {
		return (CreditAppDocument)ProxyUtil.newProxyInstance(CreditAppDocument.class.getClassLoader(),
			new Class[] { CreditAppDocument.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CreditAppDocumentClp clone = new CreditAppDocumentClp();

		clone.setCreditAppDocumentId(getCreditAppDocumentId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreditAppId(getCreditAppId());
		clone.setSequenceNumber(getSequenceNumber());
		clone.setDocumentTitle(getDocumentTitle());
		clone.setDocumentFileName(getDocumentFileName());
		clone.setDocumentFileContent(getDocumentFileContent());

		return clone;
	}

	@Override
	public int compareTo(CreditAppDocument creditAppDocument) {
		int value = 0;

		if (getSequenceNumber() < creditAppDocument.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > creditAppDocument.getSequenceNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CreditAppDocumentClp)) {
			return false;
		}

		CreditAppDocumentClp creditAppDocument = (CreditAppDocumentClp)obj;

		long primaryKey = creditAppDocument.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{CreditAppDocumentId=");
		sb.append(getCreditAppDocumentId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", creditAppId=");
		sb.append(getCreditAppId());
		sb.append(", sequenceNumber=");
		sb.append(getSequenceNumber());
		sb.append(", documentTitle=");
		sb.append(getDocumentTitle());
		sb.append(", documentFileName=");
		sb.append(getDocumentFileName());
		sb.append(", documentFileContent=");
		sb.append(getDocumentFileContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditAppDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CreditAppDocumentId</column-name><column-value><![CDATA[");
		sb.append(getCreditAppDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditAppId</column-name><column-value><![CDATA[");
		sb.append(getCreditAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNumber</column-name><column-value><![CDATA[");
		sb.append(getSequenceNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentTitle</column-name><column-value><![CDATA[");
		sb.append(getDocumentTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentFileName</column-name><column-value><![CDATA[");
		sb.append(getDocumentFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentFileContent</column-name><column-value><![CDATA[");
		sb.append(getDocumentFileContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _CreditAppDocumentId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditAppId;
	private long _sequenceNumber;
	private String _documentTitle;
	private String _documentFileName;
	private Blob _documentFileContent;
	private BaseModel<?> _creditAppDocumentRemoteModel;
}