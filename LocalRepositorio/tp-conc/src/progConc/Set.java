package progConc;

public class Set extends Operacion {

	private double dato;

	/**
	   @Prop�sito : Constructor del Set.
	   @precondition El constructor debe recibir un tipo de dato Double por par�metro
	 */
	
	 public Set(double d) {
		
		 this.dato=d;
			}
		
		/**
		   @Prop�sito : LLama a la operaci�n set(d) por medio del par�metro worker.
		   @precondition Ninguna
		   @Param.worker, es el thread que realiza la operaci�n set(d)  
		 */
		
		public void operar(Worker worker) {
		
			
			worker.set(this.dato);	
			
		}	

}
