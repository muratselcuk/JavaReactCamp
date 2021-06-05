package muratselcuk.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.EmployerApprovedService;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.EmployerApprovedDao;
import muratselcuk.hrms.dataAccess.abstracts.EmployerDao;
import muratselcuk.hrms.entities.concretes.Admin;
import muratselcuk.hrms.entities.concretes.Employer;
import muratselcuk.hrms.entities.concretes.EmployerApproved;

@Service
public class EmployerApprovedManager implements EmployerApprovedService{

	private EmployerApprovedDao employerApprovedDao;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerApprovedManager(EmployerApprovedDao employerApprovedDao, EmployerDao employerDao) {
		super();
		this.employerApprovedDao = employerApprovedDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result confirmEmployer(Employer employer, Admin admin) {
		
		EmployerApproved employerApproved = new EmployerApproved();

		employerApproved.setEmployerId(employer);
		employerApproved.setAdminId(admin);
		
	
		if(!employerDao.existsByid(employer.getId())){
			return new ErrorResult("isveren kaydi bulunamadi");
		}
		
		if(employerApprovedDao.existsByEmployerId_Id(employer.getId())) {
			if(employerApprovedDao.getByEmployerId_Id(employer.getId()).isConfirmed()) {
				
				return new ErrorResult("isveren daha once onaylanmistir.");
			}	
		}
		
	
		employerApproved.setConfirmed(true);
		employerApprovedDao.save(employerApproved);
		return new SuccessResult("Yonetici tarafindan isveren onaylandi.");
	}

	
}
