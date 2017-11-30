package com.shop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="USER")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//指定继承关系的生成策略
@DiscriminatorColumn(name="USERTYPE")//指定区分子类类型的字段
public class User {
	private int userId;
	private String userName;
	private String password;
	private String mailAddress;
	//用户-产品 多对多
	private Set<Product> pset = new HashSet<Product>();
	//一个用户对应多个订单--一对多映射
	private Set<Order> oset= new HashSet<Order>();
	
	@Id
	@GeneratedValue(generator="xho_gen")
	@GenericGenerator(name="xho_gen", strategy="increment")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}	
	@OneToMany(mappedBy="user", targetEntity=Order.class, 
            cascade=CascadeType.ALL)
	public Set<Order> getOset() {
		return oset;
	}
	public void setOset(Set<Order> oset) {
		this.oset = oset;
	}
	@ManyToMany(mappedBy="uset")//表示关联关系由Product维护
	public Set<Product> getPset() {
		return pset;
	}
	public void setPset(Set<Product> pset) {
		this.pset = pset;
	}
	
	
}
