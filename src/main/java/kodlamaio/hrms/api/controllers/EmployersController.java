package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
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
	List<Employer> getAll(){
		return this.employerService.getAll();
	}

}
