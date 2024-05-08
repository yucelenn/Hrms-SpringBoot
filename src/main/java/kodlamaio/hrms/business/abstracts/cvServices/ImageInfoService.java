package kodlamaio.hrms.business.abstracts.cvServices;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.Result;

public interface ImageInfoService {

	Result add(MultipartFile file,int candidateId);
}
