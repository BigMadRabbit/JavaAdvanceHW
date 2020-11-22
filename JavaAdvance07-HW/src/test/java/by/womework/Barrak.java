package by.womework;

public class Barrak {

	private int id;
		
	public Miner createMiner() {
		return new Miner("Miner №:" + ++id);
	}
	
}
