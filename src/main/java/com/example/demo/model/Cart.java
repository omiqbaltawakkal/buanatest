package com.example.demo.model;

import java.util.*;

public class Cart {
	
	public Integer id;
	public Map<String, Integer> items = new HashMap<>();
	
	public Cart (Integer id, Map<String, Integer> items){
		this.id = id;
		this.items = items;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, Integer> getItems() {
		return items;
	}
	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}
    
    
}
