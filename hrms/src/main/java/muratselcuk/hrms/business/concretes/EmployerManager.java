package muratselcuk.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.EmployerService;
import muratselcuk.hrms.business.abstracts.EmployerValidateService;
import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessDataResult;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.EmployerDao;
import muratselcuk.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerValidateService employerValidateService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerValidateService employerValidateService) {
		super();
		this.employerDao = employerDao;
		this.employerValidateService=employerValidateService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"isverenler listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		
		if(this.employerValidateService.employerValidate(employer).isSuccess()) {
			this.employerDao.save(employer);
			return new SuccessResult("isveren eklendi");
		}
		return new ErrorResult(this.employerValidateService.employerValidate(employer).getMessage());
	}

}
