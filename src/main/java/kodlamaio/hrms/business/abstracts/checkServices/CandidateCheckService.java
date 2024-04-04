package kodlamaio.hrms.business.abstracts.checkServices;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService extends CheckService{

	boolean checkIdentityNumberIsUnique(String identityNumber);
	Result isValidCandidate(Candidate candidate);
}
