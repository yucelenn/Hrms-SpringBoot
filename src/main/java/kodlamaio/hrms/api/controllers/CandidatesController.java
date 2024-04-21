package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	public CandidateService candidateService;
	
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);		
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
}