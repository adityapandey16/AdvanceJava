package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
    
	@JsonProperty(access = Access.READ_ONLY)
	 private Long id;
	 
	@JsonProperty(access = Access.READ_ONLY)
	 private LocalDate created_at;
	
	@JsonProperty(access = Access.READ_ONLY)
	 private LocalDateTime updated_at;
}
