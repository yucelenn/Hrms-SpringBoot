package kodlamaio.hrms.business.concretes.cvManagers;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvServices.ImageInfoService;
import kodlamaio.hrms.core.adapters.FileService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.cvDaos.ImageInfoDao;
import kodlamaio.hrms.entities.concretes.cv.ImageInfo;
import kodlamaio.hrms.entities.concretes.cv.enums.StorageType;

@Component
@Service
@SpringBootApplication
public class ImageInfoManager implements ImageInfoService{

	private ImageInfoDao imageInfoDao;
	private FileService fileService;
	private CandidateDao candidateDao;
	
	@Autowired
	public ImageInfoManager(ImageInfoDao imageInfoDao, FileService fileService, CandidateDao candidateDao) {
		super();
		this.imageInfoDao = imageInfoDao;
		this.fileService = fileService;
		this.candidateDao = candidateDao;
	}

	@Override                                     // dosya yolu ile ekleme
	public Result add(int resumeId, String path) {// path: yüklenecek fotonun dosya yolu
		File file= (new File(path));// dosya yolu verilen foto cloudinary'e yüklenecek upload metodu ile
		String link=fileService.upload(file);// link: cloudinary yüklenen fotonun linki
		ImageInfo imageInfo = new ImageInfo(
				resumeId, 
				candidateDao.findById(resumeId).get().getFirstName()+candidateDao.findById(resumeId).get().getLastName(), 
				link, 
				StorageType.Cloudinary, 
				candidateDao.findById(resumeId).get());
		imageInfoDao.save(imageInfo);
		candidateDao.save(candidateDao.findById(resumeId).get());			
		return new SuccessResult("Foto yüklendi.Link: "+ link);
	}
	
	@Override
	public DataResult<ImageInfo> getById(int id) {
		return new SuccessDataResult<ImageInfo>(this.imageInfoDao.findById(id).get(),"resim:");
	}
	
	@Override
	public DataResult<List<ImageInfo>> getAll() {
		return new SuccessDataResult<List<ImageInfo>>(this.imageInfoDao.findAll(),"listelendi");
	}
	
	@Override
	public DataResult<List<ImageInfo>> getByCandidateId(int id) {
		return new SuccessDataResult<List<ImageInfo>>(this.imageInfoDao.getByCandidate_Id(id));
	}
	
}
