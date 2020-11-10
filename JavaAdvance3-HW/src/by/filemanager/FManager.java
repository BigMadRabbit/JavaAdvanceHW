package by.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FManager {
	
	FManager (){
	  try {
		Path path   = Paths.get("").toAbsolutePath();	
		Path pathTo = Paths.get("").toAbsolutePath();	
		File file = new File(path.toString());
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("Hello, this is a simple File manager");
		System.out.println("Exit - exit");
		System.out.println("Change folder - cd 'dir'");
		System.out.println("View files in filder - dir");
		System.out.println("Copy file - copy 'file1' 'file2'");
		System.out.println(" ");		
		
		System.out.println(file.getAbsolutePath().toString()+">");
		while(true) {	
			String[] subLines = scanner.nextLine().toString().split(" ");
						    
			switch (subLines[0].toLowerCase()) {
			  case "exit":
				System.exit(0);
				scanner.close();				
			  break;
			  case "dir":
			    System.out.println(" Содержимое "+file.getAbsolutePath().toString());
				for(File f : file.listFiles()) {
				  if(f.isDirectory()) {
					  System.out.println("<dir> "+f.getName());
				  }		
				}
				for(File f : file.listFiles()) {
				  if(f.isFile()) {
				     System.out.println("      "+f.getName());
			 	  }
				}					
			  break;
			  case "cd":
			   	if(subLines.length >= 2) {
			      if (subLines[1].equals("..")) {
				   	if (file.getParentFile() != null) {
				      file = file.getParentFile();	
				    }
				  } else {
				    for(File f : file.listFiles()) {
				      if(f.isDirectory()) {
				        if(f.getName().equals(subLines[1])) {								        
					      file = new File(file.getAbsolutePath().toString()+"\\"+subLines[1]);	
				        } else {
						  file = new File(subLines[1]);	
						}
				      }
				    }			
				  }
				}
			  break;
			  case "copy":
				if(subLines.length >= 3) {
				  if(subLines[1].toString().indexOf(":") > 0) {
				    path = Paths.get(subLines[1]);   
				  } else {
					path = Paths.get(file.getAbsolutePath()+"\\"+subLines[1]);
				  }
				  if(Files.exists(path)) {	
			  	    if(subLines[2].toString().indexOf(":") > 0) {
					  pathTo  = Paths.get(subLines[2]);		
					} else {
					  pathTo = Paths.get(file.getAbsolutePath()+"\\"+subLines[2]);    
					}
					try {
					  System.out.println(path.toAbsolutePath().toString()+"  "+pathTo.toAbsolutePath().toString() );
					  Files.copy(path, pathTo, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
					}  				  
				  } else {
					System.out.println("File not found: "+path.toAbsolutePath().toString());  
				  }
				}
			  break;
			  default:					
				System.out.println(" Неизвестная команда'"+ subLines[0] +"'");
			  break;
			}
			System.out.println("");
			System.out.print(file.getAbsolutePath().toString()+">");
	    }
	  } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.exit(-1);
	  }
		
	}	

}
