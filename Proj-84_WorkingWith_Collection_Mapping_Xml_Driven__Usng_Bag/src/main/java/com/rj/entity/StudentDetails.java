package com.rj.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class StudentDetails 
{
   private Integer Sno;
   private String Sname;
   private List<String> Frends;
   private Set<Long> PhoneNo;
   private Map<String, Long> IdCirtificate;
}
