package kodlamaio.hrms.api.controllers.cvControllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cvServices.ImageInfoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.ImageInfo;

@RestController
@RequestMapping(value = "/api/image_infos")
public class ImageInfosController {

	private ImageInfoService imageInfoService;

	@Autowired
	public ImageInfosController(ImageInfoService imageInfoService) {
		super();
		this.imageInfoService = imageInfoService;
	}
	
	@PostMapping("/uploadFile")//path'e dosya lokasyonunu gir.örnek: "C:/Users/userDesktop/Candidate.png"
	public Result add(@RequestParam String path, @RequestParam int resumeId) throws IOException {
		return this.imageInfoService.add(resumeId,path);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ImageInfo>> getAll(){
		  return this.imageInfoService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public DataResult<ImageInfo> getById(@PathVariable int id){
		  return this.imageInfoService.getById(id);
	}
	
	@GetMapping("/getbyuserid/{id}")
	public DataResult<List<ImageInfo>> getByCandidateId(@PathVariable int id){
		  return this.imageInfoService.getByCandidateId(id);
	}
	
	/*@PostMapping("/add")
	public Result add(@RequestBody MultipartFile  image,@RequestParam("id")int id){
		  return this.imageInfoService.add(image, id);
	}*/
	
}
