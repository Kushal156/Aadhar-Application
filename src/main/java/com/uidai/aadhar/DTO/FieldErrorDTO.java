package com.uidai.aadhar.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class FieldErrorDTO {

	private String errorCode;
	private String errorDesc;
	private String messageDesc;
}
