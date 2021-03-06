package com.rj.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "OTOAnno_Fk_StuTab1")
public class Student implements Serializable 
{
	@Id
	@GenericGenerator(strategy ="increment",name = "gen1")
	@GeneratedValue(generator = "gen1")
    private Integer StuId;
    @NonNull
    private String StuName;
    @NonNull
    private String StuAddress;
    
    //Add The Libery Object Hear
    @OneToOne(targetEntity = Libeary.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "StuLibId",referencedColumnName = "StuId")
    private Libeary LiberyDetails;
    
    //Creat The o-Parms Constructure
    public Student()
    {
    	System.out.println("Student:: 0-Parms Constructure");
	}
    
    //Create The  To String Method
    @Override
	public String toString()
    {
		return "Student [StuId=" + StuId + ", StuName=" + StuName + ", StuAddress=" + StuAddress + "]";
	}
}
