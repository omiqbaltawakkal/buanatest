package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Item;

@Service
public class ItemService {

	public List<Item> itemList = new ArrayList<>();
	//1. Get/Search item
	
	public String createItem(String nama, Double price) {
		Item item = new Item(nama, price);
		this.itemList.add(item);
		return "added new item "+ nama;
	}
	
	public Item returnItem(String name) {
		try {
			for (Item item : this.itemList) {
				if (item.getName().equals(name)) {				
					return item;
				}
			}
			
		} catch (Exception e) {	
			return null;
		}
		return null;
	}
	
	public List<Item> returnItemList(){
		return this.itemList;
	}
	
	

}
