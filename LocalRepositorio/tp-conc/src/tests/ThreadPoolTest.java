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
