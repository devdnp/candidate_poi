package com.hellopoi.candidate.controllers;

import java.io.IOException;
import java.util.List;

import com.hellopoi.candidate.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hellopoi.candidate.services.CandidateService;

@RestController
public class CandidateController {
	
	@Autowired
	private CandidateService service;
	
	@PostMapping("/addCandidate")
	public Candidate addCandidate(@RequestBody Candidate candidate) {
		return service.saveCandidate(candidate);
	}
	
	@PostMapping("/uploadExcellData")
	public String uploadExcellData(@RequestParam("file") MultipartFile file) throws IOException {
		
		if (file.isEmpty()) {
            return "Please upload an Excel file!";
        }
		
		int i= service.uploadExcell(file);
		
		return i==1? "Successfully Upload!":"Failed";

	}
	
	
	
	@GetMapping("/candidates")
	public List<Candidate> getCandidateList(){
		return service.getCandidateList();
	}

	@GetMapping("/candidates_n")
	public List<Candidate> getCandidateListNative(){
		return service.getCandidateList_n();
	}

	@GetMapping("/candidate/{id}")
	public Candidate findCandidateById(@PathVariable int id) {
		return service.getCandidateById(id);
	}
	

	
	@DeleteMapping("/delete/{id}")
	public String deleteCandidate(@PathVariable int id) {
		return service.deleteCandidate(id);
	}
	
	
	
	
	
	
	
	
	
}
