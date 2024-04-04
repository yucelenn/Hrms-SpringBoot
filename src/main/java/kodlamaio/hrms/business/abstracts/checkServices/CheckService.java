package kodlamaio.hrms.business.abstracts.checkServices;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CheckService {

	boolean checkIfRealPerson(Candidate candidate);
}
