package progConc;

public class AssignConMask extends Operacion {
	private ConcurVector vector;
	/**
	   @Propósito : Constructor del Assign.
	   @precondition Ninguna
	 */
	public AssignConMask(ConcurVector vector) {
		this.vector= vector;
	}

	/**
	   @Propósito : LLama a la operación assignConMask() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación assignConMask().  
	 */
	
	public void operar(Worker worker) {
		
		worker.assignConMask(this.vector);	
		
	}	
	
	
}
