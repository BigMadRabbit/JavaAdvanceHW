package by.womework.model;


import java.util.ArrayList;
import java.util.List;

public class Plugin {
    private String artifactID;
    private String version;
    private Configuration configuration;
    private List<Execution> executions;

    public Plugin() {
        configuration = new Configuration();
        executions = new ArrayList<>();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public List<Execution> getExecutions() {
        return executions;
    }

	public void setArtifactID(String artifactID) {
		this.artifactID = artifactID;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Plugin [artifactID=" + artifactID + ", version=" + version + ", configuration=" + configuration
				+ ", executions=" + executions + "]";
	}    
  
}
