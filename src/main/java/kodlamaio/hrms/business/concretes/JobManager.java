package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.business.abstracts.checkServices.JobCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	private JobCheckService checkService;
	
	@Autowired
	public JobManager(JobDao jobDao, JobCheckService checkService) {
		super();
		this.jobDao = jobDao;
		this.checkService = checkService;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(Job job) {
		if (checkService.isValidJob(job).isSuccess()) {
			this.jobDao.save(job);
			return checkService.isValidJob(job);
		}
		else {
			return checkService.isValidJob(job);
		}
	}

	@Override
	public DataResult<Job> getByJobTitle(String jobTitle) {
		//iş kodlarını buraya döşe

		return new SuccessDataResult<Job>(this.jobDao.getByJobTitle(jobTitle), "Data listelendi.");
	
	}

}