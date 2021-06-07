package muratselcuk.hrms.business.abstracts;

import java.util.List;

import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive);
	DataResult<List<JobAdvertisement>> getByEmployer_IdAndIsActive(int id, boolean isActive);
	Result active(int advertisementId, int employerId);
	Result inactive(int advertisementId, int employerId);
	DataResult<List<JobAdvertisement>> getAllSorted();
}