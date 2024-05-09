package kodlamaio.hrms.business.concretes.cvManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvServices.EducationInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvDaos.EducationInfoDao;
import kodlamaio.hrms.entities.concretes.cv.EducationInfo;

@Service
public class EducationInfoManager implements EducationInfoService {

	private EducationInfoDao dao;
	
	@Autowired
	public EducationInfoManager(EducationInfoDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Result add(EducationInfo educationInfo) {
		this.dao.save(educationInfo);
		return new SuccessResult("Okul bilgileri eklendi.");
	}

	@Override
	public DataResult<List<EducationInfo>> getAll() {
		return new SuccessDataResult<List<EducationInfo>>(this.dao.findAll(), "Okul bilgileri listelendi:");
	}

	@Override
	public DataResult<List<EducationInfo>> getAllSorted() { //okul bilgilerini yeniden eskiye sırala
		Sort sort = Sort.by(Sort.Direction.DESC,"endDate");
		return new SuccessDataResult<List<EducationInfo>>(this.dao.findAll(sort), "Okul bilgileri yeniden eskiye listelendi:");
	}

}
