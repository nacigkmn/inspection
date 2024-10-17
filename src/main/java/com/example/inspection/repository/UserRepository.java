package com.example.inspection.repository;

import com.example.inspection.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUsername(String name);
}
