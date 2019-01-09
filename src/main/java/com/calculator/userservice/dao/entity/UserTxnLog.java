package com.calculator.userservice.dao.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_txn")
public class UserTxnLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private Long txnId;

    @Column(name = "user_email_id")
    private String userEmailId;

    @Column(name = "txn_operation_type")
    private String txnOperationType;

    @Column(name = "txn_operation_cost")
    private Double txnOperationCost;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    public UserTxnLog() {
    }

    public UserTxnLog(String userEmailId, String txnOperationType, Double txnOperationCost) {
        this.userEmailId = userEmailId;
        this.txnOperationType = txnOperationType;
        this.txnOperationCost = txnOperationCost;
    }

    public UserTxnLog(Long txnId, String userEmailId, String txnOperationType, Double txnOperationCost, Date createdAt, Date updatedAt) {
        this.txnId = txnId;
        this.userEmailId = userEmailId;
        this.txnOperationType = txnOperationType;
        this.txnOperationCost = txnOperationCost;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getTxnId() {
        return txnId;
    }

    public void setTxnId(Long txnId) {
        this.txnId = txnId;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getTxnOperationType() {
        return txnOperationType;
    }

    public void setTxnOperationType(String txnOperationType) {
        this.txnOperationType = txnOperationType;
    }

    public Double getTxnOperationCost() {
        return txnOperationCost;
    }

    public void setTxnOperationCost(Double txnOperationCost) {
        this.txnOperationCost = txnOperationCost;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserTxnLog{" +
                "txnId=" + txnId +
                ", userEmailId='" + userEmailId + '\'' +
                ", txnOperationType='" + txnOperationType + '\'' +
                ", txnOperationCost=" + txnOperationCost +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
