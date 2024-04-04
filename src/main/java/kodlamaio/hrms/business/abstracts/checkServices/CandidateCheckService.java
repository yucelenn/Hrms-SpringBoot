package kodlamaio.hrms.business.abstracts.checkServices;

public interface CandidateCheckService extends CheckService{

	boolean checkIdentityNumberIsUnique(String identityNumber);
}
