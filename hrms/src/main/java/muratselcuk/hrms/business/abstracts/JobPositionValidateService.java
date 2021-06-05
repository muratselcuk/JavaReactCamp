package muratselcuk.hrms.business.abstracts;

import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.JobPosition;

public interface JobPositionValidateService {

	Result jobPositionValidate(JobPosition jobPosition);
}
