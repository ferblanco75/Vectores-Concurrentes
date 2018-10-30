package progConc;

public class Work {

	private int inicio, fin;
	private ConcurVector vector1, vectorModificado;
	
	public Work(ConcurVector vector1, ConcurVector vectorModificado, int inicio,int fin) {
	
		this.inicio= inicio;
		this.fin= fin;
		this.vector1= vector1;
		this.vectorModificado= vectorModificado;
	}

	public int getInicio(){
		return this.inicio;
	}
	

	public int getFin(){
		return this.fin;
	}
	
	public ConcurVector getVector1(){
		return this.vector1;
	}
	
	public ConcurVector getVectorModificado(){
		return this.vectorModificado;
	}
}
