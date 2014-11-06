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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author pmacha
 * @see Product
 * @generated
 */
public class ProductWrapper implements Product, ModelWrapper<Product> {
	public ProductWrapper(Product product) {
		_product = product;
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productId", getProductId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productName", getProductName());
		attributes.put("sequenceNumber", getSequenceNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
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

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		Long sequenceNumber = (Long)attributes.get("sequenceNumber");

		if (sequenceNumber != null) {
			setSequenceNumber(sequenceNumber);
		}
	}

	/**
	* Returns the primary key of this product.
	*
	* @return the primary key of this product
	*/
	@Override
	public long getPrimaryKey() {
		return _product.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product.
	*
	* @param primaryKey the primary key of this product
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_product.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the product ID of this product.
	*
	* @return the product ID of this product
	*/
	@Override
	public long getProductId() {
		return _product.getProductId();
	}

	/**
	* Sets the product ID of this product.
	*
	* @param productId the product ID of this product
	*/
	@Override
	public void setProductId(long productId) {
		_product.setProductId(productId);
	}

	/**
	* Returns the company ID of this product.
	*
	* @return the company ID of this product
	*/
	@Override
	public long getCompanyId() {
		return _product.getCompanyId();
	}

	/**
	* Sets the company ID of this product.
	*
	* @param companyId the company ID of this product
	*/
	@Override
	public void setCompanyId(long companyId) {
		_product.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product.
	*
	* @return the user ID of this product
	*/
	@Override
	public long getUserId() {
		return _product.getUserId();
	}

	/**
	* Sets the user ID of this product.
	*
	* @param userId the user ID of this product
	*/
	@Override
	public void setUserId(long userId) {
		_product.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product.
	*
	* @return the user uuid of this product
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _product.getUserUuid();
	}

	/**
	* Sets the user uuid of this product.
	*
	* @param userUuid the user uuid of this product
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_product.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this product.
	*
	* @return the user name of this product
	*/
	@Override
	public java.lang.String getUserName() {
		return _product.getUserName();
	}

	/**
	* Sets the user name of this product.
	*
	* @param userName the user name of this product
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_product.setUserName(userName);
	}

	/**
	* Returns the create date of this product.
	*
	* @return the create date of this product
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _product.getCreateDate();
	}

	/**
	* Sets the create date of this product.
	*
	* @param createDate the create date of this product
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_product.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product.
	*
	* @return the modified date of this product
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _product.getModifiedDate();
	}

	/**
	* Sets the modified date of this product.
	*
	* @param modifiedDate the modified date of this product
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_product.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the product name of this product.
	*
	* @return the product name of this product
	*/
	@Override
	public java.lang.String getProductName() {
		return _product.getProductName();
	}

	/**
	* Sets the product name of this product.
	*
	* @param productName the product name of this product
	*/
	@Override
	public void setProductName(java.lang.String productName) {
		_product.setProductName(productName);
	}

	/**
	* Returns the sequence number of this product.
	*
	* @return the sequence number of this product
	*/
	@Override
	public long getSequenceNumber() {
		return _product.getSequenceNumber();
	}

	/**
	* Sets the sequence number of this product.
	*
	* @param sequenceNumber the sequence number of this product
	*/
	@Override
	public void setSequenceNumber(long sequenceNumber) {
		_product.setSequenceNumber(sequenceNumber);
	}

	@Override
	public boolean isNew() {
		return _product.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_product.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _product.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_product.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _product.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _product.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_product.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _product.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_product.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_product.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_product.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductWrapper((Product)_product.clone());
	}

	@Override
	public int compareTo(com.tamarack.creekridge.model.Product product) {
		return _product.compareTo(product);
	}

	@Override
	public int hashCode() {
		return _product.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.tamarack.creekridge.model.Product> toCacheModel() {
		return _product.toCacheModel();
	}

	@Override
	public com.tamarack.creekridge.model.Product toEscapedModel() {
		return new ProductWrapper(_product.toEscapedModel());
	}

	@Override
	public com.tamarack.creekridge.model.Product toUnescapedModel() {
		return new ProductWrapper(_product.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _product.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _product.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_product.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductWrapper)) {
			return false;
		}

		ProductWrapper productWrapper = (ProductWrapper)obj;

		if (Validator.equals(_product, productWrapper._product)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Product getWrappedProduct() {
		return _product;
	}

	@Override
	public Product getWrappedModel() {
		return _product;
	}

	@Override
	public void resetOriginalValues() {
		_product.resetOriginalValues();
	}

	private Product _product;
}