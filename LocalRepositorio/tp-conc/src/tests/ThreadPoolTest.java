<<<<<<< HEAD
package tests;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import progConc.*;

public class ThreadPoolTest {

    private ThreadPool tp;
    private ConcurVector vector;
    private ConcurVector vectorModificado;
    private Operacion operacion;
    private int dimension;
    private int threads;
    private  Thread [] workers;
    private int rango;
    private int resto;



    @Before

    public void setUp(){


        this.tp = new ThreadPool();
        this.vector =new ConcurVector(8,4);
        this.vectorModificado= new ConcurVector(8,4);
        this.operacion= new Add();
        this.dimension= vectorModificado.dimension();
        this.threads= vector.getThread();
        this.workers = new Thread [this.threads];
        this.rango= (this.dimension / this.threads);
        this.resto= (this.dimension % this.threads);


    }

    @Test
    //testeo que el threadpool se inicialize con una operacion suma y 2 vectores de diferentes dimensiones
    public void testeoQueElThreadpoolInicialice(){
        tp.initializeWorkers(operacion,vector,vectorModificado);

        Assert.assertEquals(8, vectorModificado.dimension());

    }
    @Test
    public void testeoQueElRangoDelThreadPoolSea2(){
        tp.initializeWorkers(operacion,vector,vectorModificado);

        Assert.assertEquals(2, tp.getRango());

    }






}
=======
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
	//Worker mockWorker; 
	Operacion dummyOperacion;
	Operacion operacion;
    ConcurVector vector1, dummyVector;
    Worker mockWorker;
    
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 dummyOperacion =  mock(Operacion.class);
	//	Operacion operacion= new Abs();
		vector1= new ConcurVector(7,3);
		dummyVector= mock (ConcurVector.class);
		mockWorker = mock (Worker.class) ; 
	    threadPool= new ThreadPool();
	   
	}

	@After
	public void tearDown() throws Exception {
		
		
	}

	@Test
	public void testInitializeWorkers() throws InterruptedException {
		
		threadPool.initializeWorkers(operacion,vector1,dummyVector);
		// Verifica que se instanciaron 3 Threads workers
		//verify(dummyOperacion, times(0)).operar(mockWorker);
		verify(mockWorker, atLeast(1)).start();
	}

}
>>>>>>> b96590bff97449adf17633596ba6c7140c80f2d7
