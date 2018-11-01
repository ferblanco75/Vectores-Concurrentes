package progConc;
/**
@Prop�sito : Es una clase que funicona como un monitor, cuyos m�todos
 synchronized se ejecutan en exclusi�n mutua. 
*/
public class MonitorAccionesWorker {
    
	private int contThreads;	
	 
   
    
	public MonitorAccionesWorker() {
		
		contThreads = 0;
		  }
	
	
	
	  /** @Prop�sito : Devuelve un entero positivo que se incrementa en uno, cada vez que
	    entra un thread worker
	   @precondition Ninguna
	   
	 */
	public synchronized int contThreads() {
		return this.contThreads++;
	}
	
	/**
	   @Prop�sito : Devuelve un cero, que representa que ya pasaron todos los threads workers.
	   @precondition Ninguna
	   
	 */
	public synchronized int decrementarThreads() {
		this.contThreads=0;
		return this.contThreads;
	}
	
	
	
		
	
}
