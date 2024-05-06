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
import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.SystemWorker;

@RestController
@RequestMapping("/api/system_workers")
public class SystemWorkersController {

	public SystemWorkerService systemWorkerService;

	@Autowired
	public SystemWorkersController(SystemWorkerService systemWorkerService) {
		super();
		this.systemWorkerService = systemWorkerService;
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
	public DataResult<List<SystemWorker>> getAll(){
		return this.systemWorkerService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SystemWorker systemWorker) {
		return ResponseEntity.ok(this.systemWorkerService.add(systemWorker));	
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
	
	@GetMapping("/getByFirstNameContains")
	public DataResult<List<SystemWorker>> getByFirstNameContains(@RequestParam String firstName){
		return this.systemWorkerService.getByFirstNameContains(firstName);
	}
	
	@GetMapping("/getAllPageable")
	public DataResult<List<SystemWorker>> getAll(int pageNo, int pageSize) {
		return this.systemWorkerService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSortedByNameAsc")
	public DataResult<List<SystemWorker>> getAllSortedByNameAsc() {
		return this.systemWorkerService.getAllSortedByNameAsc();
	}
	
	@GetMapping("/getAllSortedByNameDesc")
	public DataResult<List<SystemWorker>> getAllSortedByNameDesc() {
		return this.systemWorkerService.getAllSortedByNameDesc();
	}
	
	@GetMapping("/getAllSortedByLastNameAsc")
	public DataResult<List<SystemWorker>> getAllSortedByLastNameAsc() {
		return this.systemWorkerService.getAllSortedByLastNameAsc();
	}
	
	@GetMapping("/getAllSortedByLastNameDesc")
	public DataResult<List<SystemWorker>> getAllSortedByLastNameDesc() {
		return this.systemWorkerService.getAllSortedByLastNameDesc();
	}
}