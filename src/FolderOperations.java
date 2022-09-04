import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class FolderOperations {
	
	private String folderPath;
	private String[] fileList; //Sorted file list
	
	//Constructor
	public void FolderOperations()
	{
		folderPath = new String();
		folderPath = null;
	}
	// Set the user given folder path of the Application that needs the file operations
	public boolean setFolderPath(String fp)
	{
		boolean status = false;
		File fl = new File(fp);
			
		if(fl.isDirectory()) //if path is of a folder.
		{
			folderPath = fp;
			refresh_list();
			status= true;
		}
		else
		{
			folderPath = null;
			System.out.println("Folder does not exist. Recheck folder path");
			status =false;
		}
		return status;
	}
	//Refreshes the list and sorts it. To be use after file operations Add and Delete.
	private void refresh_list()
	{
		File fl = new File(folderPath);
		fileList = fl.list();
		Arrays.sort(fileList);
	}
	
	//Display list of files int he user input application folder.
	public void displayFileList()
	{
		if(folderPath == null) 
		{
			System.out.println("Folder path not entered or is Invalid");
		}
		else
		{
			int i=0;
			for(String s:fileList)
			{
				i++;
				System.out.println(i+": "+s);
			}
		 }
	 }
	
	//Add a file to the application folder from another location. 
	public void addFile(String fileNameWithPath) {
		
		if(folderPath != null && fileNameWithPath != "")
		{
			File fromFile = new File(fileNameWithPath);
			File toDirectoryPath = new File(folderPath + "\\" + fromFile.getName());

			try {
				copyFile(fromFile,toDirectoryPath);
				refresh_list();	
				System.out.println("File "+ fromFile.getName() +" -Added Successfully");
			}
			catch (IOException e) {
				System.out.println("Error:Unable to Add file - IO Exception \n");
				e.printStackTrace();
			}
	    }
	}
	//Utility method to create or add a file to application folder from a different location.
	private static void copyFile(File sourceFile, File destFile)
	        throws IOException {
	    if (!sourceFile.exists()) {
	        return;
	    }
	    if (!destFile.exists()) {
	        destFile.createNewFile();
	    }
	    FileChannel source = null;
	    FileChannel destination = null;
	    source = new FileInputStream(sourceFile).getChannel();
	    destination = new FileOutputStream(destFile).getChannel();
	    if (destination != null && source != null) {
	        destination.transferFrom(source, 0, source.size());
	    }
	    if (source != null) {
	        source.close();
	    }
	    if (destination != null) {
	        destination.close();
	    }

	}
	
	//Delete a file with name given by user.
	public void DeleteFile(String fileName)
	{
		File f = new File(folderPath);
		
		for (File i:f.listFiles())
		{
			String fn =i.getName();
			if(fn.compareTo(fileName) == 0)
			{
				boolean status = i.delete();
				
				if (status)
				{
					System.out.println("File "+i.getName()+" Deleted!");
				}
				else
				{
					System.out.println("Unable to delete"+i.getName());
				}
				refresh_list();
				return;
			}
		}
		System.out.println(fileName +" -File not Found");
	}

	//Search a file given by user in the Application folder and annuciate found/Not found.
	public void SearchFile(String fileToSearch) {
		
		for(String i: fileList)
		{
			if(i.compareTo(fileToSearch) == 0 ) {
				
				System.out.println("File:"+ fileToSearch +" Found");
				return;	
			}
		}
		System.out.println("File:"+ fileToSearch +" NOT Found");		
	}
}
