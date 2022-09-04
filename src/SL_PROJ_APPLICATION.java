import java.util.Scanner;

public class SL_PROJ_APPLICATION {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Menu mn = new Menu();
		int option = 0;
		FolderOperations fo = new FolderOperations();
		String folderPath;
		
		//Welcome Screen
		System.out.println("################################################");
		System.out.println("################################################");
		System.out.println("#######   Welcome to User File operations! #####");
		System.out.println("################################################");
		System.out.println("################################################");
		
		
		System.out.println("\n\n################################################");
		System.out.println("#### FILE OPERATIONS APPLICATION ###########");
		System.out.println("################################################");
		
		//Take the folder path for the application from user.
		do {
		System.out.println("\n Please enter the Application folder path:\n");
		folderPath = sc.next();
		}while(!fo.setFolderPath(folderPath));//Set the folder path where operations are needed.
		
		
		//Take the user choice of operation he intends to perform.
		do {
				mn.showMainMenu();
				String input = sc.next();
				if(!mn.setMainMenuOption(Integer.parseInt(input)))
					continue;
				else
				{
					//Do the needed operation per user selection.
					switch(mn.getSelectedMainMenuOption())
					{
						case 1://List the current list of files in a sorted order.
								fo.displayFileList();
							break;
							
						case 2: //Business operations Sub menu.
							    do{
							    	mn.showBuisinessOperationMenu();
							    	String opt =sc.next();
							    	if(!mn.setBOMenuOption(Integer.parseInt(opt)))
							    			continue;
							    	else
							    	{
							    		switch(mn.getSelectedBOMenuOption())
							    		{
							    		case 1: //Add a file
							    			System.out.println("Enter file to be added with path \n");
							    			String fileToAdd= sc.next();
							    			fo.addFile(fileToAdd);
							    			
							    			break;
							    		case 2: //Delete a file
							    			System.out.println("Enter file to be deleted \n");
							    			String fileToDelete = sc.next();
							    			fo.DeleteFile(fileToDelete);
							    			break;
							    			
							    		case 3://Search a file
							    			System.out.println("Enter the name of file to be Searched \n");
							    			String fileToSearch = sc.next();
							    			fo.SearchFile(fileToSearch);
							    			break;
							    		
							    		default: //Exit
							    			break;
								    		
							    		};
							    		
							    	 }
							    }while(!mn.is_return_to_main_menu());//Return to main menu based on user selection.
		
							
							break;
							
						case 3 : 		
							System.out.println("###### APPLICATION EXITED!! ###########");
							break;//Exit application
					}
				}
			
			}while(!mn.is_program_exit());//Exit the program.
		


	}

}
