package kodlamaio.hrms.dataAccess.abstracts.cvDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Talent;

public interface TalentDao extends JpaRepository<Talent, Integer>{

}
