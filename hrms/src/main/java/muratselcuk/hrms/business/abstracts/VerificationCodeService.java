package muratselcuk.hrms.business.abstracts;

import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.User;

public interface VerificationCodeService {

	void createVerificationCode(User user);
	void sendMail(String mail);
	Result verifyUser(String code);
}
