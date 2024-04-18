package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;

	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);	
	}

	@GetMapping("/getByJobTitle")
	public DataResult<Job> getByJobTitle(@RequestParam String jobTitle) {
		return this.jobService.getByJobTitle(jobTitle);
	}
	
	@GetMapping("/getByJobTitleStartsWith")
	public DataResult<List<Job>> getByJobTitleStartsWith(@RequestParam String jobTitle) {
		return this.jobService.getByJobTitleStartsWith(jobTitle);
	}
}