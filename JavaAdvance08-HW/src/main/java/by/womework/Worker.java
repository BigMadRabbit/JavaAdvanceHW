package by.womework;

import java.util.concurrent.Semaphore;

import javax.xml.stream.events.StartDocument;

public abstract class Worker implements Runnable {
	private Heap heap;
	private Truck truck;
	private String name;
	private int timeWork;
	private Semaphore semaphore;
	private Semaphore semaphoreNext;
	private Semaphore semaphorePrev;
		
	public void start() {
		System.out.println(getName() + ": Start");
		new Thread(this).start();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTimeWork() {
		return timeWork;
	}

	public void setTimeWork(int timeWork) {
		this.timeWork = timeWork;
	}
	
	public Semaphore getSemaphore() {
		return semaphore;
	}

	public void setSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public Semaphore getSemaphoreNext() {
		return semaphoreNext;
	}

	public void setSemaphoreNext(Semaphore semaphoreNext) {
		this.semaphoreNext = semaphoreNext;
	}

	public Semaphore getSemaphorePrev() {
		return semaphorePrev;
	}

	public void setSemaphorePrev(Semaphore semaphorePrev) {
		this.semaphorePrev = semaphorePrev;
	}

	public Heap getHeap() {
		return heap;
	}

	public void setHeap(Heap heap) {
		this.heap = heap;
	}

	public Truck getTruck() {
		return truck;
	}
	
	public void setTruck(Truck truck) {
		this.truck = truck;
	}

    protected abstract void work() throws InterruptedException;
	
	public abstract boolean finish();
	
	protected abstract void acquire() throws InterruptedException;
	
	protected abstract void release();

	@Override
	public void run() {
		try {
			do {
				acquire();
				System.out.println(getName() + ": work");

				do {
					work();
				}while(!finish());
				
				System.out.println(getName() + ": worked :"+getTimeWork()+" c" );
				System.out.println(getName() + ": Sleep");
				System.out.println("-------------------");
				release();
            } while(!heap.isEmpty());
			System.out.println("++++++++++++++++++++");
			System.out.println(getName() + ": finish");
			System.out.println("++++++++++++++++++++");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
