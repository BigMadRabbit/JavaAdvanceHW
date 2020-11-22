package by.womework;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
    	Mine mine = new Mine(1000);
    	Barrak barrak = new Barrak();
    	ArrayList<DoAction> actions = new ArrayList<>();
    	
    	for (int i = 0; i < 5; i++) {
    		actions.add(new DoAction(barrak.createMiner(), mine));
		}
    	
    	int i = 1;
		try {
	    	while(true) {
	    		TimeUnit.SECONDS.sleep(1);
	    		if (mine.getTotalGold() == 0) {
	    			break;
	    		}
	    		
	    		for (DoAction action : actions) {
	    			action.getMinerStaus();
				}
	    		
	    		System.out.println("");
	    		System.out.println("Total Gold: " + mine.getTotalGold());
	    		System.out.println("Time work: " + i++);
	    		System.out.println("----------------------------------------------");
	    		
	    		if (i % 10 == 0) {
	    			actions.add(new DoAction(barrak.createMiner(), mine));
	    		}
	    	}
	    	
	    	System.out.println("");
	    	System.out.println("All time work: " + i);
	    	System.out.println("Total for all miners:");
			for (DoAction action : actions) {
				action.join();
				action.getMinerStaus();
			}
			System.out.println("----------------------------------------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
