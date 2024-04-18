package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemWorker;

public interface SystemWorkerService {

	DataResult<List<SystemWorker>> getAll();
	Result add(SystemWorker systemWorker);
	
	DataResult<SystemWorker> getByeMail(String eMail);
	DataResult<List<SystemWorker>> getByFirstName(String firstName);
	DataResult<List<SystemWorker>> getByLastName(String lastName);
	DataResult<List<SystemWorker>> getByFirstNameStartsWith(String firstName);
}