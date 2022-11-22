package com.example.stringgenerator.domain;

import org.springframework.stereotype.Service;

@Service
public class RandomStringGeneratorService {

    public String generateString(int lengthOfString, String providedChars){
        String alphanumericalString = providedChars;

        StringBuilder sb = new StringBuilder(lengthOfString);

        for(int i = 0; i < lengthOfString; i++){
            int index = (int)(alphanumericalString.length() * Math.random());
            sb.append(alphanumericalString.charAt(index));
        }
        return sb.toString();
    }
}
