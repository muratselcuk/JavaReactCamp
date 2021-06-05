package muratselcuk.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.EmployerValidateService;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.UserDao;
import muratselcuk.hrms.entities.concretes.Employer;

@Service
public class EmployerValidateManager implements EmployerValidateService {

	private UserDao userDao;
	
	@Autowired
	public EmployerValidateManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean eMailValidate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.find();
		}
	
	
	
	@Override
	public Result employerValidate(Employer employer) {
		
		if (employer.getCompanyName()==null ||
				employer.getWeb()==null ||
				employer.getPhoneNumber()==null ||
				employer.getEmail()==null ||
				employer.getPassword()==null
				) {
			return new ErrorResult("firma ismi, web adresi, telefon numarasi, mail ve sifre alanları bos birakilamaz.");
		}
		
		if (!(eMailValidate(employer.getEmail()))) {
			return new ErrorResult("gecerli bir email adresi girmediniz.");
		}
		String[] splitMail = employer.getEmail().split("@");
		if(!employer.getWeb().contains(splitMail[1])) {
			return new ErrorResult("mail adresiniz kurumsal web site alanadiniz ile olmalıdır.");
		}
		
		
		if (userDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("email adresi daha once kullanilmistir.");
		}
		
		if (employer.getCompanyName().length()<2) {
			return new ErrorResult("Firma ismi en az 2 karakterden olusmalidir.");
		}
		
		if (employer.getPassword().length()<6) {
			return new ErrorResult("sifre en az 6 karakter olmalidir.");
		}
		
		if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("sifre alanlari eslesmemektedir.");
		}
		
		return new SuccessResult();
	}

}
