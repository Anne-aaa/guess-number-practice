/*
package com.thoughtworks.school.practice.guessnumber;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class NumberGuesser {

  private static final int NUMBER_SIZE = 4;
  private static final String RIGHT_GUESS = "A";
  private static final String RIGHT_NUMBER_WRONG_PLACE = "B";
  private static final long DEFAULT_COUNT = 0L;
  private final String answer;

  //answer是随机生成的一串数字
  public NumberGuesser(NumberGenerator generator) {
    this.answer = generator.generate();
  }

  //这里的gusee应该返回的是1A0B，
  public String guess(String guessed) {
      //.distinct() 元素去重
    if (guessed.chars().distinct().count() != NUMBER_SIZE) {
      return "Wrong input, input again";
    }
    if (answer.equals(guessed)) {
      return "4A0B";
    }
    //产生一个数字流0123，可以遍历
    Map<String, Long> result = IntStream.range(0, NUMBER_SIZE)
            //mapToObj 转成对象流，例如String
        .mapToObj(idx -> {
          char answerValue = answer.charAt(idx);
          char guessedValue = guessed.charAt(idx);
          if (answerValue == guessedValue) {
            return RIGHT_GUESS;
          }
          //.indexOf() 返回字符在字符串中第一次出现处的索引，没有则返回-1
          return answer.indexOf(guessedValue) == -1 ? null : RIGHT_NUMBER_WRONG_PLACE;
        })
            // 1245    AABnull
        .filter(Objects::nonNull)
            //2A1B
            //.collect:
        .collect(groupingBy(identity(), counting()));

    //hashmap.getOrDefault(Object key, V defaultValue):取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
    return result.getOrDefault(RIGHT_GUESS, DEFAULT_COUNT) + RIGHT_GUESS +
        result.getOrDefault(RIGHT_NUMBER_WRONG_PLACE, DEFAULT_COUNT) + RIGHT_NUMBER_WRONG_PLACE;
  }
}

 */
