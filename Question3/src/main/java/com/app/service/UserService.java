package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.UserDTO;
import com.app.entities.User;

public interface UserService {
	
	 //Service Layer Method To Get All Available Room
	
	public UserDTO addNewUser(UserDTO user);
	
	public List<UserDTO> getAllUser();
	
	public ApiResponse deleteUserDetails(Long userId);
	
	public ApiResponse updateUserDetails(Long id,User user);
	
	// public List<User> getAllRoom();
	 
//	 public Room addNewJob(Room job);
//	 
//	 public RoomBookDTO getByJobId(Long job_id);
//	 
//	 public RoomBookDTO updateJobById(Long job_id,Room job);
//
	 }
