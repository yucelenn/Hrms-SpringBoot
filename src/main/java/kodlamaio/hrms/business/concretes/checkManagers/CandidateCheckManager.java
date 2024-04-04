package kodlamaio.hrms.business.concretes.checkManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.checkServices.CandidateCheckService;
import kodlamaio.hrms.core.adapters.MernisVerification;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{

	private CandidateDao candidateDao;
	private MernisVerification mernisVerification;
	
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao, MernisVerification mernisVerification) {
		super();
		this.candidateDao = candidateDao;
		this.mernisVerification = mernisVerification;
	}

	@Override
	public boolean checkMailIsUnique(String eMail) {
		// bu metodu jpa ile doldur
		return true;
	}

	@Override
	public boolean checkIdentityNumberIsUnique(String identityNumber) {
		// bu metodu jpa ile doldur
		return true;
	}

	@Override
	public Result isValidCandidate(Candidate candidate) {
		if ( !(mernisVerification.checkIfRealPerson(candidate)) ) { //mernis doğrulaması false ise
			return new ErrorResult("İş arayan eklenemedi, Bilgileriniz Mernis sistemi ile uyuşmuyor!"); 
		}
		else if ( !(checkMailIsUnique(candidate.getEMail())) ) { //mail daha önce kullanılmışsa
			return new ErrorResult("İş arayan eklenemedi, Bu e posta daha önce kullanılmış!");
		}
		else if ( !(checkIdentityNumberIsUnique(candidate.getIdentityNumber())) ) { //tc no daha önce kullanılmışsa
			return new ErrorResult("İş arayan eklenemedi, Bu Tc kimlik numarası daha önce kullanılmış!");
		}
		else {
			return new SuccessResult("İş arayan eklendi.");  //isterler sağlanıyorsa
		}
	}

}
