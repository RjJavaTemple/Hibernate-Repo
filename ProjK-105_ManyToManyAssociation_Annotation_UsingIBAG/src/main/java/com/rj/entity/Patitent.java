package com.rj.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "MTM_Anno_Bag2")
public class Patitent 
{
	@Id
	@SequenceGenerator(name = "gen2",sequenceName = "AnnoMTM_Seq1",initialValue = 101001,allocationSize = 1)
	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
  private Integer PatId;
  @NonNull
  @Column(length = 20)
  private String PaiName;
  @NonNull
  @Column(length = 20)
  private String Problem;
  
  //Create The Doctor Class Object Add The Set under
  //Add The Required Annotation
  @ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Patient")
  
  private List<Doctor> Doctor;
  
  
  //Create The Tostring Method
  @Override
  public String toString()
  {
  	  return "Patitent [PatId=" + PatId + ", PaiName=" + PaiName + ", Problem=" + Problem + ", Doctor=" + Doctor + "]";
  }  
  
  
  //Creat The Constructure
  public Patitent()
  {
	 System.out.println("Patitent.0-Parms Constructure");
  }

}
