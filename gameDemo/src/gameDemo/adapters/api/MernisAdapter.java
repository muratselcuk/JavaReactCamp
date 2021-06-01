package gameDemo.adapters.api;

import java.rmi.RemoteException;
import java.util.Locale;

import gameDemo.adapters.service.GamerVerifyService;
import gameDemo.entities.concretes.Gamer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter implements GamerVerifyService{

	@Override
	public boolean chekIfRealPerson(Gamer gamer) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();		
		boolean result= true;
		
		try {
		
		result = client.TCKimlikNoDogrula(Long.parseLong(gamer.getNationalId()),
				gamer.getFirstName().toUpperCase(new Locale("tr")), 
				gamer.getLastName().toUpperCase(new Locale("tr")), 
				gamer.getDateOfBirth());
		
		}
		
		catch (RemoteException | NumberFormatException e1) {
			e1.printStackTrace();
		}
		
		return result;
		
		}
		
}
