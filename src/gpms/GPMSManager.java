package gpms;

import activemq.BankSystemProxy;
import assignment3.BankSystem;
import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseManagementSystemFactory;
import assignment3.ShortMessageSender;

public class GPMSManager {
	public static GroupPurchaseManagementSystem getInstance() {
		ShortMessageSender sms = new ShortMessageSender(){

			@Override
			public boolean sendMessage(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		BankSystem bank = new BankSystemProxy();
		
		GroupPurchaseManagementSystem gpms = GroupPurchaseManagementSystemFactory.createGroupPurchaseManagementSystem(sms, bank);
		return gpms;
	}
}
