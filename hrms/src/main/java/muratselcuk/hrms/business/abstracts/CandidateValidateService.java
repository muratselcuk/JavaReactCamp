package muratselcuk.hrms.business.abstracts;

import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.Candidate;

public interface CandidateValidateService {

	Result candidateValidate(Candidate candidate);
}
