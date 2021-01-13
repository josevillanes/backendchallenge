
package com.entelgy.backendchallenge.client.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "postId",
        "id",
    "email"
})
public class PostResponse {

    @JsonProperty("postId")
    private Integer postId;
    @JsonProperty("id")
    private Integer id;
    @JsonIgnore
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    @JsonProperty("body")
    private String body;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("postId")
    public Integer getPostId() {
        return postId;
    }

    @JsonProperty("postId")
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonIgnore
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonIgnore
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    public PostResponse() {

    }

    public PostResponse(Integer postId, Integer id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}
