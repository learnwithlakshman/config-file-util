package com.careerit.yml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TenantYMLManagerTest {
	@Test
	void loadTenantFromYml() {
		TenantYMLManager obj = new TenantYMLManager();
		List<Tenant> list = obj.getTenantDetails();
		assertEquals(4, list.size());
	}
	@Test
	void loadCustomerFromYml() {
		TenantYMLManager obj = new TenantYMLManager();
		 Customer customer = obj.getCustomerDetails();
		 System.out.println(customer);
	}

}
