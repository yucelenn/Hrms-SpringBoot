package kodlamaio.hrms.dataAccess.abstracts.cvDaos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import kodlamaio.hrms.entities.concretes.cv.ImageInfo;

public interface ImageInfoDao extends JpaRepository<ImageInfo, Integer> {
	
	List<ImageInfo> getByCandidate_Id(int id);
	
}
