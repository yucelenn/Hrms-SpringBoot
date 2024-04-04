package kodlamaio.hrms.business.concretes.checkManagers;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.checkServices.EmployerCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
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
		return ( domains[0].equalsIgnoreCase(emails[1]) || domains[1].equalsIgnoreCase(emails[1]) );
	}

	@Override
	public Result isValidEmployer(Employer employer) {
		if (checkMailIsUnique(employer.getEMail())) {
			if (checkMailMatchesDomain(employer.getEMail(), employer.getWebAdress())) {
				return new SuccessResult("İş veren eklendi.");
			}
			else {
				return new ErrorResult("İş veren eklenemedi, E posta ile domain uyuşmuyor!");
			}
		}
		else {
			return new ErrorResult("İş veren eklenemedi, Bu e posta daha önce kullanılmış!");
		}
	}

	
}