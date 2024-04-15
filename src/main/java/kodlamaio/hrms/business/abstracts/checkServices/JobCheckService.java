package kodlamaio.hrms.business.abstracts.checkServices;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobCheckService{
	boolean checkJobNameIsUnique(String jobName);
	Result isValidJob(Job job);
}
