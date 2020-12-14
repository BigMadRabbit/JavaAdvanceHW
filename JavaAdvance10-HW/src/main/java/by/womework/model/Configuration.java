package by.womework.model;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private List<String> descriptorRefs;
    private Archive archive;

    public Configuration() {
        descriptorRefs = new ArrayList<>();
        archive = new Archive();
    }

	public List<String> getDescriptorRefs() {
		return descriptorRefs;
	}

	public Archive getArchive() {
		return archive;
	}

	@Override
	public String toString() {
		return "Configuration [descriptorRefs=" + descriptorRefs + ", archive=" + archive + "]";
	}
    
}
