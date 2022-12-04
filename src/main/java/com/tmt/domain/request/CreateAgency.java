package com.tmt.domain.request;

import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class CreateAgency {

    private String code;
    private String name;
    private String address;
    private String picture;
    private Set<String> emails;
    private Set<String> phones;
    private String about;

}