package com.EventManagementApi.data.user.repo;

import com.EventManagementApi.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
public interface UserDao extends JpaRepository<User, Long> {
}
