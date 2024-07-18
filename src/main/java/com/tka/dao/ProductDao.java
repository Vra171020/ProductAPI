package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Product;

@Repository
public class ProductDao {
	@Autowired
	SessionFactory factory;
    //1) Task Title: Add Product to Database
	public void insertProduct(Product product) {
		try {
			Session session = factory.openSession();
			Criteria c = session.createCriteria(Product.class);
			Transaction t = session.beginTransaction();
			boolean exists = false;

			List<Product> li = c.list();
			for (Product P : li) {
				if (P.getPnm().equalsIgnoreCase(product.getPnm())) {
					exists = true;
				}

			}
			if (exists == false) {
				session.save(product);
				t.commit();
				System.out.println("Inserted");
			} else {
				System.out.println("Product already exists");
			}
		} catch (Exception e) {
			System.out.println("Something went Wrong");
		}

	}
 
//	2)Task Title: Delete Product from Database
	public void deleteProduct(int id) {
		try {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		Product p = session.load(Product.class, id);
		session.delete(p);
		trans.commit();
		System.out.println("Successfully deleted");
		}catch(Exception e) {
			System.err.println("Unsuccessfull attempt: "+e.getMessage());
		}
	}

//	3) Task Title: Get particular Product data  from DB
	public Product getProduct(int id) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = session.get(Product.class, id);
			transaction.commit();
			if (product != null) {
				return product;
			} else {
				throw new RuntimeException("Product not found");
			}
		} catch (Exception e) {

			System.err.println("Error retrieving product: " + e.getMessage());
			return null;
		}
	}

//	4) Task Title : Update Particular Product
	public void updateProduct(Product product) {
		try {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(product);
		transaction.commit();
		System.out.println("Updated Successfully");
		}catch(Exception e) {
			System.err.println("Unsuccessfull update: "+e.getMessage());
		}
		
	}

//	5)Task Title: Retrieve All Products from Database
	public List<Product> getAllProduct() {
		
		try {
		Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Product.class);
        List<Product> productList = criteria.list();

        transaction.commit();
        return productList;
        }catch(Exception e) {
        	System.err.println("Unable to fetch: "+e.getMessage());
        	return null;
        }
		}
}
