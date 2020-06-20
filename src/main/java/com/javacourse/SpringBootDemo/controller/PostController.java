package com.javacourse.SpringBootDemo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.SpringBootDemo.model.Post;
import com.javacourse.SpringBootDemo.repository.PostRepository;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostRepository postRepository;

	@GetMapping(path = "{id}", produces = "application/json")
	public Optional<Post> getPostById(@PathVariable("id") long postId) {
		return postRepository.findById(postId);
	}
	
	@GetMapping(produces = "application/json")
	public Iterable<Post> getAll(){
		return postRepository.findAll();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Post addPost(@Valid @RequestBody Post post) {
		return postRepository.save(post);
	}
}
