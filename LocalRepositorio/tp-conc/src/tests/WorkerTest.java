package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import progConc.*;
import org.mockito.Mockito.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;
import progConc.ConcurVector;
import progConc.MonitorAccionesWorker;
import progConc.Operacion;
import progConc.Worker;

public class WorkerTest {

    private Operacion mockOperacion;
    private MonitorAccionesWorker dummyMonitor;
    private MonitorAccionesWorker mockMonitor;
    private ConcurVector vector1;
    private ConcurVector vector2;
    private ConcurVector mask;
    private Worker worker;
    private Worker worker2;
    private Buffer buffer;
    private Max operacionMax;
    private double d;




    @Before

    public void setUp() throws Exception {

        buffer= new Buffer(3);
        vector1= new ConcurVector (3,2); vector1.setBuffer(buffer);
        vector2= new ConcurVector (3,2); vector2.setBuffer(buffer);
        mask= new ConcurVector (3,2); mask.setBuffer(buffer);
        mockOperacion=mock(Operacion.class);
        operacionMax = mock(Max.class);
        dummyMonitor= mock(MonitorAccionesWorker.class);
        for (int i=0;i < vector1.dimension();i++ ) { double d= i+1; vector1.set(i,d);
        }
        for (int i=0;i < vector2.dimension();i++ ) { vector2.set(i,2);
        }

        mask.set(0,-1);
        mask.set(1,-1);
        mask.set(2,1);


        worker= new Worker (dummyMonitor,mockOperacion,vector1,vector2,1,0,3);
        worker2= new Worker (dummyMonitor,operacionMax,vector1,vector2,2,2,4);
        mockMonitor=mock (MonitorAccionesWorker.class);

    }


    @After

    public void tearDown() throws Exception { }

    @Test

    public void testSum() {

        //Suma los elementos del vector1 1 + 2 +3 = 6
        worker.sum();
        double expected= 6;
        assertTrue(vector2.get(0)==expected);
    }


    @Test
    public void testRun() {
        worker.run();
        // Verifica que operación ejecutó el método operar

        verify (mockOperacion, atLeast(1)).operar(worker);
    }

    @Test
    public void testAssign() {

        // El vector2 tiene en todos sus elementos el valor 2, y son asignados al vector1
        double expected=2;
        worker.assign();
        assertTrue(vector1.get(0)==expected);
        assertTrue(vector1.get(1)==expected);
        assertTrue(vector1.get(2)==expected);
    }


    @Test
    public void testAbs() {
        double expected=1;
        vector1.set(0,-1);
        vector1.set(1,-1);
        vector1.set(2,-1);
        // Al hace el valor absoluto del vector1 con sus valores a -1 los pasa todos a  1
        worker.abs();
        assertTrue(vector1.get(0)==1);
        assertTrue(vector1.get(1)==1);
        assertTrue(vector1.get(2)==1);

    }

    @Test
    public void testAssignConMask() {
        // En el vector mask la última posición tiene un valor positivo, por tanto
        // es la única posición que se sobreescribe en Vector1 con el valor 2 del vector2

        worker.assignConMask(mask);
        assertTrue(vector1.get(0)==1);
        assertTrue(vector1.get(1)==2);
        assertTrue(vector1.get(2)==2);
    }

    @Test public void testMul() {
        // Multiplica los valores del vector1 (1,2,3) con los valores del vector2 uno a uno (2,2,,2)
        // y el resultado es Vector1 con (2,4,6)
        worker.mul();
        assertTrue(vector1.get(0)==2);
        assertTrue(vector1.get(1)==4);
        assertTrue(vector1.get(2)==6);
    }
    @Test public void testAdd() {
        // Suma los valores del vector1 (1,2,3) con los valores del vector2 uno a uno (2,2,,2)
        // y el resultado es Vector1 con (3,4,5)
         worker.add();
         assertTrue(vector1.get(0)==3);
         assertTrue(vector1.get(1)==4);
         assertTrue(vector1.get(2)==5);
    }
    @Test public void testSet() {
        // Pone todos los elementos del vector1 con el valor pasado por parámetro en set, en este caso es 3 worker.set(3);
         double expected= 3;
         assertTrue(vector1.get(0)==expected);
         assertTrue(vector1.get(1)==expected);
         assertTrue(vector1.get(2)==expected);
    }


}