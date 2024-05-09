package kodlamaio.hrms.business.concretes.storage;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileOperations {
	
	public static String getFileNameWithExtension(MultipartFile file) {
		String fileNameWithExtension = file.getOriginalFilename();
		return fileNameWithExtension;
	}
	
	public static String getFileName(MultipartFile file) {
		int fileIndex = getFileNameWithExtension(file).lastIndexOf(".");
		String fileName = getFileNameWithExtension(file).substring(0,fileIndex);
		return fileName;
	}
	
	public static byte[] getFileBytes(MultipartFile file) {
		byte[] fileBytes;
		try {
			fileBytes = file.getBytes();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return fileBytes;
	}
	
}
