package by.womework;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Trucker extends Worker {
	private boolean finished = false;
	private Semaphore semaphore;
	
	public Trucker(String name, int timeWork, Semaphore semaphore, Semaphore semaphoreNext) {
		setName(name);
		setTimeWork(timeWork);
		setSemaphore(semaphore);
		setSemaphoreNext(semaphoreNext);
	}	

	@Override
	protected void work() throws InterruptedException {
		Truck truck = getTruck();	
		truck.setCurrOvner(getName());
		finished = false;
		TimeUnit.MILLISECONDS.sleep(getTimeWork() * 1000);
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
		Truck truck = getTruck();
		if(truck.getCurrCapacity() > 0) {
			semaphore = getSemaphoreNext();
		} else {
			semaphore = getSemaphorePrev();
		}
		semaphore.release();
	}

}
