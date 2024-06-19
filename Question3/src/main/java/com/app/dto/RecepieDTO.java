package com.app.dto;

import com.app.entities.Difficulty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecepieDTO extends BaseDTO{
  
	private String title;
	
	private String description;
	
	private String ingredients;
	
	private String instructions;
	
	private Difficulty diff;
	
	private Long user_id;
	
}
