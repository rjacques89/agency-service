package com.tmt.repository;

import com.tmt.domain.response.LightAgency;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class AgencyRepositoryTest {

    @Autowired
    private AgencyRepository agencyRepository;

    @Test
    void findByCode() {
        //GIVEN
        var code = "";
        //WHEN
        var found =agencyRepository.findByCode(code, LightAgency.class);
        //THEN
        assertThat(found).isNotNull();
    }
}