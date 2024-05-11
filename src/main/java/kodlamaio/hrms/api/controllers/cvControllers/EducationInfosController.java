package kodlamaio.hrms.api.controllers.cvControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cvServices.EducationInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.EducationInfo;

@RestController
@RequestMapping(value = "/api/education_infos")
public class EducationInfosController {

	private EducationInfoService educationInfoService;

	@Autowired
	public EducationInfosController(EducationInfoService educationInfoService) {
		super();
		this.educationInfoService = educationInfoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationInfo educationInfo) {
		return this.educationInfoService.add(educationInfo);	
    }
	
	@GetMapping("/getAll")
	public DataResult<List<EducationInfo>> getAll(){
		return this.educationInfoService.getAll();
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<EducationInfo>> getAllSorted(){
		return this.educationInfoService.getAllSorted();
	}
	
}
