package muratselcuk.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{

}
