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

	private static int load= 2;
	private int dimension, threads;
	// El array con los elementos del vector
	private double [] elements;
	private SeqVector seqVector;
	private ThreadPool threadPool= new ThreadPool ();
	private Buffer buffer;
		
	/** Constructor del ConcurVector.
	 * @param dimension, la longitud del vector.
	 * @precondition dimension > 0. */
	public ConcurVector(int dimension, int threads) {
		
		this.dimension= dimension;
		this.threads= threads;
		this.elements= new  double[dimension];
		this.threadPool= threadPool;
		this.setBuffer();
	}
	/**
	public void reSet(int dimension) {
		
		this.dimension= dimension;
		this.elements= new double[dimension];
		this.threads= load;
	}
	*/
	public int load() {
		return this.load;
	}
	
	public void setBuffer() {
		this.buffer= new Buffer (this.dimension);
	}
	
	public Buffer getBuffer(){
		return this.buffer;
	}
	
	public void  setVector(SeqVector vector) {
		this.seqVector=vector;
	}
	
	public SeqVector getVector() {
		return this.seqVector;
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
	
	/** Multiplica los valores de este vector con los de otro
     *  (uno a uno).
	 * @param v, el vector con los valores a multiplicar.
	 * @precondition dimension() == v.dimension(). */
	public synchronized void mul(SeqVector v) {
		this.setVector(v);
		Operacion operacion= new Mul();		
		
		this.threadPool.initializeWorkers(operacion,this,this.threads);
	
		
	
	}	
	
	
	/** Suma los valores de este vector con los de otro (uno a uno).
	 * @param v, el vector con los valores a sumar.
	 * @precondition dimension() == v.dimension(). */
	public synchronized void add(SeqVector v) {
		this.setVector(v);
		Operacion operacion= new Add();	
		this.threadPool.initializeWorkers(operacion,this,this.threads);
		
	}
	/** Obtiene la suma de todos los valores del vector. */
	   public synchronized double sum() {
			
		Operacion operacion= new Sum();	
		
		
		 this.threadPool.initializeWorkers(operacion,this,this.threads);
		
		 return this.get(0)+ this.get(1);
	}	 
}
