package by.womework;

public class Miner {
	private String name;
	private int gold;

	public Miner(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getGold() {
		return gold;
	}

	public void mine(Mine mine) {
		gold += mine.getGold(3);
	}

	public void printMinerStaus() {
		System.out.println(String.format("Miner %s, gold: %s", this.name,this.gold));
	}
}
