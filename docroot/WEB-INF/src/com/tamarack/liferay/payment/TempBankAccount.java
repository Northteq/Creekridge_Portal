/**
 * 
 */
package com.tamarack.liferay.payment;

import java.io.Serializable;

import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author pmacha
 *
 */
public class TempBankAccount implements Serializable {

	private String bankReferencAccountType;
	private String bankReferenceAccountNumber;
	private String bankReferencePhone;
	private String bankReferenceName;
	private String bankReferenceContact;
	private long bankReferenceId;
	static final long serialVersionUID=100102013202L;
	public String getBankReferencAccountType() {
		return bankReferencAccountType;
	}
	public void setBankReferencAccountType(String bankReferencAccountType) {
		this.bankReferencAccountType = bankReferencAccountType;
	}
	public String getBankReferenceAccountNumber() {
		return bankReferenceAccountNumber;
	}
	public void setBankReferenceAccountNumber(String bankReferenceAccountNumber) {
		this.bankReferenceAccountNumber = bankReferenceAccountNumber;
	}
	public String getBankReferencePhone() {
		return bankReferencePhone;
	}
	public void setBankReferencePhone(String bankReferencePhone) {
		this.bankReferencePhone = bankReferencePhone;
	}
	public String getBankReferenceName() {
		return bankReferenceName;
	}
	public void setBankReferenceName(String bankReferenceName) {
		this.bankReferenceName = bankReferenceName;
	}
	public String getBankReferenceContact() {
		return bankReferenceContact;
	}
	public void setBankReferenceContact(String bankReferenceContact) {
		this.bankReferenceContact = bankReferenceContact;
	}
	public long getBankReferenceId() {
		return bankReferenceId;
	}
	public void setBankReferenceId(long bankReferenceId) {
		this.bankReferenceId = bankReferenceId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
