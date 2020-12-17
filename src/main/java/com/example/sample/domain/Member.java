package com.example.sample.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@EqualsAndHashCode(of="userNo")
@ToString
@NoArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userNo;

	private String userId;
	private String userName;
	
	@Builder
	public Member(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
//	private Gender gender;
	
//	@Temporal(TemporalType.DATE)
//	private Date joinDate;
//	
//	@CreationTimestamp
//	private Date regDate;
//
//	@UpdateTimestamp
//	private Date updDate;
}
