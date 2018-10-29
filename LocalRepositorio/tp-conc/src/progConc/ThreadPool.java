package progConc;

import javax.swing.JOptionPane;

public class ThreadPool {
	
	private ConcurVector vector;
	private ConcurVector vectorModificado;
	private int dimension;
	private int threads;
	private int inicio;
	private int fin;
	private int rango;
	private int resto;
	
	private  Worker [] workers;
	private Operacion operacion;
	private MonitorAccionesWorker monitor;
	private MonitorBarrera barrera;
	private MonitorSecuenciador secuenciador;
	

	
	/** La clase se encarga de instanciar e iniciar la cantidad de workers correspondientes
	 * a los valores de los parámetros  threads y load. 
	 * @param buffer */

	public ThreadPool() {
				
		this.inicio= 0;
		this.fin= 0;
		
		
			
	}
	
	public int getFin() {
		return this.fin;
	}
	
	public int getRango() {
		return this.rango;
	}
	
	 
	/** Inicializa e innstancia los workers
	 * @param Operacion, es la operacion que van a realizar los workers
	 * @param auxVector, es la instancia de la clase que representa el vector que dispara la operacion
	 * @param auxVectorModificado, es la instancia de la clase que representa el vector que en general fue pasado por parámetro por la operacion
	 * @precondition  Ambos vectores tienen la misma dimension
	 */
		public void initializeWorkers(Operacion operacion,ConcurVector auxVector,ConcurVector auxVectorModificado) {
			this.vector =auxVector;
			this.vectorModificado= auxVectorModificado;
			this.operacion= operacion;
			this.dimension= auxVector.dimension();
			this.threads= auxVector.getThread();
			
			this.workers = new Worker [this.threads];
			this.rango= (this.dimension / this.threads);
			this.resto= (this.dimension % this.threads); 
			this.barrera= new MonitorBarrera(this.threads);
			this.monitor= new MonitorAccionesWorker();
			this.secuenciador= new MonitorSecuenciador(this.threads);
			
			
			this.inicio= 0;
			this.fin = this.rango;
			
			for (int i= 0; i < this.threads; i++) {
			
			if ( i >= (this.threads - this.resto)) {
				this.fin ++;
			}
			
			 this.workers[i]= new Worker (this.secuenciador,this.barrera,this.monitor, this.operacion,this.vector,this.vectorModificado, i,this.inicio,this.fin);
			 	 		
			 
			 this.inicio= this.fin;
		     this.fin = this.fin + this.rango;
		     
		    		  
		     	    
		}
             for (int i= 0; i < this.threads; i++) {
            	
            	 this.workers[i].start();
            	 this.secuenciador.secuenciar(this.operacion, this.workers[i]);
            	 				
		   } 
             
          
            
			/*		
            for (int i= 0; i < this.threads; i++) {
				
				try {
					this.workers[i].join();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
            }
            */
		}			
		
		
}		


		
		
	
	
		
			

		
		
		
		


