package com.codizworld.codizworld.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codizworld.codizworld.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    public List<Job> findByTitle(String title);

    @Query("SELECT j FROM Job j")
    public List<Job> getAllJobs();

    @Query("SELECT j FROM Job j WHERE j.location = :l")
    public List<Job> getJobsByLocation(@Param("l") String location);

    @Query(value="SELECT * FROM jobs", nativeQuery = true)
    public List<Job> retrieveAllJobs();
}
