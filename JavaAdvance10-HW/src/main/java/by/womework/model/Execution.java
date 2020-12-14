package by.womework.model;

import java.util.ArrayList;
import java.util.List;

public class Execution {
    private String id;
    private String phase;
    private List<String> goals;

    public Execution() {
        goals = new ArrayList<>();
    }

	public void setId(String id) {
		this.id = id;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public List<String> getGoals() {
		return goals;
	}

	@Override
	public String toString() {
		return "Execution [id=" + id + ", phase=" + phase + ", goals=" + goals + "]";
	}
    
}