package kodlamaio.hrms.business.abstracts.validationServices;

public interface MailValidationService extends ValidationService {

	void sendValidationMail(String eMail);
	boolean validateMail(String eMail);
}
