## Overview
This is a sample implementation of a Demand Driven API which returns different attributes of Customer as requested in the incoming request. This application explains how graph-ql can be used in a complex multi entity schema; for e.g. in this application we assume that a customer can have multiple accounts, each account could have different attributes / charecterstics etc.

### How to Test
This application can be tested using PostMan or its equivalent. It's a Spring Boot application which uses GraphQL Starter project and runs on default port, 8080. Sample request,
{
	customer {
		firstName
		accounts {
			accountNumber
			cashBalance {
				availableCash
				totalCash			
			}
			mutualFundHoldings {
				fundIdentifier
				fundName,
				unitsHeld
			}
		}
		address {
			postCode
		}
	}
}

###ToDo
In this application, I have modelled two types of accounts, DematAccount and SavingsAccount, both of which implement Account interface. Ideally, I wanted my DematAccount to implement multiple interfaces, for e.g. DematAccount implements Accounts, SupportsCashBalance, SupportsMutualFunds, SupportsBrokerageAssets etc. etc. This way I wanted to keep the behaviour of an Account flexible so that both of the Accounts (DemantAccount and SavingsAccount) can be modelled independently. 

While I could do the object modelling, I could not figure out the right way to create the schema file for this. This is something whihc needs to be worked upon in coming days/weeks.
