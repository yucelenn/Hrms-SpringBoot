package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getByeMail(String eMail);
	Employer getByCompanyName(String companyName);
	Employer getByWebAdress(String webAdress);
	Employer getByPhoneNumber(String phoneNumber);
}