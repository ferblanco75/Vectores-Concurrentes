package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.Mul;
import progConc.Operacion;
import progConc.Worker;

public class MulTest {

	Operacion operacion; 
	  Worker mockWorker;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		 mockWorker= mock(Worker.class);
		 operacion= new Mul(); 
		 
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void test_Operar() {
		
		operacion.operar(mockWorker);
		// Verifica que el worker llama a mul() una vez
		verify(mockWorker, times(1)).mul();

	}

}
