package interfaces;

public class Main {

	public static void main(String[] args) {

		Logger[] loggers= { new SmsLogger(), new EmailLogger(), new FileLogger() };
		
		CustomerManager customerManager = new CustomerManager(loggers);
		
		Customer murat = new Customer(1,"Murat", "Selçuk");
				
		customerManager.add(murat);
	}

}
