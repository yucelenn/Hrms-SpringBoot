package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

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
}