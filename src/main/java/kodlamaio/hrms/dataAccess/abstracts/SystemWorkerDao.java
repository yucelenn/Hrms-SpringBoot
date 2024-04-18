package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemWorker;

public interface SystemWorkerDao extends JpaRepository<SystemWorker, Integer>{

	SystemWorker getByeMail(String eMail);
	List<SystemWorker> getByFirstName(String firstName);
	List<SystemWorker> getByLastName(String lastName);
	List<SystemWorker> getByFirstNameStartsWith(String firstName);
	List<SystemWorker> getByFirstNameContains(String firstName);
}