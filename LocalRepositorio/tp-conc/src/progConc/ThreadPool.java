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
	private Buffer buffer;

	
	/** La clase se encarga de instanciar e iniciar la cantidad de workers correspondientes
	 * a los valores de los parámetros  threads y load. 
	 * @param buffer */

	public ThreadPool(int threads, Buffer buffer, MonitorAccionesWorker monitor) {
				
		this.inicio= 0;
		this.fin= 0;
		this.threads = threads;
		this.buffer= buffer;
		this.monitor=monitor;
		
			
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
             
         	public void initializeWorkers(Operacion operacion) {
     		
     			this.operacion= operacion;
     			
     		     			
     			this.workers = new Worker [this.threads];
     			
     			this.barrera= new MonitorBarrera(this.threads);
     		
     			this.secuenciador= new MonitorSecuenciador(this.threads);
     			
     		
     		
     			
     			for (int i= 0; i < this.threads; i++) {
     			
     		
     			
     			 this.workers[i]= new Worker (this.buffer, this.monitor,this.operacion, i);
     			 	 		
     			    			
     		    		  
     		     	    
     		}
                  for (int i= 0; i < this.threads; i++) {
                 	
                 	 this.workers[i].start();
                 	operacion.operar(this.workers[i]);
                 	// this.barrera.esperar(/*operacion,this.workers[i]*/);
                 	// this.secuenciador.secuenciar(this.operacion, this.workers[i]);
                 	 				
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


		
		
	
	
		
			

		
		
		
		


