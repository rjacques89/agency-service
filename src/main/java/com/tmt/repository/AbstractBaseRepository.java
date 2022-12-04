package com.tmt.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractBaseRepository<T extends com.tmt.domain.entity.ID, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> {

}