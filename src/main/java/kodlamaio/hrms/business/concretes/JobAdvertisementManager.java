package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı Eklendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getByCompanyName(String companyName) {
		if (this.jobAdvertisementDao.getByCompanyName(companyName).isEmpty()) {
			return new ErrorDataResult<>(companyName + " iş verenine ait ilan bulunamadı.");
		} else {
			return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByCompanyName(companyName),
					companyName+" iş verenine ait ilanlar listelendi");
		}
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateAsc() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllOrderByEndDateAsc(),"Data Listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateDesc() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllOrderByEndDateDesc(),"Data Listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoByStatusTrue() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDtoByStatusTrue(),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result updateJobAdvertisementStatus(int jobAdvertisementId) {
		if (this.jobAdvertisementDao.findById(jobAdvertisementId).isPresent()) {
			this.jobAdvertisementDao.updateJobAdvertisementStatus(jobAdvertisementId);
			return new SuccessResult("İş İlanı Pasif Duruma Getirildi") ;
		} else {
			return new ErrorResult("Girdiğiniz id'ye ait bir ilan bulunmadı.");
		}
	}

}