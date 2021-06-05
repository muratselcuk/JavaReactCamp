package muratselcuk.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.JobPositionValidateService;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.JobPositionDao;
import muratselcuk.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionValidateManager implements JobPositionValidateService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionValidateManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public Result jobPositionValidate(JobPosition jobPosition) {
		if (jobPositionDao.existsByTitle(jobPosition.getTitle())) {
			return new ErrorResult("Bu is pozisyonu daha once eklenmistir.");
		}
		return new SuccessResult();
	}

	
}
