package com.denik.vy.myFirstSptingBoot.repositories;

import com.denik.vy.myFirstSptingBoot.models.User;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
}
