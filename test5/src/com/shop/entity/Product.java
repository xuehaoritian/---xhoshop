package com.shop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUCT")
public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	private int price;
	private int count;
	private Set<Order> oset= new HashSet<Order>();
	private Set<User> uset = new HashSet<User>();
	
	@Id
	@GeneratedValue(generator="xho_gen")
	@GenericGenerator(name="xho_gen",strategy="increment")
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@ManyToMany(mappedBy="pset")//表示关联关系由Order维护
	public Set<Order> getOset() {
		return oset;
	}
	public void setOset(Set<Order> oset) {
		this.oset = oset;
	}
	@ManyToMany//表明多对多关联关系
	@JoinTable(name="CART",//指定关联表
		joinColumns=@JoinColumn(name="PRODUCTID"),//指向实体对应表的外键
			inverseJoinColumns=@JoinColumn(name="USERID"))//指向所关联的实体对应表的外键
	public Set<User> getUset() {
		return uset;
	}
	public void setUset(Set<User> uset) {
		this.uset = uset;
	}
	
	
}
