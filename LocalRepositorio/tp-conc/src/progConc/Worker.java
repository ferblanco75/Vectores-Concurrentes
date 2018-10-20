/**
 * 
 */
package progConc;

/**
 @Prop�sito :  La clase  representa un trhead que hereda de la clase Thread
      
 */
public class Worker extends Thread {
   
	private  int contThreads=0 ;
	private ConcurVector vector1;
	private ConcurVector vectorModificado;
	private  int id;
	private int inicio;
	private int fin;
	private Operacion operacion;
	private MonitorAccionesWorker monitor;
    
    
    /**
    @Prop�sito : Constructor del worker 
   	@Param monitor. es una clase monitor que regula el comportamiento del worker
	@Param operacion. Representa la tarea que a a ser realizada por el worker
	@Param operacion. Representa la tarea que a a ser realizada por el worker
	@Param vector y vectorModificado. Son clases que representan vectores sobre los cuales los workers van a operar con sus elementos
	@Param id. Es un entero positivo que representa el Id �nico de cada worker al ser inicializado
	@Param inicio. Es un entero positivo que indica a partir de que posici�n del vector cada worker va a operar con sus elementos  
	@Param fin. Es un entero positivo que indica la posici�n del vector que cada worker debe finalizar su ejecuci�n.  
	*/
    
	
	public Worker ( MonitorAccionesWorker monitor,Operacion operacion,ConcurVector vector,ConcurVector vectorModificado,int id, int inicio, int fin ) {
		
	this.monitor= monitor;
	this.operacion= operacion;
	this.vector1= vector;
	this.vectorModificado= vectorModificado;
	this.id= id;
	this.inicio= inicio;
	this.fin= fin;
	

	}

	/** Obtiene la suma de todos los elementos del vector. */
	
	public void sum(){
	
		 
		double result = 0;
		
	   this.contThreads=this.monitor.contThreads();  	
		
	    
	    for (int i= this.inicio; i < this.fin; i++) {
			result += this.vector1.get(i);
			
		} 
	    	    
				
	    this.vector1.getBuffer().write(result);
		
		this.vectorModificado.set (contThreads,(double)this.vector1.getBuffer().read());
		
			   	  	   	  
	     if (this.contThreads == this.vector1.getThread() -1) {
		
		     this.contThreads=this.monitor.decrementarThreads();
		   
	   }
         
	      
	 } 
	
	 /** Obtiene el valor maximo en el vector. */
	
	public void max() {
        
	        
        double current_max = 0;
		
 	   this.contThreads=this.monitor.contThreads();  	
 		
 	    
 	    for (int i= this.inicio; i < this.fin; i++) {
 	    	current_max = Math.max(current_max, vector1.get(i));
 			
 		} 
 	    	    
 		 		
 	    this.vector1.getBuffer().write(current_max );
 		
 		this.vectorModificado.set (contThreads,(double)this.vector1.getBuffer().read());
 		
 			   	  	   	  
 	     if (this.contThreads == this.vector1.getThread() -1) {
 		
 		     this.contThreads=this.monitor.decrementarThreads();
 		     	 		     
 	     } 
 	    
	}
	
	/** Pone el valor d en todas las posiciones del vector. 
	 * @param d, el valor a ser asignado. */
	public  void set(double d) {
				
		for (int i= this.inicio; i < this.fin; i++) {
		   this.vector1.set(i, d);	
			
	}
}
	
	
	/** Prop�sito: Copia los valores de otro vector sobre este vector.
	 */
	public void assign() {
		
		for (int i= this.inicio; i < this.fin; i++) 
			this.vector1.set(i, vectorModificado.get(i));
	}
	
	
	/** Prop�sito: Multiplica los elementosde un vector con otro uno a uno
	 * 
	 */
	public  void mul() {
		
		double result1 = 0;
		double result2= 0;
		
		for (int i= this.inicio; i < this.fin; i++) {
			
			result1 = (double)this.vector1.get(i);
			result2= (double)this.vectorModificado.get(i);
			
			this.vector1.getBuffer().write(result1 * result2);
			
			this.vector1.set(i,(double)this.vector1.getBuffer().read() );
						
		}
		}

	/** Prop�sito: Suma los elementosde un vector con otro uno a uno
	 * 
	 */
		public void add() {
		    
		       	double result1 = 0;
				double result2= 0;
				
				for (int i= this.inicio; i < this.fin; i++) {
					
					result1 = (double)this.vector1.get(i);
					result2= (double)this.vectorModificado.get(i);
					
					this.vector1.getBuffer().write(result1 + result2);
					
					this.vector1.set(i,(double)this.vector1.getBuffer().read() );	
		    	
		   	       
		}
		
		}
		
		
		/** Prop�sito: Ejecuta la operacion en cuesti�n, es invocada desde el mensaje start()
		 * 
		 */	
	public void run () {
	
	  this.operacion.operar(this);
	
		
	}
}
	



