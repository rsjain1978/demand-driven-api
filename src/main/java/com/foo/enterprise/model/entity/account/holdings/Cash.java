package com.foo.enterprise.model.entity.account.holdings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cash {

	public Cash(float availableCash, 
			float totalCash, 
			float reservedcash) {
		this.availableCash=availableCash;
		this.totalCash=totalCash;
		this.reservedcash=reservedcash;
	}
	private float availableCash;
	private float totalCash;
	private float reservedcash;
}
