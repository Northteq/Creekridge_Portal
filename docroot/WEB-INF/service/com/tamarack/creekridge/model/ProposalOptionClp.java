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
import com.tamarack.creekridge.service.ProposalOptionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tamarack Consulting
 */
public class ProposalOptionClp extends BaseModelImpl<ProposalOption>
	implements ProposalOption {
	public ProposalOptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProposalOption.class;
	}

	@Override
	public String getModelClassName() {
		return ProposalOption.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _proposalOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProposalOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _proposalOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proposalOptionId", getProposalOptionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("creditAppId", getCreditAppId());
		attributes.put("productId", getProductId());
		attributes.put("termId", getTermId());
		attributes.put("purchaseOptionId", getPurchaseOptionId());
		attributes.put("rateFactorRuleId", getRateFactorRuleId());
		attributes.put("paymentAmount", getPaymentAmount());
		attributes.put("equipmentPrice", getEquipmentPrice());
		attributes.put("includeInProposal", getIncludeInProposal());
		attributes.put("useForCreditApp", getUseForCreditApp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proposalOptionId = (Long)attributes.get("proposalOptionId");

		if (proposalOptionId != null) {
			setProposalOptionId(proposalOptionId);
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

		Long rateFactorRuleId = (Long)attributes.get("rateFactorRuleId");

		if (rateFactorRuleId != null) {
			setRateFactorRuleId(rateFactorRuleId);
		}

		Double paymentAmount = (Double)attributes.get("paymentAmount");

		if (paymentAmount != null) {
			setPaymentAmount(paymentAmount);
		}

		Double equipmentPrice = (Double)attributes.get("equipmentPrice");

		if (equipmentPrice != null) {
			setEquipmentPrice(equipmentPrice);
		}

		Boolean includeInProposal = (Boolean)attributes.get("includeInProposal");

		if (includeInProposal != null) {
			setIncludeInProposal(includeInProposal);
		}

		Boolean useForCreditApp = (Boolean)attributes.get("useForCreditApp");

		if (useForCreditApp != null) {
			setUseForCreditApp(useForCreditApp);
		}
	}

	@Override
	public long getProposalOptionId() {
		return _proposalOptionId;
	}

	@Override
	public void setProposalOptionId(long proposalOptionId) {
		_proposalOptionId = proposalOptionId;

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setProposalOptionId",
						long.class);

				method.invoke(_proposalOptionRemoteModel, proposalOptionId);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_proposalOptionRemoteModel, companyId);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_proposalOptionRemoteModel, userId);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_proposalOptionRemoteModel, userName);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_proposalOptionRemoteModel, createDate);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_proposalOptionRemoteModel, modifiedDate);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditAppId", long.class);

				method.invoke(_proposalOptionRemoteModel, creditAppId);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setProductId", long.class);

				method.invoke(_proposalOptionRemoteModel, productId);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setTermId", long.class);

				method.invoke(_proposalOptionRemoteModel, termId);
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

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPurchaseOptionId",
						long.class);

				method.invoke(_proposalOptionRemoteModel, purchaseOptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRateFactorRuleId() {
		return _rateFactorRuleId;
	}

	@Override
	public void setRateFactorRuleId(long rateFactorRuleId) {
		_rateFactorRuleId = rateFactorRuleId;

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setRateFactorRuleId",
						long.class);

				method.invoke(_proposalOptionRemoteModel, rateFactorRuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPaymentAmount() {
		return _paymentAmount;
	}

	@Override
	public void setPaymentAmount(double paymentAmount) {
		_paymentAmount = paymentAmount;

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentAmount", double.class);

				method.invoke(_proposalOptionRemoteModel, paymentAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getEquipmentPrice() {
		return _equipmentPrice;
	}

	@Override
	public void setEquipmentPrice(double equipmentPrice) {
		_equipmentPrice = equipmentPrice;

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setEquipmentPrice",
						double.class);

				method.invoke(_proposalOptionRemoteModel, equipmentPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIncludeInProposal() {
		return _includeInProposal;
	}

	@Override
	public boolean isIncludeInProposal() {
		return _includeInProposal;
	}

	@Override
	public void setIncludeInProposal(boolean includeInProposal) {
		_includeInProposal = includeInProposal;

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setIncludeInProposal",
						boolean.class);

				method.invoke(_proposalOptionRemoteModel, includeInProposal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getUseForCreditApp() {
		return _useForCreditApp;
	}

	@Override
	public boolean isUseForCreditApp() {
		return _useForCreditApp;
	}

	@Override
	public void setUseForCreditApp(boolean useForCreditApp) {
		_useForCreditApp = useForCreditApp;

		if (_proposalOptionRemoteModel != null) {
			try {
				Class<?> clazz = _proposalOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUseForCreditApp",
						boolean.class);

				method.invoke(_proposalOptionRemoteModel, useForCreditApp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProposalOptionRemoteModel() {
		return _proposalOptionRemoteModel;
	}

	public void setProposalOptionRemoteModel(
		BaseModel<?> proposalOptionRemoteModel) {
		_proposalOptionRemoteModel = proposalOptionRemoteModel;
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

		Class<?> remoteModelClass = _proposalOptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_proposalOptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProposalOptionLocalServiceUtil.addProposalOption(this);
		}
		else {
			ProposalOptionLocalServiceUtil.updateProposalOption(this);
		}
	}

	@Override
	public ProposalOption toEscapedModel() {
		return (ProposalOption)ProxyUtil.newProxyInstance(ProposalOption.class.getClassLoader(),
			new Class[] { ProposalOption.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProposalOptionClp clone = new ProposalOptionClp();

		clone.setProposalOptionId(getProposalOptionId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreditAppId(getCreditAppId());
		clone.setProductId(getProductId());
		clone.setTermId(getTermId());
		clone.setPurchaseOptionId(getPurchaseOptionId());
		clone.setRateFactorRuleId(getRateFactorRuleId());
		clone.setPaymentAmount(getPaymentAmount());
		clone.setEquipmentPrice(getEquipmentPrice());
		clone.setIncludeInProposal(getIncludeInProposal());
		clone.setUseForCreditApp(getUseForCreditApp());

		return clone;
	}

	@Override
	public int compareTo(ProposalOption proposalOption) {
		long primaryKey = proposalOption.getPrimaryKey();

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

		if (!(obj instanceof ProposalOptionClp)) {
			return false;
		}

		ProposalOptionClp proposalOption = (ProposalOptionClp)obj;

		long primaryKey = proposalOption.getPrimaryKey();

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

		sb.append("{proposalOptionId=");
		sb.append(getProposalOptionId());
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
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", termId=");
		sb.append(getTermId());
		sb.append(", purchaseOptionId=");
		sb.append(getPurchaseOptionId());
		sb.append(", rateFactorRuleId=");
		sb.append(getRateFactorRuleId());
		sb.append(", paymentAmount=");
		sb.append(getPaymentAmount());
		sb.append(", equipmentPrice=");
		sb.append(getEquipmentPrice());
		sb.append(", includeInProposal=");
		sb.append(getIncludeInProposal());
		sb.append(", useForCreditApp=");
		sb.append(getUseForCreditApp());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.tamarack.creekridge.model.ProposalOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>proposalOptionId</column-name><column-value><![CDATA[");
		sb.append(getProposalOptionId());
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
			"<column><column-name>rateFactorRuleId</column-name><column-value><![CDATA[");
		sb.append(getRateFactorRuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentAmount</column-name><column-value><![CDATA[");
		sb.append(getPaymentAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>equipmentPrice</column-name><column-value><![CDATA[");
		sb.append(getEquipmentPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>includeInProposal</column-name><column-value><![CDATA[");
		sb.append(getIncludeInProposal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useForCreditApp</column-name><column-value><![CDATA[");
		sb.append(getUseForCreditApp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _proposalOptionId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _creditAppId;
	private long _productId;
	private long _termId;
	private long _purchaseOptionId;
	private long _rateFactorRuleId;
	private double _paymentAmount;
	private double _equipmentPrice;
	private boolean _includeInProposal;
	private boolean _useForCreditApp;
	private BaseModel<?> _proposalOptionRemoteModel;
}