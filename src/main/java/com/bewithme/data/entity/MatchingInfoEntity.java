package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bewithme.data.type.StatCode;
import lombok.*;
import org.thymeleaf.util.StringUtils;

import static com.bewithme.data.type.StatCode.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "matching_info")
public class MatchingInfoEntity extends TimeEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "requester", nullable = false)
	private MemberBasicEntity requester;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "requestee", nullable = false)
	private MemberBasicEntity requestee;

	@Column(name = "stat", columnDefinition = "char(4)", nullable = false)
	private String stat;

	public void approveRequest() {
		this.stat = C01.getCode();
	}

	public void cancelMate() {
		this.stat = C00.getCode();
	}

	public boolean isApproved() {
		return StringUtils.equals(this.stat, C01.getCode());
	}

	public boolean isWaited() {
		return StringUtils.equals(this.stat, C02.getCode());
	}

	public boolean isMyMate(Long id) {
		return id == requestee.getId() || id == requester.getId();
	}
}