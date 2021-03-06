package com.rj.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "OTOAnno_Fk_Libe2")
public class Libeary 
{
	@Id
	@GenericGenerator(name = "gen2",strategy = "foreign",parameters = @Parameter(name="property",value = "studentDetails"))
	@GeneratedValue(generator = "gen2")
   private Integer StuLibId;
   @NonNull
   private String BookName;
   @NonNull
   private  String Dept;
   @NonNull
   private LocalDateTime Dor;
   
   //Add The Student Object Hear
   @OneToOne(targetEntity = Student.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "LiberyDetails")
   private Student studentDetails;
   
   //Create The 0-parms Constructure
   public Libeary()
   {
	 System.out.println("Libeary::0-Parms Constructure");
   }
   
   //Create The To String Method
	/*@Override
	public String toString()
	{
	     	return "Libeary [StuLibId=" + StuLibId + ", BookName=" + BookName + ", Dept=" + Dept + ", date=" + date+"]";
	}*/
 
}
