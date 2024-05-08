package kodlamaio.hrms.business.abstracts.cvServices;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.CoverLetter;

public interface CoverLetterService {
	
	Result add(CoverLetter coverLetter);
	DataResult<List<CoverLetter>> getAll();
}
