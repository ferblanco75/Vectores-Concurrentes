package progConc;

public class MonitorBarrera {

	
	private int actual, cantThreads, n;
	private MonitorSecuenciador secuenciador;
	
 public MonitorBarrera(int n) {
	actual= 0;
	this.n= n;
	this.cantThreads = 0;
	this.secuenciador= new MonitorSecuenciador(this.n)  ;
  }

   public synchronized void esperar (Operacion operacion,Worker worker){
	
	   actual = proximo (actual );
	  // operacion.operar(worker);
	    this.secuenciador.secuenciar(operacion, worker);
	while ( actual != this.cantThreads ){
	try {
		wait();
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	}
	
	//this.secuenciador.secuenciar(Operacion operacion,Worker worker)
	//System.out.println("Actual es= " + actual);
	//System.out.println("Soy el worker: " + worker.id());
	// worker.opMul();
	//operacion.operar(worker);
	//actual = proximo (actual );
	
	//System.out.println("Soy el worker: " + worker.id()+ " y voy desde: " +   " hasta:" +);
	notifyAll();
	
	}
	
	 private int proximo ( int i) { return (i+1) %(this.n); }
}
