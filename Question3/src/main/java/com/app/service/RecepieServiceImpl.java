package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.RecepieDTO;
import com.app.entities.Recepie;
import com.app.entities.User;
import com.app.repository.RecepieRepository;
import com.app.repository.UserRepository;


@Service
@Transactional
public class RecepieServiceImpl implements RecepieService {
   
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RecepieRepository recepieRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public ApiResponse addNewRecepie(RecepieDTO recepieDto)
	{   
		//Getting the user entity 
		User user = userRepo.findById(recepieDto.getUser_id())
				    .orElseThrow(()-> new ResourceNotFoundException("The user Doesn't exist !"));
		
		//Getting the recepie entity 
		Recepie recepie = mapper.map(recepieDto, Recepie.class);
		
		user.addRecepie(recepie);
		
		return new ApiResponse("New Recepie Added Successfully !!! ");
		
	}
	
	public RecepieDTO getRecepieById(Long id)
	{
		Recepie recepie = recepieRepo.findById(id)
				          .orElseThrow(()-> new ResourceNotFoundException("The Recepie Doesn't Exist !!!"));
		
		return mapper.map(recepie, RecepieDTO.class);
	}
}
