package br.com.gubee.domain;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int id;

	private String productName;
	
	private String description;
	
	private List<String> targetMarket = new ArrayList<>();
	
	private List<String> stack = new ArrayList<>();
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getTargetMarket() {
		return targetMarket;
	}
	public void setTargetMarket(List<String> targetMarket) {
		this.targetMarket = targetMarket;
	}
	public List<String> getStack() {
		return stack;
	}
	public void setStack(List<String> stack) {
		this.stack = stack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
