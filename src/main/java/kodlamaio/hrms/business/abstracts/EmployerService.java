package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	
	DataResult<Employer> getByeMail(String eMail);
	DataResult<Employer> getByCompanyName(String companyName);
	DataResult<Employer> getByWebAdress(String webAdress);
	DataResult<Employer> getByPhoneNumber(String phoneNumber);
}