package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.checkServices.CheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService, CheckService {

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
		if (this.checkMailIsUnique(user.getEMail())) {
			this.userDao.save(user);  //JPA dan
			return new SuccessDataResult<User>(user, "Kullanıcı eklendi.");
		} else {
			return new ErrorResult("Kullanıcı eklenemedi, bu e posta daha önce kullanılmış!");
		}
	}

	@Override
	public DataResult<User> getByeMail(String eMail) {
		if (this.userDao.getByeMail(eMail) == null) {
			return new ErrorDataResult<User>("Kullanıcı bulunamadı.");
		} else {
			return new SuccessDataResult<User>(this.userDao.getByeMail(eMail), "Kullanıcı data'sı listelendi.");
		}
	}

	@Override
	public DataResult<List<User>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); //sayfalama için
		return new SuccessDataResult<List<User>>(this.userDao.findAll(pageable).getContent(), 
				"Sayfalama ile kullanıcı data'ları listelendi.");
	}

	@Override
	public boolean checkMailIsUnique(String eMail) {
		if (this.getByeMail(eMail).isSuccess()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public DataResult<List<User>> getAllSortedByIdAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "id");
		return new SuccessDataResult<List<User>>(this.userDao.findAll(sort), 
				"Id'ye göre sıralama ile kullanıcılar listelendi.");
	}
	
}