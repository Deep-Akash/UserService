package com.calculator.userservice.service;

import com.calculator.userservice.dao.daoServices.UserDAO;
import com.calculator.userservice.dao.daoServices.UserTxnLogDAO;
import com.calculator.userservice.dao.entity.UserTxnLog;
import com.calculator.userservice.enums.CalculatorOperationsENUM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreditService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserTxnLogDAO userTxnLogDAO;

    public void topUpUserBalance(String emailId, Double topUp) {
        userDAO.updateUserCreditBalance(emailId,topUp);

        UserTxnLog txnLog = new UserTxnLog();
        txnLog.setUserEmailId(emailId);
        txnLog.setTxnOperationCost(topUp);
        txnLog.setTxnOperationType(CalculatorOperationsENUM.CREDIT.name());

        userTxnLogDAO.saveUserTxnLog(txnLog);
    }
}
