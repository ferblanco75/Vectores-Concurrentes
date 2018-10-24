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
import progConc.ConcurVector;
import progConc.MonitorAccionesWorker;
import progConc.Operacion;
import progConc.Worker;

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
    private double d;




    @Before

    public void setUp() throws Exception {

        buffer = new Buffer(5);
        buffer.write(1d);
        buffer.write(1d);
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

        worker2.sum();
        // Verifica que worker escribió en el buffer 2 veces //
        //verify( mockVector,times(2)).getBuffer().write(d);
        verify (dummyMonitor).contThreads();
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
        double expected = 1.00;
        //verify (mockMonitor).contThreads();
        Assert.assertEquals(expected, vector.max(),0.5);
    }

    @Test
    public void testAbs() {
        vector.set(-2,0.00);
        worker2.abs();
        int expected = 2;
        // Verifica que worker escribi� en el buffer 2 veces
        //verify( vector,times(1)).getBuffer().write(d);
        Assert.assertEquals(expected, vector.get(0), 0.5);
    }


}