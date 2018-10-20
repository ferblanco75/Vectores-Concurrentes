package progConc;

public class Add extends Operacion {

	/**
	   @Prop�sito : Constructor del Add.
	   @precondition Ninguna
	 */
	public  Add()  {
						
		}
	
	/**
	   @Prop�sito : LLama a la operaci�n add() por medio del par�metro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operaci�n add().  
	 */
	
	public void operar(Worker worker) {
		
		worker.add();	
		
	}	
		
	}


