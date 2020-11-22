package by.womework;

import java.util.concurrent.TimeUnit;

public class DoAction implements Runnable {
	private Miner miner;
	private Mine mine;
	private Thread thread;
	
	public DoAction(Miner miner, Mine mine) {
		this.miner = miner;
		this.mine = mine;
		
		thread = new Thread(this);
		thread.start();
	}

	public void getMinerStaus() {
		miner.printMinerStaus();
	}

	public Mine getMine() {
		return mine;
	}
	
	public void join() throws InterruptedException {
		thread.join();
	}

	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.SECONDS.sleep(1);
				if (mine.getTotalGold() == 0) {
					break;
				}
				miner.mine(mine);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
