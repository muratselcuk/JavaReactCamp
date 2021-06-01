package interfaceAbstractDemo.abstracts;

import interfaceAbstractDemo.entities.Customer;
import java.rmi.RemoteException;

public abstract class BaseCustomerManager implements CustomerService {

	@Override
	public void save(Customer customer) throws RemoteException{

		System.out.println("veritabanına kaydet " + customer.getFirstName());
	}

}
