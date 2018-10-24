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
	private  Thread [] workers;
	private Operacion operacion;
	private MonitorAccionesWorker monitor;
	
	
	/** La clase se encarga de instanciar e iniciar la cantidad de workers correspondientes
	 * a los valores de los par�metros  threads y load. 
	 * @param buffer */

	public ThreadPool() {
				
		this.inicio= 0;
		this.fin= 0;
		this.monitor= new MonitorAccionesWorker();
			
	}

	public int getRango(){
		return this.rango;
	}
	
		
	/** Inicializa e innstancia los workers
	 * @param Operacion, es la operacion que van a realizar los workers
	 * @param auxVector, es la instancia de la clase que representa el vector que dispara la operacion
	 * @param auxVectorModificado, es la instancia de la clase que representa el vector que en general fue pasado por par�metro por la operacion
	 * @precondition  Ambos vectores tienen la misma dimension
	 */
		public void initializeWorkers(Operacion operacion,ConcurVector auxVector,ConcurVector auxVectorModificado) {
			this.vector =auxVector;
			this.vectorModificado= auxVectorModificado;
			this.operacion= operacion;
			this.dimension= auxVector.dimension();
			this.threads= auxVector.getThread();
			this.workers = new Thread [this.threads];
			this.rango= (this.dimension / this.threads);
			this.resto= (this.dimension % this.threads); 
			
			
														
			this.inicio= 0;
			this.fin = this.rango;
			
			for (int i= 0; i < this.threads; i++) {
			
			if ( i >= (this.threads - this.resto)) {
				this.fin ++;
			}
			
			 this.workers[i]= new Worker (this.monitor, this.operacion,this.vector,this.vectorModificado,i,this.inicio,this.fin);
			 			
			 this.inicio= this.fin;
		     this.fin = this.fin + this.rango;
			    
		}
			
			for (int i= 0; i < this.threads; i++) {
				this.workers[i].start();
			}
			
                for (int i= 0; i < this.threads; i++) {
				
				try {
					this.workers[i].join();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		      }
			
			}
			
				
		
		}	
			
 
	
	
		
			

		
		
		
		


