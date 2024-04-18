package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemWorker;

@RestController
@RequestMapping("/api/system_workers")
public class SystemWorkersController {

	public SystemWorkerService systemWorkerService;

	public SystemWorkersController(SystemWorkerService systemWorkerService) {
		super();
		this.systemWorkerService = systemWorkerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemWorker>> getAll(){
		return this.systemWorkerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemWorker systemWorker) {
		return this.systemWorkerService.add(systemWorker);	
	}
	
	@GetMapping("/getByeMail")
	public DataResult<SystemWorker> getByeMail(@RequestParam String eMail) {
		return this.systemWorkerService.getByeMail(eMail);
	}
	
	@GetMapping("/getByFirstName")
	public DataResult<List<SystemWorker>> getByFirstName(@RequestParam String firstName){
		return this.systemWorkerService.getByFirstName(firstName);
	}
	
	@GetMapping("/getByLastName")
	public DataResult<List<SystemWorker>> getByLastName(@RequestParam String lastName){
		return this.systemWorkerService.getByLastName(lastName);
	}
	
	@GetMapping("/getByFirstNameStartsWith")
	public DataResult<List<SystemWorker>> getByFirstNameStartsWith(@RequestParam String firstName){
		return this.systemWorkerService.getByFirstNameStartsWith(firstName);
	}
	
}