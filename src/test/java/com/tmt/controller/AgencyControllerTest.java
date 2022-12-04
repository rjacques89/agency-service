package com.tmt.controller;

import com.tmt.domain.request.CreateAgency;
import com.tmt.domain.entity.Agency;
import com.tmt.paramResolver.*;
import com.tmt.domain.response.LightAgency;
import com.tmt.service.AgencyService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@DisplayName("An agency:")
@ExtendWith({MockitoExtension.class, AgencyParameterResolver.class, LightAgencyParameterResolver.class})
class AgencyControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AgencyService mockService;
    @InjectMocks
    private AgencyController mockController;
    @Mock
    private CreateAgency mockDto;


    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("should save successfully 👍🏾 ")
    void shouldSaveNewAgencySuccessfully(Agency agency, LightAgency lightAgency) {

        when(mockService.add(any(CreateAgency.class))).thenReturn(lightAgency);
        var underTest = mockController.add(mockDto);

        verify(mockService).add(any(CreateAgency.class));

        assertAll(
                () -> assertThat(underTest.getStatusCode()).isNotNull().isEqualTo(HttpStatus.CREATED),
                () -> assertThat(Objects.requireNonNull(underTest.getBody()).getMainUuId()).isNull(),
                () -> assertThat(underTest.getBody())
                        .usingRecursiveComparison()
                        .ignoringFields("id")
                        .isEqualTo(lightAgency)
        );
    }


    @Test
    public void updateAgency() {

    }

    @Test
    public void deleteAgency() {

    }

    @Nested
    @DisplayName("After finding agency")
    class AgenciesAreFound {
        @Test
        @DisplayName("return one agency")
        public void shouldFindAgencyWhenGivenId() {

        }

        @Test
        @DisplayName("return list of agencies")
        public void getAgencyList() {

        }

        @Test
        @DisplayName("return pages of agencies")
        public void getAll() {
        }
    }

}