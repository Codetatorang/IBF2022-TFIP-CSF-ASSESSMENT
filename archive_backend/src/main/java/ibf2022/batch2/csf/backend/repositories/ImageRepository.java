package ibf2022.batch2.csf.backend.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import net.lingala.zip4j.ZipFile;

@Repository
public class ImageRepository {

	@Autowired
	private AmazonS3 s3Client;

	@Value("${DO_STORAGE_BUCKETNAME}")
	private String bucketName;

	// TODO: Task 3
	// You are free to change the parameter and the return type
	// Do not change the method's name
	public void upload(File file) throws IOException {

		// ZipFile zipFile = new ZipFile(file);
		// zipFile.extractAll("../.././Files");

		System.out.println("enters image repo");
		String fileString = file.getName();

		ObjectMetadata metaData = new ObjectMetadata();

		metaData.setContentType(bucketName);

		Optional<String> fileExt = Optional.ofNullable(fileString)
				.filter(f-> f.contains("."))
				.map(f->f.substring(fileString.lastIndexOf("."), +1));
		
		metaData.setContentType("image/" + fileExt.get());

		metaData.setContentLength(file.length());

		PutObjectRequest putRequest = new PutObjectRequest(bucketName,fileString, new FileInputStream(file), metaData);
		putRequest.withCannedAcl(CannedAccessControlList.PublicRead);
		s3Client.putObject(putRequest);

	}

	//extraction of zip file
	// public static final int BUFFER_SIZE = 4096;

	// public void unzip(String zipFilePath, String destDirectory) throws IOException{
	// 	File destDir = new File(destDirectory);
	// 	if(!destDir.exists()){
	// 		destDir.mkdir();
	// 	}

	// 	ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
	// 	ZipEntry zipEntry = zis.getNextEntry();

	// 	while(null!=zipEntry){
	// 		String filePath = destDirectory + File.separator + zipEntry.getName();
	// 		extractfile
	// 	}
	// }

}
