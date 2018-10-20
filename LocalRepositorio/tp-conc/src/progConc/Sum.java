package progConc;

public class Sum extends Operacion{

	/**
	   @Propósito : Constructor del Sum.
	   @precondition Ninguna
	 */
	
	public Sum() {
		
		
	}
	
	/**
	   @Propósito : LLama a la operación sum() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación sum().  
	 */
	    public void operar(Worker worker) {
			
	    	   worker.sum();	
}
}
	    
