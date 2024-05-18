package kodlamaio.hrms.core.adapters;

import java.io.File;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Component
@Service
@SpringBootApplication
public class CloudinaryManager implements FileService {
	
	Cloudinary cloudinary;

	public CloudinaryManager() {
	    this.cloudinary = new com.cloudinary.Cloudinary(ObjectUtils.asMap(
	                "cloud_name","xxxxxxxxxxxx",   //buraya Cloudinary dashboard'daki bilgiler girilecek.
	                "api_key","xxxxxxxxxxxxxxxxx",
	                "api_secret","xxxxxxxxxxxxxxxxxxxxxxxxxxxxx"));
	}
	
	@Override
	public String upload(File file) {
		try {
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return  (uploadResult.get("url").toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
	
	/*@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
		File file;
		try {
			file=convert(multipartFile);
			Map<String, String> result=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		    file.delete();
		    return new SuccessDataResult<>(result);
		}
		catch(IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>("Dosya yuklenmedi.");
		}	
	}
	
	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map result=cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
	    return new SuccessDataResult<>(result);
	}
	
	private File convert(MultipartFile multipartFile) throws IOException {
		File file=new File(multipartFile.getOriginalFilename());
		FileOutputStream stream=new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		return file;		
	}*/

}
