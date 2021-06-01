package muratselcuk.hrms.business.abstracts;

import java.util.List;

import muratselcuk.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	List<JobPosition> getAll();
}
