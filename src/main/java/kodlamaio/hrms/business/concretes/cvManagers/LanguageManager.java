package kodlamaio.hrms.business.concretes.cvManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvServices.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvDaos.LanguageDao;
import kodlamaio.hrms.entities.concretes.cv.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao dao;
	
	@Autowired
	public LanguageManager(LanguageDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Result add(Language language) {
		this.dao.save(language);
		return new SuccessResult("Dil bilgisi eklendi.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.dao.findAll(), "Bilinen diller listelendi:");
	}

}
