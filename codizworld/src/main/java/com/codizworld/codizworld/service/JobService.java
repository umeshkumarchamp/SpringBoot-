package com.codizworld.codizworld.service;

import java.util.List;

import com.codizworld.codizworld.model.Job;

public interface JobService {
    public List<Job> findAll();
    public String addJob(Job job);
    public boolean updateJob(Long id, Job job);
    public boolean removeJob(Long id);
    public Job getJobById(Long id);
    public List<Job> findByTitle(String title);
    public List<Job> findJobsByLocation(String location);
}
