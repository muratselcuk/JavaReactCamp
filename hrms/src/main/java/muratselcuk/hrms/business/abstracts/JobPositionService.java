package muratselcuk.hrms.business.abstracts;

import java.util.List;

import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
}
