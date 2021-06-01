package odev3;

public class Main {

	public static void main(String[] args) {
		
		Student murat = new Student();
		murat.setId(1);
		murat.setFirstName("Murat");
		murat.setCallNumber("12345678900");	
		
		Instructor selcuk = new Instructor();
		selcuk.setId(2);
		selcuk.setFirstName("Selçuk");
		selcuk.setBankAccount("IBAN Bilgileri");
	
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(selcuk);
		instructorManager.addCourse();
		
		StudentManager studentManager = new StudentManager();
		studentManager.add(murat);
		studentManager.registerCourse();		
		
	}

}
