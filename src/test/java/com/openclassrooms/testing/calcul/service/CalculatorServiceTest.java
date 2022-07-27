package com.openclassrooms.testing.calcul.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.openclassrooms.testing.calcul.domain.Calculator;
import com.openclassrooms.testing.calcul.domain.model.CalculationModel;
import com.openclassrooms.testing.calcul.domain.model.CalculationType;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

	@Mock
	Calculator calculator;
	CalculatorService classUnderTest;
	@BeforeEach
	public void Setup(){
		classUnderTest = new CalculatorServiceImpl(calculator);

	}
	// Calculator IS CALLED BY CalculatorService


	@Test
	public void calculate_shouldUseCalculator_forAddition() {
		//GIVEN
		when(calculator.add(1,2)).thenReturn(3);

		//WHEN

		final int result = classUnderTest.calculate(
				new CalculationModel(CalculationType.ADDITION, 1, 2)).getSolution();
		//THEN
		verify(calculator).add(1,2);
		assertThat(result).isEqualTo(3);
	}
	@Test
public void calculate_shouldUseCalculator_forSoustract(){
		// GIVEN
	when(calculator.sub(5,3)).thenReturn(2);
	// WHEN
	final  int result_sub = classUnderTest.calculate(new CalculationModel(CalculationType.SUBTRACTION,5,3)).getSolution();
		// THEN
	verify(calculator).sub(5,3);
	assertThat(result_sub).isEqualTo(2);
}
@Test
public void calculate_shouldUseCalculator_forMultiply() {
	// GIVEN
	when(calculator.multiply(3,3)).thenReturn(9);
		// WHEN
	final  int result_multiply = classUnderTest.calculate(new CalculationModel(CalculationType.MULTIPLICATION,3,3)).getSolution();
	// then
	verify(calculator).multiply(3,3);
	assertThat(result_multiply).isEqualTo(9);
}
@Test
public void calculate_shouldUseCalculator_forDivision() {
		// GIVEN
	when(calculator.divide(6,3)).thenReturn(2);
	//WHEN
	final int result_divide = classUnderTest.calculate(new CalculationModel(CalculationType.DIVISION,6,3)).getSolution();
	//then
	verify(calculator).divide(6,3);
	assertThat(result_divide).isEqualTo(2);
}
}
