package com.thoughtworks.school.practice.guessnumber;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class Answer {
    List<Character> answer;
    private int ANSWER_SIZE=4;
    Result result;

    public  Answer(NumberGenerator numberGenerator){
        //numberGenerator返回的是Sring
        this.answer=numberGenerator.generate().chars().mapToObj(i->(char)i).collect(Collectors.toList());
    }

    public CheckResult check(List<Character> guessNumber){
        //长度不对抛出错误：判断previous的长度❌（这是用了判断几轮） 通过去重判断
        if(guessNumber.stream().distinct().count()!=ANSWER_SIZE){
            throw new RuntimeException();
        }

        //逻辑：数字不一样则抛错。数字一样才判断是否在应该在的位置
//数字不一样： 把input result拆出来一个一个，两层循环比较？ ❌ ---->
// 判断answer是否包含guessNumber(两个都做成List<Character>类型，用返回值为IntPredicate的流来写)
    //遍历guessNumber
        Map<Boolean,Long> correctAndWrongPositionCounts= IntStream.range(0,ANSWER_SIZE)
                //得到数字对的
                .filter(digitIsNotInAnswer(guessNumber))
                .boxed()
                //根据位置对不对分类
                .collect(partitioningBy(digitIsInCorrectPosition(guessNumber),counting()));
        return new CheckResult(correctAndWrongPositionCounts.get(Boolean.TRUE),correctAndWrongPositionCounts.get(Boolean.FALSE));
    }
    public IntPredicate digitIsNotInAnswer(List<Character> guessNumber){
        return idx->answer.contains(guessNumber.get(idx));
    }
    //这里要写Predicate<Integer> partitioningBy才能通过
    public Predicate<Integer> digitIsInCorrectPosition(List<Character> guessNumber){
        return idx->answer.get(idx).equals(guessNumber.get(idx));
    }
}
