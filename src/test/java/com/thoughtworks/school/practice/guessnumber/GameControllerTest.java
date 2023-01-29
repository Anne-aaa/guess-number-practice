package com.thoughtworks.school.practice.guessnumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    @Mock
    private Answer answer;
    @Mock
    private FormatResult formatter;
    @InjectMocks
    private GameController gameController;
    //这里应该mock得到结果的逻辑，验证AllResult
    @Test
    void should_return_formatted_result() {
        CheckResult checkResult = new CheckResult((long)0,(long)0);
        given(answer.check(any())).willReturn(checkResult);
        given(formatter.format(checkResult)).willReturn("0A0B");

        AllResult result = gameController.guess("5678");

        assertThat(result.getCurrentresult()).isEqualTo("0A0B");
    }
}
