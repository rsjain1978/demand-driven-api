package com.foo.enterprise.model.entity.accounts;

import com.foo.enterprise.model.entity.account.holdings.Cash;
import com.foo.enterprise.model.entity.account.holdings.MutualFundHolding;

public class DematAccount implements Account{

	private String accountNumber;
	private Cash cashBalance;
	private MutualFundHolding[] mutualFundHoldings;
	
	public DematAccount(String accountNumber, 
			Cash cash, 
			MutualFundHolding[] fundHoldings) {
		this.accountNumber=accountNumber;
		this.cashBalance=cash;
		this.mutualFundHoldings=fundHoldings;
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public Cash getCashBalance() {
		return cashBalance;
	}

	@Override
	public MutualFundHolding[] getMutualFundHoldings() {
		return mutualFundHoldings;
	}

}
