package kodlamaio.hrms.dataAccess.abstracts.cvDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.ExperienceInfo;

public interface ExperienceInfoDao extends JpaRepository<ExperienceInfo, Integer>{

}
