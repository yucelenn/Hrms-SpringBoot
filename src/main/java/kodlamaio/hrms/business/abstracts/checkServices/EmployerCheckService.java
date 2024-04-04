package kodlamaio.hrms.business.abstracts.checkServices;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerCheckService extends CheckService {

	boolean checkMailMatchesDomain(String eMail, String domain);
	Result isValidEmployer(Employer employer);
}
