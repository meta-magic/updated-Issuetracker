package com.issuetracker.model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class ProductList implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@PrimaryKey
@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private String productId;
	
@Persistent(name="ISSUE_REF_ID")
	private String issurRefId;
	
	private String productName;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getIssurRefId() {
		return issurRefId;
	}

	public void setIssurRefId(String issurRefId) {
		this.issurRefId = issurRefId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
