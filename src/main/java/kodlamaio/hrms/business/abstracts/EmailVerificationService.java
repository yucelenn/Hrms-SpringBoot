package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmailVerificationService {

	boolean createCandidateEmailVerificationCode(Candidate candidate);
	boolean createEmployerEmailVerificationCode(Employer employer);
	void sendCandidateVerificationEmail(String eMail);
	void sendEmployerVerificationEmail(String eMail);
	boolean isVerificationSuccessful(String eMail);
}