package kodlamaio.hrms.core.adapters;

import java.io.File;

public interface FileService {

	 String upload(File file);//dosya yolu ile
	// DataResult<Map<String, String>> upload(MultipartFile multipartFile);//sürükle bırak ile
	// DataResult<Map> delete(String id) throws IOException;
	 
}
