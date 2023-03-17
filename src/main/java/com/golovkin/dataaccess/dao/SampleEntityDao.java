package com.golovkin.dataaccess.dao;

import com.golovkin.dataaccess.dto.SampleEntityDto;
import com.golovkin.dataaccess.mappers.SampleEntityMapper;
import com.golovkin.httpclient.*;
import com.golovkin.model.SampleEntity;
import com.golovkin.utils.ObjectMapper;

public class SampleEntityDao {
    private HttpClient httpClient;

    private SampleEntityMapper mapper;

    public SampleEntityDao(HttpClient httpClient, SampleEntityMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    public SampleEntity getById(long id) {
        Request request = new Request();
        request.setUrl(String.format("http://jira.com/v1/read?id=%d", id));
        request.setMethod(HttpMethod.GET);

        Response response = httpClient.execute(request);
        String responseJson = HttpClientUtils.getJson(response);

        SampleEntityDto dto = ObjectMapper.read(responseJson, SampleEntityDto.class);
        SampleEntity entity = new SampleEntity();

        mapper.map(dto, entity);

        return entity;
    }
}
