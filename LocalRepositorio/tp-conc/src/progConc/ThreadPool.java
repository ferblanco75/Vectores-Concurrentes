package progConc;

public class ThreadPool {
	
	private ConcurVector vector;
	private int dimension;
	private int threads;
	private int load;
	private int inicio;
	private int fin;
	private int rango;
	private int resto;
	private  Thread [] workers;
	private Worker worker;
	private Operacion operacion;
	private MonitorAccionesWorker monitor;
	
	public ThreadPool() {
				
		
		this.load = 2;
		this.inicio= 0;
		this.fin= 0;
		this.monitor= new MonitorAccionesWorker();
		
		
	}
		
		public void initializeWorkers(Operacion operacion,ConcurVector vector,int threads) {
			this.vector =vector;
			this.operacion= operacion;
			this.dimension= vector.dimension();
			this.threads= threads;
			this.workers = new Thread [this.dimension];
			this.rango= (this.workers.length / this.threads);
			this.resto= (this.workers.length % this.threads); 
			System.out.println("La dimension del vector es : "+ this.workers.length );
			System.out.println("La cantidad de threads es:  " + this.threads );
			System.out.println("El rango es:  " + this.rango);
			System.out.println("el resto es:  " + this.resto );
			
			this.inicio= 0;
			this.fin = this.rango;
			
			for (int i= 0; i < this.threads; i++) {
			
			if ( i >= (this.threads - this.resto)) {
				this.fin ++;
			}
			
			 this.workers[i]= new Worker (monitor, this.operacion,this.vector,i,this.inicio,this.fin);
			 this.workers[i].start();
			
			 this.inicio= this.fin;
		     this.fin = this.fin + this.rango;
			    
		}
			
			for (int i= 0; i < this.threads; i++) {
		
				try {
					this.workers[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
      
        
		}	
		
		
}	
		
		
		
		


