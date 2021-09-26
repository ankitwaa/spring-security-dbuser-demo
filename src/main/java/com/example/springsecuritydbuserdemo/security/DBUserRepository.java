package com.example.springsecuritydbuserdemo.security;

import com.example.springsecuritydbuserdemo.security.entity.DBUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUserRepository extends CrudRepository<DBUser, Long> {
}
