package com.calculator.userservice.dao.daoServices;

import com.calculator.userservice.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserEmailId(String userEmailId);

    @Modifying(clearAutomatically = true)
    @Query("update User user set user.creditBalance = user.creditBalance - :cost where user.userEmailId =:emailId")
    void updateUserBalance(String emailId,Double cost);
}
