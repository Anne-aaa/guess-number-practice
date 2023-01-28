package com.thoughtworks.school.practice.guessnumber;


public class FormatResult {
    public String format(CheckResult checkResult){
        return checkResult.getCorrectCount()+"A"+ checkResult.getWrongCount()+"B";
    }
}
