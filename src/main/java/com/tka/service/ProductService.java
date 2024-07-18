package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.ProductDao;
import com.tka.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	@Autowired
	SessionFactory factory;

	public void insertProduct(Product product) {
		dao.insertProduct(product);

	}

	public List<Product> getAllProducts() {
		List<Product> li = dao.getAllProduct();
		return li;
	}

	public void deleteProduct(int id) {
		dao.deleteProduct(id);
	}

	public Product getProduct(int id) {
		Product product = dao.getProduct(id);
		return product;
	}

	public void updateProduct(Product product) {
		dao.updateProduct(product);
	}

//6)Task Title: Retrieve All Products in Ascending Order by Given Parameter
	public List<Product> ascendingOrder(String sortBy) {
		try {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			Criteria c = session.createCriteria(Product.class);
			c.addOrder(Order.asc(sortBy));
			List<Product> li = c.list();
			t.commit();
			System.out.println("Ascending order");
			return li;
		} catch (Exception e) {
			System.err.println("Not Possible: " + e.getMessage());
			return null;
		}

	}

//7) Task Title: Retrieve Product by Product Name
	public List<Product> getProductByName(String name) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria c = session.createCriteria(Product.class);
			List<Product> getByNmList = new ArrayList<Product>();
			List<Product> li = c.list();
			boolean found = false;
			for (Product p : li) {
				if (p.getPnm().equalsIgnoreCase(name)) {
					getByNmList.add(p);
					found = true;
				}

			}

			if (found == true)
				System.out.println("Product Found");
			else
				System.out.println(" Product not Found");

			return getByNmList;
		} catch (Exception e) {

			System.err.println("Error :" + e.getMessage());
			return null;
		}
	}

//8) Task Title: Retrieve Products with Price Greater Than Specified Price
	public List<Product> greaterThan(int price) {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Product.class);
		List<Product> greaterThanPrice = new ArrayList<Product>();

		List<Product> li = c.list();

		for (Product p : li) {
			if (p.getPrice() >= price) {
				greaterThanPrice.add(p);
			}
		}
		System.out.println("Greater than Price: "+price);
		return greaterThanPrice;
	}

//	9) Task Title: Retrieve Products by Name Pattern
	public List<Product> namePattern(String namePattern) {
		try {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			Criteria c = session.createCriteria(Product.class);
			c.add(Restrictions.like("pnm", "%" + namePattern + "%"));

			List<Product> li = c.list();
			System.out.println("Products related to Name");
			return li;
		} catch (Exception e) {
			System.err.println("Error : " + e.getMessage());
			return null;
		}
	}

//	10) Task Title: Retrieve Products Within Price Range 
	public List<Product> getByPriceRange(int minprice, int maxprice) {
		try {
			Session session = factory.openSession();
			Criteria c = session.createCriteria(Product.class);
			Transaction t = session.beginTransaction();

			boolean found = false;
			List<Product> priceRangeList = new ArrayList<Product>();

			List<Product> li = c.list();
			for (Product p : li) {
				if (p.getPrice() >= minprice && p.getPrice() <= maxprice) {
					priceRangeList.add(p);
					found = true;
				}

			}
			if (found == true)
				System.out.println("Product found Within PriceRange : " + minprice + "-" + maxprice);
			else
				System.out.println("Product Not Found within PriceRange : " + minprice + "-" + maxprice);

			return priceRangeList;

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			return null;
		}

	}

//11) Tile : Retrieve maximum product price;
	public List<Product> maxPriceProduct() {
		try {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Product.class);
		Transaction t = session.beginTransaction();

		c.addOrder(Order.desc("price")).setMaxResults(1).list();
		
		List<Product> li = c.list();
		System.out.println("Max price Product");
		return li;}
		catch(Exception e) {
			System.err.println("Error :"+e.getMessage());
			return null;
		}

	}

}
