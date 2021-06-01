package mernisCheck;

import java.rmi.RemoteException;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class Main{

  public static void main(String[] args) throws RemoteException {
  
    KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
    
    boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(
            Long.parseLong("12345678901"),
            "MURAT",
            "SELÇUK",
            1900
            );
    System.out.println("Doğrulama durumu : gerçek kişi " + (result ? "" : "değil"));
    
  }
  
}
//Kaynak: https://karcanozbal.medium.com/java-web-servis-client-mernis-kimlik-do%C4%9Frulama-sistemi-86163b6286f9
