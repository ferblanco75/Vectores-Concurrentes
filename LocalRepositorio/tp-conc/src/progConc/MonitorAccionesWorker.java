package progConc;
/**
@Propósito : Es una clase que funicona como un monitor, cuyos métodos
 synchronized se ejecutan en exclusión mutua. 
*/
public class MonitorAccionesWorker {
    
	private int contThreads;	
	 
   
    
	public MonitorAccionesWorker() {
		
		contThreads = 0;
		  }
	
	
	
	  /** @Propósito : Devuelve un entero positivo que se incrementa en uno, cada vez que
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
