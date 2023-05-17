package com.example.happyanddaily.auth.info;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes;
    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getBirth() {
        String birth = (String) attributes.get("birthday");
            if (birth != null && birth.contains("-")) {
                String[] parts = birth.split("-");
                if (parts.length >= 2) {
                    String month = parts[0];
                    String day = parts[1];
                    return month + day;
                }
            }
        return birth;
    }
    @Override
    public String getGender() {
        String gender = (String) attributes.get("gender");
        if(gender != null) {
            if(gender.equalsIgnoreCase("F")) {
                return "female";
            } else if (gender.equalsIgnoreCase("M")){
                return "male";
            }
        }
        return gender;
    }
}
