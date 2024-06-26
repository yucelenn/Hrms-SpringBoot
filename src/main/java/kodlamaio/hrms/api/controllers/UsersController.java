package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class) //sistemde hata oluşursa bu metodu çağırır
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){ //oluşan hatayı method parametresi olarak geçecek
		Map<String, String> validationErrors = new HashMap<String, String>();
		for ( FieldError fieldError : exceptions.getBindingResult().getFieldErrors() ) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());//entitylerdeki NotBlank leri çalıştıracak
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;		
	}
	
	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add (@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));	
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