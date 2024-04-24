package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.checkServices.EmployerCheckService;
import kodlamaio.hrms.business.abstracts.validationServices.MailValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerCheckService checkService;
	private MailValidationService validationService; 
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService checkService, MailValidationService validationService) {
		super();
		this.employerDao = employerDao;
		this.checkService = checkService;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if ( checkService.isValidEmployer(employer).isSuccess() ) {
			validationService.sendValidationMail(employer.getEMail()); //doğrulama maili gönder
			if ( validationService.validateMail(employer.getEMail()) ) {
				this.employerDao.save(employer);
				return checkService.isValidEmployer(employer);
			}
			else {
				return new ErrorResult("İş veren eklenemedi, Eposta ile doğrulama gerekiyor!");
			}
		}
		else {
			return checkService.isValidEmployer(employer);
		}
	}

	@Override
	public DataResult<Employer> getByeMail(String eMail) {
		if (this.employerDao.getByeMail(eMail) != null) {
			return new SuccessDataResult<Employer>(this.employerDao.getByeMail(eMail), "İş veren data'sı listelendi.");
		}
		else {
			return new ErrorDataResult<Employer>(this.employerDao.getByeMail(eMail), "İş veren bulunamadı.");
		}
	}

	@Override
	public DataResult<Employer> getByCompanyName(String companyName) {
		
		return new SuccessDataResult<Employer>(this.employerDao.getByCompanyName(companyName), "İş veren data'sı listelendi.");
	}

	@Override
	public DataResult<Employer> getByWebAdress(String webAdress) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Employer>(this.employerDao.getByWebAdress(webAdress), "İş veren data'sı listelendi.");
	}

	@Override
	public DataResult<Employer> getByPhoneNumber(String phoneNumber) {
		
		return new SuccessDataResult<Employer>(this.employerDao.getByPhoneNumber(phoneNumber), "İş veren data'sı listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getByCompanyNameStartsWith(String companyName) {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByCompanyNameStartsWith(companyName), "İş veren data'ları listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getByCompanyNameContains(String companyName) {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.getByCompanyNameContains(companyName), "İş veren data'ları listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); //sayfalama için
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(pageable).getContent(), 
				"Sayfalama ile kullanıcı data'ları listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getAllSortedByCompanyNameAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "companyName");
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(sort), 
				"Alfabetik isim sıralama ile iş veren data'ları listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getAllSortedByCompanyNameDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "companyName");
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(sort), 
				"Ters alfabetik isim sıralama ile iş veren data'ları listelendi.");
	}

}