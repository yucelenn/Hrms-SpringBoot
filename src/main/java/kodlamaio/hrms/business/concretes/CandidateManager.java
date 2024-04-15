package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}