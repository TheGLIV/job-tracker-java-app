package com.training.job_tracker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    //using @Autowired annotation to set repository
    @Autowired
    private JobApplicationRepository repository;

    //CREATE-any POST request gets sent here
    @PostMapping
    public JobApplication addApplication(@RequestBody JobApplication application){
        return repository.save(application);
    }

    //READ- to GET all applications in a list from the database
    @GetMapping
    public List<JobApplication> getAllApplications(){
        return repository.findAll();
    }

    //UPDATE-
    @PutMapping("/{id}")
    public JobApplication updateApplication(@PathVariable String id, @RequestBody JobApplication updatedJob) {

        //finding the existing job in database using id
        JobApplication existingJob = repository.findById(id).orElseThrow();

        //update object
        existingJob.setLink(updatedJob.getLink());
        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setRole(updatedJob.getRole());
        existingJob.setStatus(updatedJob.getStatus());

        return repository.save(existingJob) ;
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable String id){
        repository.deleteById(id);
    }
}
