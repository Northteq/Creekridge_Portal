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

package com.tamarack.creekridge.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.tamarack.creekridge.model.VendorMessage;
import com.tamarack.creekridge.model.VendorMessageModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the VendorMessage service. Represents a row in the &quot;eCreekRidge_VendorMessage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tamarack.creekridge.model.VendorMessageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VendorMessageImpl}.
 * </p>
 *
 * @author tamarack
 * @see VendorMessageImpl
 * @see com.tamarack.creekridge.model.VendorMessage
 * @see com.tamarack.creekridge.model.VendorMessageModel
 * @generated
 */
public class VendorMessageModelImpl extends BaseModelImpl<VendorMessage>
	implements VendorMessageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vendor message model instance should use the {@link com.tamarack.creekridge.model.VendorMessage} interface instead.
	 */
	public static final String TABLE_NAME = "eCreekRidge_VendorMessage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "vendorId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "key_", Types.VARCHAR },
			{ "value", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eCreekRidge_VendorMessage (vendorId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,key_ VARCHAR(75) null,value VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eCreekRidge_VendorMessage";
	public static final String ORDER_BY_JPQL = " ORDER BY vendorMessage.vendorId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eCreekRidge_VendorMessage.vendorId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tamarack.creekridge.model.VendorMessage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tamarack.creekridge.model.VendorMessage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tamarack.creekridge.model.VendorMessage"),
			true);
	public static long KEY_COLUMN_BITMASK = 1L;
	public static long VENDORID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tamarack.creekridge.model.VendorMessage"));

	public VendorMessageModelImpl() {
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
	public Class<?> getModelClass() {
		return VendorMessage.class;
	}

	@Override
	public String getModelClassName() {
		return VendorMessage.class.getName();
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
		attributes.put("key", getKey());
		attributes.put("value", getValue());

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

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getVendorId() {
		return _vendorId;
	}

	@Override
	public void setVendorId(long vendorId) {
		_vendorId = vendorId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getKey() {
		if (_key == null) {
			return StringPool.BLANK;
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@Override
	public String getValue() {
		if (_value == null) {
			return StringPool.BLANK;
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		_value = value;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			VendorMessage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VendorMessage toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VendorMessage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VendorMessageImpl vendorMessageImpl = new VendorMessageImpl();

		vendorMessageImpl.setVendorId(getVendorId());
		vendorMessageImpl.setCompanyId(getCompanyId());
		vendorMessageImpl.setUserId(getUserId());
		vendorMessageImpl.setUserName(getUserName());
		vendorMessageImpl.setCreateDate(getCreateDate());
		vendorMessageImpl.setModifiedDate(getModifiedDate());
		vendorMessageImpl.setKey(getKey());
		vendorMessageImpl.setValue(getValue());

		vendorMessageImpl.resetOriginalValues();

		return vendorMessageImpl;
	}

	@Override
	public int compareTo(VendorMessage vendorMessage) {
		long primaryKey = vendorMessage.getPrimaryKey();

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

		if (!(obj instanceof VendorMessage)) {
			return false;
		}

		VendorMessage vendorMessage = (VendorMessage)obj;

		long primaryKey = vendorMessage.getPrimaryKey();

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
	public void resetOriginalValues() {
		VendorMessageModelImpl vendorMessageModelImpl = this;

		vendorMessageModelImpl._originalKey = vendorMessageModelImpl._key;

		vendorMessageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VendorMessage> toCacheModel() {
		VendorMessageCacheModel vendorMessageCacheModel = new VendorMessageCacheModel();

		vendorMessageCacheModel.vendorId = getVendorId();

		vendorMessageCacheModel.companyId = getCompanyId();

		vendorMessageCacheModel.userId = getUserId();

		vendorMessageCacheModel.userName = getUserName();

		String userName = vendorMessageCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			vendorMessageCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			vendorMessageCacheModel.createDate = createDate.getTime();
		}
		else {
			vendorMessageCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vendorMessageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vendorMessageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vendorMessageCacheModel.key = getKey();

		String key = vendorMessageCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			vendorMessageCacheModel.key = null;
		}

		vendorMessageCacheModel.value = getValue();

		String value = vendorMessageCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			vendorMessageCacheModel.value = null;
		}

		return vendorMessageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

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
		sb.append(", key=");
		sb.append(getKey());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.VendorMessage");
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
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VendorMessage.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			VendorMessage.class
		};
	private long _vendorId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _key;
	private String _originalKey;
	private String _value;
	private long _columnBitmask;
	private VendorMessage _escapedModel;
}