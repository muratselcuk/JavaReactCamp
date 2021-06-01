package interfaceAbstractDemo.abstracts;

import java.rmi.RemoteException;

import interfaceAbstractDemo.entities.Customer;

public interface CustomerCheckService {

	boolean checkIfRealPerson(Customer customer) throws RemoteException;
	
}
