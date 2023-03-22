package com.golovkin.dataaccess.validators;

import com.golovkin.model.SampleEntity;

public class SampleEntityValidator {
    public void validate(SampleEntity entity) {
        // TODO придумать механизм валидации по аналогии с Mapper
        // TODO в ValidationUtils общие проверки запихнуть, типо notNull и т.д.
        // TODO в механизме будет кидаться исключение сразу со всеми ошибками перечисленными в виде сообщений
        // TODO будет 2 метода - один кидает проверяет и кидает исключение, другой просто выдает список непройденных валидаций (чтобы можно было использовать валидаторы в составных объектах, хотя не, этим же их DAO должно заниматься)
        if (entity.getName().length() <= 1) {
            throw new
        }
    }
}
