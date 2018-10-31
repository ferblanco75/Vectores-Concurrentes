/**
 * 
 */
package progConc;

/**
 * 
 *
 */
public class Principal {

	
	
	public Principal() {
		
	}

	
	public static void main(String[] args) throws InterruptedException {
		
				
		ConcurVector vector1= new ConcurVector(7,3);
		
		
		ConcurVector vector2= new ConcurVector(7,3);
		
		
		ConcurVector vector3= new ConcurVector(7,3);
		
		
	
		ConcurVector vector4= new ConcurVector(4,2);
	
	    
		ConcurVector mask= new ConcurVector(7,3);
	 
		 
	  		ConcurVector v= new ConcurVector(7,3);
		
		 
		     ConcurVector vector5= new ConcurVector(7,3);
		
		 
		 ConcurVector vector6= new ConcurVector(7,3);
		
		 
			for (int i=0;i < vector1.dimension();i++ ) {
			int d= i+1;
			vector1.set(i,d);		
			}
					
			for (int i=0;i < vector2.dimension();i++ ) {
				vector2.set(i,2);		
				}
			
			for (int i=0;i < vector3.dimension();i++ ) {
				vector3.set(i,3);		
				}
			
			for (int i=0;i < vector4.dimension();i++ ) {
				int d= i+1;
				vector4.set(i,d);		
				}
			
					
		
			for (int i=0;i < vector1.dimension();i++ ) {
				System.out.println (vector1.get(i));	
				}	
			System.out.println ("//");
			
			
				
			
			for (int i=0;i < vector2.dimension();i++ ) {
				System.out.println (vector2.get(i));		
				}	
			   System.out.println ("//");
			
			  // vector1.operacion1();
			   
			  // vector1.mul2(vector2);
			/* 
			  vector1.mul(vector2);
			 
			
			  for (int i=0;i < vector1.dimension();i++ ) {
					System.out.println (vector1.get(i));		
					}
			  System.out.println ("//");
			 
			*/
			 
			  
			/*
		
	  			  
			  vector1.add(vector2);
			  
			  for (int i=0;i < vector1.dimension();i++ ) {
					System.out.println (vector1.get(i));		
					}
			  System.out.println ("//");
			  
		
			 
			 vector3.set(5);
			 
			 for (int i=0;i < vector3.dimension();i++ ) {
					System.out.println (vector3.get(i));		
					}
			  System.out.println ("//");
			 
			  vector2.assign(vector3);
				 
				 for (int i=0;i < vector2.dimension();i++ ) {
						System.out.println (vector2.get(i));		
						}
				  System.out.println ("//");
				 
				*/	 	
				 double suma=vector4.sum();
				   
				   for (int i=0;i < vector4.dimension();i++ ) {
				   System.out.println ("[" + i + "] : = "+vector4.get(i) ); 
				   
				   }
				   System.out.println ("El resultado de la suma de los elementos es: " + suma ); 
				  
				 
				/** 			 
				
				 double max= vector4.max();
					 
					 for (int i=0;i < vector4.dimension();i++ ) {
							System.out.println (vector4.get(i));		
							}
					  System.out.println ("//");
					  System.out.println ("El máximo elemento es: " + max );
					  
			 
			     	 				  
					  mask.set(0, -1);
					  mask.set(1, 1);
					  mask.set(2, 1);
					  mask.set(3, 1);
					  mask.set(4, 1);
					  mask.set(5, 1);
					  mask.set(6, 1);
					 // mask.set(7, -1);
					  
					  for (int i=0;i < vector1.dimension();i++ ) {
							int d= i+1;
							vector1.set(i,d);		
							}
									
								
						for (int i=0;i < v.dimension();i++ ) {
								v.set(i,0);		
								}
					
					  vector1.assign (mask, v);
					  
					  for (int i=0;i < vector1.dimension();i++ ) {
							System.out.println (vector1.get(i));	
							}	
						System.out.println ("//"); 
						
						vector5.set(0, -1);
						vector5.set(1, 1);
						vector5.set(2, 1);
						vector5.set(3, -2);
						vector5.set(4, 1);
						vector5.set(5, -1);
						vector5.set(6, -5);
					//	vector5.set(7, -1);
						
						for (int i=0;i < vector6.dimension();i++ ) {
							vector6.set(i,5);		
							}
						
						vector5.abs ();
						  
						  for (int i=0;i < vector5.dimension();i++ ) {
								System.out.println (vector5.get(i));	
								}	
							System.out.println ("//"); 
							
							
							double norma= vector5.norm ();
							  
							  for (int i=0;i < vector5.dimension();i++ ) {
									System.out.println (vector5.get(i));	
									}	
							  System.out.println ("La norma de vector es:= " + norma);
							  System.out.println ("//");
								
								double prod= vector5.prod (vector6);
								  
								  for (int i=0;i < vector5.dimension();i++ ) {
										System.out.println (vector5.get(i));	
										}	
								  System.out.println ("El producto de vector es:= " + prod);
								  System.out.println ("//"); 
								  
	                             double promedio= vector5.mean ();
								  
								  for (int i=0;i < vector5.dimension();i++ ) {
										System.out.println (vector5.get(i));	
										}	
								  System.out.println ("El promedio de vector es:= " + promedio);
								  System.out.println ("//"); 
	   
		*/}
		
		
	}