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
	private int dimension, threads;
	
	// El array con los elementos del vector
	private double [] elements;
	
	
	private ThreadPool threadPool= new ThreadPool ();
	private Buffer buffer;
	private int rango;
	
		
	/** Constructor del ConcurVector.
	 * @param dimension, la longitud del vector.
	 * @precondition dimension > 0. */
	public ConcurVector(int dimension, int threads) {
		
		this.dimension= dimension;
		this.threads= threads;
		this.elements= new  double[dimension];
		this.rango= this.dimension/this.threads;
		this.setBuffer();
		this.threadPool= threadPool;
				
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
	
	/******************* Operaciones Auxiliares ******************/
	
	/** Devuelve  un vector con la misma dimension y elementos del vector pasado por parámetro
	 *  * @param vector, es el vector cuyos elemento y dimension van a ser replicados
	 * @precondition Ninguna */
	public ConcurVector copiarVector(ConcurVector vector) {
		
		ConcurVector auxVector= new ConcurVector(vector.dimension(), vector.getThread()) ;
		
		for (int i=0; i < vector.dimension();i++ ) {
			 auxVector.set(i, vector.get(i));	
		}
			 return auxVector;
	}
	
	/** Crea y devuelve un vector con la dimension y threads pasados por parámetros
	 *  * @param dimension, representa el tamaño del vector.
	 *  * @param threads, representa la cantidad de threads .
	 * @precondition Ninguna */
	public ConcurVector crearVector(int dimension,int threads ){
		ConcurVector vector= new ConcurVector(dimension,threads );
		return vector;		
	}
	
	/*******************Desde aquí Comienzan la Operaciones concurentes ******************/
	
	/** Pone el valor d en todas las posiciones del vector. 
	 * @param d, el valor a ser asignado. */
	
	public synchronized void set(double d) {
		
	
	Operacion operacion= new Set(d) ;	
	this.auxVector= this.copiarVector(this);
	
	this.threadPool.initializeWorkers(operacion,this,this.auxVector);
	}
	
	/** Copia los valores de otro vector sobre este vector.
	 * @param v, el vector del que se tomaran los valores nuevos.
	 * @precondition dimension() == v.dimension(). */
	public synchronized void assign(ConcurVector vector) {
		
		Operacion operacion= new Assign() ;	
		
		
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
		  
		   Operacion operacion= new Sum();	
		
		    this.auxVector= this.copiarVector(this);
		    this.rango= this.auxVector.dimension()/this.auxVector.getThread();
		   
		  while (this.rango > 1) {
		 	  
		  this.auxVectorModificado= this.crearVector(this.auxVector.getThread(),this.auxVector.load());   
		  this.threadPool.initializeWorkers(operacion,this.auxVector,this.auxVectorModificado);
		  
		  for ( int i =0; i < this.auxVectorModificado.dimension();i++) {
			    System.out.println("["+i+"]"+ this.auxVectorModificado.get(i));
			    
		}   
		 	 
			 
		 this.auxVector= this.auxVectorModificado;
		 this.rango= this.auxVector.dimension()/this.auxVector.getThread();
		
	}	
		 
		  		  
		 return ( this.auxVector.get(0)  + this.auxVector.get(1) );
	     
}
	   /** Obtiene el valor maximo en el vector. */
	   public synchronized double max() {
	   Operacion operacion= new Max();	
		
	    this.auxVector= this.copiarVector(this);
	    this.rango= this.auxVector.dimension()/this.auxVector.getThread();
	   
	  while (this.rango > 1) {
	      
	  this.auxVectorModificado= this.crearVector(this.auxVector.getThread(),this.auxVector.load());   
	   
	  this.threadPool.initializeWorkers(operacion,this.auxVector,this.auxVectorModificado);
	  
	  for ( int i =0; i < this.auxVectorModificado.dimension();i++) {
		    System.out.println("["+i+"]"+ this.auxVectorModificado.get(i));
		    
	}   
	 		 
	 this.auxVector= this.auxVectorModificado;
	 this.rango= this.auxVector.dimension()/this.auxVector.getThread();
	
}	
	 	  		  
	  return ( Math.max(this.auxVector.get(0), this.auxVector.get(1)));
}
	   
 
}	   
