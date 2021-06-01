package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.CustomerService;
import eCommerceDemo.business.abstracts.EmailService;
import eCommerceDemo.business.abstracts.ValidationService;
import eCommerceDemo.dataAccess.abstracts.CustomerDao;
import eCommerceDemo.entities.concretes.Customer;
import eCommerceDemo.entities.concretes.Email;

public class CustomerManager implements CustomerService{

	private CustomerDao customerDao;
	private ValidationService validationService;
	private EmailService emailService;
	
	public CustomerManager(CustomerDao customerDao, ValidationService validationService, EmailService emailService) {
		super();
		this.customerDao = customerDao;
		this.validationService = validationService;
		this.emailService = emailService;
	}

	@Override
	public void add(Customer customer) {
		if (this.validationService.validate(customer)) {
			this.customerDao.add(customer);
			Email email = new Email("Üyelik oluşturuldu maili gönderildi.");
			this.emailService.sendMail(email, customer);
		}
		else {
			System.out.println("geçerli bir kişi değil.");
		}
		
		
	}





	
}
