package com.uidai.aadhar.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "uidai_transaction_master", schema = "uidai")
public class UidaiTransactionMasterEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "bank_ref_no")
    private String bankRefNo;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;

    @Column(name = "status")
    private Integer status;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "currency")
    private String currency;
}
