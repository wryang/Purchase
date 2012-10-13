package ab;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import assignment3.GroupPurchaseWeb;

public class GPMSRMIClient {
	public static void main(String[] args) {
		try {
			iGroupPurchaseManagementSystem gpms = (iGroupPurchaseManagementSystem) Naming
					.lookup("//localhost:8888/GPMS");
			GPMSProxy gc = new GPMSProxy(gpms);
			GroupPurchaseWeb.launch(gc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
