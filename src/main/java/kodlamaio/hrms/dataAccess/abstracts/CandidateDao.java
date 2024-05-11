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
	
	@Query("SELECT new kodlamaio.hrms.entities.concretes.dtos.CandidateDto(js.id, j.schoolName, j.departmantName, j.degree, j.startDate, j.endDate, je.companyName, je.role, je.startDate, je.endDate, jl.languageName,jl.languageLevel, ji.imagePath, jw.githubLink, jw.linkedinLink, jt.technology, jc.description) FROM Candidate js JOIN js.educationInfos j JOIN js.experienceInfos je JOIN js.languages jl JOIN js.imageInfos ji JOIN js.webAddress jw JOIN js.talents jt JOIN js.coverLetter jc")
	List<CandidateDto> getCandidateCvDto();
	
}