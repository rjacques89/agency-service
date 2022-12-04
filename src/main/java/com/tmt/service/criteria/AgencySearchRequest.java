package com.tmt.service.criteria;

import lombok.*;
import org.springframework.data.domain.Sort;

import java.time.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class AgencySearchRequest {

    private static final String SORT_BY_FIELD = "edited";

    private String code;
    private String name;
    private LocalDateTime from = LocalDate.now().atTime(LocalTime.MIN);
    private LocalDateTime to = LocalDate.now().atTime(LocalTime.MAX);
    private Integer offset = 0;
    private Integer limit = 10;
    private String sortBy = SORT_BY_FIELD ;
    private Sort.Direction sort = Sort.Direction.DESC;


}
