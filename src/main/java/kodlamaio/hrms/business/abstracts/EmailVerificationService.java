package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmailVerificationService {

	boolean createCandidateEmailVerificationCode(Candidate candidate);
	boolean createEmployerEmailVerificationCode(Employer employer);
}