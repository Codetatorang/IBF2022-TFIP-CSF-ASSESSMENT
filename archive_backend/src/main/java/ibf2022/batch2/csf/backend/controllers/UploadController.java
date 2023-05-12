package ibf2022.batch2.csf.backend.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ibf2022.batch2.csf.backend.repositories.ImageRepository;

@Controller
public class UploadController {
	@Autowired
	ImageRepository imgRepo;

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	// TODO: Task 2, Task 3, Task 4
	@PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> upload(
			@RequestPart MultipartFile zipfile,
			@RequestPart String name,
			@RequestPart String title,
			@RequestPart String comments) throws FileNotFoundException{

		// task 3
		try {
			
			//add upload repo here

			imgRepo.upload(zipfile);
		}catch(IOException ex){
			ex.printStackTrace();
		}
			
			


			// String stringZipFile = new String(zipfile.getBytes());

			// byte[] buffer = new byte[1024];

			// //!TODO: file not found exception
			// ZipInputStream zis = new ZipInputStream(new FileInputStream(stringZipFile));

			// ZipEntry zipEntry = zis.getNextEntry();

			// while (zipEntry != null) {
			// 	// extract files and send to s3
			// 	File newFile = new File(zipEntry.getName());
			// 	FileOutputStream fos = new FileOutputStream(newFile);
			// 	int len;
			// 	while ((len = zis.read(buffer)) > 0) {
			// 		fos.write(buffer, 0, len);
			// 	}
			// 	fos.close();
			// 	unzippedFiles.add(newFile);
			// 	zipEntry = zis.getNextEntry();
			// }

			// for( File f: unzippedFiles){
			// 	logger.info("files:", f.getName() );
			// }
			// zis.closeEntry();
			// zis.close();

		//upload to s3
		
		// } catch (IOException ex) {
		// 	ex.printStackTrace();
		// }
		return null;
	}

	// TODO: Task 5

	// TODO: Task 6

}
