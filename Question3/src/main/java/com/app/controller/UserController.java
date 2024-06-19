package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
  
	public UserController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside The User Controller !!!");
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getAllUsers()
	{
		System.out.println("Inside getAllUsers");
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewUser(@RequestBody UserDTO user)
	{
		System.out.println("Inside Add User Method !!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(user));
	}
	
//	@GetMapping
//	public ResponseEntity<?> getAllJobs()
//	{   System.out.println("Getting All The Categories !!!");
//		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllRoom());
//	}
	
//	@PostMapping
//	public ResponseEntity<?> addNewJob(@RequestBody Room job)
//	{   System.out.println("The Job is "+job);
//		return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addNewJob(job));
//	}
//	
//	@GetMapping("/{job_id}")
//	public ResponseEntity<?> getJobById(@PathVariable Long job_id)
//	{
//		return ResponseEntity.status(HttpStatus.OK).body(roomService.getByJobId(job_id));
//	}
//	
//	@PutMapping("/{job_id}")
//	public ResponseEntity<?> updateById(@PathVariable Long job_id,@RequestBody Room job)
//	{
//	  return ResponseEntity.status(HttpStatus.OK).body(roomService.updateJobById(job_id,job));
//	}
	
	
}
