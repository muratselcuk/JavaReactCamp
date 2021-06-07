package muratselcuk.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import muratselcuk.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{


}
