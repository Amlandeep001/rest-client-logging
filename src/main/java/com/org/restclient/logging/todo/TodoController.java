package com.org.restclient.logging.todo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController
{
	private final TodoClient client;

	public TodoController(TodoClient client)
	{
		this.client = client;
	}

	@GetMapping("")
	public List<Todo> findAll()
	{
		return client.findAll();
	}
}
