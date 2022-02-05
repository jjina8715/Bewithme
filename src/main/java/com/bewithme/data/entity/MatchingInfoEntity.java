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

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Builder
@Data
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
}