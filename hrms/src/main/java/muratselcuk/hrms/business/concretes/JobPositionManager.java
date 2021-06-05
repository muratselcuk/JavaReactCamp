package muratselcuk.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.JobPositionService;
import muratselcuk.hrms.business.abstracts.JobPositionValidateService;
import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessDataResult;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.JobPositionDao;
import muratselcuk.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	private JobPositionValidateService jobPositionValidateService;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao, JobPositionValidateService jobPositionValidateService) {
		super();
		this.jobPositionDao = jobPositionDao;
		this.jobPositionValidateService=jobPositionValidateService;
		
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "is pozisyonlari listelendi.");
	}


	@Override
	public Result add(JobPosition jobPosition) {
		if(this.jobPositionValidateService.jobPositionValidate(jobPosition).isSuccess()) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("is pozisyonu eklendi");
		}
		return new ErrorResult(this.jobPositionValidateService.jobPositionValidate(jobPosition).getMessage());
	}

}
