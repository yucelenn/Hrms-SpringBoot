package kodlamaio.hrms.dataAccess.abstracts.cvDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
