package by.womework.model;

public class Archive {
    private Manifest manifest;

    public Archive() {
        manifest = new Manifest();
    }

    public Manifest getManifest() {
        return manifest;
    }

	@Override
	public String toString() {
		return "Archive [manifest=" + manifest + "]";
	}
    
}
