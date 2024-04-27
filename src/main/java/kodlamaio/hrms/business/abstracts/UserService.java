package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	DataResult<List<User>> getAll(int pageNo, int pageSize);
	DataResult<List<User>> getAllSortedByIdAsc();
	DataResult<List<User>> getAllSortedByIdDesc();
	Result add(User user);
	DataResult<User> getById(int id);
	DataResult<User> getByeMail(String eMail);
}