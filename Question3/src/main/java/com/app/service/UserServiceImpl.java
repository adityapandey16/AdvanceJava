package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.UserDTO;
import com.app.dto.UserRecepieDetails;
import com.app.entities.User;
import com.app.repository.UserRepository;
import com.blogs.dto.CategoryPostDetails;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDTO addNewUser(UserDTO userDto)
	{   
		System.out.println("Inside the addNewUser method ");
		User user = mapper.map(userDto, User.class);
		
		return mapper.map(userRepo.save(user),UserDTO.class);
	}
	
	@Override
    public List<UserDTO> getAllUser()
    {
		System.out.println("Inside The getAllUser method ");
		
		List<User> user = userRepo.findAll();
		//empty userDTO array list 
		List<UserDTO> userDTOs = new ArrayList<>();
		
		for(User uservalue : user)
		{
			UserDTO dto = mapper.map(uservalue, UserDTO.class);
			userDTOs.add(dto);
		}
		
		return userDTOs;
    }
	
	
	@Override
	public ApiResponse deleteUserDetails(Long userId) {
		String mesg = "user details deleted";
		if (userRepo.existsById(userId)) {
			// API of CrudRepo - public void deleteById(ID id)
			userRepo.deleteById(userId);

		} else
			mesg = "deleting category details failed : Invalid category ID";
		return new ApiResponse(mesg);
	}

	
	@Override
	public ApiResponse updateUserDetails(Long id,User user) {
		String mesg = "Updation failed!!!!";
		// validate id
		if (userRepo.existsById(id)) {
			// category id valid
			userRepo.save(user);
			mesg = "Updated USER details !";
		} else
			throw new ResourceNotFoundException("Invalid USER ID !!!");
		return new ApiResponse(mesg);
	}
	
	
	@Override
	public UserRecepieDetails getUserAndRecepies(Long userId) {
		User user = userRepo.getUserAndRecepies(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id"));

		return mapper.map(user, UserRecepieDetails.class);
	}
//	@Override
//	public List<User> getAllRoom() {
//		// TODO Auto-generated method stub
//		
//		return roomRepo.findAll();
//	}

//	@Override
//	public Room addNewJob(Room job) {
//		// TODO Auto-generated method stub
//		System.out.println("The Value OF JOB : "+job);
//		return jobPostingRepo.save(job);
//	}
//	
//	@Override 
//	public RoomBookDTO getByJobId(Long job_id)
//	{
//		Room job = jobPostingRepo.findById(job_id)
//				         .orElseThrow(()-> new ResourceNotFoundException("The ID doesn't Exist !!!"));
//		
//		return mapper.map(job,RoomBookDTO.class);
//	}
//	
//	@Override 
//	public RoomBookDTO updateJobById(Long job_id,Room job)
//	{
//		if(jobPostingRepo.existsById(job_id))
//		{
//			Room jobPosting = jobPostingRepo.save(job);
//			return mapper.map(jobPosting, RoomBookDTO.class);
//		}else {
//			return null;
//		}
//	}

}
