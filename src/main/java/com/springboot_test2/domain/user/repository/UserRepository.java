package com.springboot_test2.domain.user.repository;

import com.springboot_test2.domain.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);
}
