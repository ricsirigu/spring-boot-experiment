package com.javacourse.SpringBootDemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javacourse.SpringBootDemo.model.Post;

public interface PostRepository extends CrudRepository<Post , Long>{
	List<Post> findByTitle(String title);
}
