package com.example.happyanddaily.domain.logout;

import com.example.happyanddaily.auth.principal.PrincipalDetails;
import com.example.happyanddaily.auth.service.PrincipalOauth2UserService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class LogoutController {
    private final PrincipalOauth2UserService principalOauth2UserService;

    public LogoutController(PrincipalOauth2UserService principalOauth2UserService) {
        this.principalOauth2UserService = principalOauth2UserService;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) throws IOException {
        // 로그인 여부 확인
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            // 로그인되어 있지 않은 경우
            System.out.println("로그인되어 있지 않습니다. 로그인을 해주세요");
            return;
        }

        // 로그인된 사용자 정보 가져오기
        OAuth2AuthenticationToken authenticationToken = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        OAuth2UserRequest userRequest = (OAuth2UserRequest) authenticationToken.getPrincipal();
        String accessToken = principalOauth2UserService.getAccessToken(userRequest);

        PrincipalDetails principalDetails = (PrincipalDetails) authenticationToken.getPrincipal();
        String email = principalDetails.getName();

        String reqURL = "https://kapi.kakao.com/v1/user/logout";

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(reqURL);
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        // 대상 ID 포함하여 요청 보내기
        StringEntity requestEntity = new StringEntity("target_id=" + email, StandardCharsets.UTF_8);
        httpPost.setEntity(requestEntity);

        HttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            System.out.println("로그아웃 성공");
        } else {
            System.out.println("로그아웃 실패");
        }

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream inputStream = entity.getContent();
            inputStream.close();
        }
    }
}