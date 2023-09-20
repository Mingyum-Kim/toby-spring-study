package com.toby.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitTest {
    static JunitTest testObject;

    @Test
    public void test1(){
        Assertions.assertThat(this).isNotEqualTo(testObject);
        testObject = this;
    }

    @Test
    public void test2(){
        Assertions.assertThat(this).isNotEqualTo(testObject);
        testObject = this;
    }

    @Test
    public void test3(){
        Assertions.assertThat(this).isNotEqualTo(testObject);
        testObject = this;
    }
}
