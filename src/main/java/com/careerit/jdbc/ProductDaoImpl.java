package com.careerit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

	private static final String ADD_PRODUCT = "INSERT INTO product(pname,price,discount) VALUES(?,?,?);";

	@Override
	public List<Product> selectProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertProduct(Product product) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int newId = 0;
		try {

			con = ConnectionUtil.getConnection();
			st = con.prepareStatement(ADD_PRODUCT, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, product.getPname());
			st.setDouble(2, product.getPrice());
			st.setDouble(3, product.getDiscount());
			int res = st.executeUpdate();
			rs = st.getGeneratedKeys();
			if (rs.next()) {
				newId = rs.getInt(1);
			}
			System.out.println(res + " records are inserted with" + newId);

		} catch (SQLException e) {
			System.out.println("While getting dept details: " + e);
		} finally {
			ConnectionUtil.close(rs, st, con);
		}
		return newId;
	}

	@Override
	public Product selectProduct(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
