package com.golovkin.integration;

import com.golovkin.dataaccess.dao.SampleEntityDao;
import com.golovkin.dataaccess.mappers.SampleEntityMapper;
import com.golovkin.dataaccess.repositories.SampleEntityRepository;
import com.golovkin.httpclient.HttpClient;
import com.golovkin.httpclient.HttpMethod;
import com.golovkin.httpclient.Request;
import com.golovkin.httpclient.Response;
import com.golovkin.model.SampleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        SampleEntityDao sampleEntityDao = new SampleEntityDao(httpClient, sampleEntityMapper);
        SampleEntityRepository sampleEntityRepository = new SampleEntityRepository(sampleEntityDao);

        SampleEntity sampleEntity = sampleEntityRepository.getById(1);

        assertEquals("/model/sample_entity.json", sampleEntity);
    }
}