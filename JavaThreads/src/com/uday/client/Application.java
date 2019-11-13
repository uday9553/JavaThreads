package com.uday.client;

import com.uday.inventory.InventoryManager;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		InventoryManager inventoryManager=new InventoryManager();
		Thread inventoryManagerTask=new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				inventoryManager.populateSoldProducts();
			}
			
		});
		
		Thread displayManagerTask=new Thread(new Runnable() {

			@Override
			public void run() {
				inventoryManager.displaySoldProduct();
			}
			
		});
		inventoryManagerTask.start();
		Thread.sleep(300);
		displayManagerTask.start();

	}

}
