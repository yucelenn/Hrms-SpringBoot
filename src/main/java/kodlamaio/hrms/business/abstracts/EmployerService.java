package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	DataResult<List<Employer>> getAll(int pageNo, int pageSize);
	Result add(Employer employer);
	
	DataResult<Employer> getByeMail(String eMail);
	DataResult<Employer> getByCompanyName(String companyName);
	DataResult<Employer> getByWebAdress(String webAdress);
	DataResult<Employer> getByPhoneNumber(String phoneNumber);
	DataResult<List<Employer>> getByCompanyNameStartsWith(String companyName);
	DataResult<List<Employer>> getByCompanyNameContains(String companyName);
}