package com.tmt.service;

import com.tmt.domain.request.CreateAgency;
import com.tmt.domain.entity.Agency;
import com.tmt.service.criteria.AgencySearchRequest;
import com.tmt.domain.response.LightAgency;
import org.springframework.data.domain.*;

import java.util.Collection;
import java.util.UUID;

public interface AgencyService {

    /**
     * @param dto :
     * @return LightAgency
     */
    LightAgency add(CreateAgency dto);

    /**
     * @param id  :
     * @param dto :
     * @return LightAgency
     */
    LightAgency edit(UUID id, CreateAgency dto);

    /**
     * @param id :
     * @return LightAgency
     */
    LightAgency toggle(UUID id);

    /**
     * @param id :
     */
    void remove(UUID id);

    /**
     * @param id :
     * @return LightAgency
     */
    LightAgency find(UUID id);


    /**
     * @param ids :
     * @return LightAgency
     */
    Collection<LightAgency> findByIds(Collection<UUID> ids);

    /**
     * @param code :
     * @return LightAgency
     */
    LightAgency findByCode(String code);

    /**:
     * @param params :
     * @return Page<LightAgency>
     */
    Page<Agency> search(AgencySearchRequest params);
}
