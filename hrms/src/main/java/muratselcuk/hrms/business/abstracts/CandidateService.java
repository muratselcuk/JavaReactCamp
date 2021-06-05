package muratselcuk.hrms.business.abstracts;

import java.util.List;

import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
}
