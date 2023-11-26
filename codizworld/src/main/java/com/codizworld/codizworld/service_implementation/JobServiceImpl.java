package com.codizworld.codizworld.service_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codizworld.codizworld.model.Job;
import com.codizworld.codizworld.repository.JobRepository;
import com.codizworld.codizworld.service.JobService;

@Service
public class JobServiceImpl implements JobService{

    // private List<Job> jobs = new ArrayList<>();
    // private Long nextId = 1L;

    private JobRepository jobRepo; 

    public JobServiceImpl(JobRepository jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public List<Job> findAll() {
        // return jobRepo.findAll();
        // return jobRepo.getAllJobs();
        return jobRepo.retrieveAllJobs();

    }

    @Override
    public String addJob(Job job) {
        // job.setId(nextId++);
        // jobs.add(job);
        jobRepo.save(job);
        return "Job Added Successfully";
    }

    @Override
    public boolean removeJob(Long id) {
        // for(Job job : jobs) {
        //     if(job.getId().equals(id)) {
        //         jobs.remove(job);
        //         return true;
        //     }
        // }
        // return false;
        // Iterator<Job> iterator = jobs.iterator();
        // while (iterator.hasNext()) {
        //     Job job = iterator.next();
        //     if(job.getId().equals(id)) {
        //         iterator.remove();
        //         return true;
        //     }
        // }
        // return false;

        try{
            jobRepo.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        // for(Job j : jobs) {
        //     if(j.getId().equals(job.getId())) {
        //         j.setTitle(job.getTitle());
        //         j.setDescription(job.getDescription());
        //         j.setMaxSalary(job.getMaxSalary());
        //         j.setMinSalary(job.getMinSalary());
        //         j.setLocation(job.getLocation());
        //         return true;
        //     }
        // }
        // return false;
        Optional<Job> jobOptional = jobRepo.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepo.save(job);
            return true;
        }
        return false;
    }

    @Override
    public Job getJobById(Long id) {
        // for(Job job : jobs){
        //     if(job.getId().equals(id)){
        //         return job;
        //     }
        // }
        // return null;
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public List<Job> findByTitle(String title) {
        return jobRepo.findByTitle(title);
    }

    @Override
    public List<Job> findJobsByLocation(String location) {
        return jobRepo.getJobsByLocation(location);
    }

  

}
