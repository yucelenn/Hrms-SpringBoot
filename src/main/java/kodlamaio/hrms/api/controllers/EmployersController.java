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
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	public EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
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
	DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.add(employer));		
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
	
	@GetMapping("/getByCompanyNameStartsWith")
	public DataResult<List<Employer>> getByCompanyNameStartsWith(@RequestParam String companyName) {
		return this.employerService.getByCompanyNameStartsWith(companyName);
	}
	
	@GetMapping("/getByCompanyNameContains")
	public DataResult<List<Employer>> getByCompanyNameContains(@RequestParam String companyName) {
		return this.employerService.getByCompanyNameContains(companyName);
	}
	
	@GetMapping("/getAllPageable")
	public DataResult<List<Employer>> getAll(int pageNo, int pageSize) {
		return this.employerService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSortedByCompanyNameAsc")
	public DataResult<List<Employer>> getAllSortedByCompanyNameAsc() {
		return this.employerService.getAllSortedByCompanyNameAsc();
	}
	
	@GetMapping("/getAllSortedByCompanyNameDesc")
	public DataResult<List<Employer>> getAllSortedByCompanyNameDesc() {
		return this.employerService.getAllSortedByCompanyNameDesc();
	}
}