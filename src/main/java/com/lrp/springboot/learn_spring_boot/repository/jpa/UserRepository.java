package com.lrp.springboot.learn_spring_boot.repository.jpa;

import com.lrp.springboot.learn_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {

}
