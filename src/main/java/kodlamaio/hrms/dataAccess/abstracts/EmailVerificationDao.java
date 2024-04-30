package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.verifications.EmailVerification;

public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer> {

}