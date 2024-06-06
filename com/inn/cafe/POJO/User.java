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



@NamedQuery(name = "User.findByEmailId", query = "SELECT u FROM User u WHERE u.email=:email")

@NamedQuery(name = "User.getAllUser", query = "SELECT new com.inn.cafe.wrapper.UserWrapper(u.id,u.name,u.email,u.contactNumber,u.status)FROM User u WHERE u.role='user'")

@NamedQuery(name = "User.updateStatus", query = "UPDATE User u set u.status=:status WHERE u.id=:id")

@NamedQuery(name = "User.getAllAdmin", query = "SELECT u.email FROM User u WHERE u.role='admin'")


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contactNumber")
	private String contactNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "role")
	private String role;
	
}
