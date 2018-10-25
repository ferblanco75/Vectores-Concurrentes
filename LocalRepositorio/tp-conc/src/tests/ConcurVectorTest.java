package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.Buffer;
import progConc.ConcurVector;

public class ConcurVectorTest {

	ConcurVector vector1,vector2,mask;
	Buffer buffer;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		 buffer= new Buffer(3);
		 vector1= new ConcurVector(7,3);
		 vector1.setBuffer(buffer);
		 vector2= new ConcurVector(7,3);
		 vector2.setBuffer(buffer);
		 mask= new ConcurVector(7,3);
		 mask.setBuffer(buffer);
		
		 for (int i=0;i < vector1.dimension();i++ ) {
				int d= i+1;
				vector1.set(i,d);
		 }
		 
		 
		 for (int i=0;i < vector2.dimension();i++ ) {
				vector2.set(i,2);
		 }
		 
		 mask.set(0, -1);
		 mask.set(1, -1);
		 mask.set(2, -1);
		 mask.set(3, -1);
		 mask.set(4, -1);
		 mask.set(5, -1);
		 mask.set(6, 1);
		
	}	 

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_LaDimensionDel_VectorEs_7() {
		int expected=7;
		assertTrue(vector1.dimension()==expected);
	}
	
	@Test
	public void test_El_Numero3_Esta_en_LaPosicion_2_DelVector1() {
		
		assertTrue(vector1.get(2)==3);
	}
	
	@Test
     public void test_El_Numero2_Esta_en_LaPosicion_2_DelVector2() {
		
		assertTrue(vector2.get(2)==2);
	}
	
	@Test /*test para mul*/
     public void test_Al_MultiplicarLosElementosDeAmbosVectores_LaPosicion_2_DelVector1_TieneAhora_elNumero_Seis() {
		
		//Antes de mul() el vector1 tiene en la posicion 2 el numero 3 
		assertTrue(vector1.get(2)== 3);
    	 vector1.mul(vector2);
    	//Despues de mul() el vector1 tiene en la posicion 2 el numero 6 
    	 assertTrue(vector1.get(2)==6);
 	}
	
	@Test /*test para add*/
    public void test_Al_SumarLosElementosDeAmbosVectores_LaPosicion_2_DelVector1_TieneAhora_elNumero_Cinco() {
		
		//Antes de add() el vector1 tiene en la posicion 2 el numero 3 
				assertTrue(vector1.get(2)== 3);
   	            vector1.add(vector2);
		
    	//Despues de add() el vector1 tiene en la posicion 2 el numero 5 
   	       assertTrue(vector1.get(2)== 5);
	}
		
	@Test /*test para abs*/
    public void test_El_ValorAbsolutoDe_3_Negativo_MeDevuelve_3_Positivo_EnLaPosicion_2_delVector1() {
	
		vector1.set(2,-3);
		//Antes de Abs() el vector1 tiene en la posicion 2el numero -3 
		assertTrue(vector1.get(2)== -3);
		   
		   vector1.abs();
		//Luego del Abs() el vector1 tiene en la posicion 2 el numero 3 (Positivo) 
		   	
   			assertTrue(vector1.get(2)==3);
   			
	}
	
	@Test /*test para sum*/
    public void test_Al_sumarTodosLosElementosDeLVector1_ElResultadoEs_10() {
		double expected= 28;
   	 double suma= vector1.sum();
		assertTrue(suma== expected);
	}
	
	
	@Test /*test para Max*/
    public void test_AlPedirElMaximoElementosDeLVector1_ElResultadoEs_7() {
		double expected= 7;
   	    double max= vector1.max();
		assertTrue(max== expected);
	}
	
	@Test /*test para Prod*/
    public void test_AlPedirElProductoDelVector1_SegunElVector2_ElResultadoEs_7() {
		double expected= 56;
   	    double producto= vector1.prod(vector2);
		assertTrue(producto== expected);
	}
	
	@Test /*test para Norm*/
    public void test_AlPedirLaNormaDelVector1__ElResutadoEsRaizCuadradaDe140() {
		double expected= Math.sqrt(140);
   	    double norma= vector1.norm();
		assertTrue(norma== expected);
	}
	
	@Test /*test para Mean*/
    public void test_AlPedirElPromedioDeLVector1_ElResultadoEs_4() {
		double expected= 4;
   	    double promedio= vector1.mean();
		assertTrue(promedio== expected);
	}
	

	@Test /*test para assign*/
    public void test_AlAsignarTodosLosElementosDelVector2_AlVector1_Este_TieneAhoraEnLaPosicion_2_alNumero_2() {
		
		//Antes de Asssign() el vector1 tiene en la posicion 2 el numero 3 
		   assertTrue(vector1.get(2)== 3);

		   vector1.assign(vector2);
		//Antes de Asssign() el vector1 tiene en la posicion 2 el numero 3 
		  assertTrue(vector1.get(2)==2);
	}
	
	@Test /*test para assignConMask escribe en el vector1 los elementos del vector2 si los elementos de la mascara son enteros positivos*/
    public void test_AlAsignarTodosLosElementosDelVector2_AlVector1_ConElVectorMaskConNumeroPositivoEnPosicion_6_Este_TieneAhoraEnLaPosicion_6_alNumero_2() {
		
		//Antes de AsssignConMask() el vector1 tiene en la posicion 6 el numero 7  
		   assertTrue(vector1.get(6)== 7);

		   vector1.assign(mask,vector2);
		//Antes de AsssignConMask() el vector1 tiene en la posicion 6 el numero 2 
		  assertTrue(vector1.get(6)==2);
	}

	@Test /*test para Set */
    public void test_AlAsignarATodosLosElementosDelVector1_ElNumero_5_Este_Tendra_ElNumnero_5_en_LaPosicion_6() {
		
		//Antes de AsssignConMask() el vector1 tiene en la posicion 6 el numero 7  
		   assertTrue(vector1.get(6)== 7);

		   vector1.set(5);
		//Antes de AsssignConMask() el vector1 tiene en la posicion 6 el numero 2 
		  assertTrue(vector1.get(6)==5);
	}
	
}
