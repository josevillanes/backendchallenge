package com.entelgy.backendchallenge.client.client;

import com.entelgy.backendchallenge.client.dto.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url="https://jsonplaceholder.typicode.com",name="POST-CLIENT")
public interface PostClient {

	@GetMapping("/comments")
	public List<PostResponse> getPosts();
	
}
