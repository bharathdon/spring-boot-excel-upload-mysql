package com.abc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abc.helper.ExcelHelper;
import com.abc.model.Tutorial;
import com.abc.service.ExcelService;
import com.abc.service.ResponseMessage;

@RestController
@CrossOrigin
public class ExcelController {

	@Autowired
	private ExcelService excelService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("multipartFile") MultipartFile multipartFile)
			throws IOException {

		String message = "";
			excelService.save(multipartFile);
			message = "file uploaded" + multipartFile.getOriginalFilename();
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));

	}

	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAll() {
		List<Tutorial> list = excelService.getAll();
		if (list.isEmpty()) {
			return new ResponseEntity<List<Tutorial>>(HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<List<Tutorial>>(HttpStatus.OK);

	}
}
