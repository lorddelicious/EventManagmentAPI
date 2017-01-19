package com.EventManagementApi.data.nonuser.repo;

import com.EventManagementApi.data.primary.NonUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
public interface NonUserDao extends JpaRepository<NonUser, Long> {

}
