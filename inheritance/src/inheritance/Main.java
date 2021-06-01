package inheritance;

public class Main {

	public static void main(String[] args) {
		IndividualCustomer murat = new IndividualCustomer();
		murat.customerNumber="12345";
		
		CorporateCustomer selcukBilisim = new CorporateCustomer();
		selcukBilisim.customerNumber="23456";
		
		UnionCustomer abc=new UnionCustomer();
		abc.customerNumber="900";
				
		CustomerManager customerManager = new CustomerManager();
		
		Customer[] customers = {murat, selcukBilisim, abc};
		customerManager.addMultiple(customers);
		
		
	}

}
