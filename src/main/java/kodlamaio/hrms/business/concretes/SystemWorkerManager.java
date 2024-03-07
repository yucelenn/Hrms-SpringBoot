package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.dataAccess.abstracts.SystemWorkerDao;
import kodlamaio.hrms.entities.concretes.SystemWorker;

@Service
public class SystemWorkerManager implements SystemWorkerService{

	private SystemWorkerDao systemWorkerDao;
	
	public SystemWorkerManager(SystemWorkerDao systemWorkerDao) {
		super();
		this.systemWorkerDao = systemWorkerDao;
	}

	@Override
	public List<SystemWorker> getAll() {
		return systemWorkerDao.findAll();
	}

}
