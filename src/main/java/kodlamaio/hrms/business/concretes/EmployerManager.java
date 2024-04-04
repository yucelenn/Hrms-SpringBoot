package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.checkServices.EmployerCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerCheckService checkService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService checkService) {
		super();
		this.employerDao = employerDao;
		this.checkService = checkService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if ( checkService.isValidEmployer(employer).isSuccess() ) {
			this.employerDao.save(employer);
			return checkService.isValidEmployer(employer);
		}
		else {
			return checkService.isValidEmployer(employer);
		}
	}

}