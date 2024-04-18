package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	public EmployerService employerService;

	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);		
	}

	@GetMapping("/getByeMail")
	public DataResult<Employer> getByeMail(@RequestParam String eMail) {
		return this.employerService.getByeMail(eMail);
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<Employer> getByCompanyName(@RequestParam String companyName) {
		return this.employerService.getByCompanyName(companyName);
	}
	
	@GetMapping("/getByWebAdress")
	public DataResult<Employer> getByWebAdress(@RequestParam String webAdress) {
		return this.employerService.getByWebAdress(webAdress);
	}
	
	@GetMapping("/getByPhoneNumber")
	public DataResult<Employer> getByPhoneNumber(@RequestParam String phoneNumber) {
		return this.employerService.getByPhoneNumber(phoneNumber);
	}
}