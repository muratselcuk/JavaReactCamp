package muratselcuk.hrms.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.VerificationCodeService;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.VerificationCodeDao;
import muratselcuk.hrms.entities.concretes.User;
import muratselcuk.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public void createVerificationCode(User user) {
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setUserId(user);
		verificationCode.setCode(UUID.randomUUID().toString());
		this.verificationCodeDao.save(verificationCode);
	}

	@Override
	public void sendMail(String mail) {
		
		System.out.println("üyelik doğrulama maili gönderildi." + mail);
		
	}

	@Override
	public Result verifyUser(String code) {

		if(!this.verificationCodeDao.existsByCode(code)) {
			return new ErrorResult("Dogrulama kodu yanlis");
		}

		VerificationCode verificationCode = verificationCodeDao.getByCode(code);
		
		if(this.verificationCodeDao.getById(verificationCode.getId()).isConfirmed()) {
			return new ErrorResult("Dogrulama daha once yapilmistir.");
		}
		
		verificationCode.setConfirmed(true);
		verificationCodeDao.save(verificationCode);
		
		return new SuccessResult("Dogrulama islemi yapildi.");
	}

}
