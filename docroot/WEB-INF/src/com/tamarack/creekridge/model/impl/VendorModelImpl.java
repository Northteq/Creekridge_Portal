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

import com.tamarack.creekridge.model.Vendor;
import com.tamarack.creekridge.model.VendorModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Vendor service. Represents a row in the &quot;eCreekRidge_Vendor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.tamarack.creekridge.model.VendorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VendorImpl}.
 * </p>
 *
 * @author Tamarack Consulting
 * @see VendorImpl
 * @see com.tamarack.creekridge.model.Vendor
 * @see com.tamarack.creekridge.model.VendorModel
 * @generated
 */
public class VendorModelImpl extends BaseModelImpl<Vendor>
	implements VendorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vendor model instance should use the {@link com.tamarack.creekridge.model.Vendor} interface instead.
	 */
	public static final String TABLE_NAME = "eCreekRidge_Vendor";
	public static final Object[][] TABLE_COLUMNS = {
			{ "vendorId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "multiSelectProduct", Types.BOOLEAN },
			{ "multiSelectPurchaseOption", Types.BOOLEAN },
			{ "multiSelectTerm", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table eCreekRidge_Vendor (vendorId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,groupId LONG,multiSelectProduct BOOLEAN,multiSelectPurchaseOption BOOLEAN,multiSelectTerm BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table eCreekRidge_Vendor";
	public static final String ORDER_BY_JPQL = " ORDER BY vendor.vendorId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eCreekRidge_Vendor.vendorId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.tamarack.creekridge.model.Vendor"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.tamarack.creekridge.model.Vendor"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.tamarack.creekridge.model.Vendor"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long VENDORID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.tamarack.creekridge.model.Vendor"));

	public VendorModelImpl() {
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
		return Vendor.class;
	}

	@Override
	public String getModelClassName() {
		return Vendor.class.getName();
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
		_columnBitmask |= VENDORID_COLUMN_BITMASK;

		if (!_setOriginalVendorId) {
			_setOriginalVendorId = true;

			_originalVendorId = _vendorId;
		}

		_vendorId = vendorId;
	}

	public long getOriginalVendorId() {
		return _originalVendorId;
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Vendor.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Vendor toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Vendor)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VendorImpl vendorImpl = new VendorImpl();

		vendorImpl.setVendorId(getVendorId());
		vendorImpl.setCompanyId(getCompanyId());
		vendorImpl.setUserId(getUserId());
		vendorImpl.setUserName(getUserName());
		vendorImpl.setCreateDate(getCreateDate());
		vendorImpl.setModifiedDate(getModifiedDate());
		vendorImpl.setGroupId(getGroupId());
		vendorImpl.setMultiSelectProduct(getMultiSelectProduct());
		vendorImpl.setMultiSelectPurchaseOption(getMultiSelectPurchaseOption());
		vendorImpl.setMultiSelectTerm(getMultiSelectTerm());

		vendorImpl.resetOriginalValues();

		return vendorImpl;
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

		if (!(obj instanceof Vendor)) {
			return false;
		}

		Vendor vendor = (Vendor)obj;

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
	public void resetOriginalValues() {
		VendorModelImpl vendorModelImpl = this;

		vendorModelImpl._originalVendorId = vendorModelImpl._vendorId;

		vendorModelImpl._setOriginalVendorId = false;

		vendorModelImpl._originalGroupId = vendorModelImpl._groupId;

		vendorModelImpl._setOriginalGroupId = false;

		vendorModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Vendor> toCacheModel() {
		VendorCacheModel vendorCacheModel = new VendorCacheModel();

		vendorCacheModel.vendorId = getVendorId();

		vendorCacheModel.companyId = getCompanyId();

		vendorCacheModel.userId = getUserId();

		vendorCacheModel.userName = getUserName();

		String userName = vendorCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			vendorCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			vendorCacheModel.createDate = createDate.getTime();
		}
		else {
			vendorCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vendorCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vendorCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vendorCacheModel.groupId = getGroupId();

		vendorCacheModel.multiSelectProduct = getMultiSelectProduct();

		vendorCacheModel.multiSelectPurchaseOption = getMultiSelectPurchaseOption();

		vendorCacheModel.multiSelectTerm = getMultiSelectTerm();

		return vendorCacheModel;
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

	private static ClassLoader _classLoader = Vendor.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Vendor.class };
	private long _vendorId;
	private long _originalVendorId;
	private boolean _setOriginalVendorId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private boolean _multiSelectProduct;
	private boolean _multiSelectPurchaseOption;
	private boolean _multiSelectTerm;
	private long _columnBitmask;
	private Vendor _escapedModel;
}