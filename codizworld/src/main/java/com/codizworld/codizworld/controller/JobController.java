package com.codizworld.codizworld.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codizworld.codizworld.model.Job;
import com.codizworld.codizworld.service.JobService;


@RestController
@RequestMapping(value = "/api/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<List<Job>>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>("Job Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id){

        Job job = jobService.getJobById(id);
        if(job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/edit/{id}")
    // @RequestMapping(value = "/jobs/edit", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job){

        boolean res = jobService.updateJob(id, job);
        if(res){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Record Not Found ! ", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean res = jobService.removeJob(id);
        if(res){
            return new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Record Not Found !",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/find-by-name")
    public ResponseEntity<List<Job>> findByTitle(@RequestParam(name = "jobTitle", required = true) String title) {
        return new ResponseEntity<List<Job>>(jobService.findByTitle(title), HttpStatus.OK);
    }


    /**
     * Search Jobs by Location
     * @param location
     * @return
     */
    @PostMapping("search-by-location")
    public ResponseEntity<List<Job>> searchByLocation(@RequestParam(name="location", required = true) String location){
        List<Job> jobs = jobService.findJobsByLocation(location);
        if(jobs != null){
            return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
        }
        return new ResponseEntity<List<Job>>(jobs, HttpStatus.NOT_FOUND);
    }
}
