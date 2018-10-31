/**
 * 
 */
package progConc;

import javax.swing.JOptionPane;

/**
 @Propósito :  La clase  representa un trhead que hereda de la clase Thread
      
 */
public class Worker extends Thread {
   
	private  int contThreads=0 ;
	private ConcurVector vector1;
	
	private ConcurVector vectorModificado;
	private  int id;
	private Operacion operacion;
	private MonitorAccionesWorker monitor;
	private MonitorBarrera barrera;
	
    private ThreadPool threadPool; 
	private MonitorSecuenciador secuenciador;
	
	private Buffer buffer;
	
	    
    /**
    @Propósito : Constructor del worker 
   	@Param monitor. es una clase monitor que regula el comportamiento del worker
	@Param operacion. Representa la tarea que a a ser realizada por el worker
	@Param operacion. Representa la tarea que a a ser realizada por el worker
	@Param vector y vectorModificado. Son clases que representan vectores sobre los cuales los workers van a operar con sus elementos
	@Param id. Es un entero positivo que representa el Id único de cada worker al ser inicializado
	@Param inicio. Es un entero positivo que indica a partir de que posición del vector cada worker va a operar con sus elementos  
	@Param fin. Es un entero positivo que indica la posición del vector que cada worker debe finalizar su ejecución.  
	*/
    
	
	public Worker (Buffer buffer,MonitorSecuenciador secuenciador,MonitorBarrera barrera,Operacion operacion, int id ) {
	
	this.buffer= buffer;
	this.secuenciador= secuenciador;
	this.barrera= barrera;
  	
	this.operacion= operacion;
	
	this.id= id;
	

	}

	public int id() {
		return this.id;
	}
	
	
public  void operacion1() {
		
		Work work	= (Work) this.buffer.read();	
				 		
		 System.out.println("el work" + "va desde: " + work.getInicio()+ "  hasta: "+ work.getFin() ); 		
		 
		    				
			System.out.println("A");
			
			System.out.println("B");
			System.out.println("C");
			System.out.println("D");
			  

}
				
	
	
		
	
	/** Obtiene el valor absoluto de cada elemento del vector.*/ 
	public void abs() {
		
		Work work	= (Work) this.buffer.read();	
		for (int i= work.getInicio() ; i < work.getFin(); i++) {
						
				
			work.getVector1().set(i, Math.abs(work.getVector1().get(i)));	
		}
	}
	
	 
	
	 /** Obtiene el valor promedio en el vector. */
	public void sum(){
		Work work	= (Work) this.buffer.read();
		double result = 0;
		
	   this.contThreads=this.monitor.contThreads();  	
		
	    
	   for (int i= work.getInicio() ; i < work.getFin(); i++) {
			result += work.getVector1().get(i);
			
		} 
	    	    
	    
		work.getVectorModificado().set (contThreads,result);
		
  
	     if (this.contThreads == this.vector1.getThread() -1) {
		
		     this.contThreads=this.monitor.decrementarThreads();
		   
	   }
     	      
	 } 
	
	 /** Obtiene el valor maximo en el vector.*/ 
	
	  public void max() {
		  Work work	= (Work) this.buffer.read();	        
       double current_max = work.getVector1().get(0);
		
 	   this.contThreads=this.monitor.contThreads();  	
 		
 	    
 	  for (int i= work.getInicio() ; i < work.getFin(); i++) {
 	    	current_max = Math.max(current_max, work.getVector1().get(i));
 			
 		} 
 	    	    
 		 		
 		work.getVectorModificado().set (contThreads,current_max);
 		
 			   	  	   	  
 	     if (this.contThreads == this.vector1.getThread() -1) {
 		
 		     this.contThreads=this.monitor.decrementarThreads();
 		     	 		     
 	     } 
 	    
	}
	
	/** Pone el valor d en todas las posiciones del vector. 
	 * @param d, el valor a ser asignado. */
	  public  void set(double d) {
		
		  Work work	= (Work) this.buffer.read();	
		
		  for (int i= work.getInicio() ; i < work.getFin(); i++) {
		  	  
		   	   work.getVector1().set(i, d);	
		   
	}
}
	
	
	/** Propósito: Copia los valores de otro vector sobre este vector.*/
	 
	public void assign() {
		Work work	= (Work) this.buffer.read();	
		for (int i= work.getInicio() ; i < work.getFin(); i++) {
				 		   
		  
		  work.getVector1().set(i, work.getVectorModificado().get(i));
		   
		}
	}
	
	
	/** Copia algunos valores de otro vector sobre este vector.
	 * Un vector mascara indica cuales valores deben copiarse.
	 * @param mask, vector que determina si una posicion se debe copiar.
	 * @param v, el vector del que se tomaran los valores nuevos.
	 * @precondition dimension() == mask.dimension() && dimension() == v.dimension().*/ 
	
	    public void assignConMask(ConcurVector mask)	 {
				
		Work work	= (Work) this.buffer.read();	
		for (int i= work.getInicio() ; i < work.getFin(); i++) {
		
			if (mask.get(i) >= 0){
		
			 work.getVector1().set(i, work.getVectorModificado().get(i));
		    }	
		}
	
	}
	/** Propósito: Multiplica los elementosde un vector con otro uno a uno
	 */ 
	 
	public  void mul() {
		       
  		double result1 = 0;
		double result2= 0;
			
		Work work	= (Work) this.buffer.read();	
		for (int i= work.getInicio() ; i < work.getFin(); i++) {
			
			result1 = work.getVector1().get(i);
			result2= work.getVectorModificado().get(i);
			
									
			work.getVector1().set(i,(result1 * result2) );

		
			
		}
	}
	
	
	
	
	/** Propósito: Suma los elementosde un vector con otro uno a uno
	 */ 
	 
		public void add() {
		    
		       	double result1 = 0;
				double result2= 0;
				
				Work work	= (Work) this.buffer.read();	
				for (int i= work.getInicio() ; i < work.getFin(); i++) {
					
					
					result1 = work.getVector1().get(i);
					result2= work.getVectorModificado().get(i);
											
					
					work.getVector1().set(i,(result1 + result2) );
		    	
		   	       
		}
		
		}
		
		
		/** Propósito: Ejecuta la operacion en cuestión, es invocada desde el mensaje start()
		 * 
		 */	
	//public void run () {
		
   // operacion.operar(this);
    // this.secuenciador.secuenciar(operacion, this);
    // this.barrera.esperar(/*operacion,this*/);
//	}	
		


}

