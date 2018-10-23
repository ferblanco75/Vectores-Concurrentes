package progConc;

public class Abs extends Operacion {
	
	/**
	   @param buffer 
	 * @Prop�sito : Constructor del Abs.
	   @precondition :Ninguna
	 */
	public Abs() {
	  
	}
	
	/**
	   @Prop�sito : LLama a la operaci�n abs() por medio del par�metro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operaci�n abs() 
	 */
	
	public void operar(Worker worker) {
	
		
		worker.abs();	
		
	}	

}
