package progConc;

public class Abs extends Operacion {
	
	/**
	   @param buffer 
	 * @Propósito : Constructor del Abs.
	   @precondition :Ninguna
	 */
	public Abs() {
	  
	}
	
	/**
	   @Propósito : LLama a la operación abs() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación abs() 
	 */
	
	public void operar(Worker worker) {
	
		
		worker.abs();	
		
	}	

}
