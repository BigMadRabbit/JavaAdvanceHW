package by.womework;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Loader extends Worker {
	private boolean finished = false;
	private Semaphore semaphore;
	private Semaphore semaphoreNext;

	
	public Loader(String name, int timeWork, Semaphore semaphore, Semaphore semaphoreNext) {
		setName(name);
		setTimeWork(timeWork);
		this.semaphore = semaphore;
		this.semaphoreNext = semaphoreNext;
	}
	
	@Override
	protected void work() throws InterruptedException {
		Truck truck = getTruck();
		Heap heap   = getHeap();		
		
		truck.setCurrOvner(getName());
		finished = false;
		while(!truck.isFull()) {		
			truck.putCapacity(3);
			System.out.println(truck);
			TimeUnit.MILLISECONDS.sleep(1000);
		}
		heap.getCapacity(truck.getCurrCapacity());
		System.out.println("Heap quantity:"+heap.getQuantity());
		finished = true;
	}
	
	@Override
	protected void acquire() throws InterruptedException {
		semaphore.acquire();
	}

	@Override
	protected void release() {
		semaphoreNext.release();
	}
	
	@Override
	protected void next() {
	   	
	}

	@Override
	public boolean finish() {
		return finished;
	}

}
