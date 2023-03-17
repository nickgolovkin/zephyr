package com.golovkin.dataaccess.repositories;

import com.golovkin.dataaccess.dao.SampleEntityDao;
import com.golovkin.model.SampleEntity;

public class SampleEntityRepository {
    private SampleEntityDao dao;

    public SampleEntityRepository(SampleEntityDao dao) {
        this.dao = dao;
    }

    public SampleEntity getById(long id) {
        return dao.getById(id);
    }
}
