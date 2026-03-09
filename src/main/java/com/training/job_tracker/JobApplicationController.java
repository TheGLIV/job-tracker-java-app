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

    //any POST request gets sent here
    @PostMapping
    public JobApplication addApplication(@RequestBody JobApplication application){
        return repository.save(application);
    }

    //to GET all applications in a list from the database
    @GetMapping
    public List<JobApplication> getAllApplications(){
        return repository.findAll();
    }
}
