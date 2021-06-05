package muratselcuk.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import muratselcuk.hrms.business.abstracts.VerificationCodeService;
import muratselcuk.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/valid")
public class VerificationCodeController {

	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificationCodeController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}
	
	@PutMapping("/{verificationCode}")
	public Result update(@PathVariable("verificationCode") String verificationCode) {
		return verificationCodeService.verifyUser(verificationCode);
	}
		
}
