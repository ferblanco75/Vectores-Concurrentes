/**
 * 
 */
package progConc;
import javax.swing.JOptionPane;

public class ConcurVector {
	/** La clase representa un vector de longitud fija de 
	 * numeros de punto flotante. */

	private static int load= 2;
	private int dimension, threads;
	private MonitorAccionesConcurVector monitorVector= new MonitorAccionesConcurVector();
	
	// El array con los elementos del vector
	private double [] elements;
	private ThreadPool threadPool;
	private Buffer buffer;
	
	
		
	/** Constructor del ConcurVector.
	 * @param dimension, la longitud del vector.
	 * @precondition dimension > 0. */
	public ConcurVector(int dimension, int threads) {
		
	     	this.dimension= dimension;
			this.elements= new  double[dimension];
			this.threadPool=  new ThreadPool ();
			this.threads= threads;
		
	}			
		

	public int load() {
		return this.load;
	}
	
	// Se configura el Buffer
	public void setBuffer(Buffer buffer) {
		this.buffer= buffer;
		}
	
	// Devuelve un  Buffer
	public Buffer getBuffer(){
	   return this.buffer;
    }
	
		
	// Devuelve el numero de threads del vector
	public int getThread() {
		return this.threads;
	}
	
	//Deuelve un Thread Pool
	public ThreadPool getThreadPool(){
		return this.threadPool;
	}
	
		
	/** Retorna la longitud del vector; es decir, su dimension. */
	public int dimension() {
		return elements.length;
	 }
	
	
	/** Retorna el elemento del vector en la posicion i.
	 * @param i, la posicion del elemento a ser retornado.
	 * @precondition 0 <= i < dimension(). */
	 public double get(int i) {
		return elements[i];
	}
	
	
	/** Pone el valor d en la posicion i del vector. 
	 * @param i, la posicion a setear.
	 * @param d, el valor a ser asignado en la posicion i.
	 * @precondition 0 <= i < dimension. */
	 public void set(int i, double d) {
		elements[i] = d;
	}
	
	/*******************Desde aquí Comienzan la Operaciones concurentes ******************/
	
	 

	 /** Obtiene el valor absoluto de cada elemento del vector. */
	public synchronized void abs() {
		
		if ( ! (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())){
				
		
		Operacion operacion= new Abs() ;	
		
		ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
					
		this.threadPool.initializeWorkers(operacion,this,aux);
		
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Abs");
			 
	       } 
	}

		
	 /** Obtiene el valor promedio en el vector. */
	
	public synchronized double mean() {
		if ( ! (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())){
		
        	double total = this.sum();
        	return total / this.dimension();
        	
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Mean");
			return 0;
	       } 
	}
    
	
	 
	/** Retorna el producto de este vector con otro.
     * El producto vectorial consiste en la suma de los productos
     * de cada coordenada.
	 * @param v, el vector a usar para realizar el producto.
	 * @precondition dimension() == v.dimension(). */
	public synchronized double prod(ConcurVector v) {
		if ( ! (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())){
		
		ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
		aux.setBuffer(this.getBuffer());
		aux.assign(this);
		aux.mul(v);
		return aux.sum();
		
}
		
		else {
			JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Prod");
			return 0;
	       } 
	}
	
	
	/** Retorna la norma del vector.
     *  Recordar que la norma se calcula haciendo la raiz cuadrada de la
     *  suma de los cuadrados de sus coordenadas.
     */
	public synchronized double norm() {
		if ( ! (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())){
		
		ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
		aux.setBuffer(this.getBuffer());
		aux.assign(this);
		aux.mul(this);
		return Math.sqrt(aux.sum());
		
}
		
		else {
			JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Norm");
			return 0;
	       } 
	}
	
	
		
	/** Pone el valor d en todas las posiciones del vector. 
	 * @param d, el valor a ser asignado. */
	
