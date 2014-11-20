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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.tamarack.creekridge.service.ClpSerializer;
import com.tamarack.creekridge.service.CreditAppBankReferenceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pmacha
 */
public class CreditAppBankReferenceClp extends BaseModelImpl<CreditAppBankReference>
	implements CreditAppBankReference {
	public CreditAppBankReferenceClp() {
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
	public long getPrimaryKey() {
		return _bankReferenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBankReferenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bankReferenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getBankReferenceId() {
		return _bankReferenceId;
	}

	@Override
	public void setBankReferenceId(long bankReferenceId) {
		_bankReferenceId = bankReferenceId;

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setBankReferenceId", long.class);

				method.invoke(_creditAppBankReferenceRemoteModel,
					bankReferenceId);
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

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_creditAppBankReferenceRemoteModel, companyId);
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

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_creditAppBankReferenceRemoteModel, userId);
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

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_creditAppBankReferenceRemoteModel, userName);
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

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_creditAppBankReferenceRemoteModel, createDate);
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

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_creditAppBankReferenceRemoteModel, modifiedDate);
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

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppId", long.class);

				method.invoke(_creditAppBankReferenceRemoteModel, creditAppId);
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

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setSequenceNumber", long.class);

				method.invoke(_creditAppBankReferenceRemoteModel, sequenceNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankReferenceName() {
		return _bankReferenceName;
	}

	@Override
	public void setBankReferenceName(String bankReferenceName) {
		_bankReferenceName = bankReferenceName;

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setBankReferenceName",
						String.class);

				method.invoke(_creditAppBankReferenceRemoteModel,
					bankReferenceName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankReferenceContact() {
		return _bankReferenceContact;
	}

	@Override
	public void setBankReferenceContact(String bankReferenceContact) {
		_bankReferenceContact = bankReferenceContact;

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setBankReferenceContact",
						String.class);

				method.invoke(_creditAppBankReferenceRemoteModel,
					bankReferenceContact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankReferencePhone() {
		return _bankReferencePhone;
	}

	@Override
	public void setBankReferencePhone(String bankReferencePhone) {
		_bankReferencePhone = bankReferencePhone;

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setBankReferencePhone",
						String.class);

				method.invoke(_creditAppBankReferenceRemoteModel,
					bankReferencePhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankReferencAccountType() {
		return _bankReferencAccountType;
	}

	@Override
	public void setBankReferencAccountType(String bankReferencAccountType) {
		_bankReferencAccountType = bankReferencAccountType;

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setBankReferencAccountType",
						String.class);

				method.invoke(_creditAppBankReferenceRemoteModel,
					bankReferencAccountType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankReferenceAccountNumber() {
		return _bankReferenceAccountNumber;
	}

	@Override
	public void setBankReferenceAccountNumber(String bankReferenceAccountNumber) {
		_bankReferenceAccountNumber = bankReferenceAccountNumber;

		if (_creditAppBankReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppBankReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setBankReferenceAccountNumber",
						String.class);

				method.invoke(_creditAppBankReferenceRemoteModel,
					bankReferenceAccountNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCreditAppBankReferenceRemoteModel() {
		return _creditAppBankReferenceRemoteModel;
	}

	public void setCreditAppBankReferenceRemoteModel(
		BaseModel<?> creditAppBankReferenceRemoteModel) {
		_creditAppBankReferenceRemoteModel = creditAppBankReferenceRemoteModel;
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

		Class<?> remoteModelClass = _creditAppBankReferenceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_creditAppBankReferenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CreditAppBankReferenceLocalServiceUtil.addCreditAppBankReference(this);
		}
		else {
			CreditAppBankReferenceLocalServiceUtil.updateCreditAppBankReference(this);
		}
	}

	@Override
	public CreditAppBankReference toEscapedModel() {
		return (CreditAppBankReference)ProxyUtil.newProxyInstance(CreditAppBankReference.class.getClassLoader(),
			new Class[] { CreditAppBankReference.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CreditAppBankReferenceClp clone = new CreditAppBankReferenceClp();

		clone.setBankReferenceId(getBankReferenceId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreditAppId(getCreditAppId());
		clone.setSequenceNumber(getSequenceNumber());
		clone.setBankReferenceName(getBankReferenceName());
		clone.setBankReferenceContact(getBankReferenceContact());
		clone.setBankReferencePhone(getBankReferencePhone());
		clone.setBankReferencAccountType(getBankReferencAccountType());
		clone.setBankReferenceAccountNumber(getBankReferenceAccountNumber());

		return clone;
	}

	@Override
	public int compareTo(CreditAppBankReference creditAppBankReference) {
		int value = 0;

		if (getSequenceNumber() < creditAppBankReference.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > creditAppBankReference.getSequenceNumber()) {
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

		if (!(obj instanceof CreditAppBankReferenceClp)) {
			return false;
		}

		CreditAppBankReferenceClp creditAppBankReference = (CreditAppBankReferenceClp)obj;

		long primaryKey = creditAppBankReference.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{bankReferenceId=");
		sb.append(getBankReferenceId());
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
		sb.append(", bankReferenceName=");
		sb.append(getBankReferenceName());
		sb.append(", bankReferenceContact=");
		sb.append(getBankReferenceContact());
		sb.append(", bankReferencePhone=");
		sb.append(getBankReferencePhone());
		sb.append(", bankReferencAccountType=");
		sb.append(getBankReferencAccountType());
		sb.append(", bankReferenceAccountNumber=");
		sb.append(getBankReferenceAccountNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditAppBankReference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bankReferenceId</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceId());
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
			"<column><column-name>bankReferenceName</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferenceContact</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferencePhone</column-name><column-value><![CDATA[");
		sb.append(getBankReferencePhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferencAccountType</column-name><column-value><![CDATA[");
		sb.append(getBankReferencAccountType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankReferenceAccountNumber</column-name><column-value><![CDATA[");
		sb.append(getBankReferenceAccountNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bankReferenceId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditAppId;
	private long _sequenceNumber;
	private String _bankReferenceName;
	private String _bankReferenceContact;
	private String _bankReferencePhone;
	private String _bankReferencAccountType;
	private String _bankReferenceAccountNumber;
	private BaseModel<?> _creditAppBankReferenceRemoteModel;
}