package progConc;

public class Assign extends Operacion {
	
	/**
	   @Prop�sito : Constructor del Assign.
	   @precondition Ninguna
	 */
	public Assign() {
		
	}

	/**
	   @Prop�sito : LLama a la operaci�n asssign() por medio del par�metro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operaci�n assign().  
	 */
	
	public void operar(Worker worker) {
		
		worker.assign();	
		
	}	
}
