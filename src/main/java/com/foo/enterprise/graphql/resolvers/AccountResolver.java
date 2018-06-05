package com.foo.enterprise.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.foo.enterprise.graphql.datafetchers.UnknownAccountTypeFoundException;
import com.foo.enterprise.model.entity.accounts.DematAccount;
import com.foo.enterprise.model.entity.accounts.SavingsAccount;

import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;

@Component
public class AccountResolver implements TypeResolver{

	@Override
	public GraphQLObjectType getType(TypeResolutionEnvironment env) {
		
		Object javaObject = env.getObject();
		
		GraphQLSchema schema = env.getSchema();
		if (javaObject instanceof DematAccount) {
			return (GraphQLObjectType) schema.getObjectType("DematAccount");
		} else if (javaObject instanceof SavingsAccount){
			return (GraphQLObjectType) env.getSchema().getObjectType("SavingsAccount");
		} else {
			throw new UnknownAccountTypeFoundException("Unknown account found while resolving the account details.");
		}
	}

}
