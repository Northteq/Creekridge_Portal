/**
 * 
 */
package com.tamarack.liferay.payment;

import java.io.Serializable;

/**
 * @author pmacha
 *
 */
public class TempProposalOption implements Serializable {

	private long purchaseOptionId;
	private long termId;
	private long productId;
	private double paymentAmount;
	private double equipmentPrice;
	boolean includeInProposal;
	boolean useForApplication;
	public boolean isUseForApplication() {
		return useForApplication;
	}

	public void setUseForApplication(boolean useForApplication) {
		this.useForApplication = useForApplication;
	}

	private long proposalId;
	private long rateFactorRuleId;
	
	static final long serialVersionUID=100102010202L;
	
	public boolean getIncludeInProposal() {
		
		return includeInProposal;
	}
	
    public void setIncludeInProposal(boolean arg0) {
		
    	includeInProposal=arg0;
	}


	public double getPaymentAmount() {
		
		return paymentAmount;
	}
	
  public double getEquipmentPrice() {
		
		return equipmentPrice;
	}
	public long getProposalId() {
		
		return proposalId;
	}

	 public long getRateFactorRuleId() {
		
		return rateFactorRuleId;
	}
	
	public long getProductId() {
		// TODO Auto-generated method stub
		return productId;
	}

	
	public long getProposalOptionId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public long getPurchaseOptionId() {
		// TODO Auto-generated method stub
		return purchaseOptionId;
	}

	
	public long getTermId() {
		// TODO Auto-generated method stub
		return termId;
	}


	public void setProductId(long arg0) {
		// TODO Auto-generated method stub
		productId=arg0;
	}

	
	public void setPurchaseOptionId(long arg0) {
		// TODO Auto-generated method stub
		purchaseOptionId=arg0;
	}

	
	
	public void setTermId(long arg0) {
		
		termId=arg0;
	}
	
	public void setPaymentAmount(double arg0) {
		
		paymentAmount=arg0;
	}
	
   public void setEquipmentPrice(double arg0) {
		
	   equipmentPrice=arg0;
	}
   public void setProposalId(long arg0) {
		
	   proposalId=arg0;
	}
   
   public void setRateFactorRuleId(long arg0) {
		
	   rateFactorRuleId=arg0;
	}
   
   
	
}
