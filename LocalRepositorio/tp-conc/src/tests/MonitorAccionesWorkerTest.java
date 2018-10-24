package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.MonitorAccionesWorker;

public class MonitorAccionesWorkerTest {
      int  contador;
      MonitorAccionesWorker monitor;
	
    @BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		contador=0;
		monitor = new MonitorAccionesWorker();
			}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_conThreads_Si_cuento_N_veces_Me_Devuelve_ElNumero_N_Menos_uno() {
		
	// Si cuento tres veces, me devuelve el numero dos
 	  
	 int expected=2;
 	  for (int i=0; i < 3; i++ ) {
 	  contador= monitor.contThreads();
 	  }
 	   
 	  assertTrue(contador== expected);
	}
	
	@Test
	public void test_decrementarThreads_Me_Devuelve_Siempre_Cero() {
		
	// Al hacer decrementarThreads me devuelve siempre cero
 	  
	 int expected=0;
 	 contador= monitor.decrementarThreads();
 	  	   
 	  assertTrue(contador== expected);
	}

}
