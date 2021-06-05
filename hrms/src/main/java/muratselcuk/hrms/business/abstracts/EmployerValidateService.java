package muratselcuk.hrms.business.abstracts;

import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.Employer;

public interface EmployerValidateService {

	Result employerValidate(Employer employer);
}
