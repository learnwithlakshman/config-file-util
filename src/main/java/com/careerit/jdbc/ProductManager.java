package com.careerit.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

	public static void main(String[] args) {

		// 1. Add 2.Delete 3.Search 4.View 5.Update 6.Exit

		ProductDao obj = new ProductDaoImpl();

		Product product = new Product();
		product.setPname("Lenvo ThinkPad");
		product.setPrice(55000);
		product.setDiscount(2000);

		int newId = obj.insertProduct(product);
		System.out.println("Product is created with id :" + newId);
		List<TeamCoachAmountDTO> list = showTeamAmountWithCoachDetails("%R%");
		list.stream().forEach(e->System.out.println(e.getCoach()));
	}

	private static List<TeamCoachAmountDTO> showTeamAmountWithCoachDetails(String teamName) {
		Connection con = null;
		CallableStatement st = null;
		ResultSet rs = null;
		List<TeamCoachAmountDTO> list = new ArrayList<TeamCoachAmountDTO>();
		try {

			con = ConnectionUtil.getConnection();
			st = con.prepareCall("{call team_coach_amount(?)}");
			st.setString(1, teamName);
			rs = st.executeQuery();
			while (rs.next()) {
				TeamCoachAmountDTO obj = new TeamCoachAmountDTO(rs.getString(1), rs.getString(2), rs.getDouble(3));
				list.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("While getting dept details: " + e);
		} finally {
			ConnectionUtil.close(rs, st, con);
		}
		return list;
	}
}

class TeamCoachAmountDTO {
	private String label;
	private String coach;
	private double amount;

	TeamCoachAmountDTO(String label, String coach, double amount) {
		super();
		this.label = label;
		this.coach = coach;
		this.amount = amount;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}

// label,coach,total