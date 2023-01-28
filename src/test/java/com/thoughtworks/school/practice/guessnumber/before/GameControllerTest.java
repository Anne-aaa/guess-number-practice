/*
package com.thoughtworks.school.practice.guessnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.thoughtworks.school.practice.guessnumber.GameResult.Result;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

  @Mock
  private NumberGuesser numberGuesser;
  @InjectMocks
  private GameController gameController;

  //Test1 ✅
  @Test
  void should_return_current_result_when_guess() {
    //假设1234，返回的result是4A0B
    String guessedNumber = "1234";
    //Mock的返回为空，所以在这里设定其返回值。这里只测GameController的guess,所以跳过NumberGuesser的guess
    given(numberGuesser.guess(guessedNumber)).willReturn("4A0B");

    //调用方法。由于用了@InjectMocks注解，这里的numberGuesser就被注入到gameController里了
    GameResult result = gameController.guess(guessedNumber);

    //断言
    assertThat(result.getCurrent()).isEqualTo("4A0B");
  }

  @Test
  void should_return_previous_input_and_result_when_guess() {
    String guessedNumber = "1236";
    given(numberGuesser.guess(guessedNumber)).willReturn("3A0B");
    //相当于这里的GameResult是：3A0B(previous) 3A0B(current)
    gameController.guess(guessedNumber);

    GameResult result = gameController.guess(guessedNumber);

    assertThat(result.getPrevious().stream().map(Result::getInput)).contains(guessedNumber);
    assertThat(result.getPrevious().stream().map(Result::getResult)).contains("3A0B");
  }

  @Test
  void should_not_guess_when_already_guess_failed_6_times() {
    String guessedNumber = "1236";
    given(numberGuesser.guess(guessedNumber)).willReturn("3A0B");
    IntStream.range(0,6).forEach(i -> gameController.guess(guessedNumber));

    //这里再猜一次，就相当于超了
    gameController.guess(guessedNumber);

    //校验调用guess方法的次数。"Mockito verify常见用法"
    verify(numberGuesser, times(6)).guess(guessedNumber);
  }
}

 */