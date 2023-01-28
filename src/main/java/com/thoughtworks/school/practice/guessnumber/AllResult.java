package com.thoughtworks.school.practice.guessnumber;

import java.util.List;

public class AllResult {
    String currentresult;
    List<Result> previousResult;

    public AllResult(String currentresult,List<Result> previousResult){
        this.currentresult=currentresult;
        this.previousResult=previousResult;
    }
}
