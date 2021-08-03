package com.juaracoding.service.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.juaracoding.service.utility.FileUtility;
import com.juaracoding.service.entity.DataUser;
import com.juaracoding.service.repository.DataUserRepository;

@RestController
@RequestMapping("/user")
public class DataUserController {
	@Autowired
	DataUserRepository dataRepo;

	@GetMapping("/")
	public List<DataUser> getAll() {
		return dataRepo.findAll();
	}

	@GetMapping("/login/")
	public DataUser loginUser(@RequestParam("name")String username, @RequestParam("phone") String phone) {
		return dataRepo.findByLogin(username, phone);
	}


	@GetMapping("/searchby/{type}/{value}")
	public List<DataUser> getSearchBy(@PathVariable("type")String type, @PathVariable("value") String value) {
		return dataRepo.findBySearchBy(type, value);
	}

	@GetMapping("/name/{value}")
	public DataUser getByName(@PathVariable("value") String value) {
		return dataRepo.findByName(value);
	}

	@PostMapping("/")
	public String addUser (@RequestParam(value="file")MultipartFile images, @ModelAttribute(value="data") String dataJson) throws IOException {
		String fileName = StringUtils.cleanPath(images.getOriginalFilename());
		
		String uploadDir = "src/main/java/user-photo/";
		FileUtility.saveFile(uploadDir, fileName, images);
		DataUser user = new Gson().fromJson(dataJson, DataUser.class);
		
		if(user.getJeniskelamin().equalsIgnoreCase("Laki")) {
			user.setJeniskelamin("laki");
		}else {
			user.setJeniskelamin("perempuan");
		}
		user.setImage(fileName);
		Date date = new Date();
		dataRepo.save(user);
		return "Berhasil memasukan data";
	}
	
	@GetMapping(value = "/image/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable String name) throws IOException {
	   final InputStream in = getClass().getResourceAsStream("/user-photo/"+name);
	   return IOUtils.toByteArray(in);
	}
}
