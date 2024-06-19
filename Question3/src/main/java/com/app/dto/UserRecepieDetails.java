package com.app.dto;

import java.util.List;

import com.app.entities.Recepie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRecepieDetails extends BaseDTO {
   
	private String userName;
	
	private List<Recepie> recepies;
}
