package com.careerit.jdbc;

import java.util.List;

public interface ProductDao {

		public List<Product> selectProducts();
		public List<Product> search(String str);
		public boolean deleteProduct(int pid);
		public boolean updateProduct(Product product);
		public int insertProduct(Product product);
		public Product selectProduct(int pid);
			
}
