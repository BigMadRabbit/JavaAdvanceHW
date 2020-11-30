package by.womework;

import java.util.concurrent.Semaphore;

import javax.xml.stream.events.StartDocument;

public abstract class Worker implements Runnable {
	private Heap heap;
	private Truck truck;
	private String name;
	private int timeWork;
	private int priority;
		
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
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
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
	
	protected abstract void next();
	
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
