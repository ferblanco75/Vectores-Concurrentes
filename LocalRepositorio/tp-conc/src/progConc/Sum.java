package progConc;

public class Sum extends Operacion{

	/**
	   @Prop�sito : Constructor del Sum.
	   @precondition Ninguna
	 */
	
	public Sum() {
		
		
	}
	
	/**
	   @Prop�sito : LLama a la operaci�n sum() por medio del par�metro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operaci�n sum().  
	 */
	    public void operar(Worker worker) {
			
	    	   worker.sum();	
}
}
	    
