import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import progConc.*;
//package tests;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.Abs;
import progConc.ConcurVector;
import progConc.Operacion;
import progConc.ThreadPool;
import progConc.Worker;

import static org.mockito.Mockito.*;



    public class ThreadPoolTest {

        Buffer buffer;
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
            buffer= new Buffer(3);
            dummyOperacion = mock(Operacion.class);
            operacion= new Abs();
            vector1 = new ConcurVector(7, 3);vector1.setBuffer(buffer);
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
            verify(mockWorker, times(5)).join();

        }

    }

