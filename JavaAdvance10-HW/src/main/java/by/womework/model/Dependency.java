package by.womework.model;

public class Dependency {
	private String groupID;
    private String artifactID;
    private String version;
    private String scope;
    
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	public void setArtifactID(String artifactID) {
		this.artifactID = artifactID;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "Dependency [groupID=" + groupID + ", artifactID=" + artifactID + ", version=" + version + ", scope="
				+ scope + "]";
	}
    
}
