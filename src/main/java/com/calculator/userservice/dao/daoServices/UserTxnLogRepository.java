package com.calculator.userservice.dao.daoServices;

import com.calculator.userservice.dao.entity.UserTxnLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTxnLogRepository extends JpaRepository<UserTxnLog, Long> {

}