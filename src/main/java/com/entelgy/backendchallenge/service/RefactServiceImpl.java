package com.entelgy.backendchallenge.service;

import com.entelgy.backendchallenge.client.client.PostClient;
import com.entelgy.backendchallenge.client.dto.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RefactServiceImpl implements  RefactService {

    @Autowired
    public PostClient postClient;

    public List<PostResponse> getAllPost() {
        return postClient.getPosts();
    }

}
