package kodlamaio.hrms.business.concretes.checkManagers;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.checkServices.JobCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
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
	public Result checkInformationsFulfilled(Job job) {
		if (job.getJobTitle().isEmpty()) {
			return new ErrorResult("Lütfen iş pozisyonu ismini giriniz!");
		} else {
			return new SuccessResult("Bilgi girişi başarılı!");
		}
	}
	
	@Override
	public Result isValidJob(Job job) {
		if (checkInformationsFulfilled(job).isSuccess()) { //bilgiler eksiksiz girilmişse
			if ( !(checkJobNameIsUnique(job.getJobTitle())) ) { //iş pozisyonu ismi daha önce kullanılmışsa
				return new ErrorResult("İş pozisyonu eklenemedi, Bu iş pozisyonu ismi daha önce kullanılmış!");
			} else {
				return new SuccessResult("İş pozisyonu eklendi."); //isterler sağlanıyorsa
			}
		} else {
			return checkInformationsFulfilled(job);
		}
	}

}
