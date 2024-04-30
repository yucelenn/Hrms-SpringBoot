package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("SELECT new kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto(j.freePositionAmount, j.startDate, j.endDate, p.jobTitle, e.companyName) FROM JobAdvertisement j JOIN j.job p JOIN j.employer e WHERE j.status = true AND e.companyName = :companyName")
	List<JobAdvertisementDto> getByCompanyName(String companyName);
	
	@Query("SELECT NEW kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto(j.freePositionAmount, j.startDate, j.endDate, p.jobTitle, e.companyName) FROM JobAdvertisement j JOIN j.job p JOIN j.employer e WHERE j.status = true ORDER BY j.endDate ASC")
    List<JobAdvertisementDto> getAllOrderByEndDateAsc();
	
	@Query("SELECT NEW kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto(j.freePositionAmount, j.startDate, j.endDate, p.jobTitle, e.companyName) FROM JobAdvertisement j JOIN j.job p JOIN j.employer e WHERE j.status = true ORDER BY j.endDate DESC")
    List<JobAdvertisementDto> getAllOrderByEndDateDesc();
	
	@Query("SELECT new kodlamaio.hrms.entities.concretes.dtos.JobAdvertisementDto(j.freePositionAmount, j.startDate, j.endDate, p.jobTitle, e.companyName) FROM JobAdvertisement j JOIN j.job p JOIN j.employer e WHERE j.status = true")
	List<JobAdvertisementDto> getJobAdvertisementDtoByStatusTrue();
	
	@Modifying
	@Query("Update JobAdvertisement j set status = false where j.id = :id")
	void updateJobAdvertisementStatus(int id);
}