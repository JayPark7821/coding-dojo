package com.jay.codingdojo.atdd.okr.domain.user.service;

import java.util.Optional;

import com.jay.codingdojo.atdd.okr.domain.user.User;
import com.jay.codingdojo.atdd.okr.interfaces.user.auth.OAuth2UserInfo;

public record UserWholeInfo(Optional<User> user, OAuth2UserInfo oAuth2UserInfo){
}
