package com.jay.codingdojo.atdd.okr.domain.user;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userSeq;

	private String userId;

	private String username;

	private String email;

	private String profileImage;

	@Enumerated(EnumType.STRING)
	private ProviderType providerType;

	@Builder
	public User(Long userSeq, String userId, String username, String email, String profileImage,
		ProviderType providerType) {
		this.userSeq = userSeq;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.profileImage = profileImage;
		this.providerType = providerType;
	}

	public boolean canUserLogin(ProviderType providerType) {
		if (providerType != this.providerType) {
			throw new IllegalStateException(this.providerType+ "(으)로 가입한 계정이 있습니다.");
		}
		return true;
	}
}
