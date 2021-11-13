package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.service.CartService;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/demo")
public class Controller {

	@Autowired
	CartService cartService;
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/addItem/{name}/{price}")
    public String addItem(@PathVariable("name") String name, @PathVariable("price") Double price) {
        return itemService.createItem(name, price);
    }
	
	@GetMapping("/getItem/{name}")
    public Item getItem(@PathVariable("name") String name) {
        return itemService.returnItem(name);
    }
	
	@GetMapping("/getItemList")
	public List<Item> getItemList() {
		return itemService.returnItemList();
	}
	
	@GetMapping("/createCart")
    public String createCart() {
        return cartService.createCart();
    }
	
	@GetMapping("/getCartList")
    public List<Cart> getCartList() {
        return cartService.returnCartList();
    }
	
	@GetMapping("/addToCart")
    public String addItemToCart(@RequestParam("itemName") String itemName, @RequestParam("quantity") Integer qty, @RequestParam("cartId") Integer cartId) {
        return cartService.addItemToCart(itemName,qty, cartId);
    }
	
	@GetMapping("/removeItemFromCart")
	public String removeItem(@RequestParam("itemName") String itemName, @RequestParam("cartId") Integer cartId) {
		return cartService.removeItemFromCart(itemName, cartId);
	}
	
	@GetMapping("/calculateTotalPrice")
	public Double calculateTotalPrice(@RequestParam("cartId") Integer cartId) {
		return cartService.calculateTotalPrice(cartId);
	}
}
