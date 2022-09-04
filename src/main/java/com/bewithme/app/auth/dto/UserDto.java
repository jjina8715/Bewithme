package com.bewithme.app.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.type.Gender;
import com.bewithme.data.type.Role;
import com.bewithme.data.type.StatCode;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
public class UserDto {

	private Long id;
	
	@NotBlank(message="이메일은 필수로 입력해주세요")
	@Email(message="이메일 형식에 맞지 않는 값입니다.")
	private String email;
	
	@NotBlank(message="이름은 필수로 입력해주세요.")
	@Size(min=1, max=20)
	private String name;
	
	@JsonIgnore
	@NotBlank(message="비밀번호는 필수로 입력해주세요.")

	@Pattern(regexp="(?=.*\\d)(?=.*[a-zA-Z]).{8,16}", message="8~16자 영문(대소문자), 숫자를 포함하세요.")
	private String password;
	
	@Pattern(regexp="^\\d{10}$", message="-를 제외한 핸드폰 번호를 입력해주세요.")
	private String phoneNum;
	
	private String role;
	
	private String birth;
	
	private String gender;
	
	private String nickname;
	
	private String discordUrl;
	
	private String aboutMe;
	
	public MemberAuthEntity toEntity(MemberBasicEntity userBasic) {
		return MemberAuthEntity.builder()
				.id(id)
				.authId(email)
				.authValue(password)
				.authRole(Role.ROLE_USER.toString())
				.memberBasic(userBasic)
				.build();
	}
	
	public MemberBasicEntity toBasicEntity() {
		return MemberBasicEntity.builder()
				.birth(birth.replaceAll("-",""))
				.name(name)
				.phoneNumber(phoneNum)
				.nickname(nickname)
				.discordUrl(discordUrl)
				.aboutMe(aboutMe)
				.gender(Gender.of(gender).getCode())
				.stat(StatCode.C01.getCode())
				.build();
	}
}