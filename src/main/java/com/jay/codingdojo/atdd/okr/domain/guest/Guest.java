package com.jay.codingdojo.atdd.okr.domain.guest;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jay.codingdojo.atdd.okr.domain.user.ProviderType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "guest")
public class Guest {

	@Id
	private String guestUuid;

	private String guestId;

	private String guestName;

	private String email;

	@Enumerated(EnumType.STRING)
	private ProviderType providerType;

	private String profileImage;

	@Builder
	public Guest(String guestUuid, String guestId, String guestName, String email, ProviderType providerType,
		String profileImage) {
		this.guestUuid = guestUuid;
		this.guestId = guestId;
		this.guestName = guestName;
		this.email = email;
		this.providerType = providerType;
		this.profileImage = profileImage;
	}
}
