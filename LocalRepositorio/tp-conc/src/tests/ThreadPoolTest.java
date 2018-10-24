import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import progConc.*;
//package tests;
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
            dummyOperacion = mock(Operacion.class);
            //	Operacion operacion= new Abs();
            vector1 = new ConcurVector(7, 3);
            dummyVector = mock(ConcurVector.class);
            mockWorker = mock(Worker.class);
            threadPool = new ThreadPool();

        }

        @After
        public void tearDown() throws Exception {


        }

        @Test
        public void testInitializeWorkers() throws InterruptedException {

            threadPool.initializeWorkers(operacion, vector1, dummyVector);
            // Verifica que se instanciaron 3 Threads workers
            //verify(dummyOperacion, times(0)).operar(mockWorker);
            verify(mockWorker, atLeast(1)).start();
        }

    }

