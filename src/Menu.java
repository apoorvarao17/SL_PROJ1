
public class Menu {
	
	 enum menu_option{NONE, SHOW_FILES_SORTED, BUSINESS_OPERATIONS, EXIT};
	 
	 enum business_operation_menu_options{ NONE, ADD_FILE, DELETE_FILE, SEARCH_FILE, RETURN};
	
	 private menu_option user_selection;
	 private business_operation_menu_options buis_menu_option;
	 
	 //Constructor
	 public void Menu()
	 {
		 user_selection = menu_option.NONE;
		 buis_menu_option = business_operation_menu_options.NONE;
	 }
	 
	 //Get selected option from MainMenu
	 public int getSelectedMainMenuOption()
	 {
		 return user_selection.ordinal();
	 }
	 
	 //Get selection option from Business operations Submenu
	 public int getSelectedBOMenuOption()
	 {
		 return buis_menu_option.ordinal();
	 }
	 
	 //Set User selected option for MainMenu
	 public boolean  setMainMenuOption(int userInputVal)	 
	 {
		 for (menu_option i:menu_option.values())
		 {
			 if (i.equals(menu_option.values()[userInputVal])) {
				 user_selection = menu_option.values()[userInputVal] ;
				 return true;
			 }
		 }
		 System.out.println("Invalid option. Please re-enter");
		 return false;
	 }
	//Set User selected Business operations Sub menu option
	public boolean  setBOMenuOption(int userInputVal)	 
	{
		for (business_operation_menu_options i:business_operation_menu_options.values())
		{
			if (i.equals(business_operation_menu_options.values()[userInputVal])) {
			buis_menu_option = business_operation_menu_options.values()[userInputVal] ;
			return true;
			}
		}
		System.out.println("Invalid option. Please re-enter");
		return false;
	}
	//Method that return true if user selection is program exit
	public boolean is_program_exit()
	{
		return user_selection.equals(menu_option.EXIT);
	}
	
	//Method that returns true if user selection is return to main menu from BO submenu; 
	public boolean is_return_to_main_menu()
	{
	    return buis_menu_option.equals(business_operation_menu_options.RETURN);
	}
	
	//Method to display Main Menu options with welcome message
	public void showMainMenu()
	{			
		System.out.println("\n\n################################################");
		System.out.println("#### FILE OPERATIONS APPLICATION ###########");
		System.out.println("################################################");
		
		 System.out.println("Choose what you want to do \n\n");
		 int j=1;
		 for (menu_option i:menu_option.values())
		 {
			 if(!i.equals(menu_option.NONE))
			 {
				 System.out.println("Enter \"" +j+ "\"  for   " + i.toString());
				 j++;
			 }
		 }
		 System.out.println("\n Enter option : ");
		 
	}
	//Show Buisiness operations menu
	public void showBuisinessOperationMenu()
	{			
		 System.out.println("\n\n #### BUSINESS OPERATIONS ###########");
		 System.out.println("Choose what you want to do \n\n");
		 int j=1;
		 for (business_operation_menu_options i:business_operation_menu_options.values())
		 {
			 if(!i.equals(business_operation_menu_options.NONE))
				 {
				 System.out.println("Enter \"" +j+ "\"  for   " + i.toString());
				 j++;
				 }
			
		 }
		 System.out.println("\n Enter Option : ");
		 
	 }

}
