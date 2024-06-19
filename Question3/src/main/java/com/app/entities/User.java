package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
   
	private String userName;
	
	private String password;
	
	private String fullName;

	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Recepie> recepies = new ArrayList<>();
	
	//Helper Methods 
	public void addRecepie(Recepie recepie)
	{
		recepies.add(recepie);
		recepie.setUser(this);
	}
	
	public void removeRecepie(Recepie recepie)
	{
		recepies.remove(recepie);
		recepie.setUser(null);
	}
}
