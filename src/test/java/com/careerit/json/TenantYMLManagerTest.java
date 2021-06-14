package com.careerit.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.careerit.yml.Tenant;

public class TenantYMLManagerTest {
	@Test
	void loadTenantFromYml() {
		TenantJSONManager obj = new TenantJSONManager();
		List<Tenant> list = obj.getTenantDetails();
		assertEquals(4, list.size());
	}
}
