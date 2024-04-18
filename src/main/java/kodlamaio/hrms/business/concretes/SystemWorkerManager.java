package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemWorkerDao;
import kodlamaio.hrms.entities.concretes.SystemWorker;

@Service
public class SystemWorkerManager implements SystemWorkerService{

	private SystemWorkerDao systemWorkerDao;
	
	@Autowired
	public SystemWorkerManager(SystemWorkerDao systemWorkerDao) {
		super();
		this.systemWorkerDao = systemWorkerDao;
	}

	@Override
	public DataResult<List<SystemWorker>> getAll() {
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(SystemWorker systemWorker) {
		this.systemWorkerDao.save(systemWorker);
		return new SuccessResult("Sistem personeli eklendi.");
	}

	@Override
	public DataResult<SystemWorker> getByeMail(String eMail) {
		
		return new SuccessDataResult<SystemWorker>(this.systemWorkerDao.getByeMail(eMail),
				"Sistem çalışanı data'sı listelendi.");
	}

	@Override
	public DataResult<List<SystemWorker>> getByFirstName(String firstName) {
		
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.getByFirstName(firstName),
				"Sistem çalışanı data'ları listelendi.");
	}

	@Override
	public DataResult<List<SystemWorker>> getByLastName(String lastName) {
		
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.getByLastName(lastName),
				"Sistem çalışanı data'ları listelendi.");
	}

	@Override
	public DataResult<List<SystemWorker>> getByFirstNameStartsWith(String firstName) {
		
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.getByFirstNameStartsWith(firstName),
				"Sistem çalışanı data'ları listelendi.");
	}

}