package com.foo.enterprise.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foo.enterprise.graphql.GraphQLService;

import graphql.ExecutionResult;

@RestController
public class DemandDrivenCustomerAPI {
	
	@Autowired
	private GraphQLService graphQLService;
	
	//TODO: Narrow Method to POST
	@RequestMapping("/customer")
	public ResponseEntity<Object> bookDetails(@RequestBody String query) {
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<Object>(execute, HttpStatus.OK);
	}
}
