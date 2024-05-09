package kodlamaio.hrms.business.abstracts.storage;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.entities.concretes.cv.enums.StorageType;

public interface FileService {

	String uploadFile(MultipartFile file) throws IOException;
	StorageType getFileStorageName();
}
