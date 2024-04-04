package kodlamaio.hrms.business.concretes.checkManagers;

import kodlamaio.hrms.business.abstracts.checkServices.EmployerCheckService;

public class EmployerCheckManager implements EmployerCheckService{

	@Override
	public boolean checkMailIsUnique(String eMail) {
		// bu metodu doldur jpa ile
		return true;
	}

	@Override
	public boolean checkMailMatchesDomain(String eMail, String domain) {
		String[] emails = eMail.split("[@.]+");
        String[] domains = domain.split("\\.");
        return ( domains[0].equalsIgnoreCase(emails[1]) || domains[1].equalsIgnoreCase(emails[1]));
	}

}