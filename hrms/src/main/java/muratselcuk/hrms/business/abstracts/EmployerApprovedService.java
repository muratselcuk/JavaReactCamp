package muratselcuk.hrms.business.abstracts;

import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.Admin;
import muratselcuk.hrms.entities.concretes.Employer;

public interface EmployerApprovedService {


	Result confirmEmployer(Employer employer, Admin admin);
}
