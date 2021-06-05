package muratselcuk.hrms.adapters.service;

import muratselcuk.hrms.entities.concretes.Candidate;

public interface PersonVerifyService {

	boolean chekIfRealPerson(Candidate candidate);
}
