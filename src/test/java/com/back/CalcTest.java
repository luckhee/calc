package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// build.gradle.kts 의 dependencies 블록에 `testImplementation("org.assertj:assertj-core:3.27.3")` 추가 후 그래들 리프레시 해야 아래 라이브러리 사용 가능
import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    @Test
    @DisplayName("1 + 1 == 2")
    void t1() {
        assertThat(Calc.
                run("1 + 1"))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("2 + 1 == 3")
    void t2() {
        assertThat(Calc.run("2 + 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("2 + 2 == 4")
    void t3() {
        assertThat(Calc.run("2 + 2")).isEqualTo(4);
    }

    @Test
    @DisplayName("1000 + 280 == 1280")
    void t4() {
        assertThat(Calc.
                run("1000 + 280")).
                isEqualTo(1280);
    }

    @Test
    @DisplayName("2 - 1 == 1")
    void t5() {
        assertThat(Calc.
                run("2 - 1")).isEqualTo(1);
    }


}
