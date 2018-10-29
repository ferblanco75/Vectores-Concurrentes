package progConc;

public class Mul extends Operacion {

	/**
	   @Propósito : Constructor del Mul.
	   @precondition Ninguna
	 */
	public Mul()  {
		
	}
	/**
	   @Propósito : LLama a la operación mul() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación mul().  
	 */
	     public void operar(Worker worker ) {
		
    	   worker.mul();	
    	   
}
	      
}
