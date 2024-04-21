package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemWorker;

public interface SystemWorkerService {

	DataResult<List<SystemWorker>> getAll();
	DataResult<List<SystemWorker>> getAll(int pageNo, int pageSize);
	DataResult<List<SystemWorker>> getAllSortedByNameAsc();
	DataResult<List<SystemWorker>> getAllSortedByNameDesc();
	DataResult<List<SystemWorker>> getAllSortedByLastNameAsc();
	DataResult<List<SystemWorker>> getAllSortedByLastNameDesc();
	Result add(SystemWorker systemWorker);
	
	DataResult<SystemWorker> getByeMail(String eMail);
	DataResult<List<SystemWorker>> getByFirstName(String firstName);
	DataResult<List<SystemWorker>> getByLastName(String lastName);
	DataResult<List<SystemWorker>> getByFirstNameStartsWith(String firstName);
	DataResult<List<SystemWorker>> getByFirstNameContains(String firstName);
}