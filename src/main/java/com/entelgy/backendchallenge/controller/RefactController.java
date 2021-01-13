package com.entelgy.backendchallenge.controller;

import com.entelgy.backendchallenge.client.dto.PostResponse;
import com.entelgy.backendchallenge.service.RefactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RefactController {

    @Autowired
    public RefactService refactService;

    @PostMapping(value = "/posts", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PostResponse>> getAllPost() {
        List<PostResponse> posts = refactService.getAllPost();
        return new ResponseEntity<List<PostResponse>>(posts, HttpStatus.OK);
    }

}
