package com.CommerceTool;

import com.CommerceTool.configuration.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CtDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	Calculator calculator = new Calculator();

	@Test
	void sumTest()
	{
		int expected = 15;
		int actual = calculator.sum(7,4,4);

		assertThat(actual).isEqualTo(expected);
	}

}
