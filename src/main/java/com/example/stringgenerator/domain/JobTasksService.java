package com.example.stringgenerator.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class JobTasksService {

    @Autowired
    private JobTasksRepository jobTasksRepository;

    public JobTasks addNewJobToDatabase(Integer lengthOfString, String charsToUse, Integer stringToGenerate,
                                        Integer numberOfTasks){
        JobTasks jobTask = new JobTasks(lengthOfString, charsToUse, stringToGenerate, numberOfTasks);
        jobTasksRepository.save(jobTask);
        return jobTask;
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<JobTasks> getAllJobTasks(){
        return jobTasksRepository.findAll();
    }
}
