package com.golovkin.dataaccess.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {
    private final Object entity;

    public EntityAlreadyExistsException(Object entity) {
        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }
}
