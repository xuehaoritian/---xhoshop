package com.shop.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="ORDER")
public class Order {
	
	
	private int orderId;
	private int total;
	private Date date;
	private String state;
	//一个用户对应多个订单--一对多映射
	private User user;
	private Set<Product> pset=new HashSet<Product>();
	
	@Id
    @GeneratedValue(generator="xho_gen")
    @GenericGenerator(name = "xho_gen", strategy = "increment")
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@ManyToOne
    @JoinColumn(name="USERID")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@ManyToMany//表明多对多关联关系
	@JoinTable(name="ORDERPRODUCT",//指定关联表
		joinColumns=@JoinColumn(name="ORDERID"),//指向实体对应表的外键
			inverseJoinColumns=@JoinColumn(name="PRODUCTID"))//指向所关联的实体对应表的外键
	public Set<Product> getPset() {
		return pset;
	}
	public void setPset(Set<Product> pset) {
		this.pset = pset;
	}
	
	
	
}
