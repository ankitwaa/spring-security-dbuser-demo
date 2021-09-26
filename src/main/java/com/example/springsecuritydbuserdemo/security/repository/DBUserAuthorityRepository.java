package com.example.springsecuritydbuserdemo.security.repository;

import com.example.springsecuritydbuserdemo.security.entity.DBUserAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBUserAuthorityRepository extends CrudRepository<DBUserAuthority, Long> {
}
