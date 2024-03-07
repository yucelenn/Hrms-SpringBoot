package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
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
	List<Candidate> getAll(){
		return this.candidateService.getAll();
	}
}
