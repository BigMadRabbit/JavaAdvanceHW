package by.womework;

public class Mine {
	private volatile int gold;

	public Mine(int gold) {
		this.gold = gold;
	}

	public synchronized int getTotalGold() {
		return gold;
	}

	public synchronized int getGold(int quantity) {
		int result = Math.min(gold, quantity);
		
		gold -= result;
		return result;
	}

}
