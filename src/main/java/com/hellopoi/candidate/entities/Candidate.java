package com.hellopoi.candidate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String candidateName;
	private String contactNumber;
	private String emailId;
	private String experience;
	private String skill;

	public Candidate(String candidateName, String contactNumber, String emailId, String experience, String skill) {
		this.candidateName = candidateName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.experience = experience;
		this.skill = skill;
	}
}
