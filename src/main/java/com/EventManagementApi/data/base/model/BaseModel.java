package com.EventManagementApi.data.base.model;

/**
 * Created by Shravan Deolalikar on 1/19/2017.
 */
import java.io.Serializable;

public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = 3760863162097988918L;

    @Override
    public String toString() {

        return getClass().getName() + " (" + getId() + ")";
    }

    // Enforce ID for Generic DAO methods requiring it
    public abstract Long getId();
    public abstract void setId(Long id);

}