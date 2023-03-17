package com.golovkin.dataaccess.exceptions;

public class EntityDoesNotExistException extends RuntimeException {
    private final Object entity;

    public EntityDoesNotExistException(Object entity) {
        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }
}
