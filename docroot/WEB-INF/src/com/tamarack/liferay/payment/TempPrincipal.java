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
public class TempPrincipal implements Serializable {

	private String principalLastName;
	private String principalFirstName;
	private String principalSSN;
	private long principalId;
	static final long serialVersionUID=100102013202L;
	
	public String getPrincipalLastName() {
		return principalLastName;
	}
	public void setPrincipalLastName(String lastName) {
		this.principalLastName = lastName;
	}
	public String getPrincipalFirstName() {
		return principalFirstName;
	}
	public void setPrincipalFirstName(String firstName) {
		this.principalFirstName = firstName;
	}
	public String getPrincipalSSN() {
		return principalSSN;
	}
	public void setPrincipalSSN(String sSN) {
		principalSSN = sSN;
	}
	public long getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(long principalId) {
		this.principalId = principalId;
	}
	
	
	
}
