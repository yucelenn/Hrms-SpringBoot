package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.verifications.SystemWorkerVerification;

public interface SystemWorkerVerificationDao extends JpaRepository<SystemWorkerVerification, Integer> {

}