package com.hellopoi.candidate.repositories;

import com.hellopoi.candidate.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateRepository extends JpaRepository <Candidate,Integer> {

//    Generating the native query for shorting data with name
    @Query(value = "SELECT * FROM candidates ORDER BY candidate_Name", nativeQuery = true)
    List<Candidate> findAllOrderedByCandidateName();

}
