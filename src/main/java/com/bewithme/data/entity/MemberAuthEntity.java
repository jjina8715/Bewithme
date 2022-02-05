package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
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
