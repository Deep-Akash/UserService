package com.calculator.userservice.dao.daoServices;

import com.calculator.userservice.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserEmailId(String userEmailId);
}
