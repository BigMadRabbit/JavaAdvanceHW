package by.womework;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Trucker extends Worker {
	private boolean finished = false;
	private Semaphore semaphore;
	private Semaphore semaphoreNext;
	private Semaphore semaphorePrev;
	
	public Trucker(String name, int timeWork, Semaphore semaphore, Semaphore semaphoreNext) {
		setName(name);
		setTimeWork(timeWork);
		this.semaphore = semaphore;
		this.semaphoreNext = semaphoreNext;
	}	
	
	public void setSemaphorePrev(Semaphore semaphorePrev) {
		this.semaphorePrev = semaphorePrev;
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
	protected void next() {
		// TODO Auto-generated method stub		
	}
	@Override
	public boolean finish() {
		return finished;
	}
	@Override
	protected void acquire() throws InterruptedException {
		semaphore.acquire();
	}
	
	@Override
	protected void release() {
		Truck truck = getTruck();
		if(truck.getCurrCapacity() > 0) {
			semaphoreNext.release();
		} else {
			semaphorePrev.release();
		}
	}

}
