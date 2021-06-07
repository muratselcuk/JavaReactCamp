package muratselcuk.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import muratselcuk.hrms.business.abstracts.JobAdvertisementService;
import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.ErrorResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.core.utilities.results.SuccessDataResult;
import muratselcuk.hrms.core.utilities.results.SuccessResult;
import muratselcuk.hrms.dataAccess.abstracts.JobAdvertisementDao;
import muratselcuk.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManage implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementdao;
	
	@Autowired
	public JobAdvertisementManage(JobAdvertisementDao jobAdvertisementdao) {
		super();
		this.jobAdvertisementdao = jobAdvertisementdao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementdao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementdao.save(jobAdvertisement);
		return new SuccessResult("is ilanı eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementdao.getByIsActive(isActive), "Data Listelendi.") ;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_IdAndIsActive(int id, boolean isActive) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementdao.getByEmployer_IdAndIsActive(id, isActive),"Data Listelendi");
	}

	@Override
	public Result active(int advertisementId, int employerId){
		if(!this.jobAdvertisementdao.existsByEmployer_IdAndId(employerId, advertisementId)) {
			return new ErrorResult("isverene ait boyle bir ilan bulunamadi.");
		}
		JobAdvertisement jobAdvertisement = jobAdvertisementdao.getByEmployer_IdAndId(employerId, advertisementId);
		if(this.jobAdvertisementdao.getById(jobAdvertisement.getId()).isActive()) {
			return new ErrorResult("Bu ilan zaten aktiftir.");
		}
		jobAdvertisement.setActive(true);
		jobAdvertisementdao.save(jobAdvertisement);
		return new SuccessResult("ilan aktiflestirildi.");
	}
	
	@Override
	public Result inactive(int advertisementId, int employerId){
		if(!this.jobAdvertisementdao.existsByEmployer_IdAndId(employerId, advertisementId)) {
			return new ErrorResult("isverene ait boyle bir ilan bulunamadi.");
		}
		JobAdvertisement jobAdvertisement = jobAdvertisementdao.getByEmployer_IdAndId(employerId, advertisementId);
		if(!this.jobAdvertisementdao.getById(jobAdvertisement.getId()).isActive()) {
			return new ErrorResult("Bu ilan zaten pasiftir.");
		}
		jobAdvertisement.setActive(false);
		jobAdvertisementdao.save(jobAdvertisement);
		return new SuccessResult("ilan pasiflestirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementdao.findAll(sort), "Data Listelendi.");
	}

}
