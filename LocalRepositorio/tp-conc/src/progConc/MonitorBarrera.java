package progConc;

public class MonitorBarrera {

	
	private int actual, cantThreads, n;
		
 public MonitorBarrera(int n) {
	actual= 0;
	this.n= n;
	this.cantThreads = 0;
	
  }

   public synchronized void esperar (){
	
	   actual = proximo (actual );
	 // operacion.operar(worker);
	   
	
	while ( actual != this.cantThreads ){
	try {
		wait();
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	}
	
	
	//operacion.operar(worker);
	notifyAll();
	
	}
	
	 private int proximo ( int i) { return (i+1) %(this.n); }
}
