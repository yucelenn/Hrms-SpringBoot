package kodlamaio.hrms.business.concretes.checkManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.checkServices.CandidateCheckService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;

@Service
public class CandidateCheckManager implements CandidateCheckService{

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean checkMailIsUnique(String eMail) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean checkIdentityNumberIsUnique(String identityNumber) {
		// TODO Auto-generated method stub
		return true;
	}


}
