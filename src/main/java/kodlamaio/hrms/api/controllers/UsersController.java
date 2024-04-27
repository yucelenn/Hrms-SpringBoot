package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;
	
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);	
	}
	
	@GetMapping("/getByeMail")
	public DataResult<User> getByeMail(@RequestParam String eMail) {
		return this.userService.getByeMail(eMail);
	}
	
	@GetMapping("/getAllPageable")
	public DataResult<List<User>> getAll(int pageNo, int pageSize) {
		return this.userService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSortedByIdAsc")
	public DataResult<List<User>> getAllSortedByIdAsc() {
		return this.userService.getAllSortedByIdAsc();
	}
	
	@GetMapping("/getAllSortedByIdDesc")
	public DataResult<List<User>> getAllSortedByIdDesc() {
		return this.userService.getAllSortedByIdDesc();
	}
	
	@GetMapping("/getById")
	public DataResult<User> getById(int id){
		return this.userService.getById(id);
	}
}