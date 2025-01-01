package com.seleniumexpress.guesstheword.guess_the_word.utils;

import com.seleniumexpress.guesstheword.guess_the_word.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GameUtils {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    private int MAX_TRIES = 5;

    public int reduceTry() {

        MAX_TRIES = MAX_TRIES - 1;
        return MAX_TRIES;
    }

    public void resetTries() {

        MAX_TRIES = 5;

    }

    public int getTriesRemaining() {

        return MAX_TRIES;
    }

    public GameService reload() {

        GameService gameService = applicationContext.getBean(GameService.class);

        return gameService;

    }

}
