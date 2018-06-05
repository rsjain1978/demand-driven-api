package com.foo.enterprise.graphql;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.foo.enterprise.graphql.datafetchers.CustomerDataFetcher;
import com.foo.enterprise.graphql.resolvers.AccountResolver;
import com.foo.enterprise.graphql.resolvers.SupportsCashBalanceResolver;
import com.foo.enterprise.graphql.resolvers.SupportsMutualFundeResolver;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.RuntimeWiring.Builder;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQLService {
	
	private GraphQL graphQLObject;
	
	@Value("classpath:customer.graphqls")
	private Resource customerResourceLoader;
	
	@Value("classpath:account.graphqls")
	private Resource accountResourceLoader;
	
	@Autowired
	CustomerDataFetcher customerDataFetcher;
	
	@Autowired
	AccountResolver accountResolver;

	@Autowired
	SupportsCashBalanceResolver supportsCashBalanceResolver;
	
	@Autowired
	SupportsMutualFundeResolver supportsMutualFundeResolver;
	
	@PostConstruct
	private void loadGraphQLSchema() {
		
		SchemaParser schemaParser = new SchemaParser();
		SchemaGenerator schemaGenerator = new SchemaGenerator();

		try {
			File customerSchemaFile = (File) customerResourceLoader.getFile();
			File accountSchemaFile = (File) accountResourceLoader.getFile();
	
			TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
			typeRegistry.merge(schemaParser.parse(customerSchemaFile));
			typeRegistry.merge(schemaParser.parse(accountSchemaFile));
			
			RuntimeWiring wiring = buildRuntimeWiring();
			
			GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
			graphQLObject = GraphQL.newGraphQL(graphQLSchema).build();
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new UnableToLoadSchemeException("Unable to load schema files");
		}
	}
	
	RuntimeWiring buildRuntimeWiring() {
	    Builder newRuntimeWiring = RuntimeWiring.newRuntimeWiring();
	    newRuntimeWiring.type("Query", typeWiring -> typeWiring.dataFetcher("customer", customerDataFetcher));
	    newRuntimeWiring.type("Interface", typeWiring->typeWiring.typeName("Account").typeResolver(accountResolver));
	    newRuntimeWiring.type("Interface", typeWiring->typeWiring.typeName("SupportsCashBalance").typeResolver(supportsCashBalanceResolver));
	    newRuntimeWiring.type("Interface", typeWiring->typeWiring.typeName("SupportsMutualFunds").typeResolver(supportsMutualFundeResolver));
	    return newRuntimeWiring.build();
	}

	public GraphQL getGraphQL() {
		return graphQLObject;
	}
}
