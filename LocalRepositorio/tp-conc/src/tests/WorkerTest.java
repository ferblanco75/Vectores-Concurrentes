package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.ConcurVector;
import progConc.MonitorAccionesWorker;
import progConc.Operacion;
import progConc.Worker;

public class WorkerTest {
	
	
	Operacion dummyOperacion;
	MonitorAccionesWorker dummyMonitor;
	Worker worker;
	double d;
	//Worker worker= new (workerthis.monitor, this.operacion,this.vector,this.vectorModificado,i,this.inicio,this.fin);
	
	ConcurVector mockVector;
	Object dummy;  
	
		   

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		dummyOperacion=mock(Operacion.class);
		dummyMonitor= mock(MonitorAccionesWorker.class);
		mockVector= mock (ConcurVector.class);
		worker= new Worker (dummyMonitor,dummyOperacion,mockVector,mockVector,1,0,2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbs() {
		 worker.abs();
		// Verifica que worker escribió en el buffer 2 veces
		  verify( mockVector,times(2)).getBuffer().write(d);

}
	
}