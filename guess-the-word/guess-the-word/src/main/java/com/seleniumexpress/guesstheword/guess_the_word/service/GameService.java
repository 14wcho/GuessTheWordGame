package com.seleniumexpress.guesstheword.guess_the_word.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class GameService {


    private String randomlyChosenWord = null; //hello

    private String[] randomWords = {"father", "mother", "sister","string", "hello", "light", "java"};

    private char[] allCharactersOfTheWord;



    Random random = new Random();

    public GameService() {

        randomlyChosenWord = randomWords[random.nextInt(randomWords.length)]; // hello
        System.out.println("Randomly chosen word is: " + randomlyChosenWord);
        allCharactersOfTheWord = new char[randomlyChosenWord.length()];
    }


    @Override
    public String toString() {

        String ret = "";

        for(char c: allCharactersOfTheWord){
            if(c == '\u0000') {  // \u0000 is same as null, or nul
                ret = ret + "_";
            } else {
                ret = ret + c;
            }
            ret = ret + ' ';
        }

        return ret;
    }

    public boolean addGuess(char guessedChar) { // o

        boolean isGuessCorrect = false;

        for(int i=0; i<randomlyChosenWord.length(); i++) {
            if (guessedChar == randomlyChosenWord.charAt(i)){
                allCharactersOfTheWord[i]= guessedChar;
                isGuessCorrect = true;
            }
        }

        return isGuessCorrect;

    }
}
