package com.foo.enterprise.model.entity.account.holdings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MutualFundHolding {
 
	public MutualFundHolding(String fundIdentifier, 
			String fundName, 
			double unitsHeld) {
		this.fundIdentifier=fundIdentifier;
		this.fundName=fundName;
		this.unitsHeld=unitsHeld;
	}
	private String fundIdentifier;
	private String fundName;
	private double unitsHeld;
}
