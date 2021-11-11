package com.rj.entity;

import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "actor_info")
public class SetAndImpClass 
{
	  private Integer ActorId;
	  private String ActorName;
	  private String ActorAddress;
	  private Double ActorSalary;
	  private String ActorColor;
	  private String ActorGender;
	  private String ActorCurrentFilm;
	  
}
