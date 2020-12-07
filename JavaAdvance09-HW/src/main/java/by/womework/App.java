package by.womework;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class App {

	
    public static void main( String[] args ){
		final int countPlayers = 5;
		ExecutorService es = Executors.newFixedThreadPool(countPlayers);		
    	ArrayList<Future<Boolean>> listPlaers = new ArrayList<>(countPlayers);
    	
    	final long beginMain = System.nanoTime();
    	final long waitingTimeout = 15 * 1000_000_000L;
    	
    	for (int i = 0; i < countPlayers; i++) {
    		listPlaers.add(es.submit(new Player(Integer.toString(i))));
		}    	
    	System.out.println("Starting connecting to Dota2 server");
    	
    	try {
   			for (Future<Boolean> player : listPlaers) {
			  player.get(waitingTimeout - (System.nanoTime() - beginMain), TimeUnit.NANOSECONDS);    			
			}	
    		System.out.println("Dota2 has started successfully"); 
    			
		} catch (InterruptedException | ExecutionException e) {				
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println( "Connection lost. This game is safe to leave");
		}	
		es.shutdown();  
	
    }
}
