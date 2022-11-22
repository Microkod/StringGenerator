package com.example.stringgenerator.domain;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class CombinationCounter {

    public Long getMaxCombinations(long numberOfCharacters, long lengthOfString){
        long maxCombination = 1;
        while (lengthOfString > 0) {
            if (lengthOfString % 2 == 1){
                maxCombination *= numberOfCharacters;
            }
            numberOfCharacters = numberOfCharacters * numberOfCharacters;
            lengthOfString /= 2;
        }
        return maxCombination;
    }
}
