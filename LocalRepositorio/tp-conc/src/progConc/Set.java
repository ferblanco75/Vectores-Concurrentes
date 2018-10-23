package progConc;

public class Set extends Operacion {

	private double dato;

	/**
	   @Propósito : Constructor del Set.
	   @precondition El constructor debe recibir un tipo de dato Double por parámetro
	 */
	
	 public Set(double d) {
		
		 this.dato=d;
			}
		
		/**
		   @Propósito : LLama a la operación set(d) por medio del parámetro worker.
		   @precondition Ninguna
		   @Param.worker, es el thread que realiza la operación set(d)  
		 */
		
		public void operar(Worker worker) {
		
			
			worker.set(this.dato);	
			
		}	

}
