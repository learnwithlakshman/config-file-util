package com.careerit.jdbc;

public class ProductManager {

		public static void main(String[] args) {
			
				
				// 1. Add 2.Delete 3.Search 4.View 5.Update 6.Exit
			
				ProductDao obj = new ProductDaoImpl();
				
				Product product = new Product();
				product.setPname("Lenvo ThinkPad");
				product.setPrice(55000);
				product.setDiscount(2000);
				
				int newId = obj.insertProduct(product);
				System.out.println("Product is created with id :"+newId);
		}
}
