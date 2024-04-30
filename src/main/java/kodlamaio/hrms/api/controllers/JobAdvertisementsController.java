package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvertisementDto>> getByCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByCompanyName(companyName);
	}
	
	@GetMapping("/getAllOrderByEndDateAsc")
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateAsc(){
		return this.jobAdvertisementService.getAllOrderByEndDateAsc();
	}
	
	@GetMapping("/getAllOrderByEndDateDesc")
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateDesc(){
		return this.jobAdvertisementService.getAllOrderByEndDateDesc();
	}
	
	@GetMapping("/getJobAdvertisementDtoByStatusTrue")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoByStatusTrue(){
		return this.jobAdvertisementService.getJobAdvertisementDtoByStatusTrue();
	}
	
	@PutMapping("/updateJobAdvertisementStatus")
	@Transactional
	public Result updateJobAdvertisementStatus(@RequestParam int jobAdvertisementId) {
	    return this.jobAdvertisementService.updateJobAdvertisementStatus(jobAdvertisementId);
	}
	
}
