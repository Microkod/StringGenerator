package com.example.stringgenerator.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTasksRepository extends CrudRepository<JobTasks, Integer> {
}
