package com.springboot_test2.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    private String nickname;
    private String password;
    private LocalDateTime joinDate;

    public SiteUser(String username, String nickname, String password) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.joinDate = LocalDateTime.now();
    }
}
