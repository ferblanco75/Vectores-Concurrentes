package progConc;

/**
@Prop�sito : Es una clase que funicona como un monitor, cuyos m�todos
 synchronized se ejecutan en exclusi�n mutua. y Simula un buffer circular
 de longitud fija de punto flotante.
*/

public class Buffer {
		private Object [] data;
		private int begin = 0, end = 0;
	
		/**
		@Prop�sito : Constructor del Buffer
		@precondition n Debe ser un entero positivo.
		@Param n. Es un entero positivo, que indica la dimensi�n del Buffer
		*/
		
		public Buffer(int n) {
		
			this.data= new Object [n];
		}
		
		
		/**
		@Prop�sito : Devuelve un array de elementos Object
		@precondition Ninguna.
		@Param Object[] El array de elementos Object que ser� devuelto.
		*/
		public Object[] getData() {
			return this.data;
		}
		
		/**
		@Prop�sito : Escribe un dato en el Buffer, mientras �ste no est� lleno,y notifica 
		a los procesos de la cola que ya hay un nuevo dato. 
		caso contrario, el proceso se va a dormir hasta que otro proceso lo despierte.
		@precondition Ninguna.
		@Param Object, es el tipo de dato gen�rico a ser escrito en el buffer. 
		*/
		public synchronized void write ( Object o) {
		while ( isFull ())
			try {
				wait ();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		data [ begin ] = o;
		begin = next ( begin );
		notifyAll ();
		}
		
		/**
		@Prop�sito :Devuelve un dato le�do del Buffer, mientras �ste no est� vacio,y notifica 
		a los procesos de la cola que hay espacio disponible en el buffer. 
		caso contrario, el proceso se va a dormir hasta que otro proceso lo despierte.
		@precondition Ninguna.
		@Param Object, es el tipo de dato gen�rico a ser devuelto al leer del buffer. 
		*/
		public synchronized Object read () {
		while ( isEmpty ())
			try {
				wait ();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Object result = data [ end ];
		end = next ( end );
		notifyAll ();
		return result ;
		}
		
		/**
		@Prop�sito :Devuelve true en caso que el buffer est� vac�o.
		@precondition Begin y end.Deben ser enteros positivos.
		@Param begin, es un entero positivo que indica en que posici�n se va a escribir el buffer 
		@Param begin, es un entero positivo que indica en que posici�n se va a leer del buffer 
		*/
		public boolean isEmpty () { return begin == end; }
		
		/**
		@Prop�sito :Devuelve true en caso que el buffer est� lleno.
		@precondition Begin y end.Deben ser enteros positivos.
		@Param begin, es un entero positivo que indica en que posici�n se va a escribir el buffer 
		@Param begin, es un entero positivo que indica en que posici�n se va a leer del buffer 
		*/
		public boolean isFull () { return next ( begin ) == end ; }
		
		/**
		@Prop�sito :Devuelve la pr�xima posici�n del buffer.
		@precondition i , nunca puede tomar un valor negativo, ni superar el tama�o del buffer. 
		@Param i , es un entero positivo. 
		 
		*/
		private int next ( int i) { return (i+1) %(this.data.length) ; }

}



