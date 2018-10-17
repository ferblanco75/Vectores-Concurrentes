package progConc;


public class Buffer {
		private Object [] data;
		private int begin = 0, end = 0;
	
		
		public Buffer(int n) {
		
			this.data= new Object [n];
		}
		
		public Object[] getData() {
			return this.data;
		}
		
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
		
		
		private boolean isEmpty () { return begin == end; }
		private boolean isFull () { return next ( begin ) == end ; }
		private int next ( int i) { return (i+1) %(this.data.length) ; }

}



