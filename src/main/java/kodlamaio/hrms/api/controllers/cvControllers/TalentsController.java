package kodlamaio.hrms.api.controllers.cvControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cvServices.TalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Talent;

@RestController
@RequestMapping(value = "/api/talents")
public class TalentsController {

	private TalentService talentService;

	@Autowired
	public TalentsController(TalentService talentService) {
		super();
		this.talentService = talentService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Talent talent) {
		return this.talentService.add(talent);	
    }
	
	@GetMapping("/getAll")
	public DataResult<List<Talent>> getAll(){
		return this.talentService.getAll();
	}
	
}
