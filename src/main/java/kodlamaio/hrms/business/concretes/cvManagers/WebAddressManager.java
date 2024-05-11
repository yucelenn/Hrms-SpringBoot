package kodlamaio.hrms.business.concretes.cvManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cvServices.WebAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.cvDaos.WebAddressDao;
import kodlamaio.hrms.entities.concretes.cv.WebAddress;

@Service
public class WebAddressManager implements WebAddressService{

	private WebAddressDao addressDao;

	@Autowired
	public WebAddressManager(WebAddressDao addressDao) {
		super();
		this.addressDao = addressDao;
	}

	@Override
	public Result add(WebAddress webAddress) {
		this.addressDao.save(webAddress);
		return new SuccessResult("Web adresi eklendi.");
	}

	@Override
	public DataResult<List<WebAddress>> getAll() {
		return new SuccessDataResult<List<WebAddress>>(this.addressDao.findAll(), "Web adresleri listelendi.");
	}
		
}
