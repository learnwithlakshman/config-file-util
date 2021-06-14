package com.careerit.jdbc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

public class ConnectionUtilTest {

			@Test
			void testConnection() {
				ConnectionUtil obj = new ConnectionUtil();
				Connection con = obj.getConnection();
				assertNotNull(con, "Connection object can't be null");
			}
}
