package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	DataResult<List<Candidate>> getAll(int pageNo, int pageSize);
	DataResult<List<Candidate>> getAllSortedByNameAsc();
	Result add(Candidate candidate);
	DataResult<Candidate> getByIdentityNumber(String identityNumber);
	DataResult<Candidate> getByeMail(String eMail);
	DataResult<List<Candidate>> getByFirstName(String firstName);
	DataResult<List<Candidate>> getByLastName(String lastName);
	DataResult<List<Candidate>> getByBirthYear(String birthYear);
	DataResult<List<Candidate>> getByFirstNameContains(String firstName);
	DataResult<List<Candidate>> getByLastNameContains(String lastName);
	DataResult<List<Candidate>> getByFirstNameStartsWith(String firstName);
	DataResult<List<Candidate>> getByLastNameStartsWith(String lastName);
}