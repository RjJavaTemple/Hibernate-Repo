package com.rj.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "MTM_Anno_Bag1")
public class Doctor 
{
    //Create The All required Variable
	@Id
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private Integer DocId;
	@NonNull
	@Column(length = 20)
	private String DocName;
	@NonNull
	@Column(length = 20)
	private String DocCategory;
	
	//Create The Patient Class Object Are St Property
	 //Add The Required Annotation
	  @ManyToMany(targetEntity = Patitent.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @JoinTable(name = "MTM_DocPatComboIBAG",joinColumns = @JoinColumn(name="Docter_id",referencedColumnName = "DOCID"),
	                       inverseJoinColumns = @JoinColumn(name="Patient_Id" ,referencedColumnName = "PATID")
			  )
	  @GenericGenerator(name = "gen1",strategy = "increment")
	  @CollectionId(columns = @Column(name = "DocPatIndex",length =15,nullable = true),type = @Type(type = "int"),generator = "gen1")
	private List<Patitent> Patient;
	
	
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
