package muratselcuk.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import muratselcuk.hrms.business.abstracts.AdminService;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.Admin;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Admin admin) {
		return this.adminService.add(admin);
	}
}
