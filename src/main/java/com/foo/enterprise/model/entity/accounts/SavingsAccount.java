package com.foo.enterprise.model.entity.accounts;

import com.foo.enterprise.model.entity.account.holdings.Cash;
import com.foo.enterprise.model.entity.account.holdings.MutualFundHolding;

public class SavingsAccount implements Account {

	private String accountNumber;
	private Cash cashBalance;
	
	public SavingsAccount(String accountNumer, 
			Cash cash) {
		this.accountNumber=accountNumer;
		this.cashBalance=cash;
	}

	@Override
	public Cash getCashBalance() {
		return cashBalance;
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public MutualFundHolding[] getMutualFundHoldings() {
		return null;
	}

}
