package com.rj.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "AnnoDriInheri_Per")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Persion_Type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("per")
//This Is The Parent Class 
public class Persion
{
  @Id
  @GeneratedValue
   private Integer Id;
  @Column(length = 20)
   private String Name;
  @Column(length = 20)
   private String Address;
}
