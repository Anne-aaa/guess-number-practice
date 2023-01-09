package com.thoughtworks.school.practice.guessnumber;

import com.thoughtworks.school.practice.guessnumber.GameResult.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {

  private static final int LIMITED_GAME_ROUND = 6;
  private final NumberGuesser numberGuesser;
  //所有Result的集合
  private List<Result> previousResult = new ArrayList<>();

  //写这么一句是为了？
  public GameController(NumberGuesser numberGuesser) {
    this.numberGuesser = numberGuesser;
  }

  public GameResult guess(String guessedNumber) {

    List<Result> previous = Collections.unmodifiableList(new ArrayList<>(previousResult));

    if (previousResult.size() >= LIMITED_GAME_ROUND) {
      return new GameResult(null, previous);
    }

    //当前result
    String currentResult = numberGuesser.guess(guessedNumber);

    previousResult.add(new Result(guessedNumber, currentResult));

    //这里的GameResult是所有Result的集合
    return new GameResult(currentResult, previous);
  }
}
