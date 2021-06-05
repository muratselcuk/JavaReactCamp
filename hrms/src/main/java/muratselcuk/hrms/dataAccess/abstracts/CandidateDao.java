package muratselcuk.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	boolean existsByIdentityNumber(String identity_number);
}
