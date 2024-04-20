package com.hellopoi.candidate.services;

import java.io.IOException;
import java.util.List;

import com.hellopoi.candidate.entities.Candidate;
import com.hellopoi.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.poi.ss.usermodel.*;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository repository;
	

	public int uploadExcell(MultipartFile file) throws IOException {

//		formatting the value stored in a Cell in Excel sheet
		DataFormatter dataFormatter = new DataFormatter();
		Workbook workbook = WorkbookFactory.create(file.getInputStream());
		Sheet sheet = workbook.getSheetAt(0); // Assuming it's the first sheet
		for (Row row : sheet) {


			String candidateName = dataFormatter.formatCellValue(row.getCell(0));  // Assuming name is in the first column
			String contactNum = dataFormatter.formatCellValue(row.getCell(1));  // Assuming contact is in the second column
			String emailId = dataFormatter.formatCellValue(row.getCell(2)); // Assuming email is in the third column
			String experience = dataFormatter.formatCellValue(row.getCell(3)); // Assuming experience is in the fourth column
			String skills = dataFormatter.formatCellValue(row.getCell(4));  // Assuming skills are in the fifth column

			// Create a new Candidate object with extracted values
			Candidate candidate = new Candidate(candidateName, contactNum, emailId, experience, skills);

			saveCandidate(candidate);

		}
		workbook.close();


		return 1;
		
	}
	
	
	
	
	public Candidate saveCandidate(Candidate candidate) {
		return repository.save(candidate);
	}
	
	public List<Candidate> getCandidateList_n(){
		//using native/custom query
		return repository.findAllOrderedByCandidateName();
	}
	public List<Candidate> getCandidateList(){
		Sort sort = Sort.by(Sort.Direction.ASC, "candidateName");
		return repository.findAll(sort);
	}
	
	public Candidate getCandidateById(int id){
		return repository.findById(id).orElse(null);
	}
	

	
	
	public String deleteCandidate(int id) {
		repository.deleteById(id);
		return "candidate removed !! "+id;
		
	}

	


}
