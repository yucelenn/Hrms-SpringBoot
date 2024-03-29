package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemWorker;

@RestController
@RequestMapping("/api/system_workers")
public class SystemWorkerController {

	public SystemWorkerService systemWorkerService;

	public SystemWorkerController(SystemWorkerService systemWorkerService) {
		super();
		this.systemWorkerService = systemWorkerService;
	}
	
	@GetMapping("/getall")
	DataResult<List<SystemWorker>> getAll(){
		return this.systemWorkerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemWorker systemWorker) {
		return this.systemWorkerService.add(systemWorker);	
	}
}
