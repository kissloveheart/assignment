package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> listItems;

	public Cart() {
		listItems = new ArrayList<>();
	}
	//add product to cart
	public void add(Product product) {
		for(Product item : listItems) {
			if(product.getId() == item.getId()) {
				item.setNumber(item.getNumber()+1);
				return;
			}
		}
		listItems.add(product);
	}
	//remove product from cart
	public void remove(int id) {
		for(Product item : listItems) {
			if(item.getId() == id) {
				listItems.remove(item);
				return;
			}
		}
	}
	
	//get total amount of cart
	public double getAmount() {
		double amount = 0;
		for (Product item : listItems) {
			amount += item.getNumber()*item.getPrice(); 
		}
		return Math.round(amount*100)/100.0;
	}
	
	//get listItem
	public List<Product> getListItems() {
		return listItems;
	}
	
	

	public void setListItems() {
		this.listItems = null;
	}
	// increase number item
	public void increaseItem(int id) {
		for(Product item : listItems) {
			if(item.getId() == id) {
				item.setNumber(item.getNumber()+1);
				return;
			}
		}
	}
	
	//decrease number item
	public void decreaseItem(int id) {
		for(Product item : listItems) {
			if(item.getId() == id) {
				if(item.getNumber() == 1) {
					remove(id);
					return;
				}
				item.setNumber(item.getNumber()-1);
				return;
			}
		}
	}
	
	
}
