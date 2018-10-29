package progConc;

public class Mul extends Operacion {

	/**
	   @Prop�sito : Constructor del Mul.
	   @precondition Ninguna
	 */
	public Mul()  {
		
	}
	/**
	   @Prop�sito : LLama a la operaci�n mul() por medio del par�metro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operaci�n mul().  
	 */
	     public void operar(Worker worker ) {
		
    	   worker.mul();	
    	   
}
	      
}
