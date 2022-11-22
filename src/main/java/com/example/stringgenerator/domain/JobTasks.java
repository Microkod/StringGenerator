package com.example.stringgenerator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer lengthOfString;
    private String charsUsedInString;

    private int uniqueStringsToGenerate;
    private int tasksToCreate;



    public Integer getLengthOfString() {
        return lengthOfString;
    }

    public void setLengthOfString(Integer lengthOfString) {
        this.lengthOfString = lengthOfString;
    }

    public String getCharsUsedInString() {
        return charsUsedInString;
    }

    public void setCharsUsedInString(String charsUsedInString) {
        this.charsUsedInString = charsUsedInString;
    }

    public int getTasksToCreate() {
        return tasksToCreate;
    }

    public void setTasksToCreate(int tasksToCreate) {
        this.tasksToCreate = tasksToCreate;
    }

    public int getUniqueStringsToGenerate() {
        return uniqueStringsToGenerate;
    }

    public void setUniqueStringsToGenerate(int uniqueStringsToGenerate) {
        this.uniqueStringsToGenerate = uniqueStringsToGenerate;
    }

    public JobTasks(Integer lengthOfString, String charsUsedInString, int uniqueStringsToGenerate, int tasksToCreate) {
        this.lengthOfString = lengthOfString;
        this.charsUsedInString = charsUsedInString;
        this.uniqueStringsToGenerate = uniqueStringsToGenerate;
        this.tasksToCreate = tasksToCreate;
    }
}
