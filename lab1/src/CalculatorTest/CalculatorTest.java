package CalculatorTest;

import org.junit.*;
import static org.junit.Assert.*;

import Calculator.Calculator;
import Exceptions.WrongModeException;

public class CalculatorTest {
	private Calculator calc;
	
	@Before
	public void setUp() {
		calc = new Calculator();
		System.out.println("Before");
	}
	
	@After
	public void tearDown() {
		calc = null;
		System.out.println("After");
	}
	
	@Test
	public void TestAdding() {
		Double result = 10.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.add, 6.0, 4.0));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testErrorThrowMonoOperations() {
		WrongModeException thrown = assertThrows(
				WrongModeException.class,
				() -> calc.calculateMono(Calculator.MonoOperatorModes.notImplementedMode, 20.0));
		
		assertTrue(thrown.getMessage().contains("Wrong Mono Mode"));
	}
	
	@Test
	public void testErrorThrowBiOperations() {
		WrongModeException thrown = assertThrows(
				WrongModeException.class,
				() -> calc.calculateBiImpl(Calculator.BiOperatorModes.normal, 1.0, 2.0));
		
		assertTrue(thrown.getMessage().contains("Wrong Bi Mode"));
	}
	
	@Test
	public void TestSubstract() {
		Double result = 2.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.substract, 4.0, 2.0));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestMultiply() {
		Double result = 9.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.multiply, 2.0, 4.5));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestDivide() {
		Double result = 4.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.divide, 8.0, 2.0));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestxPowerOfY() {
		Double result = 9.0;
		try {
			assertEquals(result, calc.calculateBiImpl(Calculator.BiOperatorModes.xpowerofy, 3.0, 2.0));
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void TestAbs() {
		Double result = 5.0;
		try {
			assertEquals(result, calc.calculateMono(Calculator.MonoOperatorModes.abs, -5.0));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
