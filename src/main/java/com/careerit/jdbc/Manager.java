package com.careerit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager {

	private static final String GET_DEPT_DETAILS = "SELECT deptno,dname,loc FROM dept;";
	private static final String GET_EMP_DETAILS = "SELECT empno,ename,job,sal FROM emp;";
	private static final String ADD_DEPT_DETAILS = "INSERT INTO dept(deptno,dname,loc) values(?,?,?);";
	private static final String SEARCH_EMP = "SELECT empno,ename,job,sal from emp where ename like ?;";

	public static void main(String[] args) {

		// Get dept details

		// Add new dept

		// Get emp details

		// Search emp details

//		showDeptDetails();
//		System.out.println("-------------------------");
//		showEmpDetails();
//		System.out.println("--------------------------------------");
//		addDeptDetails(60,"QA","SRI LANKA");
		searchEmpDetails("S"); 
	}

	public static void showDeptDetails() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(GET_DEPT_DETAILS);
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String location = rs.getString("loc");
				System.out.println(deptno + "\t" + dname + "\t" + location);
			}
		} catch (SQLException e) {
			System.out.println("While getting dept details: " + e);
		} finally {
			ConnectionUtil.close(rs, st, con);
		}

	}

	public static void addDeptDetails(int deptno,String dname,String loc) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			con = ConnectionUtil.getConnection();
			st = con.prepareStatement(ADD_DEPT_DETAILS);
			st.setInt(1, deptno);
			st.setString(2, dname);
			st.setString(3, loc);
			
			int res = st.executeUpdate();
			System.out.println(res + " records are inserted");

		} catch (SQLException e) {
			System.out.println("While getting dept details: " + e);
		} finally {
			ConnectionUtil.close(rs, st, con);
		}
	}

	public static void showEmpDetails() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(GET_EMP_DETAILS);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				double salary = rs.getDouble("sal");
				System.out.println(empno + "\t" + ename + "\t" + job + "\t" + salary);
			}
		} catch (SQLException e) {
			System.out.println("While getting dept details: " + e);
		} finally {
			ConnectionUtil.close(rs, st, con);
		}

	}

	public static void searchEmpDetails(String str) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			st = con.prepareStatement(SEARCH_EMP);
			st.setString(1, "%"+str+"%");
			rs = st.executeQuery();
			System.out.println(st);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				double salary = rs.getDouble("sal");
				System.out.println(empno + "\t" + ename + "\t" + job + "\t" + salary);
			}
		} catch (SQLException e) {
			System.out.println("While getting dept details: " + e);
		} finally {
			ConnectionUtil.close(rs, st, con);
		}
	}
}
