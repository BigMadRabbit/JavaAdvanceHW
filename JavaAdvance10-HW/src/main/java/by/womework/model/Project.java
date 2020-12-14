package by.womework.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String modelVersion;
	private String groupId;	
	private String artifactId;
	private String version;
	private String name;
	private String url;
	private Properties properties;
	private List<Dependency> dependencies;
	private Build build;
	
	public Project() {
        properties = new Properties();
        dependencies = new ArrayList<>();
        build = new Build();
        dependencies = new ArrayList<>();
    }

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Properties getProperties() {
		return properties;
	}

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public Build getBuild() {
		return build;
	}

	@Override
    public String toString() {
        return "Project{" +
                "modelVersion='" + modelVersion + '\'' +
                ", groupID='" + groupId + '\'' +
                ", artifactID='" + artifactId + '\'' +
                ", version='" + version + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", properties=" + properties +
                ", dependencies=" + dependencies +
                ", build=" + build +
                '}';
    } 

}
