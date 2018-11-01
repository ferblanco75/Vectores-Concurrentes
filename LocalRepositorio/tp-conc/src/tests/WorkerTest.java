package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.Buffer;
import progConc.ConcurVector;
import progConc.MonitorAccionesWorker;
import progConc.MonitorBarrera;
import progConc.MonitorSecuenciador;
import progConc.Operacion;
import progConc.Work;
import progConc.Worker;

public class WorkerTest {
	
	
	Operacion mockOperacion;
	MonitorAccionesWorker dummyMonitor;
	Worker worker;
	Buffer buffer;
	ConcurVector vector1,vector2,mask;
	MonitorAccionesWorker mockMonitor;
	MonitorBarrera mockBarrera;
	MonitorSecuenciador mockSecuenciador;
	Work work;
	int inicio,fin;	   

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		mockOperacion=mock(Operacion.class);
		dummyMonitor= mock(MonitorAccionesWorker.class);
		mockBarrera= mock(MonitorBarrera.class); 
		mockSecuenciador= mock(MonitorSecuenciador.class); 
		inicio= 0;
		fin=3;
	 
		
		vector1= new ConcurVector (3,2);
	
		
		vector2= new ConcurVector (3,2);
	
		
		
        mask= new ConcurVector (3,2);
	
		
		for (int i=0;i < vector1.dimension();i++ ) {
			double d= i+1;
			vector1.set(i,d);		
			}
					
			for (int i=0;i < vector2.dimension();i++ ) {
				vector2.set(i,2);		
				}
			
			
				mask.set(0,-1);	
				mask.set(1,-1);	
				mask.set(2,1);	
				
		
		
		work= new Work (vector1,vector2,inicio,fin);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testMul() {
		// Multiplica los valores del vector1 (1,2,3) con los valores del vector2 uno a uno (2,2,,2)
		// y el resultado es Vector1 con (2,4,6)
		vector1.mul(vector2);
		
		assertTrue(work.getVector1().get(0)==2);
		assertTrue(work.getVector1().get(1)==4);
		assertTrue(work.getVector1().get(2)==6);
	
				
		
	}
	
	@Test
	public void testAssign() {
		
		// El vector2 tiene en todos sus elementos el valor 2, y son asignados al vector1
		 double expected=2;
		 vector1.assign(vector2);
		 assertTrue(work.getVector1().get(0)==expected);
		 assertTrue(work.getVector1().get(1)==expected);
		 assertTrue(work.getVector1().get(2)==expected);
}
	
	
	@Test
	public void testAbs() {
		double expected= 1;
		vector1.set(0,-1);
		vector1.set(1,-1);
		vector1.set(2,-1);
		// Al hace el valor absoluto del vector1 con sus valores a -1 los pasa todos a  1
		vector1.abs();
		 assertTrue(work.getVector1().get(0)==expected);
		 assertTrue(work.getVector1().get(1)==expected);
		 assertTrue(work.getVector1().get(2)==expected);
		
}
	
	@Test
	public void testAssignConMask() {
		// En el vector mask la última posición tiene un valor positivo, por tanto
		// es la única posición que se sobreescribe en Vector1 con el valor 2 del vector2  
		
		vector1.assign(mask,vector2);
		 assertTrue(work.getVector1().get(0)==1);
		 assertTrue(work.getVector1().get(1)==2);
		 assertTrue(work.getVector1().get(2)==2);
	}
	
	@Test
	public void testSum() {
		//Suma los elementos del vector1 1 + 2 +3 = 6 
		vector1.sum();
		double expected= 6;
		 assertTrue(work.getVector1().get(0)==expected);
		 
	}
	
	@Test
	public void testMax() {
		//Devuelve el máximo valor de los elementos de Vector1 (1,2,3) = máximo 3  
		vector1.max();
		double expected= 3;
		 assertTrue(work.getVector1().get(0)==expected);
		 
	}
	
	
	
	@Test
	public void testAdd() {
		// Suma los valores del vector1 (1,2,3) con los valores del vector2 uno a uno (2,2,,2)
		// y el resultado es Vector1 con (3,4,5)

		vector1.add(vector2);
		assertTrue(work.getVector1().get(0)==3);
		assertTrue(work.getVector1().get(1)==4);
		assertTrue(work.getVector1().get(2)==5);
		 
	}
	
	@Test
	public void testSet() {
		// Pone todos los elementos del vector1 con el valor pasado por parámetro en set, en este caso es 3 
		vector1.set(3);
		double expected= 3;
		assertTrue(work.getVector1().get(0)==expected);
		assertTrue(work.getVector1().get(1)==expected);
		assertTrue(work.getVector1().get(2)==expected);
		 
	}
	
	
	
}
