package com.javawebtutor.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.Product;
import com.javawebtutor.model.User;


public class ProductService {
	public List<Product> getListOfProducts(){
        List<Product> list = new ArrayList<Product>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Product").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
	public boolean AddProduct(Product product){
	     Session session = HibernateUtil.openSession();
	     
	     
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();
	         session.saveOrUpdate(product);       
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	     } finally {
	         session.close();
	     } 
	     return true;
	}
	public Product getProductByProductId(Long ProductId) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Product product = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            System.out.println("error start");
            Query query = session.createQuery("from Product where id='"+ProductId+"'");
            System.out.println("error start f");
            product = (Product)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }
	public boolean UpdateProductDetails(Product product){
		System.out.println("product name: "+product.getName());
		System.out.println("product Description: "+product.getDescription());
		System.out.println("product Id: "+product.getId());
		 Session session = HibernateUtil.openSession();
	     boolean result = false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	       
	         Query query = session.createQuery("update Product set name= :name,"+"description= :description"+" where id= :id");
	         query.setParameter("name", product.getName());
	         query.setParameter("description", product.getDescription());
	         query.setParameter("id", product.getId());
	         int done = query.executeUpdate();
	         if(done==1){
	        	 result=true;
	         }
	         tx.commit();
	         System.out.println("Student data Update Status=" + done); 
	     }catch(Exception ex){
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	     }
	     return result;
	}
	public boolean DeletProductDetails(Long product){
		Session session = HibernateUtil.openSession();
	     boolean result = false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	       
	         Query query = session.createQuery("delete Product"+" where id= :id");

	         query.setParameter("id", product);
	         int done = query.executeUpdate();
	         if(done==1){
	        	 result=true;
	         }
	         tx.commit();
	         System.out.println("Student data delete Status=" + done); 
	     }catch(Exception ex){
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	     }
	     return result;
	}
}
