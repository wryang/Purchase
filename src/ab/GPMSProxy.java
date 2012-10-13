package ab;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import assignment3.GroupPurchaseItem;
import assignment3.GroupPurchaseManagementSystem;

public class GPMSProxy implements GroupPurchaseManagementSystem{

	private iGroupPurchaseManagementSystem gpms;
	
	public GPMSProxy(iGroupPurchaseManagementSystem gpmsImp) {
		gpms = gpmsImp;
	}
	
	@Override
	public List<GroupPurchaseItem> listGroupPurchase() {
		try {
			return gpms.listGroupPurchase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ArrayList<GroupPurchaseItem>();
	}

	@Override
	public boolean submitPurchase(String itemId, String bankAccount, String password,
			String phone) {
		boolean result = false;
		try {
			result = gpms.submitPurchase(itemId, bankAccount, password, phone);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean confirmPurchase(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean publishGroupPurchaseItem(String arg0, String arg1,
			String arg2, double arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}

}
