package com.uidai.aadhar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class PayCollectionRespDTO {

	private Integer code;              // 0 = Success, -1 = Error
    private String message;

    private String orderNo;
    private String referenceNo;

    // NEFT Details
    private String beneficiaryAccount;
    private String beneficiaryName;
    private String beneficiaryIFSC;
    private String beneficiaryBank;
    private String beneficiaryBranch;

    // Order Details
    private String orderCurrency;
    private String orderGrossAmount;
    private String orderNetAmount;
    private String orderPayOption;
    private String orderExpiryDate;

    // QR Details
    private String orderQrCode;
    private String orderBqrCode;
    private String orderDynamicQrCode;
    private String orderQrCodeType;
    private String orderQRExpiryTime;

    // Charges
    private String orderServiceTax;
    private String orderTransactionFees;

    // Merchant References
    private String merReferenceNo1;
    private String merReferenceNo2;
    private String merReferenceNo3;
    private String merReferenceNo4;
    private String merReferenceNo5;
    
    private String messageDesc;
}
