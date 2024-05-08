package kodlamaio.hrms.business.abstracts.cvServices;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.EducationInfo;

public interface EducationInfoService {

	Result add (EducationInfo educationInfo);
	DataResult<List<EducationInfo>> getAll();
	DataResult<List<EducationInfo>> getAllSorted();
}
