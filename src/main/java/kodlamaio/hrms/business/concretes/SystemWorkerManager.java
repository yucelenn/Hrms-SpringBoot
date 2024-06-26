package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
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
		return new SuccessResult("Sistem çalışanı eklendi.");
	}

	@Override
	public DataResult<SystemWorker> getByeMail(String eMail) {
		if (this.systemWorkerDao.getByeMail(eMail) == null) {
			return new ErrorDataResult<>("Sistem çalışanı bulunamadı.");
		} else {
			return new SuccessDataResult<SystemWorker>(this.systemWorkerDao.getByeMail(eMail), "Sistem çalışanı data'sı listelendi.");
		}
	}

	@Override
	public DataResult<List<SystemWorker>> getByFirstName(String firstName) {
		if (this.systemWorkerDao.getByFirstName(firstName).isEmpty()) {
			return new ErrorDataResult<>("Sistem çalışanı bulunamadı.");
		} else {
			return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.getByFirstName(firstName),
					"Sistem çalışanı data'ları listelendi.");		
		}
	}

	@Override
	public DataResult<List<SystemWorker>> getByLastName(String lastName) {
		if (this.systemWorkerDao.getByLastName(lastName).isEmpty()) {
			return new ErrorDataResult<>("Sistem çalışanı bulunamadı.");
		} else {
			return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.getByLastName(lastName),
					"Sistem çalışanı data'ları listelendi.");		
		}
	}

	@Override
	public DataResult<List<SystemWorker>> getByFirstNameStartsWith(String firstName) {
		if (this.systemWorkerDao.getByFirstNameStartsWith(firstName).isEmpty()) {
			return new ErrorDataResult<>("Sistem çalışanı bulunamadı.");
		} else {
			return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.getByFirstNameStartsWith(firstName),
					"Sistem çalışanı data'ları listelendi.");		
		}
	}

	@Override
	public DataResult<List<SystemWorker>> getByFirstNameContains(String firstName) {
		if (this.systemWorkerDao.getByFirstNameContains(firstName).isEmpty()) {
			return new ErrorDataResult<>("Sistem çalışanı bulunamadı.");
		} else {
			return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.getByFirstNameContains(firstName),
					"Sistem çalışanı data'ları listelendi.");		
		}
	}

	@Override
	public DataResult<List<SystemWorker>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); //sayfalama için
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(pageable).getContent(), 
				"Sayfalama ile sistem çalışanı data'ları listelendi.");
	}

	@Override
	public DataResult<List<SystemWorker>> getAllSortedByNameAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(sort), 
				"Alfabetik isim sıralama ile sistem çalışanı data'ları listelendi.");
	}

	@Override
	public DataResult<List<SystemWorker>> getAllSortedByNameDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "firstName");
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(sort), 
				"Ters alfabetik isim sıralama ile sistem çalışanı data'ları listelendi.");
	}
	
	@Override
	public DataResult<List<SystemWorker>> getAllSortedByLastNameAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "lastName");
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(sort), 
				"Alfabetik soyisim sıralama ile sistem çalışanı data'ları listelendi.");
	}

	@Override
	public DataResult<List<SystemWorker>> getAllSortedByLastNameDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "lastName");
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(sort), 
				"Ters alfabetik soyisim sıralama ile sistem çalışanı data'ları listelendi.");
	}

}