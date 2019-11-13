package com.uday.inventory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {
	List<Product> soldProductList=new CopyOnWriteArrayList<Product>();
	//List<Product> purchaseProductList=new ArrayList<Product>();
	public void populateSoldProducts() {
		for (int i = 0; i < 25; i++) {
			Product prod=new Product(i, "testProduct"+i);
			soldProductList.add(prod);
			System.out.println("Added"+prod);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void displaySoldProduct() {
		for(Product product:soldProductList) {
			System.out.println("printing sold product"+product);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
