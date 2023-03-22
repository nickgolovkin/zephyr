package com.golovkin.dataaccess.exceptions;

public class EntityValidationException extends RuntimeException {
    private final Object entity;

    public EntityValidationException(Object entity) {
        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }
}
