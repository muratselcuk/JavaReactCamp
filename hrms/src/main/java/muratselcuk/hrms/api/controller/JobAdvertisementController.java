package muratselcuk.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import muratselcuk.hrms.business.abstracts.JobAdvertisementService;
import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/JobAdvertisements")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/active")
	public Result active(@RequestParam("advertisementId") int advertisementId, @RequestParam("employerId") int employerId) {
		return this.jobAdvertisementService.active(advertisementId, employerId);
	}
	
	@PostMapping("/inactive")
	public Result inactive(@RequestParam("advertisementId") int advertisementId, @RequestParam("employerId") int employerId) {
		return this.jobAdvertisementService.inactive(advertisementId, employerId);
	}
	
	@GetMapping("/getallactive")
	public DataResult<List<JobAdvertisement>> getByJobIsActive(){
		return this.jobAdvertisementService.getByIsActive(true);
	}
	
	@GetMapping("/getallemployer")
	public DataResult<List<JobAdvertisement>> getByEmployer_IdAndIsActive(@RequestParam("id") int id){
		return this.jobAdvertisementService.getByEmployer_IdAndIsActive(id, true);
	}
	
	@GetMapping("/getallsorteddatedsc")
	public DataResult<List<JobAdvertisement>> getAllSorted(){
		return this.jobAdvertisementService.getAllSorted();
	}
}
