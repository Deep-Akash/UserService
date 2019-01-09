package com.calculator.userservice.dao.daoServices;

import com.calculator.userservice.dao.entity.UserTxnLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserTxnLogDAO {

    @Autowired
    private UserTxnLogRepository userTxnLogRepository;

    public void saveUserTxnLog(UserTxnLog txnLog) {
        userTxnLogRepository.save(txnLog);
    }

}
