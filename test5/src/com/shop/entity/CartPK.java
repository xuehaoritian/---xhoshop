package com.shop.entity;

import java.io.Serializable;

public class CartPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private int productId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof CartPK) {
			CartPK key = (CartPK) o;
			if(this.userId==key.getUserId()&&this.productId==key.getProductId()) {
				return true;
			}
		}
		return false;	
		
	}
	@Override
	public int hashCode() {
		
		return this.getUserId();
		
	}
}
