/**
 * 
 */
package progConc;

/**
 * @author COMMODORE1
 *
 */
public class Worker extends Thread {
   private int contThreads =0;
	private ConcurVector vector1;
	private ConcurVector auxVector;
	private SeqVector vector2;
	private int rango;
	//private final Buffer buffer ;
	private  int id;
	private int inicio;
	private int fin;
	private Operacion operacion;
	private MonitorAccionesWorker monitor;
     
	
	public Worker ( MonitorAccionesWorker monitor,Operacion operacion,ConcurVector vector,int id, int inicio, int fin ) {
	
	this.monitor= monitor;
	this.operacion= operacion;
	this.vector1= vector;
	this.vector2= vector.getVector();
	this.id= id;
	this.inicio= inicio;
	this.fin= fin;
	this.rango= vector1.dimension()/vector1.load();
	
	}

		
	public void sum(){
	
	while (this.rango > 1) {	
	  
		double result = 0;
		
	    this.contThreads=this.monitor.contThreads();  	
		if (contThreads==0) {
			   this.auxVector = new  ConcurVector(vector1.getThread(),vector1.load());
			   System.out.println("la dimension del auXvector es de := " + this.auxVector.dimension() );	     
		}
		for (int i= this.inicio; i < this.fin; i++) {
		result += vector1.get(i);
		
	} 
		
		
		System.out.println("Soy el hilo " + this.id+ " voy de :" + this.inicio +"a: " + this.fin+ "y mi contThreads ea: = " + contThreads );
				
		
	   this.vector1.getBuffer().write(result);
	 
	   //this.auxVector.set (contThreads,(double)this.vector1.getBuffer().read());
	
	  	   	  
	   if (contThreads == this.vector1.getThread() -1) {
		   System.out.println("Soy el hilo " + this.id+ " voy de :" + this.inicio +"a: " + this.fin+ "y mi contThreads es el último: = " + contThreads );	   
   
	    
		    for ( int i =0; i < this.vector1.getThread();i++) {
		    	 this.contThreads=this.monitor.decrementarThreads();
		    }
		    this.vector1= this.auxVector;
		    this.auxVector=null;
		    vector1.getThreadPool().initializeWorkers(this.operacion, this.vector1, this.vector1.getThread());
	   }
	  
	}
	}
	
	
	public  void mul() {
		for (int i= this.inicio; i < this.fin; i++) {
		    	
			vector1.set(i, vector1.get(i) * vector2.get(i));
			System.out.println( "vector1 ["+ i+"]"  + vector1.get(i));
			 		System.out.println( );
			 		System.out.println(); 
		}
		}

		
		public void add() {
		    for (int i= this.inicio; i < this.fin; i++) {
		         vector1.set(i,  vector1.get(i)+ vector2.get(i));
		         System.out.println( "vector1 ["+ i+"]"  + vector1.get(i));
		 		System.out.println( );
		 		System.out.println(); 	
		}
		
		}
	public void run () {
	
	  this.operacion.operar(this);
	
		
	}
}
	



