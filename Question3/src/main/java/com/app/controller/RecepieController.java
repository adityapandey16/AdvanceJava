package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RecepieDTO;
import com.app.service.RecepieService;

@RestController
@RequestMapping("/recepies")
public class RecepieController {
  
	public RecepieController()
	{
		System.out.println("Inside the recepie controller !!!!");
	}
	
	@Autowired
	private RecepieService recepieService;
	
	@GetMapping("/{recepie_id}")
	public ResponseEntity<?> getRecepie(@PathVariable Long recepie_id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(recepieService.getRecepieById(recepie_id));
	}
	
	@PostMapping
	public ResponseEntity<?> addNewRecepie(@RequestBody RecepieDTO recepie)
	{
		System.out.println("Inside Add addNewRecepie Method !!!");
		return ResponseEntity.status(HttpStatus.CREATED).body(recepieService.addNewRecepie(recepie));
	}
}
