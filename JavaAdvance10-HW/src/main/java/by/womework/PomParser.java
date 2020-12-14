package by.womework;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.womework.model.Archive;
import by.womework.model.Configuration;
import by.womework.model.Dependency;
import by.womework.model.Execution;
import by.womework.model.Manifest;
import by.womework.model.Plugin;
import by.womework.model.Project;
import by.womework.model.Properties;

public class PomParser extends DefaultHandler {
	private Project project;
	private String thisElement = ""; 
	private String subElement = "";
	
	private Properties properties;
	private List<Dependency> dependencies;
	private List<Plugin> plugins;
	private Plugin plugin;
	private Configuration configuration;
	private List<String> descriptorRefs;
	private Archive archive;
	private Manifest manifest;
	private List<Execution> executions;
	private Execution execution;
	private List<String> goals;
		
	public PomParser() {
        project = new Project();  
        properties = project.getProperties();         
        dependencies = project.getDependencies();
        plugins = project.getBuild().getPlugins();
    }
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parsing XML Document");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		thisElement = convert(qName);

		if(subElement.equals("")) {
			subElement = "project";
		}		
	}
		
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (!thisElement.toString().equals("")) { 
		String value = new String(new String(ch, start, length)).replace("\n", "");
		
		System.out.println(subElement + " "+ thisElement +" : " +value);
		if (subElement.equals("project")) {
			switch (thisElement.toString()) {
			case "modelVersion":
				project.setModelVersion(value);
				break;
			case "groupId":
				project.setGroupId(value);
				break;
			case "artifactId":
				project.setArtifactId(value);
				break;	
			case "version":
				project.setVersion(value);
				break;
			case "name":
				project.setName(value);
				break;
			case "url":
				project.setUrl(value);
				break;				
			default:
				subElement = thisElement;
				break;
			} 
		}
		if (subElement.equals("properties")) {
			switch (thisElement.toString()) {
			case "projectBuildSourceEncoding":
				properties.setProjectBuildSourceEncoding(value);
				break;
			case "mavenCompilerSource":
				properties.setMavenCompilerSource(value);
				break;
			case "mavenCompilerTarget":
				properties.setMavenCompilerTarget(value);
				break;
				
			default:
				subElement = thisElement;
				break;
			}			
		}
		if (subElement.equals("dependencies")) {
			subElement = thisElement;
		}
		if (subElement.equals("dependency")) {
			switch (thisElement.toString()) {
			case "groupId":
				dependencies.add(new Dependency());
				dependencies.get(dependencies.size() - 1).setGroupID(value);
				break;
			case "artifactId":
				dependencies.get(dependencies.size() - 1).setArtifactID(value);
				break;
			case "version":
				dependencies.get(dependencies.size() - 1).setVersion(value);
				break;
			case "scope":
				dependencies.get(dependencies.size() - 1).setScope(value);
				break;	
			default:
				subElement = thisElement;
				break;
			}			
		}
		if (subElement.equals("build")) {
			subElement = thisElement;
		}
		if (subElement.equals("plugins")) {
			
			subElement = thisElement;
		}
		if (subElement.equals("plugin")) {
			switch (thisElement.toString()) {
			case "artifactId":
				plugins.add(new Plugin());
				plugins.get(plugins.size() - 1).setArtifactID(value);
				break;
			case "version":
				plugins.get(plugins.size() - 1).setVersion(value);
				break;
			case "scope":
				dependencies.get(dependencies.size() - 1).setScope(value);
				break;	
			default:
				subElement = thisElement;
				break;
			}			
		}
		if (subElement.equals("descriptorRefs")) {
			subElement = thisElement;
		}
		if(subElement.equals("descriptorRef")) {	
			descriptorRefs = plugins.get(plugins.size() - 1).getConfiguration().getDescriptorRefs();
			descriptorRefs.add(value);
			subElement = thisElement;
		}	
		if(subElement.equals("archive")) {	
			archive = plugins.get(plugins.size() - 1).getConfiguration().getArchive();	
			subElement = thisElement;
	    }		
		if(subElement.equals("manifest")) {
			manifest = archive.getManifest();
			subElement = thisElement;
		}
		if(subElement.equals("mainClass")) {	
			manifest.setMainClass(value);
			subElement = thisElement;
	    }
		if(subElement.equals("executions")) {	
			executions = plugins.get(plugins.size() - 1).getExecutions();
			subElement = thisElement;
	    }
		if (subElement.equals("execution")) {
			switch (thisElement.toString()) {
			case "id":
				executions.add(new Execution());				
				executions.get(executions.size() - 1).setId(value);
				break;
			case "phase":
				executions.get(executions.size() - 1).setPhase(value);
				break;
			default:
				subElement = thisElement;
				break;
			}			
		}
		if (subElement.equals("goals")) {
			switch (thisElement.toString()) {
			case "goal":
				Execution execution = executions.get(executions.size() - 1);
				List<String> goals = execution.getGoals();				
				goals.add(value);
				break;
			default:		
				subElement = thisElement;
				break;
			}
		}
		}
	}
	
		
    private String convert(String name) {
		
		switch (name) {
		case "project.build.sourceEncoding":
			return "projectBuildSourceEncoding";

		case "maven.compiler.source":
			return "mavenCompilerSource";
			
		case "maven.compiler.target":
			return "mavenCompilerTarget";
			
		default:
			return name;
		}
	}
    
    @Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		thisElement = "";
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End parsing XML Document");
		System.out.println(project.toString());
	}	

}
