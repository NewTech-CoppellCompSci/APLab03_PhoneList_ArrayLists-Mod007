package phoneList;

import java.util.Scanner;
import java.util.ArrayList;

/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the 
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */


public class PhoneList {

	/*
	 * Instance Variables
	 */
	private ArrayList<Contact> list;
	//the phone number is a string since we wont be needing to edit it like an int/double
	private String name, phone;
	private Contact contact;
	
	//Constructor
	public PhoneList() {
		//initialize instance variables
		list = new ArrayList<Contact>();
		phone = "";
		name = "";
	}
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for contact's name and number
	 *   - create a new Contact object with that input
	 *   - add that object to the phone list
	 *        in alphabetical order
	 *        Hint: compareTo(String other)
	 *   - tell the user what the new contact is and that 
	 *        it's been added
	 */
	public void addContact() {
		name = getString("What is the name of the new contact?");
		phone = getString("What is the phone number of the new contact?");
		// making a new contact object, the variable name doesn't have to be unique since its data is
		contact = new Contact(name, phone); 
		int j = 1, i = 0;
		if (list.size() == 0) {
			list.add(contact);
		}
		else {
			for (i = 0; i <= list.size() && j != -1 && j != 0; i++) { //run until either list ends or j is 0 or -1
				 //compareTo gives result of +1, -1, or 0 based off its alphabetical order
				j = name.compareToIgnoreCase((list.get(i)).getName());
			}
			if (j == -1 || j == 0 || i == list.size()) {
				list.add(i,contact);
			}
		}
	}
	
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for the contact's name
	 *   - search through the list for that contact
	 *   - if the contact is not found
	 *        tell the user and end the method
	 *   - if the contact is found
	 *        Remove the item from the list
	 *        Print the contact's name and number
	 *        Say that contact has been removed
	 *        Remove the item from the list
	 *        
	 */
	public void removeContact() {
		name = getString("What is the name of the contact you wish to remove? (CAPS Sensitive)");
		int j = 1, i = 0;
		for (i = 0; i <= list.size() && j != 0; i++) {
			j = name.compareTo((list.get(i)).getName());
		}
		if (j == 0) {
			list.remove(i);
		}
		else if (j == 1 || j == -1) {
			System.out.println("ERROR 404 - We could not find the contact you were looking for.");
		}
	}
	
	
	/*
	 * This should
	 *   - Print all items in list
	 *   - Must be headers for all columns
	 *   - print in alphabetical order
	 *   - print line of something to "box" the list
	 *       Examples:
	 *          *****************
	 *          -----------------
	 *          #################
	 */
	public void printList() {
		int i = 0, j = 0;
		System.out.println("-LIST OF CONTACTS-"+"\nContacts - "+list.size()+"\n-----------------");
		for (i = 0; i <= list.size(); i++) {
			System.out.println((list.get(i)).getName()+" - "+(list.get(i)).getPhone());
			System.out.println("-------");
		}
		System.out.println("-END OF CONTACT LIST-");	
	}

	
	
	/*
	 * GET FAMILIAR WITH THIS MENU!!!!
	 * 
	 * I will be asking you to create programs with menus.
	 * You may do them however you like.  But here is an example
	 * of how to manage them.
	 * 
	 */
	public void menu() {
		
		int input = 0;
		
		String menu = "-----------------------\n"
				    + "     Contacts Menu     \n"
				    + "-----------------------\n"
				    + "  1 - Add Contact      \n"
				    + "  2 - Remove Contact   \n"
				    + "  3 - Print List       \n"
				    + "  4 - Quit             \n\n"
				    + "Enter Choice: ";
		
		while (input != 4) {  //keep looping till user want's to quit
			
			//try getting an input
			try {
				String inputString = getString("\n" + menu);  //get input
				input = Integer.valueOf(inputString);  //try converting to int
			}
			catch (Exception e) {
				//if bad input, set input to 0
				input = 0;  
			}
		
			switch (input) {
			case 1:
				//handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				//handle menu line 2: Remove Contact
				removeContact();
				break;
			case 3:
				//handle menu line 3: Print List
				printList();
				break;
			case 4:
				//handle menu line 4: Quit
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("\nNot a valid input.\n"
								 + "Please try again.");
			}
			
			
		
		}
		
	}
	
	public String getString(String str) {
		
		Scanner inKey = new Scanner(System.in);
		System.out.print(str);  //notice it's NOT a print line.  This way input is next to question.
		String b = inKey.nextLine();
		return b;
		
	}
	
	
	public static void main(String[] args) {
		PhoneList app = new PhoneList();
		app.menu();
	}
}
