package com.rj.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "MTM_Anno_Tab2")
public class Doctor 
{
    //Create The All required Variable
	@Id
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private Integer DocId;
	@NonNull
	private String DocName;
	@NonNull
	private String DocCategory;
	
	//Create The Patient Class Object Are St Property
	 //Add The Required Annotation
	  @ManyToMany(targetEntity = Patitent.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @JoinTable(name = "MTM_DocPatComboTable1",joinColumns = @JoinColumn(name="Docter_id",referencedColumnName = "DOCID"),
	                       inverseJoinColumns = @JoinColumn(name="Patient_Id" ,referencedColumnName = "PATID")
			  )
	private Set<Patitent> Patient;
	
	
	//Create The ToString Method
	@Override
	public String toString()
	{
		return "Doctor [DocId=" + DocId + ", DocName=" + DocName + ", DocCategory=" + DocCategory + ", Patient="
				+ Patient + "]";
	}
	
	
	//Create The Constructure
	public Doctor()
	{
	  System.out.println("Doctor.0-Parms Constructure");	
	}

}
