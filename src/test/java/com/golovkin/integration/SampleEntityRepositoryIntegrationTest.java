package com.golovkin.integration;

import com.golovkin.dataaccess.dao.SampleEntityDao;
import com.golovkin.dataaccess.mappers.dto.SampleEntityDtoMapper;
import com.golovkin.dataaccess.mappers.entity.SampleEntityMapper;
import com.golovkin.dataaccess.repositories.SampleEntityRepository;
import com.golovkin.httpclient.HttpClient;
import com.golovkin.httpclient.HttpMethod;
import com.golovkin.httpclient.Request;
import com.golovkin.httpclient.Response;
import com.golovkin.model.SampleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.golovkin.integration.Assertions.*;
import static org.mockito.Mockito.doReturn;

public class SampleEntityRepositoryIntegrationTest {
    @Mock
    private HttpClient httpClient;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEntityById() {
        Request request = new Request();
        request.setMethod(HttpMethod.GET);
        request.setUrl("http://jira.com/v1/read?id=1");

        Response response = new Response();
        response.setStatusCode(200);
        response.setBody(Resources.read("/dto/sample_entity_dto.json"));

        doReturn(response).when(httpClient).execute(request);

        SampleEntityMapper sampleEntityMapper = new SampleEntityMapper();
        SampleEntityDtoMapper sampleEntityDtoMapper = new SampleEntityDtoMapper();
        SampleEntityDao sampleEntityDao = new SampleEntityDao(httpClient, sampleEntityMapper, sampleEntityDtoMapper);
        SampleEntityRepository sampleEntityRepository = new SampleEntityRepository(sampleEntityDao);

        SampleEntity sampleEntity = sampleEntityRepository.getById(1);

        assertEquals("/model/sample_entity.json", sampleEntity);
    }

    @Test
    public void create() {
        Request request = new Request();
        request.setMethod(HttpMethod.POST);
        request.setUrl("http://jira.com/v1/create");
        request.setBody(Resources.read("/dto/create/sampleentitydto/request.json"));

        Response response = new Response();
        response.setStatusCode(200);
        response.setBody(Resources.read("/dto/create/sampleentitydto/response.json"));

        doReturn(response).when(httpClient).execute(request);

        SampleEntityMapper sampleEntityMapper = new SampleEntityMapper();
        SampleEntityDtoMapper sampleEntityDtoMapper = new SampleEntityDtoMapper();
        SampleEntityDao sampleEntityDao = new SampleEntityDao(httpClient, sampleEntityMapper, sampleEntityDtoMapper);
        SampleEntityRepository sampleEntityRepository = new SampleEntityRepository(sampleEntityDao);

        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName("sample");
        sampleEntityRepository.create(sampleEntity);

        assertEquals("/model/create/sampleentity/expected.json", sampleEntity);
    }
}
