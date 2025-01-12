package com.pixelprompt.repository;

import com.pixelprompt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User,String> {
    boolean existsByEmailOrUsername(String email,String username);
}
