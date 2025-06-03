package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// build.gradle.kts 의 dependencies 블록에 `testImplementation("org.assertj:assertj-core:3.27.3")` 추가 후 그래들 리프레시 해야 아래 라이브러리 사용 가능
import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {

    @Test
    @DisplayName("1 + 1 == 2")
    void t1() {
        assertThat(ReCalc.run("1 + 1")).isEqualTo(2);
    }
}
