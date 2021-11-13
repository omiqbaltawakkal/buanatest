package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;

@Service
public class CartService {

	public List<Cart> carts = new ArrayList<>();

	@Autowired
	public ItemService itemService;

//	2. For selected item, add item to cart
//	3. Add more items to cart
//	4. Remove item from cart
//	5. Finalize cart (calculcate price)

	public String createCart() {
		Map<String, Integer> items = new HashMap<String, Integer>();
		Cart item = new Cart(this.carts.size() + 1, items);
		this.carts.add(item);
		return "added new carts with id "+ this.carts.size() + 1;
	}

	public String addItemToCart(String namaItem, Integer qty, Integer cartId) {
		try {
			if (itemService.returnItem(namaItem) == null) {
				System.out.println("no such item");
				return "";
			}
			for (Cart cart : this.carts) {
				if (cart.getId() == cartId) {
					Map<String, Integer> tempItems = cart.getItems();
					if (tempItems.get(namaItem) != null) {
						tempItems.put(namaItem, tempItems.get(namaItem) + qty);
					} else {
						tempItems.put(namaItem, qty);
					}
					break;
				}
			}
			return "Success add " + namaItem + " to cart " + cartId + " with qty : " + qty;
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
			return "";
		}
	}

	public String removeItemFromCart(String namaItem, Integer cartId) {
		for (Cart cart : this.carts) {
			if (cart.getId() == cartId) {
				Map<String, Integer> tempItems = cart.getItems();
				if (tempItems.get(namaItem) != null) {
					tempItems.remove(namaItem);
					System.out.println("Success remove");
					break;
				}
			}
		}
		return "";
	}

	public Double calculateTotalPrice(Integer cartId) {
		Double price = 0.0;
		for (Cart cart : this.carts) {
			if (cart.getId() == cartId) {
				Map<String, Integer> tempItems = cart.getItems();
				for (Map.Entry<String, Integer> items : tempItems.entrySet()) {
					price +=itemService.returnItem(items.getKey()).getPrice() * items.getValue();
				}
				break;
			}
		}
		return price;
	}

	public List<Cart> returnCartList() {
		return this.carts;
	}

}
