package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailVerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public boolean createCandidateEmailVerificationCode(Candidate candidate) {
		return true;
	}

	@Override
	public boolean createEmployerEmailVerificationCode(Employer employer) {
		return true;
	}

	@Override
	public void sendCandidateVerificationEmail(String eMail) {
		createCandidateEmailVerificationCode(null); //iş arayan doğrulama kodu oluşturulacak
	}

	@Override
	public void sendEmployerVerificationEmail(String eMail) {
		createEmployerEmailVerificationCode(null); //iş veren doğrulama kodu oluşturulacak
	}

	@Override
	public boolean isVerificationSuccessful(String eMail) { //doğrulama kodu başarılı şekilde girildiyse
		return true;
	}

}