package com.thoughtworks.school.practice.guessnumber;

public class CheckResult {
    Long correctCount;
    Long wrongCount;
    public CheckResult(Long correctCount,Long wrongCount){
        this.correctCount=correctCount;
        this.wrongCount=wrongCount;
    }
}
