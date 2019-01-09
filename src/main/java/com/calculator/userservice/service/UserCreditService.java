package com.calculator.userservice.service;

import com.calculator.userservice.dao.daoServices.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreditService {

    @Autowired
    public UserDAO userDAO;

    public void topUpUserBalance(String emailId, Double topUp) {
        userDAO.updateUserCreditBalance(emailId,topUp);
    }
}
