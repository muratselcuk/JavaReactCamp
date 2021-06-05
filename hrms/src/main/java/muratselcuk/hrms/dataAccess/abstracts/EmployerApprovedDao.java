package muratselcuk.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.EmployerApproved;

public interface EmployerApprovedDao extends JpaRepository<EmployerApproved, Integer> {

	EmployerApproved getByEmployerId_Id(int id);
	boolean existsByEmployerId_Id(int id);
}
