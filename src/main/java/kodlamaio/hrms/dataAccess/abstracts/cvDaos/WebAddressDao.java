package kodlamaio.hrms.dataAccess.abstracts.cvDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.WebAddress;

public interface WebAddressDao extends JpaRepository<WebAddress, Integer>{

}
