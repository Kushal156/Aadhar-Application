package com.uidai.aadhar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayCollectReqDTO {

	// ===============================
    // Mandatory Fields
    // ===============================

    private String accessCode;
    private String requestHash;

    @NotBlank(message = "Order Number is required")
    @Size(max = 30, message = "Order Number must not exceed 30 characters")
    @Pattern(
        regexp = "^[a-zA-Z0-9_:\\-\\[\\]#/()]+$",
        message = "Order Number contains invalid characters"
    )
    private String orderNo;

    @NotBlank(message = "Order Currency is required")
    @Pattern(
        regexp = "^[A-Za-z]+$",
        message = "Order Currency must contain only alphabetic characters"
    )
    private String orderCurrency;

    @NotBlank(message = "Order Amount is required")
    @Pattern(
        regexp = "^\\d+(\\.\\d{1,2})?$",
        message = "Order Amount must be a valid number with up to 2 decimal places"
    )
    private String orderAmount;

    @NotBlank(message = "Order Payment Option is required")
    @Pattern(
        regexp = "^(NEFT|BQR|DYNAMICQR|STATICQR)$",
        message = "Order Payment Option must be NEFT, BQR, DYNAMICQR, or STATICQR"
    )
    private String orderPayOption;


    // ===============================
    // Optional Fields
    // ===============================

    private String orderExpiryDate;
    private String orderQRExpiryTime;
    private String merReferenceNo1;
    private String merReferenceNo2;
    private String merReferenceNo3;
    private String merReferenceNo4;
    private String merReferenceNo5;

}
