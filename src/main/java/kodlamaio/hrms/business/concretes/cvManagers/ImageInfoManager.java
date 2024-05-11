package kodlamaio.hrms.business.concretes.cvManagers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.cvServices.ImageInfoService;
import kodlamaio.hrms.business.abstracts.storage.FileService;
import kodlamaio.hrms.business.concretes.storage.FileOperations;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.cvDaos.ImageInfoDao;
import kodlamaio.hrms.entities.concretes.cv.ImageInfo;

@Service
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

	@Override
	public Result add(MultipartFile file, int candidateId) {
		ImageInfo imageInfo = new ImageInfo();
		
		try {
			String filePath= fileService.uploadFile(file);
			imageInfo.setCandidate(candidateDao.findById(candidateId).orElseThrow(null));
			imageInfo.setImageName(FileOperations.getFileName(file));
			imageInfo.setStorageName(fileService.getFileStorageName());
			imageInfo.setImagePath(filePath);	
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
		imageInfoDao.save(imageInfo);	
		return new SuccessResult("Profil resminiz başarılı bir şekilde kaydedildi.");
	}

}
