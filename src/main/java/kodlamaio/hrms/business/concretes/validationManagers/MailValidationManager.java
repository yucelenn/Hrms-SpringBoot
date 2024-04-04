package kodlamaio.hrms.business.concretes.validationManagers;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.validationServices.MailValidationService;

@Service
public class MailValidationManager implements MailValidationService{

	@Override
	public void sendValidationMail(String eMail) {
		// doğrulama e maili simülasyonu
		
	}
	
	@Override
	public boolean validateMail(String eMail) {
		// doğrulama e mailine tıklandı simülasyonu
		return true;
	}

}
