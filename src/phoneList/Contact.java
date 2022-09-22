package phoneList;

/*
 * This contains info for a single contact
 * 
 * Parameters Needed to Store
 *   - Contact's Name
 *   - Contact's Phone Number
 *   
 * Needed Methods
 *   - Constructor(s)
 *   - getter methods
 *   - Setter methods not necessary unless Constructor
 *        initialize variables.
 *   - Override toString() so that Contact can
 *        be printed as part of a list.
 * 
 */



public class Contact {
	
	private String name;
	private String phonenumber;
	
	public Contact(String newname, String newphone) {
		name = newname;
		phonenumber = newphone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phonenumber;
	}
	
	public void setName(String newname) {
		name = newname;
	}
	
	public void setPhone(String newphone) {
		phonenumber = newphone;
	}
	
	@Override
	public String toString() {
		return "Name: "+name+"\nPhone Number: "+phonenumber;
	}
}
