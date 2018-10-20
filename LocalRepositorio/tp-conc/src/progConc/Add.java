package progConc;

public class Add extends Operacion {

	/**
	   @Propósito : Constructor del Add.
	   @precondition Ninguna
	 */
	public  Add()  {
						
		}
	
	/**
	   @Propósito : LLama a la operación add() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación add().  
	 */
	
	public void operar(Worker worker) {
		
		worker.add();	
		
	}	
		
	}


