package progConc;

public class Max extends Operacion {

	/**
	   @Propósito : Constructor del Max.
	   @precondition Ninguna
	 */
	public Max() {
		
	}

	/**
	   @Propósito : LLama a la operación max() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación max().  
	 */
	
	public void operar(Worker worker) {
		
		worker.max();	
	}
}
	
