package progConc;

public class MonitorAccionesConcurVector {


private int actual, cantThreads, n;
private MonitorSecuenciador secuenciador  ;

public MonitorAccionesConcurVector() {
	actual= 0;
	//this.n= actual +1;
	this.cantThreads = 1;
	//this.secuenciador= new MonitorSecuenciador(this.n)  ;
}

public synchronized void esperar ( ThreadPool threadPool,Operacion operacion,ConcurVector vector, ConcurVector aux){

 	
   //actual = proximo (actual );


while ( actual != this.cantThreads ){
try {
	wait();
} catch (InterruptedException e) {
	
	e.printStackTrace();
}
}


System.out.println("Actual es= " + actual);

 threadPool.initializeWorkers(operacion,vector,aux);
actual ++ ;

notifyAll();

}

 //private int proximo ( int i) { return (i+1) %(this.n); }
 
}