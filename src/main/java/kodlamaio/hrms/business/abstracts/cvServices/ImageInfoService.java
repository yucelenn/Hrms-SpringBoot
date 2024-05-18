package kodlamaio.hrms.business.abstracts.cvServices;

import java.io.IOException;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.ImageInfo;

public interface ImageInfoService {

	//DataResult<Map<String, String>> add(MultipartFile multipartFile, int candidateId);
	Result add(int resumeId, String path) throws IOException;
	DataResult<ImageInfo> getById(int id);
	DataResult<List<ImageInfo>> getAll();
	DataResult<List<ImageInfo>> getByCandidateId(int id);
	//Result add(MultipartFile multipartFile,int id);
}
