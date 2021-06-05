package muratselcuk.hrms.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import muratselcuk.hrms.business.abstracts.EmployerApprovedService;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.dataAccess.abstracts.AdminDao;
import muratselcuk.hrms.dataAccess.abstracts.EmployerDao;

@RestController
@RequestMapping("/validEmployer")
public class EmployerApprovedController {
	
	private EmployerApprovedService employerApprovedService;
	private EmployerDao employerDao;
	private AdminDao adminDao;

	public EmployerApprovedController(EmployerApprovedService employerApprovedService, EmployerDao employerDao, AdminDao adminDao) {
		super();
		this.employerApprovedService = employerApprovedService;
		this.employerDao = employerDao;
		this.adminDao = adminDao;
	}
	
	@PutMapping("/{adminId}/{employerId}")
	public Result update(@PathVariable("adminId") int adminId, @PathVariable("employerId") int employerId) {
		return employerApprovedService.confirmEmployer(employerDao.getById(employerId), adminDao.getById(adminId));
	}
	

}
