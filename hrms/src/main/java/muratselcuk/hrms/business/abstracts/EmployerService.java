package muratselcuk.hrms.business.abstracts;

import java.util.List;

import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
