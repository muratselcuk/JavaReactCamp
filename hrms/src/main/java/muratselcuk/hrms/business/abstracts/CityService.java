package muratselcuk.hrms.business.abstracts;

import java.util.List;

import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();
}
