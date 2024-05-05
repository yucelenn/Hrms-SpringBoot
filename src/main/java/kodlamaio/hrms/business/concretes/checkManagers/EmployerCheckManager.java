package kodlamaio.hrms.business.concretes.checkManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.checkServices.EmployerCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService{
	private EmployerDao employerDao;

	@Autowired
	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public boolean checkMailIsUnique(String eMail) {
		if (employerDao.getByeMail(eMail) != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkMailMatchesDomain(String eMail, String domain) {
		String[] emails = eMail.split("[@.]+");
		String[] domains = domain.split("\\.");
		return ( domains[0].equalsIgnoreCase(emails[1]) || domains[1].equalsIgnoreCase(emails[1]) );
	}

	@Override
	public Result checkInformationsFulfilled(Employer employer) {//validation sayesinde gerek kalmadı bu methoda
		if (employer.getCompanyName().isEmpty()) {
			return new ErrorResult("Lütfen şirket isminizi giriniz!");
		}
		else if (employer.getWebAdress().isEmpty()) {
			return new ErrorResult("Lütfen web site adresinizi giriniz!");
		}
		else if (employer.getEMail().isEmpty()) {
			return new ErrorResult("Lütfen e postanızı giriniz!");
		}
		else if (employer.getPhoneNumber().isEmpty()) {
			return new ErrorResult("Lütfen telefon numaranızı giriniz!");
		}
		else if (employer.getPassword().isEmpty()) {
			return new ErrorResult("Lütfen şifre bilgisini giriniz!");
		}
		else {
			return new SuccessResult("Bilgi girişi başarılı!");
		}
	}

	@Override
	public Result isValidEmployer(Employer employer) {
		//if (checkInformationsFulfilled(employer).isSuccess()) { //bilgiler eksiksiz girilmişse
		// NotBlank-Valid handleValidationException sayesinde gerek kalmadı bu if else'e
			if ( !(checkMailIsUnique(employer.getEMail())) ) { //mail daha önce kullanılmışsa
				return new ErrorResult("İş veren eklenemedi, Bu e posta daha önce kullanılmış!");
			}
			else if ( !(checkMailMatchesDomain(employer.getEMail(), employer.getWebAdress())) ) { //mail ile domain uyuşmuyorsa
				return new ErrorResult("İş veren eklenemedi, E posta ile domain uyuşmuyor!");
			}
			else {
				return new SuccessResult("İş veren eklendi."); //isterler sağlanıyorsa
			}
	}

}