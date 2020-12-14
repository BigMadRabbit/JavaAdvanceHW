package by.womework.model;

import java.util.ArrayList;
import java.util.List;

public class Build {

	private List<Plugin> plugins;

    public Build() {
        plugins = new ArrayList<>();
    }

    public List<Plugin> getPlugins() {
        return plugins;
    }
    
    @Override
	public String toString() {
		return "Build [plugins=" + plugins + "]";
	}
}
