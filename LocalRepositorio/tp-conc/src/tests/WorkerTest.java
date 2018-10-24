<<<<<<< HEAD
package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import progConc.*;
import org.mockito.Mockito.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;

public class WorkerTest {

    private Operacion dummyOperacion;
    private MonitorAccionesWorker dummyMonitor;
    private MonitorAccionesWorker mockMonitor;
    private ConcurVector mockVector;
    private ConcurVector vector;
    private Worker worker;
    private Worker worker2;
    private Buffer buffer;
    private Max operacionMax;


 /*   private Worker worker1;
    private Worker worker2;
    private Worker worker3;
    private Worker worker4;
    private Buffer buffer;
    private MonitorAccionesWorker unMonitor;
    private Operacion operacionSum;
    private Operacion operacionMul;
    private Operacion operacionSet;
    private Operacion operacionAbs;
    private ConcurVector vector;
    private ConcurVector vectorAux;
    private int id1;
    private int id2;
    private int id3;
    private int id4;
    private int unInicio;
    private int unFin;
    private double nro;


    @Before

    public void setUp() {

        this.buffer = new Buffer(5);
        this.nro = 8.00;
        this.unMonitor = new MonitorAccionesWorker();
        this.operacionSum = new Add();
        this.operacionMul = new Mul();
        this.operacionAbs = new Abs();
        this.operacionSet = new Set(nro);
        this.vector = new ConcurVector(6, 3);
        this.vector.setBuffer(buffer);
        this.vectorAux = new ConcurVector(6, 3);
        this.id1 = 1;
        this.id2 = 2;
        this.id3 = 3;
        this.id4 = 4;
        this.unInicio = 1;
        this.unFin = 4;
        this.worker1 = new Worker(unMonitor,operacionSum, vector, vectorAux, id1, unInicio, unFin );
        this.worker2 = new Worker(unMonitor,operacionMul, vector, vectorAux, id2, unInicio, unFin );
        this.worker3 = new Worker(unMonitor,operacionAbs, vector, vectorAux, id3, unInicio, unFin );
        this.worker4 = new Worker(unMonitor,operacionSet, vector, vectorAux, id4, unInicio, unFin );

    }

    @Test
    public void testeoSum(){

        this.worker1.sum();

        Assert.assertEquals(this.vector.norm(), 5);

    }
*/

    @Before

    public void setUp() throws Exception {

        buffer = new Buffer(5);
        buffer.write(1);
        buffer.write(1);
        dummyOperacion=mock(Operacion.class);
        operacionMax = mock(Max.class);
        dummyMonitor= mock(MonitorAccionesWorker.class);
        vector = new ConcurVector(6, 3);
        vector.setBuffer(buffer);
        mockVector= mock (ConcurVector.class);
        mockVector.setBuffer(buffer);
        worker= new Worker (dummyMonitor,dummyOperacion,mockVector,mockVector,1,0,2);
        worker2= new Worker (dummyMonitor,operacionMax,vector,mockVector,2,2,4);
        mockMonitor=mock (MonitorAccionesWorker.class);

    }


    @After

    public void tearDown() throws Exception { }

    @Test

    public void testSum() {

        worker.sum();
        // Verifica que worker escribió en el buffer 2 veces //
        //verify( mockVector,times(2)).getBuffer().write(d);
        verify (mockMonitor).contThreads();
    }

    @Test

    public void testRun() {
        worker.run();
        // Verifica que worker escribió en el buffer 2 veces
        // verify( mockVector,times(2)).getBuffer().write(d);
         verify (dummyOperacion, atLeast(1)).operar(worker);
        }

    @Test

    public void testMax() {
        worker2.max();
        double expected = 4.00;
        //verify (mockMonitor).contThreads();
        Assert.assertEquals(expected, vector.max());
    }



=======
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
		// Verifica que worker escribi� en el buffer 2 veces
		  verify( mockVector,times(2)).getBuffer().write(d);

}
	
>>>>>>> b96590bff97449adf17633596ba6c7140c80f2d7
}