package com.shop.product.dao;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.shop.entity.Product;
@Repository
public class ProductDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/*
	 * return List<Product>
	 * 查询所有的product
	 * */
	public List<Product> findAllProduct(){
		List<Product> list = null;
		list = this.sessionFactory.getCurrentSession().createQuery("select p from Product p").list();
		return list;		
	}
	public void insertProduct(Product p) {
		this.sessionFactory.getCurrentSession().save(p);
	}
	/*
	 * 参数 id
	 * return Product
	 * 查询含id的product
	 * */
	public Product findById(int keyWord){
		String hql = "from Product p where p.productId="+keyWord;
		Product p = null;
		p = (Product) this.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		return p;
		
	}
	/*
	 * 按类别查询
	 * 参数key
	 * return List<Product>
	 * */
	public List<Product> findByType(String type){
		System.out.println("this is dao");
		String hql="from Product p where p.type='"+type+"'";
		System.out.println(type);
		List<Product> list =this.sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
		
	}
	public List<Product> findByKeyword(String key){
		String hql="from Product p where p.productId ="+key+" or p.productName like '%"+key+"%' or p.productDescription like'%"+key+"%'";
		List<Product> list = this.sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
		
	}
	public void deleteProduct(Product p) {
		this.sessionFactory.getCurrentSession().remove(p);
	}
	public void updateProduct(Product p) {
		String hql="update Product p set p.imgAddress=?,p.productDescription=?,p.productName=?,p.type=?,p.shelfTime=?,p.price=? where p.productId=?";
		this.sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, p.getImgAddress()).setParameter(1, p.getProductDescription()).setParameter(2, p.getProductName()).setParameter(3, p.getType()).setParameter(4, p.getShelfTime()).setParameter(5, p.getPrice()).setParameter(6, p.getProductId()).executeUpdate();
	}
}
