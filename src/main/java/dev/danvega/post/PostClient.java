package dev.danvega.post;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import dev.danvega.ClientLoggerRequestInterceptor;

@Component
public class PostClient
{
	private final RestClient restClient;

	public PostClient(RestClient.Builder builder, ClientLoggerRequestInterceptor clientLoggerRequestInterceptor)
	{
		this.restClient = builder
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.requestInterceptor(clientLoggerRequestInterceptor)
				.build();
	}

	public List<Post> findAll()
	{
		return restClient.get()
				.uri("/posts")
				.retrieve()
				.body(new ParameterizedTypeReference<>()
				{
				});
	}

	public Post findById(Integer id)
	{
		return restClient.get()
				.uri("/posts/{id}", id)
				.retrieve()
				.toEntity(Post.class)
				.getBody();
	}

}
