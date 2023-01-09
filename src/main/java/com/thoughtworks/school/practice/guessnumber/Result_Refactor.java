package com.thoughtworks.school.practice.guessnumber;

public class Result_Refactor {
    private Long correctNumber;
    private Long wrongPositionNumber;
    public Result_Refactor(Long correctNumber,Long wrongPositionNumber){
        this.correctNumber=correctNumber;
        this.wrongPositionNumber=wrongPositionNumber;
    }
    public Long getCorrectNumber(){return correctNumber;}
    public Long getWrongPositionNumber(){return wrongPositionNumber;}


}
