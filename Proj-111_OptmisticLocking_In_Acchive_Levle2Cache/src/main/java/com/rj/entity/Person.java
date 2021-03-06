package com.rj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "PersionL2Table")
public class Person
{
	@Id
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
     private Integer Pid;
     @NonNull
     private String Pname;
     @NonNull
     private String Paddress;
     @NonNull
     private String PGmail;
     @NonNull
     private Float Salary;
     
     
     private Integer Ver;
     //Catered The 0-Parms Constructor
     public Person()
     {
        System.out.println("Person:: 0-Parms Constructor");	 
	}
}
