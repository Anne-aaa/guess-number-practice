package com.thoughtworks.school.practice.guessnumber;

import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;


public class NumberGuesser_Refactor {
    private final List<Character> answer;
    private static final int NUMBER_SIZE = 4;
    //1.随机生成答案
    public NumberGuesser_Refactor(NumberGenerator generator) {
        //mapToObj 转成对象流
        this.answer = generator.generate().chars().mapToObj(i->(char)i).collect(Collectors.toList());
    }
    //2.猜答案
    public Result_Refactor guess(List<Character> guessed) {
        //List<Character>是.stream()     String是.chars()会把每个字符解出ASCII
        //.distinct()是Stream接口的
        //3.根据数字是否在正确的位置上分类
        Map<Boolean, Long> result = IntStream.range(0, NUMBER_SIZE)
                //过滤掉错误的数字,filter里面需要IntPredicate
                .filter(digitIsNotInAnswer(guessed))
                //???
                .boxed()
                //Collectors partitioningBy: split the stream of elements into two parts.
                .collect(partitioningBy(digitIsCorrect(guessed),counting()));
        return new Result_Refactor(result.get(Boolean.TRUE), result.get(Boolean.FALSE));
    }
    private IntPredicate digitIsNotInAnswer(List<Character> guessed){
        return idx->answer.contains(guessed.get(idx));
    }
    private Predicate<Integer> digitIsCorrect(List<Character> guessed){
        return idx ->answer.get(idx).equals(guessed.get(idx));
    }
}
