package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);	
	DataResult<List<JobAdvertisementDto>> getByCompanyName(String companyName);	
	DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateAsc();	
	DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateDesc();
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoByStatusTrue();	
	DataResult<List<JobAdvertisement>> getAll();	
	Result updateJobAdvertisementStatus(int jobAdvertisementId);
}
