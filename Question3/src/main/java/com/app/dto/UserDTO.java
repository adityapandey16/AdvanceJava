package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@NoArgsConstructor
public class UserDTO extends BaseDTO {
	
	private String userName;
	
	private String password;
	
	private String fullName;
}
