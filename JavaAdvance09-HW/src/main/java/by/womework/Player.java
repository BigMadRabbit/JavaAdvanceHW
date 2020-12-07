package by.womework;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Player implements Callable<Boolean> {
	private String name;
	
	public Player(String name) {
		this.name = "Player : " + name;
	}		

	public String getName() {
		return name;
	}

	@Override
	public Boolean call() throws Exception {
		long beginConnection = (long) (5 + Math.random() * 15);
        TimeUnit.SECONDS.sleep(beginConnection);
		System.out.println(this.getName() + " connected, connecting time: " + beginConnection + " sec.");
		return null;
	}
	

}
