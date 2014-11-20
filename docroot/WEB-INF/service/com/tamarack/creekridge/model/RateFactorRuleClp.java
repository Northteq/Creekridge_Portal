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
import com.tamarack.creekridge.service.RateFactorRuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pmacha
 */
public class RateFactorRuleClp extends BaseModelImpl<RateFactorRule>
	implements RateFactorRule {
	public RateFactorRuleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RateFactorRule.class;
	}

	@Override
	public String getModelClassName() {
		return RateFactorRule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rateFactorRuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRateFactorRuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rateFactorRuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rateFactorRuleId", getRateFactorRuleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productId", getProductId());
		attributes.put("termId", getTermId());
		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("vendorId", getVendorId());
		attributes.put("minPrice", getMinPrice());
		attributes.put("rateFactor", getRateFactor());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("active", getActive());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rateFactorRuleId = (Long)attributes.get("rateFactorRuleId");

		if (rateFactorRuleId != null) {
			setRateFactorRuleId(rateFactorRuleId);
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

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		Long purchaseOptionId = (Long)attributes.get("purchaseOptionId");

		if (purchaseOptionId != null) {
			setPurchaseOptionId(purchaseOptionId);
		}

		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		Double minPrice = (Double)attributes.get("minPrice");

		if (minPrice != null) {
			setMinPrice(minPrice);
		}

		Double rateFactor = (Double)attributes.get("rateFactor");

		if (rateFactor != null) {
			setRateFactor(rateFactor);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	@Override
	public long getRateFactorRuleId() {
		return _rateFactorRuleId;
	}

	@Override
	public void setRateFactorRuleId(long rateFactorRuleId) {
		_rateFactorRuleId = rateFactorRuleId;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setRateFactorRuleId",
						long.class);

				method.invoke(_rateFactorRuleRemoteModel, rateFactorRuleId);
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

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rateFactorRuleRemoteModel, companyId);
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

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rateFactorRuleRemoteModel, userId);
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

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rateFactorRuleRemoteModel, userName);
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

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rateFactorRuleRemoteModel, createDate);
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

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rateFactorRuleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductId() {
		return _productId;
	}

	@Override
	public void setProductId(long productId) {
		_productId = productId;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setProductId", long.class);

				method.invoke(_rateFactorRuleRemoteModel, productId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTermId() {
		return _termId;
	}

	@Override
	public void setTermId(long termId) {
		_termId = termId;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setTermId", long.class);

				method.invoke(_rateFactorRuleRemoteModel, termId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPurchaseOptionId() {
		return _purchaseOptionId;
	}

	@Override
	public void setPurchaseOptionId(long purchaseOptionId) {
		_purchaseOptionId = purchaseOptionId;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchaseOptionId",
						long.class);

				method.invoke(_rateFactorRuleRemoteModel, purchaseOptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVendorId() {
		return _vendorId;
	}

	@Override
	public void setVendorId(long vendorId) {
		_vendorId = vendorId;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setVendorId", long.class);

				method.invoke(_rateFactorRuleRemoteModel, vendorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMinPrice() {
		return _minPrice;
	}

	@Override
	public void setMinPrice(double minPrice) {
		_minPrice = minPrice;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setMinPrice", double.class);

				method.invoke(_rateFactorRuleRemoteModel, minPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getRateFactor() {
		return _rateFactor;
	}

	@Override
	public void setRateFactor(double rateFactor) {
		_rateFactor = rateFactor;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setRateFactor", double.class);

				method.invoke(_rateFactorRuleRemoteModel, rateFactor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveDate", Date.class);

				method.invoke(_rateFactorRuleRemoteModel, effectiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_rateFactorRuleRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;

		if (_rateFactorRuleRemoteModel != null) {
			try {
				Class<?> clazz = _rateFactorRuleRemoteModel.getClass();

				Method method = clazz.getMethod("setExpirationDate", Date.class);

				method.invoke(_rateFactorRuleRemoteModel, expirationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRateFactorRuleRemoteModel() {
		return _rateFactorRuleRemoteModel;
	}

	public void setRateFactorRuleRemoteModel(
		BaseModel<?> rateFactorRuleRemoteModel) {
		_rateFactorRuleRemoteModel = rateFactorRuleRemoteModel;
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

		Class<?> remoteModelClass = _rateFactorRuleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_rateFactorRuleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RateFactorRuleLocalServiceUtil.addRateFactorRule(this);
		}
		else {
			RateFactorRuleLocalServiceUtil.updateRateFactorRule(this);
		}
	}

	@Override
	public RateFactorRule toEscapedModel() {
		return (RateFactorRule)ProxyUtil.newProxyInstance(RateFactorRule.class.getClassLoader(),
			new Class[] { RateFactorRule.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RateFactorRuleClp clone = new RateFactorRuleClp();

		clone.setRateFactorRuleId(getRateFactorRuleId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setProductId(getProductId());
		clone.setTermId(getTermId());
		clone.setPurchaseOptionId(getPurchaseOptionId());
		clone.setVendorId(getVendorId());
		clone.setMinPrice(getMinPrice());
		clone.setRateFactor(getRateFactor());
		clone.setEffectiveDate(getEffectiveDate());
		clone.setActive(getActive());
		clone.setExpirationDate(getExpirationDate());

		return clone;
	}

	@Override
	public int compareTo(RateFactorRule rateFactorRule) {
		long primaryKey = rateFactorRule.getPrimaryKey();

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

		if (!(obj instanceof RateFactorRuleClp)) {
			return false;
		}

		RateFactorRuleClp rateFactorRule = (RateFactorRuleClp)obj;

		long primaryKey = rateFactorRule.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{rateFactorRuleId=");
		sb.append(getRateFactorRuleId());
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
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", termId=");
		sb.append(getTermId());
		sb.append(", purchaseOptionId=");
		sb.append(getPurchaseOptionId());
		sb.append(", vendorId=");
		sb.append(getVendorId());
		sb.append(", minPrice=");
		sb.append(getMinPrice());
		sb.append(", rateFactor=");
		sb.append(getRateFactor());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", expirationDate=");
		sb.append(getExpirationDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.RateFactorRule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rateFactorRuleId</column-name><column-value><![CDATA[");
		sb.append(getRateFactorRuleId());
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
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termId</column-name><column-value><![CDATA[");
		sb.append(getTermId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>purchaseOptionId</column-name><column-value><![CDATA[");
		sb.append(getPurchaseOptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vendorId</column-name><column-value><![CDATA[");
		sb.append(getVendorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minPrice</column-name><column-value><![CDATA[");
		sb.append(getMinPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rateFactor</column-name><column-value><![CDATA[");
		sb.append(getRateFactor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expirationDate</column-name><column-value><![CDATA[");
		sb.append(getExpirationDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _rateFactorRuleId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _productId;
	private long _termId;
	private long _purchaseOptionId;
	private long _vendorId;
	private double _minPrice;
	private double _rateFactor;
	private Date _effectiveDate;
	private boolean _active;
	private Date _expirationDate;
	private BaseModel<?> _rateFactorRuleRemoteModel;
}