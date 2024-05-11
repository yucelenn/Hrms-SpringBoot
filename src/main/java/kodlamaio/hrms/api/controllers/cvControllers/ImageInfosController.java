package kodlamaio.hrms.api.controllers.cvControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.cvServices.ImageInfoService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping(value = "/api/image_infos")
public class ImageInfosController {

	private ImageInfoService imageInfoService;

	@Autowired
	public ImageInfosController(ImageInfoService imageInfoService) {
		super();
		this.imageInfoService = imageInfoService;
	}
	
	@PostMapping("/uploadFile")
	public Result uploadFile(@RequestParam("file") MultipartFile file, @RequestParam int candidateId) {

		return 	imageInfoService.add(file, candidateId) ;
	}
	
}
