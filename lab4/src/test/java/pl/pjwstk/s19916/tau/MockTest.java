package pl.pjwstk.s19916.tau;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.*;

import pl.pjwstk.s19916.tau.exceptions.*;
import pl.pjwstk.s19916.tau.app.*;

public class MockTest{

    @Test
    public void spaceAtEndTest(){
        StringManipulator manipulator = mock(StringManipulator.class);
        when(manipulator.addSpaceAtEnd("text")).thenReturn("text ");
        String result = manipulator.addSpaceAtEnd("text");
        assertEquals(result, "text ");
    }

    @Test 
    public void addSpaceAtBegginingTest(){
    StringManipulator manipulator = mock(StringManipulator.class);
    when(manipulator.addSpaceAtBeggining("text")).thenReturn(" text");
    String result = manipulator.addSpaceAtBeggining("text");
    assertEquals(result, " text");
    }

    @Test
    public void addVarAndStubTest(){
        StringManipulator manipulator = mock(StringManipulator.class);
        StringHolder stub = new StringHolder();
        stub.setStringThatWeHold("string that we hold");
        when(manipulator.addInternalVarToTheEnd("text")).thenReturn("text " + stub.getStringThatWeHold());
        String result = manipulator.addInternalVarToTheEnd("text");
        assertEquals(result, "text " + stub.getStringThatWeHold());
    }


    @Test
	public void testMockAdding() {
        Calculator calc = mock(Calculator.class);
		try {
			given(calc.calculateBiImpl(Calculator.BiOperatorModes.add, 1.0, 4.0)).willReturn(5.0);
            assertEquals(5.0, calc.calculateBiImpl(Calculator.BiOperatorModes.add, 1.0, 4.0));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

    @Test
	public void testMockMinus() {
        Calculator calc = mock(Calculator.class);
		try {
			given(calc.calculateBiImpl(Calculator.BiOperatorModes.minus, 4.0, 1.0)).willReturn(3.0);
            assertEquals(3.0, calc.calculateBiImpl(Calculator.BiOperatorModes.minus, 4.0, 1.0));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testMockErrorThrowMonoOperations() {
        Calculator calc = mock(Calculator.class);
        try {
			given(calc.calculateMono(Calculator.MonoOperatorModes.notImplementedMode, 20.0)).willThrow(WrongModeException.class);
            WrongModeException thrown = assertThrows(
				WrongModeException.class,
				() -> calc.calculateMono(Calculator.MonoOperatorModes.notImplementedMode, 20.0));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}