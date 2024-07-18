package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Product;
import com.tka.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/insertProduct")
	public void insertProduct(@RequestBody Product product) {
		service.insertProduct(product);
	}

	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		List<Product> h = service.getAllProducts();
		return h;
	}

	@DeleteMapping("/deleteProduct")
	public void deleteProduct(@RequestParam int id) {
		service.deleteProduct(id);
	}

	@GetMapping("/getProduct")
	public Product getProduct(@RequestParam int id) {
		Product product = service.getProduct(id);
		return product;
	}

	@PutMapping("/updateProduct")
	public void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}

	@GetMapping("/sortByAsc")
	public List<Product> ascendingOrder(@RequestParam String sortBy) {
		List<Product> li = service.ascendingOrder(sortBy);
		return li;
	}

	@GetMapping("/getByName")
	public List<Product> getProductByName(@RequestParam String name) {
		List<Product> li = service.getProductByName(name);
		return li;
	}

	@GetMapping("/greaterThanPrice")
	public List<Product> greaterThan(int price) {
		List<Product> li = service.greaterThan(price);
		return li;
	}

	@GetMapping("/getByPriceRange")
	public List<Product> getByPriceRange(@RequestParam int minprice, @RequestParam int maxprice) {
		List<Product> li = service.getByPriceRange(minprice, maxprice);
		return li;

	}

	@GetMapping("/namePattern")
	public List<Product> namePattern(@RequestParam String namePattern) {
		List<Product> li = service.namePattern(namePattern);
		return li;
	}

	@GetMapping("maxPriceProduct")
	public List<Product> maxPriceProduct() {
		List<Product> li = service.maxPriceProduct();
		return li;
	}
}
