package com.abc.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abc.helper.ExcelHelper;
import com.abc.model.Tutorial;
import com.abc.repository.TutorialRepository;

@Service
public class ExcelService {

	@Autowired
	private TutorialRepository tutorialRepository;
	
	@Autowired
	private ExcelHelper excelHelper;
	
	public void save(MultipartFile multipartFile) throws IOException {
		@SuppressWarnings("static-access")
		List<Tutorial> tutorials = excelHelper.excelToTutorial(multipartFile.getInputStream());
		tutorialRepository.saveAll(tutorials);
		
	}
	
	public List<Tutorial> getAll(){
			return tutorialRepository.findAll();
	}
}
