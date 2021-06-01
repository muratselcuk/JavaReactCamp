package interfaceAbstractDemo.abstracts;
import interfaceAbstractDemo.entities.Customer;
import java.rmi.RemoteException;
public interface CustomerService {

	void save(Customer customer) throws RemoteException;
}
