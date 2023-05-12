package ibf2022.batch2.csf.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);


	// TODO: Task 2, Task 3, Task 4
	@PostMapping(path="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> upload(
		@RequestPart MultipartFile zipfile,
		@RequestPart String name,
		@RequestPart String title,
		@RequestPart String comments
	) {
		logger.info(">>>>>springboot backend called");

		//task 3 
		
		return null;
	}
	

	// TODO: Task 5
	

	// TODO: Task 6

}
