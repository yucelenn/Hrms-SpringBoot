package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.verifications.EmployerSystemWorkerVerification;

public interface EmployerSystemWorkerVerificationDao extends JpaRepository<EmployerSystemWorkerVerification, Integer> {

}