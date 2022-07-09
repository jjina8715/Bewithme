package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.bewithme.data.type.Role;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "member_auth")
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
	
	@Column(name = "auth_role", length = 10)
	private String authRole; 
	
	//status??
	
	@Builder
	public MemberAuthEntity(Long id, MemberBasicEntity memberBasic, String authId, String authValue, String authRole) {
		this.id = id;
		this.memberBasic = memberBasic;
		this.authId = authId;
		this.authValue = authValue;
		this.authRole = authRole;
	}
	
}