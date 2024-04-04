package kodlamaio.hrms.business.abstracts.checkServices;

public interface EmployerCheckService extends CheckService {

	boolean checkMailMatchesDomain(String eMail, String domain);

}
