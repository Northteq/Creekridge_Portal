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
import com.tamarack.creekridge.service.VendorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pmacha
 */
public class VendorClp extends BaseModelImpl<Vendor> implements Vendor {
	public VendorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Vendor.class;
	}

	@Override
	public String getModelClassName() {
		return Vendor.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _vendorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVendorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vendorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vendorId", getVendorId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("multiSelectProduct", getMultiSelectProduct());
		attributes.put("multiSelectPurchaseOption",
			getMultiSelectPurchaseOption());
		attributes.put("multiSelectTerm", getMultiSelectTerm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Boolean multiSelectProduct = (Boolean)attributes.get(
				"multiSelectProduct");

		if (multiSelectProduct != null) {
			setMultiSelectProduct(multiSelectProduct);
		}

		Boolean multiSelectPurchaseOption = (Boolean)attributes.get(
				"multiSelectPurchaseOption");

		if (multiSelectPurchaseOption != null) {
			setMultiSelectPurchaseOption(multiSelectPurchaseOption);
		}

		Boolean multiSelectTerm = (Boolean)attributes.get("multiSelectTerm");

		if (multiSelectTerm != null) {
			setMultiSelectTerm(multiSelectTerm);
		}
	}

	@Override
	public long getVendorId() {
		return _vendorId;
	}

	@Override
	public void setVendorId(long vendorId) {
		_vendorId = vendorId;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorId", long.class);

				method.invoke(_vendorRemoteModel, vendorId);
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

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vendorRemoteModel, companyId);
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

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vendorRemoteModel, userId);
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

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vendorRemoteModel, userName);
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

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_vendorRemoteModel, createDate);
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

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_vendorRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vendorRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMultiSelectProduct() {
		return _multiSelectProduct;
	}

	@Override
	public boolean isMultiSelectProduct() {
		return _multiSelectProduct;
	}

	@Override
	public void setMultiSelectProduct(boolean multiSelectProduct) {
		_multiSelectProduct = multiSelectProduct;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setMultiSelectProduct",
						boolean.class);

				method.invoke(_vendorRemoteModel, multiSelectProduct);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMultiSelectPurchaseOption() {
		return _multiSelectPurchaseOption;
	}

	@Override
	public boolean isMultiSelectPurchaseOption() {
		return _multiSelectPurchaseOption;
	}

	@Override
	public void setMultiSelectPurchaseOption(boolean multiSelectPurchaseOption) {
		_multiSelectPurchaseOption = multiSelectPurchaseOption;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setMultiSelectPurchaseOption",
						boolean.class);

				method.invoke(_vendorRemoteModel, multiSelectPurchaseOption);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMultiSelectTerm() {
		return _multiSelectTerm;
	}

	@Override
	public boolean isMultiSelectTerm() {
		return _multiSelectTerm;
	}

	@Override
	public void setMultiSelectTerm(boolean multiSelectTerm) {
		_multiSelectTerm = multiSelectTerm;

		if (_vendorRemoteModel != null) {
			try {
				Class<?> clazz = _vendorRemoteModel.getClass();

				Method method = clazz.getMethod("setMultiSelectTerm",
						boolean.class);

				method.invoke(_vendorRemoteModel, multiSelectTerm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVendorRemoteModel() {
		return _vendorRemoteModel;
	}

	public void setVendorRemoteModel(BaseModel<?> vendorRemoteModel) {
		_vendorRemoteModel = vendorRemoteModel;
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

		Class<?> remoteModelClass = _vendorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vendorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VendorLocalServiceUtil.addVendor(this);
		}
		else {
			VendorLocalServiceUtil.updateVendor(this);
		}
	}

	@Override
	public Vendor toEscapedModel() {
		return (Vendor)ProxyUtil.newProxyInstance(Vendor.class.getClassLoader(),
			new Class[] { Vendor.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VendorClp clone = new VendorClp();

		clone.setVendorId(getVendorId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGroupId(getGroupId());
		clone.setMultiSelectProduct(getMultiSelectProduct());
		clone.setMultiSelectPurchaseOption(getMultiSelectPurchaseOption());
		clone.setMultiSelectTerm(getMultiSelectTerm());

		return clone;
	}

	@Override
	public int compareTo(Vendor vendor) {
		long primaryKey = vendor.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VendorClp)) {
			return false;
		}

		VendorClp vendor = (VendorClp)obj;

		long primaryKey = vendor.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{vendorId=");
		sb.append(getVendorId());
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
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", multiSelectProduct=");
		sb.append(getMultiSelectProduct());
		sb.append(", multiSelectPurchaseOption=");
		sb.append(getMultiSelectPurchaseOption());
		sb.append(", multiSelectTerm=");
		sb.append(getMultiSelectTerm());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.Vendor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vendorId</column-name><column-value><![CDATA[");
		sb.append(getVendorId());
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
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>multiSelectProduct</column-name><column-value><![CDATA[");
		sb.append(getMultiSelectProduct());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>multiSelectPurchaseOption</column-name><column-value><![CDATA[");
		sb.append(getMultiSelectPurchaseOption());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>multiSelectTerm</column-name><column-value><![CDATA[");
		sb.append(getMultiSelectTerm());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _vendorId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private boolean _multiSelectProduct;
	private boolean _multiSelectPurchaseOption;
	private boolean _multiSelectTerm;
	private BaseModel<?> _vendorRemoteModel;
}