package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.dtos.CandidateDto;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	Candidate getByeMail(String eMail);
	Candidate getByIdentityNumber(String identityNumber);
	List<Candidate> getByFirstName(String firstName);
	List<Candidate> getByLastName(String lastName);
	List<Candidate> getByBirthYear(String birthYear);
	List<Candidate> getByFirstNameContains(String firstName);
	List<Candidate> getByLastNameContains(String lastName);
	List<Candidate> getByFirstNameStartsWith(String firstName);
	List<Candidate> getByLastNameStartsWith(String lastName);
	Candidate findByeMail(String eMail);
	//c: Candidate,  ed: EducationInfo,  ex: ExperienceInfo,  l: Language,
	//i: İmageInfo,  w: WebAddress,  t: Talent,  cl: CoverLetter
	@Query("SELECT new kodlamaio.hrms.entities.concretes.dtos.CandidateDto"
	+ "(c.id, c.firstName, c.lastName, c.identityNumber, c.birthYear, "
	+ " ed.schoolName, ed.departmantName, ed.degree, ed.startDate, ed.endDate,"
	+ " ex.companyName, ex.role, ex.startDate, ex.endDate,"
	+ " l.languageName, l.languageLevel,"
	+ " i.imagePath,"
	+ " w.githubLink, w.linkedinLink,"
	+ " t.technology,"
	+ " cl.description) "
	+ "FROM Candidate c "
	+ "JOIN c.educationInfos ed "
	+ "JOIN c.experienceInfos ex "
	+ "JOIN c.languages l "
	+ "JOIN c.imageInfos i "
	+ "JOIN c.webAddress w "
	+ "JOIN c.talents t "
	+ "JOIN c.coverLetter cl")
	List<CandidateDto> getCandidateCvDto();

	@Query("SELECT new kodlamaio.hrms.entities.concretes.dtos.CandidateDto"
	+ "(c.id, c.firstName, c.lastName, c.identityNumber, c.birthYear,"
	+ " ed.schoolName, ed.departmantName, ed.degree, ed.startDate, ed.endDate,"
	+ " ex.companyName, ex.role, ex.startDate, ex.endDate,"
	+ " l.languageName, l.languageLevel,"
	+ " i.imagePath,"
	+ " w.githubLink, w.linkedinLink,"
	+ " t.technology,"
	+ " cl.description) "
	+ "FROM Candidate c "
	+ "JOIN c.educationInfos ed "
	+ "JOIN c.experienceInfos ex "
	+ "JOIN c.languages l "
	+ "JOIN c.imageInfos i "
	+ "JOIN c.webAddress w "
	+ "JOIN c.talents t "
	+ "JOIN c.coverLetter cl where c.id = :id")
	CandidateDto getById(int id);
	
}