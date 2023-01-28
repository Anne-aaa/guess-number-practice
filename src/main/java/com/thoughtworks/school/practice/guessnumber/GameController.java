package com.thoughtworks.school.practice.guessnumber;

import java.util.List;

public class GameController {
    //TDD1.假设只有一轮时
    Answer answer;
    FormatResult formatResult;
    public GameController(Answer answer,FormatResult formatResult){
        this.answer=answer;
        this.formatResult=formatResult;
    }
    List<Character> guessNumber;
    CheckResult checkResult=answer.check(guessNumber);

    public String getResult(){
        return formatResult.format(checkResult);
    }
}
