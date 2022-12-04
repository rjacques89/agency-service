package com.tmt.service;

import com.tmt.domain.request.CreateAgency;
import com.tmt.domain.entity.Agency;
import com.tmt.domain.response.LightAgency;
import com.tmt.repository.AgencyRepository;
import com.tmt.service.criteria.*;
import com.tmt.utils.CustomBeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository repository;
    private final ProjectionFactory projectionFactory;


    @Override
    public LightAgency add(CreateAgency dto) {
        var created = repository.save(new Agency(dto));
        return projectionFactory.createProjection(LightAgency.class, created);
    }

    @Override
    public LightAgency edit(UUID id, CreateAgency dto) {
        var found = repository.findById(id).orElseThrow(RuntimeException::new);
        CustomBeanUtils.copyPropertiesIgnoreNull(dto, found);
        var updated = repository.save(found);
        return projectionFactory.createProjection(LightAgency.class, updated);
    }


    @Override
    public LightAgency toggle(UUID id) {
        return null;
    }

    @Override
    public void remove(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Was not found");
        }
        repository.deleteById(id);

    }


    @Override
    public LightAgency find(UUID id) {
        if (!repository.existsById(id))
            throw new RuntimeException("Entity Was not found");
        return repository.findByMainUuid(id, LightAgency.class);
    }

    @Override
    public Collection<LightAgency> findByIds(Collection<UUID> ids) {
        return null;
    }


    @Override
    public LightAgency findByCode(String code) {
        return null;
    }

    @Override
    public Page<Agency> search(AgencySearchRequest request) {
        return repository.findAll(AgencySpecs.search(request),
                PageRequest.of(request.getOffset(), request.getLimit(), request.getSort(), request.getSortBy()));
    }


}
