package com.golovkin.dataaccess.mappers.dto;

import com.golovkin.dataaccess.dto.SampleEntityDto;
import com.golovkin.model.SampleEntity;

public class SampleEntityDtoMapper {
    public void map(SampleEntity entity, SampleEntityDto dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
    }
}