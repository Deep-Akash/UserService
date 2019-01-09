package com.calculator.userservice.service;

import com.calculator.userservice.dao.daoServices.UserDAO;
import com.calculator.userservice.dao.daoServices.UserRepository;
import com.calculator.userservice.dao.daoServices.UserTxnLogDAO;
import com.calculator.userservice.dao.entity.UserTxnLog;
import com.calculator.userservice.model.request.UserDebitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDebitService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTxnLogDAO userTxnLogDAO;

    @Transactional
    public void debitUserBalance(UserDebitRequest debitRequest) {
        userRepository.updateUserBalance(debitRequest.getUserEmailId(),debitRequest.getCost());
        userTxnLogDAO.saveUserTxnLog(new UserTxnLog(debitRequest.getUserEmailId(),debitRequest.getOperation().name(),debitRequest.getCost()));
    }



}
