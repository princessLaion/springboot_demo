package com.lrp.springboot.learn_spring_boot.repository.jpa;


import com.lrp.springboot.learn_spring_boot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
