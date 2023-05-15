package com.example.happyanddaily.auth.service;

import com.example.happyanddaily.auth.info.KakaoUserInfo;
import com.example.happyanddaily.auth.info.NaverUserInfo;
import com.example.happyanddaily.auth.info.OAuth2UserInfo;
import com.example.happyanddaily.auth.principal.PrincipalDetails;
import com.example.happyanddaily.domain.user.entity.User;
import com.example.happyanddaily.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
// 첫 로그인시 회원가입
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder encoder;

    // OAuth2UserRequest, OAuth2User로 user 정보 추출후 회원가입 진행
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("getAttributes : {}", oAuth2User.getAttributes());
        OAuth2UserInfo oAuth2UserInfo = null;

        String provider = userRequest.getClientRegistration().getRegistrationId();
        log.info("Provider: {}", provider);

        if(provider.equals("kakao")) {
            log.info("카카오 로그인 요청");
            oAuth2UserInfo = new KakaoUserInfo((Map)oAuth2User.getAttributes());
        } else if (provider.equals("naver")) {
            log.info("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }

        String providerId = oAuth2UserInfo.getProviderId();
        String email = oAuth2UserInfo.getEmail();
        String loginId = provider + "_" + providerId;
        String nickname = oAuth2UserInfo.getName();

        Optional<User> optionalUser = userRepository.findByLoginId(loginId);

        User user = null;

        if(!optionalUser.isPresent()) {
            if (nickname == null) {
                nickname = "";
            }
            user = User.builder()
                    .loginId(loginId)
                    .nickname(nickname)
                    .provider(provider)
                    .providerId(providerId)
                    .role(User.UserRole.USER.getValue())
                    .email(email)
                    .build();
            userRepository.save(user);
        }else {
            user = optionalUser.get();
        }

        String principalName = oAuth2User.getName();

        return new PrincipalDetails(user, oAuth2User.getAttributes(), principalName, User.UserRole.USER.getValue());
    }
}
