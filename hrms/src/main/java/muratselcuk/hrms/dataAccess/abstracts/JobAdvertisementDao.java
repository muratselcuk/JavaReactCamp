package muratselcuk.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByIsActive(boolean isActive);
	List<JobAdvertisement> getByEmployer_IdAndIsActive(int id, boolean isActive);
	JobAdvertisement getByEmployer_IdAndId(int employerId, int advertisementId);
	boolean existsByEmployer_IdAndId(int employerId, int advertisementId);
}
