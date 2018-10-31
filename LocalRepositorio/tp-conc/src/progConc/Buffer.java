package progConc;

/**
@Propósito : Es una clase que funicona como un monitor, cuyos métodos
 synchronized se ejecutan en exclusión mutua. y Simula un buffer circular
 de longitud fija de punto flotante.
*/

public class Buffer {
		private Object [] data;
		private int begin = 0, end = 0;
	    private int tamanio;
	
		/**
		@Propósito : Constructor del Buffer
		@precondition n Debe ser un entero positivo.
		@Param n. Es un entero positivo, que indica la dimensión del Buffer
		*/
		
		public Buffer(int n) {
		    this.tamanio= n +1;
			this.data= new Object [n +1];
		}
		
		public int getDimension() {
			return this.data.length -1 ;
		}
		
		/**
		@Propósito : Devuelve un array de elementos Object
		@precondition Ninguna.
		@Param Object[] El array de elementos Object que será devuelto.
		*/
		public Object[] getData() {
			return this.data ;
		}
		
		/**
		@Propósito : Escribe un dato en el Buffer, mientras éste no esté lleno,y notifica 
		a los procesos de la cola que ya hay un nuevo dato. 
		caso contrario, el proceso se va a dormir hasta que otro proceso lo despierte.
		@precondition Ninguna.
		@Param Object, es el tipo de dato genérico a ser escrito en el buffer. 
		*/
		public synchronized void write ( Object o) {
		while ( isFull ())
			try {
				wait ();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		data [ begin ] =  o;
		begin = next ( begin );
		notifyAll ();
		}
		
		/**
		@Propósito :Devuelve un dato leído del Buffer, mientras éste no esté vacio,y notifica 
		a los procesos de la cola que hay espacio disponible en el buffer. 
		caso contrario, el proceso se va a dormir hasta que otro proceso lo despierte.
		@precondition Ninguna.
		@Param Object, es el tipo de dato genérico a ser devuelto al leer del buffer. 
		*/
		public synchronized Object read () {
		while ( isEmpty ())
			try {
				wait ();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		Object result = data [ end ];
		end = next ( end );
		notifyAll ();
		return result ;
		}
		
		/**
		@Propósito :Devuelve true en caso que el buffer esté vacío.
		@precondition Begin y end.Deben ser enteros positivos.
		@Param begin, es un entero positivo que indica en que posición se va a escribir el buffer 
		@Param begin, es un entero positivo que indica en que posición se va a leer del buffer 
		*/
		public boolean isEmpty () { return begin == end; }
		
		/**
		@Propósito :Devuelve true en caso que el buffer esté lleno.
		@precondition Begin y end.Deben ser enteros positivos.
		@Param begin, es un entero positivo que indica en que posición se va a escribir el buffer 
		@Param begin, es un entero positivo que indica en que posición se va a leer del buffer 
		*/
		public boolean isFull () { return next ( begin ) == end ; }
		
		/**
		@Propósito :Devuelve la próxima posición del buffer.
		@precondition i , nunca puede tomar un valor negativo, ni superar el tamaño del buffer. 
		@Param i , es un entero positivo. 
		 
		*/
		private int next ( int i) { return (i+1) %(this.tamanio ) ; }

}



