package com.rj.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Persion implements Serializable  
{
   private Integer PersioId;
	@NonNull
   private String PersionName;
	@NonNull
   private String PersionAddress;
	@NonNull
   private String PersionColor;

    //Add The Details File In The Persion Class
	@NonNull
   private Dtails Details;

}
