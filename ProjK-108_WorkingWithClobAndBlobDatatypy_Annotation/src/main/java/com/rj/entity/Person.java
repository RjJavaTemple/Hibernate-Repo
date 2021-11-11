package com.rj.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "Person_TabClobBlobData1")
public class Person
{
	@Id
	@GenericGenerator(name = "gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
     private Integer Pid;
     private String Pname;
     private String Paddress;
     @Lob
     private byte[] Photo;
     @Lob
     private char[] Resume;
}
