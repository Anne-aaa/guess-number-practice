package com.thoughtworks.school.practice.guessnumber;

import java.util.List;
import java.util.stream.Collectors;


public class NumberGuesser_Refactor {
    private final List<Character> answer;
    private static final int NUMBER_SIZE = 4;
    //1.随机生成答案
    public NumberGuesser_Refactor(NumberGenerator generator) {
        //mapToObj 转成对象流
        this.answer = generator.generate().chars().mapToObj(i->(char)i).collect(Collectors.toList());
    }
}
