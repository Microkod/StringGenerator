package com.example.stringgenerator;

import com.example.stringgenerator.domain.*;
import com.example.stringgenerator.domain.Record;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;

@SpringBootTest
class StringGeneratorApplicationTests {


    @Test
    void contextLoads() {
    }
    @Test
    void savedRecordHasID(){
        Record r = new Record("abbc");
        Record savedRecord = recordService.addNewRecord(r.getName());
        assertThat(savedRecord.getId()).isNotNull();
    }
    @Test
    void savedJobTaskHasId(){
        JobTasks jobTasks = new JobTasks(10, "abc", 2,2);
        JobTasks savedJobTask = jobTasksService.addNewJobToDatabase(jobTasks.getLengthOfString(),
                jobTasks.getCharsUsedInString(), jobTasks.getUniqueStringsToGenerate(), jobTasks.getTasksToCreate());
        assertThat(savedJobTask.getId()).isNotNull();
    }
    @Test
    void testComboCounter(){
        long expected = 10000;
        assertEquals(expected, combinationCounter.getMaxCombinations(10,4));
    }

    @Test
    void givenLengthOfStringIsCorrect(){
        int expected = 10;
        String generatedString = randomStringGeneratorService.generateString(10, "cdef");
        assertEquals(expected, generatedString.length());
    }




    @Autowired
    private RecordService recordService;
    @Autowired
    private JobTasksService jobTasksService;
    @Autowired
    private CombinationCounter combinationCounter;
    @Autowired
    RandomStringGeneratorService randomStringGeneratorService;
}
