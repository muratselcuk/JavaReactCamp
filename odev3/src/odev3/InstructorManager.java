package odev3;

public class InstructorManager extends UserManager{
	
	
	public void add(User user) {
		System.out.println("Eğitmen eklendi : " + user.getId() + " "+ user.getFirstName());
		
	}
	
	public void addCourse() {
		
		System.out.println("Ders Eklendi");

	}
	
	
	public void delCourse() {

		System.out.println("Ders Silindi");
		
	}


}
