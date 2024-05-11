package kodlamaio.hrms.business.concretes.cvManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvServices.TalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvDaos.TalentDao;
import kodlamaio.hrms.entities.concretes.cv.Talent;

@Service
public class TalentManager implements TalentService {
	
	private TalentDao talentDao;

	@Autowired
	public TalentManager(TalentDao talentDao) {
		super();
		this.talentDao = talentDao;
	}

	@Override
	public Result add(Talent talent) {
		this.talentDao.save(talent);
		return new SuccessResult("Teknoloji Eklendi");
	}

	@Override
	public DataResult<List<Talent>> getAll() {
		return new SuccessDataResult<List<Talent>>(this.talentDao.findAll(),"Yetenekler listelendi");
	}

}
