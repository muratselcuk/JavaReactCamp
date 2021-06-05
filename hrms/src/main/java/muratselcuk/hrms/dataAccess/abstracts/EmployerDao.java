package muratselcuk.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	boolean existsByid(int id);

}
