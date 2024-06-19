package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.RecepieDTO;

public interface RecepieService {
   
	public ApiResponse addNewRecepie(RecepieDTO recepie);
	
	public RecepieDTO getRecepieById(Long id);
}
