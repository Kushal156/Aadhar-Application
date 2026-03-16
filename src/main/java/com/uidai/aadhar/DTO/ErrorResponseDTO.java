package com.uidai.aadhar.DTO;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ErrorResponseDTO {

	private Integer code;   // -1
    private String message;

    private List<FieldErrorDTO> fieldErrors;

    private String errorCode;
    private String errorDesc;
    private String messageDesc;
}
