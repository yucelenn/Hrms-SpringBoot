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
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.dtos.CandidateDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	public CandidateService candidateService;
	
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
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
	DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) { // HTTP kodları için 200 - 300 - 400 ...
		return ResponseEntity.ok(this.candidateService.add(candidate));		
	}
	
	@GetMapping("/getByeMail")
	public DataResult<Candidate> getByeMail(@RequestParam String eMail) {
		return this.candidateService.getByeMail(eMail);
	}
	
	@GetMapping("/getByFirstName")
	public DataResult<List<Candidate>> getByFirstName(@RequestParam String firstName) {
		return this.candidateService.getByFirstName(firstName);
	}
	
	@GetMapping("/getByLastName")
	public DataResult<List<Candidate>> getByLastName(@RequestParam String lastName) {
		return this.candidateService.getByLastName(lastName);
	}
	
	@GetMapping("/getByIdentityNumber")
	public DataResult<Candidate> getByIdentityNumber(@RequestParam String identityNumber) {
		return this.candidateService.getByIdentityNumber(identityNumber);
	}
	
	@GetMapping("/getByBirthYear")
	public DataResult<List<Candidate>> getByBirthYear(@RequestParam String birthYear) {
		return this.candidateService.getByBirthYear(birthYear);
	}
	
	@GetMapping("/getByFirstNameContains")
	public DataResult<List<Candidate>> getByFirstNameContains(@RequestParam String firstName) {
		return this.candidateService.getByFirstNameContains(firstName);
	}
	
	@GetMapping("/getByLastNameContains")
	public DataResult<List<Candidate>> getByLastNameContains(@RequestParam String lastName) {
		return this.candidateService.getByLastNameContains(lastName);
	}
	
	@GetMapping("/getByFirstNameStartsWith")
	public DataResult<List<Candidate>> getByFirstNameStartsWith(@RequestParam String firstName) {
		return this.candidateService.getByFirstNameStartsWith(firstName);
	}
	
	@GetMapping("/getByLastNameStartsWith")
	public DataResult<List<Candidate>> getByLastNameStartsWith(@RequestParam String lastName) {
		return this.candidateService.getByLastNameStartsWith(lastName);
	}
	
	@GetMapping("/getAllPageable")
	public DataResult<List<Candidate>> getAll(int pageNo, int pageSize) {
		return this.candidateService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSortedByNameAsc")
	public DataResult<List<Candidate>> getAllSortedByNameAsc() {
		return this.candidateService.getAllSortedByNameAsc();
	}
	
	@GetMapping("/getAllSortedByNameDesc")
	public DataResult<List<Candidate>> getAllSortedByNameDesc() {
		return this.candidateService.getAllSortedByNameDesc();
	}
	
	@GetMapping("/getAllSortedByLastNameAsc")
	public DataResult<List<Candidate>> getAllSortedByLastNameAsc() {
		return this.candidateService.getAllSortedByLastNameAsc();
	}
	
	@GetMapping("/getAllSortedByLastNameDesc")
	public DataResult<List<Candidate>> getAllSortedByLastNameDesc() {
		return this.candidateService.getAllSortedByLastNameDesc();
	}
	
	@GetMapping("/getAllSortedByBirthYearAsc")
	public DataResult<List<Candidate>> getAllSortedByBirthYearAsc() {
		return this.candidateService.getAllSortedByBirthYearAsc();
	}
	
	@GetMapping("/getAllSortedByBirthYearDesc")
	public DataResult<List<Candidate>> getAllSortedByBirthYearDesc() {
		return this.candidateService.getAllSortedByBirthYearDesc();
	}
	
	@GetMapping("/findByeMail")
	public DataResult<Candidate> findByeMail(String eMail) {
		return this.candidateService.findByeMail(eMail);
	}
	
	@GetMapping("/getAllCvs")
	public DataResult<List<CandidateDto>> getCandidateCvDto(){		
		return this.candidateService.getCandidateCvDto();
	}
	
	@GetMapping("/getCandidateCv")
	public DataResult<CandidateDto> getById(int id) {
		return this.candidateService.getById(id);
	}
	
}