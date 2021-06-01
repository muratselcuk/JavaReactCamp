package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.Customer;

public interface ValidationService {

	boolean validate(Customer customer);
}
