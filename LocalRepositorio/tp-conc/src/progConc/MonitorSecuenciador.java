package progConc;

public class MonitorSecuenciador {

	private int  actual,n, cantThreads= 0;
//	private MonitorBarrera barrera; 

	public MonitorSecuenciador(int n) {
		
		actual= 0;
		this.n= n;
		this.cantThreads = 0;
	//	this.barrera= new MonitorBarrera(this.n)  ;
	  }

	   public synchronized void secuenciar (Operacion operacion, Worker worker){
		
		//   operacion.operar(worker);  
		
		while ( actual != worker.id() /*this.cantThreads*/ ){
		try {
			wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
		
		//this.secuenciador.secuenciar(Operacion operacion,Worker worker)
		//System.out.println("Actual es= " + actual);
		//System.out.println("Soy el worker: " + worker.id());
		//worker.run();
		
		//operacion.operar(worker);
		//this.barrera.esperar(operacion, worker);
		
		actual = proximo (actual );
		
		//System.out.println("Soy el worker: " + worker.id()+ " y voy desde: " +   " hasta:" +);
		notifyAll();
		
		}
		
		 private int proximo ( int i) { return (i+1) %(this.n); }
}


