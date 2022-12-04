package com.tmt.service;

import com.tmt.domain.entity.ID;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface AbstractBaseService<T extends ID, P, K extends Serializable> {
    public abstract P save(T entity);

    public abstract Collection<P> findAll();

    public abstract Optional<P> findById(K entityId);

    public abstract P update(T entity);

    public abstract P updateById(T entity, K entityId);

    public abstract void delete(T entity);

    public abstract void deleteById(K entityId);

    public abstract void toggleStatusById(K entityId);

}