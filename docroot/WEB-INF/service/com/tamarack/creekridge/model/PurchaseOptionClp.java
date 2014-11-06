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
import com.tamarack.creekridge.service.PurchaseOptionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pmacha
 */
public class PurchaseOptionClp extends BaseModelImpl<PurchaseOption>
	implements PurchaseOption {
	public PurchaseOptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PurchaseOption.class;
	}

	@Override
	public String getModelClassName() {
		return PurchaseOption.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _purchaseOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPurchaseOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _purchaseOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("purchaseOptionName", getPurchaseOptionName());
		attributes.put("sequenceNumber", getSequenceNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long purchaseOptionId = (Long)attributes.get("purchaseOptionId");

		if (purchaseOptionId != null) {
			setPurchaseOptionId(purchaseOptionId);
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

		String purchaseOptionName = (String)attributes.get("purchaseOptionName");

		if (purchaseOptionName != null) {
			setPurchaseOptionName(purchaseOptionName);
		}

		Long sequenceNumber = (Long)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}
	}

	@Override
	public long getPurchaseOptionId() {
		return _purchaseOptionId;
	}

	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_purchaseOptionId = purchaseOptionId;

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchaseOptionId",
						long.class);

				method.invoke(_purchaseOptionRemoteModel, purchaseOptionId);
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

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_purchaseOptionRemoteModel, companyId);
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

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_purchaseOptionRemoteModel, userId);
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

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_purchaseOptionRemoteModel, userName);
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

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_purchaseOptionRemoteModel, createDate);
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

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_purchaseOptionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPurchaseOptionName() {
		return _purchaseOptionName;
	}

	@Override
	public void setPurchaseOptionName(String purchaseOptionName) {
		_purchaseOptionName = purchaseOptionName;

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchaseOptionName",
						String.class);

				method.invoke(_purchaseOptionRemoteModel, purchaseOptionName);
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

		if (_purchaseOptionRemoteModel != null) {
			try {
				Class<?> clazz = _purchaseOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSequenceNumber", long.class);

				method.invoke(_purchaseOptionRemoteModel, sequenceNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPurchaseOptionRemoteModel() {
		return _purchaseOptionRemoteModel;
	}

	public void setPurchaseOptionRemoteModel(
		BaseModel<?> purchaseOptionRemoteModel) {
		_purchaseOptionRemoteModel = purchaseOptionRemoteModel;
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

		Class<?> remoteModelClass = _purchaseOptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_purchaseOptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PurchaseOptionLocalServiceUtil.addPurchaseOption(this);
		}
		else {
			PurchaseOptionLocalServiceUtil.updatePurchaseOption(this);
		}
	}

	@Override
	public PurchaseOption toEscapedModel() {
		return (PurchaseOption)ProxyUtil.newProxyInstance(PurchaseOption.class.getClassLoader(),
			new Class[] { PurchaseOption.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PurchaseOptionClp clone = new PurchaseOptionClp();

		clone.setPurchaseOptionId(getPurchaseOptionId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPurchaseOptionName(getPurchaseOptionName());
		clone.setSequenceNumber(getSequenceNumber());

		return clone;
	}

	@Override
	public int compareTo(PurchaseOption purchaseOption) {
		int value = 0;

		if (getSequenceNumber() < purchaseOption.getSequenceNumber()) {
			value = -1;
		}
		else if (getSequenceNumber() > purchaseOption.getSequenceNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getPurchaseOptionName()
					.compareTo(purchaseOption.getPurchaseOptionName());

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

		if (!(obj instanceof PurchaseOptionClp)) {
			return false;
		}

		PurchaseOptionClp purchaseOption = (PurchaseOptionClp)obj;

		long primaryKey = purchaseOption.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{purchaseOptionId=");
		sb.append(getPurchaseOptionId());
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
		sb.append(", purchaseOptionName=");
		sb.append(getPurchaseOptionName());
		sb.append(", sequenceNumber=");
		sb.append(getSequenceNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.PurchaseOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>purchaseOptionId</column-name><column-value><![CDATA[");
		sb.append(getPurchaseOptionId());
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
			"<column><column-name>purchaseOptionName</column-name><column-value><![CDATA[");
		sb.append(getPurchaseOptionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNumber</column-name><column-value><![CDATA[");
		sb.append(getSequenceNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _purchaseOptionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _purchaseOptionName;
	private long _sequenceNumber;
	private BaseModel<?> _purchaseOptionRemoteModel;
}