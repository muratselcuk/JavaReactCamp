package odev2;

public class Main {

	public static void main(String[] args) {
		Course course1=new Course("Java", "Java - React Kampi", 0);
		Course course2=new Course("C#", "C# Kampi", 0);
		CourseManager courseManager= new CourseManager();
		
		Course[] courses= {course1, course2};
		for (Course course:courses) {
			System.out.println(course.title);
			System.out.println(course.description);
			System.out.println(course.price);
		}
		courseManager.add();
		courseManager.del();
	}

}
