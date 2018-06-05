package com.foo.enterprise.model.entity.accounts;

import com.foo.enterprise.model.entity.accounts.behaviours.SupportsCashBalance;
import com.foo.enterprise.model.entity.accounts.behaviours.SupportsMutualFunds;

public interface Account extends SupportsCashBalance, SupportsMutualFunds{

	public String getAccountNumber();
	
}
