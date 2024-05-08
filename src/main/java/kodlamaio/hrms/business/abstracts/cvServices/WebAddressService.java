package kodlamaio.hrms.business.abstracts.cvServices;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.WebAddress;

public interface WebAddressService {

	Result add (WebAddress webAddress);
	DataResult<List<WebAddress>> getAll();
}
