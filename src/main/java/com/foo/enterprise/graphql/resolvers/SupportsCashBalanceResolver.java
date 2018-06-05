package com.foo.enterprise.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.foo.enterprise.graphql.datafetchers.UnknownAccountTypeFoundException;
import com.foo.enterprise.model.entity.accounts.behaviours.SupportsCashBalance;

import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;

@Component
public class SupportsCashBalanceResolver implements TypeResolver{

	@Override
	public GraphQLObjectType getType(TypeResolutionEnvironment env) {
		Object javaObject = env.getObject();
		
		GraphQLSchema schema = env.getSchema();
		if (javaObject instanceof SupportsCashBalance) {
			return (GraphQLObjectType) schema.getObjectType("SupportsCashBalance");
		} else {
			throw new UnknownAccountTypeFoundException("Unknown interface found.");
		}
	}

}
