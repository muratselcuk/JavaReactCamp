package muratselcuk.hrms.business.abstracts;

import muratselcuk.hrms.core.utilities.results.Result;
import muratselcuk.hrms.entities.concretes.Admin;

public interface AdminService {

	Result add(Admin admin);
}
