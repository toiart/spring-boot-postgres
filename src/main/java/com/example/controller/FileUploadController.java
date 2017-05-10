package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Art on 11/24/16.
 */
@RestController
public class FileUploadController {

	@PostMapping("/upload")
	public @ResponseBody String uploadImage(@RequestParam("imageValue") String imageValue)
	{
		try
		{
			String base64Image = imageValue.split(",")[1];
			byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
			BufferedImage image = ImageIO.read(bis);
			bis.close();
			Date date = new Date() ;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
			File outputfile = new File("/tmp/"+dateFormat.format(date)+".png");
			ImageIO.write(image, "png", outputfile);
			return "success ";

		}
		catch(Exception e)
		{
			return "error = "+e;
		}

	}

	@PostMapping("/uploadfile")
	public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {

		try {
			String filepath = Paths.get("/tmp", file.getOriginalFilename()).toString();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(file.getBytes());
			stream.close();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
