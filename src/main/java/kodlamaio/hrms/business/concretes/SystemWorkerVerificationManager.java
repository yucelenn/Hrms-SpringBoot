package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerVerificationService;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class SystemWorkerVerificationManager implements SystemWorkerVerificationService{

	@Override
	public boolean createEmployerSystemWorkerVerification(Employer employer) {
		return true; //sistem çalışanı iş vereni onaylar
	}

}