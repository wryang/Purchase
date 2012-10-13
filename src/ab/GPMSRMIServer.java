package ab;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class GPMSRMIServer {
	public static void main(String[] args) {
		try {
			iGroupPurchaseManagementSystem gpcm = new GroupPurchaseManagementSystemImp();
			LocateRegistry.createRegistry(8888);
			Naming.bind("//localhost:8888/GPMS", gpcm);
			System.out.println("Server start");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}