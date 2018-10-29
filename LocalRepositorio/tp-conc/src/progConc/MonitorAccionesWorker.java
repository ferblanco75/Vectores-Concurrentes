package progConc;
/**
@Propósito : Es una clase que funicona como un monitor, cuyos métodos
 synchronized se ejecutan en exclusión mutua. 
*/
public class MonitorAccionesWorker {
    
	private int contThreads=0;	
	private int actual, cantThreads, n;
    private MonitorSecuenciador secuenciador  ;
	private int inicio, fin;

   
    
	public MonitorAccionesWorker() {
		actual= 0;
		cantThreads = 0;
		
		
	
	
	  }
	
	
	// public synchronized void esperar (Operacion operacion,Worker worker,int inicio, int fin, ConcurVector vector1,ConcurVector vectorModificado, int threads){
	public synchronized void esperar (Worker worker,int threads){
		this.n= threads;	
		// actual = proximo (actual );
		//this.secuenciador.esperar (operacion,worker);
		//operacion.operar(worker);	
		
		while ( actual != worker.id() ){
		try {
			wait();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	/**	
		//this.secuenciador.secuenciar(Operacion operacion,Worker worker)
		//System.out.println("Actual es= " + actual);
		//System.out.println("Soy el worker: " + worker.id());
        
		System.out.println("Soy el Worker: "+ worker.id() +" y voy desde: " + inicio+ "hasta: "+ fin  );
		
		double result1 = 0;
		double result2= 0;
			
		for (int i= inicio; i < fin; i++) {
			
			result1 = (double)vector1.get(i);
			result2= (double)vectorModificado.get(i);
			
			//this.monitor.esperar();
			
			vector1.set(i,result1*result2);
		//	this.vector1.getBuffer().write(result1 * result2);
			
		//	this.vector1.set(i,(double)this.vector1.getBuffer().read() );

			System.out.println("resultado = "+ vector1.get(i) );
		}*/
		//worker.opMul();
		actual = proximo (actual );
		//System.out.println("Soy el worker: " + worker.id()+ " y voy desde: " +   " hasta:" +);
		notifyAll();
	 }
	
	   private int proximo ( int i) { return (i+1) %(this.n); }
		     
	/**
	   @Propósito : Devuelve un entero positivo que se incrementa en uno, cada vez que
	    entra un thread worker
	   @precondition Ninguna
	   
	 */
	public synchronized int contThreads() {
		return this.contThreads++;
	}
	
	/**
	   @Propósito : Devuelve un cero, que representa que ya pasaron todos los threads workers.
	   @precondition Ninguna
	   
	 */
	public synchronized int decrementarThreads() {
		this.contThreads=0;
		return this.contThreads;
	}
	
	
	
		
	
}
