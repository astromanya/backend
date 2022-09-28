package com.internet.site.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internet.site.entitys.User;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
