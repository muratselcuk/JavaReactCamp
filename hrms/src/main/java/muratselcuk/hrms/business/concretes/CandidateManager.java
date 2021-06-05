package muratselcuk.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.CandidateService;
import muratselcuk.hrms.business.abstracts.CandidateValidateService;
import muratselcuk.hrms.business.abstracts.VerificationCodeService;
import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessDataResult;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.CandidateDao;
import muratselcuk.hrms.dataAccess.abstracts.UserDao;
import muratselcuk.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateValidateService candidateValidateService;
	private VerificationCodeService verificationCodeService;
	private UserDao userDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateValidateService candidateValidateService, VerificationCodeService verificationCodeService, UserDao userDao) {
		super();
		this.candidateDao = candidateDao;
		this.candidateValidateService = candidateValidateService;
		this.verificationCodeService = verificationCodeService;
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"adaylar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if(this.candidateValidateService.candidateValidate(candidate).isSuccess()) {
			this.candidateDao.save(candidate);
			this.verificationCodeService.createVerificationCode(userDao.getById(candidate.getId()));
			this.verificationCodeService.sendMail(candidate.getEmail());
			return new SuccessResult("aday eklendi.");
		}
		return new ErrorResult(this.candidateValidateService.candidateValidate(candidate).getMessage());
	}

}
