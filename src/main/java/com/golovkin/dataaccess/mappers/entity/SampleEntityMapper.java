package com.golovkin.dataaccess.mappers.entity;

import com.golovkin.dataaccess.dto.SampleEntityDto;
import com.golovkin.model.SampleEntity;

public class SampleEntityMapper {
    public void map(SampleEntityDto dto, SampleEntity entity) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
    }
}