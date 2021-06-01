package odev3;

public class StudentManager extends UserManager{
	
	public void add(User user) {
		System.out.println("Öğrenci eklendi : " + user.getId()+ " "+ user.getFirstName());
		
	}
	
	public void registerCourse() {
		System.out.println("Ders Kayıt olundu.");

	}
	
	
	
	public void delCourse() {
		System.out.println("Ders Kaydı silindi.");

	}


}
