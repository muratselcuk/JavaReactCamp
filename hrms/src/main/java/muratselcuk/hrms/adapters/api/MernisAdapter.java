package muratselcuk.hrms.adapters.api;


import org.springframework.stereotype.Service;

import muratselcuk.hrms.adapters.service.PersonVerifyService;
import muratselcuk.hrms.entities.concretes.Candidate;

@Service
public class MernisAdapter implements PersonVerifyService{

	@Override
	public boolean chekIfRealPerson(Candidate candidate) {
		// Fake Service
		return true;
	}

}
