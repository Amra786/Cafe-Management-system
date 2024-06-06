package com.inn.cafe.POJO;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@NamedQuery(name = "Bill.getAllBills", query="SELECT b FROM Bill b ORDER by b.id desc")

@NamedQuery(name = "Bill.getBillByUserName", query="SELECT b FROM Bill b where b.createdBy=:username ORDER by b.id desc")


@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name ="bill")

public class Bill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "uuid")
	private String uuid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "contactNumber")
	private String contactNumber;
	
	@Column(name = "paymentMethod")
	private String paymentMethod;
	
	@Column(name = "total")
	private Integer total;
	
	@Column(name = "productdetails",columnDefinition = "json")
	private String productDetail;
	
	@Column(name = "createdby")
	private String createdBy;

}
