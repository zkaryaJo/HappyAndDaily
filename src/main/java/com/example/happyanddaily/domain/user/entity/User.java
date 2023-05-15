package com.example.happyanddaily.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserId;

    private String loginId;
    private String nickname;
    private String email;
    private String gender;
    private String birthday;
    private String provider;
    private String providerId;
    private String role;

    public enum UserRole {
        USER("USER"), ADMIN("ADMIN"), SYSTEM("SYSTEM"), GUEST("GUEST");
        private final String value;

        UserRole(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
}
