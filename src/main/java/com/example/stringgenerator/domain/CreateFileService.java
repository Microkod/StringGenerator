package com.example.stringgenerator.domain;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class CreateFileService {

    public void fileWithNumberCreation(int number) {
        try {
            File myObj = new File(number + "filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists. ");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred.");
        }
    }
}
