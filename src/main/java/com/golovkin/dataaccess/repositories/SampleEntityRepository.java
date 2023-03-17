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

    public void create(SampleEntity entity) {
        dao.create(entity);
    }

    public void update(SampleEntity entity) {
        dao.update(entity);
    }

    public void delete(SampleEntity entity) {
        dao.delete(entity);
    }
}
