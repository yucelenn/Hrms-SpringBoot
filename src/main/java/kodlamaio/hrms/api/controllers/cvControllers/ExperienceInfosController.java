package kodlamaio.hrms.api.controllers.cvControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cvServices.ExperienceInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.ExperienceInfo;

@RestController
@RequestMapping(value = "/api/experience_infos")
public class ExperienceInfosController {

	private ExperienceInfoService experienceInfoService;

	@Autowired
	public ExperienceInfosController(ExperienceInfoService experienceInfoService) {
		super();
		this.experienceInfoService = experienceInfoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ExperienceInfo experienceInfo) {
		return this.experienceInfoService.add(experienceInfo);	
    }
	
	@GetMapping("/getAll")
	public DataResult<List<ExperienceInfo>> getAll(){
		return this.experienceInfoService.getAll();
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<ExperienceInfo>> getAllSorted(){
		return this.experienceInfoService.getAllSorted();
	}
	
}
