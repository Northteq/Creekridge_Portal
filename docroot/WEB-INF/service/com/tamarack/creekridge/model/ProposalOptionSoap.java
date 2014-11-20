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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pmacha
 * @generated
 */
public class ProposalOptionSoap implements Serializable {
	public static ProposalOptionSoap toSoapModel(ProposalOption model) {
		ProposalOptionSoap soapModel = new ProposalOptionSoap();

		soapModel.setProposalOptionId(model.getProposalOptionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreditAppId(model.getCreditAppId());
		soapModel.setProductId(model.getProductId());
		soapModel.setTermId(model.getTermId());
		soapModel.setPurchaseOptionId(model.getPurchaseOptionId());
		soapModel.setRateFactorRuleId(model.getRateFactorRuleId());
		soapModel.setPaymentAmount(model.getPaymentAmount());
		soapModel.setEquipmentPrice(model.getEquipmentPrice());
		soapModel.setIncludeInProposal(model.getIncludeInProposal());

		return soapModel;
	}

	public static ProposalOptionSoap[] toSoapModels(ProposalOption[] models) {
		ProposalOptionSoap[] soapModels = new ProposalOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProposalOptionSoap[][] toSoapModels(ProposalOption[][] models) {
		ProposalOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProposalOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProposalOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProposalOptionSoap[] toSoapModels(List<ProposalOption> models) {
		List<ProposalOptionSoap> soapModels = new ArrayList<ProposalOptionSoap>(models.size());

		for (ProposalOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProposalOptionSoap[soapModels.size()]);
	}

	public ProposalOptionSoap() {
	}

	public long getPrimaryKey() {
		return _proposalOptionId;
	}

	public void setPrimaryKey(long pk) {
		setProposalOptionId(pk);
	}

	public long getProposalOptionId() {
		return _proposalOptionId;
	}

	public void setProposalOptionId(long proposalOptionId) {
		_proposalOptionId = proposalOptionId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCreditAppId() {
		return _creditAppId;
	}

	public void setCreditAppId(long creditAppId) {
		_creditAppId = creditAppId;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getTermId() {
		return _termId;
	}

	public void setTermId(long termId) {
		_termId = termId;
	}

	public long getPurchaseOptionId() {
		return _purchaseOptionId;
	}

	public void setPurchaseOptionId(long purchaseOptionId) {
		_purchaseOptionId = purchaseOptionId;
	}

	public long getRateFactorRuleId() {
		return _rateFactorRuleId;
	}

	public void setRateFactorRuleId(long rateFactorRuleId) {
		_rateFactorRuleId = rateFactorRuleId;
	}

	public double getPaymentAmount() {
		return _paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		_paymentAmount = paymentAmount;
	}

	public double getEquipmentPrice() {
		return _equipmentPrice;
	}

	public void setEquipmentPrice(double equipmentPrice) {
		_equipmentPrice = equipmentPrice;
	}

	public boolean getIncludeInProposal() {
		return _includeInProposal;
	}

	public boolean isIncludeInProposal() {
		return _includeInProposal;
	}

	public void setIncludeInProposal(boolean includeInProposal) {
		_includeInProposal = includeInProposal;
	}

	private long _proposalOptionId;
	private long _companyId;
	private long _userId;
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
}