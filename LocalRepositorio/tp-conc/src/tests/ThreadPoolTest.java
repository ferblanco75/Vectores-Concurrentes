package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.Abs;
import progConc.ConcurVector;
import progConc.Operacion;
import progConc.ThreadPool;
import progConc.Worker;

import static org.mockito.Mockito.*;

public class ThreadPoolTest {
     
	ThreadPool threadPool;
	
	Operacion dummyOperacion;
	
    ConcurVector vector1, dummyVector;
  
    
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 dummyOperacion =  mock(Operacion.class);
		vector1= new ConcurVector(7,3);
		dummyVector= mock (ConcurVector.class);
		 //threadPool= new ThreadPool();
	   
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void testInitializeWorkers() throws InterruptedException {
		
		threadPool.initializeWorkers(dummyOperacion/*,vector1,dummyVector*/);
		int expoected= 7;
		// El último thread va hasta el fin que es la dimension del vector
		assertTrue(threadPool.getFin()-threadPool.getRango() == 7);
		
	}

}
