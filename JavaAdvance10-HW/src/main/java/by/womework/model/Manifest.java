package by.womework.model;

public class Manifest {
    private String mainClass;

	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}

	@Override
	public String toString() {
		return "Manifest [mainClass=" + mainClass + "]";
	}
    
}
