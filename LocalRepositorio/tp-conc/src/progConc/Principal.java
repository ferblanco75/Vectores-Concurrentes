/**
 * 
 */
package progConc;

//import java.util.concurrent.Semaphore;

/**
 * @author COMMODORE1
 *
 */
public class Principal {

	
	
	public Principal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	
	
	SeqVector vector2= new SeqVector(8);
	
	ConcurVector vector1= new ConcurVector(8,4);
	
		
		for (int i=0;i < vector1.dimension();i++ ) {
		int d= i+1;
		vector1.set(i,d);		
		}
				
		for (int i=0;i < vector2.dimension();i++ ) {
			vector2.set(i,2);		
			}
		
		
		for (int i=0;i < vector1.dimension();i++ ) {
			System.out.println (vector1.get(i));	
			}	
		System.out.println ("//");
		
		
		for (int i=0;i < vector2.dimension();i++ ) {
			System.out.println (vector2.get(i));		
			}	
		System.out.println ("//");
		
		   
		   vector1.mul(vector2);	  
		 
		  for (int i=0;i < vector1.dimension();i++ ) {
				System.out.println (vector1.get(i));		
				}
		  System.out.println ("//");
		 
		
		  for (int i=0;i < vector2.dimension();i++ ) {
				System.out.println (vector2.get(i));		
				}
		  System.out.println ("//");
		  
           
		  
		  vector1.add(vector2);
		  
		  for (int i=0;i < vector1.dimension();i++ ) {
				System.out.println (vector1.get(i));		
				}
		  System.out.println ("//");
		  
		  for (int i=0;i < vector2.dimension();i++ ) {
				System.out.println (vector2.get(i));		
				}
    /**
        vector1.sum();
		   
		   for (int i=0;i < vector1.dimension();i++ )
		   System.out.println ("[" + i + "] : = "+vector1.get(i) ); 
		 // vector1.mul(vector2);
		  
		  */
	}

}
