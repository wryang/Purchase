package ab;

import gpms.GPMSManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import assignment3.GroupPurchaseItem;
import assignment3.GroupPurchaseManagementSystem;

public class GroupPurchaseManagementSystemImp extends UnicastRemoteObject
		implements iGroupPurchaseManagementSystem {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5721944397126148291L;
	private GroupPurchaseManagementSystem gpms;

	protected GroupPurchaseManagementSystemImp() throws RemoteException {
		super();
		gpms = GPMSManager.getInstance();
	}

	@Override
	public List<GroupPurchaseItem> listGroupPurchase() {
		return gpms.listGroupPurchase();
	}

	@Override
	public boolean submitPurchase(String itemId, String bankAccount,
			String password, String phone) {
		return gpms.submitPurchase(itemId, bankAccount, password, phone);
	}

}
