package eCommerceDemo;


import eCommerceDemo.business.abstracts.CustomerService;
import eCommerceDemo.business.concretes.CustomerManager;
import eCommerceDemo.business.concretes.EmailManager;
import eCommerceDemo.business.concretes.ValidateManager;
import eCommerceDemo.dataAccess.concretes.InMemoryCustomerDao;
import eCommerceDemo.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {

		Customer customer = new Customer(1,"Murat", 
				"Selçuk", "muratselcuk@muratselcuk.com","abc123");
		CustomerService customerService = new CustomerManager(new InMemoryCustomerDao(), new ValidateManager(), new EmailManager());
		customerService.add(customer);
		
	}

}
