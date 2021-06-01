package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.Customer;
import eCommerceDemo.entities.concretes.Email;

public interface EmailService {

	void sendMail(Email email, Customer customer );
}
