package kodlamaio.hrms.business.abstracts.cvServices;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.ExperienceInfo;

public interface ExperienceInfoService {
	
	Result add (ExperienceInfo experienceInfo);
	DataResult<List<ExperienceInfo>> getAll();
	DataResult<List<ExperienceInfo>> getAllSorted();
}
