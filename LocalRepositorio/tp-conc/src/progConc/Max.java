package progConc;

public class Max extends Operacion {

	/**
	   @Prop�sito : Constructor del Max.
	   @precondition Ninguna
	 */
	public Max() {
		
	}

	/**
	   @Prop�sito : LLama a la operaci�n max() por medio del par�metro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operaci�n max().  
	 */
	
	public void operar(Worker worker) {
		
		worker.max();	
	}
}
	
