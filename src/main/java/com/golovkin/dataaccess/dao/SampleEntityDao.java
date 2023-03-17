package com.golovkin.dataaccess.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.golovkin.dataaccess.dto.SampleEntityDto;
import com.golovkin.dataaccess.exceptions.EntityAlreadyExistsException;
import com.golovkin.dataaccess.exceptions.EntityDoesNotExistException;
import com.golovkin.dataaccess.mappers.dto.SampleEntityDtoMapper;
import com.golovkin.dataaccess.mappers.entity.SampleEntityMapper;
import com.golovkin.httpclient.*;
import com.golovkin.model.SampleEntity;
import com.golovkin.utils.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class SampleEntityDao {
    private HttpClient httpClient;

    private SampleEntityMapper entityMapper;
    private SampleEntityDtoMapper dtoMapper;

    public SampleEntityDao(HttpClient httpClient, SampleEntityMapper entityMapper, SampleEntityDtoMapper dtoMapper) {
        this.httpClient = httpClient;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    public SampleEntity getById(long id) {
        Request request = new Request();
        request.setUrl(String.format("http://jira.com/v1/read?id=%d", id));
        request.setMethod(HttpMethod.GET);

        Response response = httpClient.execute(request);
        String responseJson = HttpClientUtils.getJson(response);

        SampleEntityDto dto = ObjectMapper.read(responseJson, SampleEntityDto.class);
        SampleEntity entity = new SampleEntity();

        entityMapper.map(dto, entity);

        return entity;
    }

    public void create(SampleEntity entity) {
        if (entity.getId() != null) {
            throw new EntityAlreadyExistsException(entity);
        }

        SampleEntityDto dto = new SampleEntityDto();
        dtoMapper.map(entity, dto);

        Request request = new Request();
        request.setUrl("http://jira.com/v1/create");
        request.setMethod(HttpMethod.POST);
        request.setBody(ObjectMapper.toJson(dto));

        Response response = httpClient.execute(request);
        String responseJson = HttpClientUtils.getJson(response);

        List<Long> ids = ObjectMapper.read(responseJson, new TypeReference<List<Long>>() {});

        entity.setId(ids.get(0));
    }

    public void update(SampleEntity entity) {
        if (entity.getId() == null) {
            throw new EntityDoesNotExistException(entity);
        }

        SampleEntityDto dto = new SampleEntityDto();
        dtoMapper.map(entity, dto);

        Request request = new Request();
        request.setUrl("http://jira.com/v1/update");
        request.setMethod(HttpMethod.PUT);
        request.setBody(ObjectMapper.toJson(dto));

        Response response = httpClient.execute(request);
        HttpClientUtils.checkSuccessful(response);
    }

    public void delete(SampleEntity entity) {
        delete(entity.getId());
    }

    public void delete(long id) {
        List<String> ids = new ArrayList<>();
        ids.add(Long.toString(id));

        Request request = new Request();
        request.setUrl("http://jira.com/v1/delete");
        request.setMethod(HttpMethod.DELETE);
        request.setBody(ObjectMapper.toJson(ids));

        Response response = httpClient.execute(request);
        HttpClientUtils.checkSuccessful(response);
    }
}
