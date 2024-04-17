package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	// getBy kalıbı hepsine uygulanır.
	Job getByJobTitle(String jobTitle); //İsimlendirme çok önemli Jpa'dan hazır almak için dikkat et
}