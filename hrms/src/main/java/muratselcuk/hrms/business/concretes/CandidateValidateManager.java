package muratselcuk.hrms.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import muratselcuk.hrms.adapters.service.PersonVerifyService;
import muratselcuk.hrms.business.abstracts.CandidateValidateService;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.CandidateDao;
import muratselcuk.hrms.dataAccess.abstracts.UserDao;
import muratselcuk.hrms.entities.concretes.Candidate;

@Service
public class CandidateValidateManager implements CandidateValidateService{

	private CandidateDao candidateDao;
	private UserDao userDao;
	private PersonVerifyService personVerifyService;
	
	public CandidateValidateManager(CandidateDao candidateDao, UserDao userDao, PersonVerifyService personVerifyService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao=userDao;
		this.personVerifyService = personVerifyService;
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean eMailValidate(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.find();
		}
	
	
	@Override
	public Result candidateValidate(Candidate candidate) {

		if (candidate.getFirstName()==null ||
				candidate.getLastName()==null ||
				candidate.getBirthDate()==null ||
				candidate.getIdentityNumber()==null ||
				candidate.getEmail()==null ||
				candidate.getPassword()==null
				) {
			return new ErrorResult("isim, soyisim, dogum tarihi, kimlik numarası, mail ve sifre alanları bos birakilamaz.");
		}
		
		if (candidateDao.existsByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("TC kimlik numarasi daha once kullanilmistir.");
		}
		
		if (!(eMailValidate(candidate.getEmail()))) {
			return new ErrorResult("gecerli bir email adresi girmediniz.");
		}
		
		if (userDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("email adresi daha once kullanilmistir.");
		}
		
		if (candidate.getFirstName().length()<2 || candidate.getLastName().length()<2) {
			return new ErrorResult("Ad ve soyad en az 2 karakterden olusmalidir.");
		}
		
		if (candidate.getPassword().length()<6) {
			return new ErrorResult("sifre en az 6 karakter olmalidir.");
		}
		
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("sifre alanlari eslesmemektedir.");
		}
		
		if (!personVerifyService.chekIfRealPerson(candidate)) {
			return new ErrorResult("Mernis kimlik bilgileri eslesmedi");
		}
		return new SuccessResult();
	}

}
