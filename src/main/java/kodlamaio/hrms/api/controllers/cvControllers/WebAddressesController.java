package kodlamaio.hrms.api.controllers.cvControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cvServices.WebAddressService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.WebAddress;

@RestController
@RequestMapping(value = "/api/web_addresses")
public class WebAddressesController {

	private WebAddressService addressService;

	@Autowired
	public WebAddressesController(WebAddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WebAddress webAddress) {
		return this.addressService.add(webAddress);	
    }
	
	@GetMapping("/getAll")
	public DataResult<List<WebAddress>> getAll(){
		return this.addressService.getAll();
	}
	
}
