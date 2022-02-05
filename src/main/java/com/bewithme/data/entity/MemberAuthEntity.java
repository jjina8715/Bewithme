package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
public class MemberAuthEntity extends TimeEntity{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private MemberBasicEntity memberBasic;
	
	@Column(name = "auth_id", length = 20, nullable = false)//, unique = true
	private String authId;
	
	@Column(name = "auth_value", length = 255, nullable = false)
	private String authValue;
	
	//@Convert
	@Column(name = "auth_role", length = 10)
	private String authRole; //AuthRole enum
	
	//status??
	
	
}
