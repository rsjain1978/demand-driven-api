package com.foo.enterprise.model.commons.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

	public Address(String line1, 
			String line2,
			String postCode) {
		this.line1=line1;
		this.line2=line2;
		this.postCode = postCode;
	}
	private String line1;
	private String line2;
	private String postCode;
	
}
