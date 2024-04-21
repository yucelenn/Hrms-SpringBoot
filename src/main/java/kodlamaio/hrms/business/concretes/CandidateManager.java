package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.checkServices.CandidateCheckService;
import kodlamaio.hrms.business.abstracts.validationServices.MailValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateCheckService checkService;
	private MailValidationService validationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateCheckService checkService, MailValidationService validationService) {
		super();
		this.candidateDao = candidateDao;
		this.checkService = checkService;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if ( checkService.isValidCandidate(candidate).isSuccess() ) {
			validationService.sendValidationMail(candidate.getEMail()); // doğrulama için e posta gönder
			if (validationService.validateMail(candidate.getEMail())) {
				this.candidateDao.save(candidate);
				return checkService.isValidCandidate(candidate);
			}
			else {
				return new ErrorResult("İş arayan eklenemedi, Eposta ile doğrulama gerekiyor!");
			}		
		}
		else {
			return checkService.isValidCandidate(candidate);
		}
	}

	@Override
	public DataResult<Candidate> getByeMail(String eMail) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getByeMail(eMail), "İş arayan data'sı listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getByFirstName(String firstName) {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getByFirstName(firstName), "İş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getByLastName(String lastName) {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getByLastName(lastName), "İş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber), "İş arayan data'sı listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getByBirthYear(String birthYear) {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getByBirthYear(birthYear), "İş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getByFirstNameContains(String firstName) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getByFirstNameContains(firstName), "İş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getByLastNameContains(String lastName) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getByLastNameContains(lastName), "İş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getByFirstNameStartsWith(String firstName) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getByFirstNameStartsWith(firstName), "İş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getByLastNameStartsWith(String lastName) {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.getByLastNameStartsWith(lastName), "İş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); //sayfalama için
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(pageable).getContent(), 
				"Sayfalama ile iş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getAllSortedByNameAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(sort), 
				"Alfabetik isim sıralama ile iş arayan data'ları listelendi.");
	}

	@Override
	public DataResult<List<Candidate>> getAllSortedByNameDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(sort), 
				"Ters alfabetik isim sıralama ile iş arayan data'ları listelendi.");
	}

}