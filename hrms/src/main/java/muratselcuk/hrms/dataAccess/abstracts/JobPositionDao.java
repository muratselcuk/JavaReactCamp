package muratselcuk.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

	boolean existsByTitle(String title);
}
