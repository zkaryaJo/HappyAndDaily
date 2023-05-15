package com.example.happyanddaily.auth.info;

public interface OAuth2UserInfo {
    String getProviderId();
    String getProvider();
    String getEmail();
    String getName();
    String getBirth();
    String getGender();
}
