package com.careerit.yml;

import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class TenantYMLManager {

	public List<Tenant> getTenantDetails() {
		List<Tenant> list = new ArrayList<>();
		Yaml yaml = new Yaml(new Constructor(Tenant.class));
		
		Iterable<Object> itr = yaml.loadAll(TenantYMLManager.class.getResourceAsStream("/tenant.yml"));
		for (Object obj : itr) {
			if (obj instanceof Tenant) {
				list.add((Tenant) obj);
			}
		}
		return list;
	}

	public Customer getCustomerDetails(){
			Yaml yaml = new Yaml(new Constructor(Customer.class));
			Customer customer = yaml.load(TenantYMLManager.class.getResourceAsStream("/customer.yml"));
			return customer;
		}
}
