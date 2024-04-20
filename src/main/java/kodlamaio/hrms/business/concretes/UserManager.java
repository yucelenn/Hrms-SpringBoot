package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao; 
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
	
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data listelendi.");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);  //JPA dan
		return new SuccessResult("Kullanıcı eklendi.");
	}

	@Override
	public DataResult<User> getByeMail(String eMail) {
		
		return new SuccessDataResult<User>(this.userDao.getByeMail(eMail), "Kullanıcı data'sı listelendi.");
	}

	@Override
	public DataResult<List<User>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); //sayfalama için
		return new SuccessDataResult<List<User>>(this.userDao.findAll(pageable).getContent(), 
				"Sayfalama ile kullanıcı data'ları listelendi.");
	}

}