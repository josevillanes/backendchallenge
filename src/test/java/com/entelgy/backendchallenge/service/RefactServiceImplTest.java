package com.entelgy.backendchallenge.service;

import com.entelgy.backendchallenge.client.client.PostClient;
import com.entelgy.backendchallenge.client.dto.PostResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RefactServiceImplTest {

    @InjectMocks
    RefactService refactService = new RefactServiceImpl();

    @Mock
    PostClient postClient;

    @BeforeEach
    void setUp() {

        PostResponse postResponse1 = new PostResponse(1, 1, "nombre1", "email1@gardner.biz", "Descripcion 1");
        PostResponse postResponse2 = new PostResponse(1, 2, "nombre2", "email2@sydney.com", "Descripcion 2");
        PostResponse postResponse3 = new PostResponse(1, 3, "nombre3", "email3@garfield.biz", "Descripcion 3");
        PostResponse postResponse4 = new PostResponse(1, 4, "nombre4", "email4@alysha.tv", "Descripcion 4");

        PostResponse postResponse5 = new PostResponse();
        postResponse5.setPostId(1);
        postResponse5.setId(5);
        postResponse5.setName("nombre5");
        postResponse5.setEmail("email5@althea.biz");
        postResponse5.setBody("Descripcion 5");

        List<PostResponse> postsResponse = new ArrayList<>();
        postsResponse.add(postResponse1);
        postsResponse.add(postResponse2);
        postsResponse.add(postResponse3);
        postsResponse.add(postResponse4);
        postsResponse.add(postResponse5);

        Mockito.when(postClient.getPosts()).thenReturn(postsResponse);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllPost() throws JsonProcessingException {

        List<PostResponse> postsResponse = refactService.getAllPost();

        //Se verifica que el resultado no sea vacio
        Assertions.assertFalse(postsResponse.isEmpty());

        ObjectMapper mapper = new ObjectMapper();
        PostResponse post = postsResponse.get(0);

        //Se verifica que el resultado sea del mockito
        Assertions.assertEquals("nombre1", post.getName());

        //Se verifica que la estructura del resultado contenga solo 3 atributos y se encuentre en el orden correcto.
        String postJson = mapper.writeValueAsString(post);
        Assertions.assertEquals("postId|id|email", getKeys(postJson));

    }

    String getKeys(String json) throws JsonProcessingException {
        String structure = "";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);
        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
        while(fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            structure += field.getKey() + (fields.hasNext()?"|":"");
        }
        return structure;
    }
}