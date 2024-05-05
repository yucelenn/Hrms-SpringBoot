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
		if (candidateDao.findByeMail(eMail) != null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkIdentityNumberIsUnique(String identityNumber) {
		if (candidateDao.getByIdentityNumber(identityNumber) != null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public Result checkInformationsFulfilled(Candidate candidate) { //validation sayesinde bu methoda gerek kalmadı.
		if (candidate.getFirstName().isEmpty()) {
			return new ErrorResult("Lütfen isminizi giriniz!");
		}
		else if (candidate.getLastName().isEmpty()) {
			return new ErrorResult("Lütfen soyisminizi giriniz!");
		}
		else if (candidate.getIdentityNumber().isEmpty()) {
			return new ErrorResult("Lütfen Tc kimlik numaranızı giriniz!");
		}
		else if (candidate.getBirthYear().isEmpty()) {
			return new ErrorResult("Lütfen doğum yılınızı giriniz!");
		}
		else if (candidate.getEMail().isEmpty()) {
			return new ErrorResult("Lütfen e postanızı giriniz!");
		}
		else if (candidate.getPassword().isEmpty()) {
			return new ErrorResult("Lütfen şifre bilgisini giriniz!");
		}
		else {
			return new SuccessResult("Bilgi girişi başarılı!");
		}
	}
	
	@Override
	public Result isValidCandidate(Candidate candidate) {
		//if (checkInformationsFulfilled(candidate).isSuccess()) { //bilgiler tam girilmişse
		// Valid-NotBlank anotasyonları sayesinde eksik bilgi girişini methodsuz tespit ediyoruz bu if'e gerek kalmadı.
			if ( !(mernisVerification.checkIfRealPerson(candidate)) ) { //mernis doğrulaması false ise
				return new ErrorResult("İş arayan eklenemedi, Bilgileriniz Mernis sistemi ile uyuşmuyor!"); 
			}
			else if ( !(this.checkMailIsUnique(candidate.getEMail()))  ) { //mail daha önce kullanılmışsa
				return new ErrorResult("İş arayan eklenemedi, Bu e posta daha önce kullanılmış!!");
			}
			else if ( !(checkIdentityNumberIsUnique(candidate.getIdentityNumber())) ) { //tc no daha önce kullanılmışsa
				return new ErrorResult("İş arayan eklenemedi, Bu Tc kimlik numarası daha önce kullanılmış!");
			}
			else {
				return new SuccessResult("İş arayan eklendi.");  //isterler sağlanıyorsa
			}
	}

}
