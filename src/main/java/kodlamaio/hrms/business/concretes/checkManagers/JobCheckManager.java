package kodlamaio.hrms.business.concretes.checkManagers;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.checkServices.JobCheckService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobCheckManager implements JobCheckService{

	@Override
	public boolean checkJobNameIsUnique(String jobName) {
		// burayı JPA ile doldur.
		return true;
	}

	@Override
	public Result isValidJob(Job job) {

		return null;
	}

}
