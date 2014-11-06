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
import com.tamarack.creekridge.service.CreditAppStatusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pmacha
 */
public class CreditAppStatusClp extends BaseModelImpl<CreditAppStatus>
	implements CreditAppStatus {
	public CreditAppStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CreditAppStatus.class;
	}

	@Override
	public String getModelClassName() {
		return CreditAppStatus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _CreditAppStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCreditAppStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CreditAppStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CreditAppStatusId", getCreditAppStatusId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppStatusName", getCreditAppStatusName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long CreditAppStatusId = (Long)attributes.get("CreditAppStatusId");

		if (CreditAppStatusId != null) {
			setCreditAppStatusId(CreditAppStatusId);
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

		String creditAppStatusName = (String)attributes.get(
				"creditAppStatusName");

		if (creditAppStatusName != null) {
			setCreditAppStatusName(creditAppStatusName);
		}
	}

	@Override
	public long getCreditAppStatusId() {
		return _CreditAppStatusId;
	}

	@Override
	public void setCreditAppStatusId(long CreditAppStatusId) {
		_CreditAppStatusId = CreditAppStatusId;

		if (_creditAppStatusRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppStatusId",
						long.class);

				method.invoke(_creditAppStatusRemoteModel, CreditAppStatusId);
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

		if (_creditAppStatusRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_creditAppStatusRemoteModel, companyId);
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

		if (_creditAppStatusRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_creditAppStatusRemoteModel, userId);
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

		if (_creditAppStatusRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_creditAppStatusRemoteModel, userName);
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

		if (_creditAppStatusRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_creditAppStatusRemoteModel, createDate);
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

		if (_creditAppStatusRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_creditAppStatusRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreditAppStatusName() {
		return _creditAppStatusName;
	}

	@Override
	public void setCreditAppStatusName(String creditAppStatusName) {
		_creditAppStatusName = creditAppStatusName;

		if (_creditAppStatusRemoteModel != null) {
			try {
				Class<?> clazz = _creditAppStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppStatusName",
						String.class);

				method.invoke(_creditAppStatusRemoteModel, creditAppStatusName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCreditAppStatusRemoteModel() {
		return _creditAppStatusRemoteModel;
	}

	public void setCreditAppStatusRemoteModel(
		BaseModel<?> creditAppStatusRemoteModel) {
		_creditAppStatusRemoteModel = creditAppStatusRemoteModel;
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

		Class<?> remoteModelClass = _creditAppStatusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_creditAppStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CreditAppStatusLocalServiceUtil.addCreditAppStatus(this);
		}
		else {
			CreditAppStatusLocalServiceUtil.updateCreditAppStatus(this);
		}
	}

	@Override
	public CreditAppStatus toEscapedModel() {
		return (CreditAppStatus)ProxyUtil.newProxyInstance(CreditAppStatus.class.getClassLoader(),
			new Class[] { CreditAppStatus.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CreditAppStatusClp clone = new CreditAppStatusClp();

		clone.setCreditAppStatusId(getCreditAppStatusId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreditAppStatusName(getCreditAppStatusName());

		return clone;
	}

	@Override
	public int compareTo(CreditAppStatus creditAppStatus) {
		int value = 0;

		value = getCreditAppStatusName()
					.compareTo(creditAppStatus.getCreditAppStatusName());

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

		if (!(obj instanceof CreditAppStatusClp)) {
			return false;
		}

		CreditAppStatusClp creditAppStatus = (CreditAppStatusClp)obj;

		long primaryKey = creditAppStatus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{CreditAppStatusId=");
		sb.append(getCreditAppStatusId());
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
		sb.append(", creditAppStatusName=");
		sb.append(getCreditAppStatusName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.CreditAppStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CreditAppStatusId</column-name><column-value><![CDATA[");
		sb.append(getCreditAppStatusId());
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
			"<column><column-name>creditAppStatusName</column-name><column-value><![CDATA[");
		sb.append(getCreditAppStatusName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _CreditAppStatusId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _creditAppStatusName;
	private BaseModel<?> _creditAppStatusRemoteModel;
}