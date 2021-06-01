package interfaceAbstractDemo.concretes;

import interfaceAbstractDemo.abstracts.BaseCustomerManager;
import interfaceAbstractDemo.abstracts.CustomerCheckService;
import interfaceAbstractDemo.entities.Customer;
import java.rmi.RemoteException;

public class StarbucksCustomerManager extends BaseCustomerManager{

	private CustomerCheckService customerCheckService;

	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		super();
		this.customerCheckService = customerCheckService;
	}

	@Override
	public void save(Customer customer) throws RemoteException {
	
		if (customerCheckService.checkIfRealPerson(customer)) {
			super.save(customer);
		}
		else {
			throw new RemoteException("Geçerli bir kişi değil");
			
		}
	}
	
	

}
