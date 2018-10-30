package progConc;

public class Mul2 extends Operacion {

	public Mul2() {
		
	}
	/**
	   @Propósito : LLama a la operación mul() por medio del parámetro worker.
	   @precondition Ninguna
	   @Param.worker, es el thread que realiza la operación mul().  
	 */
	     public void operar(Worker worker ) {
		
 	   worker.mul2();	
}

}
