package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOSerialization {

	public static String projectPath = "projects/";
	
	static
	{
		File folder = new File(projectPath);
		if(!folder.exists())
		{
			System.out.println("creating folder directory");

		    try{
		        folder.mkdir();
		    } 
		    catch(SecurityException se){
		        System.err.print("Can't create Project Folder");
		        System.exit(1);
		    }   
		}
	}
	
	public static ArrayList<Project> readProjects()
	{
		ArrayList<Project> projects = new ArrayList<Project>();
		
		File dir = new File(projectPath);

        File[] files = dir.listFiles(new FilenameFilter() { 
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith(".proj"); }
        } );
		
        for(File f : files)
        {
        	Project p = null;
        	try {
				FileInputStream fileInput = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(fileInput);
				
				p = (Project)in.readObject();
				
				in.close();
				fileInput.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				p = null;
			}
        	if(p!= null) projects.add(p);
        }
        
		return projects;
	}
	
	public static void saveAll(ArrayList<Project> projects)
	{
		for(Project p : projects) save(p);
	}
	
	public static void save(Project p)
	{
		String filename = projectPath+p.name + ".proj";
		try {
			FileOutputStream fileOutput = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOutput);
			
			out.writeObject(p);
			
			out.close();
			fileOutput.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
