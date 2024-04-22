package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	DataResult<List<Job>>  getAll();
	DataResult<List<Job>> getAll(int pageNo, int pageSize);
	DataResult<List<Job>> getAllSortedByJobTitleAsc();
	DataResult<List<Job>> getAllSortedByJobTitleDesc();
	Result add(Job job);
	
	DataResult<Job> getByJobTitle(String jobTitle);
	DataResult<List<Job>> getByJobTitleStartsWith(String jobTitle);
	DataResult<List<Job>> getByJobTitleContains(String jobTitle);
}