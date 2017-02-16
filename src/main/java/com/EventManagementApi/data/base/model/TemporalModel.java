package com.EventManagementApi.data.base.model;

/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class TemporalModel extends BaseModel {
    private static final long serialVersionUID = -2763801936972787830L;
    private Date created;
    private Date updated;

    public TemporalModel() {
        created = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mod_date", nullable = false)
    @Version
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
