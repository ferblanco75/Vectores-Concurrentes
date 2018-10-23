package progConc;

public class AssignConMask extends Operacion {
	private ConcurVector vector;
	/**
	   @Prop�sito : Constructor del Assign.
	   @precondition Ninguna
	 */
	public AssignConMask(ConcurVector vector) {
		this.vector= vector;
	}

	/**
	   @Prop�sito : LLama a la operaci�n assignConMask() por medio del par�metro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operaci�n assignConMask().  
	 */
	
	public void operar(Worker worker) {
		
		worker.assignConMask(this.vector);	
		
	}	
	
	
}
