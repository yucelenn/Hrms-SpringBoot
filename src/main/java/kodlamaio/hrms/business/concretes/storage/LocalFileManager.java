package kodlamaio.hrms.business.concretes.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.storage.FileService;
import kodlamaio.hrms.entities.concretes.cv.enums.StorageType;

public class LocalFileManager implements FileService{

	@Override
	public String uploadFile(MultipartFile file) throws IOException {
		File convFile = new File("src/main/resources/temporaryFolder/"+file.getOriginalFilename());
		String path = convFile.getAbsolutePath();
		file.transferTo(Path.of(convFile.getAbsolutePath()));
		
		return path;
	}

	@Override
	public StorageType getFileStorageName() {
		return StorageType.Local;
	}

}
