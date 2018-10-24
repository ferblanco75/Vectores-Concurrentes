package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import progConc.Operacion;
import progConc.Set;
import progConc.Worker;

public class SetTest {

	Operacion operacion; 
	  Worker mockWorker;
	 double d ;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		 mockWorker= mock(Worker.class);
		 operacion= new Set(d); 
		 
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void test_Operar() {
		
		operacion.operar(mockWorker);
		// Verifica que el worker llama a set(d)
		verify(mockWorker, atLeast(1)).set(d);

	}

}
