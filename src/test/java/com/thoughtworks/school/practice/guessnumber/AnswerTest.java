
package com.thoughtworks.school.practice.guessnumber;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnswerTest{
    @Mock
    private NumberGenerator numberGenerator;
    private Answer answer;
    @BeforeEach
    void setUp(){
        given(numberGenerator.generate()).willReturn("1234");
        answer = new Answer(numberGenerator);
    }
    @Test
    void should_return_0_correct_0_wrong_position_when_answer_is_1234_and_given_5678(){
        CheckResult result = answer.check(asList('5', '6', '7', '8'));

        assertThat(result.getCorrectCount()).isEqualTo(0);
        assertThat(result.getWrongCount()).isEqualTo(0);
    }
    @Test
    void should_return_1_correct_0_position_when_answer_is_1234_and_given_1567() {
        CheckResult result = answer.check(asList('1', '5', '6', '7'));

        assertThat(result.getCorrectCount()).isEqualTo(1);
        assertThat(result.getWrongCount()).isEqualTo(0);
    }
    @Test
    void should_return_4_correct_0_position_when_answer_is_1234_and_given_1234() {
        CheckResult result = answer.check(asList('1', '2', '3', '4'));

        assertThat(result.getCorrectCount()).isEqualTo(4);
        assertThat(result.getWrongCount()).isEqualTo(0);
    }
    @Test
    void should_return_0_correct_4_position_when_answer_is_1234_and_given_4321() {
        CheckResult result = answer.check(asList('4', '3', '2', '1'));

        assertThat(result.getCorrectCount()).isEqualTo(0);
        assertThat(result.getWrongCount()).isEqualTo(4);
    }
    @Test
    void should_throw_exception_given_1233() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> answer.check(asList('1', '2', '3', '3')));
    }
    @Test
    void should_throw_exception_given_12345() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> answer.check(asList('1', '2', '3', '4', '5')));
    }

}