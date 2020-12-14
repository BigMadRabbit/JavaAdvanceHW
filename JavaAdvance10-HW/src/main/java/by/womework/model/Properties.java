package by.womework.model;

public class Properties {
    private String projectBuildSourceEncoding;
    private String mavenCompilerSource;
    private String mavenCompilerTarget;
    
	public void setProjectBuildSourceEncoding(String projectBuildSourceEncoding) {
		this.projectBuildSourceEncoding = projectBuildSourceEncoding;
	}
	public void setMavenCompilerSource(String mavenCompilerSource) {
		this.mavenCompilerSource = mavenCompilerSource;
	}
	public void setMavenCompilerTarget(String mavenCompilerTarget) {
		this.mavenCompilerTarget = mavenCompilerTarget;
	}
	@Override
	public String toString() {
		return "Properties [projectBuildSourceEncoding=" + projectBuildSourceEncoding + ", mavenCompilerSource="
				+ mavenCompilerSource + ", mavenCompilerTarget=" + mavenCompilerTarget + "]";
	}

    
}
