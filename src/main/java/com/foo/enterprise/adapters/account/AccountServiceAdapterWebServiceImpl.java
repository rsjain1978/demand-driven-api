package com.foo.enterprise.adapters.account;

import org.springframework.stereotype.Component;

import com.foo.enterprise.model.entity.account.holdings.Cash;
import com.foo.enterprise.model.entity.account.holdings.MutualFundHolding;
import com.foo.enterprise.model.entity.accounts.Account;
import com.foo.enterprise.model.entity.accounts.DematAccount;
import com.foo.enterprise.model.entity.accounts.SavingsAccount;
import com.foo.enterprise.model.entity.customer.Customer;

@Component
public class AccountServiceAdapterWebServiceImpl {

	public Customer populateAccountDetails(Customer customer) {
		
		Cash cash = new Cash(129.23f,122.22f,100f);
		
		MutualFundHolding[] fundHoldings = new MutualFundHolding[1];
		MutualFundHolding holding1 = new MutualFundHolding("isin1","xyx focus fund",100);
		fundHoldings[0]=holding1;
				
		DematAccount dematAccount = new DematAccount("accountnumber1234",cash, fundHoldings);
		SavingsAccount savingAccount = new SavingsAccount("accountnumber1234",cash);
		
		Account[] accounts = new Account[2];
		accounts[0]=dematAccount;
		accounts[1]=savingAccount;
		
		customer.setAccounts(accounts);
		
		return customer;
	}

}
