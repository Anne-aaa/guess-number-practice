package com.thoughtworks.school.practice.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final int MAX_GAME_ROUND = 6;
    //TDD1.假设只有一轮时
    //TDD2.假设有六轮，需要对previousResult进行追加，每次guess时追加
    Answer answer;
    FormatResult formatResult;
    List<Result> previousResult=new ArrayList<>();
    Boolean alreadyWin=false;
    String guessNumber;
    public GameController(Answer answer,FormatResult formatResult){
        this.answer=answer;
        this.formatResult=formatResult;
    }
    CheckResult checkResult=answer.check(toCharList(guessNumber));

    private List<Character> toCharList(String guessNumber) {
        return guessNumber.chars().mapToObj(i->(char) i).collect(Collectors.toList());
    }

    public AllResult guess(String guessNumber){
        String message=null;
        if(alreadyWin||previousResult.size()>=MAX_GAME_ROUND){
            throw new RuntimeException();
        }
        String currentResult=formatAndCheckResult(guessNumber);
        if(currentResult.equals("4A0B")){
            message="Congratulations, you win !";
            alreadyWin = true;
        }
        previousResult.add(new Result(guessNumber,message));
        return new AllResult(currentResult,previousResult);
    }

    private String formatAndCheckResult(String guessNumber) {
        try{
            return formatResult.format(checkResult);
        }catch (RuntimeException e){
            return "Wrong input,input again";
        }
    }
}
