package com.EventManagementApi.data.entity;

import com.EventManagementApi.data.secondary.BaseUser;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
@Entity
@Table(name = "user_role")
public class UserRole extends BaseUser {
    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 1322120000551624359L;

        @Column(name = "app_user_id")
        protected Long userId;

        @Enumerated(EnumType.STRING)
        @Column(name = "role")
        protected Role role;

        public Id() { }

        public Id(Long userId, Role role) {
            this.userId = userId;
            this.role = role;
        }
    }

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {

    }

    @EmbeddedId
    Id id = new Id();

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", insertable=false, updatable=false)
    protected Role role;

    public Role getRole() {
        return role;
    }
}
