package muratselcuk.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {

	VerificationCode getByCode(String code);
	boolean existsByCode(String code);
}
