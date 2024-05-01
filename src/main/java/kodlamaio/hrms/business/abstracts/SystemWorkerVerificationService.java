package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface SystemWorkerVerificationService {

	boolean createEmployerSystemWorkerVerification(Employer employer);
}
