package com.org.restclient.logging.todo;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.org.restclient.logging.ClientLoggerRequestInterceptor;

@Component
public class TodoClient
{
	private final RestClient restClient;

	public TodoClient(RestClient.Builder builder, ClientLoggerRequestInterceptor clientLoggerRequestInterceptor)
	{
		this.restClient = builder
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.requestInterceptor(clientLoggerRequestInterceptor)
				.build();
	}

	public List<Todo> findAll()
	{
		return restClient.get()
				.uri("/todos")
				.retrieve()
				.body(new ParameterizedTypeReference<List<Todo>>()
				{
				});
	}

}
