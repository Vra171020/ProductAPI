package com.tka.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int pid;
	String pnm;
	int quantity;
	int price;
	LocalDate mfgDate;
	LocalDate expDate;
	String category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pnm, int quantity, int price, LocalDate mfgDate, LocalDate expDate,
			String category) {
		super();
		this.pid = pid;
		this.pnm = pnm;
		this.quantity = quantity;
		this.price = price;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.category = category;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPnm() {
		return pnm;
	}
	public void setPnm(String pnm) {
		this.pnm = pnm;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pnm=" + pnm + ", quantity=" + quantity + ", price=" + price + ", mfgDate="
				+ mfgDate + ", expDate=" + expDate + ", category=" + category + "]";
	}
	
	
	

}
