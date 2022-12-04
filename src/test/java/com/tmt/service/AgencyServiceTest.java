package com.tmt.service;

import com.tmt.domain.request.CreateAgency;
import com.tmt.domain.entity.Agency;
import com.tmt.paramResolver.*;
import com.tmt.domain.response.LightAgency;
import com.tmt.repository.AgencyRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.*;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.projection.ProjectionFactory;

import java.util.Optional;
import java.util.UUID;

import static com.tmt.utils.Constants.UPDATED_AGENCY_NAME;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class,
        AgencyParameterResolver.class,
        LightAgencyParameterResolver.class}
)

@Execution(ExecutionMode.CONCURRENT)
class AgencyServiceTest {
    @Mock
    private AgencyRepository mockRepository;
    @Mock
    private ProjectionFactory mockFactory;
    @Mock
    private CreateAgency mockDto;
    @InjectMocks
    private AgencyServiceImpl mockService;


    @Test
    @DisplayName("Should create new agency when dto given")
    void shouldCreateAgencyWhenValidAgencyDtoGiven(Agency agency, LightAgency lightAgency) {

        when(mockRepository.save(any(Agency.class))).thenReturn(agency);
        when(mockFactory.createProjection(LightAgency.class, agency)).thenReturn(lightAgency);
        var underTest = mockService.add(mockDto);

        verify(mockRepository).save(any(Agency.class));
        verify(mockFactory).createProjection(LightAgency.class, agency);

        assertThat(underTest)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(lightAgency);

    }

    @Test
    @DisplayName("Should create agency with random uuid")
    void shouldCreateAgencyWithRandomMainUuid(Agency agency, LightAgency lightAgency) {

        when(mockRepository.save(any(Agency.class))).thenReturn(agency);
        when(mockFactory.createProjection(LightAgency.class, agency)).thenReturn(lightAgency);
        var underTest = mockService.add(mockDto);

        verify(mockRepository).save(any(Agency.class));
        verify(mockFactory).createProjection(LightAgency.class, agency);
        assertThat(underTest.getMainUuId()).isNotNull();

    }

    @Test
    @DisplayName("Should find an existing agency when given id exists")
    void shouldFindExistingEntityWhenGivenIdExists(LightAgency lightAgency) {

        var id = UUID.randomUUID();

        when(mockRepository.existsById(id)).thenReturn(Boolean.TRUE);
        when(mockRepository.findByMainUuid(id, LightAgency.class)).thenReturn(lightAgency);
        var underTest = mockService.find(id);

        verify(mockRepository).existsById(id);
        verify(mockRepository).findByMainUuid(id, LightAgency.class);
        assertThat(underTest)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(lightAgency);

    }

    @Test
    @DisplayName("Should throw a runtime exception when given id does not exists")
    void shouldThrowRuntimeExceptionWhenGivenIdDoesNotExists() {

        var id = UUID.randomUUID();
        when(mockRepository.existsById(id)).thenReturn(Boolean.FALSE);

        assertThrows(RuntimeException.class, () -> mockService.find(id));
        verify(mockRepository).existsById(id);
        verify(mockRepository, never()).save(any(Agency.class));

    }

    @Test
    @DisplayName("Should update an existing agency when id and dto are given")
    void shouldUpdateExistingAgencyWhenIdAndDtoGiven(Agency agency, LightAgency lightAgency) {

        var mainUuid = UUID.randomUUID();
        var updated = Agency.builder().name(UPDATED_AGENCY_NAME).build();

        when(mockRepository.findById(mainUuid)).thenReturn(Optional.of(agency));
        when(mockRepository.save(agency)).thenReturn(updated);
        when(mockFactory.createProjection(LightAgency.class, updated)).thenReturn(lightAgency);
        var underTest = mockService.edit(mainUuid, mockDto);

        ArgumentCaptor<Agency> agencyArgumentCaptor = ArgumentCaptor.forClass(Agency.class);
        verify(mockRepository).findById(mainUuid);
        verify(mockRepository).save(agencyArgumentCaptor.capture());
        verify(mockFactory).createProjection(LightAgency.class, updated);

        assertThat(underTest)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(lightAgency);

    }

    @Test
    @DisplayName("Should update an existing agency when id and dto are given")
    void shouldThrowRuntimeExceptionWhenGivenIdDoNotExist() {

        var mainUuid = UUID.randomUUID();

        var exc = assertThrows(RuntimeException.class, () -> mockService.remove(mainUuid));
        verify(mockRepository).existsById(mainUuid);
        assertThat(exc.getMessage()).isNotEmpty();

    }
}