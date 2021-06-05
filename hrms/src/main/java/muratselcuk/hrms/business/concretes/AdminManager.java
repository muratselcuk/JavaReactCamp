package muratselcuk.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.AdminService;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.AdminDao;
import muratselcuk.hrms.entities.concretes.Admin;

@Service
public class AdminManager implements AdminService {

	private AdminDao adminDao;
	
	
	@Autowired
	public AdminManager(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}


	@Override
	public Result add(Admin admin) {

		this.adminDao.save(admin);
		return new SuccessResult("Yonetici eklendi.");
	}

}
