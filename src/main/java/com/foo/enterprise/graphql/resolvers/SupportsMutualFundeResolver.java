package com.foo.enterprise.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.foo.enterprise.graphql.datafetchers.UnknownAccountTypeFoundException;
import com.foo.enterprise.model.entity.accounts.behaviours.SupportsMutualFunds;

import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;

@Component
public class SupportsMutualFundeResolver implements TypeResolver{

	@Override
	public GraphQLObjectType getType(TypeResolutionEnvironment env) {
		Object javaObject = env.getObject();
		
		GraphQLSchema schema = env.getSchema();
		if (javaObject instanceof SupportsMutualFunds) {
			return (GraphQLObjectType) schema.getObjectType("SupportsMutualFunds");
		} else {
			throw new UnknownAccountTypeFoundException("Unknown interface found.");
		}
	}

}
