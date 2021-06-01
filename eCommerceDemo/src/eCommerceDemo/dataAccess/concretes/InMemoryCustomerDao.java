package eCommerceDemo.dataAccess.concretes;

import eCommerceDemo.dataAccess.abstracts.CustomerDao;
import eCommerceDemo.entities.concretes.Customer;

public class InMemoryCustomerDao implements CustomerDao {

	@Override
	public void add(Customer customer) {

		System.out.println("Kayıt eklendi");
	}

}
