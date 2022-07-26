package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

public class CalculatorTest {
private Calculator calculatorUnderTest;
private static Instant startedAt;

@BeforeAll
public  static  void initStartingTime(){
	System.out.println("appelle avant tous les tests");
	startedAt=Instant.now();
}
@AfterAll
public  static void showTestDuration() {
System.out.println("appel apres tous les test ");
Instant endedAt = Instant.now();
long duration = Duration.between(startedAt,endedAt).toMillis();
System.out.println(MessageFormat.format("duree des test : {0} ms",duration));
}

@BeforeEach
public void initCalculator() {
	calculatorUnderTest = new Calculator();
	System.out.println("appel avant chaque test ");

}
@AfterEach
public void undefCalculator(){
	System.out.println("appelle apres chaque test ");
	calculatorUnderTest= null;
}
	@Test
	public void testAddTwoPositiveNumbers() {
		// Arrange
		int a = 2;
		int b = 3;


		// Act
		int somme = calculatorUnderTest.add(a, b);

		// Assert
		assertEquals(5, somme);
	}

	@Test
	public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
		// Arrange
		int a = 42;
		int b = 11;


		// Act
		int produit = calculatorUnderTest .multiply(a, b);

		// Assert
		assertEquals(462, produit);
	}

}
