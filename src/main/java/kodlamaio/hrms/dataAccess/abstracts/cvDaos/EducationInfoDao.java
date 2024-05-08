package kodlamaio.hrms.dataAccess.abstracts.cvDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.EducationInfo;

public interface EducationInfoDao extends JpaRepository<EducationInfo, Integer> {

}
