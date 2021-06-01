package odev3;

public class Student extends User{
	String callNumber;
	boolean contactPermission;
	
	public String getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	public boolean isContactPermission() {
		return contactPermission;
	}
	public void setContactPermission(boolean contactPermission) {
		this.contactPermission = contactPermission;
	}

}
