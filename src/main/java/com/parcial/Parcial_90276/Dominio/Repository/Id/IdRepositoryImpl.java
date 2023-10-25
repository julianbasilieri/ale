package com.parcial.Parcial_90276.Dominio.Repository.Id;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IdRepositoryImpl implements IdRepository{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public int siguienteId(String tableName) {
        Integer resultado = (Integer) entityManager.createNativeQuery(format("SELECT count(*) FROM %s;", tableName)).getSingleResult();
        return resultado + 1;
    }
}

