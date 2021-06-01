package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.EmailService;
import eCommerceDemo.entities.concretes.Customer;
import eCommerceDemo.entities.concretes.Email;

public class EmailManager implements EmailService{

	@Override
	public void sendMail(Email email, Customer customer) {
		System.out.println(customer.geteMail()+" mail adresine gönderildi: "+ email.getMessage());
		
	}

}
