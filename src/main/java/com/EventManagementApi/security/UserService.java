package com.EventManagementApi.security;

import java.util.Optional;

import com.EventManagementApi.data.entity.User;

/**
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
