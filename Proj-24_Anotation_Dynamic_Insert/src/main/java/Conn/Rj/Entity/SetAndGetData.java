package Conn.Rj.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="ARTIST12")
@Data
//@AllArgsConstructor
//@DynamicInsert(true)
@Proxy(lazy = false)
public class SetAndGetData implements Serializable 
{
      @Id
      @Column(name="PID")
      private Integer pid;
      @Column(name="NAME")
      private String name;
      @Column(name="ADDRESS")
      private String address;
      @Column(name="MOBILENO")
      private long mobileno;
      @Column(name="CATEGORY",length =15)
      private String category;
}
