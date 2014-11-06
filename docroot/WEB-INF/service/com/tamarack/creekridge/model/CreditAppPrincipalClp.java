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
import com.tamarack.creekridge.service.CreditAppPrincipalLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pmacha
 */
public class CreditAppPrincipalClp extends BaseModelImpl<CreditAppPrincipal>
	implements CreditAppPrincipal {
	public CreditAppPrincipalClp() {
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
	public long getPrimaryKey() {
		return _principalId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPrincipalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _principalId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getPrincipalId() {
		return _principalId;
	}

	@Override
	public void setPrincipalId(long principalId) {
		_principalId = principalId;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalId", long.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalId);
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

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_creditAppPrincipalRemoteModel, companyId);
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

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_creditAppPrincipalRemoteModel, userId);
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

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_creditAppPrincipalRemoteModel, userName);
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

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_creditAppPrincipalRemoteModel, createDate);
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

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_creditAppPrincipalRemoteModel, modifiedDate);
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

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppId", long.class);

				method.invoke(_creditAppPrincipalRemoteModel, creditAppId);
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

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setSequenceNumber", long.class);

				method.invoke(_creditAppPrincipalRemoteModel, sequenceNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalFirstName() {
		return _principalFirstName;
	}

	@Override
	public void setPrincipalFirstName(String principalFirstName) {
		_principalFirstName = principalFirstName;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalFirstName",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalFirstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalMiddleName() {
		return _principalMiddleName;
	}

	@Override
	public void setPrincipalMiddleName(String principalMiddleName) {
		_principalMiddleName = principalMiddleName;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalMiddleName",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel,
					principalMiddleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalLastName() {
		return _principalLastName;
	}

	@Override
	public void setPrincipalLastName(String principalLastName) {
		_principalLastName = principalLastName;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalLastName",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalLastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalSSN() {
		return _principalSSN;
	}

	@Override
	public void setPrincipalSSN(String principalSSN) {
		_principalSSN = principalSSN;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalSSN", String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalSSN);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalHomePhoneNumber() {
		return _principalHomePhoneNumber;
	}

	@Override
	public void setPrincipalHomePhoneNumber(String principalHomePhoneNumber) {
		_principalHomePhoneNumber = principalHomePhoneNumber;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalHomePhoneNumber",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel,
					principalHomePhoneNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalAddress1() {
		return _principalAddress1;
	}

	@Override
	public void setPrincipalAddress1(String principalAddress1) {
		_principalAddress1 = principalAddress1;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalAddress1",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalAddress1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalAddress2() {
		return _principalAddress2;
	}

	@Override
	public void setPrincipalAddress2(String principalAddress2) {
		_principalAddress2 = principalAddress2;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalAddress2",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalAddress2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalCity() {
		return _principalCity;
	}

	@Override
	public void setPrincipalCity(String principalCity) {
		_principalCity = principalCity;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalCity", String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalState() {
		return _principalState;
	}

	@Override
	public void setPrincipalState(String principalState) {
		_principalState = principalState;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalState",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalZip() {
		return _principalZip;
	}

	@Override
	public void setPrincipalZip(String principalZip) {
		_principalZip = principalZip;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalZip", String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalZip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrincipalEmail() {
		return _principalEmail;
	}

	@Override
	public void setPrincipalEmail(String principalEmail) {
		_principalEmail = principalEmail;

		if (_creditAppPrincipalRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppPrincipalRemoteModel.getClass();

				Method method = clazz.getMethod("setPrincipalEmail",
						String.class);

				method.invoke(_creditAppPrincipalRemoteModel, principalEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCreditAppPrincipalRemoteModel() {
		return _creditAppPrincipalRemoteModel;
	}

	public void setCreditAppPrincipalRemoteModel(
		BaseModel<?> creditAppPrincipalRemoteModel) {
		_creditAppPrincipalRemoteModel = creditAppPrincipalRemoteModel;
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

		Class<?> remoteModelClass = _creditAppPrincipalRemoteModel.getClass();

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

		Object returnValue = method.invoke(_creditAppPrincipalRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CreditAppPrincipalLocalServiceUtil.addCreditAppPrincipal(this);
		}
		else {
			CreditAppPrincipalLocalServiceUtil.updateCreditAppPrincipal(this);
		}
	}

	@Override
	public CreditAppPrincipal toEscapedModel() {
		return (CreditAppPrincipal)ProxyUtil.newProxyInstance(CreditAppPrincipal.class.getClassLoader(),
			new Class[] { CreditAppPrincipal.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CreditAppPrincipalClp clone = new CreditAppPrincipalClp();

		clone.setPrincipalId(getPrincipalId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreditAppId(getCreditAppId());
		clone.setSequenceNumber(getSequenceNumber());
		clone.setPrincipalFirstName(getPrincipalFirstName());
		clone.setPrincipalMiddleName(getPrincipalMiddleName());
		clone.setPrincipalLastName(getPrincipalLastName());
		clone.setPrincipalSSN(getPrincipalSSN());
		clone.setPrincipalHomePhoneNumber(getPrincipalHomePhoneNumber());
		clone.setPrincipalAddress1(getPrincipalAddress1());
		clone.setPrincipalAddress2(getPrincipalAddress2());
		clone.setPrincipalCity(getPrincipalCity());
		clone.setPrincipalState(getPrincipalState());
		clone.setPrincipalZip(getPrincipalZip());
		clone.setPrincipalEmail(getPrincipalEmail());

		return clone;
	}

	@Override
	public int compareTo(CreditAppPrincipal creditAppPrincipal) {
		int value = 0;

		value = getPrincipalFirstName()
					.compareTo(creditAppPrincipal.getPrincipalFirstName());

		if (value != 0) {
			return value;
		}

		if (getSequenceNumber() < creditAppPrincipal.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > creditAppPrincipal.getSequenceNumber()) {
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

		if (!(obj instanceof CreditAppPrincipalClp)) {
			return false;
		}

		CreditAppPrincipalClp creditAppPrincipal = (CreditAppPrincipalClp)obj;

		long primaryKey = creditAppPrincipal.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{principalId=");
		sb.append(getPrincipalId());
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
		sb.append(", principalFirstName=");
		sb.append(getPrincipalFirstName());
		sb.append(", principalMiddleName=");
		sb.append(getPrincipalMiddleName());
		sb.append(", principalLastName=");
		sb.append(getPrincipalLastName());
		sb.append(", principalSSN=");
		sb.append(getPrincipalSSN());
		sb.append(", principalHomePhoneNumber=");
		sb.append(getPrincipalHomePhoneNumber());
		sb.append(", principalAddress1=");
		sb.append(getPrincipalAddress1());
		sb.append(", principalAddress2=");
		sb.append(getPrincipalAddress2());
		sb.append(", principalCity=");
		sb.append(getPrincipalCity());
		sb.append(", principalState=");
		sb.append(getPrincipalState());
		sb.append(", principalZip=");
		sb.append(getPrincipalZip());
		sb.append(", principalEmail=");
		sb.append(getPrincipalEmail());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditAppPrincipal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>principalId</column-name><column-value><![CDATA[");
		sb.append(getPrincipalId());
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
			"<column><column-name>principalFirstName</column-name><column-value><![CDATA[");
		sb.append(getPrincipalFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalMiddleName</column-name><column-value><![CDATA[");
		sb.append(getPrincipalMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalLastName</column-name><column-value><![CDATA[");
		sb.append(getPrincipalLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalSSN</column-name><column-value><![CDATA[");
		sb.append(getPrincipalSSN());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalHomePhoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPrincipalHomePhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalAddress1</column-name><column-value><![CDATA[");
		sb.append(getPrincipalAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalAddress2</column-name><column-value><![CDATA[");
		sb.append(getPrincipalAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalCity</column-name><column-value><![CDATA[");
		sb.append(getPrincipalCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalState</column-name><column-value><![CDATA[");
		sb.append(getPrincipalState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalZip</column-name><column-value><![CDATA[");
		sb.append(getPrincipalZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalEmail</column-name><column-value><![CDATA[");
		sb.append(getPrincipalEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _principalId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _creditAppPrincipalRemoteModel;
}