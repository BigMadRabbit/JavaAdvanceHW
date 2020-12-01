package by.womework;

import java.util.concurrent.Semaphore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        
    	Semaphore loaderSemaphore    = new Semaphore(0);
    	Semaphore truckerSemaphore   = new Semaphore(0);
		Semaphore unloaderSemaphore  = new Semaphore(0);
		
		Heap heap   = new Heap(100);
		Truck truck = new Truck(6);
		
		Loader  loader    = new Loader("Loader", 3, loaderSemaphore, truckerSemaphore);
		loader.setHeap(heap);
		loader.setTruck(truck);
		
		Trucker trucker   = new Trucker("Trucker", 5, truckerSemaphore, unloaderSemaphore);
		trucker.setHeap(heap);
		trucker.setTruck(truck);
		trucker.setSemaphorePrev(loaderSemaphore);
		
		UnLoader unloader = new UnLoader("UnLoader", 2, unloaderSemaphore, truckerSemaphore);
		unloader.setHeap(heap);
		unloader.setTruck(truck);
		
		
		loader.start();
		trucker.start();
		unloader.start();
		
		loaderSemaphore.release();
    	
    }
}
