package com.example.stringgenerator.controllers;

import com.example.stringgenerator.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
public class MainController {

    //POST endpoint for creating a files and adding results to database unique Strings with provided length,
// characters used, number of strings in file and numbers of files to create
    @PostMapping(path = "/new")
    public @ResponseBody String addNewJob(@RequestParam Integer lengthOfString,
                                          @RequestParam String charsToUse,
                                          @RequestParam Integer stringsToGenerate,
                                          @RequestParam Integer numberOfTasks) {
        recordService.deleteRecords();
        long maxCombo = combinationCounter.getMaxCombinations(charsToUse.length(), lengthOfString);
        if (maxCombo >= stringsToGenerate) {
            jobTasksService.addNewJobToDatabase(lengthOfString, charsToUse, stringsToGenerate, numberOfTasks);
            for (int index = 0; index < numberOfTasks; index++) {
                Set<String> stringSet = new HashSet<>();
                for (int i = 0; i < stringsToGenerate; i++) {
                    String generatedString = randomStringGeneratorService.generateString(lengthOfString, charsToUse);
                    stringSet.add(generatedString);
                    recordService.addNewRecord(generatedString);
                }
                createFileService.fileWithNumberCreation(index);
                fileWriterService.writeSetToFile(stringSet, index);
            }
            return "success";
        } else {
            return "Maximum combination from provided length of String and characters to use is: " + maxCombo;
        }
    }

    //POST endpoint for creating a file without adding records to database
    @PostMapping(path = "/new/nodb")
    public @ResponseBody String addNewJobWithoutDatabase(@RequestParam Integer lengthOfString,
                                                         @RequestParam String charsToUse,
                                                         @RequestParam Integer stringsToGenerate,
                                                         @RequestParam Integer numberOfTasks) {
        long maxCombo = combinationCounter.getMaxCombinations(charsToUse.length(), lengthOfString);
        if (maxCombo >= stringsToGenerate) {
            for (int index = 0; index < numberOfTasks; index++) {
                Set<String> stringSet = new HashSet<>();
                for (int i = 0; i < stringsToGenerate; i++) {
                    String generatedString = randomStringGeneratorService.generateString(lengthOfString, charsToUse);
                    stringSet.add(generatedString);
                }
                createFileService.fileWithNumberCreation(index);
                fileWriterService.writeSetToFile(stringSet, index);
            }
            return "success";
        } else {
            return "Maximum combination from provided length of String and characters to use is: " + maxCombo;
        }
    }

    //GET endpoint for getting results from database
    @GetMapping(path = "/all")
    public ResponseEntity getAllGeneratedStrings() {
        return ResponseEntity.ok().body(recordService.getAllRecords().toString());
    }

    //GET endpoint to check how many combinations are possible with provided length of string and characters used in string
    @GetMapping(path = "/combo/{lengthOfString}/{chars}")
    public Long getMaxCombo(@PathVariable Map<String, String> pathvariables) {
        String convertLength = pathvariables.get("lengthOfString");
        Long lengthOfString = Long.valueOf(convertLength);
        String charsProv = pathvariables.get("chars");
        return combinationCounter.getMaxCombinations(charsProv.length(), lengthOfString);
    }

    @Autowired
    private CombinationCounter combinationCounter;
    @Autowired
    private JobTasksService jobTasksService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private FileWriterService fileWriterService;
    @Autowired
    private CreateFileService createFileService;
    @Autowired
    private RandomStringGeneratorService randomStringGeneratorService;
}
