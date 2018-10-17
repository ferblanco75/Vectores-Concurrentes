package progConc;

public class MonitorAccionesWorker {
    
	private int contThreads=0;
	public MonitorAccionesWorker() {
		
	}

	public synchronized int contThreads() {
		return contThreads++;
	}
	
	
	public synchronized int decrementarThreads() {
		return contThreads--;
	}
}
