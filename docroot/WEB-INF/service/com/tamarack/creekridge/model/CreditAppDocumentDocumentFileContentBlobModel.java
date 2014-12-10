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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the documentFileContent column in CreditAppDocument.
 *
 * @author Tamarack Consulting
 * @see CreditAppDocument
 * @generated
 */
public class CreditAppDocumentDocumentFileContentBlobModel {
	public CreditAppDocumentDocumentFileContentBlobModel() {
	}

	public CreditAppDocumentDocumentFileContentBlobModel(
		long CreditAppDocumentId) {
		_CreditAppDocumentId = CreditAppDocumentId;
	}

	public CreditAppDocumentDocumentFileContentBlobModel(
		long CreditAppDocumentId, Blob documentFileContentBlob) {
		_CreditAppDocumentId = CreditAppDocumentId;
		_documentFileContentBlob = documentFileContentBlob;
	}

	public long getCreditAppDocumentId() {
		return _CreditAppDocumentId;
	}

	public void setCreditAppDocumentId(long CreditAppDocumentId) {
		_CreditAppDocumentId = CreditAppDocumentId;
	}

	public Blob getDocumentFileContentBlob() {
		return _documentFileContentBlob;
	}

	public void setDocumentFileContentBlob(Blob documentFileContentBlob) {
		_documentFileContentBlob = documentFileContentBlob;
	}

	private long _CreditAppDocumentId;
	private Blob _documentFileContentBlob;
}