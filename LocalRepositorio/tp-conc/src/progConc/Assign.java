package progConc;

public class Assign extends Operacion {
	
	/**
	   @Propósito : Constructor del Assign.
	   @precondition Ninguna
	 */
	public Assign() {
		
	}

	/**
	   @Propósito : LLama a la operación asssign() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación assign().  
	 */
	
	public void operar(Worker worker) {
		
		worker.assign();	
		
	}	
}
