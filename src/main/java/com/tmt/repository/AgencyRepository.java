package com.tmt.repository;

import com.tmt.domain.entity.Agency;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;


@Repository
public interface AgencyRepository extends PagingAndSortingRepository<Agency, UUID>, JpaSpecificationExecutor<Agency> {

    /**
     * @param id :
     * @param projectionClass :
     * @param <T> :
     * @return LightMember
     */
    <T> T findByMainUuid(UUID id, Class<T> projectionClass);

    /**
     * @param code :
     * @param projectionClass :
     * @param <T> :
     * @return LightMember
     */
    <T> T findByCode(String code, Class<T> projectionClass);

    /**
     * @param ids :
     * @param projectionClass :
     * @param <T> :
     * @return Collection<LightMember>
     */
    <T> Collection<T> findAllByMainUuidIn(Collection<UUID> ids, Class<T> projectionClass);


}
