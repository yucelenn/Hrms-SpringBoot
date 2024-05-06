package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobService;

	@Autowired
	public JobsController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class) //sistemde hata oluşursa bu metodu çağırır
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){ //oluşan hatayı method parametresi olarak geçecek
		Map<String, String> validationErrors = new HashMap<String, String>();
		for ( FieldError fieldError : exceptions.getBindingResult().getFieldErrors() ) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());//entitylerdeki NotBlank leri çalıştıracak
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll(){
		return this.jobService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Job job) {
		return ResponseEntity.ok(this.jobService.add(job));	
	}

	@GetMapping("/getByJobTitle")
	public DataResult<Job> getByJobTitle(@RequestParam String jobTitle) {
		return this.jobService.getByJobTitle(jobTitle);
	}
	
	@GetMapping("/getByJobTitleStartsWith")
	public DataResult<List<Job>> getByJobTitleStartsWith(@RequestParam String jobTitle) {
		return this.jobService.getByJobTitleStartsWith(jobTitle);
	}
	
	@GetMapping("/getByJobTitleContains")
	public DataResult<List<Job>> getByJobTitleContains(@RequestParam String jobTitle) {
		return this.jobService.getByJobTitleContains(jobTitle);
	}
	
	@GetMapping("/getAllPageable")
	public DataResult<List<Job>> getAll(int pageNo, int pageSize) {
		return this.jobService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSortedByJobTitleAsc")
	public DataResult<List<Job>> getAllSortedByJobTitleAsc() {
		return this.jobService.getAllSortedByJobTitleAsc();
	}
	
	@GetMapping("/getAllSortedByJobTitleDesc")
	public DataResult<List<Job>> getAllSortedByJobTitleDesc() {
		return this.jobService.getAllSortedByJobTitleDesc();
	}
}