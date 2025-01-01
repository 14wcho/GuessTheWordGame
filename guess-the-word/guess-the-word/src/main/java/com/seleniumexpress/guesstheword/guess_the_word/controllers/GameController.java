package com.seleniumexpress.guesstheword.guess_the_word.controllers;

import com.seleniumexpress.guesstheword.guess_the_word.service.GameService;
import com.seleniumexpress.guesstheword.guess_the_word.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameUtils gameUtils;

    @GetMapping("/game-home")
    public String showGameHomePage(@RequestParam(value = "guessedChar", required = false) String guessedChar, Model model) {

        System.out.println("captured guessed word is " + guessedChar);

        String randomWord = gameService.toString();

        if(guessedChar != null && guessedChar.length()==1) {
            boolean isGuessCorrect = gameService.addGuess(guessedChar.charAt(0));
            randomWord = gameService.toString();
            if(isGuessCorrect == false) {
                gameUtils.reduceTry();
            }
        }
        System.out.println("number of tries remaining: " + gameUtils.getTriesRemaining());
        model.addAttribute("wordToDisplay", randomWord);
        model.addAttribute("triesLeft",gameUtils.getTriesRemaining());

        System.out.println(randomWord);

        return "game-home-page";
    }

    @GetMapping("/reload")
    public String reloadGame() {

        gameService = gameUtils.reload();

        //reset the tries to the initial value

        gameUtils.resetTries();

        return "redirect:/game-home";
    }

}

//RequestParam - captured the parameter we defined, in here "guessedChar", you can find it in url as well, required makes it to be not necessary