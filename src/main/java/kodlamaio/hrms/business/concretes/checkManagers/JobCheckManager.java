package kodlamaio.hrms.business.concretes.checkManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.checkServices.JobCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobCheckManager implements JobCheckService{

	private JobDao jobDao;
	
	@Autowired
	public JobCheckManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public boolean checkJobNameIsUnique(String jobName) {
		if (this.jobDao.getByJobTitle(jobName) != null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public Result checkInformationsFulfilled(Job job) {
		if (job.getJobTitle().isEmpty()) {
			return new ErrorResult("Lütfen iş pozisyonu ismi giriniz!");
		} else {
			return new SuccessResult("Bilgi girişi başarılı!");
		}
	}
	
	@Override
	public Result isValidJob(Job job) {
		//if (checkInformationsFulfilled(job).isSuccess()) { //bilgiler eksiksiz girilmişse
		//NotBlank-Valid handleValidationException sayesinde gerek kalmadı bu if else'e
			if ( !(checkJobNameIsUnique(job.getJobTitle())) ) { //iş pozisyonu ismi daha önce kullanılmışsa
				return new ErrorResult("İş pozisyonu eklenemedi, Bu iş pozisyonu ismi daha önce kullanılmış!");
			} else {
				return new SuccessResult("İş pozisyonu eklendi."); //isterler sağlanıyorsa
			}
	}

}
