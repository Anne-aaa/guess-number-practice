package com.thoughtworks.school.practice.guessnumber;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {
    //空指针异常？
//        NumberGenerator numberGenerator;
private NumberGenerator numberGenerator = new NumberGenerator();
    @Test
    void should_generate_number_with_four_digits_and_they_are_different(){
        String number = numberGenerator.generate();

        assertThat(number).hasSize(4);
        assertThat(number.chars().distinct()).hasSize(4);
    }
    @Test
    void should_generate_different_number_when_each_time_to_generate() {
        String first = numberGenerator.generate();
        String second = numberGenerator.generate();

        assertThat(first).isNotEqualTo(second);
    }
}
