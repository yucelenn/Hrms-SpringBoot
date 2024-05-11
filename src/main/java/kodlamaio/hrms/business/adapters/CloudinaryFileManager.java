package kodlamaio.hrms.business.adapters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.business.abstracts.storage.FileService;
import kodlamaio.hrms.business.concretes.storage.FileOperations;
import kodlamaio.hrms.entities.concretes.cv.enums.StorageType;

@Service
public class CloudinaryFileManager implements FileService {

	@Autowired
	private Environment environment;
	
	@Override
	public String uploadFile(MultipartFile file) {
		Map<String, String> config = new HashMap<String, String>();
        config.put("cloud_name", environment.getProperty("cloudinary.cloud_name"));
        config.put("api_key", environment.getProperty("cloudinary.api_key"));
        config.put("api_secret", environment.getProperty("cloudinary.api_secret"));
        Cloudinary cloudinary = new Cloudinary(config);
        
        String fileNameWithExtension = FileOperations.getFileNameWithExtension(file);
        String fileName = FileOperations.getFileName(file);
        byte[] fileBytes = FileOperations.getFileBytes(file);
        String filePath = environment.getProperty("cloudinary.file_folder_name") + fileName;
        
        Object imageVersion = "";
        
        try {
            imageVersion = cloudinary.uploader().upload(fileBytes, ObjectUtils.asMap( "public_id", filePath));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        String fileFullPath = cloudinary.url().generate(FileOperations.getFileNameWithExtension(file));
        return fileFullPath;
	}

	@Override
	public StorageType getFileStorageName() {
		return StorageType.Cloudinary;
	}

}
