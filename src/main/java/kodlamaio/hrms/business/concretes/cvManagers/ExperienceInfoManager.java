package kodlamaio.hrms.business.concretes.cvManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvServices.ExperienceInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvDaos.ExperienceInfoDao;
import kodlamaio.hrms.entities.concretes.cv.ExperienceInfo;

@Service
public class ExperienceInfoManager implements ExperienceInfoService {

	private ExperienceInfoDao dao;
	
	@Autowired
	public ExperienceInfoManager(ExperienceInfoDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Result add(ExperienceInfo experienceInfo) {
		this.dao.save(experienceInfo);
		return new SuccessResult("İş deneyimi kaydedildi.");
	}

	@Override
	public DataResult<List<ExperienceInfo>> getAll() {
		return new SuccessDataResult<List<ExperienceInfo>>(this.dao.findAll(), "İş deneyimi bilgileri listelendi:");
	}

	@Override
	public DataResult<List<ExperienceInfo>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"endDate");
		return new SuccessDataResult<List<ExperienceInfo>>(this.dao.findAll(sort), 
				"İş deneyimi bilgileri yeniden eskiye listelendi:");
	}

}
