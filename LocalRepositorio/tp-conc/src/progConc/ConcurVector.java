/**
 * 
 */
package progConc;

/**
 * @author COMMODORE1
 *
 */
public class ConcurVector {
	/** La clase representa un vector de longitud fija de 
	 * numeros de punto flotante. */

	
    private ConcurVector auxVector;
    private ConcurVector auxVectorModificado;
    private static int load= 2;
	private int dimension, threads, diferenciaThreadsRango;
	
	// El array con los elementos del vector
	private double [] elements;
	
	
	private ThreadPool threadPool= new ThreadPool ();
	private Buffer buffer;
	private int rango;
	
	/** Constructor del ConcurVector.
	 * @param dimension, la longitud del vector.
	 * @precondition dimension > 0. */
	public ConcurVector(int dimension) {
		
		this.dimension= dimension;
		this.elements= new  double[dimension];
		this.setBuffer();
		this.threadPool= threadPool;
				
	}	
	/** Constructor del ConcurVector.
	 * @param dimension, la longitud del vector.
	 * @precondition dimension > 0. */
	public ConcurVector(int dimension, int threads) {
		
		this (dimension);
		this.threads= threads;
		
				
	}
		
	public int load() {
		return this.load;
	}
	
	/** Crea un Buffer con
	 * numeros de punto flotante de dimension igual a los elemnentos del vector. */
	public void setBuffer() {
		this.buffer= new Buffer (this.dimension);
	}
	
	public Buffer getBuffer(){
		return this.buffer;
	}
	
		
	
	public int getThread () {
		return this.threads;
	}
	
	
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
	public void abs() {
		Operacion operacion= new Abs() ;	
		
			
		this.threadPool.initializeWorkers(operacion,this,this.auxVector);
	
	}
	
	
	 /** Obtiene el valor promedio en el vector. */
	
	public synchronized double mean() {
        	double total = this.sum();
        	return total / this.dimension();
	}
    
	
	 
	/** Retorna el producto de este vector con otro.
     * El producto vectorial consiste en la suma de los productos
     * de cada coordenada.
	 * @param v, el vector a usar para realizar el producto.
	 * @precondition dimension() == v.dimension(). */
	public double prod(ConcurVector v) {
		ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
		aux.assign(this);
		aux.mul(v);
		return aux.sum();
	}
	
	
	/** Retorna la norma del vector.
     *  Recordar que la norma se calcula haciendo la raiz cuadrada de la
     *  suma de los cuadrados de sus coordenadas.
     */
	public double norm() {
		ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
		aux.assign(this);
		aux.mul(this);
		return Math.sqrt(aux.sum());
	}
	
	
		
	/** Pone el valor d en todas las posiciones del vector. 
	 * @param d, el valor a ser asignado. */
	
	public synchronized void set(double d) {
		
		ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
		aux.assign(this);
	Operacion operacion= new Set(d) ;	
	
	
	this.threadPool.initializeWorkers(operacion,this,aux);
	}
	
	/** Copia los valores de otro vector sobre este vector.
	 * @param v, el vector del que se tomaran los valores nuevos.
	 * @precondition dimension() == v.dimension(). */
	public synchronized void assign(ConcurVector vector) {
		
		Operacion operacion= new Assign() ;	
		
		
		this.threadPool.initializeWorkers(operacion,this,vector);
		
	}
	
	
	public synchronized void assign(ConcurVector mask, ConcurVector vector){ 
       Operacion operacion= new AssignConMask(mask) ;	
		
		
		this.threadPool.initializeWorkers(operacion,this,vector);
			
		
	}
	
	/** Multiplica los valores de este vector con los de otro
     *  (uno a uno).
	 * @param v, el vector con los valores a multiplicar.
	 * @precondition dimension() == v.dimension(). */
	public synchronized void mul(ConcurVector vector) {
		
		Operacion operacion= new Mul();	
		
		
		this.threadPool.initializeWorkers(operacion,this,vector);
		
	}	
	
	
	/** Suma los valores de este vector con los de otro (uno a uno).
	 * @param v, el vector con los valores a sumar.
	 * @precondition dimension() == v.dimension(). */
	public synchronized void add(ConcurVector vector) {
		
		Operacion operacion= new Add();
		
	
		
		this.threadPool.initializeWorkers(operacion,this,vector);
		
	}
	
		
	/** Obtiene la suma de todos los valores del vector. */
	   public synchronized double sum() {
		  int rango;
		   int diferenciaThreadsRango=1;
		   Operacion operacion= new Sum();	
		
		  	   
		   ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
		  
			aux.assign(this);
		    
		     rango= aux.dimension()/aux.getThread();
		   
		
			  while (aux.dimension() > 1) {
		
		    if (rango != aux.getThread()) {
			      diferenciaThreadsRango = Math.abs(aux.getThread() -  rango); 
		     }
		    		  
		    ConcurVector auxModificado = new ConcurVector(aux.getThread(),diferenciaThreadsRango);
		  
		  this.threadPool.initializeWorkers(operacion,aux,auxModificado);
		  		 		
		   aux= auxModificado;
		   rango= aux.dimension()/aux.getThread(); 
			
	}	
	  		  
		 return ( aux.get(0)); 
  
}
	   /** Obtiene el valor maximo en el vector. */
	   public synchronized double max() {
		   int rango;
		   int diferenciaThreadsRango=1;
		   Operacion operacion= new Max();	
	  		    
	    ConcurVector aux = new ConcurVector(this.dimension(),this.getThread());
	  
		aux.assign(this);
	    
	     rango= aux.dimension()/aux.getThread();
	   
	               while (aux.dimension() > 1) {
			
	            	   if (rango != aux.getThread()) {
	     			      diferenciaThreadsRango = Math.abs(aux.getThread() -  rango); 
	     		     }
	            	   ConcurVector auxModificado = new ConcurVector(aux.getThread(),diferenciaThreadsRango);
	         		 
	         		  this.threadPool.initializeWorkers(operacion,aux,auxModificado);
	         		  		 		
	         		   aux= auxModificado;
	         		   rango= aux.dimension()/aux.getThread(); 
	
   }	
	 	  		  
	  return ( aux.get(0));
   }
	   
 
}	   
