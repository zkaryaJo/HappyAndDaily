package com.example.happyanddaily.auth.principal;

import com.example.happyanddaily.domain.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PrincipalDetails implements OAuth2User {
    private User user;
    //1. oauth로 가입한 user 정보 저장
    public Map<String, Object> attributes;
    public String principalName;

    private String role;

    public PrincipalDetails(User user, Map<String, Object> attributes, String principalName, String role){
        this.user = user;
        this.attributes = attributes; //oauth2 로그인을 통해서 받은 정보 담아 리턴
        this.principalName = principalName;
        this.role = role;
    }

    @Override
    public Map<String, Object> getAttributes() {
        attributes.put("role", role);
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authorities;
    }

    @Override
    public String getName() {
        return principalName;
    }
}
