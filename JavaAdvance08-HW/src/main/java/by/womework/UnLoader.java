package by.womework;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UnLoader extends Worker {
	private boolean finished = false;
	private Semaphore semaphore;
	
	public UnLoader(String name, int timeWork, Semaphore semaphore, Semaphore semaphoreNext) {
		setName(name);
		setTimeWork(timeWork);
		setSemaphore(semaphore);
		setSemaphoreNext(semaphoreNext);
	}	
	
	@Override
	protected void work() throws InterruptedException {
		Truck truck = getTruck();
		Heap heap   = getHeap();		
		
		truck.setCurrOvner(getName());
		finished = false;
		while(!truck.isEmpty()) {		
			truck.getCapacity(2);
			System.out.println(truck);
			TimeUnit.MILLISECONDS.sleep(1000);
		}
		finished = true;		
	}
	
	@Override
	public boolean finish() {
		return finished;
	}

	@Override
	protected void acquire() throws InterruptedException {
		semaphore = getSemaphore();
		semaphore.acquire();
	}

	@Override
	protected void release() {
		semaphore = getSemaphoreNext();
		semaphore.release();
	}
	


}
