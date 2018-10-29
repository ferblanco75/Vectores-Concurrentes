package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import progConc.Buffer;

public class BufferTest {
	Buffer buffer;
	double dato= 5;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		buffer= new Buffer(3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test 
	
	public void test_LaDimension_delBufferEs_3(){
          int expected= 3;
          assertTrue(buffer.getData().length==expected);
	}
	
	@Test
	
	public void test_ElBuffer_Al_Comienzo_estaVacio(){
       
		assertTrue(buffer.isEmpty());
        assertFalse(buffer.isFull());
	}
	
@Test
	
	public void test__AlEscribir_enElBuffer_una_Vez_YaTiene_UnDato(){
	assertTrue(buffer.isEmpty());
	    buffer.write(dato);
		assertFalse(buffer.isEmpty());
   	}

@Test

  public void test__AlEscribir_2_VecesMas_ElBuffer_estaLLeno(){
	assertTrue(buffer.isEmpty());
  	buffer.write(dato);
	buffer.write(dato);
  // buffer.write(dato);
      
	assertTrue(buffer.isFull());
	}

@Test
public void test__AlLeer_3_VecesElBuffer_VuelveA_estarVacio(){
	//assertTrue(buffer.isFull());
	assertTrue(buffer.isEmpty());
	 buffer.write(dato);
	  buffer.write(dato);
	 buffer.write(dato);
	  assertTrue(buffer.isFull()); 
   // buffer.read();
   // buffer.read();
   // buffer.read();
//	assertTrue(buffer.isEmpty());

	}

}