	public synchronized void set(double d) {
		if ( ! (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())){
	
			ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
			
		     Operacion operacion= new Set(d) ;	
		
	          this.threadPool.initializeWorkers(operacion,this,aux);
	          
}
		
		else {
			JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Set (d)");
			
	       } 
	}
	
	
	/** Copia los valores de otro vector sobre este vector.
	 * @param v, el vector del que se tomaran los valores nuevos.
	 * @precondition dimension() == v.dimension(). */
	public synchronized void assign(ConcurVector vector) {
		if ( ! ((this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())
				|| (vector.dimension()<=0 || vector.getThread()<=0 || vector.dimension()< vector.getThread()) ) ) {
		
			Operacion operacion= new Assign() ;	
		
		    this.threadPool.initializeWorkers(operacion,this,vector);
		    
		}	
		else {
			JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Assign");
			 
	       } 
	}
	
	
	public synchronized void assign(ConcurVector mask, ConcurVector vector){ 
		
		if ( ! (   (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())
			|| (mask.dimension()<=0 || mask.getThread()<=0 || mask.dimension()< mask.getThread())  
			|| (vector.dimension()<=0 || vector.getThread()<=0 || vector.dimension()< vector.getThread())  )  ){
		
			Operacion operacion= new AssignConMask(mask) ;	
			
		    this.threadPool.initializeWorkers(operacion,this,vector);
	}	
		else {
			JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación AssignConMask");
			 
	       } 
			
	}
	
	/** Multiplica los valores de este vector con los de otro
     *  (uno a uno).
	 * @param v, el vector con los valores a multiplicar.
	 * @precondition dimension() == v.dimension(). */
	  public synchronized void mul(ConcurVector vector) {
		  if ( ! ((this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())
					|| (vector.dimension()<=0 || vector.getThread()<=0 || vector.dimension()< vector.getThread())) ) {
		 	 
		  Operacion operacion= new Mul();	
				
			 this.threadPool.initializeWorkers(operacion,this,vector);
					  	  
		  }
		 
		  else {
				JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Mul");
				
		       } 
			
	}	
	
	
	/** Suma los valores de este vector con los de otro (uno a uno).
	 * @param v, el vector con los valores a sumar.
	 * @precondition dimension() == v.dimension(). */
	 public synchronized void add(ConcurVector vector) {
		 if ( ! ((this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())
					|| (vector.dimension()<=0 || vector.getThread()<=0 || vector.dimension()< vector.getThread())) ) {
		
		 Operacion operacion= new Add();
			
		this.threadPool.initializeWorkers(operacion,this,vector);
		
		 }
		 
		  else {
				JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Add");
				
		       } 
		
	}
	
		
	/** Obtiene la suma de todos los valores del vector. */
	   public synchronized double sum() {
		   if ( ! (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())){
		   int rango;
		   int diferenciaThreadsRango=1;
		   Operacion operacion= new Sum();	
			  	   
		   ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
		  
			 aux.setBuffer(this.getBuffer());
			 aux.assign(this);
		     rango= aux.dimension()/aux.getThread();
		   
		
			  while (aux.dimension() > 1) {
		
	     	     if (rango != aux.getThread()) {
	 	   	          diferenciaThreadsRango = Math.abs(aux.getThread() -  rango); 
		         }
		    		  
		    ConcurVector auxModificado = new ConcurVector(aux.getThread(),diferenciaThreadsRango);
		    
		    auxModificado.setBuffer(this.getBuffer());
		    this.threadPool.initializeWorkers(operacion,aux,auxModificado);
		  		 		
		   aux= auxModificado;
		   rango= aux.dimension()/aux.getThread(); 
			
	}	
	  		  
	 return ( aux.get(0)); 
  
		  
	   }   
			 
			  else {
					JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Sum");
					return 0;
			       } 
		 
}
	   /** Obtiene el valor maximo en el vector. */
	   public synchronized double max() {
		   if ( ! (this.dimension()<=0 || this.getThread()<=0 || this.dimension()< this.getThread())){  
		   int rango;
		   int diferenciaThreadsRango=1;
		   Operacion operacion= new Max();	
	  		    
	    ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
	  
	      aux.setBuffer(this.getBuffer());
		  aux.assign(this);
	    
	     rango= aux.dimension()/aux.getThread();
	   
	               while (aux.dimension() > 1) {
			
	            	   if (rango != aux.getThread()) {
	     			      diferenciaThreadsRango = Math.abs(aux.getThread() -  rango); 
	     		     }
	            	   ConcurVector auxModificado = new ConcurVector(aux.getThread(),diferenciaThreadsRango);
	            	   auxModificado.setBuffer(this.getBuffer());
	         		  this.threadPool.initializeWorkers(operacion,aux,auxModificado);
	         		  		 		
	         		   aux= auxModificado;
	         		   rango= aux.dimension()/aux.getThread(); 
	
   }	
	 	  		  
	  return ( aux.get(0));
		   }   
			 
			  else {
					JOptionPane.showMessageDialog(null, "Número inválido, no se puede realizar la operación Max");
					return 0;
			       } 
	   
 
}
}	   
	   