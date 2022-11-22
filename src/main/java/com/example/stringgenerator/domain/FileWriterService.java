package com.example.stringgenerator.domain;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class FileWriterService {

    public void writeSetToFile(Set setToFile, int number){
        List<String> list = new ArrayList<String>(setToFile);
        try {
            FileWriter myWriter = new FileWriter(number+"filename.txt");

            for (int i = 0; i < setToFile.size(); i++){
                myWriter.write(list.get(i));
                myWriter.write(System.lineSeparator());
            }
            myWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
