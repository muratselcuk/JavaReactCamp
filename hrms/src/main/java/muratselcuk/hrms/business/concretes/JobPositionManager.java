package muratselcuk.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.JobPositionService;
import muratselcuk.hrms.dataAccess.abstracts.JobPositionDao;
import muratselcuk.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public List<JobPosition> getAll() {
		
		return this.jobPositionDao.findAll();
	}

}
