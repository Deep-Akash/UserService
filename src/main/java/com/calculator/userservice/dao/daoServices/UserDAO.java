package com.calculator.userservice.dao.daoServices;

import com.calculator.userservice.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public User findUserWithID(Long id) {
        return userRepository.findById(id).get();
    }

    public User findUserWithEmail(String email) {
        List<User> users = userRepository.findByUserEmailId(email);
        return users.get(0);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUserCreditBalance (String email, Double topUp) {
        User user = findUserWithEmail(email);
        user.setCreditBalance(user.getCreditBalance()+topUp);
        saveUser(user);
    }
}
