package ab;

import java.rmi.Remote;
import java.util.List;

import assignment3.GroupPurchaseItem;

public interface iGroupPurchaseManagementSystem extends Remote {
	List<GroupPurchaseItem> listGroupPurchase() throws java.rmi.RemoteException;

	boolean submitPurchase(String itemId, String bankAccount, String password,
			String phone) throws java.rmi.RemoteException;
}
