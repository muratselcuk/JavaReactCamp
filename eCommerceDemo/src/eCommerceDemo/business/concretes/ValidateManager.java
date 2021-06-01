package eCommerceDemo.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceDemo.business.abstracts.ValidationService;
import eCommerceDemo.entities.concretes.Customer;

public class ValidateManager implements ValidationService{

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean eMailValidate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.find();
		}
	
	
	@Override
	public boolean validate(Customer customer) {
		
		if (customer.getFirstName()==null ||
				customer.getLastName()==null || 
				customer.getPassword()==null ||
				customer.geteMail()==null
				) {
			System.out.println("Adı, soyadı, eposta ve şifre alanları boş bırakılamaz");
			
			return false;
		}
		
		if (customer.getFirstName().length()<2 || customer.getLastName().length()<2) {
			System.out.println("Ad ve soyad en az 2 karakterden oluşmalıdır.");
			return false;
		
		}
		
		if (customer.getPassword().length()<6) {
			System.out.println("şifre en az 6 karakter olmalıdır.");
			return false;
		}
		
		if (!(eMailValidate(customer.geteMail()))) {
			System.out.println("Geçerli bir mail adresi girmediniz.");
			return false;
		}
		
		return true;

	}
	

}
